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
  public Signal bottleAtPoint = new Signal("bottleAtPoint", Signal.INPUT);
  public Signal CMDfb = new Signal("CMDfb", Signal.INPUT);
  public Signal CMD = new Signal("CMD", Signal.OUTPUT);
  private int S31 = 1;
  private int S1 = 1;
  
  private int[] ends = new int[2];
  private int[] tdone = new int[2];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S31){
        case 0 : 
          S31=0;
          break RUN;
        
        case 1 : 
          S31=2;
          S31=2;
          S1=0;
          active[1]=1;
          ends[1]=1;
          break RUN;
        
        case 2 : 
          switch(S1){
            case 0 : 
              if(bottleAtPoint.getprestatus()){//sysj\baxtercontroller.sysj line: 12, column: 9
                S1=1;
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
              S1=1;
              CMD.setPresent();//sysj\baxtercontroller.sysj line: 17, column: 3
              currsigs.addElement(CMD);
              CMD.setValue("limb_moveto left_limb B");//sysj\baxtercontroller.sysj line: 17, column: 3
              S1=2;
              active[1]=1;
              ends[1]=1;
              break RUN;
            
            case 2 : 
              S1=2;
              S1=3;
              active[1]=1;
              ends[1]=1;
              break RUN;
            
            case 3 : 
              if(CMDfb.getprestatus()){//sysj\baxtercontroller.sysj line: 19, column: 9
                CMD.setPresent();//sysj\baxtercontroller.sysj line: 22, column: 3
                currsigs.addElement(CMD);
                CMD.setValue("limb_gripper left_limb close");//sysj\baxtercontroller.sysj line: 22, column: 3
                S1=4;
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
              S1=4;
              CMD.setPresent();//sysj\baxtercontroller.sysj line: 26, column: 3
              currsigs.addElement(CMD);
              CMD.setValue("limb_moveto left_limb C");//sysj\baxtercontroller.sysj line: 26, column: 3
              S1=5;
              active[1]=1;
              ends[1]=1;
              break RUN;
            
            case 5 : 
              S1=5;
              S1=6;
              active[1]=1;
              ends[1]=1;
              break RUN;
            
            case 6 : 
              if(CMDfb.getprestatus()){//sysj\baxtercontroller.sysj line: 28, column: 9
                CMD.setPresent();//sysj\baxtercontroller.sysj line: 31, column: 3
                currsigs.addElement(CMD);
                CMD.setValue("limb_moveto left_limb D");//sysj\baxtercontroller.sysj line: 31, column: 3
                S1=7;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            
            case 7 : 
              S1=7;
              S1=8;
              active[1]=1;
              ends[1]=1;
              break RUN;
            
            case 8 : 
              if(CMDfb.getprestatus()){//sysj\baxtercontroller.sysj line: 33, column: 9
                CMD.setPresent();//sysj\baxtercontroller.sysj line: 36, column: 3
                currsigs.addElement(CMD);
                CMD.setValue("limb_gripper left_limb open");//sysj\baxtercontroller.sysj line: 36, column: 3
                S1=9;
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
              S1=9;
              CMD.setPresent();//sysj\baxtercontroller.sysj line: 40, column: 3
              currsigs.addElement(CMD);
              CMD.setValue("limb_moveto left_limb A");//sysj\baxtercontroller.sysj line: 40, column: 3
              S1=10;
              active[1]=1;
              ends[1]=1;
              break RUN;
            
            case 10 : 
              S1=10;
              S1=11;
              active[1]=1;
              ends[1]=1;
              break RUN;
            
            case 11 : 
              if(CMDfb.getprestatus()){//sysj\baxtercontroller.sysj line: 42, column: 9
                S1=0;
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
          bottleAtPoint.gethook();
          CMDfb.gethook();
          df = true;
        }
        runClockDomain();
      }
      bottleAtPoint.setpreclear();
      CMDfb.setpreclear();
      CMD.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = bottleAtPoint.getStatus() ? bottleAtPoint.setprepresent() : bottleAtPoint.setpreclear();
      bottleAtPoint.setpreval(bottleAtPoint.getValue());
      bottleAtPoint.setClear();
      dummyint = CMDfb.getStatus() ? CMDfb.setprepresent() : CMDfb.setpreclear();
      CMDfb.setpreval(CMDfb.getValue());
      CMDfb.setClear();
      CMD.sethook();
      CMD.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        bottleAtPoint.gethook();
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
