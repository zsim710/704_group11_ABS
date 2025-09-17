package org.compsys704;

import java.util.Arrays;
import java.util.List;

import org.compsys704.States;

public class LoaderCapperWorker extends Worker{

	@Override 
	public void setSignal(boolean status) {
		System.out.println(signame+"  "+status);
		switch(signame) {
		case "capperIdleGUI":
            States.CAPPER_IDLE = true;
            States.BOTTLE_AT_POS4 = false;
			States.CAPPER_GRIPPER_CLAMP= false;
            States.CAPPER_DONE = false;;
			break;	
		case "bottleAtPos4GUI":
            States.CAPPER_IDLE = false;
            States.BOTTLE_AT_POS4 = true;
			States.CAPPER_GRIPPER_CLAMP= false;
            States.CAPPER_DONE = false;;
			break;
		case "gripperClampGUI":  
            States.CAPPER_IDLE = false;
            States.BOTTLE_AT_POS4 = false;
			States.CAPPER_GRIPPER_CLAMP= true;
            States.CAPPER_DONE = false;;
			break;
		case "capperDoneGUI": 
            States.CAPPER_IDLE = false;
            States.BOTTLE_AT_POS4 = false;
			States.CAPPER_GRIPPER_CLAMP= false;
            States.CAPPER_DONE = true;;
			break;
		default: 
				System.err.println("Wrong sig name : "+signame);
				System.exit(1);
		}
	}
 
	static final List<String> signames = Arrays.asList("capperIdleGUI", "bottleAtPos4GUI","gripperClampGUI", "capperDoneGUI");

	@Override
	public boolean hasSignal(String sn) {
		return signames.contains(sn);
	} 

}
