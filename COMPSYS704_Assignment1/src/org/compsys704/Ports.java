package org.compsys704;

public class Ports {
	public static final String REQUEST_SIGNAL = "ControllerCD.request";
	public static final String REFILL_SIGNAL = "PlantCD.refill";
	public static final String ENABLE_SIGNAL = "PlantCD.enable";
	public static final int PORT_LOADER_PLANT = 10001;
	public static final int PORT_LOADER_CONTROLLER = 10000;
	public static final int PORT_LOADER_VIZ = 20001;
	public static final int PORT_BOTTLELOADER_VIZ = 20000;
	
	// Manual 
	public static final String SIGNAL_PUSHER_EXTEND   = "ControllerCD.pusherExtendM";
//	public static final String SIGNAL_VACOFF          = "ControllerCD.vacOffM";
	public static final String SIGNAL_VACON           = "ControllerCD.vacOnM";
	public static final String SIGNAL_ARM_SOURCE      = "ControllerCD.armSourceM";
	public static final String SIGNAL_ARM_DEST        = "ControllerCD.armDestM";
	public static final String SIGNAL_Mode            = "ControllerCD.mode";

	// POS System signals - must match SystemJ XML signal names exactly
	public static final int PORT_POS_CONTROLLER = 10003;
	public static final String SIGNAL_BATCH_NAME = "batchName";
	public static final int MainControllerCD_port = 10200;
	public static final String SIGNAL_BOTTLE_QUANTITY = "MainControllerCD.BottleQuantity";
	public static final String SIGNAL_LIQUID_AMOUNT_1 = "MainControllerCD.LiquidAmount1";
	public static final String SIGNAL_LIQUID_AMOUNT_2 = "MainControllerCD.LiquidAmount2";
	//public static final String SIGNAL_LIQUID_MIXTURE = "MainControllerCD.liquidMixture";

	


}
