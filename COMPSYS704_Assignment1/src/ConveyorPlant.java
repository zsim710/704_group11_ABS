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
  public Signal bottleAtPos1RGUI = new Signal("bottleAtPos1RGUI", Signal.OUTPUT);
  public Signal bottleAtPos1ConveyorGUI = new Signal("bottleAtPos1ConveyorGUI", Signal.OUTPUT);
  public Signal bottleLeftPos5ConveyorGUI = new Signal("bottleLeftPos5ConveyorGUI", Signal.OUTPUT);
  public Signal bottleAtLoadGUI = new Signal("bottleAtLoadGUI", Signal.OUTPUT);
  private long __start_thread_2;//sysj\ConveyorPlant.sysj line: 21, column: 2
  private long __start_thread_3;//sysj\ConveyorPlant.sysj line: 33, column: 2
  private int S2599 = 1;
  private int S2221 = 1;
  private int S2119 = 1;
  private int S2121 = 1;
  private int S2325 = 1;
  private int S2251 = 1;
  private int S2357 = 1;
  private int S2336 = 1;
  private int S2347 = 1;
  private int S2355 = 1;
  
  private int[] ends = new int[8];
  private int[] tdone = new int[8];
  
  public void thread2614(int [] tdone, int [] ends){
        switch(S2355){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        if(motConveyorOn.getprestatus()){//sysj\ConveyorPlant.sysj line: 54, column: 25
          bottleAtLoadGUI.setPresent();//sysj\ConveyorPlant.sysj line: 54, column: 40
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

  public void thread2613(int [] tdone, int [] ends){
        switch(S2347){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        if(bottleLeftPos5ConvC.getprestatus()){//sysj\ConveyorPlant.sysj line: 51, column: 24
          bottleLeftPos5RotaryGUI.setPresent();//sysj\ConveyorPlant.sysj line: 51, column: 45
          currsigs.addElement(bottleLeftPos5RotaryGUI);
          bottleLeftPos5ConveyorGUI.setPresent();//sysj\ConveyorPlant.sysj line: 52, column: 3
          currsigs.addElement(bottleLeftPos5ConveyorGUI);
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

  public void thread2612(int [] tdone, int [] ends){
        switch(S2336){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        if(bottleAtPos1ConvC.getprestatus()){//sysj\ConveyorPlant.sysj line: 47, column: 24
          bottleAtPos1RGUI.setPresent();//sysj\ConveyorPlant.sysj line: 47, column: 43
          currsigs.addElement(bottleAtPos1RGUI);
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

  public void thread2611(int [] tdone, int [] ends){
        switch(S2357){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        thread2612(tdone,ends);
        thread2613(tdone,ends);
        thread2614(tdone,ends);
        int biggest2615 = 0;
        if(ends[5]>=biggest2615){
          biggest2615=ends[5];
        }
        if(ends[6]>=biggest2615){
          biggest2615=ends[6];
        }
        if(ends[7]>=biggest2615){
          biggest2615=ends[7];
        }
        if(biggest2615 == 1){
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
        //FINXME code
        if(biggest2615 == 0){
          S2357=0;
          active[4]=0;
          ends[4]=0;
          tdone[4]=1;
        }
        break;
      
    }
  }

  public void thread2610(int [] tdone, int [] ends){
        switch(S2325){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S2251){
          case 0 : 
            if(bottleAtPos5.getprestatus()){//sysj\ConveyorPlant.sysj line: 36, column: 10
              S2251=1;
              __start_thread_3 = com.systemj.Timer.getMs();//sysj\ConveyorPlant.sysj line: 33, column: 2
              if(com.systemj.Timer.getMs() - __start_thread_3 >= (1) * 1000){//sysj\ConveyorPlant.sysj line: 33, column: 2
                ends[3]=2;
                ;//sysj\ConveyorPlant.sysj line: 33, column: 2
                System.out.println("bottle left pos 5");//sysj\ConveyorPlant.sysj line: 38, column: 4
                bottleLeftPos5M.setPresent();//sysj\ConveyorPlant.sysj line: 39, column: 4
                currsigs.addElement(bottleLeftPos5M);
                bottleLeftPos5ConvC.setPresent();//sysj\ConveyorPlant.sysj line: 40, column: 4
                currsigs.addElement(bottleLeftPos5ConvC);
                S2251=2;
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
              S2251=2;
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
              S2251=0;
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

  public void thread2609(int [] tdone, int [] ends){
        switch(S2221){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S2119){
          case 0 : 
            if(motConveyorOn.getprestatus()){//sysj\ConveyorPlant.sysj line: 24, column: 10
              System.out.println("conveyor is moving");//sysj\ConveyorPlant.sysj line: 25, column: 4
              S2119=1;
              __start_thread_2 = com.systemj.Timer.getMs();//sysj\ConveyorPlant.sysj line: 21, column: 2
              S2121=0;
              if(com.systemj.Timer.getMs() - __start_thread_2 >= (1) * 1000){//sysj\ConveyorPlant.sysj line: 21, column: 2
                ends[2]=2;
                ;//sysj\ConveyorPlant.sysj line: 21, column: 2
                System.out.println("bottle at pos1");//sysj\ConveyorPlant.sysj line: 27, column: 4
                bottleAtPos1ConvC.setPresent();//sysj\ConveyorPlant.sysj line: 28, column: 4
                currsigs.addElement(bottleAtPos1ConvC);
                S2119=2;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S2121=1;
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
            switch(S2121){
              case 0 : 
                S2121=0;
                if(com.systemj.Timer.getMs() - __start_thread_2 >= (1) * 1000){//sysj\ConveyorPlant.sysj line: 21, column: 2
                  ends[2]=2;
                  ;//sysj\ConveyorPlant.sysj line: 21, column: 2
                  System.out.println("bottle at pos1");//sysj\ConveyorPlant.sysj line: 27, column: 4
                  bottleAtPos1ConvC.setPresent();//sysj\ConveyorPlant.sysj line: 28, column: 4
                  currsigs.addElement(bottleAtPos1ConvC);
                  S2119=2;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S2121=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                break;
              
              case 1 : 
                S2121=1;
                S2121=0;
                if(com.systemj.Timer.getMs() - __start_thread_2 >= (1) * 1000){//sysj\ConveyorPlant.sysj line: 21, column: 2
                  ends[2]=2;
                  ;//sysj\ConveyorPlant.sysj line: 21, column: 2
                  System.out.println("bottle at pos1");//sysj\ConveyorPlant.sysj line: 27, column: 4
                  bottleAtPos1ConvC.setPresent();//sysj\ConveyorPlant.sysj line: 28, column: 4
                  currsigs.addElement(bottleAtPos1ConvC);
                  S2119=2;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S2121=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                break;
              
            }
            break;
          
          case 2 : 
            if(rotatedConvP.getprestatus()){//sysj\ConveyorPlant.sysj line: 29, column: 10
              S2119=0;
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

  public void thread2606(int [] tdone, int [] ends){
        S2355=1;
    if(motConveyorOn.getprestatus()){//sysj\ConveyorPlant.sysj line: 54, column: 25
      bottleAtLoadGUI.setPresent();//sysj\ConveyorPlant.sysj line: 54, column: 40
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

  public void thread2605(int [] tdone, int [] ends){
        S2347=1;
    if(bottleLeftPos5ConvC.getprestatus()){//sysj\ConveyorPlant.sysj line: 51, column: 24
      bottleLeftPos5RotaryGUI.setPresent();//sysj\ConveyorPlant.sysj line: 51, column: 45
      currsigs.addElement(bottleLeftPos5RotaryGUI);
      bottleLeftPos5ConveyorGUI.setPresent();//sysj\ConveyorPlant.sysj line: 52, column: 3
      currsigs.addElement(bottleLeftPos5ConveyorGUI);
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

  public void thread2604(int [] tdone, int [] ends){
        S2336=1;
    if(bottleAtPos1ConvC.getprestatus()){//sysj\ConveyorPlant.sysj line: 47, column: 24
      bottleAtPos1RGUI.setPresent();//sysj\ConveyorPlant.sysj line: 47, column: 43
      currsigs.addElement(bottleAtPos1RGUI);
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

  public void thread2603(int [] tdone, int [] ends){
        S2357=1;
    thread2604(tdone,ends);
    thread2605(tdone,ends);
    thread2606(tdone,ends);
    int biggest2607 = 0;
    if(ends[5]>=biggest2607){
      biggest2607=ends[5];
    }
    if(ends[6]>=biggest2607){
      biggest2607=ends[6];
    }
    if(ends[7]>=biggest2607){
      biggest2607=ends[7];
    }
    if(biggest2607 == 1){
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread2602(int [] tdone, int [] ends){
        S2325=1;
    S2251=0;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread2601(int [] tdone, int [] ends){
        S2221=1;
    S2119=0;
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
      switch(S2599){
        case 0 : 
          S2599=0;
          break RUN;
        
        case 1 : 
          S2599=2;
          S2599=2;
          new Thread(new GUI()).start();//sysj\ConveyorPlant.sysj line: 17, column: 2
          thread2601(tdone,ends);
          thread2602(tdone,ends);
          thread2603(tdone,ends);
          int biggest2608 = 0;
          if(ends[2]>=biggest2608){
            biggest2608=ends[2];
          }
          if(ends[3]>=biggest2608){
            biggest2608=ends[3];
          }
          if(ends[4]>=biggest2608){
            biggest2608=ends[4];
          }
          if(biggest2608 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread2609(tdone,ends);
          thread2610(tdone,ends);
          thread2611(tdone,ends);
          int biggest2616 = 0;
          if(ends[2]>=biggest2616){
            biggest2616=ends[2];
          }
          if(ends[3]>=biggest2616){
            biggest2616=ends[3];
          }
          if(ends[4]>=biggest2616){
            biggest2616=ends[4];
          }
          if(biggest2616 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest2616 == 0){
            S2599=0;
            active[1]=0;
            ends[1]=0;
            S2599=0;
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
      bottleAtPos1RGUI.setpreclear();
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
      bottleAtPos1RGUI.sethook();
      bottleAtPos1RGUI.setClear();
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
