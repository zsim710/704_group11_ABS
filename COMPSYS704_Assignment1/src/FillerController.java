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
  public Signal fillerReady = new Signal("fillerReady", Signal.OUTPUT);
  public Signal valveInjectorOn = new Signal("valveInjectorOn", Signal.OUTPUT);
  public Signal valveInletOn = new Signal("valveInletOn", Signal.OUTPUT);
  public Signal dosUnitValveRetract = new Signal("dosUnitValveRetract", Signal.OUTPUT);
  public Signal dosUnitValveExtend = new Signal("dosUnitValveExtend", Signal.OUTPUT);
  private int S2897 = 1;
  private int S2621 = 1;
  private int S2629 = 1;
  private int S2637 = 1;
  private int S2663 = 1;
  private int S2671 = 1;
  
  private int[] ends = new int[6];
  private int[] tdone = new int[6];
  
  public void thread2912(int [] tdone, int [] ends){
        switch(S2671){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        dosUnitValveExtend.setPresent();//sysj\FillerController.sysj line: 38, column: 5
        currsigs.addElement(dosUnitValveExtend);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread2911(int [] tdone, int [] ends){
        switch(S2663){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        valveInletOn.setPresent();//sysj\FillerController.sysj line: 33, column: 5
        currsigs.addElement(valveInletOn);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread2909(int [] tdone, int [] ends){
        S2671=1;
    System.out.println("brings pressire canister down");//sysj\FillerController.sysj line: 37, column: 5
    dosUnitValveExtend.setPresent();//sysj\FillerController.sysj line: 38, column: 5
    currsigs.addElement(dosUnitValveExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread2908(int [] tdone, int [] ends){
        S2663=1;
    System.out.println("toggles valve inlet");//sysj\FillerController.sysj line: 32, column: 5
    valveInletOn.setPresent();//sysj\FillerController.sysj line: 33, column: 5
    currsigs.addElement(valveInletOn);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread2906(int [] tdone, int [] ends){
        switch(S2637){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        dosUnitValveRetract.setPresent();//sysj\FillerController.sysj line: 26, column: 5
        currsigs.addElement(dosUnitValveRetract);
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
        break;
      
    }
  }

  public void thread2905(int [] tdone, int [] ends){
        switch(S2629){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        valveInjectorOn.setPresent();//sysj\FillerController.sysj line: 21, column: 5
        currsigs.addElement(valveInjectorOn);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
        break;
      
    }
  }

  public void thread2903(int [] tdone, int [] ends){
        S2671=1;
    System.out.println("brings pressire canister down");//sysj\FillerController.sysj line: 37, column: 5
    dosUnitValveExtend.setPresent();//sysj\FillerController.sysj line: 38, column: 5
    currsigs.addElement(dosUnitValveExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread2902(int [] tdone, int [] ends){
        S2663=1;
    System.out.println("toggles valve inlet");//sysj\FillerController.sysj line: 32, column: 5
    valveInletOn.setPresent();//sysj\FillerController.sysj line: 33, column: 5
    currsigs.addElement(valveInletOn);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread2900(int [] tdone, int [] ends){
        S2637=1;
    System.out.println("brings pressure canister up");//sysj\FillerController.sysj line: 25, column: 5
    dosUnitValveRetract.setPresent();//sysj\FillerController.sysj line: 26, column: 5
    currsigs.addElement(dosUnitValveRetract);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread2899(int [] tdone, int [] ends){
        S2629=1;
    System.out.println("toggles valve injector");//sysj\FillerController.sysj line: 20, column: 5
    valveInjectorOn.setPresent();//sysj\FillerController.sysj line: 21, column: 5
    currsigs.addElement(valveInjectorOn);
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
      switch(S2897){
        case 0 : 
          S2897=0;
          break RUN;
        
        case 1 : 
          S2897=2;
          S2897=2;
          S2621=0;
          fillerReady.setPresent();//sysj\FillerController.sysj line: 10, column: 5
          currsigs.addElement(fillerReady);
          active[1]=1;
          ends[1]=1;
          break RUN;
        
        case 2 : 
          switch(S2621){
            case 0 : 
              if(bottleAtPos2.getprestatus()){//sysj\FillerController.sysj line: 9, column: 10
                System.out.println("bottle at pos2 in filler");//sysj\FillerController.sysj line: 14, column: 4
                S2621=1;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                fillerReady.setPresent();//sysj\FillerController.sysj line: 10, column: 5
                currsigs.addElement(fillerReady);
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            
            case 1 : 
              S2621=1;
              S2621=2;
              thread2899(tdone,ends);
              thread2900(tdone,ends);
              int biggest2901 = 0;
              if(ends[2]>=biggest2901){
                biggest2901=ends[2];
              }
              if(ends[3]>=biggest2901){
                biggest2901=ends[3];
              }
              if(biggest2901 == 1){
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            
            case 2 : 
              if(dosUnitFilled.getprestatus()){//sysj\FillerController.sysj line: 18, column: 10
                S2621=3;
                thread2902(tdone,ends);
                thread2903(tdone,ends);
                int biggest2904 = 0;
                if(ends[4]>=biggest2904){
                  biggest2904=ends[4];
                }
                if(ends[5]>=biggest2904){
                  biggest2904=ends[5];
                }
                if(biggest2904 == 1){
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
              else {
                thread2905(tdone,ends);
                thread2906(tdone,ends);
                int biggest2907 = 0;
                if(ends[2]>=biggest2907){
                  biggest2907=ends[2];
                }
                if(ends[3]>=biggest2907){
                  biggest2907=ends[3];
                }
                if(biggest2907 == 1){
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest2907 == 0){
                  S2621=3;
                  thread2908(tdone,ends);
                  thread2909(tdone,ends);
                  int biggest2910 = 0;
                  if(ends[4]>=biggest2910){
                    biggest2910=ends[4];
                  }
                  if(ends[5]>=biggest2910){
                    biggest2910=ends[5];
                  }
                  if(biggest2910 == 1){
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                }
              }
            
            case 3 : 
              if(dosUnitEvac.getprestatus()){//sysj\FillerController.sysj line: 30, column: 10
                System.out.println("filler is done");//sysj\FillerController.sysj line: 42, column: 4
                fillerReady.setPresent();//sysj\FillerController.sysj line: 44, column: 4
                currsigs.addElement(fillerReady);
                S2621=4;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                thread2911(tdone,ends);
                thread2912(tdone,ends);
                int biggest2913 = 0;
                if(ends[4]>=biggest2913){
                  biggest2913=ends[4];
                }
                if(ends[5]>=biggest2913){
                  biggest2913=ends[5];
                }
                if(biggest2913 == 1){
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest2913 == 0){
                  System.out.println("filler is done");//sysj\FillerController.sysj line: 42, column: 4
                  fillerReady.setPresent();//sysj\FillerController.sysj line: 44, column: 4
                  currsigs.addElement(fillerReady);
                  S2621=4;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
            
            case 4 : 
              if(!bottleAtPos2.getprestatus()){//sysj\FillerController.sysj line: 45, column: 10
                S2621=0;
                fillerReady.setPresent();//sysj\FillerController.sysj line: 10, column: 5
                currsigs.addElement(fillerReady);
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
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
          df = true;
        }
        runClockDomain();
      }
      bottleAtPos2.setpreclear();
      dosUnitEvac.setpreclear();
      dosUnitFilled.setpreclear();
      fillerReady.setpreclear();
      valveInjectorOn.setpreclear();
      valveInletOn.setpreclear();
      dosUnitValveRetract.setpreclear();
      dosUnitValveExtend.setpreclear();
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
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        bottleAtPos2.gethook();
        dosUnitEvac.gethook();
        dosUnitFilled.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
