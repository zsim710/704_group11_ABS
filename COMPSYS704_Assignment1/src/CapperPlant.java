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
  public Signal start = new Signal("start", Signal.INPUT);
  public Signal gripperZAxisLowered = new Signal("gripperZAxisLowered", Signal.OUTPUT);
  public Signal gripperZAxisLifted = new Signal("gripperZAxisLifted", Signal.OUTPUT);
  public Signal gripperTurnHomePos = new Signal("gripperTurnHomePos", Signal.OUTPUT);
  public Signal gripperTurnFinalPos = new Signal("gripperTurnFinalPos", Signal.OUTPUT);
  public Signal capGripped = new Signal("capGripped", Signal.OUTPUT);
  public Signal letGo = new Signal("letGo", Signal.OUTPUT);
  public Signal bottleAtPos4E = new Signal("bottleAtPos4E", Signal.OUTPUT);
  public Signal gripperZAxisLoweredE = new Signal("gripperZAxisLoweredE", Signal.OUTPUT);
  public Signal gripperZAxisLiftedE = new Signal("gripperZAxisLiftedE", Signal.OUTPUT);
  public Signal gripperTurnHomePosE = new Signal("gripperTurnHomePosE", Signal.OUTPUT);
  public Signal gripperTurnFinalPosE = new Signal("gripperTurnFinalPosE", Signal.OUTPUT);
  public Signal capIsGrippedE = new Signal("capIsGrippedE", Signal.OUTPUT);
  private int S1589 = 1;
  private int S1546 = 1;
  private int S1342 = 1;
  private int S1350 = 1;
  private int S1358 = 1;
  private int S1351 = 1;
  private int S1587 = 1;
  private int S1559 = 1;
  
  private int[] ends = new int[6];
  private int[] tdone = new int[6];
  
  public void thread1601(int [] tdone, int [] ends){
        switch(S1587){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S1559){
          case 0 : 
            if(gripperTurnExtend.getprestatus()){//sysj\CapperPlant.sysj line: 57, column: 11
              S1559=1;
              gripperTurnFinalPos.setPresent();//sysj\CapperPlant.sysj line: 64, column: 5
              currsigs.addElement(gripperTurnFinalPos);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              gripperTurnHomePos.setPresent();//sysj\CapperPlant.sysj line: 59, column: 5
              currsigs.addElement(gripperTurnHomePos);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 1 : 
            if(gripperTurnRetract.getprestatus()){//sysj\CapperPlant.sysj line: 62, column: 10
              S1559=0;
              gripperTurnHomePos.setPresent();//sysj\CapperPlant.sysj line: 59, column: 5
              currsigs.addElement(gripperTurnHomePos);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              gripperTurnFinalPos.setPresent();//sysj\CapperPlant.sysj line: 64, column: 5
              currsigs.addElement(gripperTurnFinalPos);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1599(int [] tdone, int [] ends){
        switch(S1358){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S1351){
          case 0 : 
            S1351=0;
            System.out.println("cap gripped sent");//sysj\CapperPlant.sysj line: 33, column: 6
            S1351=1;
            capGripped.setPresent();//sysj\CapperPlant.sysj line: 34, column: 6
            currsigs.addElement(capGripped);
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
          case 1 : 
            capGripped.setPresent();//sysj\CapperPlant.sysj line: 34, column: 6
            currsigs.addElement(capGripped);
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread1598(int [] tdone, int [] ends){
        switch(S1350){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        gripperZAxisLowered.setPresent();//sysj\CapperPlant.sysj line: 27, column: 6
        currsigs.addElement(gripperZAxisLowered);
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
        break;
      
    }
  }

  public void thread1596(int [] tdone, int [] ends){
        S1358=1;
    System.out.println("waiting for gripped enable");//sysj\CapperPlant.sysj line: 31, column: 6
    S1351=0;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread1595(int [] tdone, int [] ends){
        S1350=1;
    System.out.println("gripper at bottom");//sysj\CapperPlant.sysj line: 26, column: 6
    gripperZAxisLowered.setPresent();//sysj\CapperPlant.sysj line: 27, column: 6
    currsigs.addElement(gripperZAxisLowered);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread1594(int [] tdone, int [] ends){
        switch(S1546){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S1342){
          case 0 : 
            if(start.getprestatus()){//sysj\CapperPlant.sysj line: 13, column: 20
              S1342=1;
              System.out.println("sustaining gripper at top");//sysj\CapperPlant.sysj line: 16, column: 6
              gripperZAxisLifted.setPresent();//sysj\CapperPlant.sysj line: 17, column: 6
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
            if(cylPos5ZaxisExtend.getprestatus()){//sysj\CapperPlant.sysj line: 15, column: 10
              System.out.println("waiting for gripper at bottom disable");//sysj\CapperPlant.sysj line: 21, column: 4
              S1342=2;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              gripperZAxisLifted.setPresent();//sysj\CapperPlant.sysj line: 17, column: 6
              currsigs.addElement(gripperZAxisLifted);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 2 : 
            S1342=2;
            S1342=3;
            thread1595(tdone,ends);
            thread1596(tdone,ends);
            int biggest1597 = 0;
            if(ends[3]>=biggest1597){
              biggest1597=ends[3];
            }
            if(ends[4]>=biggest1597){
              biggest1597=ends[4];
            }
            if(biggest1597 == 1){
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 3 : 
            if(!cylPos5ZaxisExtend.getprestatus()){//sysj\CapperPlant.sysj line: 24, column: 10
              System.out.println("waiting for let go disable");//sysj\CapperPlant.sysj line: 38, column: 4
              System.out.println("waiting for let go enable");//sysj\CapperPlant.sysj line: 39, column: 4
              S1342=4;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              thread1598(tdone,ends);
              thread1599(tdone,ends);
              int biggest1600 = 0;
              if(ends[3]>=biggest1600){
                biggest1600=ends[3];
              }
              if(ends[4]>=biggest1600){
                biggest1600=ends[4];
              }
              if(biggest1600 == 1){
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              //FINXME code
              if(biggest1600 == 0){
                System.out.println("waiting for let go disable");//sysj\CapperPlant.sysj line: 38, column: 4
                System.out.println("waiting for let go enable");//sysj\CapperPlant.sysj line: 39, column: 4
                S1342=4;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
            }
            break;
          
          case 4 : 
            S1342=4;
            S1342=5;
            System.out.println("let go emitted");//sysj\CapperPlant.sysj line: 43, column: 5
            letGo.setPresent();//sysj\CapperPlant.sysj line: 44, column: 5
            currsigs.addElement(letGo);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
            break;
          
          case 5 : 
            if(gripperTurnRetract.getprestatus()){//sysj\CapperPlant.sysj line: 42, column: 10
              System.out.println("looped");//sysj\CapperPlant.sysj line: 47, column: 4
              S1342=0;
              if(start.getprestatus()){//sysj\CapperPlant.sysj line: 13, column: 20
                S1342=1;
                System.out.println("sustaining gripper at top");//sysj\CapperPlant.sysj line: 16, column: 6
                gripperZAxisLifted.setPresent();//sysj\CapperPlant.sysj line: 17, column: 6
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
            }
            else {
              letGo.setPresent();//sysj\CapperPlant.sysj line: 44, column: 5
              currsigs.addElement(letGo);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1592(int [] tdone, int [] ends){
        S1587=1;
    S1559=0;
    gripperTurnHomePos.setPresent();//sysj\CapperPlant.sysj line: 59, column: 5
    currsigs.addElement(gripperTurnHomePos);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread1591(int [] tdone, int [] ends){
        S1546=1;
    S1342=0;
    if(start.getprestatus()){//sysj\CapperPlant.sysj line: 13, column: 20
      S1342=1;
      System.out.println("sustaining gripper at top");//sysj\CapperPlant.sysj line: 16, column: 6
      gripperZAxisLifted.setPresent();//sysj\CapperPlant.sysj line: 17, column: 6
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
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S1589){
        case 0 : 
          S1589=0;
          break RUN;
        
        case 1 : 
          S1589=2;
          S1589=2;
          thread1591(tdone,ends);
          thread1592(tdone,ends);
          int biggest1593 = 0;
          if(ends[2]>=biggest1593){
            biggest1593=ends[2];
          }
          if(ends[5]>=biggest1593){
            biggest1593=ends[5];
          }
          if(biggest1593 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread1594(tdone,ends);
          thread1601(tdone,ends);
          int biggest1602 = 0;
          if(ends[2]>=biggest1602){
            biggest1602=ends[2];
          }
          if(ends[5]>=biggest1602){
            biggest1602=ends[5];
          }
          if(biggest1602 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest1602 == 0){
            S1589=0;
            active[1]=0;
            ends[1]=0;
            S1589=0;
            break RUN;
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
          cylPos5ZaxisExtend.gethook();
          gripperTurnRetract.gethook();
          gripperTurnExtend.gethook();
          capGripperPos5Extend.gethook();
          cylClampBottleExtend.gethook();
          start.gethook();
          df = true;
        }
        runClockDomain();
      }
      cylPos5ZaxisExtend.setpreclear();
      gripperTurnRetract.setpreclear();
      gripperTurnExtend.setpreclear();
      capGripperPos5Extend.setpreclear();
      cylClampBottleExtend.setpreclear();
      start.setpreclear();
      gripperZAxisLowered.setpreclear();
      gripperZAxisLifted.setpreclear();
      gripperTurnHomePos.setpreclear();
      gripperTurnFinalPos.setpreclear();
      capGripped.setpreclear();
      letGo.setpreclear();
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
      dummyint = start.getStatus() ? start.setprepresent() : start.setpreclear();
      start.setpreval(start.getValue());
      start.setClear();
      gripperZAxisLowered.sethook();
      gripperZAxisLowered.setClear();
      gripperZAxisLifted.sethook();
      gripperZAxisLifted.setClear();
      gripperTurnHomePos.sethook();
      gripperTurnHomePos.setClear();
      gripperTurnFinalPos.sethook();
      gripperTurnFinalPos.setClear();
      capGripped.sethook();
      capGripped.setClear();
      letGo.sethook();
      letGo.setClear();
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
