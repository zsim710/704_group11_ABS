import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class FillerController extends ClockDomain{
  public FillerController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal bottleAtPos2 = new Signal("bottleAtPos2", Signal.INPUT);
  public Signal dosUnitEvac = new Signal("dosUnitEvac", Signal.INPUT);
  public Signal dosUnitFilled = new Signal("dosUnitFilled", Signal.INPUT);
  public Signal LiquidAmount1FC = new Signal("LiquidAmount1FC", Signal.INPUT);
  public Signal LiquidAmount2FC = new Signal("LiquidAmount2FC", Signal.INPUT);
  public Signal fillerReady = new Signal("fillerReady", Signal.OUTPUT);
  public Signal valveInjectorOn = new Signal("valveInjectorOn", Signal.OUTPUT);
  public Signal valveInletOn = new Signal("valveInletOn", Signal.OUTPUT);
  public Signal dosUnitValveRetract = new Signal("dosUnitValveRetract", Signal.OUTPUT);
  public Signal dosUnitValveExtend = new Signal("dosUnitValveExtend", Signal.OUTPUT);
  public Signal filler2Complete = new Signal("filler2Complete", Signal.OUTPUT);
  public Signal start = new Signal("start", Signal.OUTPUT);
  private Signal filler2CompleteLocal_1;
  private Signal filler2_1;
  private Signal filler1_1;
  private Signal currentFiller_1;
  private int S4959 = 1;
  private int S4877 = 1;
  private int S2675 = 1;
  private int S2244 = 1;
  private int S2252 = 1;
  private int S2260 = 1;
  private int S2303 = 1;
  private int S2311 = 1;
  private int S4957 = 1;
  private int S4890 = 1;
  
  private int[] ends = new int[8];
  private int[] tdone = new int[8];
  
  public void thread5001(int [] tdone, int [] ends){
        switch(S4957){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        switch(S4890){
          case 0 : 
            S4890=0;
            S4890=1;
            if((Integer)(currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) == 2){//sysj\FillerController.sysj line: 75, column: 8
              filler2_1.setPresent();//sysj\FillerController.sysj line: 76, column: 5
              currsigs.addElement(filler2_1);
              S4890=0;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              if((Integer)(currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) == 1){//sysj\FillerController.sysj line: 77, column: 16
                filler1_1.setPresent();//sysj\FillerController.sysj line: 78, column: 6
                currsigs.addElement(filler1_1);
                S4890=0;
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
              else {
                if((Integer)(currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) == 3){//sysj\FillerController.sysj line: 79, column: 15
                  filler2Complete.setPresent();//sysj\FillerController.sysj line: 80, column: 6
                  currsigs.addElement(filler2Complete);
                  filler2CompleteLocal_1.setPresent();//sysj\FillerController.sysj line: 81, column: 6
                  currsigs.addElement(filler2CompleteLocal_1);
                  fillerReady.setPresent();//sysj\FillerController.sysj line: 82, column: 6
                  currsigs.addElement(fillerReady);
                  currentFiller_1.setPresent();//sysj\FillerController.sysj line: 83, column: 6
                  currsigs.addElement(currentFiller_1);
                  currentFiller_1.setValue(1);//sysj\FillerController.sysj line: 83, column: 6
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  S4890=0;
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
              }
            }
            break;
          
          case 1 : 
            if(!bottleAtPos2.getprestatus()){//sysj\FillerController.sysj line: 84, column: 12
              S4890=0;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread4999(int [] tdone, int [] ends){
        S2260=1;
    System.out.println("brings pressure canister up");//sysj\FillerController.sysj line: 45, column: 7
    dosUnitValveRetract.setPresent();//sysj\FillerController.sysj line: 46, column: 7
    currsigs.addElement(dosUnitValveRetract);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread4998(int [] tdone, int [] ends){
        S2252=1;
    System.out.println("toggles valve injector");//sysj\FillerController.sysj line: 40, column: 7
    valveInjectorOn.setPresent();//sysj\FillerController.sysj line: 41, column: 7
    currsigs.addElement(valveInjectorOn);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread4996(int [] tdone, int [] ends){
        S2311=1;
    System.out.println("brings pressire canister down");//sysj\FillerController.sysj line: 57, column: 7
    dosUnitValveExtend.setPresent();//sysj\FillerController.sysj line: 58, column: 7
    currsigs.addElement(dosUnitValveExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread4995(int [] tdone, int [] ends){
        S2303=1;
    System.out.println("toggles valve inlet");//sysj\FillerController.sysj line: 52, column: 7
    valveInletOn.setPresent();//sysj\FillerController.sysj line: 53, column: 7
    currsigs.addElement(valveInletOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread4993(int [] tdone, int [] ends){
        S2260=1;
    System.out.println("brings pressure canister up");//sysj\FillerController.sysj line: 45, column: 7
    dosUnitValveRetract.setPresent();//sysj\FillerController.sysj line: 46, column: 7
    currsigs.addElement(dosUnitValveRetract);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread4992(int [] tdone, int [] ends){
        S2252=1;
    System.out.println("toggles valve injector");//sysj\FillerController.sysj line: 40, column: 7
    valveInjectorOn.setPresent();//sysj\FillerController.sysj line: 41, column: 7
    currsigs.addElement(valveInjectorOn);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread4990(int [] tdone, int [] ends){
        S2311=1;
    System.out.println("brings pressire canister down");//sysj\FillerController.sysj line: 57, column: 7
    dosUnitValveExtend.setPresent();//sysj\FillerController.sysj line: 58, column: 7
    currsigs.addElement(dosUnitValveExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread4989(int [] tdone, int [] ends){
        S2303=1;
    System.out.println("toggles valve inlet");//sysj\FillerController.sysj line: 52, column: 7
    valveInletOn.setPresent();//sysj\FillerController.sysj line: 53, column: 7
    currsigs.addElement(valveInletOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread4987(int [] tdone, int [] ends){
        switch(S2311){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        dosUnitValveExtend.setPresent();//sysj\FillerController.sysj line: 58, column: 7
        currsigs.addElement(dosUnitValveExtend);
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
        break;
      
    }
  }

  public void thread4986(int [] tdone, int [] ends){
        switch(S2303){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        valveInletOn.setPresent();//sysj\FillerController.sysj line: 53, column: 7
        currsigs.addElement(valveInletOn);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread4984(int [] tdone, int [] ends){
        S2311=1;
    System.out.println("brings pressire canister down");//sysj\FillerController.sysj line: 57, column: 7
    dosUnitValveExtend.setPresent();//sysj\FillerController.sysj line: 58, column: 7
    currsigs.addElement(dosUnitValveExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread4983(int [] tdone, int [] ends){
        S2303=1;
    System.out.println("toggles valve inlet");//sysj\FillerController.sysj line: 52, column: 7
    valveInletOn.setPresent();//sysj\FillerController.sysj line: 53, column: 7
    currsigs.addElement(valveInletOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread4981(int [] tdone, int [] ends){
        switch(S2260){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        dosUnitValveRetract.setPresent();//sysj\FillerController.sysj line: 46, column: 7
        currsigs.addElement(dosUnitValveRetract);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread4980(int [] tdone, int [] ends){
        switch(S2252){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        valveInjectorOn.setPresent();//sysj\FillerController.sysj line: 41, column: 7
        currsigs.addElement(valveInjectorOn);
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
        break;
      
    }
  }

  public void thread4978(int [] tdone, int [] ends){
        S2311=1;
    System.out.println("brings pressire canister down");//sysj\FillerController.sysj line: 57, column: 7
    dosUnitValveExtend.setPresent();//sysj\FillerController.sysj line: 58, column: 7
    currsigs.addElement(dosUnitValveExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread4977(int [] tdone, int [] ends){
        S2303=1;
    System.out.println("toggles valve inlet");//sysj\FillerController.sysj line: 52, column: 7
    valveInletOn.setPresent();//sysj\FillerController.sysj line: 53, column: 7
    currsigs.addElement(valveInletOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread4975(int [] tdone, int [] ends){
        S2260=1;
    System.out.println("brings pressure canister up");//sysj\FillerController.sysj line: 45, column: 7
    dosUnitValveRetract.setPresent();//sysj\FillerController.sysj line: 46, column: 7
    currsigs.addElement(dosUnitValveRetract);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread4974(int [] tdone, int [] ends){
        S2252=1;
    System.out.println("toggles valve injector");//sysj\FillerController.sysj line: 40, column: 7
    valveInjectorOn.setPresent();//sysj\FillerController.sysj line: 41, column: 7
    currsigs.addElement(valveInjectorOn);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread4972(int [] tdone, int [] ends){
        S2311=1;
    System.out.println("brings pressire canister down");//sysj\FillerController.sysj line: 57, column: 7
    dosUnitValveExtend.setPresent();//sysj\FillerController.sysj line: 58, column: 7
    currsigs.addElement(dosUnitValveExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread4971(int [] tdone, int [] ends){
        S2303=1;
    System.out.println("toggles valve inlet");//sysj\FillerController.sysj line: 52, column: 7
    valveInletOn.setPresent();//sysj\FillerController.sysj line: 53, column: 7
    currsigs.addElement(valveInletOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread4970(int [] tdone, int [] ends){
        switch(S4877){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S2675){
          case 0 : 
            if(filler2CompleteLocal_1.getprestatus()){//sysj\FillerController.sysj line: 15, column: 20
              S2675=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              switch(S2244){
                case 0 : 
                  if(bottleAtPos2.getprestatus()){//sysj\FillerController.sysj line: 18, column: 22
                    System.out.println("no longer emitting filler ready");//sysj\FillerController.sysj line: 22, column: 6
                    System.out.println("awaiting starting start signal");//sysj\FillerController.sysj line: 24, column: 6
                    start.setPresent();//sysj\FillerController.sysj line: 26, column: 6
                    currsigs.addElement(start);
                    if((Integer)(currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) == 1) {//sysj\FillerController.sysj line: 28, column: 40
                      System.out.println("filler 1 start, filled " + ((Integer)(LiquidAmount1FC.getpreval() == null ? null : ((Integer)LiquidAmount1FC.getpreval()))) + "%");//sysj\FillerController.sysj line: 29, column: 7
                    }
                    else {//sysj\FillerController.sysj line: 28, column: 6
                      if((Integer)(currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) == 2) {//sysj\FillerController.sysj line: 31, column: 45
                        System.out.println("filler 2 start, filled " + ((Integer)(LiquidAmount2FC.getpreval() == null ? null : ((Integer)LiquidAmount2FC.getpreval()))) + "%");//sysj\FillerController.sysj line: 32, column: 7
                      }
                      else {//sysj\FillerController.sysj line: 34, column: 11
                        System.out.println("filler 1 start, filled " + ((Integer)(LiquidAmount1FC.getpreval() == null ? null : ((Integer)LiquidAmount1FC.getpreval()))) + "%");//sysj\FillerController.sysj line: 35, column: 7
                      }
                    }
                    S2244=1;
                    if(dosUnitFilled.getprestatus()){//sysj\FillerController.sysj line: 38, column: 22
                      S2244=2;
                      if(dosUnitEvac.getprestatus()){//sysj\FillerController.sysj line: 50, column: 22
                        System.out.println("filler is done");//sysj\FillerController.sysj line: 62, column: 6
                        currentFiller_1.setPresent();//sysj\FillerController.sysj line: 64, column: 6
                        currsigs.addElement(currentFiller_1);
                        currentFiller_1.setValue((currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) + 1);//sysj\FillerController.sysj line: 64, column: 6
                        S2244=3;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        thread4971(tdone,ends);
                        thread4972(tdone,ends);
                        int biggest4973 = 0;
                        if(ends[5]>=biggest4973){
                          biggest4973=ends[5];
                        }
                        if(ends[6]>=biggest4973){
                          biggest4973=ends[6];
                        }
                        if(biggest4973 == 1){
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                      }
                    }
                    else {
                      thread4974(tdone,ends);
                      thread4975(tdone,ends);
                      int biggest4976 = 0;
                      if(ends[3]>=biggest4976){
                        biggest4976=ends[3];
                      }
                      if(ends[4]>=biggest4976){
                        biggest4976=ends[4];
                      }
                      if(biggest4976 == 1){
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                  }
                  else {
                    fillerReady.setPresent();//sysj\FillerController.sysj line: 20, column: 7
                    currsigs.addElement(fillerReady);
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  break;
                
                case 1 : 
                  if(dosUnitFilled.getprestatus()){//sysj\FillerController.sysj line: 38, column: 22
                    S2244=2;
                    if(dosUnitEvac.getprestatus()){//sysj\FillerController.sysj line: 50, column: 22
                      System.out.println("filler is done");//sysj\FillerController.sysj line: 62, column: 6
                      currentFiller_1.setPresent();//sysj\FillerController.sysj line: 64, column: 6
                      currsigs.addElement(currentFiller_1);
                      currentFiller_1.setValue((currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) + 1);//sysj\FillerController.sysj line: 64, column: 6
                      S2244=3;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      thread4977(tdone,ends);
                      thread4978(tdone,ends);
                      int biggest4979 = 0;
                      if(ends[5]>=biggest4979){
                        biggest4979=ends[5];
                      }
                      if(ends[6]>=biggest4979){
                        biggest4979=ends[6];
                      }
                      if(biggest4979 == 1){
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                  }
                  else {
                    thread4980(tdone,ends);
                    thread4981(tdone,ends);
                    int biggest4982 = 0;
                    if(ends[3]>=biggest4982){
                      biggest4982=ends[3];
                    }
                    if(ends[4]>=biggest4982){
                      biggest4982=ends[4];
                    }
                    if(biggest4982 == 1){
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    //FINXME code
                    if(biggest4982 == 0){
                      S2244=2;
                      if(dosUnitEvac.getprestatus()){//sysj\FillerController.sysj line: 50, column: 22
                        System.out.println("filler is done");//sysj\FillerController.sysj line: 62, column: 6
                        currentFiller_1.setPresent();//sysj\FillerController.sysj line: 64, column: 6
                        currsigs.addElement(currentFiller_1);
                        currentFiller_1.setValue((currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) + 1);//sysj\FillerController.sysj line: 64, column: 6
                        S2244=3;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        thread4983(tdone,ends);
                        thread4984(tdone,ends);
                        int biggest4985 = 0;
                        if(ends[5]>=biggest4985){
                          biggest4985=ends[5];
                        }
                        if(ends[6]>=biggest4985){
                          biggest4985=ends[6];
                        }
                        if(biggest4985 == 1){
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                      }
                    }
                  }
                  break;
                
                case 2 : 
                  if(dosUnitEvac.getprestatus()){//sysj\FillerController.sysj line: 50, column: 22
                    System.out.println("filler is done");//sysj\FillerController.sysj line: 62, column: 6
                    currentFiller_1.setPresent();//sysj\FillerController.sysj line: 64, column: 6
                    currsigs.addElement(currentFiller_1);
                    currentFiller_1.setValue((currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) + 1);//sysj\FillerController.sysj line: 64, column: 6
                    S2244=3;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    thread4986(tdone,ends);
                    thread4987(tdone,ends);
                    int biggest4988 = 0;
                    if(ends[5]>=biggest4988){
                      biggest4988=ends[5];
                    }
                    if(ends[6]>=biggest4988){
                      biggest4988=ends[6];
                    }
                    if(biggest4988 == 1){
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    //FINXME code
                    if(biggest4988 == 0){
                      System.out.println("filler is done");//sysj\FillerController.sysj line: 62, column: 6
                      currentFiller_1.setPresent();//sysj\FillerController.sysj line: 64, column: 6
                      currsigs.addElement(currentFiller_1);
                      currentFiller_1.setValue((currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) + 1);//sysj\FillerController.sysj line: 64, column: 6
                      S2244=3;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                  }
                  break;
                
                case 3 : 
                  S2244=3;
                  S2244=0;
                  if(bottleAtPos2.getprestatus()){//sysj\FillerController.sysj line: 18, column: 22
                    System.out.println("no longer emitting filler ready");//sysj\FillerController.sysj line: 22, column: 6
                    System.out.println("awaiting starting start signal");//sysj\FillerController.sysj line: 24, column: 6
                    start.setPresent();//sysj\FillerController.sysj line: 26, column: 6
                    currsigs.addElement(start);
                    if((Integer)(currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) == 1) {//sysj\FillerController.sysj line: 28, column: 40
                      System.out.println("filler 1 start, filled " + ((Integer)(LiquidAmount1FC.getpreval() == null ? null : ((Integer)LiquidAmount1FC.getpreval()))) + "%");//sysj\FillerController.sysj line: 29, column: 7
                    }
                    else {//sysj\FillerController.sysj line: 28, column: 6
                      if((Integer)(currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) == 2) {//sysj\FillerController.sysj line: 31, column: 45
                        System.out.println("filler 2 start, filled " + ((Integer)(LiquidAmount2FC.getpreval() == null ? null : ((Integer)LiquidAmount2FC.getpreval()))) + "%");//sysj\FillerController.sysj line: 32, column: 7
                      }
                      else {//sysj\FillerController.sysj line: 34, column: 11
                        System.out.println("filler 1 start, filled " + ((Integer)(LiquidAmount1FC.getpreval() == null ? null : ((Integer)LiquidAmount1FC.getpreval()))) + "%");//sysj\FillerController.sysj line: 35, column: 7
                      }
                    }
                    S2244=1;
                    if(dosUnitFilled.getprestatus()){//sysj\FillerController.sysj line: 38, column: 22
                      S2244=2;
                      if(dosUnitEvac.getprestatus()){//sysj\FillerController.sysj line: 50, column: 22
                        System.out.println("filler is done");//sysj\FillerController.sysj line: 62, column: 6
                        currentFiller_1.setPresent();//sysj\FillerController.sysj line: 64, column: 6
                        currsigs.addElement(currentFiller_1);
                        currentFiller_1.setValue((currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) + 1);//sysj\FillerController.sysj line: 64, column: 6
                        S2244=3;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        thread4989(tdone,ends);
                        thread4990(tdone,ends);
                        int biggest4991 = 0;
                        if(ends[5]>=biggest4991){
                          biggest4991=ends[5];
                        }
                        if(ends[6]>=biggest4991){
                          biggest4991=ends[6];
                        }
                        if(biggest4991 == 1){
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                      }
                    }
                    else {
                      thread4992(tdone,ends);
                      thread4993(tdone,ends);
                      int biggest4994 = 0;
                      if(ends[3]>=biggest4994){
                        biggest4994=ends[3];
                      }
                      if(ends[4]>=biggest4994){
                        biggest4994=ends[4];
                      }
                      if(biggest4994 == 1){
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                  }
                  else {
                    System.out.println("emitting filler ready");//sysj\FillerController.sysj line: 19, column: 7
                    fillerReady.setPresent();//sysj\FillerController.sysj line: 20, column: 7
                    currsigs.addElement(fillerReady);
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  break;
                
              }
            }
            break;
          
          case 1 : 
            if(currentFiller_1.getprestatus()){//sysj\FillerController.sysj line: 68, column: 10
              S2675=0;
              if(filler2CompleteLocal_1.getprestatus()){//sysj\FillerController.sysj line: 15, column: 20
                S2675=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S2244=0;
                if(bottleAtPos2.getprestatus()){//sysj\FillerController.sysj line: 18, column: 22
                  System.out.println("no longer emitting filler ready");//sysj\FillerController.sysj line: 22, column: 6
                  System.out.println("awaiting starting start signal");//sysj\FillerController.sysj line: 24, column: 6
                  start.setPresent();//sysj\FillerController.sysj line: 26, column: 6
                  currsigs.addElement(start);
                  if((Integer)(currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) == 1) {//sysj\FillerController.sysj line: 28, column: 40
                    System.out.println("filler 1 start, filled " + ((Integer)(LiquidAmount1FC.getpreval() == null ? null : ((Integer)LiquidAmount1FC.getpreval()))) + "%");//sysj\FillerController.sysj line: 29, column: 7
                  }
                  else {//sysj\FillerController.sysj line: 28, column: 6
                    if((Integer)(currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) == 2) {//sysj\FillerController.sysj line: 31, column: 45
                      System.out.println("filler 2 start, filled " + ((Integer)(LiquidAmount2FC.getpreval() == null ? null : ((Integer)LiquidAmount2FC.getpreval()))) + "%");//sysj\FillerController.sysj line: 32, column: 7
                    }
                    else {//sysj\FillerController.sysj line: 34, column: 11
                      System.out.println("filler 1 start, filled " + ((Integer)(LiquidAmount1FC.getpreval() == null ? null : ((Integer)LiquidAmount1FC.getpreval()))) + "%");//sysj\FillerController.sysj line: 35, column: 7
                    }
                  }
                  S2244=1;
                  if(dosUnitFilled.getprestatus()){//sysj\FillerController.sysj line: 38, column: 22
                    S2244=2;
                    if(dosUnitEvac.getprestatus()){//sysj\FillerController.sysj line: 50, column: 22
                      System.out.println("filler is done");//sysj\FillerController.sysj line: 62, column: 6
                      currentFiller_1.setPresent();//sysj\FillerController.sysj line: 64, column: 6
                      currsigs.addElement(currentFiller_1);
                      currentFiller_1.setValue((currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) + 1);//sysj\FillerController.sysj line: 64, column: 6
                      S2244=3;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      thread4995(tdone,ends);
                      thread4996(tdone,ends);
                      int biggest4997 = 0;
                      if(ends[5]>=biggest4997){
                        biggest4997=ends[5];
                      }
                      if(ends[6]>=biggest4997){
                        biggest4997=ends[6];
                      }
                      if(biggest4997 == 1){
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                  }
                  else {
                    thread4998(tdone,ends);
                    thread4999(tdone,ends);
                    int biggest5000 = 0;
                    if(ends[3]>=biggest5000){
                      biggest5000=ends[3];
                    }
                    if(ends[4]>=biggest5000){
                      biggest5000=ends[4];
                    }
                    if(biggest5000 == 1){
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                  }
                }
                else {
                  System.out.println("emitting filler ready");//sysj\FillerController.sysj line: 19, column: 7
                  fillerReady.setPresent();//sysj\FillerController.sysj line: 20, column: 7
                  currsigs.addElement(fillerReady);
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
              }
            }
            else {
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread4968(int [] tdone, int [] ends){
        S4957=1;
    S4890=0;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread4966(int [] tdone, int [] ends){
        S2260=1;
    System.out.println("brings pressure canister up");//sysj\FillerController.sysj line: 45, column: 7
    dosUnitValveRetract.setPresent();//sysj\FillerController.sysj line: 46, column: 7
    currsigs.addElement(dosUnitValveRetract);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread4965(int [] tdone, int [] ends){
        S2252=1;
    System.out.println("toggles valve injector");//sysj\FillerController.sysj line: 40, column: 7
    valveInjectorOn.setPresent();//sysj\FillerController.sysj line: 41, column: 7
    currsigs.addElement(valveInjectorOn);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread4963(int [] tdone, int [] ends){
        S2311=1;
    System.out.println("brings pressire canister down");//sysj\FillerController.sysj line: 57, column: 7
    dosUnitValveExtend.setPresent();//sysj\FillerController.sysj line: 58, column: 7
    currsigs.addElement(dosUnitValveExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread4962(int [] tdone, int [] ends){
        S2303=1;
    System.out.println("toggles valve inlet");//sysj\FillerController.sysj line: 52, column: 7
    valveInletOn.setPresent();//sysj\FillerController.sysj line: 53, column: 7
    currsigs.addElement(valveInletOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread4961(int [] tdone, int [] ends){
        S4877=1;
    currentFiller_1.setPresent();//sysj\FillerController.sysj line: 12, column: 3
    currsigs.addElement(currentFiller_1);
    currentFiller_1.setValue(1);//sysj\FillerController.sysj line: 12, column: 3
    S2675=0;
    if(filler2CompleteLocal_1.getprestatus()){//sysj\FillerController.sysj line: 15, column: 20
      S2675=1;
      active[2]=1;
      ends[2]=1;
      tdone[2]=1;
    }
    else {
      S2244=0;
      if(bottleAtPos2.getprestatus()){//sysj\FillerController.sysj line: 18, column: 22
        System.out.println("no longer emitting filler ready");//sysj\FillerController.sysj line: 22, column: 6
        System.out.println("awaiting starting start signal");//sysj\FillerController.sysj line: 24, column: 6
        start.setPresent();//sysj\FillerController.sysj line: 26, column: 6
        currsigs.addElement(start);
        if((Integer)(currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) == 1) {//sysj\FillerController.sysj line: 28, column: 40
          System.out.println("filler 1 start, filled " + ((Integer)(LiquidAmount1FC.getpreval() == null ? null : ((Integer)LiquidAmount1FC.getpreval()))) + "%");//sysj\FillerController.sysj line: 29, column: 7
        }
        else {//sysj\FillerController.sysj line: 28, column: 6
          if((Integer)(currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) == 2) {//sysj\FillerController.sysj line: 31, column: 45
            System.out.println("filler 2 start, filled " + ((Integer)(LiquidAmount2FC.getpreval() == null ? null : ((Integer)LiquidAmount2FC.getpreval()))) + "%");//sysj\FillerController.sysj line: 32, column: 7
          }
          else {//sysj\FillerController.sysj line: 34, column: 11
            System.out.println("filler 1 start, filled " + ((Integer)(LiquidAmount1FC.getpreval() == null ? null : ((Integer)LiquidAmount1FC.getpreval()))) + "%");//sysj\FillerController.sysj line: 35, column: 7
          }
        }
        S2244=1;
        if(dosUnitFilled.getprestatus()){//sysj\FillerController.sysj line: 38, column: 22
          S2244=2;
          if(dosUnitEvac.getprestatus()){//sysj\FillerController.sysj line: 50, column: 22
            System.out.println("filler is done");//sysj\FillerController.sysj line: 62, column: 6
            currentFiller_1.setPresent();//sysj\FillerController.sysj line: 64, column: 6
            currsigs.addElement(currentFiller_1);
            currentFiller_1.setValue((currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) + 1);//sysj\FillerController.sysj line: 64, column: 6
            S2244=3;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            thread4962(tdone,ends);
            thread4963(tdone,ends);
            int biggest4964 = 0;
            if(ends[5]>=biggest4964){
              biggest4964=ends[5];
            }
            if(ends[6]>=biggest4964){
              biggest4964=ends[6];
            }
            if(biggest4964 == 1){
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
          }
        }
        else {
          thread4965(tdone,ends);
          thread4966(tdone,ends);
          int biggest4967 = 0;
          if(ends[3]>=biggest4967){
            biggest4967=ends[3];
          }
          if(ends[4]>=biggest4967){
            biggest4967=ends[4];
          }
          if(biggest4967 == 1){
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
        }
      }
      else {
        System.out.println("emitting filler ready");//sysj\FillerController.sysj line: 19, column: 7
        fillerReady.setPresent();//sysj\FillerController.sysj line: 20, column: 7
        currsigs.addElement(fillerReady);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
    }
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S4959){
        case 0 : 
          S4959=0;
          break RUN;
        
        case 1 : 
          S4959=2;
          S4959=2;
          filler2CompleteLocal_1.setClear();//sysj\FillerController.sysj line: 8, column: 2
          filler2_1.setClear();//sysj\FillerController.sysj line: 8, column: 2
          filler1_1.setClear();//sysj\FillerController.sysj line: 8, column: 2
          currentFiller_1.setClear();//sysj\FillerController.sysj line: 9, column: 2
          thread4961(tdone,ends);
          thread4968(tdone,ends);
          int biggest4969 = 0;
          if(ends[2]>=biggest4969){
            biggest4969=ends[2];
          }
          if(ends[7]>=biggest4969){
            biggest4969=ends[7];
          }
          if(biggest4969 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          filler2CompleteLocal_1.setClear();//sysj\FillerController.sysj line: 8, column: 2
          filler2_1.setClear();//sysj\FillerController.sysj line: 8, column: 2
          filler1_1.setClear();//sysj\FillerController.sysj line: 8, column: 2
          currentFiller_1.setClear();//sysj\FillerController.sysj line: 9, column: 2
          thread4970(tdone,ends);
          thread5001(tdone,ends);
          int biggest5002 = 0;
          if(ends[2]>=biggest5002){
            biggest5002=ends[2];
          }
          if(ends[7]>=biggest5002){
            biggest5002=ends[7];
          }
          if(biggest5002 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest5002 == 0){
            S4959=0;
            active[1]=0;
            ends[1]=0;
            S4959=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    filler2CompleteLocal_1 = new Signal();
    filler2_1 = new Signal();
    filler1_1 = new Signal();
    currentFiller_1 = new Signal();
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[1] != 0){
      int index = 1;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        if(!df){
          bottleAtPos2.gethook();
          dosUnitEvac.gethook();
          dosUnitFilled.gethook();
          LiquidAmount1FC.gethook();
          LiquidAmount2FC.gethook();
          df = true;
        }
        runClockDomain();
      }
      bottleAtPos2.setpreclear();
      dosUnitEvac.setpreclear();
      dosUnitFilled.setpreclear();
      LiquidAmount1FC.setpreclear();
      LiquidAmount2FC.setpreclear();
      fillerReady.setpreclear();
      valveInjectorOn.setpreclear();
      valveInletOn.setpreclear();
      dosUnitValveRetract.setpreclear();
      dosUnitValveExtend.setpreclear();
      filler2Complete.setpreclear();
      start.setpreclear();
      filler2CompleteLocal_1.setpreclear();
      filler2_1.setpreclear();
      filler1_1.setpreclear();
      currentFiller_1.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = bottleAtPos2.getStatus() ? bottleAtPos2.setprepresent() : bottleAtPos2.setpreclear();
      bottleAtPos2.setpreval(bottleAtPos2.getValue());
      bottleAtPos2.setClear();
      dummyint = dosUnitEvac.getStatus() ? dosUnitEvac.setprepresent() : dosUnitEvac.setpreclear();
      dosUnitEvac.setpreval(dosUnitEvac.getValue());
      dosUnitEvac.setClear();
      dummyint = dosUnitFilled.getStatus() ? dosUnitFilled.setprepresent() : dosUnitFilled.setpreclear();
      dosUnitFilled.setpreval(dosUnitFilled.getValue());
      dosUnitFilled.setClear();
      dummyint = LiquidAmount1FC.getStatus() ? LiquidAmount1FC.setprepresent() : LiquidAmount1FC.setpreclear();
      LiquidAmount1FC.setpreval(LiquidAmount1FC.getValue());
      LiquidAmount1FC.setClear();
      dummyint = LiquidAmount2FC.getStatus() ? LiquidAmount2FC.setprepresent() : LiquidAmount2FC.setpreclear();
      LiquidAmount2FC.setpreval(LiquidAmount2FC.getValue());
      LiquidAmount2FC.setClear();
      fillerReady.sethook();
      fillerReady.setClear();
      valveInjectorOn.sethook();
      valveInjectorOn.setClear();
      valveInletOn.sethook();
      valveInletOn.setClear();
      dosUnitValveRetract.sethook();
      dosUnitValveRetract.setClear();
      dosUnitValveExtend.sethook();
      dosUnitValveExtend.setClear();
      filler2Complete.sethook();
      filler2Complete.setClear();
      start.sethook();
      start.setClear();
      filler2CompleteLocal_1.setClear();
      filler2_1.setClear();
      filler1_1.setClear();
      currentFiller_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        bottleAtPos2.gethook();
        dosUnitEvac.gethook();
        dosUnitFilled.gethook();
        LiquidAmount1FC.gethook();
        LiquidAmount2FC.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
