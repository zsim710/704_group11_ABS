import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.GUI;//sysj\RotaryController.sysj line: 1, column: 1

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
  public Signal rotatedM = new Signal("rotatedM", Signal.OUTPUT);
  public Signal rotatedConvP = new Signal("rotatedConvP", Signal.OUTPUT);
  public Signal bottleAtPos2 = new Signal("bottleAtPos2", Signal.OUTPUT);
  public Signal bottleAtPos3 = new Signal("bottleAtPos3", Signal.OUTPUT);
  public Signal bottleAtPos4 = new Signal("bottleAtPos4", Signal.OUTPUT);
  public Signal start_r = new Signal("start_r", Signal.OUTPUT);
  private long __start_thread_6;//sysj\RotaryController.sysj line: 53, column: 6
  private int S7214 = 1;
  private int S4454 = 1;
  private int S4457 = 1;
  private int S4460 = 1;
  private int S4463 = 1;
  private int S4479 = 1;
  private int S4487 = 1;
  private int S4503 = 1;
  
  private int[] ends = new int[7];
  private int[] tdone = new int[7];
  
  public void thread7234(int [] tdone, int [] ends){
        switch(S4503){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        if(com.systemj.Timer.getMs() - __start_thread_6 >= (0.5) * 1000){//sysj\RotaryController.sysj line: 53, column: 6
          ends[6]=3;
          ;//sysj\RotaryController.sysj line: 53, column: 6
          ends[6]=2;
          tdone[6]=1;
        }
        else {
          active[6]=1;
          ends[6]=1;
          tdone[6]=1;
        }
        break;
      
    }
  }

  public void thread7233(int [] tdone, int [] ends){
        switch(S4487){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        rotaryTableTrigger.setPresent();//sysj\RotaryController.sysj line: 50, column: 7
        currsigs.addElement(rotaryTableTrigger);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread7231(int [] tdone, int [] ends){
        S4503=1;
    __start_thread_6 = com.systemj.Timer.getMs();//sysj\RotaryController.sysj line: 53, column: 6
    if(com.systemj.Timer.getMs() - __start_thread_6 >= (0.5) * 1000){//sysj\RotaryController.sysj line: 53, column: 6
      ends[6]=3;
      ;//sysj\RotaryController.sysj line: 53, column: 6
      ends[6]=2;
      tdone[6]=1;
    }
    else {
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
  }

  public void thread7230(int [] tdone, int [] ends){
        S4487=1;
    System.out.println("rotating");//sysj\RotaryController.sysj line: 49, column: 7
    rotaryTableTrigger.setPresent();//sysj\RotaryController.sysj line: 50, column: 7
    currsigs.addElement(rotaryTableTrigger);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread7228(int [] tdone, int [] ends){
        S4503=1;
    __start_thread_6 = com.systemj.Timer.getMs();//sysj\RotaryController.sysj line: 53, column: 6
    if(com.systemj.Timer.getMs() - __start_thread_6 >= (0.5) * 1000){//sysj\RotaryController.sysj line: 53, column: 6
      ends[6]=3;
      ;//sysj\RotaryController.sysj line: 53, column: 6
      ends[6]=2;
      tdone[6]=1;
    }
    else {
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
  }

  public void thread7227(int [] tdone, int [] ends){
        S4487=1;
    System.out.println("rotating");//sysj\RotaryController.sysj line: 49, column: 7
    rotaryTableTrigger.setPresent();//sysj\RotaryController.sysj line: 50, column: 7
    currsigs.addElement(rotaryTableTrigger);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread7225(int [] tdone, int [] ends){
        S4503=1;
    __start_thread_6 = com.systemj.Timer.getMs();//sysj\RotaryController.sysj line: 53, column: 6
    if(com.systemj.Timer.getMs() - __start_thread_6 >= (0.5) * 1000){//sysj\RotaryController.sysj line: 53, column: 6
      ends[6]=3;
      ;//sysj\RotaryController.sysj line: 53, column: 6
      ends[6]=2;
      tdone[6]=1;
    }
    else {
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
  }

  public void thread7224(int [] tdone, int [] ends){
        S4487=1;
    System.out.println("rotating");//sysj\RotaryController.sysj line: 49, column: 7
    rotaryTableTrigger.setPresent();//sysj\RotaryController.sysj line: 50, column: 7
    currsigs.addElement(rotaryTableTrigger);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread7222(int [] tdone, int [] ends){
        switch(S4463){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        if(lidLoaderReady.getprestatus()){//sysj\RotaryController.sysj line: 30, column: 57
          S4463=0;
          active[4]=0;
          ends[4]=0;
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

  public void thread7221(int [] tdone, int [] ends){
        switch(S4460){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        if(capperReady.getprestatus()){//sysj\RotaryController.sysj line: 30, column: 34
          S4460=0;
          active[3]=0;
          ends[3]=0;
          tdone[3]=1;
        }
        else {
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        break;
      
    }
  }

  public void thread7220(int [] tdone, int [] ends){
        switch(S4457){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(fillerReady.getprestatus()){//sysj\RotaryController.sysj line: 30, column: 11
          S4457=0;
          active[2]=0;
          ends[2]=0;
          tdone[2]=1;
        }
        else {
          active[2]=1;
          ends[2]=1;
          tdone[2]=1;
        }
        break;
      
    }
  }

  public void thread7218(int [] tdone, int [] ends){
        S4463=1;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread7217(int [] tdone, int [] ends){
        S4460=1;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread7216(int [] tdone, int [] ends){
        S4457=1;
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
      switch(S7214){
        case 0 : 
          S7214=0;
          break RUN;
        
        case 1 : 
          S7214=2;
          S7214=2;
          System.out.println("got into controller");//sysj\RotaryController.sysj line: 13, column: 3
          S4454=0;
          active[1]=1;
          ends[1]=1;
          break RUN;
        
        case 2 : 
          switch(S4454){
            case 0 : 
              if(bottleAtPos1RC.getprestatus()){//sysj\RotaryController.sysj line: 17, column: 10
                start_r.setPresent();//sysj\RotaryController.sysj line: 18, column: 4
                currsigs.addElement(start_r);
                System.out.println("emitted start");//sysj\RotaryController.sysj line: 21, column: 4
                S4454=1;
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
              S4454=1;
              if((Integer)(bottleTotalRC.getpreval() == null ? null : ((Integer)bottleTotalRC.getpreval())) < (Integer)(BatchQuantityRC.getpreval() == null ? null : ((Integer)BatchQuantityRC.getpreval()))) {//sysj\RotaryController.sysj line: 25, column: 61
                System.out.println("received bottleAtPos1RC");//sysj\RotaryController.sysj line: 27, column: 5
              }
              S4454=2;
              thread7216(tdone,ends);
              thread7217(tdone,ends);
              thread7218(tdone,ends);
              int biggest7219 = 0;
              if(ends[2]>=biggest7219){
                biggest7219=ends[2];
              }
              if(ends[3]>=biggest7219){
                biggest7219=ends[3];
              }
              if(ends[4]>=biggest7219){
                biggest7219=ends[4];
              }
              if(biggest7219 == 1){
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            
            case 2 : 
              thread7220(tdone,ends);
              thread7221(tdone,ends);
              thread7222(tdone,ends);
              int biggest7223 = 0;
              if(ends[2]>=biggest7223){
                biggest7223=ends[2];
              }
              if(ends[3]>=biggest7223){
                biggest7223=ends[3];
              }
              if(ends[4]>=biggest7223){
                biggest7223=ends[4];
              }
              if(biggest7223 == 1){
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              //FINXME code
              if(biggest7223 == 0){
                System.out.println("all ready signals received");//sysj\RotaryController.sysj line: 31, column: 4
                S4454=3;
                if(capOnBottleAtPos1.getprestatus()){//sysj\RotaryController.sysj line: 34, column: 12
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
                else {
                  S4454=4;
                  if(!capOnBottleAtPos1.getprestatus()){//sysj\RotaryController.sysj line: 40, column: 12
                    S4479=0;
                    if((Integer)(wsActiveRC.getpreval() == null ? null : ((Integer)wsActiveRC.getpreval())) > 4){//sysj\RotaryController.sysj line: 41, column: 9
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      System.out.println("awaiting trap");//sysj\RotaryController.sysj line: 45, column: 5
                      S4479=1;
                      thread7224(tdone,ends);
                      thread7225(tdone,ends);
                      int biggest7226 = 0;
                      if(ends[5]>=biggest7226){
                        biggest7226=ends[5];
                      }
                      if(ends[6]>=biggest7226){
                        biggest7226=ends[6];
                      }
                      if(biggest7226 == 1){
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                      if(biggest7226 == 2){
                        ends[1]=2;
                        ;//sysj\RotaryController.sysj line: 47, column: 5
                        System.out.println("exited the trap");//sysj\RotaryController.sysj line: 55, column: 5
                        S4479=2;
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                    }
                  }
                  else {
                    S4454=0;
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                }
              }
            
            case 3 : 
              if(capRemoved.getprestatus()){//sysj\RotaryController.sysj line: 35, column: 11
                S4454=4;
                if(!capOnBottleAtPos1.getprestatus()){//sysj\RotaryController.sysj line: 40, column: 12
                  S4479=0;
                  if((Integer)(wsActiveRC.getpreval() == null ? null : ((Integer)wsActiveRC.getpreval())) > 4){//sysj\RotaryController.sysj line: 41, column: 9
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  else {
                    System.out.println("awaiting trap");//sysj\RotaryController.sysj line: 45, column: 5
                    S4479=1;
                    thread7227(tdone,ends);
                    thread7228(tdone,ends);
                    int biggest7229 = 0;
                    if(ends[5]>=biggest7229){
                      biggest7229=ends[5];
                    }
                    if(ends[6]>=biggest7229){
                      biggest7229=ends[6];
                    }
                    if(biggest7229 == 1){
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    if(biggest7229 == 2){
                      ends[1]=2;
                      ;//sysj\RotaryController.sysj line: 47, column: 5
                      System.out.println("exited the trap");//sysj\RotaryController.sysj line: 55, column: 5
                      S4479=2;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  }
                }
                else {
                  S4454=0;
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
              switch(S4479){
                case 0 : 
                  if(bottleLeftPos5RC.getprestatus()){//sysj\RotaryController.sysj line: 42, column: 13
                    System.out.println("awaiting trap");//sysj\RotaryController.sysj line: 45, column: 5
                    S4479=1;
                    thread7230(tdone,ends);
                    thread7231(tdone,ends);
                    int biggest7232 = 0;
                    if(ends[5]>=biggest7232){
                      biggest7232=ends[5];
                    }
                    if(ends[6]>=biggest7232){
                      biggest7232=ends[6];
                    }
                    if(biggest7232 == 1){
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    if(biggest7232 == 2){
                      ends[1]=2;
                      ;//sysj\RotaryController.sysj line: 47, column: 5
                      System.out.println("exited the trap");//sysj\RotaryController.sysj line: 55, column: 5
                      S4479=2;
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
                
                case 1 : 
                  thread7233(tdone,ends);
                  thread7234(tdone,ends);
                  int biggest7235 = 0;
                  if(ends[5]>=biggest7235){
                    biggest7235=ends[5];
                  }
                  if(ends[6]>=biggest7235){
                    biggest7235=ends[6];
                  }
                  if(biggest7235 == 1){
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  if(biggest7235 == 2){
                    ends[1]=2;
                    ;//sysj\RotaryController.sysj line: 47, column: 5
                    System.out.println("exited the trap");//sysj\RotaryController.sysj line: 55, column: 5
                    S4479=2;
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  //FINXME code
                  if(biggest7235 == 0){
                    System.out.println("exited the trap");//sysj\RotaryController.sysj line: 55, column: 5
                    S4479=2;
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                
                case 2 : 
                  if(tableAlignedWithSensor.getprestatus()){//sysj\RotaryController.sysj line: 56, column: 11
                    System.out.println("received aligned signal");//sysj\RotaryController.sysj line: 57, column: 5
                    rotated.setPresent();//sysj\RotaryController.sysj line: 58, column: 5
                    currsigs.addElement(rotated);
                    rotatedConvP.setPresent();//sysj\RotaryController.sysj line: 59, column: 5
                    currsigs.addElement(rotatedConvP);
                    rotatedM.setPresent();//sysj\RotaryController.sysj line: 60, column: 5
                    currsigs.addElement(rotatedM);
                    System.out.println("rotated emitted");//sysj\RotaryController.sysj line: 61, column: 5
                    S4454=0;
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

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0};
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
      rotatedM.setpreclear();
      rotatedConvP.setpreclear();
      bottleAtPos2.setpreclear();
      bottleAtPos3.setpreclear();
      bottleAtPos4.setpreclear();
      start_r.setpreclear();
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
      rotatedM.sethook();
      rotatedM.setClear();
      rotatedConvP.sethook();
      rotatedConvP.setClear();
      bottleAtPos2.sethook();
      bottleAtPos2.setClear();
      bottleAtPos3.sethook();
      bottleAtPos3.setClear();
      bottleAtPos4.sethook();
      bottleAtPos4.setClear();
      start_r.sethook();
      start_r.setClear();
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
