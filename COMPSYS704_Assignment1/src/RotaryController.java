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
  public Signal rotaryTableTriggerConvP = new Signal("rotaryTableTriggerConvP", Signal.OUTPUT);
  public Signal rotated = new Signal("rotated", Signal.OUTPUT);
  public Signal rotatedM = new Signal("rotatedM", Signal.OUTPUT);
  public Signal rotatedConvP = new Signal("rotatedConvP", Signal.OUTPUT);
  public Signal bottleAtPos2 = new Signal("bottleAtPos2", Signal.OUTPUT);
  public Signal bottleAtPos3 = new Signal("bottleAtPos3", Signal.OUTPUT);
  public Signal bottleAtPos4 = new Signal("bottleAtPos4", Signal.OUTPUT);
  public Signal start_r = new Signal("start_r", Signal.OUTPUT);
  private long __start_thread_8;//sysj\RotaryController.sysj line: 57, column: 6
  private int S12120 = 1;
  private int S8100 = 1;
  private int S8103 = 1;
  private int S8106 = 1;
  private int S8109 = 1;
  private int S8125 = 1;
  private int S8147 = 1;
  private int S8130 = 1;
  private int S8135 = 1;
  private int S8163 = 1;
  
  private int[] ends = new int[9];
  private int[] tdone = new int[9];
  
  public void thread12152(int [] tdone, int [] ends){
        switch(S8163){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        if(com.systemj.Timer.getMs() - __start_thread_8 >= (0.5) * 1000){//sysj\RotaryController.sysj line: 57, column: 6
          ends[8]=3;
          ;//sysj\RotaryController.sysj line: 57, column: 6
          ends[8]=2;
          tdone[8]=1;
        }
        else {
          active[8]=1;
          ends[8]=1;
          tdone[8]=1;
        }
        break;
      
    }
  }

  public void thread12150(int [] tdone, int [] ends){
        switch(S8135){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        rotaryTableTriggerConvP.setPresent();//sysj\RotaryController.sysj line: 53, column: 8
        currsigs.addElement(rotaryTableTriggerConvP);
        active[7]=1;
        ends[7]=1;
        tdone[7]=1;
        break;
      
    }
  }

  public void thread12149(int [] tdone, int [] ends){
        switch(S8130){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        rotaryTableTrigger.setPresent();//sysj\RotaryController.sysj line: 51, column: 8
        currsigs.addElement(rotaryTableTrigger);
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
        break;
      
    }
  }

  public void thread12148(int [] tdone, int [] ends){
        switch(S8147){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        thread12149(tdone,ends);
        thread12150(tdone,ends);
        int biggest12151 = 0;
        if(ends[6]>=biggest12151){
          biggest12151=ends[6];
        }
        if(ends[7]>=biggest12151){
          biggest12151=ends[7];
        }
        if(biggest12151 == 1){
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        //FINXME code
        if(biggest12151 == 0){
          S8147=0;
          active[5]=0;
          ends[5]=0;
          tdone[5]=1;
        }
        break;
      
    }
  }

  public void thread12146(int [] tdone, int [] ends){
        S8163=1;
    __start_thread_8 = com.systemj.Timer.getMs();//sysj\RotaryController.sysj line: 57, column: 6
    if(com.systemj.Timer.getMs() - __start_thread_8 >= (0.5) * 1000){//sysj\RotaryController.sysj line: 57, column: 6
      ends[8]=3;
      ;//sysj\RotaryController.sysj line: 57, column: 6
      ends[8]=2;
      tdone[8]=1;
    }
    else {
      active[8]=1;
      ends[8]=1;
      tdone[8]=1;
    }
  }

  public void thread12144(int [] tdone, int [] ends){
        S8135=1;
    rotaryTableTriggerConvP.setPresent();//sysj\RotaryController.sysj line: 53, column: 8
    currsigs.addElement(rotaryTableTriggerConvP);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread12143(int [] tdone, int [] ends){
        S8130=1;
    rotaryTableTrigger.setPresent();//sysj\RotaryController.sysj line: 51, column: 8
    currsigs.addElement(rotaryTableTrigger);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread12142(int [] tdone, int [] ends){
        S8147=1;
    System.out.println("rotating");//sysj\RotaryController.sysj line: 49, column: 7
    thread12143(tdone,ends);
    thread12144(tdone,ends);
    int biggest12145 = 0;
    if(ends[6]>=biggest12145){
      biggest12145=ends[6];
    }
    if(ends[7]>=biggest12145){
      biggest12145=ends[7];
    }
    if(biggest12145 == 1){
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
  }

  public void thread12140(int [] tdone, int [] ends){
        S8163=1;
    __start_thread_8 = com.systemj.Timer.getMs();//sysj\RotaryController.sysj line: 57, column: 6
    if(com.systemj.Timer.getMs() - __start_thread_8 >= (0.5) * 1000){//sysj\RotaryController.sysj line: 57, column: 6
      ends[8]=3;
      ;//sysj\RotaryController.sysj line: 57, column: 6
      ends[8]=2;
      tdone[8]=1;
    }
    else {
      active[8]=1;
      ends[8]=1;
      tdone[8]=1;
    }
  }

  public void thread12138(int [] tdone, int [] ends){
        S8135=1;
    rotaryTableTriggerConvP.setPresent();//sysj\RotaryController.sysj line: 53, column: 8
    currsigs.addElement(rotaryTableTriggerConvP);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread12137(int [] tdone, int [] ends){
        S8130=1;
    rotaryTableTrigger.setPresent();//sysj\RotaryController.sysj line: 51, column: 8
    currsigs.addElement(rotaryTableTrigger);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread12136(int [] tdone, int [] ends){
        S8147=1;
    System.out.println("rotating");//sysj\RotaryController.sysj line: 49, column: 7
    thread12137(tdone,ends);
    thread12138(tdone,ends);
    int biggest12139 = 0;
    if(ends[6]>=biggest12139){
      biggest12139=ends[6];
    }
    if(ends[7]>=biggest12139){
      biggest12139=ends[7];
    }
    if(biggest12139 == 1){
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
  }

  public void thread12134(int [] tdone, int [] ends){
        S8163=1;
    __start_thread_8 = com.systemj.Timer.getMs();//sysj\RotaryController.sysj line: 57, column: 6
    if(com.systemj.Timer.getMs() - __start_thread_8 >= (0.5) * 1000){//sysj\RotaryController.sysj line: 57, column: 6
      ends[8]=3;
      ;//sysj\RotaryController.sysj line: 57, column: 6
      ends[8]=2;
      tdone[8]=1;
    }
    else {
      active[8]=1;
      ends[8]=1;
      tdone[8]=1;
    }
  }

  public void thread12132(int [] tdone, int [] ends){
        S8135=1;
    rotaryTableTriggerConvP.setPresent();//sysj\RotaryController.sysj line: 53, column: 8
    currsigs.addElement(rotaryTableTriggerConvP);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread12131(int [] tdone, int [] ends){
        S8130=1;
    rotaryTableTrigger.setPresent();//sysj\RotaryController.sysj line: 51, column: 8
    currsigs.addElement(rotaryTableTrigger);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread12130(int [] tdone, int [] ends){
        S8147=1;
    System.out.println("rotating");//sysj\RotaryController.sysj line: 49, column: 7
    thread12131(tdone,ends);
    thread12132(tdone,ends);
    int biggest12133 = 0;
    if(ends[6]>=biggest12133){
      biggest12133=ends[6];
    }
    if(ends[7]>=biggest12133){
      biggest12133=ends[7];
    }
    if(biggest12133 == 1){
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
  }

  public void thread12128(int [] tdone, int [] ends){
        switch(S8109){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        if(lidLoaderReady.getprestatus()){//sysj\RotaryController.sysj line: 30, column: 57
          S8109=0;
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

  public void thread12127(int [] tdone, int [] ends){
        switch(S8106){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        if(capperReady.getprestatus()){//sysj\RotaryController.sysj line: 30, column: 34
          S8106=0;
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

  public void thread12126(int [] tdone, int [] ends){
        switch(S8103){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(fillerReady.getprestatus()){//sysj\RotaryController.sysj line: 30, column: 11
          S8103=0;
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

  public void thread12124(int [] tdone, int [] ends){
        S8109=1;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread12123(int [] tdone, int [] ends){
        S8106=1;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread12122(int [] tdone, int [] ends){
        S8103=1;
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
      switch(S12120){
        case 0 : 
          S12120=0;
          break RUN;
        
        case 1 : 
          S12120=2;
          S12120=2;
          System.out.println("got into controller");//sysj\RotaryController.sysj line: 13, column: 3
          S8100=0;
          active[1]=1;
          ends[1]=1;
          break RUN;
        
        case 2 : 
          switch(S8100){
            case 0 : 
              if(bottleAtPos1RC.getprestatus()){//sysj\RotaryController.sysj line: 17, column: 10
                start_r.setPresent();//sysj\RotaryController.sysj line: 18, column: 4
                currsigs.addElement(start_r);
                System.out.println("emitted start");//sysj\RotaryController.sysj line: 21, column: 4
                S8100=1;
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
              S8100=1;
              if((Integer)(bottleTotalRC.getpreval() == null ? null : ((Integer)bottleTotalRC.getpreval())) < (Integer)(BatchQuantityRC.getpreval() == null ? null : ((Integer)BatchQuantityRC.getpreval()))) {//sysj\RotaryController.sysj line: 25, column: 61
                System.out.println("received bottleAtPos1RC");//sysj\RotaryController.sysj line: 27, column: 5
              }
              S8100=2;
              thread12122(tdone,ends);
              thread12123(tdone,ends);
              thread12124(tdone,ends);
              int biggest12125 = 0;
              if(ends[2]>=biggest12125){
                biggest12125=ends[2];
              }
              if(ends[3]>=biggest12125){
                biggest12125=ends[3];
              }
              if(ends[4]>=biggest12125){
                biggest12125=ends[4];
              }
              if(biggest12125 == 1){
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            
            case 2 : 
              thread12126(tdone,ends);
              thread12127(tdone,ends);
              thread12128(tdone,ends);
              int biggest12129 = 0;
              if(ends[2]>=biggest12129){
                biggest12129=ends[2];
              }
              if(ends[3]>=biggest12129){
                biggest12129=ends[3];
              }
              if(ends[4]>=biggest12129){
                biggest12129=ends[4];
              }
              if(biggest12129 == 1){
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              //FINXME code
              if(biggest12129 == 0){
                System.out.println("all ready signals received");//sysj\RotaryController.sysj line: 31, column: 4
                S8100=3;
                if(capOnBottleAtPos1.getprestatus()){//sysj\RotaryController.sysj line: 34, column: 12
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
                else {
                  S8100=4;
                  if(!capOnBottleAtPos1.getprestatus()){//sysj\RotaryController.sysj line: 40, column: 12
                    S8125=0;
                    if((Integer)(wsActiveRC.getpreval() == null ? null : ((Integer)wsActiveRC.getpreval())) > 4){//sysj\RotaryController.sysj line: 41, column: 9
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      System.out.println("awaiting trap");//sysj\RotaryController.sysj line: 45, column: 5
                      S8125=1;
                      thread12130(tdone,ends);
                      thread12134(tdone,ends);
                      int biggest12135 = 0;
                      if(ends[5]>=biggest12135){
                        biggest12135=ends[5];
                      }
                      if(ends[8]>=biggest12135){
                        biggest12135=ends[8];
                      }
                      if(biggest12135 == 1){
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                      if(biggest12135 == 2){
                        ends[1]=2;
                        ;//sysj\RotaryController.sysj line: 47, column: 5
                        System.out.println("exited the trap");//sysj\RotaryController.sysj line: 59, column: 5
                        S8125=2;
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                    }
                  }
                  else {
                    S8100=0;
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                }
              }
            
            case 3 : 
              if(capRemoved.getprestatus()){//sysj\RotaryController.sysj line: 35, column: 11
                S8100=4;
                if(!capOnBottleAtPos1.getprestatus()){//sysj\RotaryController.sysj line: 40, column: 12
                  S8125=0;
                  if((Integer)(wsActiveRC.getpreval() == null ? null : ((Integer)wsActiveRC.getpreval())) > 4){//sysj\RotaryController.sysj line: 41, column: 9
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  else {
                    System.out.println("awaiting trap");//sysj\RotaryController.sysj line: 45, column: 5
                    S8125=1;
                    thread12136(tdone,ends);
                    thread12140(tdone,ends);
                    int biggest12141 = 0;
                    if(ends[5]>=biggest12141){
                      biggest12141=ends[5];
                    }
                    if(ends[8]>=biggest12141){
                      biggest12141=ends[8];
                    }
                    if(biggest12141 == 1){
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    if(biggest12141 == 2){
                      ends[1]=2;
                      ;//sysj\RotaryController.sysj line: 47, column: 5
                      System.out.println("exited the trap");//sysj\RotaryController.sysj line: 59, column: 5
                      S8125=2;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  }
                }
                else {
                  S8100=0;
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
              switch(S8125){
                case 0 : 
                  if(bottleLeftPos5RC.getprestatus()){//sysj\RotaryController.sysj line: 42, column: 13
                    System.out.println("awaiting trap");//sysj\RotaryController.sysj line: 45, column: 5
                    S8125=1;
                    thread12142(tdone,ends);
                    thread12146(tdone,ends);
                    int biggest12147 = 0;
                    if(ends[5]>=biggest12147){
                      biggest12147=ends[5];
                    }
                    if(ends[8]>=biggest12147){
                      biggest12147=ends[8];
                    }
                    if(biggest12147 == 1){
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    if(biggest12147 == 2){
                      ends[1]=2;
                      ;//sysj\RotaryController.sysj line: 47, column: 5
                      System.out.println("exited the trap");//sysj\RotaryController.sysj line: 59, column: 5
                      S8125=2;
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
                  thread12148(tdone,ends);
                  thread12152(tdone,ends);
                  int biggest12153 = 0;
                  if(ends[5]>=biggest12153){
                    biggest12153=ends[5];
                  }
                  if(ends[8]>=biggest12153){
                    biggest12153=ends[8];
                  }
                  if(biggest12153 == 1){
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  if(biggest12153 == 2){
                    ends[1]=2;
                    ;//sysj\RotaryController.sysj line: 47, column: 5
                    System.out.println("exited the trap");//sysj\RotaryController.sysj line: 59, column: 5
                    S8125=2;
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  //FINXME code
                  if(biggest12153 == 0){
                    System.out.println("exited the trap");//sysj\RotaryController.sysj line: 59, column: 5
                    S8125=2;
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                
                case 2 : 
                  if(tableAlignedWithSensor.getprestatus()){//sysj\RotaryController.sysj line: 60, column: 11
                    System.out.println("received aligned signal");//sysj\RotaryController.sysj line: 61, column: 5
                    rotated.setPresent();//sysj\RotaryController.sysj line: 62, column: 5
                    currsigs.addElement(rotated);
                    rotatedConvP.setPresent();//sysj\RotaryController.sysj line: 63, column: 5
                    currsigs.addElement(rotatedConvP);
                    rotatedM.setPresent();//sysj\RotaryController.sysj line: 64, column: 5
                    currsigs.addElement(rotatedM);
                    System.out.println("rotated emitted");//sysj\RotaryController.sysj line: 65, column: 5
                    S8100=0;
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
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0};
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
      rotaryTableTriggerConvP.setpreclear();
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
      rotaryTableTriggerConvP.sethook();
      rotaryTableTriggerConvP.setClear();
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
