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
  public Signal enableConvP = new Signal("enableConvP", Signal.INPUT);
  public Signal bottleAtPos1ConvC = new Signal("bottleAtPos1ConvC", Signal.OUTPUT);
  public Signal bottleAtPos1RC = new Signal("bottleAtPos1RC", Signal.OUTPUT);
  public Signal bottleAtPos1M = new Signal("bottleAtPos1M", Signal.OUTPUT);
  public Signal start = new Signal("start", Signal.OUTPUT);
  public Signal bottleLeftPos5ConvC = new Signal("bottleLeftPos5ConvC", Signal.OUTPUT);
  public Signal bottleLeftPos5M = new Signal("bottleLeftPos5M", Signal.OUTPUT);
  public Signal bottleLeftPos5RC = new Signal("bottleLeftPos5RC", Signal.OUTPUT);
  public Signal bottleLeftPos5RotaryGUI = new Signal("bottleLeftPos5RotaryGUI", Signal.OUTPUT);
  public Signal bottleAtPos1RotaryGUI = new Signal("bottleAtPos1RotaryGUI", Signal.OUTPUT);
  public Signal bottleAtPos1ConveyorGUI = new Signal("bottleAtPos1ConveyorGUI", Signal.OUTPUT);
  public Signal bottleLeftPos5ConveyorGUI = new Signal("bottleLeftPos5ConveyorGUI", Signal.OUTPUT);
  public Signal bottleAtLoadGUI = new Signal("bottleAtLoadGUI", Signal.OUTPUT);
  private int S2018 = 1;
  private int S2017 = 1;
  private int S1859 = 1;
  private int S1815 = 1;
  private int S1885 = 1;
  private int S1863 = 1;
  private int S1914 = 1;
  private int S1896 = 1;
  private int S1904 = 1;
  private int S1912 = 1;
  
  private int[] ends = new int[8];
  private int[] tdone = new int[8];
  
  public void thread2033(int [] tdone, int [] ends){
        switch(S1912){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        if(motConveyorOn.getprestatus()){//sysj\ConveyorPlant.sysj line: 68, column: 25
          bottleAtLoadGUI.setPresent();//sysj\ConveyorPlant.sysj line: 68, column: 40
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

  public void thread2032(int [] tdone, int [] ends){
        switch(S1904){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        if(bottleLeftPos5ConvC.getprestatus()){//sysj\ConveyorPlant.sysj line: 66, column: 24
          bottleLeftPos5RotaryGUI.setPresent();//sysj\ConveyorPlant.sysj line: 66, column: 45
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

  public void thread2031(int [] tdone, int [] ends){
        switch(S1896){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        if(bottleAtPos1ConvC.getprestatus()){//sysj\ConveyorPlant.sysj line: 56, column: 12
          bottleAtPos1RotaryGUI.setPresent();//sysj\ConveyorPlant.sysj line: 57, column: 5
          currsigs.addElement(bottleAtPos1RotaryGUI);
          System.out.println("at least we got here 1");//sysj\ConveyorPlant.sysj line: 58, column: 5
          bottleAtPos1ConveyorGUI.setPresent();//sysj\ConveyorPlant.sysj line: 59, column: 5
          currsigs.addElement(bottleAtPos1ConveyorGUI);
          bottleAtPos1RC.setPresent();//sysj\ConveyorPlant.sysj line: 60, column: 5
          currsigs.addElement(bottleAtPos1RC);
          bottleAtPos1M.setPresent();//sysj\ConveyorPlant.sysj line: 61, column: 5
          currsigs.addElement(bottleAtPos1M);
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

  public void thread2030(int [] tdone, int [] ends){
        switch(S1914){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        thread2031(tdone,ends);
        thread2032(tdone,ends);
        thread2033(tdone,ends);
        int biggest2034 = 0;
        if(ends[5]>=biggest2034){
          biggest2034=ends[5];
        }
        if(ends[6]>=biggest2034){
          biggest2034=ends[6];
        }
        if(ends[7]>=biggest2034){
          biggest2034=ends[7];
        }
        if(biggest2034 == 1){
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
        //FINXME code
        if(biggest2034 == 0){
          S1914=0;
          active[4]=0;
          ends[4]=0;
          tdone[4]=1;
        }
        break;
      
    }
  }

  public void thread2029(int [] tdone, int [] ends){
        switch(S1885){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S1863){
          case 0 : 
            if(enableConvP.getprestatus()){//sysj\ConveyorPlant.sysj line: 42, column: 10
              S1863=1;
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
          
          case 1 : 
            if(bottleAtPos5.getprestatus()){//sysj\ConveyorPlant.sysj line: 43, column: 10
              S1863=2;
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
            if(!enableConvP.getprestatus()){//sysj\ConveyorPlant.sysj line: 44, column: 10
              System.out.println("bottle left pos 5");//sysj\ConveyorPlant.sysj line: 46, column: 4
              bottleLeftPos5M.setPresent();//sysj\ConveyorPlant.sysj line: 47, column: 4
              currsigs.addElement(bottleLeftPos5M);
              bottleLeftPos5ConvC.setPresent();//sysj\ConveyorPlant.sysj line: 48, column: 4
              currsigs.addElement(bottleLeftPos5ConvC);
              S1863=3;
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
          
          case 3 : 
            if(rotatedConvP.getprestatus()){//sysj\ConveyorPlant.sysj line: 49, column: 10
              S1863=0;
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

  public void thread2028(int [] tdone, int [] ends){
        switch(S1859){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S1815){
          case 0 : 
            if(enableConvP.getprestatus()){//sysj\ConveyorPlant.sysj line: 24, column: 10
              start.setPresent();//sysj\ConveyorPlant.sysj line: 25, column: 4
              currsigs.addElement(start);
              S1815=1;
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
          
          case 1 : 
            if(motConveyorOn.getprestatus()){//sysj\ConveyorPlant.sysj line: 26, column: 10
              System.out.println("conveyor is moving");//sysj\ConveyorPlant.sysj line: 27, column: 4
              S1815=2;
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
          
          case 2 : 
            if(!enableConvP.getprestatus()){//sysj\ConveyorPlant.sysj line: 29, column: 10
              System.out.println("bottle at pos1");//sysj\ConveyorPlant.sysj line: 32, column: 4
              S1815=3;
              bottleAtPos1ConvC.setPresent();//sysj\ConveyorPlant.sysj line: 34, column: 5
              currsigs.addElement(bottleAtPos1ConvC);
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
            if(rotatedConvP.getprestatus()){//sysj\ConveyorPlant.sysj line: 33, column: 10
              System.out.println("made it into conveyor");//sysj\ConveyorPlant.sysj line: 23, column: 4
              S1815=0;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              bottleAtPos1ConvC.setPresent();//sysj\ConveyorPlant.sysj line: 34, column: 5
              currsigs.addElement(bottleAtPos1ConvC);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2025(int [] tdone, int [] ends){
        S1912=1;
    if(motConveyorOn.getprestatus()){//sysj\ConveyorPlant.sysj line: 68, column: 25
      bottleAtLoadGUI.setPresent();//sysj\ConveyorPlant.sysj line: 68, column: 40
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

  public void thread2024(int [] tdone, int [] ends){
        S1904=1;
    if(bottleLeftPos5ConvC.getprestatus()){//sysj\ConveyorPlant.sysj line: 66, column: 24
      bottleLeftPos5RotaryGUI.setPresent();//sysj\ConveyorPlant.sysj line: 66, column: 45
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

  public void thread2023(int [] tdone, int [] ends){
        S1896=1;
    if(bottleAtPos1ConvC.getprestatus()){//sysj\ConveyorPlant.sysj line: 56, column: 12
      bottleAtPos1RotaryGUI.setPresent();//sysj\ConveyorPlant.sysj line: 57, column: 5
      currsigs.addElement(bottleAtPos1RotaryGUI);
      System.out.println("at least we got here 1");//sysj\ConveyorPlant.sysj line: 58, column: 5
      bottleAtPos1ConveyorGUI.setPresent();//sysj\ConveyorPlant.sysj line: 59, column: 5
      currsigs.addElement(bottleAtPos1ConveyorGUI);
      bottleAtPos1RC.setPresent();//sysj\ConveyorPlant.sysj line: 60, column: 5
      currsigs.addElement(bottleAtPos1RC);
      bottleAtPos1M.setPresent();//sysj\ConveyorPlant.sysj line: 61, column: 5
      currsigs.addElement(bottleAtPos1M);
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

  public void thread2022(int [] tdone, int [] ends){
        S1914=1;
    thread2023(tdone,ends);
    thread2024(tdone,ends);
    thread2025(tdone,ends);
    int biggest2026 = 0;
    if(ends[5]>=biggest2026){
      biggest2026=ends[5];
    }
    if(ends[6]>=biggest2026){
      biggest2026=ends[6];
    }
    if(ends[7]>=biggest2026){
      biggest2026=ends[7];
    }
    if(biggest2026 == 1){
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread2021(int [] tdone, int [] ends){
        S1885=1;
    S1863=0;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread2020(int [] tdone, int [] ends){
        S1859=1;
    System.out.println("made it into conveyor");//sysj\ConveyorPlant.sysj line: 23, column: 4
    S1815=0;
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
      switch(S2018){
        case 0 : 
          S2018=0;
          break RUN;
        
        case 1 : 
          S2018=2;
          S2018=2;
          S2017=0;
          active[1]=1;
          ends[1]=1;
          break RUN;
        
        case 2 : 
          switch(S2017){
            case 0 : 
              S2017=0;
              S2017=1;
              thread2020(tdone,ends);
              thread2021(tdone,ends);
              thread2022(tdone,ends);
              int biggest2027 = 0;
              if(ends[2]>=biggest2027){
                biggest2027=ends[2];
              }
              if(ends[3]>=biggest2027){
                biggest2027=ends[3];
              }
              if(ends[4]>=biggest2027){
                biggest2027=ends[4];
              }
              if(biggest2027 == 1){
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            
            case 1 : 
              thread2028(tdone,ends);
              thread2029(tdone,ends);
              thread2030(tdone,ends);
              int biggest2035 = 0;
              if(ends[2]>=biggest2035){
                biggest2035=ends[2];
              }
              if(ends[3]>=biggest2035){
                biggest2035=ends[3];
              }
              if(ends[4]>=biggest2035){
                biggest2035=ends[4];
              }
              if(biggest2035 == 1){
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              //FINXME code
              if(biggest2035 == 0){
                S2018=0;
                active[1]=0;
                ends[1]=0;
                S2018=0;
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
          enableConvP.gethook();
          df = true;
        }
        runClockDomain();
      }
      motConveyorOn.setpreclear();
      enableConveyor.setpreclear();
      bottleAtPos5.setpreclear();
      rotatedConvP.setpreclear();
      enableConvP.setpreclear();
      bottleAtPos1ConvC.setpreclear();
      bottleAtPos1RC.setpreclear();
      bottleAtPos1M.setpreclear();
      start.setpreclear();
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
      dummyint = enableConvP.getStatus() ? enableConvP.setprepresent() : enableConvP.setpreclear();
      enableConvP.setpreval(enableConvP.getValue());
      enableConvP.setClear();
      bottleAtPos1ConvC.sethook();
      bottleAtPos1ConvC.setClear();
      bottleAtPos1RC.sethook();
      bottleAtPos1RC.setClear();
      bottleAtPos1M.sethook();
      bottleAtPos1M.setClear();
      start.sethook();
      start.setClear();
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
        enableConvP.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
