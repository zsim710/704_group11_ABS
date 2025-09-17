import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.GUI;//sysj\FillerPlant.sysj line: 1, column: 1

public class FillerPlant extends ClockDomain{
  public FillerPlant(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal enableFP = new Signal("enableFP", Signal.INPUT);
  public Signal valveInjectorOn = new Signal("valveInjectorOn", Signal.INPUT);
  public Signal valveInletOn = new Signal("valveInletOn", Signal.INPUT);
  public Signal dosUnitValveRetract = new Signal("dosUnitValveRetract", Signal.INPUT);
  public Signal dosUnitValveExtend = new Signal("dosUnitValveExtend", Signal.INPUT);
  public Signal LiquidAmount1FP = new Signal("LiquidAmount1FP", Signal.INPUT);
  public Signal LiquidAmount2FP = new Signal("LiquidAmount2FP", Signal.INPUT);
  public Signal dosUnitEvac = new Signal("dosUnitEvac", Signal.OUTPUT);
  public Signal dosUnitFilled = new Signal("dosUnitFilled", Signal.OUTPUT);
  public Signal fillersCompleteGUI = new Signal("fillersCompleteGUI", Signal.OUTPUT);
  public Signal filler1OnGUI = new Signal("filler1OnGUI", Signal.OUTPUT);
  public Signal filler2OnGUI = new Signal("filler2OnGUI", Signal.OUTPUT);
  public Signal filler1InletGUI = new Signal("filler1InletGUI", Signal.OUTPUT);
  public Signal filler2InletGUI = new Signal("filler2InletGUI", Signal.OUTPUT);
  public Signal fillerIdleGUI = new Signal("fillerIdleGUI", Signal.OUTPUT);
  public Signal bottleAtPos2GUI = new Signal("bottleAtPos2GUI", Signal.OUTPUT);
  private Signal filler1_1;
  private Signal filler2_1;
  private Signal filler2Complete_1;
  private Signal filler1Complete_1;
  private Signal currentFiller_1;
  private Signal fillerIdle_1;
  private Signal bottleAtPos2_1;
  private int S4567 = 1;
  private int S3242 = 1;
  private int S3239 = 1;
  private int S2925 = 1;
  private int S3279 = 1;
  private int S3329 = 1;
  private int S3287 = 1;
  private int S3295 = 1;
  private int S3303 = 1;
  private int S3311 = 1;
  private int S3319 = 1;
  private int S3327 = 1;
  
  private int[] ends = new int[11];
  private int[] tdone = new int[11];
  
  public void thread4588(int [] tdone, int [] ends){
        switch(S3327){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        if(fillerIdle_1.getprestatus()){//sysj\FillerPlant.sysj line: 103, column: 24
          fillerIdleGUI.setPresent();//sysj\FillerPlant.sysj line: 103, column: 36
          currsigs.addElement(fillerIdleGUI);
          active[10]=1;
          ends[10]=1;
          tdone[10]=1;
        }
        else {
          active[10]=1;
          ends[10]=1;
          tdone[10]=1;
        }
        break;
      
    }
  }

  public void thread4587(int [] tdone, int [] ends){
        switch(S3319){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        if(filler2_1.getprestatus() && dosUnitValveExtend.getprestatus()){//sysj\FillerPlant.sysj line: 101, column: 24
          filler2InletGUI.setPresent();//sysj\FillerPlant.sysj line: 101, column: 55
          currsigs.addElement(filler2InletGUI);
          active[9]=1;
          ends[9]=1;
          tdone[9]=1;
        }
        else {
          active[9]=1;
          ends[9]=1;
          tdone[9]=1;
        }
        break;
      
    }
  }

  public void thread4586(int [] tdone, int [] ends){
        switch(S3311){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        if(filler1_1.getprestatus() && dosUnitValveExtend.getprestatus()){//sysj\FillerPlant.sysj line: 99, column: 24
          filler1InletGUI.setPresent();//sysj\FillerPlant.sysj line: 99, column: 55
          currsigs.addElement(filler1InletGUI);
          active[8]=1;
          ends[8]=1;
          tdone[8]=1;
        }
        else {
          active[8]=1;
          ends[8]=1;
          tdone[8]=1;
        }
        break;
      
    }
  }

  public void thread4585(int [] tdone, int [] ends){
        switch(S3303){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        if(filler2_1.getprestatus() && valveInjectorOn.getprestatus()){//sysj\FillerPlant.sysj line: 97, column: 24
          filler2OnGUI.setPresent();//sysj\FillerPlant.sysj line: 97, column: 52
          currsigs.addElement(filler2OnGUI);
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
  }

  public void thread4584(int [] tdone, int [] ends){
        switch(S3295){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        if(filler1_1.getprestatus() && valveInjectorOn.getprestatus()){//sysj\FillerPlant.sysj line: 95, column: 24
          filler1OnGUI.setPresent();//sysj\FillerPlant.sysj line: 95, column: 52
          currsigs.addElement(filler1OnGUI);
          active[6]=1;
          ends[6]=1;
          tdone[6]=1;
        }
        else {
          active[6]=1;
          ends[6]=1;
          tdone[6]=1;
        }
        break;
      
    }
  }

  public void thread4583(int [] tdone, int [] ends){
        switch(S3287){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        if(filler2Complete_1.getprestatus()){//sysj\FillerPlant.sysj line: 93, column: 24
          fillersCompleteGUI.setPresent();//sysj\FillerPlant.sysj line: 93, column: 41
          currsigs.addElement(fillersCompleteGUI);
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        else {
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        break;
      
    }
  }

  public void thread4582(int [] tdone, int [] ends){
        switch(S3329){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        thread4583(tdone,ends);
        thread4584(tdone,ends);
        thread4585(tdone,ends);
        thread4586(tdone,ends);
        thread4587(tdone,ends);
        thread4588(tdone,ends);
        int biggest4589 = 0;
        if(ends[5]>=biggest4589){
          biggest4589=ends[5];
        }
        if(ends[6]>=biggest4589){
          biggest4589=ends[6];
        }
        if(ends[7]>=biggest4589){
          biggest4589=ends[7];
        }
        if(ends[8]>=biggest4589){
          biggest4589=ends[8];
        }
        if(ends[9]>=biggest4589){
          biggest4589=ends[9];
        }
        if(ends[10]>=biggest4589){
          biggest4589=ends[10];
        }
        if(biggest4589 == 1){
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
        //FINXME code
        if(biggest4589 == 0){
          S3329=0;
          active[4]=0;
          ends[4]=0;
          tdone[4]=1;
        }
        break;
      
    }
  }

  public void thread4581(int [] tdone, int [] ends){
        switch(S3279){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        if((Integer)(currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) == 2){//sysj\FillerPlant.sysj line: 80, column: 7
          filler2_1.setPresent();//sysj\FillerPlant.sysj line: 81, column: 4
          currsigs.addElement(filler2_1);
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        else {
          if((Integer)(currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) == 1){//sysj\FillerPlant.sysj line: 82, column: 15
            filler1_1.setPresent();//sysj\FillerPlant.sysj line: 83, column: 5
            currsigs.addElement(filler1_1);
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
          }
          else {
            filler2Complete_1.setPresent();//sysj\FillerPlant.sysj line: 85, column: 5
            currsigs.addElement(filler2Complete_1);
            currentFiller_1.setPresent();//sysj\FillerPlant.sysj line: 86, column: 5
            currsigs.addElement(currentFiller_1);
            currentFiller_1.setValue(1);//sysj\FillerPlant.sysj line: 86, column: 5
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
          }
        }
        break;
      
    }
  }

  public void thread4580(int [] tdone, int [] ends){
        switch(S3242){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(filler2Complete_1.getprestatus()){//sysj\FillerPlant.sysj line: 21, column: 8
          System.out.println("all fillers complete");//sysj\FillerPlant.sysj line: 73, column: 2
          S3242=0;
          active[2]=0;
          ends[2]=0;
          tdone[2]=1;
        }
        else {
          switch(S3239){
            case 0 : 
              S3239=0;
              S3239=1;
              S2925=0;
              fillerIdle_1.setPresent();//sysj\FillerPlant.sysj line: 27, column: 5
              currsigs.addElement(fillerIdle_1);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
              break;
            
            case 1 : 
              switch(S2925){
                case 0 : 
                  if(valveInjectorOn.getprestatus() && enableFP.getprestatus()){//sysj\FillerPlant.sysj line: 26, column: 10
                    System.out.println("starting filler " + (Integer)(currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()));//sysj\FillerPlant.sysj line: 30, column: 4
                    S2925=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    fillerIdle_1.setPresent();//sysj\FillerPlant.sysj line: 27, column: 5
                    currsigs.addElement(fillerIdle_1);
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  break;
                
                case 1 : 
                  if(!enableFP.getprestatus()){//sysj\FillerPlant.sysj line: 35, column: 10
                    S2925=2;
                    if(dosUnitValveRetract.getprestatus()){//sysj\FillerPlant.sysj line: 38, column: 14
                      System.out.println("reached here 1");//sysj\FillerPlant.sysj line: 39, column: 7
                      dosUnitFilled.setPresent();//sysj\FillerPlant.sysj line: 40, column: 7
                      currsigs.addElement(dosUnitFilled);
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      System.out.println("left abort 1");//sysj\FillerPlant.sysj line: 43, column: 4
                      S2925=3;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                  }
                  else {
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  break;
                
                case 2 : 
                  if(dosUnitValveExtend.getprestatus() && enableFP.getprestatus()){//sysj\FillerPlant.sysj line: 37, column: 10
                    System.out.println("left abort 1");//sysj\FillerPlant.sysj line: 43, column: 4
                    S2925=3;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    dosUnitFilled.setPresent();//sysj\FillerPlant.sysj line: 40, column: 7
                    currsigs.addElement(dosUnitFilled);
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  break;
                
                case 3 : 
                  if(!enableFP.getprestatus()){//sysj\FillerPlant.sysj line: 46, column: 10
                    S2925=4;
                    if(dosUnitValveExtend.getprestatus()){//sysj\FillerPlant.sysj line: 49, column: 14
                      System.out.println("reached here 2");//sysj\FillerPlant.sysj line: 50, column: 7
                      dosUnitEvac.setPresent();//sysj\FillerPlant.sysj line: 51, column: 7
                      currsigs.addElement(dosUnitEvac);
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      System.out.println("left abort 2");//sysj\FillerPlant.sysj line: 54, column: 4
                      S2925=5;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                  }
                  else {
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  break;
                
                case 4 : 
                  if(!valveInletOn.getprestatus() && enableFP.getprestatus()){//sysj\FillerPlant.sysj line: 48, column: 10
                    System.out.println("left abort 2");//sysj\FillerPlant.sysj line: 54, column: 4
                    S2925=5;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    dosUnitEvac.setPresent();//sysj\FillerPlant.sysj line: 51, column: 7
                    currsigs.addElement(dosUnitEvac);
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  break;
                
                case 5 : 
                  if(!enableFP.getprestatus()){//sysj\FillerPlant.sysj line: 56, column: 10
                    if((Integer)(currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) == 1) {//sysj\FillerPlant.sysj line: 58, column: 38
                      System.out.println("filler 1 complete, filled " + ((Integer)(LiquidAmount1FP.getpreval() == null ? null : ((Integer)LiquidAmount1FP.getpreval()))) + "%");//sysj\FillerPlant.sysj line: 59, column: 5
                    }
                    else {//sysj\FillerPlant.sysj line: 58, column: 4
                      if((Integer)(currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) == 2) {//sysj\FillerPlant.sysj line: 61, column: 43
                        System.out.println("filler 2 complete, filled " + ((Integer)(LiquidAmount2FP.getpreval() == null ? null : ((Integer)LiquidAmount2FP.getpreval()))) + "%");//sysj\FillerPlant.sysj line: 62, column: 5
                      }
                    }
                    S2925=6;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  break;
                
                case 6 : 
                  if(enableFP.getprestatus()){//sysj\FillerPlant.sysj line: 65, column: 10
                    currentFiller_1.setPresent();//sysj\FillerPlant.sysj line: 66, column: 4
                    currsigs.addElement(currentFiller_1);
                    currentFiller_1.setValue((Integer)(currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) + 1);//sysj\FillerPlant.sysj line: 66, column: 4
                    System.out.println("looped");//sysj\FillerPlant.sysj line: 67, column: 4
                    S2925=7;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  break;
                
                case 7 : 
                  if(!enableFP.getprestatus()){//sysj\FillerPlant.sysj line: 68, column: 10
                    S2925=0;
                    fillerIdle_1.setPresent();//sysj\FillerPlant.sysj line: 27, column: 5
                    currsigs.addElement(fillerIdle_1);
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
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
        break;
      
    }
  }

  public void thread4577(int [] tdone, int [] ends){
        S3327=1;
    if(fillerIdle_1.getprestatus()){//sysj\FillerPlant.sysj line: 103, column: 24
      fillerIdleGUI.setPresent();//sysj\FillerPlant.sysj line: 103, column: 36
      currsigs.addElement(fillerIdleGUI);
      active[10]=1;
      ends[10]=1;
      tdone[10]=1;
    }
    else {
      active[10]=1;
      ends[10]=1;
      tdone[10]=1;
    }
  }

  public void thread4576(int [] tdone, int [] ends){
        S3319=1;
    if(filler2_1.getprestatus() && dosUnitValveExtend.getprestatus()){//sysj\FillerPlant.sysj line: 101, column: 24
      filler2InletGUI.setPresent();//sysj\FillerPlant.sysj line: 101, column: 55
      currsigs.addElement(filler2InletGUI);
      active[9]=1;
      ends[9]=1;
      tdone[9]=1;
    }
    else {
      active[9]=1;
      ends[9]=1;
      tdone[9]=1;
    }
  }

  public void thread4575(int [] tdone, int [] ends){
        S3311=1;
    if(filler1_1.getprestatus() && dosUnitValveExtend.getprestatus()){//sysj\FillerPlant.sysj line: 99, column: 24
      filler1InletGUI.setPresent();//sysj\FillerPlant.sysj line: 99, column: 55
      currsigs.addElement(filler1InletGUI);
      active[8]=1;
      ends[8]=1;
      tdone[8]=1;
    }
    else {
      active[8]=1;
      ends[8]=1;
      tdone[8]=1;
    }
  }

  public void thread4574(int [] tdone, int [] ends){
        S3303=1;
    if(filler2_1.getprestatus() && valveInjectorOn.getprestatus()){//sysj\FillerPlant.sysj line: 97, column: 24
      filler2OnGUI.setPresent();//sysj\FillerPlant.sysj line: 97, column: 52
      currsigs.addElement(filler2OnGUI);
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

  public void thread4573(int [] tdone, int [] ends){
        S3295=1;
    if(filler1_1.getprestatus() && valveInjectorOn.getprestatus()){//sysj\FillerPlant.sysj line: 95, column: 24
      filler1OnGUI.setPresent();//sysj\FillerPlant.sysj line: 95, column: 52
      currsigs.addElement(filler1OnGUI);
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
    else {
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
  }

  public void thread4572(int [] tdone, int [] ends){
        S3287=1;
    if(filler2Complete_1.getprestatus()){//sysj\FillerPlant.sysj line: 93, column: 24
      fillersCompleteGUI.setPresent();//sysj\FillerPlant.sysj line: 93, column: 41
      currsigs.addElement(fillersCompleteGUI);
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
    else {
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
  }

  public void thread4571(int [] tdone, int [] ends){
        S3329=1;
    thread4572(tdone,ends);
    thread4573(tdone,ends);
    thread4574(tdone,ends);
    thread4575(tdone,ends);
    thread4576(tdone,ends);
    thread4577(tdone,ends);
    int biggest4578 = 0;
    if(ends[5]>=biggest4578){
      biggest4578=ends[5];
    }
    if(ends[6]>=biggest4578){
      biggest4578=ends[6];
    }
    if(ends[7]>=biggest4578){
      biggest4578=ends[7];
    }
    if(ends[8]>=biggest4578){
      biggest4578=ends[8];
    }
    if(ends[9]>=biggest4578){
      biggest4578=ends[9];
    }
    if(ends[10]>=biggest4578){
      biggest4578=ends[10];
    }
    if(biggest4578 == 1){
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread4570(int [] tdone, int [] ends){
        S3279=1;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread4569(int [] tdone, int [] ends){
        S3242=1;
    S3239=0;
    active[2]=1;
    ends[2]=1;
    tdone[2]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S4567){
        case 0 : 
          S4567=0;
          break RUN;
        
        case 1 : 
          S4567=2;
          S4567=2;
          new Thread(new GUI()).start();//sysj\FillerPlant.sysj line: 12, column: 2
          filler1_1.setClear();//sysj\FillerPlant.sysj line: 14, column: 2
          filler2_1.setClear();//sysj\FillerPlant.sysj line: 14, column: 2
          filler2Complete_1.setClear();//sysj\FillerPlant.sysj line: 14, column: 2
          filler1Complete_1.setClear();//sysj\FillerPlant.sysj line: 14, column: 2
          currentFiller_1.setClear();//sysj\FillerPlant.sysj line: 15, column: 2
          fillerIdle_1.setClear();//sysj\FillerPlant.sysj line: 16, column: 2
          bottleAtPos2_1.setClear();//sysj\FillerPlant.sysj line: 16, column: 2
          currentFiller_1.setPresent();//sysj\FillerPlant.sysj line: 18, column: 2
          currsigs.addElement(currentFiller_1);
          currentFiller_1.setValue(1);//sysj\FillerPlant.sysj line: 18, column: 2
          thread4569(tdone,ends);
          thread4570(tdone,ends);
          thread4571(tdone,ends);
          int biggest4579 = 0;
          if(ends[2]>=biggest4579){
            biggest4579=ends[2];
          }
          if(ends[3]>=biggest4579){
            biggest4579=ends[3];
          }
          if(ends[4]>=biggest4579){
            biggest4579=ends[4];
          }
          if(biggest4579 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          filler1_1.setClear();//sysj\FillerPlant.sysj line: 14, column: 2
          filler2_1.setClear();//sysj\FillerPlant.sysj line: 14, column: 2
          filler2Complete_1.setClear();//sysj\FillerPlant.sysj line: 14, column: 2
          filler1Complete_1.setClear();//sysj\FillerPlant.sysj line: 14, column: 2
          currentFiller_1.setClear();//sysj\FillerPlant.sysj line: 15, column: 2
          fillerIdle_1.setClear();//sysj\FillerPlant.sysj line: 16, column: 2
          bottleAtPos2_1.setClear();//sysj\FillerPlant.sysj line: 16, column: 2
          thread4580(tdone,ends);
          thread4581(tdone,ends);
          thread4582(tdone,ends);
          int biggest4590 = 0;
          if(ends[2]>=biggest4590){
            biggest4590=ends[2];
          }
          if(ends[3]>=biggest4590){
            biggest4590=ends[3];
          }
          if(ends[4]>=biggest4590){
            biggest4590=ends[4];
          }
          if(biggest4590 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest4590 == 0){
            S4567=0;
            active[1]=0;
            ends[1]=0;
            S4567=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    filler1_1 = new Signal();
    filler2_1 = new Signal();
    filler2Complete_1 = new Signal();
    filler1Complete_1 = new Signal();
    currentFiller_1 = new Signal();
    fillerIdle_1 = new Signal();
    bottleAtPos2_1 = new Signal();
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
          enableFP.gethook();
          valveInjectorOn.gethook();
          valveInletOn.gethook();
          dosUnitValveRetract.gethook();
          dosUnitValveExtend.gethook();
          LiquidAmount1FP.gethook();
          LiquidAmount2FP.gethook();
          df = true;
        }
        runClockDomain();
      }
      enableFP.setpreclear();
      valveInjectorOn.setpreclear();
      valveInletOn.setpreclear();
      dosUnitValveRetract.setpreclear();
      dosUnitValveExtend.setpreclear();
      LiquidAmount1FP.setpreclear();
      LiquidAmount2FP.setpreclear();
      dosUnitEvac.setpreclear();
      dosUnitFilled.setpreclear();
      fillersCompleteGUI.setpreclear();
      filler1OnGUI.setpreclear();
      filler2OnGUI.setpreclear();
      filler1InletGUI.setpreclear();
      filler2InletGUI.setpreclear();
      fillerIdleGUI.setpreclear();
      bottleAtPos2GUI.setpreclear();
      filler1_1.setpreclear();
      filler2_1.setpreclear();
      filler2Complete_1.setpreclear();
      filler1Complete_1.setpreclear();
      currentFiller_1.setpreclear();
      fillerIdle_1.setpreclear();
      bottleAtPos2_1.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = enableFP.getStatus() ? enableFP.setprepresent() : enableFP.setpreclear();
      enableFP.setpreval(enableFP.getValue());
      enableFP.setClear();
      dummyint = valveInjectorOn.getStatus() ? valveInjectorOn.setprepresent() : valveInjectorOn.setpreclear();
      valveInjectorOn.setpreval(valveInjectorOn.getValue());
      valveInjectorOn.setClear();
      dummyint = valveInletOn.getStatus() ? valveInletOn.setprepresent() : valveInletOn.setpreclear();
      valveInletOn.setpreval(valveInletOn.getValue());
      valveInletOn.setClear();
      dummyint = dosUnitValveRetract.getStatus() ? dosUnitValveRetract.setprepresent() : dosUnitValveRetract.setpreclear();
      dosUnitValveRetract.setpreval(dosUnitValveRetract.getValue());
      dosUnitValveRetract.setClear();
      dummyint = dosUnitValveExtend.getStatus() ? dosUnitValveExtend.setprepresent() : dosUnitValveExtend.setpreclear();
      dosUnitValveExtend.setpreval(dosUnitValveExtend.getValue());
      dosUnitValveExtend.setClear();
      dummyint = LiquidAmount1FP.getStatus() ? LiquidAmount1FP.setprepresent() : LiquidAmount1FP.setpreclear();
      LiquidAmount1FP.setpreval(LiquidAmount1FP.getValue());
      LiquidAmount1FP.setClear();
      dummyint = LiquidAmount2FP.getStatus() ? LiquidAmount2FP.setprepresent() : LiquidAmount2FP.setpreclear();
      LiquidAmount2FP.setpreval(LiquidAmount2FP.getValue());
      LiquidAmount2FP.setClear();
      dosUnitEvac.sethook();
      dosUnitEvac.setClear();
      dosUnitFilled.sethook();
      dosUnitFilled.setClear();
      fillersCompleteGUI.sethook();
      fillersCompleteGUI.setClear();
      filler1OnGUI.sethook();
      filler1OnGUI.setClear();
      filler2OnGUI.sethook();
      filler2OnGUI.setClear();
      filler1InletGUI.sethook();
      filler1InletGUI.setClear();
      filler2InletGUI.sethook();
      filler2InletGUI.setClear();
      fillerIdleGUI.sethook();
      fillerIdleGUI.setClear();
      bottleAtPos2GUI.sethook();
      bottleAtPos2GUI.setClear();
      filler1_1.setClear();
      filler2_1.setClear();
      filler2Complete_1.setClear();
      filler1Complete_1.setClear();
      currentFiller_1.setClear();
      fillerIdle_1.setClear();
      bottleAtPos2_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        enableFP.gethook();
        valveInjectorOn.gethook();
        valveInletOn.gethook();
        dosUnitValveRetract.gethook();
        dosUnitValveExtend.gethook();
        LiquidAmount1FP.gethook();
        LiquidAmount2FP.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
