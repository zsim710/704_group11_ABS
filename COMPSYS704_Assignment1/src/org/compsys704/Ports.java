package org.compsys704;

public class Ports {
	public static final String REQUEST_SIGNAL = "LidLoaderControllerCD.request";
	public static final String REFILL_SIGNAL = "LidLoaderPlantCD.refill";
	public static final String ENABLE_SIGNAL = "LidLoaderPlantCD.enable";
	public static final int PORT_LOADER_PLANT = 10001;
	public static final int PORT_LOADER_CONTROLLER = 10000;
	public static final int PORT_LOADER_VIZ = 20001;
	public static final int PORT_BOTTLELOADER_VIZ = 20000;
	public static final int PORT_ROTARY_VIZ = 10011;
	public static final int PORT_CONVEYOR_VIZ = 10015;
	public static final int PORT_FILLER_VIZ = 10016;
	public static final int PORT_CAPPER_VIZ = 10017;
	
	
	// Manual 
	public static final String SIGNAL_PUSHER_EXTEND   = "ControllerCD.pusherExtendM";
//	public static final String SIGNAL_VACOFF          = "ControllerCD.vacOffM";
	public static final String SIGNAL_VACON           = "ControllerCD.vacOnM";
	public static final String SIGNAL_ARM_SOURCE      = "ControllerCD.armSourceM";
	public static final String SIGNAL_ARM_DEST        = "ControllerCD.armDestM";
	public static final String SIGNAL_Mode            = "ControllerCD.mode";

	
	// conveyor
//	public static final int PORT_Conveyor_PLANT = 40001;
//	public static final String Conveyor_motConveyorOnOff = "ConveyorPlantCD.motConveyorOnOff";
//	public static final int PORT_Conveyor_PLANT = 40001;
//	public static final String Conveyor_Stop = "ConveyorPlantCD.ConvStop";
	
	// will eventually need for rotary to simulate button for fault to RC/RP
	public static final String SIMULATE_FAULT = "RotaryControllerCD.capOnBottleAtPos1";
	public static final int PORT_ROTARY_CONTROLLER = 10003;
	public static final String ROTARY_ENABLE = "RotaryControllerCD.enable";
//	public static final String BOTTLE_AT_POS1 = "RotaryControllerCD.capOnBottleAtPos1";

	// capper port signals
	public static final String CAPPER_BOTTLE_PRESENT = "CapperControllerCD.bottleAtPos4";
	public static final int PORT_CAPPER_CONTROLLER = 31000;
	


}
