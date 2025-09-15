import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

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
  private Signal filler1_1;
  private Signal filler2_1;
  private Signal filler2Complete_1;
  private Signal filler1Complete_1;
  private Signal currentFiller_1;
  private int S2784 = 1;
  private int S2404 = 1;
  private int S2401 = 1;
  private int S2102 = 1;
  private int S2441 = 1;
  
  private int[] ends = new int[4];
  private int[] tdone = new int[4];
  
  public void thread2790(int [] tdone, int [] ends){
        switch(S2441){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        if((Integer)(currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) == 2){//sysj\FillerPlant.sysj line: 68, column: 7
          filler2_1.setPresent();//sysj\FillerPlant.sysj line: 69, column: 4
          currsigs.addElement(filler2_1);
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        else {
          if((Integer)(currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) == 1){//sysj\FillerPlant.sysj line: 70, column: 15
            filler1_1.setPresent();//sysj\FillerPlant.sysj line: 71, column: 5
            currsigs.addElement(filler1_1);
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
          }
          else {
            filler2Complete_1.setPresent();//sysj\FillerPlant.sysj line: 73, column: 5
            currsigs.addElement(filler2Complete_1);
            currentFiller_1.setPresent();//sysj\FillerPlant.sysj line: 74, column: 5
            currsigs.addElement(currentFiller_1);
            currentFiller_1.setValue(1);//sysj\FillerPlant.sysj line: 74, column: 5
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
          }
        }
        break;
      
    }
  }

  public void thread2789(int [] tdone, int [] ends){
        switch(S2404){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(filler2Complete_1.getprestatus()){//sysj\FillerPlant.sysj line: 13, column: 8
          System.out.println("all fillers complete");//sysj\FillerPlant.sysj line: 62, column: 2
          S2404=0;
          active[2]=0;
          ends[2]=0;
          tdone[2]=1;
        }
        else {
          switch(S2401){
            case 0 : 
              S2401=0;
              S2401=1;
              S2102=0;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
              break;
            
            case 1 : 
              switch(S2102){
                case 0 : 
                  if(valveInjectorOn.getprestatus() && enableFP.getprestatus()){//sysj\FillerPlant.sysj line: 18, column: 10
                    System.out.println("starting filler " + (Integer)(currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()));//sysj\FillerPlant.sysj line: 19, column: 4
                    S2102=1;
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
                
                case 1 : 
                  if(!enableFP.getprestatus()){//sysj\FillerPlant.sysj line: 24, column: 10
                    S2102=2;
                    if(dosUnitValveRetract.getprestatus()){//sysj\FillerPlant.sysj line: 27, column: 14
                      System.out.println("reached here 1");//sysj\FillerPlant.sysj line: 28, column: 7
                      dosUnitFilled.setPresent();//sysj\FillerPlant.sysj line: 29, column: 7
                      currsigs.addElement(dosUnitFilled);
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      System.out.println("left abort 1");//sysj\FillerPlant.sysj line: 32, column: 4
                      S2102=3;
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
                  if(dosUnitValveExtend.getprestatus() && enableFP.getprestatus()){//sysj\FillerPlant.sysj line: 26, column: 10
                    System.out.println("left abort 1");//sysj\FillerPlant.sysj line: 32, column: 4
                    S2102=3;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    dosUnitFilled.setPresent();//sysj\FillerPlant.sysj line: 29, column: 7
                    currsigs.addElement(dosUnitFilled);
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  break;
                
                case 3 : 
                  if(!enableFP.getprestatus()){//sysj\FillerPlant.sysj line: 35, column: 10
                    S2102=4;
                    if(dosUnitValveExtend.getprestatus()){//sysj\FillerPlant.sysj line: 38, column: 14
                      System.out.println("reached here 2");//sysj\FillerPlant.sysj line: 39, column: 7
                      dosUnitEvac.setPresent();//sysj\FillerPlant.sysj line: 40, column: 7
                      currsigs.addElement(dosUnitEvac);
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      System.out.println("left abort 2");//sysj\FillerPlant.sysj line: 43, column: 4
                      S2102=5;
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
                  if(!valveInletOn.getprestatus() && enableFP.getprestatus()){//sysj\FillerPlant.sysj line: 37, column: 10
                    System.out.println("left abort 2");//sysj\FillerPlant.sysj line: 43, column: 4
                    S2102=5;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    dosUnitEvac.setPresent();//sysj\FillerPlant.sysj line: 40, column: 7
                    currsigs.addElement(dosUnitEvac);
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  break;
                
                case 5 : 
                  if(!enableFP.getprestatus()){//sysj\FillerPlant.sysj line: 45, column: 10
                    if((Integer)(currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) == 1) {//sysj\FillerPlant.sysj line: 47, column: 38
                      System.out.println("filler 1 complete, filled " + ((Integer)(LiquidAmount1FP.getpreval() == null ? null : ((Integer)LiquidAmount1FP.getpreval()))) + "%");//sysj\FillerPlant.sysj line: 48, column: 5
                    }
                    else {//sysj\FillerPlant.sysj line: 47, column: 4
                      if((Integer)(currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) == 2) {//sysj\FillerPlant.sysj line: 50, column: 43
                        System.out.println("filler 2 complete, filled " + ((Integer)(LiquidAmount2FP.getpreval() == null ? null : ((Integer)LiquidAmount2FP.getpreval()))) + "%");//sysj\FillerPlant.sysj line: 51, column: 5
                      }
                    }
                    S2102=6;
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
                  if(enableFP.getprestatus()){//sysj\FillerPlant.sysj line: 54, column: 10
                    currentFiller_1.setPresent();//sysj\FillerPlant.sysj line: 55, column: 4
                    currsigs.addElement(currentFiller_1);
                    currentFiller_1.setValue((Integer)(currentFiller_1.getpreval() == null ? 0 : ((Integer)currentFiller_1.getpreval()).intValue()) + 1);//sysj\FillerPlant.sysj line: 55, column: 4
                    System.out.println("looped");//sysj\FillerPlant.sysj line: 56, column: 4
                    S2102=7;
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
                  if(!enableFP.getprestatus()){//sysj\FillerPlant.sysj line: 57, column: 10
                    S2102=0;
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

  public void thread2787(int [] tdone, int [] ends){
        S2441=1;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread2786(int [] tdone, int [] ends){
        S2404=1;
    S2401=0;
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
      switch(S2784){
        case 0 : 
          S2784=0;
          break RUN;
        
        case 1 : 
          S2784=2;
          S2784=2;
          filler1_1.setClear();//sysj\FillerPlant.sysj line: 7, column: 2
          filler2_1.setClear();//sysj\FillerPlant.sysj line: 7, column: 2
          filler2Complete_1.setClear();//sysj\FillerPlant.sysj line: 7, column: 2
          filler1Complete_1.setClear();//sysj\FillerPlant.sysj line: 7, column: 2
          currentFiller_1.setClear();//sysj\FillerPlant.sysj line: 8, column: 2
          currentFiller_1.setPresent();//sysj\FillerPlant.sysj line: 10, column: 2
          currsigs.addElement(currentFiller_1);
          currentFiller_1.setValue(1);//sysj\FillerPlant.sysj line: 10, column: 2
          thread2786(tdone,ends);
          thread2787(tdone,ends);
          int biggest2788 = 0;
          if(ends[2]>=biggest2788){
            biggest2788=ends[2];
          }
          if(ends[3]>=biggest2788){
            biggest2788=ends[3];
          }
          if(biggest2788 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          filler1_1.setClear();//sysj\FillerPlant.sysj line: 7, column: 2
          filler2_1.setClear();//sysj\FillerPlant.sysj line: 7, column: 2
          filler2Complete_1.setClear();//sysj\FillerPlant.sysj line: 7, column: 2
          filler1Complete_1.setClear();//sysj\FillerPlant.sysj line: 7, column: 2
          currentFiller_1.setClear();//sysj\FillerPlant.sysj line: 8, column: 2
          thread2789(tdone,ends);
          thread2790(tdone,ends);
          int biggest2791 = 0;
          if(ends[2]>=biggest2791){
            biggest2791=ends[2];
          }
          if(ends[3]>=biggest2791){
            biggest2791=ends[3];
          }
          if(biggest2791 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest2791 == 0){
            S2784=0;
            active[1]=0;
            ends[1]=0;
            S2784=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    filler1_1 = new Signal();
    filler2_1 = new Signal();
    filler2Complete_1 = new Signal();
    filler1Complete_1 = new Signal();
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
      filler1_1.setpreclear();
      filler2_1.setpreclear();
      filler2Complete_1.setpreclear();
      filler1Complete_1.setpreclear();
      currentFiller_1.setpreclear();
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
      filler1_1.setClear();
      filler2_1.setClear();
      filler2Complete_1.setClear();
      filler1Complete_1.setClear();
      currentFiller_1.setClear();
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
