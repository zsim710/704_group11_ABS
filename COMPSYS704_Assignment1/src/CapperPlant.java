import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class CapperPlant extends ClockDomain{
  public CapperPlant(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal cylPos5ZaxisExtend = new Signal("cylPos5ZaxisExtend", Signal.INPUT);
  public Signal gripperTurnRetract = new Signal("gripperTurnRetract", Signal.INPUT);
  public Signal gripperTurnExtend = new Signal("gripperTurnExtend", Signal.INPUT);
  public Signal capGripperPos5Extend = new Signal("capGripperPos5Extend", Signal.INPUT);
  public Signal cylClampBottleExtend = new Signal("cylClampBottleExtend", Signal.INPUT);
  public Signal enableCapP = new Signal("enableCapP", Signal.INPUT);
  public Signal gripperZAxisLowered = new Signal("gripperZAxisLowered", Signal.OUTPUT);
  public Signal gripperZAxisLifted = new Signal("gripperZAxisLifted", Signal.OUTPUT);
  public Signal gripperTurnHomePos = new Signal("gripperTurnHomePos", Signal.OUTPUT);
  public Signal gripperTurnFinalPos = new Signal("gripperTurnFinalPos", Signal.OUTPUT);
  public Signal bottleAtPos4E = new Signal("bottleAtPos4E", Signal.OUTPUT);
  public Signal gripperZAxisLoweredE = new Signal("gripperZAxisLoweredE", Signal.OUTPUT);
  public Signal gripperZAxisLiftedE = new Signal("gripperZAxisLiftedE", Signal.OUTPUT);
  public Signal gripperTurnHomePosE = new Signal("gripperTurnHomePosE", Signal.OUTPUT);
  public Signal gripperTurnFinalPosE = new Signal("gripperTurnFinalPosE", Signal.OUTPUT);
  public Signal capIsGrippedE = new Signal("capIsGrippedE", Signal.OUTPUT);
  private int S1144 = 1;
  private int S1065 = 1;
  private int S955 = 1;
  private int S1142 = 1;
  private int S1090 = 1;
  
  private int[] ends = new int[4];
  private int[] tdone = new int[4];
  
  public void thread1150(int [] tdone, int [] ends){
        switch(S1142){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S1090){
          case 0 : 
            if(gripperTurnExtend.getprestatus()){//sysj\CapperPlant.sysj line: 41, column: 11
              S1090=1;
              System.out.println("final");//sysj\CapperPlant.sysj line: 47, column: 5
              gripperTurnFinalPos.setPresent();//sysj\CapperPlant.sysj line: 48, column: 5
              currsigs.addElement(gripperTurnFinalPos);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              gripperTurnHomePos.setPresent();//sysj\CapperPlant.sysj line: 43, column: 5
              currsigs.addElement(gripperTurnHomePos);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 1 : 
            if(gripperTurnRetract.getprestatus()){//sysj\CapperPlant.sysj line: 46, column: 10
              S1090=0;
              System.out.println("home");//sysj\CapperPlant.sysj line: 42, column: 5
              gripperTurnHomePos.setPresent();//sysj\CapperPlant.sysj line: 43, column: 5
              currsigs.addElement(gripperTurnHomePos);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              gripperTurnFinalPos.setPresent();//sysj\CapperPlant.sysj line: 48, column: 5
              currsigs.addElement(gripperTurnFinalPos);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1149(int [] tdone, int [] ends){
        switch(S1065){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S955){
          case 0 : 
            if(enableCapP.getprestatus()){//sysj\CapperPlant.sysj line: 13, column: 10
              S955=1;
              System.out.println("sustaining gripper at top");//sysj\CapperPlant.sysj line: 15, column: 5
              gripperZAxisLifted.setPresent();//sysj\CapperPlant.sysj line: 16, column: 5
              currsigs.addElement(gripperZAxisLifted);
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
            if(cylPos5ZaxisExtend.getprestatus()){//sysj\CapperPlant.sysj line: 14, column: 10
              System.out.println("abort 1");//sysj\CapperPlant.sysj line: 18, column: 4
              S955=2;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              gripperZAxisLifted.setPresent();//sysj\CapperPlant.sysj line: 16, column: 5
              currsigs.addElement(gripperZAxisLifted);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 2 : 
            if(!enableCapP.getprestatus()){//sysj\CapperPlant.sysj line: 20, column: 10
              System.out.println("reached here 1");//sysj\CapperPlant.sysj line: 21, column: 4
              S955=3;
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
          
          case 3 : 
            if(enableCapP.getprestatus()){//sysj\CapperPlant.sysj line: 22, column: 10
              System.out.println("aborted gripper at top");//sysj\CapperPlant.sysj line: 23, column: 4
              S955=4;
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
          
          case 4 : 
            if(!enableCapP.getprestatus()){//sysj\CapperPlant.sysj line: 25, column: 10
              System.out.println("reached here 2");//sysj\CapperPlant.sysj line: 26, column: 4
              S955=5;
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
          
          case 5 : 
            if(enableCapP.getprestatus()){//sysj\CapperPlant.sysj line: 27, column: 10
              S955=6;
              System.out.println("gripper at bottom");//sysj\CapperPlant.sysj line: 29, column: 5
              gripperZAxisLowered.setPresent();//sysj\CapperPlant.sysj line: 30, column: 5
              currsigs.addElement(gripperZAxisLowered);
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
            if(!cylPos5ZaxisExtend.getprestatus()){//sysj\CapperPlant.sysj line: 28, column: 10
              S955=0;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              gripperZAxisLowered.setPresent();//sysj\CapperPlant.sysj line: 30, column: 5
              currsigs.addElement(gripperZAxisLowered);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1147(int [] tdone, int [] ends){
        S1142=1;
    S1090=0;
    System.out.println("home");//sysj\CapperPlant.sysj line: 42, column: 5
    gripperTurnHomePos.setPresent();//sysj\CapperPlant.sysj line: 43, column: 5
    currsigs.addElement(gripperTurnHomePos);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread1146(int [] tdone, int [] ends){
        S1065=1;
    S955=0;
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
      switch(S1144){
        case 0 : 
          S1144=0;
          break RUN;
        
        case 1 : 
          S1144=2;
          S1144=2;
          thread1146(tdone,ends);
          thread1147(tdone,ends);
          int biggest1148 = 0;
          if(ends[2]>=biggest1148){
            biggest1148=ends[2];
          }
          if(ends[3]>=biggest1148){
            biggest1148=ends[3];
          }
          if(biggest1148 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread1149(tdone,ends);
          thread1150(tdone,ends);
          int biggest1151 = 0;
          if(ends[2]>=biggest1151){
            biggest1151=ends[2];
          }
          if(ends[3]>=biggest1151){
            biggest1151=ends[3];
          }
          if(biggest1151 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest1151 == 0){
            S1144=0;
            active[1]=0;
            ends[1]=0;
            S1144=0;
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
          cylPos5ZaxisExtend.gethook();
          gripperTurnRetract.gethook();
          gripperTurnExtend.gethook();
          capGripperPos5Extend.gethook();
          cylClampBottleExtend.gethook();
          enableCapP.gethook();
          df = true;
        }
        runClockDomain();
      }
      cylPos5ZaxisExtend.setpreclear();
      gripperTurnRetract.setpreclear();
      gripperTurnExtend.setpreclear();
      capGripperPos5Extend.setpreclear();
      cylClampBottleExtend.setpreclear();
      enableCapP.setpreclear();
      gripperZAxisLowered.setpreclear();
      gripperZAxisLifted.setpreclear();
      gripperTurnHomePos.setpreclear();
      gripperTurnFinalPos.setpreclear();
      bottleAtPos4E.setpreclear();
      gripperZAxisLoweredE.setpreclear();
      gripperZAxisLiftedE.setpreclear();
      gripperTurnHomePosE.setpreclear();
      gripperTurnFinalPosE.setpreclear();
      capIsGrippedE.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = cylPos5ZaxisExtend.getStatus() ? cylPos5ZaxisExtend.setprepresent() : cylPos5ZaxisExtend.setpreclear();
      cylPos5ZaxisExtend.setpreval(cylPos5ZaxisExtend.getValue());
      cylPos5ZaxisExtend.setClear();
      dummyint = gripperTurnRetract.getStatus() ? gripperTurnRetract.setprepresent() : gripperTurnRetract.setpreclear();
      gripperTurnRetract.setpreval(gripperTurnRetract.getValue());
      gripperTurnRetract.setClear();
      dummyint = gripperTurnExtend.getStatus() ? gripperTurnExtend.setprepresent() : gripperTurnExtend.setpreclear();
      gripperTurnExtend.setpreval(gripperTurnExtend.getValue());
      gripperTurnExtend.setClear();
      dummyint = capGripperPos5Extend.getStatus() ? capGripperPos5Extend.setprepresent() : capGripperPos5Extend.setpreclear();
      capGripperPos5Extend.setpreval(capGripperPos5Extend.getValue());
      capGripperPos5Extend.setClear();
      dummyint = cylClampBottleExtend.getStatus() ? cylClampBottleExtend.setprepresent() : cylClampBottleExtend.setpreclear();
      cylClampBottleExtend.setpreval(cylClampBottleExtend.getValue());
      cylClampBottleExtend.setClear();
      dummyint = enableCapP.getStatus() ? enableCapP.setprepresent() : enableCapP.setpreclear();
      enableCapP.setpreval(enableCapP.getValue());
      enableCapP.setClear();
      gripperZAxisLowered.sethook();
      gripperZAxisLowered.setClear();
      gripperZAxisLifted.sethook();
      gripperZAxisLifted.setClear();
      gripperTurnHomePos.sethook();
      gripperTurnHomePos.setClear();
      gripperTurnFinalPos.sethook();
      gripperTurnFinalPos.setClear();
      bottleAtPos4E.sethook();
      bottleAtPos4E.setClear();
      gripperZAxisLoweredE.sethook();
      gripperZAxisLoweredE.setClear();
      gripperZAxisLiftedE.sethook();
      gripperZAxisLiftedE.setClear();
      gripperTurnHomePosE.sethook();
      gripperTurnHomePosE.setClear();
      gripperTurnFinalPosE.sethook();
      gripperTurnFinalPosE.setClear();
      capIsGrippedE.sethook();
      capIsGrippedE.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        cylPos5ZaxisExtend.gethook();
        gripperTurnRetract.gethook();
        gripperTurnExtend.gethook();
        capGripperPos5Extend.gethook();
        cylClampBottleExtend.gethook();
        enableCapP.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
