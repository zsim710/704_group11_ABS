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
  private int S8428 = 1;
  private int S8427 = 1;
  private int S5529 = 1;
  private int S5536 = 1;
  private int S5539 = 1;
  private int S5542 = 1;
  private int S5567 = 1;
  private int S5575 = 1;
  private int S5591 = 1;
  
  private int[] ends = new int[7];
  private int[] tdone = new int[7];
  
  public void thread8452(int [] tdone, int [] ends){
        switch(S5591){
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

  public void thread8451(int [] tdone, int [] ends){
        switch(S5575){
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

  public void thread8449(int [] tdone, int [] ends){
        S5591=1;
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

  public void thread8448(int [] tdone, int [] ends){
        S5575=1;
    System.out.println("rotating");//sysj\RotaryController.sysj line: 44, column: 7
    rotaryTableTrigger.setPresent();//sysj\RotaryController.sysj line: 45, column: 7
    currsigs.addElement(rotaryTableTrigger);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread8446(int [] tdone, int [] ends){
        S5591=1;
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

  public void thread8445(int [] tdone, int [] ends){
        S5575=1;
    System.out.println("rotating");//sysj\RotaryController.sysj line: 44, column: 7
    rotaryTableTrigger.setPresent();//sysj\RotaryController.sysj line: 45, column: 7
    currsigs.addElement(rotaryTableTrigger);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread8443(int [] tdone, int [] ends){
        S5591=1;
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

  public void thread8442(int [] tdone, int [] ends){
        S5575=1;
    System.out.println("rotating");//sysj\RotaryController.sysj line: 44, column: 7
    rotaryTableTrigger.setPresent();//sysj\RotaryController.sysj line: 45, column: 7
    currsigs.addElement(rotaryTableTrigger);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread8440(int [] tdone, int [] ends){
        switch(S5542){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        if(lidLoaderReady.getprestatus()){//sysj\RotaryController.sysj line: 25, column: 57
          S5542=0;
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

  public void thread8439(int [] tdone, int [] ends){
        switch(S5539){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        if(capperReady.getprestatus()){//sysj\RotaryController.sysj line: 25, column: 34
          S5539=0;
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

  public void thread8438(int [] tdone, int [] ends){
        switch(S5536){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(fillerReady.getprestatus()){//sysj\RotaryController.sysj line: 25, column: 11
          S5536=0;
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

  public void thread8436(int [] tdone, int [] ends){
        S5542=1;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread8435(int [] tdone, int [] ends){
        S5539=1;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread8434(int [] tdone, int [] ends){
        S5536=1;
    active[2]=1;
    ends[2]=1;
    tdone[2]=1;
  }

  public void thread8432(int [] tdone, int [] ends){
        S5542=1;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread8431(int [] tdone, int [] ends){
        S5539=1;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread8430(int [] tdone, int [] ends){
        S5536=1;
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
      switch(S8428){
        case 0 : 
          S8428=0;
          break RUN;
        
        case 1 : 
          S8428=2;
          S8428=2;
          S8427=0;
          active[1]=1;
          ends[1]=1;
          break RUN;
        
        case 2 : 
          switch(S8427){
            case 0 : 
              S8427=0;
              S8427=1;
              System.out.println("awaiting start");//sysj\RotaryController.sysj line: 16, column: 4
              S5529=0;
              if(start.getprestatus()){//sysj\RotaryController.sysj line: 17, column: 20
                System.out.println("received start");//sysj\RotaryController.sysj line: 18, column: 4
                S5529=1;
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
              switch(S5529){
                case 0 : 
                  if(start.getprestatus()){//sysj\RotaryController.sysj line: 17, column: 20
                    System.out.println("received start");//sysj\RotaryController.sysj line: 18, column: 4
                    S5529=1;
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
                  S5529=1;
                  S5529=2;
                  if((Integer)(bottleTotalRC.getpreval() == null ? null : ((Integer)bottleTotalRC.getpreval())) < (Integer)(BatchQuantityRC.getpreval() == null ? null : ((Integer)BatchQuantityRC.getpreval()))){//sysj\RotaryController.sysj line: 21, column: 8
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  else {
                    S5529=3;
                    thread8430(tdone,ends);
                    thread8431(tdone,ends);
                    thread8432(tdone,ends);
                    int biggest8433 = 0;
                    if(ends[2]>=biggest8433){
                      biggest8433=ends[2];
                    }
                    if(ends[3]>=biggest8433){
                      biggest8433=ends[3];
                    }
                    if(ends[4]>=biggest8433){
                      biggest8433=ends[4];
                    }
                    if(biggest8433 == 1){
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  }
                
                case 2 : 
                  if(bottleAtPos1RC.getprestatus()){//sysj\RotaryController.sysj line: 22, column: 11
                    S5529=3;
                    thread8434(tdone,ends);
                    thread8435(tdone,ends);
                    thread8436(tdone,ends);
                    int biggest8437 = 0;
                    if(ends[2]>=biggest8437){
                      biggest8437=ends[2];
                    }
                    if(ends[3]>=biggest8437){
                      biggest8437=ends[3];
                    }
                    if(ends[4]>=biggest8437){
                      biggest8437=ends[4];
                    }
                    if(biggest8437 == 1){
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
                  thread8438(tdone,ends);
                  thread8439(tdone,ends);
                  thread8440(tdone,ends);
                  int biggest8441 = 0;
                  if(ends[2]>=biggest8441){
                    biggest8441=ends[2];
                  }
                  if(ends[3]>=biggest8441){
                    biggest8441=ends[3];
                  }
                  if(ends[4]>=biggest8441){
                    biggest8441=ends[4];
                  }
                  if(biggest8441 == 1){
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  //FINXME code
                  if(biggest8441 == 0){
                    System.out.println("all ready signals received");//sysj\RotaryController.sysj line: 26, column: 4
                    S5529=4;
                    if(capOnBottleAtPos1.getprestatus()){//sysj\RotaryController.sysj line: 29, column: 12
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      S5529=5;
                      if(!capOnBottleAtPos1.getprestatus()){//sysj\RotaryController.sysj line: 35, column: 12
                        S5567=0;
                        if((Integer)(wsActiveRC.getpreval() == null ? null : ((Integer)wsActiveRC.getpreval())) > 4){//sysj\RotaryController.sysj line: 36, column: 9
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          System.out.println("awaiting trap");//sysj\RotaryController.sysj line: 40, column: 5
                          S5567=1;
                          thread8442(tdone,ends);
                          thread8443(tdone,ends);
                          int biggest8444 = 0;
                          if(ends[5]>=biggest8444){
                            biggest8444=ends[5];
                          }
                          if(ends[6]>=biggest8444){
                            biggest8444=ends[6];
                          }
                          if(biggest8444 == 1){
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          if(biggest8444 == 2){
                            ends[1]=2;
                            ;//sysj\RotaryController.sysj line: 42, column: 5
                            S5567=2;
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        System.out.println("awaiting start");//sysj\RotaryController.sysj line: 16, column: 4
                        S5529=0;
                        if(start.getprestatus()){//sysj\RotaryController.sysj line: 17, column: 20
                          System.out.println("received start");//sysj\RotaryController.sysj line: 18, column: 4
                          S5529=1;
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
                    S5529=5;
                    if(!capOnBottleAtPos1.getprestatus()){//sysj\RotaryController.sysj line: 35, column: 12
                      S5567=0;
                      if((Integer)(wsActiveRC.getpreval() == null ? null : ((Integer)wsActiveRC.getpreval())) > 4){//sysj\RotaryController.sysj line: 36, column: 9
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                      else {
                        System.out.println("awaiting trap");//sysj\RotaryController.sysj line: 40, column: 5
                        S5567=1;
                        thread8445(tdone,ends);
                        thread8446(tdone,ends);
                        int biggest8447 = 0;
                        if(ends[5]>=biggest8447){
                          biggest8447=ends[5];
                        }
                        if(ends[6]>=biggest8447){
                          biggest8447=ends[6];
                        }
                        if(biggest8447 == 1){
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        if(biggest8447 == 2){
                          ends[1]=2;
                          ;//sysj\RotaryController.sysj line: 42, column: 5
                          S5567=2;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      System.out.println("awaiting start");//sysj\RotaryController.sysj line: 16, column: 4
                      S5529=0;
                      if(start.getprestatus()){//sysj\RotaryController.sysj line: 17, column: 20
                        System.out.println("received start");//sysj\RotaryController.sysj line: 18, column: 4
                        S5529=1;
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
                  switch(S5567){
                    case 0 : 
                      if(bottleLeftPos5RC.getprestatus()){//sysj\RotaryController.sysj line: 37, column: 13
                        System.out.println("awaiting trap");//sysj\RotaryController.sysj line: 40, column: 5
                        S5567=1;
                        thread8448(tdone,ends);
                        thread8449(tdone,ends);
                        int biggest8450 = 0;
                        if(ends[5]>=biggest8450){
                          biggest8450=ends[5];
                        }
                        if(ends[6]>=biggest8450){
                          biggest8450=ends[6];
                        }
                        if(biggest8450 == 1){
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        if(biggest8450 == 2){
                          ends[1]=2;
                          ;//sysj\RotaryController.sysj line: 42, column: 5
                          S5567=2;
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
                      thread8451(tdone,ends);
                      thread8452(tdone,ends);
                      int biggest8453 = 0;
                      if(ends[5]>=biggest8453){
                        biggest8453=ends[5];
                      }
                      if(ends[6]>=biggest8453){
                        biggest8453=ends[6];
                      }
                      if(biggest8453 == 1){
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                      if(biggest8453 == 2){
                        ends[1]=2;
                        ;//sysj\RotaryController.sysj line: 42, column: 5
                        S5567=2;
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                      //FINXME code
                      if(biggest8453 == 0){
                        S5567=2;
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
                        S5567=3;
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
                      S5567=3;
                      System.out.println("awaiting start");//sysj\RotaryController.sysj line: 16, column: 4
                      S5529=0;
                      if(start.getprestatus()){//sysj\RotaryController.sysj line: 17, column: 20
                        System.out.println("received start");//sysj\RotaryController.sysj line: 18, column: 4
                        S5529=1;
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
