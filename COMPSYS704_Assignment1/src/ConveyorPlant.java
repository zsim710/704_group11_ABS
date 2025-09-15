import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.GUI;//sysj\ConveyorPlant.sysj line: 1, column: 1

public class ConveyorPlant extends ClockDomain{
  public ConveyorPlant(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal motConveyorOn = new Signal("motConveyorOn", Signal.INPUT);
  public Signal enableConveyor = new Signal("enableConveyor", Signal.INPUT);
  public Signal bottleAtPos5 = new Signal("bottleAtPos5", Signal.INPUT);
  public Signal rotatedConvP = new Signal("rotatedConvP", Signal.INPUT);
  public Signal bottleAtPos1ConvC = new Signal("bottleAtPos1ConvC", Signal.OUTPUT);
  public Signal bottleAtPos1RC = new Signal("bottleAtPos1RC", Signal.OUTPUT);
  public Signal bottleAtPos1M = new Signal("bottleAtPos1M", Signal.OUTPUT);
  public Signal bottleLeftPos5ConvC = new Signal("bottleLeftPos5ConvC", Signal.OUTPUT);
  public Signal bottleLeftPos5M = new Signal("bottleLeftPos5M", Signal.OUTPUT);
  public Signal bottleLeftPos5RC = new Signal("bottleLeftPos5RC", Signal.OUTPUT);
  public Signal bottleLeftPos5RotaryGUI = new Signal("bottleLeftPos5RotaryGUI", Signal.OUTPUT);
  public Signal bottleAtPos1RotaryGUI = new Signal("bottleAtPos1RotaryGUI", Signal.OUTPUT);
  public Signal bottleAtPos1ConveyorGUI = new Signal("bottleAtPos1ConveyorGUI", Signal.OUTPUT);
  public Signal bottleLeftPos5ConveyorGUI = new Signal("bottleLeftPos5ConveyorGUI", Signal.OUTPUT);
  public Signal bottleAtLoadGUI = new Signal("bottleAtLoadGUI", Signal.OUTPUT);
  private long __start_thread_2;//sysj\ConveyorPlant.sysj line: 21, column: 2
  private long __start_thread_3;//sysj\ConveyorPlant.sysj line: 33, column: 2
  private int S1780 = 1;
  private int S1305 = 1;
  private int S1409 = 1;
  private int S1307 = 1;
  private int S1309 = 1;
  private int S1513 = 1;
  private int S1439 = 1;
  private int S1542 = 1;
  private int S1524 = 1;
  private int S1532 = 1;
  private int S1540 = 1;
  
  private int[] ends = new int[8];
  private int[] tdone = new int[8];
  
  public void thread1795(int [] tdone, int [] ends){
        switch(S1540){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        if(motConveyorOn.getprestatus()){//sysj\ConveyorPlant.sysj line: 53, column: 25
          bottleAtLoadGUI.setPresent();//sysj\ConveyorPlant.sysj line: 53, column: 40
          currsigs.addElement(bottleAtLoadGUI);
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
      
    }
  }

  public void thread1794(int [] tdone, int [] ends){
        switch(S1532){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        if(bottleLeftPos5ConvC.getprestatus()){//sysj\ConveyorPlant.sysj line: 51, column: 24
          bottleLeftPos5RotaryGUI.setPresent();//sysj\ConveyorPlant.sysj line: 51, column: 45
          currsigs.addElement(bottleLeftPos5RotaryGUI);
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
      
    }
  }

  public void thread1793(int [] tdone, int [] ends){
        switch(S1524){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        if(bottleAtPos1ConvC.getprestatus()){//sysj\ConveyorPlant.sysj line: 47, column: 24
          bottleAtPos1RotaryGUI.setPresent();//sysj\ConveyorPlant.sysj line: 47, column: 43
          currsigs.addElement(bottleAtPos1RotaryGUI);
          bottleAtPos1ConveyorGUI.setPresent();//sysj\ConveyorPlant.sysj line: 48, column: 3
          currsigs.addElement(bottleAtPos1ConveyorGUI);
          bottleAtPos1RC.setPresent();//sysj\ConveyorPlant.sysj line: 49, column: 3
          currsigs.addElement(bottleAtPos1RC);
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        else {
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        break;
      
    }
  }

  public void thread1792(int [] tdone, int [] ends){
        switch(S1542){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        thread1793(tdone,ends);
        thread1794(tdone,ends);
        thread1795(tdone,ends);
        int biggest1796 = 0;
        if(ends[5]>=biggest1796){
          biggest1796=ends[5];
        }
        if(ends[6]>=biggest1796){
          biggest1796=ends[6];
        }
        if(ends[7]>=biggest1796){
          biggest1796=ends[7];
        }
        if(biggest1796 == 1){
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
        //FINXME code
        if(biggest1796 == 0){
          S1542=0;
          active[4]=0;
          ends[4]=0;
          tdone[4]=1;
        }
        break;
      
    }
  }

  public void thread1791(int [] tdone, int [] ends){
        switch(S1513){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S1439){
          case 0 : 
            if(bottleAtPos5.getprestatus()){//sysj\ConveyorPlant.sysj line: 36, column: 10
              S1439=1;
              __start_thread_3 = com.systemj.Timer.getMs();//sysj\ConveyorPlant.sysj line: 33, column: 2
              if(com.systemj.Timer.getMs() - __start_thread_3 >= (1) * 1000){//sysj\ConveyorPlant.sysj line: 33, column: 2
                ends[3]=2;
                ;//sysj\ConveyorPlant.sysj line: 33, column: 2
                System.out.println("bottle left pos 5");//sysj\ConveyorPlant.sysj line: 38, column: 4
                bottleLeftPos5M.setPresent();//sysj\ConveyorPlant.sysj line: 39, column: 4
                currsigs.addElement(bottleLeftPos5M);
                bottleLeftPos5ConvC.setPresent();//sysj\ConveyorPlant.sysj line: 40, column: 4
                currsigs.addElement(bottleLeftPos5ConvC);
                S1439=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
            }
            else {
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 1 : 
            if(com.systemj.Timer.getMs() - __start_thread_3 >= (1) * 1000){//sysj\ConveyorPlant.sysj line: 33, column: 2
              ends[3]=2;
              ;//sysj\ConveyorPlant.sysj line: 33, column: 2
              System.out.println("bottle left pos 5");//sysj\ConveyorPlant.sysj line: 38, column: 4
              bottleLeftPos5M.setPresent();//sysj\ConveyorPlant.sysj line: 39, column: 4
              currsigs.addElement(bottleLeftPos5M);
              bottleLeftPos5ConvC.setPresent();//sysj\ConveyorPlant.sysj line: 40, column: 4
              currsigs.addElement(bottleLeftPos5ConvC);
              S1439=2;
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
          
          case 2 : 
            if(rotatedConvP.getprestatus()){//sysj\ConveyorPlant.sysj line: 41, column: 10
              S1439=0;
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
          
        }
        break;
      
    }
  }

  public void thread1790(int [] tdone, int [] ends){
        switch(S1409){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S1307){
          case 0 : 
            if(motConveyorOn.getprestatus()){//sysj\ConveyorPlant.sysj line: 24, column: 10
              System.out.println("conveyor is moving");//sysj\ConveyorPlant.sysj line: 25, column: 4
              S1307=1;
              __start_thread_2 = com.systemj.Timer.getMs();//sysj\ConveyorPlant.sysj line: 21, column: 2
              S1309=0;
              if(com.systemj.Timer.getMs() - __start_thread_2 >= (1) * 1000){//sysj\ConveyorPlant.sysj line: 21, column: 2
                ends[2]=2;
                ;//sysj\ConveyorPlant.sysj line: 21, column: 2
                System.out.println("bottle at pos1");//sysj\ConveyorPlant.sysj line: 27, column: 4
                bottleAtPos1ConvC.setPresent();//sysj\ConveyorPlant.sysj line: 28, column: 4
                currsigs.addElement(bottleAtPos1ConvC);
                S1307=2;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S1309=1;
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
            switch(S1309){
              case 0 : 
                S1309=0;
                if(com.systemj.Timer.getMs() - __start_thread_2 >= (1) * 1000){//sysj\ConveyorPlant.sysj line: 21, column: 2
                  ends[2]=2;
                  ;//sysj\ConveyorPlant.sysj line: 21, column: 2
                  System.out.println("bottle at pos1");//sysj\ConveyorPlant.sysj line: 27, column: 4
                  bottleAtPos1ConvC.setPresent();//sysj\ConveyorPlant.sysj line: 28, column: 4
                  currsigs.addElement(bottleAtPos1ConvC);
                  S1307=2;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S1309=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                break;
              
              case 1 : 
                S1309=1;
                S1309=0;
                if(com.systemj.Timer.getMs() - __start_thread_2 >= (1) * 1000){//sysj\ConveyorPlant.sysj line: 21, column: 2
                  ends[2]=2;
                  ;//sysj\ConveyorPlant.sysj line: 21, column: 2
                  System.out.println("bottle at pos1");//sysj\ConveyorPlant.sysj line: 27, column: 4
                  bottleAtPos1ConvC.setPresent();//sysj\ConveyorPlant.sysj line: 28, column: 4
                  currsigs.addElement(bottleAtPos1ConvC);
                  S1307=2;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S1309=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                break;
              
            }
            break;
          
          case 2 : 
            if(rotatedConvP.getprestatus()){//sysj\ConveyorPlant.sysj line: 29, column: 10
              S1307=0;
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
          
        }
        break;
      
    }
  }

  public void thread1787(int [] tdone, int [] ends){
        S1540=1;
    if(motConveyorOn.getprestatus()){//sysj\ConveyorPlant.sysj line: 53, column: 25
      bottleAtLoadGUI.setPresent();//sysj\ConveyorPlant.sysj line: 53, column: 40
      currsigs.addElement(bottleAtLoadGUI);
      active[7]=1;
      ends[7]=1;
      tdone[7]=1;
    }
    else {
      active[7]=1;
      ends[7]=1;
      tdone[7]=1;
    }
  }

  public void thread1786(int [] tdone, int [] ends){
        S1532=1;
    if(bottleLeftPos5ConvC.getprestatus()){//sysj\ConveyorPlant.sysj line: 51, column: 24
      bottleLeftPos5RotaryGUI.setPresent();//sysj\ConveyorPlant.sysj line: 51, column: 45
      currsigs.addElement(bottleLeftPos5RotaryGUI);
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
    else {
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
  }

  public void thread1785(int [] tdone, int [] ends){
        S1524=1;
    if(bottleAtPos1ConvC.getprestatus()){//sysj\ConveyorPlant.sysj line: 47, column: 24
      bottleAtPos1RotaryGUI.setPresent();//sysj\ConveyorPlant.sysj line: 47, column: 43
      currsigs.addElement(bottleAtPos1RotaryGUI);
      bottleAtPos1ConveyorGUI.setPresent();//sysj\ConveyorPlant.sysj line: 48, column: 3
      currsigs.addElement(bottleAtPos1ConveyorGUI);
      bottleAtPos1RC.setPresent();//sysj\ConveyorPlant.sysj line: 49, column: 3
      currsigs.addElement(bottleAtPos1RC);
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
    else {
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
  }

  public void thread1784(int [] tdone, int [] ends){
        S1542=1;
    thread1785(tdone,ends);
    thread1786(tdone,ends);
    thread1787(tdone,ends);
    int biggest1788 = 0;
    if(ends[5]>=biggest1788){
      biggest1788=ends[5];
    }
    if(ends[6]>=biggest1788){
      biggest1788=ends[6];
    }
    if(ends[7]>=biggest1788){
      biggest1788=ends[7];
    }
    if(biggest1788 == 1){
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread1783(int [] tdone, int [] ends){
        S1513=1;
    S1439=0;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread1782(int [] tdone, int [] ends){
        S1409=1;
    S1307=0;
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
      switch(S1780){
        case 0 : 
          S1780=0;
          break RUN;
        
        case 1 : 
          S1780=2;
          S1780=2;
          new Thread(new GUI()).start();//sysj\ConveyorPlant.sysj line: 17, column: 2
          S1305=0;
          active[1]=1;
          ends[1]=1;
          break RUN;
        
        case 2 : 
          switch(S1305){
            case 0 : 
              S1305=0;
              S1305=1;
              thread1782(tdone,ends);
              thread1783(tdone,ends);
              thread1784(tdone,ends);
              int biggest1789 = 0;
              if(ends[2]>=biggest1789){
                biggest1789=ends[2];
              }
              if(ends[3]>=biggest1789){
                biggest1789=ends[3];
              }
              if(ends[4]>=biggest1789){
                biggest1789=ends[4];
              }
              if(biggest1789 == 1){
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            
            case 1 : 
              thread1790(tdone,ends);
              thread1791(tdone,ends);
              thread1792(tdone,ends);
              int biggest1797 = 0;
              if(ends[2]>=biggest1797){
                biggest1797=ends[2];
              }
              if(ends[3]>=biggest1797){
                biggest1797=ends[3];
              }
              if(ends[4]>=biggest1797){
                biggest1797=ends[4];
              }
              if(biggest1797 == 1){
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              //FINXME code
              if(biggest1797 == 0){
                S1780=0;
                active[1]=0;
                ends[1]=0;
                S1780=0;
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
          motConveyorOn.gethook();
          enableConveyor.gethook();
          bottleAtPos5.gethook();
          rotatedConvP.gethook();
          df = true;
        }
        runClockDomain();
      }
      motConveyorOn.setpreclear();
      enableConveyor.setpreclear();
      bottleAtPos5.setpreclear();
      rotatedConvP.setpreclear();
      bottleAtPos1ConvC.setpreclear();
      bottleAtPos1RC.setpreclear();
      bottleAtPos1M.setpreclear();
      bottleLeftPos5ConvC.setpreclear();
      bottleLeftPos5M.setpreclear();
      bottleLeftPos5RC.setpreclear();
      bottleLeftPos5RotaryGUI.setpreclear();
      bottleAtPos1RotaryGUI.setpreclear();
      bottleAtPos1ConveyorGUI.setpreclear();
      bottleLeftPos5ConveyorGUI.setpreclear();
      bottleAtLoadGUI.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = motConveyorOn.getStatus() ? motConveyorOn.setprepresent() : motConveyorOn.setpreclear();
      motConveyorOn.setpreval(motConveyorOn.getValue());
      motConveyorOn.setClear();
      dummyint = enableConveyor.getStatus() ? enableConveyor.setprepresent() : enableConveyor.setpreclear();
      enableConveyor.setpreval(enableConveyor.getValue());
      enableConveyor.setClear();
      dummyint = bottleAtPos5.getStatus() ? bottleAtPos5.setprepresent() : bottleAtPos5.setpreclear();
      bottleAtPos5.setpreval(bottleAtPos5.getValue());
      bottleAtPos5.setClear();
      dummyint = rotatedConvP.getStatus() ? rotatedConvP.setprepresent() : rotatedConvP.setpreclear();
      rotatedConvP.setpreval(rotatedConvP.getValue());
      rotatedConvP.setClear();
      bottleAtPos1ConvC.sethook();
      bottleAtPos1ConvC.setClear();
      bottleAtPos1RC.sethook();
      bottleAtPos1RC.setClear();
      bottleAtPos1M.sethook();
      bottleAtPos1M.setClear();
      bottleLeftPos5ConvC.sethook();
      bottleLeftPos5ConvC.setClear();
      bottleLeftPos5M.sethook();
      bottleLeftPos5M.setClear();
      bottleLeftPos5RC.sethook();
      bottleLeftPos5RC.setClear();
      bottleLeftPos5RotaryGUI.sethook();
      bottleLeftPos5RotaryGUI.setClear();
      bottleAtPos1RotaryGUI.sethook();
      bottleAtPos1RotaryGUI.setClear();
      bottleAtPos1ConveyorGUI.sethook();
      bottleAtPos1ConveyorGUI.setClear();
      bottleLeftPos5ConveyorGUI.sethook();
      bottleLeftPos5ConveyorGUI.setClear();
      bottleAtLoadGUI.sethook();
      bottleAtLoadGUI.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        motConveyorOn.gethook();
        enableConveyor.gethook();
        bottleAtPos5.gethook();
        rotatedConvP.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
