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
  public Signal start = new Signal("start", Signal.INPUT);
  public Signal LiquidAmount1FC = new Signal("LiquidAmount1FC", Signal.INPUT);
  public Signal LiquidAmount2FC = new Signal("LiquidAmount2FC", Signal.INPUT);
  public Signal fillerReady = new Signal("fillerReady", Signal.OUTPUT);
  public Signal valveInjectorOn = new Signal("valveInjectorOn", Signal.OUTPUT);
  public Signal valveInletOn = new Signal("valveInletOn", Signal.OUTPUT);
  public Signal dosUnitValveRetract = new Signal("dosUnitValveRetract", Signal.OUTPUT);
  public Signal dosUnitValveExtend = new Signal("dosUnitValveExtend", Signal.OUTPUT);
  public Signal filler2Complete = new Signal("filler2Complete", Signal.OUTPUT);
  private Signal filler2CompleteLocal_1;
  private Signal filler2_1;
  private Signal filler1_1;
  private Signal currentFiller_1;
  private int S2950 = 1;
  private int S2892 = 1;
  private int S2042 = 1;
  private int S2051 = 1;
  private int S2059 = 1;
  private int S2067 = 1;
  private int S2093 = 1;
  private int S2101 = 1;
  private int S2948 = 1;
  
  private int[] ends = new int[8];
  private int[] tdone = new int[8];
  
  public void thread2971(int [] tdone, int [] ends){
        switch(S2948){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        if((Integer)(currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) == 2){//sysj\FillerController.sysj line: 83, column: 8
          filler2_1.setPresent();//sysj\FillerController.sysj line: 84, column: 5
          currsigs.addElement(filler2_1);
          active[7]=1;
          ends[7]=1;
          tdone[7]=1;
        }
        else {
          if((Integer)(currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) == 1){//sysj\FillerController.sysj line: 85, column: 16
            filler1_1.setPresent();//sysj\FillerController.sysj line: 86, column: 6
            currsigs.addElement(filler1_1);
            active[7]=1;
            ends[7]=1;
            tdone[7]=1;
          }
          else {
            if((Integer)(currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) == 3){//sysj\FillerController.sysj line: 87, column: 15
              filler2Complete.setPresent();//sysj\FillerController.sysj line: 88, column: 6
              currsigs.addElement(filler2Complete);
              filler2CompleteLocal_1.setPresent();//sysj\FillerController.sysj line: 89, column: 6
              currsigs.addElement(filler2CompleteLocal_1);
              currentFiller_1.setPresent();//sysj\FillerController.sysj line: 91, column: 6
              currsigs.addElement(currentFiller_1);
              currentFiller_1.setValue(1);//sysj\FillerController.sysj line: 91, column: 6
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
          }
        }
        break;
      
    }
  }

  public void thread2969(int [] tdone, int [] ends){
        switch(S2101){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        dosUnitValveExtend.setPresent();//sysj\FillerController.sysj line: 62, column: 6
        currsigs.addElement(dosUnitValveExtend);
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
        break;
      
    }
  }

  public void thread2968(int [] tdone, int [] ends){
        switch(S2093){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        valveInletOn.setPresent();//sysj\FillerController.sysj line: 57, column: 6
        currsigs.addElement(valveInletOn);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread2966(int [] tdone, int [] ends){
        S2101=1;
    System.out.println("brings pressire canister down");//sysj\FillerController.sysj line: 61, column: 6
    dosUnitValveExtend.setPresent();//sysj\FillerController.sysj line: 62, column: 6
    currsigs.addElement(dosUnitValveExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread2965(int [] tdone, int [] ends){
        S2093=1;
    System.out.println("toggles valve inlet");//sysj\FillerController.sysj line: 56, column: 6
    valveInletOn.setPresent();//sysj\FillerController.sysj line: 57, column: 6
    currsigs.addElement(valveInletOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread2963(int [] tdone, int [] ends){
        switch(S2067){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        dosUnitValveRetract.setPresent();//sysj\FillerController.sysj line: 50, column: 6
        currsigs.addElement(dosUnitValveRetract);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread2962(int [] tdone, int [] ends){
        switch(S2059){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        valveInjectorOn.setPresent();//sysj\FillerController.sysj line: 45, column: 6
        currsigs.addElement(valveInjectorOn);
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
        break;
      
    }
  }

  public void thread2960(int [] tdone, int [] ends){
        S2101=1;
    System.out.println("brings pressire canister down");//sysj\FillerController.sysj line: 61, column: 6
    dosUnitValveExtend.setPresent();//sysj\FillerController.sysj line: 62, column: 6
    currsigs.addElement(dosUnitValveExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread2959(int [] tdone, int [] ends){
        S2093=1;
    System.out.println("toggles valve inlet");//sysj\FillerController.sysj line: 56, column: 6
    valveInletOn.setPresent();//sysj\FillerController.sysj line: 57, column: 6
    currsigs.addElement(valveInletOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread2957(int [] tdone, int [] ends){
        S2067=1;
    System.out.println("brings pressure canister up");//sysj\FillerController.sysj line: 49, column: 6
    dosUnitValveRetract.setPresent();//sysj\FillerController.sysj line: 50, column: 6
    currsigs.addElement(dosUnitValveRetract);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread2956(int [] tdone, int [] ends){
        S2059=1;
    System.out.println("toggles valve injector");//sysj\FillerController.sysj line: 44, column: 6
    valveInjectorOn.setPresent();//sysj\FillerController.sysj line: 45, column: 6
    currsigs.addElement(valveInjectorOn);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread2955(int [] tdone, int [] ends){
        switch(S2892){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S2042){
          case 0 : 
            if(start.getprestatus()){//sysj\FillerController.sysj line: 14, column: 19
              currentFiller_1.setPresent();//sysj\FillerController.sysj line: 15, column: 3
              currsigs.addElement(currentFiller_1);
              currentFiller_1.setValue(1);//sysj\FillerController.sysj line: 15, column: 3
              S2042=1;
              if(filler2CompleteLocal_1.getprestatus()){//sysj\FillerController.sysj line: 17, column: 19
                S2892=0;
                active[2]=0;
                ends[2]=0;
                tdone[2]=1;
              }
              else {
                S2051=0;
                if(bottleAtPos2.getprestatus()){//sysj\FillerController.sysj line: 20, column: 21
                  if((Integer)(currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) == 1) {//sysj\FillerController.sysj line: 26, column: 39
                    System.out.println("filler 1 start, filled " + ((Integer)(LiquidAmount1FC.getpreval() == null ? null : ((Integer)LiquidAmount1FC.getpreval()))) + "%");//sysj\FillerController.sysj line: 27, column: 6
                  }
                  else {//sysj\FillerController.sysj line: 26, column: 5
                    if((Integer)(currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) == 2) {//sysj\FillerController.sysj line: 29, column: 44
                      System.out.println("filler 2 start, filled " + ((Integer)(LiquidAmount2FC.getpreval() == null ? null : ((Integer)LiquidAmount2FC.getpreval()))) + "%");//sysj\FillerController.sysj line: 30, column: 6
                    }
                    else {//sysj\FillerController.sysj line: 31, column: 11
                      System.out.println("filler 1 start, filled " + ((Integer)(LiquidAmount1FC.getpreval() == null ? null : ((Integer)LiquidAmount1FC.getpreval()))) + "%");//sysj\FillerController.sysj line: 32, column: 6
                    }
                  }
                  S2051=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  System.out.println("emitting filler ready");//sysj\FillerController.sysj line: 21, column: 6
                  fillerReady.setPresent();//sysj\FillerController.sysj line: 22, column: 6
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
          
          case 1 : 
            if(filler2CompleteLocal_1.getprestatus()){//sysj\FillerController.sysj line: 17, column: 19
              S2892=0;
              active[2]=0;
              ends[2]=0;
              tdone[2]=1;
            }
            else {
              switch(S2051){
                case 0 : 
                  if(bottleAtPos2.getprestatus()){//sysj\FillerController.sysj line: 20, column: 21
                    if((Integer)(currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) == 1) {//sysj\FillerController.sysj line: 26, column: 39
                      System.out.println("filler 1 start, filled " + ((Integer)(LiquidAmount1FC.getpreval() == null ? null : ((Integer)LiquidAmount1FC.getpreval()))) + "%");//sysj\FillerController.sysj line: 27, column: 6
                    }
                    else {//sysj\FillerController.sysj line: 26, column: 5
                      if((Integer)(currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) == 2) {//sysj\FillerController.sysj line: 29, column: 44
                        System.out.println("filler 2 start, filled " + ((Integer)(LiquidAmount2FC.getpreval() == null ? null : ((Integer)LiquidAmount2FC.getpreval()))) + "%");//sysj\FillerController.sysj line: 30, column: 6
                      }
                      else {//sysj\FillerController.sysj line: 31, column: 11
                        System.out.println("filler 1 start, filled " + ((Integer)(LiquidAmount1FC.getpreval() == null ? null : ((Integer)LiquidAmount1FC.getpreval()))) + "%");//sysj\FillerController.sysj line: 32, column: 6
                      }
                    }
                    S2051=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    fillerReady.setPresent();//sysj\FillerController.sysj line: 22, column: 6
                    currsigs.addElement(fillerReady);
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  break;
                
                case 1 : 
                  S2051=1;
                  S2051=2;
                  thread2956(tdone,ends);
                  thread2957(tdone,ends);
                  int biggest2958 = 0;
                  if(ends[3]>=biggest2958){
                    biggest2958=ends[3];
                  }
                  if(ends[4]>=biggest2958){
                    biggest2958=ends[4];
                  }
                  if(biggest2958 == 1){
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  break;
                
                case 2 : 
                  if(dosUnitFilled.getprestatus()){//sysj\FillerController.sysj line: 42, column: 11
                    S2051=3;
                    thread2959(tdone,ends);
                    thread2960(tdone,ends);
                    int biggest2961 = 0;
                    if(ends[5]>=biggest2961){
                      biggest2961=ends[5];
                    }
                    if(ends[6]>=biggest2961){
                      biggest2961=ends[6];
                    }
                    if(biggest2961 == 1){
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                  }
                  else {
                    thread2962(tdone,ends);
                    thread2963(tdone,ends);
                    int biggest2964 = 0;
                    if(ends[3]>=biggest2964){
                      biggest2964=ends[3];
                    }
                    if(ends[4]>=biggest2964){
                      biggest2964=ends[4];
                    }
                    if(biggest2964 == 1){
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    //FINXME code
                    if(biggest2964 == 0){
                      S2051=3;
                      thread2965(tdone,ends);
                      thread2966(tdone,ends);
                      int biggest2967 = 0;
                      if(ends[5]>=biggest2967){
                        biggest2967=ends[5];
                      }
                      if(ends[6]>=biggest2967){
                        biggest2967=ends[6];
                      }
                      if(biggest2967 == 1){
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                  }
                  break;
                
                case 3 : 
                  if(dosUnitEvac.getprestatus()){//sysj\FillerController.sysj line: 54, column: 11
                    System.out.println("filler is done");//sysj\FillerController.sysj line: 66, column: 5
                    currentFiller_1.setPresent();//sysj\FillerController.sysj line: 68, column: 5
                    currsigs.addElement(currentFiller_1);
                    currentFiller_1.setValue((currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) + 1);//sysj\FillerController.sysj line: 68, column: 5
                    S2051=4;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    thread2968(tdone,ends);
                    thread2969(tdone,ends);
                    int biggest2970 = 0;
                    if(ends[5]>=biggest2970){
                      biggest2970=ends[5];
                    }
                    if(ends[6]>=biggest2970){
                      biggest2970=ends[6];
                    }
                    if(biggest2970 == 1){
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    //FINXME code
                    if(biggest2970 == 0){
                      System.out.println("filler is done");//sysj\FillerController.sysj line: 66, column: 5
                      currentFiller_1.setPresent();//sysj\FillerController.sysj line: 68, column: 5
                      currsigs.addElement(currentFiller_1);
                      currentFiller_1.setValue((currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) + 1);//sysj\FillerController.sysj line: 68, column: 5
                      S2051=4;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                  }
                  break;
                
                case 4 : 
                  S2051=4;
                  S2051=0;
                  if(bottleAtPos2.getprestatus()){//sysj\FillerController.sysj line: 20, column: 21
                    if((Integer)(currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) == 1) {//sysj\FillerController.sysj line: 26, column: 39
                      System.out.println("filler 1 start, filled " + ((Integer)(LiquidAmount1FC.getpreval() == null ? null : ((Integer)LiquidAmount1FC.getpreval()))) + "%");//sysj\FillerController.sysj line: 27, column: 6
                    }
                    else {//sysj\FillerController.sysj line: 26, column: 5
                      if((Integer)(currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) == 2) {//sysj\FillerController.sysj line: 29, column: 44
                        System.out.println("filler 2 start, filled " + ((Integer)(LiquidAmount2FC.getpreval() == null ? null : ((Integer)LiquidAmount2FC.getpreval()))) + "%");//sysj\FillerController.sysj line: 30, column: 6
                      }
                      else {//sysj\FillerController.sysj line: 31, column: 11
                        System.out.println("filler 1 start, filled " + ((Integer)(LiquidAmount1FC.getpreval() == null ? null : ((Integer)LiquidAmount1FC.getpreval()))) + "%");//sysj\FillerController.sysj line: 32, column: 6
                      }
                    }
                    S2051=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    System.out.println("emitting filler ready");//sysj\FillerController.sysj line: 21, column: 6
                    fillerReady.setPresent();//sysj\FillerController.sysj line: 22, column: 6
                    currsigs.addElement(fillerReady);
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  break;
                
              }
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2953(int [] tdone, int [] ends){
        S2948=1;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread2952(int [] tdone, int [] ends){
        S2892=1;
    System.out.println("awaiting starting start signal");//sysj\FillerController.sysj line: 13, column: 3
    S2042=0;
    if(start.getprestatus()){//sysj\FillerController.sysj line: 14, column: 19
      currentFiller_1.setPresent();//sysj\FillerController.sysj line: 15, column: 3
      currsigs.addElement(currentFiller_1);
      currentFiller_1.setValue(1);//sysj\FillerController.sysj line: 15, column: 3
      S2042=1;
      if(filler2CompleteLocal_1.getprestatus()){//sysj\FillerController.sysj line: 17, column: 19
        S2892=0;
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
      }
      else {
        S2051=0;
        if(bottleAtPos2.getprestatus()){//sysj\FillerController.sysj line: 20, column: 21
          if((Integer)(currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) == 1) {//sysj\FillerController.sysj line: 26, column: 39
            System.out.println("filler 1 start, filled " + ((Integer)(LiquidAmount1FC.getpreval() == null ? null : ((Integer)LiquidAmount1FC.getpreval()))) + "%");//sysj\FillerController.sysj line: 27, column: 6
          }
          else {//sysj\FillerController.sysj line: 26, column: 5
            if((Integer)(currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) == 2) {//sysj\FillerController.sysj line: 29, column: 44
              System.out.println("filler 2 start, filled " + ((Integer)(LiquidAmount2FC.getpreval() == null ? null : ((Integer)LiquidAmount2FC.getpreval()))) + "%");//sysj\FillerController.sysj line: 30, column: 6
            }
            else {//sysj\FillerController.sysj line: 31, column: 11
              System.out.println("filler 1 start, filled " + ((Integer)(LiquidAmount1FC.getpreval() == null ? null : ((Integer)LiquidAmount1FC.getpreval()))) + "%");//sysj\FillerController.sysj line: 32, column: 6
            }
          }
          S2051=1;
          active[2]=1;
          ends[2]=1;
          tdone[2]=1;
        }
        else {
          System.out.println("emitting filler ready");//sysj\FillerController.sysj line: 21, column: 6
          fillerReady.setPresent();//sysj\FillerController.sysj line: 22, column: 6
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
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S2950){
        case 0 : 
          S2950=0;
          break RUN;
        
        case 1 : 
          S2950=2;
          S2950=2;
          filler2CompleteLocal_1.setClear();//sysj\FillerController.sysj line: 8, column: 2
          filler2_1.setClear();//sysj\FillerController.sysj line: 8, column: 2
          filler1_1.setClear();//sysj\FillerController.sysj line: 8, column: 2
          currentFiller_1.setClear();//sysj\FillerController.sysj line: 9, column: 2
          thread2952(tdone,ends);
          thread2953(tdone,ends);
          int biggest2954 = 0;
          if(ends[2]>=biggest2954){
            biggest2954=ends[2];
          }
          if(ends[7]>=biggest2954){
            biggest2954=ends[7];
          }
          if(biggest2954 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          filler2CompleteLocal_1.setClear();//sysj\FillerController.sysj line: 8, column: 2
          filler2_1.setClear();//sysj\FillerController.sysj line: 8, column: 2
          filler1_1.setClear();//sysj\FillerController.sysj line: 8, column: 2
          currentFiller_1.setClear();//sysj\FillerController.sysj line: 9, column: 2
          thread2955(tdone,ends);
          thread2971(tdone,ends);
          int biggest2972 = 0;
          if(ends[2]>=biggest2972){
            biggest2972=ends[2];
          }
          if(ends[7]>=biggest2972){
            biggest2972=ends[7];
          }
          if(biggest2972 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest2972 == 0){
            S2950=0;
            active[1]=0;
            ends[1]=0;
            S2950=0;
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
          start.gethook();
          LiquidAmount1FC.gethook();
          LiquidAmount2FC.gethook();
          df = true;
        }
        runClockDomain();
      }
      bottleAtPos2.setpreclear();
      dosUnitEvac.setpreclear();
      dosUnitFilled.setpreclear();
      start.setpreclear();
      LiquidAmount1FC.setpreclear();
      LiquidAmount2FC.setpreclear();
      fillerReady.setpreclear();
      valveInjectorOn.setpreclear();
      valveInletOn.setpreclear();
      dosUnitValveRetract.setpreclear();
      dosUnitValveExtend.setpreclear();
      filler2Complete.setpreclear();
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
      dummyint = start.getStatus() ? start.setprepresent() : start.setpreclear();
      start.setpreval(start.getValue());
      start.setClear();
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
      filler2CompleteLocal_1.setClear();
      filler2_1.setClear();
      filler1_1.setClear();
      currentFiller_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        bottleAtPos2.gethook();
        dosUnitEvac.gethook();
        dosUnitFilled.gethook();
        start.gethook();
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
