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
  private Signal filler1Done_1;
  private int S2079 = 1;
  private int S1803 = 1;
  private int S1811 = 1;
  private int S1819 = 1;
  private int S1845 = 1;
  private int S1853 = 1;
  
  private int[] ends = new int[6];
  private int[] tdone = new int[6];
  
  public void thread2094(int [] tdone, int [] ends){
        switch(S1853){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        dosUnitValveExtend.setPresent();//sysj\FillerController.sysj line: 42, column: 5
        currsigs.addElement(dosUnitValveExtend);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread2093(int [] tdone, int [] ends){
        switch(S1845){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        valveInletOn.setPresent();//sysj\FillerController.sysj line: 37, column: 5
        currsigs.addElement(valveInletOn);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread2091(int [] tdone, int [] ends){
        S1853=1;
    System.out.println("brings pressire canister down");//sysj\FillerController.sysj line: 41, column: 5
    dosUnitValveExtend.setPresent();//sysj\FillerController.sysj line: 42, column: 5
    currsigs.addElement(dosUnitValveExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread2090(int [] tdone, int [] ends){
        S1845=1;
    System.out.println("toggles valve inlet");//sysj\FillerController.sysj line: 36, column: 5
    valveInletOn.setPresent();//sysj\FillerController.sysj line: 37, column: 5
    currsigs.addElement(valveInletOn);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread2088(int [] tdone, int [] ends){
        switch(S1819){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        dosUnitValveRetract.setPresent();//sysj\FillerController.sysj line: 30, column: 5
        currsigs.addElement(dosUnitValveRetract);
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
        break;
      
    }
  }

  public void thread2087(int [] tdone, int [] ends){
        switch(S1811){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        valveInjectorOn.setPresent();//sysj\FillerController.sysj line: 25, column: 5
        currsigs.addElement(valveInjectorOn);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
        break;
      
    }
  }

  public void thread2085(int [] tdone, int [] ends){
        S1853=1;
    System.out.println("brings pressire canister down");//sysj\FillerController.sysj line: 41, column: 5
    dosUnitValveExtend.setPresent();//sysj\FillerController.sysj line: 42, column: 5
    currsigs.addElement(dosUnitValveExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread2084(int [] tdone, int [] ends){
        S1845=1;
    System.out.println("toggles valve inlet");//sysj\FillerController.sysj line: 36, column: 5
    valveInletOn.setPresent();//sysj\FillerController.sysj line: 37, column: 5
    currsigs.addElement(valveInletOn);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread2082(int [] tdone, int [] ends){
        S1819=1;
    System.out.println("brings pressure canister up");//sysj\FillerController.sysj line: 29, column: 5
    dosUnitValveRetract.setPresent();//sysj\FillerController.sysj line: 30, column: 5
    currsigs.addElement(dosUnitValveRetract);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread2081(int [] tdone, int [] ends){
        S1811=1;
    System.out.println("toggles valve injector");//sysj\FillerController.sysj line: 24, column: 5
    valveInjectorOn.setPresent();//sysj\FillerController.sysj line: 25, column: 5
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
      switch(S2079){
        case 0 : 
          S2079=0;
          break RUN;
        
        case 1 : 
          S2079=2;
          S2079=2;
          filler1Done_1.setClear();//sysj\FillerController.sysj line: 6, column: 2
          S1803=0;
          fillerReady.setPresent();//sysj\FillerController.sysj line: 12, column: 5
          currsigs.addElement(fillerReady);
          active[1]=1;
          ends[1]=1;
          break RUN;
        
        case 2 : 
          filler1Done_1.setClear();//sysj\FillerController.sysj line: 6, column: 2
          switch(S1803){
            case 0 : 
              if(bottleAtPos2.getprestatus()){//sysj\FillerController.sysj line: 11, column: 10
                System.out.println("bottle at pos2 in filler");//sysj\FillerController.sysj line: 18, column: 4
                S1803=1;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                fillerReady.setPresent();//sysj\FillerController.sysj line: 12, column: 5
                currsigs.addElement(fillerReady);
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            
            case 1 : 
              S1803=1;
              S1803=2;
              thread2081(tdone,ends);
              thread2082(tdone,ends);
              int biggest2083 = 0;
              if(ends[2]>=biggest2083){
                biggest2083=ends[2];
              }
              if(ends[3]>=biggest2083){
                biggest2083=ends[3];
              }
              if(biggest2083 == 1){
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            
            case 2 : 
              if(dosUnitFilled.getprestatus()){//sysj\FillerController.sysj line: 22, column: 10
                S1803=3;
                thread2084(tdone,ends);
                thread2085(tdone,ends);
                int biggest2086 = 0;
                if(ends[4]>=biggest2086){
                  biggest2086=ends[4];
                }
                if(ends[5]>=biggest2086){
                  biggest2086=ends[5];
                }
                if(biggest2086 == 1){
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
              else {
                thread2087(tdone,ends);
                thread2088(tdone,ends);
                int biggest2089 = 0;
                if(ends[2]>=biggest2089){
                  biggest2089=ends[2];
                }
                if(ends[3]>=biggest2089){
                  biggest2089=ends[3];
                }
                if(biggest2089 == 1){
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest2089 == 0){
                  S1803=3;
                  thread2090(tdone,ends);
                  thread2091(tdone,ends);
                  int biggest2092 = 0;
                  if(ends[4]>=biggest2092){
                    biggest2092=ends[4];
                  }
                  if(ends[5]>=biggest2092){
                    biggest2092=ends[5];
                  }
                  if(biggest2092 == 1){
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                }
              }
            
            case 3 : 
              if(dosUnitEvac.getprestatus()){//sysj\FillerController.sysj line: 34, column: 10
                System.out.println("filler is done");//sysj\FillerController.sysj line: 46, column: 4
                fillerReady.setPresent();//sysj\FillerController.sysj line: 48, column: 4
                currsigs.addElement(fillerReady);
                S1803=4;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                thread2093(tdone,ends);
                thread2094(tdone,ends);
                int biggest2095 = 0;
                if(ends[4]>=biggest2095){
                  biggest2095=ends[4];
                }
                if(ends[5]>=biggest2095){
                  biggest2095=ends[5];
                }
                if(biggest2095 == 1){
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest2095 == 0){
                  System.out.println("filler is done");//sysj\FillerController.sysj line: 46, column: 4
                  fillerReady.setPresent();//sysj\FillerController.sysj line: 48, column: 4
                  currsigs.addElement(fillerReady);
                  S1803=4;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
            
            case 4 : 
              if(!bottleAtPos2.getprestatus()){//sysj\FillerController.sysj line: 49, column: 10
                S1803=0;
                fillerReady.setPresent();//sysj\FillerController.sysj line: 12, column: 5
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
    filler1Done_1 = new Signal();
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
      filler1Done_1.setpreclear();
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
      filler1Done_1.setClear();
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
