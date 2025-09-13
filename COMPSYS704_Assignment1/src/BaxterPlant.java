import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.GUI;//sysj\baxterplant.sysj line: 1, column: 1

public class BaxterPlant extends ClockDomain{
  public BaxterPlant(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal CMD = new Signal("CMD", Signal.INPUT);
  public Signal CMDfb = new Signal("CMDfb", Signal.OUTPUT);
  public Signal bottleAtPoint = new Signal("bottleAtPoint", Signal.OUTPUT);
  public Signal POSA = new Signal("POSA", Signal.OUTPUT);
  public Signal POSB = new Signal("POSB", Signal.OUTPUT);
  public Signal POSC = new Signal("POSC", Signal.OUTPUT);
  public Signal POSD = new Signal("POSD", Signal.OUTPUT);
  public Signal GripDat = new Signal("GripDat", Signal.OUTPUT);
  private String command_thread_1;//sysj\baxterplant.sysj line: 22, column: 4
  private java.lang.String []  parts_thread_1;//sysj\baxterplant.sysj line: 23, column: 4
  private int S370 = 1;
  private int S33 = 1;
  
  private int[] ends = new int[2];
  private int[] tdone = new int[2];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S370){
        case 0 : 
          S370=0;
          break RUN;
        
        case 1 : 
          S370=2;
          S370=2;
          new Thread(new GUI()).start();//sysj\baxterplant.sysj line: 12, column: 2
          S33=0;
          active[1]=1;
          ends[1]=1;
          break RUN;
        
        case 2 : 
          switch(S33){
            case 0 : 
              S33=0;
              S33=1;
              bottleAtPoint.setPresent();//sysj\baxterplant.sysj line: 19, column: 3
              currsigs.addElement(bottleAtPoint);
              active[1]=1;
              ends[1]=1;
              break RUN;
            
            case 1 : 
              if(CMD.getprestatus()){//sysj\baxterplant.sysj line: 21, column: 11
                command_thread_1 = (String)(CMD.getpreval() == null ? null : ((String)CMD.getpreval()));//sysj\baxterplant.sysj line: 22, column: 4
                parts_thread_1 = command_thread_1.split(" ");//sysj\baxterplant.sysj line: 23, column: 4
                System.out.println(parts_thread_1[0]);//sysj\baxterplant.sysj line: 26, column: 4
                System.out.println(parts_thread_1[1]);//sysj\baxterplant.sysj line: 27, column: 4
                System.out.println(parts_thread_1[2]);//sysj\baxterplant.sysj line: 28, column: 4
                if(parts_thread_1[2].equals("A")){//sysj\baxterplant.sysj line: 31, column: 4
                  POSA.setPresent();//sysj\baxterplant.sysj line: 32, column: 5
                  currsigs.addElement(POSA);
                  CMDfb.setPresent();//sysj\baxterplant.sysj line: 46, column: 3
                  currsigs.addElement(CMDfb);
                  bottleAtPoint.setPresent();//sysj\baxterplant.sysj line: 19, column: 3
                  currsigs.addElement(bottleAtPoint);
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
                else {
                  if(parts_thread_1[2].equals("B")){//sysj\baxterplant.sysj line: 34, column: 11
                    POSB.setPresent();//sysj\baxterplant.sysj line: 35, column: 5
                    currsigs.addElement(POSB);
                    CMDfb.setPresent();//sysj\baxterplant.sysj line: 46, column: 3
                    currsigs.addElement(CMDfb);
                    bottleAtPoint.setPresent();//sysj\baxterplant.sysj line: 19, column: 3
                    currsigs.addElement(bottleAtPoint);
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  else {
                    if(parts_thread_1[2].equals("C")){//sysj\baxterplant.sysj line: 37, column: 11
                      POSC.setPresent();//sysj\baxterplant.sysj line: 38, column: 5
                      currsigs.addElement(POSC);
                      CMDfb.setPresent();//sysj\baxterplant.sysj line: 46, column: 3
                      currsigs.addElement(CMDfb);
                      bottleAtPoint.setPresent();//sysj\baxterplant.sysj line: 19, column: 3
                      currsigs.addElement(bottleAtPoint);
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      if(parts_thread_1[2].equals("D")){//sysj\baxterplant.sysj line: 40, column: 11
                        POSD.setPresent();//sysj\baxterplant.sysj line: 41, column: 5
                        currsigs.addElement(POSD);
                        CMDfb.setPresent();//sysj\baxterplant.sysj line: 46, column: 3
                        currsigs.addElement(CMDfb);
                        bottleAtPoint.setPresent();//sysj\baxterplant.sysj line: 19, column: 3
                        currsigs.addElement(bottleAtPoint);
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                      else {
                        CMDfb.setPresent();//sysj\baxterplant.sysj line: 46, column: 3
                        currsigs.addElement(CMDfb);
                        bottleAtPoint.setPresent();//sysj\baxterplant.sysj line: 19, column: 3
                        currsigs.addElement(bottleAtPoint);
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                    }
                  }
                }
              }
              else {
                CMDfb.setPresent();//sysj\baxterplant.sysj line: 46, column: 3
                currsigs.addElement(CMDfb);
                bottleAtPoint.setPresent();//sysj\baxterplant.sysj line: 19, column: 3
                currsigs.addElement(bottleAtPoint);
                active[1]=1;
                ends[1]=1;
                break RUN;
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
          CMD.gethook();
          df = true;
        }
        runClockDomain();
      }
      CMD.setpreclear();
      CMDfb.setpreclear();
      bottleAtPoint.setpreclear();
      POSA.setpreclear();
      POSB.setpreclear();
      POSC.setpreclear();
      POSD.setpreclear();
      GripDat.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = CMD.getStatus() ? CMD.setprepresent() : CMD.setpreclear();
      CMD.setpreval(CMD.getValue());
      CMD.setClear();
      CMDfb.sethook();
      CMDfb.setClear();
      bottleAtPoint.sethook();
      bottleAtPoint.setClear();
      POSA.sethook();
      POSA.setClear();
      POSB.sethook();
      POSB.setClear();
      POSC.sethook();
      POSC.setClear();
      POSD.sethook();
      POSD.setClear();
      GripDat.sethook();
      GripDat.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        CMD.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
