import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class CapperController extends ClockDomain{
  public CapperController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal bottleAtPos4 = new Signal("bottleAtPos4", Signal.INPUT);
  public Signal gripperZAxisLowered = new Signal("gripperZAxisLowered", Signal.INPUT);
  public Signal gripperZAxisLifted = new Signal("gripperZAxisLifted", Signal.INPUT);
  public Signal gripperTurnHomePos = new Signal("gripperTurnHomePos", Signal.INPUT);
  public Signal gripperTurnFinalPos = new Signal("gripperTurnFinalPos", Signal.INPUT);
  public Signal capperReady = new Signal("capperReady", Signal.OUTPUT);
  public Signal cylPos5ZaxisExtend = new Signal("cylPos5ZaxisExtend", Signal.OUTPUT);
  public Signal gripperTurnRetract = new Signal("gripperTurnRetract", Signal.OUTPUT);
  public Signal gripperTurnExtend = new Signal("gripperTurnExtend", Signal.OUTPUT);
  public Signal capGripperPos5Extend = new Signal("capGripperPos5Extend", Signal.OUTPUT);
  public Signal cylClampBottleExtend = new Signal("cylClampBottleExtend", Signal.OUTPUT);
  private int S920 = 1;
  private int S588 = 1;
  private int S477 = 1;
  private int S485 = 1;
  private int S527 = 1;
  private int S488 = 1;
  private int S496 = 1;
  private int S504 = 1;
  private int S497 = 1;
  private int S507 = 1;
  
  private int[] ends = new int[8];
  private int[] tdone = new int[8];
  
  public void thread935(int [] tdone, int [] ends){
        switch(S507){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        if(gripperTurnFinalPos.getprestatus()){//sysj\CapperController.sysj line: 49, column: 13
          System.out.println("fully twisted");//sysj\CapperController.sysj line: 50, column: 7
          ends[7]=2;
          tdone[7]=1;
        }
        else {
          active[7]=1;
          ends[7]=1;
          tdone[7]=1;
        }
        break;
      
    }
  }

  public void thread934(int [] tdone, int [] ends){
        switch(S504){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S497){
          case 0 : 
            S497=0;
            System.out.println("twisting");//sysj\CapperController.sysj line: 42, column: 7
            S497=1;
            gripperTurnExtend.setPresent();//sysj\CapperController.sysj line: 43, column: 7
            currsigs.addElement(gripperTurnExtend);
            active[6]=1;
            ends[6]=1;
            tdone[6]=1;
            break;
          
          case 1 : 
            gripperTurnExtend.setPresent();//sysj\CapperController.sysj line: 43, column: 7
            currsigs.addElement(gripperTurnExtend);
            active[6]=1;
            ends[6]=1;
            tdone[6]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread933(int [] tdone, int [] ends){
        switch(S496){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        capGripperPos5Extend.setPresent();//sysj\CapperController.sysj line: 35, column: 7
        currsigs.addElement(capGripperPos5Extend);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread931(int [] tdone, int [] ends){
        S507=1;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread930(int [] tdone, int [] ends){
        S504=1;
    S497=0;
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread929(int [] tdone, int [] ends){
        S496=1;
    System.out.println("gripped");//sysj\CapperController.sysj line: 34, column: 7
    capGripperPos5Extend.setPresent();//sysj\CapperController.sysj line: 35, column: 7
    currsigs.addElement(capGripperPos5Extend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread928(int [] tdone, int [] ends){
        switch(S527){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S488){
          case 0 : 
            if(gripperZAxisLowered.getprestatus()){//sysj\CapperController.sysj line: 31, column: 12
              S488=1;
              thread929(tdone,ends);
              thread930(tdone,ends);
              thread931(tdone,ends);
              int biggest932 = 0;
              if(ends[5]>=biggest932){
                biggest932=ends[5];
              }
              if(ends[6]>=biggest932){
                biggest932=ends[6];
              }
              if(ends[7]>=biggest932){
                biggest932=ends[7];
              }
              if(biggest932 == 1){
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 1 : 
            thread933(tdone,ends);
            thread934(tdone,ends);
            thread935(tdone,ends);
            int biggest936 = 0;
            if(ends[5]>=biggest936){
              biggest936=ends[5];
            }
            if(ends[6]>=biggest936){
              biggest936=ends[6];
            }
            if(ends[7]>=biggest936){
              biggest936=ends[7];
            }
            if(biggest936 == 1){
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            if(biggest936 == 2){
              ends[4]=2;
              tdone[4]=1;
            }
            //FINXME code
            if(biggest936 == 0){
              S527=0;
              active[4]=0;
              ends[4]=0;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread927(int [] tdone, int [] ends){
        switch(S485){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj\CapperController.sysj line: 24, column: 6
        currsigs.addElement(cylClampBottleExtend);
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
        break;
      
    }
  }

  public void thread926(int [] tdone, int [] ends){
        switch(S477){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        cylPos5ZaxisExtend.setPresent();//sysj\CapperController.sysj line: 17, column: 6
        currsigs.addElement(cylPos5ZaxisExtend);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
        break;
      
    }
  }

  public void thread924(int [] tdone, int [] ends){
        S527=1;
    System.out.println("reached here 3");//sysj\CapperController.sysj line: 30, column: 6
    S488=0;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread923(int [] tdone, int [] ends){
        S485=1;
    System.out.println("clamped");//sysj\CapperController.sysj line: 23, column: 6
    cylClampBottleExtend.setPresent();//sysj\CapperController.sysj line: 24, column: 6
    currsigs.addElement(cylClampBottleExtend);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread922(int [] tdone, int [] ends){
        S477=1;
    System.out.println("lowering");//sysj\CapperController.sysj line: 16, column: 6
    cylPos5ZaxisExtend.setPresent();//sysj\CapperController.sysj line: 17, column: 6
    currsigs.addElement(cylPos5ZaxisExtend);
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
      switch(S920){
        case 0 : 
          S920=0;
          break RUN;
        
        case 1 : 
          S920=2;
          S920=2;
          S588=0;
          capperReady.setPresent();//sysj\CapperController.sysj line: 10, column: 5
          currsigs.addElement(capperReady);
          active[1]=1;
          ends[1]=1;
          break RUN;
        
        case 2 : 
          switch(S588){
            case 0 : 
              if(bottleAtPos4.getprestatus()){//sysj\CapperController.sysj line: 9, column: 10
                S588=1;
                thread922(tdone,ends);
                thread923(tdone,ends);
                thread924(tdone,ends);
                int biggest925 = 0;
                if(ends[2]>=biggest925){
                  biggest925=ends[2];
                }
                if(ends[3]>=biggest925){
                  biggest925=ends[3];
                }
                if(ends[4]>=biggest925){
                  biggest925=ends[4];
                }
                if(biggest925 == 1){
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
              else {
                capperReady.setPresent();//sysj\CapperController.sysj line: 10, column: 5
                currsigs.addElement(capperReady);
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            
            case 1 : 
              thread926(tdone,ends);
              thread927(tdone,ends);
              thread928(tdone,ends);
              int biggest937 = 0;
              if(ends[2]>=biggest937){
                biggest937=ends[2];
              }
              if(ends[3]>=biggest937){
                biggest937=ends[3];
              }
              if(ends[4]>=biggest937){
                biggest937=ends[4];
              }
              if(biggest937 == 1){
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              if(biggest937 == 2){
                ends[1]=2;
                ;//sysj\CapperController.sysj line: 13, column: 4
                System.out.println("ungripped");//sysj\CapperController.sysj line: 55, column: 4
                System.out.println("unclamped");//sysj\CapperController.sysj line: 56, column: 4
                System.out.println("raising");//sysj\CapperController.sysj line: 57, column: 4
                S588=2;
                System.out.println("untwisting");//sysj\CapperController.sysj line: 60, column: 5
                gripperTurnRetract.setPresent();//sysj\CapperController.sysj line: 61, column: 5
                currsigs.addElement(gripperTurnRetract);
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              //FINXME code
              if(biggest937 == 0){
                System.out.println("ungripped");//sysj\CapperController.sysj line: 55, column: 4
                System.out.println("unclamped");//sysj\CapperController.sysj line: 56, column: 4
                System.out.println("raising");//sysj\CapperController.sysj line: 57, column: 4
                S588=2;
                System.out.println("untwisting");//sysj\CapperController.sysj line: 60, column: 5
                gripperTurnRetract.setPresent();//sysj\CapperController.sysj line: 61, column: 5
                currsigs.addElement(gripperTurnRetract);
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            
            case 2 : 
              if(gripperTurnHomePos.getprestatus()){//sysj\CapperController.sysj line: 59, column: 10
                System.out.println("fully untwisted");//sysj\CapperController.sysj line: 63, column: 4
                S588=3;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                gripperTurnRetract.setPresent();//sysj\CapperController.sysj line: 61, column: 5
                currsigs.addElement(gripperTurnRetract);
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            
            case 3 : 
              if(gripperZAxisLifted.getprestatus()){//sysj\CapperController.sysj line: 65, column: 10
                System.out.println("at top");//sysj\CapperController.sysj line: 66, column: 4
                capperReady.setPresent();//sysj\CapperController.sysj line: 67, column: 4
                currsigs.addElement(capperReady);
                System.out.println("capperReady signal sent");//sysj\CapperController.sysj line: 68, column: 4
                S588=4;
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
              if(!bottleAtPos4.getprestatus()){//sysj\CapperController.sysj line: 69, column: 10
                S588=0;
                capperReady.setPresent();//sysj\CapperController.sysj line: 10, column: 5
                currsigs.addElement(capperReady);
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
          bottleAtPos4.gethook();
          gripperZAxisLowered.gethook();
          gripperZAxisLifted.gethook();
          gripperTurnHomePos.gethook();
          gripperTurnFinalPos.gethook();
          df = true;
        }
        runClockDomain();
      }
      bottleAtPos4.setpreclear();
      gripperZAxisLowered.setpreclear();
      gripperZAxisLifted.setpreclear();
      gripperTurnHomePos.setpreclear();
      gripperTurnFinalPos.setpreclear();
      capperReady.setpreclear();
      cylPos5ZaxisExtend.setpreclear();
      gripperTurnRetract.setpreclear();
      gripperTurnExtend.setpreclear();
      capGripperPos5Extend.setpreclear();
      cylClampBottleExtend.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = bottleAtPos4.getStatus() ? bottleAtPos4.setprepresent() : bottleAtPos4.setpreclear();
      bottleAtPos4.setpreval(bottleAtPos4.getValue());
      bottleAtPos4.setClear();
      dummyint = gripperZAxisLowered.getStatus() ? gripperZAxisLowered.setprepresent() : gripperZAxisLowered.setpreclear();
      gripperZAxisLowered.setpreval(gripperZAxisLowered.getValue());
      gripperZAxisLowered.setClear();
      dummyint = gripperZAxisLifted.getStatus() ? gripperZAxisLifted.setprepresent() : gripperZAxisLifted.setpreclear();
      gripperZAxisLifted.setpreval(gripperZAxisLifted.getValue());
      gripperZAxisLifted.setClear();
      dummyint = gripperTurnHomePos.getStatus() ? gripperTurnHomePos.setprepresent() : gripperTurnHomePos.setpreclear();
      gripperTurnHomePos.setpreval(gripperTurnHomePos.getValue());
      gripperTurnHomePos.setClear();
      dummyint = gripperTurnFinalPos.getStatus() ? gripperTurnFinalPos.setprepresent() : gripperTurnFinalPos.setpreclear();
      gripperTurnFinalPos.setpreval(gripperTurnFinalPos.getValue());
      gripperTurnFinalPos.setClear();
      capperReady.sethook();
      capperReady.setClear();
      cylPos5ZaxisExtend.sethook();
      cylPos5ZaxisExtend.setClear();
      gripperTurnRetract.sethook();
      gripperTurnRetract.setClear();
      gripperTurnExtend.sethook();
      gripperTurnExtend.setClear();
      capGripperPos5Extend.sethook();
      capGripperPos5Extend.setClear();
      cylClampBottleExtend.sethook();
      cylClampBottleExtend.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        bottleAtPos4.gethook();
        gripperZAxisLowered.gethook();
        gripperZAxisLifted.gethook();
        gripperTurnHomePos.gethook();
        gripperTurnFinalPos.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
