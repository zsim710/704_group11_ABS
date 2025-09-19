package org.compsys704.dontNeedRightNow;

import java.util.Arrays;
import java.util.List;

import org.compsys704.States;
import org.compsys704.Worker;

public class LoaderVizWorker extends Worker{

	@Override
	public void setSignal(boolean status) {
//		System.out.println(signame+"  "+status);
//		System.out.println(signame+"  "+status);
 //System.out.println("BottleLoaderVizWorker received: " + signame + " = " + status); // Add this debug line

		switch(signame){
		case "POSA":
			States.POSA = status;
			States.POSB = false; // only one position can be true at a time
			States.POSC = false;
			States.POSD = false;

			break;
		case "POSB":
			States.POSB = status;
			States.POSA = false;
			States.POSC = false;
			States.POSD = false;
			break;
		case "POSC":
			States.POSC = status;
			States.POSA = false;
			States.POSB = false;
			States.POSD = false;
			break;
		case "POSD":
			States.POSD = status;
			States.POSA = false;
			States.POSB = false;
			States.POSC = false;
			break;
		case "GRIPDAT":
			States.GRIPDAT = status;
			System.out.println("In GRIPPY");
			break;
		default: 
			System.err.println("Wrong sig name : "+signame);
			System.exit(1);
		}
	}


	static final List<String> signames = Arrays.asList("POSA","POSB","POSC","POSD","GRIPDAT");

	@Override
	public boolean hasSignal(String sn) {
		return signames.contains(sn);
	} 

}
