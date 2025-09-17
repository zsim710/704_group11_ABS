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
  public Signal filler2Complete = new Signal("filler2Complete", Signal.INPUT);
  public Signal dosUnitEvac = new Signal("dosUnitEvac", Signal.OUTPUT);
  public Signal dosUnitFilled = new Signal("dosUnitFilled", Signal.OUTPUT);
  public Signal start = new Signal("start", Signal.OUTPUT);
  private int S3223 = 1;
  private int S2974 = 1;
  private int S2977 = 1;
  
  private int[] ends = new int[2];
  private int[] tdone = new int[2];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S3223){
        case 0 : 
          S3223=0;
          break RUN;
        
        case 1 : 
          S3223=2;
          S3223=2;
          if(filler2Complete.getprestatus()){//sysj\FillerPlant.sysj line: 10, column: 18
            System.out.println("all fillers complete");//sysj\FillerPlant.sysj line: 73, column: 2
            S3223=0;
            active[1]=0;
            ends[1]=0;
            S3223=0;
            break RUN;
          }
          else {
            S2974=0;
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          if(filler2Complete.getprestatus()){//sysj\FillerPlant.sysj line: 10, column: 18
            System.out.println("all fillers complete");//sysj\FillerPlant.sysj line: 73, column: 2
            S3223=0;
            active[1]=0;
            ends[1]=0;
            S3223=0;
            break RUN;
          }
          else {
            switch(S2974){
              case 0 : 
                if(enableFP.getprestatus()){//sysj\FillerPlant.sysj line: 11, column: 9
                  start.setPresent();//sysj\FillerPlant.sysj line: 12, column: 3
                  currsigs.addElement(start);
                  S2974=1;
                  System.out.println("awaiting starting enable");//sysj\FillerPlant.sysj line: 17, column: 4
                  S2977=0;
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
                switch(S2977){
                  case 0 : 
                    if(enableFP.getprestatus()){//sysj\FillerPlant.sysj line: 18, column: 10
                      System.out.println("completed starting enable");//sysj\FillerPlant.sysj line: 19, column: 4
                      S2977=1;
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
                    if(valveInjectorOn.getprestatus()){//sysj\FillerPlant.sysj line: 22, column: 10
                      System.out.println("awaiting disable 1");//sysj\FillerPlant.sysj line: 28, column: 4
                      S2977=2;
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
                    if(!enableFP.getprestatus()){//sysj\FillerPlant.sysj line: 29, column: 10
                      System.out.println("completed disable 1");//sysj\FillerPlant.sysj line: 30, column: 4
                      System.out.println("awaiting enable 2");//sysj\FillerPlant.sysj line: 32, column: 4
                      S2977=3;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  
                  case 3 : 
                    if(enableFP.getprestatus()){//sysj\FillerPlant.sysj line: 33, column: 10
                      System.out.println("completed enable 2");//sysj\FillerPlant.sysj line: 34, column: 4
                      S2977=4;
                      if(dosUnitValveRetract.getprestatus()){//sysj\FillerPlant.sysj line: 37, column: 14
                        dosUnitFilled.setPresent();//sysj\FillerPlant.sysj line: 38, column: 7
                        currsigs.addElement(dosUnitFilled);
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                      else {
                        System.out.println("awaiting disable 2");//sysj\FillerPlant.sysj line: 42, column: 4
                        S2977=5;
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
                  
                  case 4 : 
                    if(dosUnitValveExtend.getprestatus()){//sysj\FillerPlant.sysj line: 36, column: 10
                      System.out.println("awaiting disable 2");//sysj\FillerPlant.sysj line: 42, column: 4
                      S2977=5;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      dosUnitFilled.setPresent();//sysj\FillerPlant.sysj line: 38, column: 7
                      currsigs.addElement(dosUnitFilled);
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  
                  case 5 : 
                    if(!enableFP.getprestatus()){//sysj\FillerPlant.sysj line: 43, column: 10
                      System.out.println("completed disable 2");//sysj\FillerPlant.sysj line: 44, column: 4
                      System.out.println("awaiting enable 3");//sysj\FillerPlant.sysj line: 47, column: 4
                      S2977=6;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  
                  case 6 : 
                    if(enableFP.getprestatus()){//sysj\FillerPlant.sysj line: 48, column: 10
                      System.out.println("completed enable 3");//sysj\FillerPlant.sysj line: 49, column: 4
                      S2977=7;
                      if(dosUnitValveExtend.getprestatus()){//sysj\FillerPlant.sysj line: 51, column: 14
                        dosUnitEvac.setPresent();//sysj\FillerPlant.sysj line: 52, column: 7
                        currsigs.addElement(dosUnitEvac);
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                      else {
                        System.out.println("awaiting disable 3");//sysj\FillerPlant.sysj line: 56, column: 4
                        S2977=8;
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
                  
                  case 7 : 
                    if(!valveInletOn.getprestatus()){//sysj\FillerPlant.sysj line: 50, column: 10
                      System.out.println("awaiting disable 3");//sysj\FillerPlant.sysj line: 56, column: 4
                      S2977=8;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      dosUnitEvac.setPresent();//sysj\FillerPlant.sysj line: 52, column: 7
                      currsigs.addElement(dosUnitEvac);
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  
                  case 8 : 
                    if(!enableFP.getprestatus()){//sysj\FillerPlant.sysj line: 57, column: 10
                      System.out.println("completed disable 3");//sysj\FillerPlant.sysj line: 58, column: 4
                      System.out.println("awaiting enable 4");//sysj\FillerPlant.sysj line: 60, column: 4
                      S2977=9;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  
                  case 9 : 
                    if(enableFP.getprestatus()){//sysj\FillerPlant.sysj line: 61, column: 10
                      System.out.println("completed enable 4");//sysj\FillerPlant.sysj line: 62, column: 4
                      System.out.println("awaiting disable 4");//sysj\FillerPlant.sysj line: 65, column: 4
                      S2977=10;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  
                  case 10 : 
                    if(!enableFP.getprestatus()){//sysj\FillerPlant.sysj line: 66, column: 10
                      System.out.println("completed disable 4");//sysj\FillerPlant.sysj line: 67, column: 4
                      System.out.println("looped");//sysj\FillerPlant.sysj line: 69, column: 4
                      System.out.println("awaiting starting enable");//sysj\FillerPlant.sysj line: 17, column: 4
                      S2977=0;
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
          enableFP.gethook();
          valveInjectorOn.gethook();
          valveInletOn.gethook();
          dosUnitValveRetract.gethook();
          dosUnitValveExtend.gethook();
          filler2Complete.gethook();
          df = true;
        }
        runClockDomain();
      }
      enableFP.setpreclear();
      valveInjectorOn.setpreclear();
      valveInletOn.setpreclear();
      dosUnitValveRetract.setpreclear();
      dosUnitValveExtend.setpreclear();
      filler2Complete.setpreclear();
      dosUnitEvac.setpreclear();
      dosUnitFilled.setpreclear();
      start.setpreclear();
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
      dummyint = filler2Complete.getStatus() ? filler2Complete.setprepresent() : filler2Complete.setpreclear();
      filler2Complete.setpreval(filler2Complete.getValue());
      filler2Complete.setClear();
      dosUnitEvac.sethook();
      dosUnitEvac.setClear();
      dosUnitFilled.sethook();
      dosUnitFilled.setClear();
      start.sethook();
      start.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        enableFP.gethook();
        valveInjectorOn.gethook();
        valveInletOn.gethook();
        dosUnitValveRetract.gethook();
        dosUnitValveExtend.gethook();
        filler2Complete.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
