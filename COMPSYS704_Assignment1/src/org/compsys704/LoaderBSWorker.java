package org.compsys704;

import java.util.Arrays;
import java.util.List;

public class LoaderBSWorker extends Worker{

	@Override
	public void setSignal(boolean status) {
		System.out.println(signame+"  "+status);
		switch(signame){
		case "rotation": 
            States.prevRotation = States.rotation; // to ensure animation works correctly when toggling
			States.rotation = status;
			 
			System.out.println("rotation received by UI yay");
			break;
		case "bottleAtPos1RGUI":
			States.BOTTLE_AT_POS_1R = true;
			States.FAULT_AT_POS1 = false;
			
		case "bottleAtPos2GUI":
			States.BOTTLE_AT_POS_2R = true;
			States.FAULT_AT_POS1 = false;

//			States.BOTTLE_AT_POS_3R = false;
//			States.BOTTLE_AT_POS_4R = false;
//			States.BOTTLE_AT_POS_5R = false;
			break;
		case "bottleAtPos3GUI":
			States.BOTTLE_AT_POS_3R = true;
			States.FAULT_AT_POS1 = false;

//			States.BOTTLE_AT_POS_2R = false;
//			States.BOTTLE_AT_POS_4R = false;
//			States.BOTTLE_AT_POS_5R = false;
			break;
		case "bottleAtPos4GUI":
			States.BOTTLE_AT_POS_4R = true;
			States.FAULT_AT_POS1 = false;

//			States.BOTTLE_AT_POS_5R = false;
//			States.BOTTLE_AT_POS_2R = false;
//			States.BOTTLE_AT_POS_3R = false;
			break;
		case "bottleAtPos5GUI":
			States.BOTTLE_AT_POS_5R = true;
			States.FAULT_AT_POS1 = false;

//			States.BOTTLE_AT_POS_4R = false;
//			States.BOTTLE_AT_POS_2R = false;
//			States.BOTTLE_AT_POS_3R = false;
			break;
		case "capOnBottleAtPos1GUI":
//			System.out.println("fault detected at pos1 of the rotary");

			States.FAULT_AT_POS1 = true;
			States.BOTTLE_AT_POS_1R = false;
			break;
		default: 
			System.err.println("Wrong sig name : "+signame);
			System.exit(1);
		}
	} 

	static final List<String> signames = Arrays.asList("rotation", "bottleAtPos1RGUI", "bottleAtPos2GUI", "bottleAtPos3GUI", "bottleAtPos4GUI", "bottleAtPos5GUI", "capOnBottleAtPos1GUI");

	@Override
	public boolean hasSignal(String sn) {
		return signames.contains(sn);
	} 

}
