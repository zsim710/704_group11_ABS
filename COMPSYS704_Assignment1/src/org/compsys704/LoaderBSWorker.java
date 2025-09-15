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
		default: 
			System.err.println("Wrong sig name : "+signame);
			System.exit(1);
		}
	}

	static final List<String> signames = Arrays.asList("rotation");

	@Override
	public boolean hasSignal(String sn) {
		return signames.contains(sn);
	} 

}
