package org.compsys704;

import java.util.Arrays;
import java.util.List;

public class LoaderConveyorWorker extends Worker{

	@Override
	public void setSignal(boolean status) {
		System.out.println(signame+"  "+status);
		switch(signame) {
		case "bottleAtLoadGUI":
			States.BOTTLE_AT_LOAD = true;
			
			States.BOTTLE_AT_POS_1 = false;
			States.BOTTLE_LEFT_POS_5 = false;;

			break;	
		case "bottleAtPos1ConveyorGUI":
			States.BOTTLE_AT_POS_1 = true;
			
			States.BOTTLE_LEFT_POS_5 = false;
			States.BOTTLE_AT_LOAD = false;;

			break;
		case "bottleLeftPos5ConveyorGUI": 
			States.BOTTLE_LEFT_POS_5 = true;
			
			States.BOTTLE_AT_POS_1 = false;
			States.BOTTLE_AT_LOAD = false;;
			
			break;
		
		default: 
				System.err.println("Wrong sig name : "+signame);
				System.exit(1);
		}
	}

	static final List<String> signames = Arrays.asList("bottleAtLoadGUI", "bottleAtPos1ConveyorGUI","bottleLeftPos5ConveyorGUI");

	@Override
	public boolean hasSignal(String sn) {
		return signames.contains(sn);
	} 

}