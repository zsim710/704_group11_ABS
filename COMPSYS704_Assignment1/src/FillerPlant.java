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
  private int S6609 = 1;
  private int S5537 = 1;
  private int S5535 = 1;
  private int S5006 = 1;
  
  private int[] ends = new int[2];
  private int[] tdone = new int[2];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S6609){
        case 0 : 
          S6609=0;
          break RUN;
        
        case 1 : 
          S6609=2;
          S6609=2;
          S5537=0;
          if(filler2Complete.getprestatus()){//sysj\FillerPlant.sysj line: 10, column: 19
            System.out.println("all fillers complete");//sysj\FillerPlant.sysj line: 45, column: 3
            S5537=1;
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          else {
            S5535=0;
            if(start.getprestatus()){//sysj\FillerPlant.sysj line: 12, column: 20
              S5535=1;
              System.out.println("recieved start");//sysj\FillerPlant.sysj line: 16, column: 5
              S5006=0;
              if(valveInjectorOn.getprestatus()){//sysj\FillerPlant.sysj line: 19, column: 21
                System.out.println("received valveInjectorOn");//sysj\FillerPlant.sysj line: 21, column: 5
                S5006=1;
                if(dosUnitValveExtend.getprestatus()){//sysj\FillerPlant.sysj line: 23, column: 21
                  System.out.println("aborted dosUnitFilled");//sysj\FillerPlant.sysj line: 29, column: 5
                  S5006=2;
                  if(!valveInletOn.getprestatus()){//sysj\FillerPlant.sysj line: 31, column: 21
                    System.out.println("aborted dosUnitEvac");//sysj\FillerPlant.sysj line: 37, column: 5
                    S5006=3;
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  else {
                    System.out.println("sustaining dosUnitEvac");//sysj\FillerPlant.sysj line: 33, column: 7
                    dosUnitEvac.setPresent();//sysj\FillerPlant.sysj line: 34, column: 7
                    currsigs.addElement(dosUnitEvac);
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                }
                else {
                  System.out.println("sustaining dosUnitFilled");//sysj\FillerPlant.sysj line: 25, column: 6
                  dosUnitFilled.setPresent();//sysj\FillerPlant.sysj line: 26, column: 6
                  currsigs.addElement(dosUnitFilled);
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
              else {
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            }
            else {
              active[1]=1;
              ends[1]=1;
              break RUN;
            }
          }
        
        case 2 : 
          switch(S5537){
            case 0 : 
              if(filler2Complete.getprestatus()){//sysj\FillerPlant.sysj line: 10, column: 19
                System.out.println("all fillers complete");//sysj\FillerPlant.sysj line: 45, column: 3
                S5537=1;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                switch(S5535){
                  case 0 : 
                    if(start.getprestatus()){//sysj\FillerPlant.sysj line: 12, column: 20
                      S5535=1;
                      System.out.println("recieved start");//sysj\FillerPlant.sysj line: 16, column: 5
                      S5006=0;
                      if(valveInjectorOn.getprestatus()){//sysj\FillerPlant.sysj line: 19, column: 21
                        System.out.println("received valveInjectorOn");//sysj\FillerPlant.sysj line: 21, column: 5
                        S5006=1;
                        if(dosUnitValveExtend.getprestatus()){//sysj\FillerPlant.sysj line: 23, column: 21
                          System.out.println("aborted dosUnitFilled");//sysj\FillerPlant.sysj line: 29, column: 5
                          S5006=2;
                          if(!valveInletOn.getprestatus()){//sysj\FillerPlant.sysj line: 31, column: 21
                            System.out.println("aborted dosUnitEvac");//sysj\FillerPlant.sysj line: 37, column: 5
                            S5006=3;
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            System.out.println("sustaining dosUnitEvac");//sysj\FillerPlant.sysj line: 33, column: 7
                            dosUnitEvac.setPresent();//sysj\FillerPlant.sysj line: 34, column: 7
                            currsigs.addElement(dosUnitEvac);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          System.out.println("sustaining dosUnitFilled");//sysj\FillerPlant.sysj line: 25, column: 6
                          dosUnitFilled.setPresent();//sysj\FillerPlant.sysj line: 26, column: 6
                          currsigs.addElement(dosUnitFilled);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                    }
                    else {
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  
                  case 1 : 
                    switch(S5006){
                      case 0 : 
                        if(valveInjectorOn.getprestatus()){//sysj\FillerPlant.sysj line: 19, column: 21
                          System.out.println("received valveInjectorOn");//sysj\FillerPlant.sysj line: 21, column: 5
                          S5006=1;
                          if(dosUnitValveExtend.getprestatus()){//sysj\FillerPlant.sysj line: 23, column: 21
                            System.out.println("aborted dosUnitFilled");//sysj\FillerPlant.sysj line: 29, column: 5
                            S5006=2;
                            if(!valveInletOn.getprestatus()){//sysj\FillerPlant.sysj line: 31, column: 21
                              System.out.println("aborted dosUnitEvac");//sysj\FillerPlant.sysj line: 37, column: 5
                              S5006=3;
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                            else {
                              System.out.println("sustaining dosUnitEvac");//sysj\FillerPlant.sysj line: 33, column: 7
                              dosUnitEvac.setPresent();//sysj\FillerPlant.sysj line: 34, column: 7
                              currsigs.addElement(dosUnitEvac);
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                          }
                          else {
                            System.out.println("sustaining dosUnitFilled");//sysj\FillerPlant.sysj line: 25, column: 6
                            dosUnitFilled.setPresent();//sysj\FillerPlant.sysj line: 26, column: 6
                            currsigs.addElement(dosUnitFilled);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      
                      case 1 : 
                        if(dosUnitValveExtend.getprestatus()){//sysj\FillerPlant.sysj line: 23, column: 21
                          System.out.println("aborted dosUnitFilled");//sysj\FillerPlant.sysj line: 29, column: 5
                          S5006=2;
                          if(!valveInletOn.getprestatus()){//sysj\FillerPlant.sysj line: 31, column: 21
                            System.out.println("aborted dosUnitEvac");//sysj\FillerPlant.sysj line: 37, column: 5
                            S5006=3;
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            System.out.println("sustaining dosUnitEvac");//sysj\FillerPlant.sysj line: 33, column: 7
                            dosUnitEvac.setPresent();//sysj\FillerPlant.sysj line: 34, column: 7
                            currsigs.addElement(dosUnitEvac);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          dosUnitFilled.setPresent();//sysj\FillerPlant.sysj line: 26, column: 6
                          currsigs.addElement(dosUnitFilled);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      
                      case 2 : 
                        if(!valveInletOn.getprestatus()){//sysj\FillerPlant.sysj line: 31, column: 21
                          System.out.println("aborted dosUnitEvac");//sysj\FillerPlant.sysj line: 37, column: 5
                          S5006=3;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          dosUnitEvac.setPresent();//sysj\FillerPlant.sysj line: 34, column: 7
                          currsigs.addElement(dosUnitEvac);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      
                      case 3 : 
                        S5006=3;
                        System.out.println("looped");//sysj\FillerPlant.sysj line: 41, column: 5
                        System.out.println("recieved start");//sysj\FillerPlant.sysj line: 16, column: 5
                        S5006=0;
                        if(valveInjectorOn.getprestatus()){//sysj\FillerPlant.sysj line: 19, column: 21
                          System.out.println("received valveInjectorOn");//sysj\FillerPlant.sysj line: 21, column: 5
                          S5006=1;
                          if(dosUnitValveExtend.getprestatus()){//sysj\FillerPlant.sysj line: 23, column: 21
                            System.out.println("aborted dosUnitFilled");//sysj\FillerPlant.sysj line: 29, column: 5
                            S5006=2;
                            if(!valveInletOn.getprestatus()){//sysj\FillerPlant.sysj line: 31, column: 21
                              System.out.println("aborted dosUnitEvac");//sysj\FillerPlant.sysj line: 37, column: 5
                              S5006=3;
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                            else {
                              System.out.println("sustaining dosUnitEvac");//sysj\FillerPlant.sysj line: 33, column: 7
                              dosUnitEvac.setPresent();//sysj\FillerPlant.sysj line: 34, column: 7
                              currsigs.addElement(dosUnitEvac);
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                          }
                          else {
                            System.out.println("sustaining dosUnitFilled");//sysj\FillerPlant.sysj line: 25, column: 6
                            dosUnitFilled.setPresent();//sysj\FillerPlant.sysj line: 26, column: 6
                            currsigs.addElement(dosUnitFilled);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      
                    }
                    break;
                  
                }
              }
              break;
            
            case 1 : 
              S5537=1;
              S5537=0;
              if(filler2Complete.getprestatus()){//sysj\FillerPlant.sysj line: 10, column: 19
                System.out.println("all fillers complete");//sysj\FillerPlant.sysj line: 45, column: 3
                S5537=1;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                S5535=0;
                if(start.getprestatus()){//sysj\FillerPlant.sysj line: 12, column: 20
                  S5535=1;
                  System.out.println("recieved start");//sysj\FillerPlant.sysj line: 16, column: 5
                  S5006=0;
                  if(valveInjectorOn.getprestatus()){//sysj\FillerPlant.sysj line: 19, column: 21
                    System.out.println("received valveInjectorOn");//sysj\FillerPlant.sysj line: 21, column: 5
                    S5006=1;
                    if(dosUnitValveExtend.getprestatus()){//sysj\FillerPlant.sysj line: 23, column: 21
                      System.out.println("aborted dosUnitFilled");//sysj\FillerPlant.sysj line: 29, column: 5
                      S5006=2;
                      if(!valveInletOn.getprestatus()){//sysj\FillerPlant.sysj line: 31, column: 21
                        System.out.println("aborted dosUnitEvac");//sysj\FillerPlant.sysj line: 37, column: 5
                        S5006=3;
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                      else {
                        System.out.println("sustaining dosUnitEvac");//sysj\FillerPlant.sysj line: 33, column: 7
                        dosUnitEvac.setPresent();//sysj\FillerPlant.sysj line: 34, column: 7
                        currsigs.addElement(dosUnitEvac);
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                    }
                    else {
                      System.out.println("sustaining dosUnitFilled");//sysj\FillerPlant.sysj line: 25, column: 6
                      dosUnitFilled.setPresent();//sysj\FillerPlant.sysj line: 26, column: 6
                      currsigs.addElement(dosUnitFilled);
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  }
                  else {
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
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
