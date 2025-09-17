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
  public Signal start = new Signal("start", Signal.OUTPUT);
  public Signal capGripped = new Signal("capGripped", Signal.OUTPUT);
  public Signal letGo = new Signal("letGo", Signal.OUTPUT);
  public Signal bottleAtPos4E = new Signal("bottleAtPos4E", Signal.OUTPUT);
  public Signal gripperZAxisLoweredE = new Signal("gripperZAxisLoweredE", Signal.OUTPUT);
  public Signal gripperZAxisLiftedE = new Signal("gripperZAxisLiftedE", Signal.OUTPUT);
  public Signal gripperTurnHomePosE = new Signal("gripperTurnHomePosE", Signal.OUTPUT);
  public Signal gripperTurnFinalPosE = new Signal("gripperTurnFinalPosE", Signal.OUTPUT);
  public Signal capIsGrippedE = new Signal("capIsGrippedE", Signal.OUTPUT);
  private int S1242 = 1;
  private int S1199 = 1;
  private int S973 = 1;
  private int S963 = 1;
  private int S956 = 1;
  private int S971 = 1;
  private int S984 = 1;
  private int S994 = 1;
  private int S987 = 1;
  private int S1240 = 1;
  private int S1212 = 1;
  
  private int[] ends = new int[8];
  private int[] tdone = new int[8];
  
  public void thread1263(int [] tdone, int [] ends){
        switch(S1240){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        switch(S1212){
          case 0 : 
            if(gripperTurnExtend.getprestatus()){//sysj\CapperPlant.sysj line: 63, column: 11
              S1212=1;
              gripperTurnFinalPos.setPresent();//sysj\CapperPlant.sysj line: 70, column: 5
              currsigs.addElement(gripperTurnFinalPos);
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              gripperTurnHomePos.setPresent();//sysj\CapperPlant.sysj line: 65, column: 5
              currsigs.addElement(gripperTurnHomePos);
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
          case 1 : 
            if(gripperTurnRetract.getprestatus()){//sysj\CapperPlant.sysj line: 68, column: 10
              S1212=0;
              gripperTurnHomePos.setPresent();//sysj\CapperPlant.sysj line: 65, column: 5
              currsigs.addElement(gripperTurnHomePos);
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              gripperTurnFinalPos.setPresent();//sysj\CapperPlant.sysj line: 70, column: 5
              currsigs.addElement(gripperTurnFinalPos);
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1261(int [] tdone, int [] ends){
        S971=1;
    System.out.println("sustaining gripper at top");//sysj\CapperPlant.sysj line: 21, column: 6
    gripperZAxisLifted.setPresent();//sysj\CapperPlant.sysj line: 22, column: 6
    currsigs.addElement(gripperZAxisLifted);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread1260(int [] tdone, int [] ends){
        S963=1;
    S956=0;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread1258(int [] tdone, int [] ends){
        switch(S994){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S987){
          case 0 : 
            if(enableCapP.getprestatus()){//sysj\CapperPlant.sysj line: 37, column: 12
              System.out.println("cap gripped sent");//sysj\CapperPlant.sysj line: 38, column: 6
              S987=1;
              capGripped.setPresent();//sysj\CapperPlant.sysj line: 39, column: 6
              currsigs.addElement(capGripped);
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
          case 1 : 
            capGripped.setPresent();//sysj\CapperPlant.sysj line: 39, column: 6
            currsigs.addElement(capGripped);
            active[6]=1;
            ends[6]=1;
            tdone[6]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread1257(int [] tdone, int [] ends){
        switch(S984){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        gripperZAxisLowered.setPresent();//sysj\CapperPlant.sysj line: 32, column: 6
        currsigs.addElement(gripperZAxisLowered);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread1255(int [] tdone, int [] ends){
        S994=1;
    System.out.println("waiting for gripped enable");//sysj\CapperPlant.sysj line: 36, column: 6
    S987=0;
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread1254(int [] tdone, int [] ends){
        S984=1;
    System.out.println("gripper at bottom");//sysj\CapperPlant.sysj line: 31, column: 6
    gripperZAxisLowered.setPresent();//sysj\CapperPlant.sysj line: 32, column: 6
    currsigs.addElement(gripperZAxisLowered);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread1252(int [] tdone, int [] ends){
        switch(S971){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        gripperZAxisLifted.setPresent();//sysj\CapperPlant.sysj line: 22, column: 6
        currsigs.addElement(gripperZAxisLifted);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread1251(int [] tdone, int [] ends){
        switch(S963){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S956){
          case 0 : 
            if(enableCapP.getprestatus()){//sysj\CapperPlant.sysj line: 15, column: 13
              System.out.println("sending start signal");//sysj\CapperPlant.sysj line: 16, column: 6
              S956=1;
              start.setPresent();//sysj\CapperPlant.sysj line: 17, column: 6
              currsigs.addElement(start);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 1 : 
            start.setPresent();//sysj\CapperPlant.sysj line: 17, column: 6
            currsigs.addElement(start);
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread1250(int [] tdone, int [] ends){
        switch(S1199){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S973){
          case 0 : 
            if(cylPos5ZaxisExtend.getprestatus()){//sysj\CapperPlant.sysj line: 13, column: 10
              System.out.println("waiting for gripper at bottom disable");//sysj\CapperPlant.sysj line: 26, column: 4
              S973=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              thread1251(tdone,ends);
              thread1252(tdone,ends);
              int biggest1253 = 0;
              if(ends[3]>=biggest1253){
                biggest1253=ends[3];
              }
              if(ends[4]>=biggest1253){
                biggest1253=ends[4];
              }
              if(biggest1253 == 1){
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              //FINXME code
              if(biggest1253 == 0){
                System.out.println("waiting for gripper at bottom disable");//sysj\CapperPlant.sysj line: 26, column: 4
                S973=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
            }
            break;
          
          case 1 : 
            if(!enableCapP.getprestatus()){//sysj\CapperPlant.sysj line: 27, column: 10
              S973=2;
              thread1254(tdone,ends);
              thread1255(tdone,ends);
              int biggest1256 = 0;
              if(ends[5]>=biggest1256){
                biggest1256=ends[5];
              }
              if(ends[6]>=biggest1256){
                biggest1256=ends[6];
              }
              if(biggest1256 == 1){
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
            }
            else {
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 2 : 
            if(!cylPos5ZaxisExtend.getprestatus()){//sysj\CapperPlant.sysj line: 29, column: 10
              System.out.println("waiting for let go disable");//sysj\CapperPlant.sysj line: 43, column: 4
              S973=3;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              thread1257(tdone,ends);
              thread1258(tdone,ends);
              int biggest1259 = 0;
              if(ends[5]>=biggest1259){
                biggest1259=ends[5];
              }
              if(ends[6]>=biggest1259){
                biggest1259=ends[6];
              }
              if(biggest1259 == 1){
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              //FINXME code
              if(biggest1259 == 0){
                System.out.println("waiting for let go disable");//sysj\CapperPlant.sysj line: 43, column: 4
                S973=3;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
            }
            break;
          
          case 3 : 
            if(!enableCapP.getprestatus()){//sysj\CapperPlant.sysj line: 44, column: 10
              System.out.println("waiting for let go enable");//sysj\CapperPlant.sysj line: 45, column: 4
              S973=4;
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
            if(enableCapP.getprestatus()){//sysj\CapperPlant.sysj line: 47, column: 10
              S973=5;
              System.out.println("let go emitted");//sysj\CapperPlant.sysj line: 49, column: 5
              letGo.setPresent();//sysj\CapperPlant.sysj line: 50, column: 5
              currsigs.addElement(letGo);
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
            if(gripperTurnRetract.getprestatus()){//sysj\CapperPlant.sysj line: 48, column: 10
              System.out.println("looped");//sysj\CapperPlant.sysj line: 53, column: 4
              S973=0;
              thread1260(tdone,ends);
              thread1261(tdone,ends);
              int biggest1262 = 0;
              if(ends[3]>=biggest1262){
                biggest1262=ends[3];
              }
              if(ends[4]>=biggest1262){
                biggest1262=ends[4];
              }
              if(biggest1262 == 1){
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
            }
            else {
              letGo.setPresent();//sysj\CapperPlant.sysj line: 50, column: 5
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

  public void thread1248(int [] tdone, int [] ends){
        S1240=1;
    S1212=0;
    gripperTurnHomePos.setPresent();//sysj\CapperPlant.sysj line: 65, column: 5
    currsigs.addElement(gripperTurnHomePos);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread1246(int [] tdone, int [] ends){
        S971=1;
    System.out.println("sustaining gripper at top");//sysj\CapperPlant.sysj line: 21, column: 6
    gripperZAxisLifted.setPresent();//sysj\CapperPlant.sysj line: 22, column: 6
    currsigs.addElement(gripperZAxisLifted);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread1245(int [] tdone, int [] ends){
        S963=1;
    S956=0;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread1244(int [] tdone, int [] ends){
        S1199=1;
    S973=0;
    thread1245(tdone,ends);
    thread1246(tdone,ends);
    int biggest1247 = 0;
    if(ends[3]>=biggest1247){
      biggest1247=ends[3];
    }
    if(ends[4]>=biggest1247){
      biggest1247=ends[4];
    }
    if(biggest1247 == 1){
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
      switch(S1242){
        case 0 : 
          S1242=0;
          break RUN;
        
        case 1 : 
          S1242=2;
          S1242=2;
          thread1244(tdone,ends);
          thread1248(tdone,ends);
          int biggest1249 = 0;
          if(ends[2]>=biggest1249){
            biggest1249=ends[2];
          }
          if(ends[7]>=biggest1249){
            biggest1249=ends[7];
          }
          if(biggest1249 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread1250(tdone,ends);
          thread1263(tdone,ends);
          int biggest1264 = 0;
          if(ends[2]>=biggest1264){
            biggest1264=ends[2];
          }
          if(ends[7]>=biggest1264){
            biggest1264=ends[7];
          }
          if(biggest1264 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest1264 == 0){
            S1242=0;
            active[1]=0;
            ends[1]=0;
            S1242=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0};
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
      start.setpreclear();
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
      start.sethook();
      start.setClear();
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
