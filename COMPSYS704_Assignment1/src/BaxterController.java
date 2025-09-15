import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class BaxterController extends ClockDomain{
  public BaxterController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal fail = new Signal("fail", Signal.INPUT);
  public Signal CMDfb = new Signal("CMDfb", Signal.INPUT);
  public Signal CMD = new Signal("CMD", Signal.OUTPUT);
  public Signal failT = new Signal("failT", Signal.OUTPUT);
  private int S155 = 1;
  private int S24 = 1;
  private int S2 = 1;
  
  private int[] ends = new int[2];
  private int[] tdone = new int[2];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S155){
        case 0 : 
          S155=0;
          break RUN;
        
        case 1 : 
          S155=2;
          S155=2;
          S24=0;
          active[1]=1;
          ends[1]=1;
          break RUN;
        
        case 2 : 
          switch(S24){
            case 0 : 
              S24=0;
              S24=1;
              CMD.setPresent();//sysj\BaxterController.sysj line: 17, column: 6
              currsigs.addElement(CMD);
              CMD.setValue("limb_moveto left_limb B");//sysj\BaxterController.sysj line: 17, column: 6
              S2=0;
              active[1]=1;
              ends[1]=1;
              break RUN;
            
            case 1 : 
              if(fail.getprestatus()){//sysj\BaxterController.sysj line: 13, column: 13
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                switch(S2){
                  case 0 : 
                    if(CMDfb.getprestatus()){//sysj\BaxterController.sysj line: 18, column: 12
                      CMD.setPresent();//sysj\BaxterController.sysj line: 21, column: 6
                      currsigs.addElement(CMD);
                      CMD.setValue("limb_gripper left_limb close");//sysj\BaxterController.sysj line: 21, column: 6
                      S2=1;
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
                    if(CMDfb.getprestatus()){//sysj\BaxterController.sysj line: 22, column: 12
                      CMD.setPresent();//sysj\BaxterController.sysj line: 25, column: 6
                      currsigs.addElement(CMD);
                      CMD.setValue("limb_moveto left_limb C");//sysj\BaxterController.sysj line: 25, column: 6
                      S2=2;
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
                    if(CMDfb.getprestatus()){//sysj\BaxterController.sysj line: 26, column: 12
                      CMD.setPresent();//sysj\BaxterController.sysj line: 29, column: 6
                      currsigs.addElement(CMD);
                      CMD.setValue("limb_moveto left_limb D");//sysj\BaxterController.sysj line: 29, column: 6
                      S2=3;
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
                    if(CMDfb.getprestatus()){//sysj\BaxterController.sysj line: 30, column: 12
                      CMD.setPresent();//sysj\BaxterController.sysj line: 33, column: 6
                      currsigs.addElement(CMD);
                      CMD.setValue("limb_gripper left_limb open");//sysj\BaxterController.sysj line: 33, column: 6
                      S2=4;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  
                  case 4 : 
                    if(CMDfb.getprestatus()){//sysj\BaxterController.sysj line: 34, column: 12
                      CMD.setPresent();//sysj\BaxterController.sysj line: 37, column: 6
                      currsigs.addElement(CMD);
                      CMD.setValue("limb_moveto left_limb A");//sysj\BaxterController.sysj line: 37, column: 6
                      S24=0;
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
              break;
            
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
          fail.gethook();
          CMDfb.gethook();
          df = true;
        }
        runClockDomain();
      }
      fail.setpreclear();
      CMDfb.setpreclear();
      CMD.setpreclear();
      failT.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = fail.getStatus() ? fail.setprepresent() : fail.setpreclear();
      fail.setpreval(fail.getValue());
      fail.setClear();
      dummyint = CMDfb.getStatus() ? CMDfb.setprepresent() : CMDfb.setpreclear();
      CMDfb.setpreval(CMDfb.getValue());
      CMDfb.setClear();
      CMD.sethook();
      CMD.setClear();
      failT.sethook();
      failT.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        fail.gethook();
        CMDfb.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
