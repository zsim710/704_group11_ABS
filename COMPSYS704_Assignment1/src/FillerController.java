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
  private int S2729 = 1;
  private int S2671 = 1;
  private int S2112 = 1;
  private int S2120 = 1;
  private int S2128 = 1;
  private int S2154 = 1;
  private int S2162 = 1;
  private int S2727 = 1;
  
  private int[] ends = new int[8];
  private int[] tdone = new int[8];
  
  public void thread2750(int [] tdone, int [] ends){
        switch(S2727){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        if((Integer)(currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) == 2){//sysj\FillerController.sysj line: 85, column: 8
          filler2_1.setPresent();//sysj\FillerController.sysj line: 86, column: 5
          currsigs.addElement(filler2_1);
          active[7]=1;
          ends[7]=1;
          tdone[7]=1;
        }
        else {
          if((Integer)(currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) == 1){//sysj\FillerController.sysj line: 87, column: 16
            filler1_1.setPresent();//sysj\FillerController.sysj line: 88, column: 6
            currsigs.addElement(filler1_1);
            active[7]=1;
            ends[7]=1;
            tdone[7]=1;
          }
          else {
            if((Integer)(currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) == 3){//sysj\FillerController.sysj line: 89, column: 15
              filler2Complete.setPresent();//sysj\FillerController.sysj line: 90, column: 6
              currsigs.addElement(filler2Complete);
              filler2CompleteLocal_1.setPresent();//sysj\FillerController.sysj line: 91, column: 6
              currsigs.addElement(filler2CompleteLocal_1);
              currentFiller_1.setPresent();//sysj\FillerController.sysj line: 93, column: 6
              currsigs.addElement(currentFiller_1);
              currentFiller_1.setValue(1);//sysj\FillerController.sysj line: 93, column: 6
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

  public void thread2748(int [] tdone, int [] ends){
        switch(S2162){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        dosUnitValveExtend.setPresent();//sysj\FillerController.sysj line: 64, column: 6
        currsigs.addElement(dosUnitValveExtend);
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
        break;
      
    }
  }

  public void thread2747(int [] tdone, int [] ends){
        switch(S2154){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        valveInletOn.setPresent();//sysj\FillerController.sysj line: 59, column: 6
        currsigs.addElement(valveInletOn);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread2745(int [] tdone, int [] ends){
        S2162=1;
    System.out.println("brings pressire canister down");//sysj\FillerController.sysj line: 63, column: 6
    dosUnitValveExtend.setPresent();//sysj\FillerController.sysj line: 64, column: 6
    currsigs.addElement(dosUnitValveExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread2744(int [] tdone, int [] ends){
        S2154=1;
    System.out.println("toggles valve inlet");//sysj\FillerController.sysj line: 58, column: 6
    valveInletOn.setPresent();//sysj\FillerController.sysj line: 59, column: 6
    currsigs.addElement(valveInletOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread2742(int [] tdone, int [] ends){
        switch(S2128){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        dosUnitValveRetract.setPresent();//sysj\FillerController.sysj line: 52, column: 6
        currsigs.addElement(dosUnitValveRetract);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread2741(int [] tdone, int [] ends){
        switch(S2120){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        valveInjectorOn.setPresent();//sysj\FillerController.sysj line: 47, column: 6
        currsigs.addElement(valveInjectorOn);
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
        break;
      
    }
  }

  public void thread2739(int [] tdone, int [] ends){
        S2162=1;
    System.out.println("brings pressire canister down");//sysj\FillerController.sysj line: 63, column: 6
    dosUnitValveExtend.setPresent();//sysj\FillerController.sysj line: 64, column: 6
    currsigs.addElement(dosUnitValveExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread2738(int [] tdone, int [] ends){
        S2154=1;
    System.out.println("toggles valve inlet");//sysj\FillerController.sysj line: 58, column: 6
    valveInletOn.setPresent();//sysj\FillerController.sysj line: 59, column: 6
    currsigs.addElement(valveInletOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread2736(int [] tdone, int [] ends){
        S2128=1;
    System.out.println("brings pressure canister up");//sysj\FillerController.sysj line: 51, column: 6
    dosUnitValveRetract.setPresent();//sysj\FillerController.sysj line: 52, column: 6
    currsigs.addElement(dosUnitValveRetract);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread2735(int [] tdone, int [] ends){
        S2120=1;
    System.out.println("toggles valve injector");//sysj\FillerController.sysj line: 46, column: 6
    valveInjectorOn.setPresent();//sysj\FillerController.sysj line: 47, column: 6
    currsigs.addElement(valveInjectorOn);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread2734(int [] tdone, int [] ends){
        switch(S2671){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(filler2CompleteLocal_1.getprestatus()){//sysj\FillerController.sysj line: 14, column: 19
          S2671=0;
          active[2]=0;
          ends[2]=0;
          tdone[2]=1;
        }
        else {
          switch(S2112){
            case 0 : 
              if(bottleAtPos2.getprestatus()){//sysj\FillerController.sysj line: 17, column: 21
                System.out.println("no longer emitting filler ready");//sysj\FillerController.sysj line: 21, column: 5
                S2112=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                fillerReady.setPresent();//sysj\FillerController.sysj line: 19, column: 6
                currsigs.addElement(fillerReady);
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              break;
            
            case 1 : 
              S2112=1;
              System.out.println("awaiting starting start signal");//sysj\FillerController.sysj line: 24, column: 5
              start.setPresent();//sysj\FillerController.sysj line: 26, column: 5
              currsigs.addElement(start);
              if((Integer)(currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) == 1) {//sysj\FillerController.sysj line: 28, column: 39
                System.out.println("filler 1 start, filled " + ((Integer)(LiquidAmount1FC.getpreval() == null ? null : ((Integer)LiquidAmount1FC.getpreval()))) + "%");//sysj\FillerController.sysj line: 29, column: 6
              }
              else {//sysj\FillerController.sysj line: 28, column: 5
                if((Integer)(currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) == 2) {//sysj\FillerController.sysj line: 31, column: 44
                  System.out.println("filler 2 start, filled " + ((Integer)(LiquidAmount2FC.getpreval() == null ? null : ((Integer)LiquidAmount2FC.getpreval()))) + "%");//sysj\FillerController.sysj line: 32, column: 6
                }
                else {//sysj\FillerController.sysj line: 33, column: 11
                  System.out.println("filler 1 start, filled " + ((Integer)(LiquidAmount1FC.getpreval() == null ? null : ((Integer)LiquidAmount1FC.getpreval()))) + "%");//sysj\FillerController.sysj line: 34, column: 6
                }
              }
              S2112=2;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
              break;
            
            case 2 : 
              S2112=2;
              S2112=3;
              thread2735(tdone,ends);
              thread2736(tdone,ends);
              int biggest2737 = 0;
              if(ends[3]>=biggest2737){
                biggest2737=ends[3];
              }
              if(ends[4]>=biggest2737){
                biggest2737=ends[4];
              }
              if(biggest2737 == 1){
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              break;
            
            case 3 : 
              if(dosUnitFilled.getprestatus()){//sysj\FillerController.sysj line: 44, column: 11
                S2112=4;
                thread2738(tdone,ends);
                thread2739(tdone,ends);
                int biggest2740 = 0;
                if(ends[5]>=biggest2740){
                  biggest2740=ends[5];
                }
                if(ends[6]>=biggest2740){
                  biggest2740=ends[6];
                }
                if(biggest2740 == 1){
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
              }
              else {
                thread2741(tdone,ends);
                thread2742(tdone,ends);
                int biggest2743 = 0;
                if(ends[3]>=biggest2743){
                  biggest2743=ends[3];
                }
                if(ends[4]>=biggest2743){
                  biggest2743=ends[4];
                }
                if(biggest2743 == 1){
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                //FINXME code
                if(biggest2743 == 0){
                  S2112=4;
                  thread2744(tdone,ends);
                  thread2745(tdone,ends);
                  int biggest2746 = 0;
                  if(ends[5]>=biggest2746){
                    biggest2746=ends[5];
                  }
                  if(ends[6]>=biggest2746){
                    biggest2746=ends[6];
                  }
                  if(biggest2746 == 1){
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
              }
              break;
            
            case 4 : 
              if(dosUnitEvac.getprestatus()){//sysj\FillerController.sysj line: 56, column: 11
                System.out.println("filler is done");//sysj\FillerController.sysj line: 68, column: 5
                currentFiller_1.setPresent();//sysj\FillerController.sysj line: 70, column: 5
                currsigs.addElement(currentFiller_1);
                currentFiller_1.setValue((currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) + 1);//sysj\FillerController.sysj line: 70, column: 5
                S2112=5;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                thread2747(tdone,ends);
                thread2748(tdone,ends);
                int biggest2749 = 0;
                if(ends[5]>=biggest2749){
                  biggest2749=ends[5];
                }
                if(ends[6]>=biggest2749){
                  biggest2749=ends[6];
                }
                if(biggest2749 == 1){
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                //FINXME code
                if(biggest2749 == 0){
                  System.out.println("filler is done");//sysj\FillerController.sysj line: 68, column: 5
                  currentFiller_1.setPresent();//sysj\FillerController.sysj line: 70, column: 5
                  currsigs.addElement(currentFiller_1);
                  currentFiller_1.setValue((currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) + 1);//sysj\FillerController.sysj line: 70, column: 5
                  S2112=5;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
              }
              break;
            
            case 5 : 
              S2112=5;
              S2112=0;
              if(bottleAtPos2.getprestatus()){//sysj\FillerController.sysj line: 17, column: 21
                System.out.println("no longer emitting filler ready");//sysj\FillerController.sysj line: 21, column: 5
                S2112=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                System.out.println("emitting filler ready");//sysj\FillerController.sysj line: 18, column: 6
                fillerReady.setPresent();//sysj\FillerController.sysj line: 19, column: 6
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
  }

  public void thread2732(int [] tdone, int [] ends){
        S2727=1;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread2731(int [] tdone, int [] ends){
        S2671=1;
    currentFiller_1.setPresent();//sysj\FillerController.sysj line: 12, column: 3
    currsigs.addElement(currentFiller_1);
    currentFiller_1.setValue(1);//sysj\FillerController.sysj line: 12, column: 3
    if(filler2CompleteLocal_1.getprestatus()){//sysj\FillerController.sysj line: 14, column: 19
      S2671=0;
      active[2]=0;
      ends[2]=0;
      tdone[2]=1;
    }
    else {
      S2112=0;
      if(bottleAtPos2.getprestatus()){//sysj\FillerController.sysj line: 17, column: 21
        System.out.println("no longer emitting filler ready");//sysj\FillerController.sysj line: 21, column: 5
        S2112=1;
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        System.out.println("emitting filler ready");//sysj\FillerController.sysj line: 18, column: 6
        fillerReady.setPresent();//sysj\FillerController.sysj line: 19, column: 6
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
      switch(S2729){
        case 0 : 
          S2729=0;
          break RUN;
        
        case 1 : 
          S2729=2;
          S2729=2;
          filler2CompleteLocal_1.setClear();//sysj\FillerController.sysj line: 8, column: 2
          filler2_1.setClear();//sysj\FillerController.sysj line: 8, column: 2
          filler1_1.setClear();//sysj\FillerController.sysj line: 8, column: 2
          currentFiller_1.setClear();//sysj\FillerController.sysj line: 9, column: 2
          thread2731(tdone,ends);
          thread2732(tdone,ends);
          int biggest2733 = 0;
          if(ends[2]>=biggest2733){
            biggest2733=ends[2];
          }
          if(ends[7]>=biggest2733){
            biggest2733=ends[7];
          }
          if(biggest2733 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          filler2CompleteLocal_1.setClear();//sysj\FillerController.sysj line: 8, column: 2
          filler2_1.setClear();//sysj\FillerController.sysj line: 8, column: 2
          filler1_1.setClear();//sysj\FillerController.sysj line: 8, column: 2
          currentFiller_1.setClear();//sysj\FillerController.sysj line: 9, column: 2
          thread2734(tdone,ends);
          thread2750(tdone,ends);
          int biggest2751 = 0;
          if(ends[2]>=biggest2751){
            biggest2751=ends[2];
          }
          if(ends[7]>=biggest2751){
            biggest2751=ends[7];
          }
          if(biggest2751 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest2751 == 0){
            S2729=0;
            active[1]=0;
            ends[1]=0;
            S2729=0;
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
