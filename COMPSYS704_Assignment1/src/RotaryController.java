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
  public Signal start = new Signal("start", Signal.INPUT);
  public Signal wsActiveRC = new Signal("wsActiveRC", Signal.INPUT);
  public Signal bottleTotalRC = new Signal("bottleTotalRC", Signal.INPUT);
  public Signal BatchQuantityRC = new Signal("BatchQuantityRC", Signal.INPUT);
  public Signal rotaryTableTrigger = new Signal("rotaryTableTrigger", Signal.OUTPUT);
  public Signal rotated = new Signal("rotated", Signal.OUTPUT);
  public Signal rotatedConvP = new Signal("rotatedConvP", Signal.OUTPUT);
  public Signal bottleAtPos2 = new Signal("bottleAtPos2", Signal.OUTPUT);
  public Signal bottleAtPos3 = new Signal("bottleAtPos3", Signal.OUTPUT);
  public Signal bottleAtPos4 = new Signal("bottleAtPos4", Signal.OUTPUT);
  private long __start_thread_6;//sysj\RotaryController.sysj line: 48, column: 6
  private int S7692 = 1;
  private int S7691 = 1;
  private int S4793 = 1;
  private int S4800 = 1;
  private int S4803 = 1;
  private int S4806 = 1;
  private int S4831 = 1;
  private int S4839 = 1;
  private int S4855 = 1;
  
  private int[] ends = new int[7];
  private int[] tdone = new int[7];
  
  public void thread7716(int [] tdone, int [] ends){
        switch(S4855){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        if(com.systemj.Timer.getMs() - __start_thread_6 >= (0.5) * 1000){//sysj\RotaryController.sysj line: 48, column: 6
          ends[6]=3;
          ;//sysj\RotaryController.sysj line: 48, column: 6
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

  public void thread7715(int [] tdone, int [] ends){
        switch(S4839){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        rotaryTableTrigger.setPresent();//sysj\RotaryController.sysj line: 45, column: 7
        currsigs.addElement(rotaryTableTrigger);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread7713(int [] tdone, int [] ends){
        S4855=1;
    __start_thread_6 = com.systemj.Timer.getMs();//sysj\RotaryController.sysj line: 48, column: 6
    if(com.systemj.Timer.getMs() - __start_thread_6 >= (0.5) * 1000){//sysj\RotaryController.sysj line: 48, column: 6
      ends[6]=3;
      ;//sysj\RotaryController.sysj line: 48, column: 6
      ends[6]=2;
      tdone[6]=1;
    }
    else {
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
  }

  public void thread7712(int [] tdone, int [] ends){
        S4839=1;
    System.out.println("rotating");//sysj\RotaryController.sysj line: 44, column: 7
    rotaryTableTrigger.setPresent();//sysj\RotaryController.sysj line: 45, column: 7
    currsigs.addElement(rotaryTableTrigger);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread7710(int [] tdone, int [] ends){
        S4855=1;
    __start_thread_6 = com.systemj.Timer.getMs();//sysj\RotaryController.sysj line: 48, column: 6
    if(com.systemj.Timer.getMs() - __start_thread_6 >= (0.5) * 1000){//sysj\RotaryController.sysj line: 48, column: 6
      ends[6]=3;
      ;//sysj\RotaryController.sysj line: 48, column: 6
      ends[6]=2;
      tdone[6]=1;
    }
    else {
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
  }

  public void thread7709(int [] tdone, int [] ends){
        S4839=1;
    System.out.println("rotating");//sysj\RotaryController.sysj line: 44, column: 7
    rotaryTableTrigger.setPresent();//sysj\RotaryController.sysj line: 45, column: 7
    currsigs.addElement(rotaryTableTrigger);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread7707(int [] tdone, int [] ends){
        S4855=1;
    __start_thread_6 = com.systemj.Timer.getMs();//sysj\RotaryController.sysj line: 48, column: 6
    if(com.systemj.Timer.getMs() - __start_thread_6 >= (0.5) * 1000){//sysj\RotaryController.sysj line: 48, column: 6
      ends[6]=3;
      ;//sysj\RotaryController.sysj line: 48, column: 6
      ends[6]=2;
      tdone[6]=1;
    }
    else {
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
  }

  public void thread7706(int [] tdone, int [] ends){
        S4839=1;
    System.out.println("rotating");//sysj\RotaryController.sysj line: 44, column: 7
    rotaryTableTrigger.setPresent();//sysj\RotaryController.sysj line: 45, column: 7
    currsigs.addElement(rotaryTableTrigger);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread7704(int [] tdone, int [] ends){
        switch(S4806){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        if(lidLoaderReady.getprestatus()){//sysj\RotaryController.sysj line: 25, column: 57
          S4806=0;
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

  public void thread7703(int [] tdone, int [] ends){
        switch(S4803){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        if(capperReady.getprestatus()){//sysj\RotaryController.sysj line: 25, column: 34
          S4803=0;
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

  public void thread7702(int [] tdone, int [] ends){
        switch(S4800){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(fillerReady.getprestatus()){//sysj\RotaryController.sysj line: 25, column: 11
          S4800=0;
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

  public void thread7700(int [] tdone, int [] ends){
        S4806=1;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread7699(int [] tdone, int [] ends){
        S4803=1;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread7698(int [] tdone, int [] ends){
        S4800=1;
    active[2]=1;
    ends[2]=1;
    tdone[2]=1;
  }

  public void thread7696(int [] tdone, int [] ends){
        S4806=1;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread7695(int [] tdone, int [] ends){
        S4803=1;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread7694(int [] tdone, int [] ends){
        S4800=1;
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
      switch(S7692){
        case 0 : 
          S7692=0;
          break RUN;
        
        case 1 : 
          S7692=2;
          S7692=2;
          S7691=0;
          active[1]=1;
          ends[1]=1;
          break RUN;
        
        case 2 : 
          switch(S7691){
            case 0 : 
              S7691=0;
              S7691=1;
              System.out.println("awaiting start");//sysj\RotaryController.sysj line: 16, column: 4
              S4793=0;
              if(start.getprestatus()){//sysj\RotaryController.sysj line: 17, column: 20
                System.out.println("received start");//sysj\RotaryController.sysj line: 18, column: 4
                S4793=1;
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
              switch(S4793){
                case 0 : 
                  if(start.getprestatus()){//sysj\RotaryController.sysj line: 17, column: 20
                    System.out.println("received start");//sysj\RotaryController.sysj line: 18, column: 4
                    S4793=1;
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
                  S4793=1;
                  S4793=2;
                  if((Integer)(bottleTotalRC.getpreval() == null ? null : ((Integer)bottleTotalRC.getpreval())) < (Integer)(BatchQuantityRC.getpreval() == null ? null : ((Integer)BatchQuantityRC.getpreval()))){//sysj\RotaryController.sysj line: 21, column: 8
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  else {
                    S4793=3;
                    thread7694(tdone,ends);
                    thread7695(tdone,ends);
                    thread7696(tdone,ends);
                    int biggest7697 = 0;
                    if(ends[2]>=biggest7697){
                      biggest7697=ends[2];
                    }
                    if(ends[3]>=biggest7697){
                      biggest7697=ends[3];
                    }
                    if(ends[4]>=biggest7697){
                      biggest7697=ends[4];
                    }
                    if(biggest7697 == 1){
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  }
                
                case 2 : 
                  if(bottleAtPos1RC.getprestatus()){//sysj\RotaryController.sysj line: 22, column: 11
                    S4793=3;
                    thread7698(tdone,ends);
                    thread7699(tdone,ends);
                    thread7700(tdone,ends);
                    int biggest7701 = 0;
                    if(ends[2]>=biggest7701){
                      biggest7701=ends[2];
                    }
                    if(ends[3]>=biggest7701){
                      biggest7701=ends[3];
                    }
                    if(ends[4]>=biggest7701){
                      biggest7701=ends[4];
                    }
                    if(biggest7701 == 1){
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
                
                case 3 : 
                  thread7702(tdone,ends);
                  thread7703(tdone,ends);
                  thread7704(tdone,ends);
                  int biggest7705 = 0;
                  if(ends[2]>=biggest7705){
                    biggest7705=ends[2];
                  }
                  if(ends[3]>=biggest7705){
                    biggest7705=ends[3];
                  }
                  if(ends[4]>=biggest7705){
                    biggest7705=ends[4];
                  }
                  if(biggest7705 == 1){
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  //FINXME code
                  if(biggest7705 == 0){
                    System.out.println("all ready signals received");//sysj\RotaryController.sysj line: 26, column: 4
                    S4793=4;
                    if(capOnBottleAtPos1.getprestatus()){//sysj\RotaryController.sysj line: 29, column: 12
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      S4793=5;
                      if(!capOnBottleAtPos1.getprestatus()){//sysj\RotaryController.sysj line: 35, column: 12
                        S4831=0;
                        if((Integer)(wsActiveRC.getpreval() == null ? null : ((Integer)wsActiveRC.getpreval())) > 4){//sysj\RotaryController.sysj line: 36, column: 9
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          System.out.println("awaiting trap");//sysj\RotaryController.sysj line: 40, column: 5
                          S4831=1;
                          thread7706(tdone,ends);
                          thread7707(tdone,ends);
                          int biggest7708 = 0;
                          if(ends[5]>=biggest7708){
                            biggest7708=ends[5];
                          }
                          if(ends[6]>=biggest7708){
                            biggest7708=ends[6];
                          }
                          if(biggest7708 == 1){
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          if(biggest7708 == 2){
                            ends[1]=2;
                            ;//sysj\RotaryController.sysj line: 42, column: 5
                            S4831=2;
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        System.out.println("awaiting start");//sysj\RotaryController.sysj line: 16, column: 4
                        S4793=0;
                        if(start.getprestatus()){//sysj\RotaryController.sysj line: 17, column: 20
                          System.out.println("received start");//sysj\RotaryController.sysj line: 18, column: 4
                          S4793=1;
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
                
                case 4 : 
                  if(capRemoved.getprestatus()){//sysj\RotaryController.sysj line: 30, column: 11
                    S4793=5;
                    if(!capOnBottleAtPos1.getprestatus()){//sysj\RotaryController.sysj line: 35, column: 12
                      S4831=0;
                      if((Integer)(wsActiveRC.getpreval() == null ? null : ((Integer)wsActiveRC.getpreval())) > 4){//sysj\RotaryController.sysj line: 36, column: 9
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                      else {
                        System.out.println("awaiting trap");//sysj\RotaryController.sysj line: 40, column: 5
                        S4831=1;
                        thread7709(tdone,ends);
                        thread7710(tdone,ends);
                        int biggest7711 = 0;
                        if(ends[5]>=biggest7711){
                          biggest7711=ends[5];
                        }
                        if(ends[6]>=biggest7711){
                          biggest7711=ends[6];
                        }
                        if(biggest7711 == 1){
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        if(biggest7711 == 2){
                          ends[1]=2;
                          ;//sysj\RotaryController.sysj line: 42, column: 5
                          S4831=2;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      System.out.println("awaiting start");//sysj\RotaryController.sysj line: 16, column: 4
                      S4793=0;
                      if(start.getprestatus()){//sysj\RotaryController.sysj line: 17, column: 20
                        System.out.println("received start");//sysj\RotaryController.sysj line: 18, column: 4
                        S4793=1;
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
                  else {
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                
                case 5 : 
                  switch(S4831){
                    case 0 : 
                      if(bottleLeftPos5RC.getprestatus()){//sysj\RotaryController.sysj line: 37, column: 13
                        System.out.println("awaiting trap");//sysj\RotaryController.sysj line: 40, column: 5
                        S4831=1;
                        thread7712(tdone,ends);
                        thread7713(tdone,ends);
                        int biggest7714 = 0;
                        if(ends[5]>=biggest7714){
                          biggest7714=ends[5];
                        }
                        if(ends[6]>=biggest7714){
                          biggest7714=ends[6];
                        }
                        if(biggest7714 == 1){
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        if(biggest7714 == 2){
                          ends[1]=2;
                          ;//sysj\RotaryController.sysj line: 42, column: 5
                          S4831=2;
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
                      thread7715(tdone,ends);
                      thread7716(tdone,ends);
                      int biggest7717 = 0;
                      if(ends[5]>=biggest7717){
                        biggest7717=ends[5];
                      }
                      if(ends[6]>=biggest7717){
                        biggest7717=ends[6];
                      }
                      if(biggest7717 == 1){
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                      if(biggest7717 == 2){
                        ends[1]=2;
                        ;//sysj\RotaryController.sysj line: 42, column: 5
                        S4831=2;
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                      //FINXME code
                      if(biggest7717 == 0){
                        S4831=2;
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                    
                    case 2 : 
                      if(tableAlignedWithSensor.getprestatus()){//sysj\RotaryController.sysj line: 51, column: 11
                        System.out.println("received aligned signal");//sysj\RotaryController.sysj line: 52, column: 5
                        rotated.setPresent();//sysj\RotaryController.sysj line: 53, column: 5
                        currsigs.addElement(rotated);
                        rotatedConvP.setPresent();//sysj\RotaryController.sysj line: 54, column: 5
                        currsigs.addElement(rotatedConvP);
                        System.out.println("rotated emitted");//sysj\RotaryController.sysj line: 55, column: 5
                        S4831=3;
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
                      S4831=3;
                      System.out.println("awaiting start");//sysj\RotaryController.sysj line: 16, column: 4
                      S4793=0;
                      if(start.getprestatus()){//sysj\RotaryController.sysj line: 17, column: 20
                        System.out.println("received start");//sysj\RotaryController.sysj line: 18, column: 4
                        S4793=1;
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
          start.gethook();
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
      start.setpreclear();
      wsActiveRC.setpreclear();
      bottleTotalRC.setpreclear();
      BatchQuantityRC.setpreclear();
      rotaryTableTrigger.setpreclear();
      rotated.setpreclear();
      rotatedConvP.setpreclear();
      bottleAtPos2.setpreclear();
      bottleAtPos3.setpreclear();
      bottleAtPos4.setpreclear();
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
      dummyint = start.getStatus() ? start.setprepresent() : start.setpreclear();
      start.setpreval(start.getValue());
      start.setClear();
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
        start.gethook();
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
