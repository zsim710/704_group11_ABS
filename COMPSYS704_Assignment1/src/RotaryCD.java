import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.GUI;//sysj\RotaryController.sysj line: 1, column: 1

public class RotaryCD extends ClockDomain{
  public RotaryCD(String name){super(name);}
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
  private long __start_thread_6;//sysj\RotaryController.sysj line: 39, column: 37
  private int S5797 = 1;
  private int S4795 = 1;
  private int S4798 = 1;
  private int S4801 = 1;
  private int S4804 = 1;
  private int S4832 = 1;
  private int S4837 = 1;
  private int S4853 = 1;
  
  private int[] ends = new int[7];
  private int[] tdone = new int[7];
  
  public void thread5815(int [] tdone, int [] ends){
        switch(S4853){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        if(com.systemj.Timer.getMs() - __start_thread_6 >= 500){//sysj\RotaryController.sysj line: 39, column: 37
          ends[6]=3;
          ;//sysj\RotaryController.sysj line: 39, column: 37
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

  public void thread5814(int [] tdone, int [] ends){
        switch(S4837){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        rotaryTableTrigger.setPresent();//sysj\RotaryController.sysj line: 39, column: 7
        currsigs.addElement(rotaryTableTrigger);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread5812(int [] tdone, int [] ends){
        S4853=1;
    __start_thread_6 = com.systemj.Timer.getMs();//sysj\RotaryController.sysj line: 39, column: 37
    if(com.systemj.Timer.getMs() - __start_thread_6 >= 500){//sysj\RotaryController.sysj line: 39, column: 37
      ends[6]=3;
      ;//sysj\RotaryController.sysj line: 39, column: 37
      ends[6]=2;
      tdone[6]=1;
    }
    else {
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
  }

  public void thread5811(int [] tdone, int [] ends){
        S4837=1;
    rotaryTableTrigger.setPresent();//sysj\RotaryController.sysj line: 39, column: 7
    currsigs.addElement(rotaryTableTrigger);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread5809(int [] tdone, int [] ends){
        switch(S4804){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        if(lidLoaderReady.getprestatus()){//sysj\RotaryController.sysj line: 21, column: 57
          S4804=0;
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

  public void thread5808(int [] tdone, int [] ends){
        switch(S4801){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        if(capperReady.getprestatus()){//sysj\RotaryController.sysj line: 21, column: 34
          S4801=0;
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

  public void thread5807(int [] tdone, int [] ends){
        switch(S4798){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(fillerReady.getprestatus()){//sysj\RotaryController.sysj line: 21, column: 11
          S4798=0;
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

  public void thread5805(int [] tdone, int [] ends){
        S4804=1;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread5804(int [] tdone, int [] ends){
        S4801=1;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread5803(int [] tdone, int [] ends){
        S4798=1;
    active[2]=1;
    ends[2]=1;
    tdone[2]=1;
  }

  public void thread5801(int [] tdone, int [] ends){
        S4804=1;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread5800(int [] tdone, int [] ends){
        S4801=1;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread5799(int [] tdone, int [] ends){
        S4798=1;
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
      switch(S5797){
        case 0 : 
          S5797=0;
          break RUN;
        
        case 1 : 
          S5797=2;
          S5797=2;
          S4795=0;
          active[1]=1;
          ends[1]=1;
          break RUN;
        
        case 2 : 
          switch(S4795){
            case 0 : 
              S4795=0;
              S4795=1;
              if((Integer)(bottleTotalRC.getpreval() == null ? null : ((Integer)bottleTotalRC.getpreval())) < (Integer)(BatchQuantityRC.getpreval() == null ? null : ((Integer)BatchQuantityRC.getpreval()))){//sysj\RotaryController.sysj line: 17, column: 8
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                S4795=2;
                thread5799(tdone,ends);
                thread5800(tdone,ends);
                thread5801(tdone,ends);
                int biggest5802 = 0;
                if(ends[2]>=biggest5802){
                  biggest5802=ends[2];
                }
                if(ends[3]>=biggest5802){
                  biggest5802=ends[3];
                }
                if(ends[4]>=biggest5802){
                  biggest5802=ends[4];
                }
                if(biggest5802 == 1){
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
            
            case 1 : 
              if(bottleAtPos1RC.getprestatus()){//sysj\RotaryController.sysj line: 18, column: 11
                S4795=2;
                thread5803(tdone,ends);
                thread5804(tdone,ends);
                thread5805(tdone,ends);
                int biggest5806 = 0;
                if(ends[2]>=biggest5806){
                  biggest5806=ends[2];
                }
                if(ends[3]>=biggest5806){
                  biggest5806=ends[3];
                }
                if(ends[4]>=biggest5806){
                  biggest5806=ends[4];
                }
                if(biggest5806 == 1){
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
              thread5807(tdone,ends);
              thread5808(tdone,ends);
              thread5809(tdone,ends);
              int biggest5810 = 0;
              if(ends[2]>=biggest5810){
                biggest5810=ends[2];
              }
              if(ends[3]>=biggest5810){
                biggest5810=ends[3];
              }
              if(ends[4]>=biggest5810){
                biggest5810=ends[4];
              }
              if(biggest5810 == 1){
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              //FINXME code
              if(biggest5810 == 0){
                System.out.println("all ready signals received");//sysj\RotaryController.sysj line: 22, column: 4
                S4795=3;
                if(capOnBottleAtPos1.getprestatus()){//sysj\RotaryController.sysj line: 25, column: 12
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
                else {
                  S4795=4;
                  if(!capOnBottleAtPos1.getprestatus()){//sysj\RotaryController.sysj line: 31, column: 12
                    S4832=0;
                    if((Integer)(wsActiveRC.getpreval() == null ? null : ((Integer)wsActiveRC.getpreval())) > 4){//sysj\RotaryController.sysj line: 32, column: 9
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      S4832=1;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  }
                  else {
                    S4795=0;
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                }
              }
            
            case 3 : 
              if(capRemoved.getprestatus()){//sysj\RotaryController.sysj line: 26, column: 11
                S4795=4;
                if(!capOnBottleAtPos1.getprestatus()){//sysj\RotaryController.sysj line: 31, column: 12
                  S4832=0;
                  if((Integer)(wsActiveRC.getpreval() == null ? null : ((Integer)wsActiveRC.getpreval())) > 4){//sysj\RotaryController.sysj line: 32, column: 9
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  else {
                    S4832=1;
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                }
                else {
                  S4795=0;
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
              switch(S4832){
                case 0 : 
                  if(bottleLeftPos5RC.getprestatus()){//sysj\RotaryController.sysj line: 33, column: 13
                    S4832=1;
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
                  if(start.getprestatus()){//sysj\RotaryController.sysj line: 36, column: 11
                    S4832=2;
                    thread5811(tdone,ends);
                    thread5812(tdone,ends);
                    int biggest5813 = 0;
                    if(ends[5]>=biggest5813){
                      biggest5813=ends[5];
                    }
                    if(ends[6]>=biggest5813){
                      biggest5813=ends[6];
                    }
                    if(biggest5813 == 1){
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    if(biggest5813 == 2){
                      ends[1]=2;
                      ;//sysj\RotaryController.sysj line: 38, column: 5
                      S4832=3;
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
                  thread5814(tdone,ends);
                  thread5815(tdone,ends);
                  int biggest5816 = 0;
                  if(ends[5]>=biggest5816){
                    biggest5816=ends[5];
                  }
                  if(ends[6]>=biggest5816){
                    biggest5816=ends[6];
                  }
                  if(biggest5816 == 1){
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  if(biggest5816 == 2){
                    ends[1]=2;
                    ;//sysj\RotaryController.sysj line: 38, column: 5
                    S4832=3;
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  //FINXME code
                  if(biggest5816 == 0){
                    S4832=3;
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                
                case 3 : 
                  if(tableAlignedWithSensor.getprestatus()){//sysj\RotaryController.sysj line: 41, column: 11
                    rotated.setPresent();//sysj\RotaryController.sysj line: 42, column: 5
                    currsigs.addElement(rotated);
                    rotatedConvP.setPresent();//sysj\RotaryController.sysj line: 43, column: 5
                    currsigs.addElement(rotatedConvP);
                    System.out.println("rotated emitted");//sysj\RotaryController.sysj line: 44, column: 5
                    S4832=4;
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
                  S4832=4;
                  S4795=0;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                
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
