import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class RotaryController extends ClockDomain{
  public RotaryController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal tableAlignedWithSensor = new Signal("tableAlignedWithSensor", Signal.INPUT);
  public Signal bottleLeftPos5RC = new Signal("bottleLeftPos5RC", Signal.INPUT);
  public Signal bottleAtPos1RC = new Signal("bottleAtPos1RC", Signal.INPUT);
  public Signal capRemoved = new Signal("capRemoved", Signal.INPUT);
  public Signal capOnBottleAtPos1 = new Signal("capOnBottleAtPos1", Signal.INPUT);
  public Signal fillerReady = new Signal("fillerReady", Signal.INPUT);
  public Signal capperReady = new Signal("capperReady", Signal.INPUT);
  public Signal lidLoaderReady = new Signal("lidLoaderReady", Signal.INPUT);
  public Signal wsActiveRC = new Signal("wsActiveRC", Signal.INPUT);
  public Signal bottleTotalRC = new Signal("bottleTotalRC", Signal.INPUT);
  public Signal BatchQuantityRC = new Signal("BatchQuantityRC", Signal.INPUT);
  public Signal rotaryTableTrigger = new Signal("rotaryTableTrigger", Signal.OUTPUT);
  public Signal rotated = new Signal("rotated", Signal.OUTPUT);
  public Signal rotatedConvP = new Signal("rotatedConvP", Signal.OUTPUT);
  public Signal bottleAtPos2 = new Signal("bottleAtPos2", Signal.OUTPUT);
  public Signal bottleAtPos3 = new Signal("bottleAtPos3", Signal.OUTPUT);
  public Signal bottleAtPos4 = new Signal("bottleAtPos4", Signal.OUTPUT);
  public Signal capOnBottleAtPos1RP = new Signal("capOnBottleAtPos1RP", Signal.OUTPUT);
  private long __start_thread_4;//sysj\RotaryController.sysj line: 45, column: 37
  private int S7814 = 1;
  private int S7792 = 1;
  private int S6570 = 1;
  private int S6334 = 1;
  private int S6272 = 1;
  private int S6288 = 1;
  private int S7812 = 1;
  private int S7798 = 1;
  
  private int[] ends = new int[6];
  private int[] tdone = new int[6];
  
  public void thread7829(int [] tdone, int [] ends){
        switch(S7812){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S7798){
          case 0 : 
            if(capRemoved.getprestatus()){//sysj\RotaryController.sysj line: 62, column: 11
              S7798=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              System.out.println("fault detected, sent to RP");//sysj\RotaryController.sysj line: 64, column: 6
              capOnBottleAtPos1RP.setPresent();//sysj\RotaryController.sysj line: 65, column: 6
              currsigs.addElement(capOnBottleAtPos1RP);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 1 : 
            S7798=1;
            S7798=0;
            if(capOnBottleAtPos1.getprestatus()){//sysj\RotaryController.sysj line: 61, column: 12
              System.out.println("fault detected, sent to RP");//sysj\RotaryController.sysj line: 64, column: 6
              capOnBottleAtPos1RP.setPresent();//sysj\RotaryController.sysj line: 65, column: 6
              currsigs.addElement(capOnBottleAtPos1RP);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              S7798=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread7827(int [] tdone, int [] ends){
        switch(S6288){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        if(com.systemj.Timer.getMs() - __start_thread_4 >= 500){//sysj\RotaryController.sysj line: 45, column: 37
          ends[4]=3;
          ;//sysj\RotaryController.sysj line: 45, column: 37
          ends[4]=2;
          tdone[4]=1;
        }
        else {
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
        break;
      
    }
  }

  public void thread7826(int [] tdone, int [] ends){
        switch(S6272){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        rotaryTableTrigger.setPresent();//sysj\RotaryController.sysj line: 45, column: 7
        currsigs.addElement(rotaryTableTrigger);
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
        break;
      
    }
  }

  public void thread7824(int [] tdone, int [] ends){
        S6288=1;
    __start_thread_4 = com.systemj.Timer.getMs();//sysj\RotaryController.sysj line: 45, column: 37
    if(com.systemj.Timer.getMs() - __start_thread_4 >= 500){//sysj\RotaryController.sysj line: 45, column: 37
      ends[4]=3;
      ;//sysj\RotaryController.sysj line: 45, column: 37
      ends[4]=2;
      tdone[4]=1;
    }
    else {
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread7823(int [] tdone, int [] ends){
        S6272=1;
    rotaryTableTrigger.setPresent();//sysj\RotaryController.sysj line: 45, column: 7
    currsigs.addElement(rotaryTableTrigger);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread7821(int [] tdone, int [] ends){
        S6288=1;
    __start_thread_4 = com.systemj.Timer.getMs();//sysj\RotaryController.sysj line: 45, column: 37
    if(com.systemj.Timer.getMs() - __start_thread_4 >= 500){//sysj\RotaryController.sysj line: 45, column: 37
      ends[4]=3;
      ;//sysj\RotaryController.sysj line: 45, column: 37
      ends[4]=2;
      tdone[4]=1;
    }
    else {
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread7820(int [] tdone, int [] ends){
        S6272=1;
    rotaryTableTrigger.setPresent();//sysj\RotaryController.sysj line: 45, column: 7
    currsigs.addElement(rotaryTableTrigger);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread7819(int [] tdone, int [] ends){
        switch(S7792){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S6570){
          case 0 : 
            S6570=0;
            S6570=1;
            System.out.println("allgood");//sysj\RotaryController.sysj line: 37, column: 5
            if(!capOnBottleAtPos1.getprestatus()){//sysj\RotaryController.sysj line: 39, column: 13
              S6334=0;
              if((Integer)(wsActiveRC.getpreval() == null ? null : ((Integer)wsActiveRC.getpreval())) > 4){//sysj\RotaryController.sysj line: 40, column: 9
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S6334=1;
                thread7820(tdone,ends);
                thread7821(tdone,ends);
                int biggest7822 = 0;
                if(ends[3]>=biggest7822){
                  biggest7822=ends[3];
                }
                if(ends[4]>=biggest7822){
                  biggest7822=ends[4];
                }
                if(biggest7822 == 1){
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                if(biggest7822 == 2){
                  ends[2]=2;
                  ;//sysj\RotaryController.sysj line: 44, column: 5
                  S6334=2;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
              }
            }
            else {
              S6570=0;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 1 : 
            if(capOnBottleAtPos1.getprestatus()){//sysj\RotaryController.sysj line: 36, column: 10
              S6570=0;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              switch(S6334){
                case 0 : 
                  if(bottleLeftPos5RC.getprestatus()){//sysj\RotaryController.sysj line: 41, column: 13
                    S6334=1;
                    thread7823(tdone,ends);
                    thread7824(tdone,ends);
                    int biggest7825 = 0;
                    if(ends[3]>=biggest7825){
                      biggest7825=ends[3];
                    }
                    if(ends[4]>=biggest7825){
                      biggest7825=ends[4];
                    }
                    if(biggest7825 == 1){
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    if(biggest7825 == 2){
                      ends[2]=2;
                      ;//sysj\RotaryController.sysj line: 44, column: 5
                      S6334=2;
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
                
                case 1 : 
                  thread7826(tdone,ends);
                  thread7827(tdone,ends);
                  int biggest7828 = 0;
                  if(ends[3]>=biggest7828){
                    biggest7828=ends[3];
                  }
                  if(ends[4]>=biggest7828){
                    biggest7828=ends[4];
                  }
                  if(biggest7828 == 1){
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  if(biggest7828 == 2){
                    ends[2]=2;
                    ;//sysj\RotaryController.sysj line: 44, column: 5
                    S6334=2;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  //FINXME code
                  if(biggest7828 == 0){
                    S6334=2;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  break;
                
                case 2 : 
                  if(tableAlignedWithSensor.getprestatus()){//sysj\RotaryController.sysj line: 47, column: 11
                    rotated.setPresent();//sysj\RotaryController.sysj line: 48, column: 5
                    currsigs.addElement(rotated);
                    rotatedConvP.setPresent();//sysj\RotaryController.sysj line: 49, column: 5
                    currsigs.addElement(rotatedConvP);
                    System.out.println("rotated emitted");//sysj\RotaryController.sysj line: 50, column: 5
                    S6334=3;
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
                  S6334=3;
                  S6570=0;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                  break;
                
              }
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread7817(int [] tdone, int [] ends){
        S7812=1;
    S7798=0;
    if(capOnBottleAtPos1.getprestatus()){//sysj\RotaryController.sysj line: 61, column: 12
      System.out.println("fault detected, sent to RP");//sysj\RotaryController.sysj line: 64, column: 6
      capOnBottleAtPos1RP.setPresent();//sysj\RotaryController.sysj line: 65, column: 6
      currsigs.addElement(capOnBottleAtPos1RP);
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
    else {
      S7798=1;
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
  }

  public void thread7816(int [] tdone, int [] ends){
        S7792=1;
    S6570=0;
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
      switch(S7814){
        case 0 : 
          S7814=0;
          break RUN;
        
        case 1 : 
          S7814=2;
          S7814=2;
          thread7816(tdone,ends);
          thread7817(tdone,ends);
          int biggest7818 = 0;
          if(ends[2]>=biggest7818){
            biggest7818=ends[2];
          }
          if(ends[5]>=biggest7818){
            biggest7818=ends[5];
          }
          if(biggest7818 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread7819(tdone,ends);
          thread7829(tdone,ends);
          int biggest7830 = 0;
          if(ends[2]>=biggest7830){
            biggest7830=ends[2];
          }
          if(ends[5]>=biggest7830){
            biggest7830=ends[5];
          }
          if(biggest7830 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest7830 == 0){
            S7814=0;
            active[1]=0;
            ends[1]=0;
            S7814=0;
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
          tableAlignedWithSensor.gethook();
          bottleLeftPos5RC.gethook();
          bottleAtPos1RC.gethook();
          capRemoved.gethook();
          capOnBottleAtPos1.gethook();
          fillerReady.gethook();
          capperReady.gethook();
          lidLoaderReady.gethook();
          wsActiveRC.gethook();
          bottleTotalRC.gethook();
          BatchQuantityRC.gethook();
          df = true;
        }
        runClockDomain();
      }
      tableAlignedWithSensor.setpreclear();
      bottleLeftPos5RC.setpreclear();
      bottleAtPos1RC.setpreclear();
      capRemoved.setpreclear();
      capOnBottleAtPos1.setpreclear();
      fillerReady.setpreclear();
      capperReady.setpreclear();
      lidLoaderReady.setpreclear();
      wsActiveRC.setpreclear();
      bottleTotalRC.setpreclear();
      BatchQuantityRC.setpreclear();
      rotaryTableTrigger.setpreclear();
      rotated.setpreclear();
      rotatedConvP.setpreclear();
      bottleAtPos2.setpreclear();
      bottleAtPos3.setpreclear();
      bottleAtPos4.setpreclear();
      capOnBottleAtPos1RP.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = tableAlignedWithSensor.getStatus() ? tableAlignedWithSensor.setprepresent() : tableAlignedWithSensor.setpreclear();
      tableAlignedWithSensor.setpreval(tableAlignedWithSensor.getValue());
      tableAlignedWithSensor.setClear();
      dummyint = bottleLeftPos5RC.getStatus() ? bottleLeftPos5RC.setprepresent() : bottleLeftPos5RC.setpreclear();
      bottleLeftPos5RC.setpreval(bottleLeftPos5RC.getValue());
      bottleLeftPos5RC.setClear();
      dummyint = bottleAtPos1RC.getStatus() ? bottleAtPos1RC.setprepresent() : bottleAtPos1RC.setpreclear();
      bottleAtPos1RC.setpreval(bottleAtPos1RC.getValue());
      bottleAtPos1RC.setClear();
      dummyint = capRemoved.getStatus() ? capRemoved.setprepresent() : capRemoved.setpreclear();
      capRemoved.setpreval(capRemoved.getValue());
      capRemoved.setClear();
      dummyint = capOnBottleAtPos1.getStatus() ? capOnBottleAtPos1.setprepresent() : capOnBottleAtPos1.setpreclear();
      capOnBottleAtPos1.setpreval(capOnBottleAtPos1.getValue());
      capOnBottleAtPos1.setClear();
      dummyint = fillerReady.getStatus() ? fillerReady.setprepresent() : fillerReady.setpreclear();
      fillerReady.setpreval(fillerReady.getValue());
      fillerReady.setClear();
      dummyint = capperReady.getStatus() ? capperReady.setprepresent() : capperReady.setpreclear();
      capperReady.setpreval(capperReady.getValue());
      capperReady.setClear();
      dummyint = lidLoaderReady.getStatus() ? lidLoaderReady.setprepresent() : lidLoaderReady.setpreclear();
      lidLoaderReady.setpreval(lidLoaderReady.getValue());
      lidLoaderReady.setClear();
      dummyint = wsActiveRC.getStatus() ? wsActiveRC.setprepresent() : wsActiveRC.setpreclear();
      wsActiveRC.setpreval(wsActiveRC.getValue());
      wsActiveRC.setClear();
      dummyint = bottleTotalRC.getStatus() ? bottleTotalRC.setprepresent() : bottleTotalRC.setpreclear();
      bottleTotalRC.setpreval(bottleTotalRC.getValue());
      bottleTotalRC.setClear();
      dummyint = BatchQuantityRC.getStatus() ? BatchQuantityRC.setprepresent() : BatchQuantityRC.setpreclear();
      BatchQuantityRC.setpreval(BatchQuantityRC.getValue());
      BatchQuantityRC.setClear();
      rotaryTableTrigger.sethook();
      rotaryTableTrigger.setClear();
      rotated.sethook();
      rotated.setClear();
      rotatedConvP.sethook();
      rotatedConvP.setClear();
      bottleAtPos2.sethook();
      bottleAtPos2.setClear();
      bottleAtPos3.sethook();
      bottleAtPos3.setClear();
      bottleAtPos4.sethook();
      bottleAtPos4.setClear();
      capOnBottleAtPos1RP.sethook();
      capOnBottleAtPos1RP.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        tableAlignedWithSensor.gethook();
        bottleLeftPos5RC.gethook();
        bottleAtPos1RC.gethook();
        capRemoved.gethook();
        capOnBottleAtPos1.gethook();
        fillerReady.gethook();
        capperReady.gethook();
        lidLoaderReady.gethook();
        wsActiveRC.gethook();
        bottleTotalRC.gethook();
        BatchQuantityRC.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
