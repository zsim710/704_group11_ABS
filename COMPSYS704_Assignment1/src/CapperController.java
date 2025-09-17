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
  public Signal start = new Signal("start", Signal.INPUT);
  public Signal capGripped = new Signal("capGripped", Signal.INPUT);
  public Signal letGo = new Signal("letGo", Signal.INPUT);
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
  private int S937 = 1;
  private int S936 = 1;
  private int S8 = 1;
  private int S16 = 1;
  private int S24 = 1;
  private int S69 = 1;
  private int S68 = 1;
  private int S33 = 1;
  private int S41 = 1;
  private int S34 = 1;
  private int S46 = 1;
  private int S43 = 1;
  
  private int[] ends = new int[8];
  private int[] tdone = new int[8];
  
  public void thread952(int [] tdone, int [] ends){
        switch(S46){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        switch(S43){
          case 0 : 
            if(capGripped.getprestatus()){//sysj\CapperController.sysj line: 53, column: 14
              System.out.println("gripped");//sysj\CapperController.sysj line: 54, column: 7
              S43=1;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
          case 1 : 
            if(gripperTurnFinalPos.getprestatus()){//sysj\CapperController.sysj line: 56, column: 13
              System.out.println("fully twisted");//sysj\CapperController.sysj line: 57, column: 7
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
        break;
      
    }
  }

  public void thread951(int [] tdone, int [] ends){
        switch(S41){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S34){
          case 0 : 
            S34=0;
            System.out.println("twisting");//sysj\CapperController.sysj line: 46, column: 7
            S34=1;
            gripperTurnExtend.setPresent();//sysj\CapperController.sysj line: 47, column: 7
            currsigs.addElement(gripperTurnExtend);
            active[6]=1;
            ends[6]=1;
            tdone[6]=1;
            break;
          
          case 1 : 
            gripperTurnExtend.setPresent();//sysj\CapperController.sysj line: 47, column: 7
            currsigs.addElement(gripperTurnExtend);
            active[6]=1;
            ends[6]=1;
            tdone[6]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread950(int [] tdone, int [] ends){
        switch(S33){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        capGripperPos5Extend.setPresent();//sysj\CapperController.sysj line: 38, column: 7
        currsigs.addElement(capGripperPos5Extend);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread948(int [] tdone, int [] ends){
        S46=1;
    S43=0;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread947(int [] tdone, int [] ends){
        S41=1;
    S34=0;
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread946(int [] tdone, int [] ends){
        S33=1;
    System.out.println("gripping");//sysj\CapperController.sysj line: 37, column: 7
    capGripperPos5Extend.setPresent();//sysj\CapperController.sysj line: 38, column: 7
    currsigs.addElement(capGripperPos5Extend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread945(int [] tdone, int [] ends){
        switch(S69){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S68){
          case 0 : 
            if(gripperZAxisLowered.getprestatus()){//sysj\CapperController.sysj line: 34, column: 12
              S68=1;
              thread946(tdone,ends);
              thread947(tdone,ends);
              thread948(tdone,ends);
              int biggest949 = 0;
              if(ends[5]>=biggest949){
                biggest949=ends[5];
              }
              if(ends[6]>=biggest949){
                biggest949=ends[6];
              }
              if(ends[7]>=biggest949){
                biggest949=ends[7];
              }
              if(biggest949 == 1){
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
            thread950(tdone,ends);
            thread951(tdone,ends);
            thread952(tdone,ends);
            int biggest953 = 0;
            if(ends[5]>=biggest953){
              biggest953=ends[5];
            }
            if(ends[6]>=biggest953){
              biggest953=ends[6];
            }
            if(ends[7]>=biggest953){
              biggest953=ends[7];
            }
            if(biggest953 == 1){
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            if(biggest953 == 2){
              ends[4]=2;
              tdone[4]=1;
            }
            //FINXME code
            if(biggest953 == 0){
              S69=0;
              active[4]=0;
              ends[4]=0;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread944(int [] tdone, int [] ends){
        switch(S24){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj\CapperController.sysj line: 28, column: 6
        currsigs.addElement(cylClampBottleExtend);
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
        break;
      
    }
  }

  public void thread943(int [] tdone, int [] ends){
        switch(S16){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        cylPos5ZaxisExtend.setPresent();//sysj\CapperController.sysj line: 21, column: 6
        currsigs.addElement(cylPos5ZaxisExtend);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
        break;
      
    }
  }

  public void thread941(int [] tdone, int [] ends){
        S69=1;
    S68=0;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread940(int [] tdone, int [] ends){
        S24=1;
    System.out.println("clamped");//sysj\CapperController.sysj line: 27, column: 6
    cylClampBottleExtend.setPresent();//sysj\CapperController.sysj line: 28, column: 6
    currsigs.addElement(cylClampBottleExtend);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread939(int [] tdone, int [] ends){
        S16=1;
    System.out.println("lowering");//sysj\CapperController.sysj line: 20, column: 6
    cylPos5ZaxisExtend.setPresent();//sysj\CapperController.sysj line: 21, column: 6
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
      switch(S937){
        case 0 : 
          S937=0;
          break RUN;
        
        case 1 : 
          S937=2;
          S937=2;
          S936=0;
          active[1]=1;
          ends[1]=1;
          break RUN;
        
        case 2 : 
          switch(S936){
            case 0 : 
              S936=0;
              S936=1;
              S8=0;
              if(bottleAtPos4.getprestatus()){//sysj\CapperController.sysj line: 10, column: 20
                S8=1;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                capperReady.setPresent();//sysj\CapperController.sysj line: 11, column: 5
                currsigs.addElement(capperReady);
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            
            case 1 : 
              switch(S8){
                case 0 : 
                  if(bottleAtPos4.getprestatus()){//sysj\CapperController.sysj line: 10, column: 20
                    S8=1;
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  else {
                    capperReady.setPresent();//sysj\CapperController.sysj line: 11, column: 5
                    currsigs.addElement(capperReady);
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                
                case 1 : 
                  if(start.getprestatus()){//sysj\CapperController.sysj line: 15, column: 10
                    S8=2;
                    thread939(tdone,ends);
                    thread940(tdone,ends);
                    thread941(tdone,ends);
                    int biggest942 = 0;
                    if(ends[2]>=biggest942){
                      biggest942=ends[2];
                    }
                    if(ends[3]>=biggest942){
                      biggest942=ends[3];
                    }
                    if(ends[4]>=biggest942){
                      biggest942=ends[4];
                    }
                    if(biggest942 == 1){
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
                
                case 2 : 
                  thread943(tdone,ends);
                  thread944(tdone,ends);
                  thread945(tdone,ends);
                  int biggest954 = 0;
                  if(ends[2]>=biggest954){
                    biggest954=ends[2];
                  }
                  if(ends[3]>=biggest954){
                    biggest954=ends[3];
                  }
                  if(ends[4]>=biggest954){
                    biggest954=ends[4];
                  }
                  if(biggest954 == 1){
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  if(biggest954 == 2){
                    ends[1]=2;
                    ;//sysj\CapperController.sysj line: 17, column: 4
                    S8=3;
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  //FINXME code
                  if(biggest954 == 0){
                    S8=3;
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                
                case 3 : 
                  if(letGo.getprestatus()){//sysj\CapperController.sysj line: 63, column: 10
                    System.out.println("ungripped");//sysj\CapperController.sysj line: 65, column: 4
                    System.out.println("unclamped");//sysj\CapperController.sysj line: 66, column: 4
                    System.out.println("raising");//sysj\CapperController.sysj line: 67, column: 4
                    S8=4;
                    System.out.println("untwisting");//sysj\CapperController.sysj line: 70, column: 5
                    gripperTurnRetract.setPresent();//sysj\CapperController.sysj line: 71, column: 5
                    currsigs.addElement(gripperTurnRetract);
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
                  if(gripperTurnHomePos.getprestatus()){//sysj\CapperController.sysj line: 69, column: 10
                    System.out.println("fully untwisted");//sysj\CapperController.sysj line: 73, column: 4
                    S8=5;
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  else {
                    gripperTurnRetract.setPresent();//sysj\CapperController.sysj line: 71, column: 5
                    currsigs.addElement(gripperTurnRetract);
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                
                case 5 : 
                  if(gripperZAxisLifted.getprestatus()){//sysj\CapperController.sysj line: 75, column: 10
                    System.out.println("at top");//sysj\CapperController.sysj line: 76, column: 4
                    capperReady.setPresent();//sysj\CapperController.sysj line: 77, column: 4
                    currsigs.addElement(capperReady);
                    System.out.println("capperReady signal sent");//sysj\CapperController.sysj line: 78, column: 4
                    S8=6;
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
                  if(!bottleAtPos4.getprestatus()){//sysj\CapperController.sysj line: 79, column: 10
                    S8=0;
                    if(bottleAtPos4.getprestatus()){//sysj\CapperController.sysj line: 10, column: 20
                      S8=1;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      capperReady.setPresent();//sysj\CapperController.sysj line: 11, column: 5
                      currsigs.addElement(capperReady);
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
          start.gethook();
          capGripped.gethook();
          letGo.gethook();
          bottleAtPos4.gethook();
          gripperZAxisLowered.gethook();
          gripperZAxisLifted.gethook();
          gripperTurnHomePos.gethook();
          gripperTurnFinalPos.gethook();
          df = true;
        }
        runClockDomain();
      }
      start.setpreclear();
      capGripped.setpreclear();
      letGo.setpreclear();
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
      dummyint = start.getStatus() ? start.setprepresent() : start.setpreclear();
      start.setpreval(start.getValue());
      start.setClear();
      dummyint = capGripped.getStatus() ? capGripped.setprepresent() : capGripped.setpreclear();
      capGripped.setpreval(capGripped.getValue());
      capGripped.setClear();
      dummyint = letGo.getStatus() ? letGo.setprepresent() : letGo.setpreclear();
      letGo.setpreval(letGo.getValue());
      letGo.setClear();
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
        start.gethook();
        capGripped.gethook();
        letGo.gethook();
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
