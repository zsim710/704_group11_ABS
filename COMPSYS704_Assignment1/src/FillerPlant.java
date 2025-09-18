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
  public Signal valveInjectorOn = new Signal("valveInjectorOn", Signal.INPUT);
  public Signal valveInletOn = new Signal("valveInletOn", Signal.INPUT);
  public Signal dosUnitValveRetract = new Signal("dosUnitValveRetract", Signal.INPUT);
  public Signal dosUnitValveExtend = new Signal("dosUnitValveExtend", Signal.INPUT);
  public Signal filler2Complete = new Signal("filler2Complete", Signal.INPUT);
  public Signal start = new Signal("start", Signal.INPUT);
  public Signal dosUnitEvac = new Signal("dosUnitEvac", Signal.OUTPUT);
  public Signal dosUnitFilled = new Signal("dosUnitFilled", Signal.OUTPUT);
  private int S2963 = 1;
  private int S2960 = 1;
  private int S2753 = 1;
  
  private int[] ends = new int[2];
  private int[] tdone = new int[2];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S2963){
        case 0 : 
          S2963=0;
          break RUN;
        
        case 1 : 
          S2963=2;
          S2963=2;
          if(filler2Complete.getprestatus()){//sysj\FillerPlant.sysj line: 9, column: 18
            System.out.println("all fillers complete");//sysj\FillerPlant.sysj line: 58, column: 2
            S2963=0;
            active[1]=0;
            ends[1]=0;
            S2963=0;
            break RUN;
          }
          else {
            S2960=0;
            if(start.getprestatus()){//sysj\FillerPlant.sysj line: 11, column: 19
              S2960=1;
              System.out.println("awaiting starting enable");//sysj\FillerPlant.sysj line: 16, column: 4
              S2753=0;
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
        
        case 2 : 
          if(filler2Complete.getprestatus()){//sysj\FillerPlant.sysj line: 9, column: 18
            System.out.println("all fillers complete");//sysj\FillerPlant.sysj line: 58, column: 2
            S2963=0;
            active[1]=0;
            ends[1]=0;
            S2963=0;
            break RUN;
          }
          else {
            switch(S2960){
              case 0 : 
                if(start.getprestatus()){//sysj\FillerPlant.sysj line: 11, column: 19
                  S2960=1;
                  System.out.println("awaiting starting enable");//sysj\FillerPlant.sysj line: 16, column: 4
                  S2753=0;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
                else {
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              
              case 1 : 
                switch(S2753){
                  case 0 : 
                    S2753=0;
                    System.out.println("completed starting enable");//sysj\FillerPlant.sysj line: 18, column: 4
                    S2753=1;
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  
                  case 1 : 
                    if(valveInjectorOn.getprestatus()){//sysj\FillerPlant.sysj line: 21, column: 10
                      System.out.println("awaiting disable 1");//sysj\FillerPlant.sysj line: 27, column: 4
                      System.out.println("completed disable 1");//sysj\FillerPlant.sysj line: 28, column: 4
                      System.out.println("awaiting enable 2");//sysj\FillerPlant.sysj line: 30, column: 4
                      S2753=2;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  
                  case 2 : 
                    S2753=2;
                    System.out.println("completed enable 2");//sysj\FillerPlant.sysj line: 32, column: 4
                    S2753=3;
                    if(dosUnitValveRetract.getprestatus()){//sysj\FillerPlant.sysj line: 35, column: 14
                      dosUnitFilled.setPresent();//sysj\FillerPlant.sysj line: 36, column: 7
                      currsigs.addElement(dosUnitFilled);
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      System.out.println("completed disable 2");//sysj\FillerPlant.sysj line: 40, column: 4
                      System.out.println("waiting 2s");//sysj\FillerPlant.sysj line: 41, column: 4
                      S2753=4;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  
                  case 3 : 
                    if(dosUnitValveExtend.getprestatus()){//sysj\FillerPlant.sysj line: 34, column: 10
                      System.out.println("completed disable 2");//sysj\FillerPlant.sysj line: 40, column: 4
                      System.out.println("waiting 2s");//sysj\FillerPlant.sysj line: 41, column: 4
                      S2753=4;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      dosUnitFilled.setPresent();//sysj\FillerPlant.sysj line: 36, column: 7
                      currsigs.addElement(dosUnitFilled);
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  
                  case 4 : 
                    S2753=4;
                    S2753=5;
                    if(dosUnitValveExtend.getprestatus()){//sysj\FillerPlant.sysj line: 44, column: 14
                      dosUnitEvac.setPresent();//sysj\FillerPlant.sysj line: 45, column: 7
                      currsigs.addElement(dosUnitEvac);
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      System.out.println("completed disable 3");//sysj\FillerPlant.sysj line: 49, column: 4
                      System.out.println("waiting 2s");//sysj\FillerPlant.sysj line: 51, column: 4
                      S2753=6;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  
                  case 5 : 
                    if(!valveInletOn.getprestatus()){//sysj\FillerPlant.sysj line: 43, column: 10
                      System.out.println("completed disable 3");//sysj\FillerPlant.sysj line: 49, column: 4
                      System.out.println("waiting 2s");//sysj\FillerPlant.sysj line: 51, column: 4
                      S2753=6;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      dosUnitEvac.setPresent();//sysj\FillerPlant.sysj line: 45, column: 7
                      currsigs.addElement(dosUnitEvac);
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  
                  case 6 : 
                    S2753=6;
                    System.out.println("looped");//sysj\FillerPlant.sysj line: 54, column: 4
                    System.out.println("awaiting starting enable");//sysj\FillerPlant.sysj line: 16, column: 4
                    S2753=0;
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  
                }
                break;
              
            }
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1};
    char [] paused1 = {0, 0};
    char [] suspended1 = {0, 0};
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
          valveInjectorOn.gethook();
          valveInletOn.gethook();
          dosUnitValveRetract.gethook();
          dosUnitValveExtend.gethook();
          filler2Complete.gethook();
          start.gethook();
          df = true;
        }
        runClockDomain();
      }
      valveInjectorOn.setpreclear();
      valveInletOn.setpreclear();
      dosUnitValveRetract.setpreclear();
      dosUnitValveExtend.setpreclear();
      filler2Complete.setpreclear();
      start.setpreclear();
      dosUnitEvac.setpreclear();
      dosUnitFilled.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
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
      dummyint = filler2Complete.getStatus() ? filler2Complete.setprepresent() : filler2Complete.setpreclear();
      filler2Complete.setpreval(filler2Complete.getValue());
      filler2Complete.setClear();
      dummyint = start.getStatus() ? start.setprepresent() : start.setpreclear();
      start.setpreval(start.getValue());
      start.setClear();
      dosUnitEvac.sethook();
      dosUnitEvac.setClear();
      dosUnitFilled.sethook();
      dosUnitFilled.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        valveInjectorOn.gethook();
        valveInletOn.gethook();
        dosUnitValveRetract.gethook();
        dosUnitValveExtend.gethook();
        filler2Complete.gethook();
        start.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
