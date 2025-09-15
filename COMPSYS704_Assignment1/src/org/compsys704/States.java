package org.compsys704;

public class States {
	
	public static volatile boolean ARM_AT_DEST = true;
	public static volatile boolean ARM_AT_SOURCE = !ARM_AT_DEST;
	public static volatile boolean PUSHER_RETRACTED = true;
	public static volatile boolean PUSHER_EXTENDED = !PUSHER_RETRACTED;
	public static volatile boolean GRIPPED = false;
	public static volatile boolean MAG_EMPTY = false;
	public static volatile boolean CAP_READY = false;
	
	// store all addresses, --> add for bottle loader
	public static volatile boolean POSA = true;
	public static volatile boolean POSB = false;
	public static volatile boolean POSC = false;
	public static volatile boolean POSD = false;
	public static volatile boolean GRIPDAT = false;
	
	public static volatile boolean WS1 = true;
	

	// bottling station positions
	public static volatile boolean rotation = false;
	public static volatile boolean prevRotation = false; 
	
	// conveyor
	public static volatile boolean BOTTLE_AT_LOAD = false;
	public static volatile boolean BOTTLE_AT_POS_1 = false;
	public static volatile boolean BOTTLE_LEFT_POS_5 = false;
//	public static volatile boolean BOTTLE_AT_DONE = false;
//	public static volatile boolean BOTTLE_AT_EMPTY = false;

}
 