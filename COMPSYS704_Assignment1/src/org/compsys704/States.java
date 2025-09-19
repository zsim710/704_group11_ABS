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
	

	// rotary table positions
	public static volatile boolean rotation = false;
	public static volatile boolean prevRotation = false; 
	public static volatile boolean BOTTLE_AT_POS_1R = false; 
	public static volatile boolean BOTTLE_AT_POS_2R = false; 
	public static volatile boolean BOTTLE_AT_POS_3R = false; 
	public static volatile boolean BOTTLE_AT_POS_4R = false; 
	public static volatile boolean BOTTLE_AT_POS_5R = false; 
	public static volatile boolean FAULT_AT_POS1 = false; 
	 
	// conveyor
	public static volatile boolean BOTTLE_AT_LOAD = false;
	public static volatile boolean BOTTLE_AT_POS_1 = false;
	public static volatile boolean BOTTLE_LEFT_POS_5 = false;
//	public static volatile boolean BOTTLE_AT_DONE = false;
//	public static volatile boolean BOTTLE_AT_EMPTY = false;
	
	// filler
    public static volatile boolean BOTTLE_AT_POS2 = false;
    public static volatile boolean ALL_FILLERS_COMPLETE = false;
    public static volatile boolean FILLER1_VALVE_CANISTER = false;
    public static volatile boolean FILLER2_VALVE_CANISTER = false;
    public static volatile boolean FILLER1_VALVE_INLET = false;
    public static volatile boolean FILLER2_VALVE_INLET = false;
    public static volatile boolean FILLER_IDLE = true;
    
     
    // Capper
    public static volatile boolean BOTTLE_AT_POS4 = false;
    public static volatile boolean CAPPER_GRIPPER_CLAMP = false;
    public static volatile boolean CAPPER_DONE = false;
    public static volatile boolean CAPPER_IDLE = true;
	
	
}

