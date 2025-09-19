package org.compsys704;

import java.util.Arrays;
import java.util.List;

import org.compsys704.States;

public class LoaderFillerWorker extends Worker{

	@Override // TO CHANGE
	public void setSignal(boolean status) {
		System.out.println(signame+"  "+status);
		switch(signame) {
		case "fillersCompleteGUI":
            States.ALL_FILLERS_COMPLETE = true;

            States.FILLER1_VALVE_CANISTER = false;
			States.FILLER1_VALVE_INLET = false; 
            States.FILLER2_VALVE_INLET = false;
            States.BOTTLE_AT_POS2 = false;
            States.FILLER_IDLE = false;
			States.FILLER2_VALVE_CANISTER = false;;
			break;	
		case "filler1OnGUI":
            States.FILLER1_VALVE_CANISTER = true;

			States.FILLER1_VALVE_INLET = false;
            States.FILLER2_VALVE_INLET = false;
            States.BOTTLE_AT_POS2 = false;
			States.ALL_FILLERS_COMPLETE = false;
			States.FILLER_IDLE = false;
			States.FILLER2_VALVE_CANISTER = false;;
			break;
		case "filler2OnGUI":  
			States.FILLER2_VALVE_CANISTER = true;

			States.FILLER1_VALVE_INLET = false;
            States.FILLER2_VALVE_INLET = false;
            States.BOTTLE_AT_POS2 = false;
			States.ALL_FILLERS_COMPLETE = false;
			States.FILLER1_VALVE_CANISTER = false;;
			break;
		case "filler1InletGUI":
			States.FILLER1_VALVE_INLET = true;

            States.FILLER2_VALVE_INLET = false;
            States.BOTTLE_AT_POS2 = false;
			States.ALL_FILLERS_COMPLETE = false;
			States.FILLER1_VALVE_CANISTER = false;
			States.FILLER_IDLE = false;
			States.FILLER2_VALVE_CANISTER = false;;
			break;
		case "filler2InletGUI":
			States.FILLER2_VALVE_INLET = true;

            States.BOTTLE_AT_POS2 = false;
			States.ALL_FILLERS_COMPLETE = false;
			States.FILLER1_VALVE_CANISTER = false;
			States.FILLER2_VALVE_CANISTER = false;
			States.FILLER_IDLE = false;
			States.FILLER1_VALVE_INLET = false;;
			break;
		case "fillerIdleGUI":
			States.FILLER_IDLE = true;

            States.BOTTLE_AT_POS2 = false;
			States.ALL_FILLERS_COMPLETE = false;
			States.FILLER1_VALVE_CANISTER = false;
			States.FILLER2_VALVE_CANISTER = false;
			States.FILLER1_VALVE_INLET = false;
			States.FILLER2_VALVE_INLET = false;;
			break;
        case "bottleAtPos2GUI":
            States.BOTTLE_AT_POS2 = true;

			States.ALL_FILLERS_COMPLETE = false;
			States.FILLER1_VALVE_CANISTER = false;
			States.FILLER2_VALVE_CANISTER = false;
			States.FILLER1_VALVE_INLET = false;
			States.FILLER_IDLE = false;
			States.FILLER2_VALVE_INLET = false;;
			break;
		default: 
				System.err.println("Wrong sig name : "+signame);
				System.exit(1);
		}
	}

	static final List<String> signames = Arrays.asList("fillersCompleteGUI","filler1OnGUI", "filler2OnGUI", "filler1InletGUI", "filler2InletGUI", "fillerIdleGUI", "bottleAtPos2GUI");

	@Override
	public boolean hasSignal(String sn) {
		return signames.contains(sn);
	} 

}