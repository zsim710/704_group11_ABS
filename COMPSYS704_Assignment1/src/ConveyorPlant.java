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
  public Signal bottleAtPos5 = new Signal("bottleAtPos5", Signal.INPUT);
  public Signal rotatedConvP = new Signal("rotatedConvP", Signal.INPUT);
  public Signal start = new Signal("start", Signal.INPUT);
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
  private Signal rotatedUpdated_1;
  private int S2082 = 1;
  private int S2081 = 1;
  private int S1854 = 1;
  private int S1853 = 1;
  private int S1822 = 1;
  private int S1871 = 1;
  private int S1857 = 1;
  private int S1906 = 1;
  private int S1905 = 1;
  private int S1888 = 1;
  private int S1896 = 1;
  private int S1904 = 1;
  
  private int[] ends = new int[8];
  private int[] tdone = new int[8];
  
  public void thread2097(int [] tdone, int [] ends){
        switch(S1904){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        if(motConveyorOn.getprestatus()){//sysj\ConveyorPlant.sysj line: 76, column: 25
          bottleAtLoadGUI.setPresent();//sysj\ConveyorPlant.sysj line: 76, column: 40
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

  public void thread2096(int [] tdone, int [] ends){
        switch(S1896){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        if(bottleLeftPos5ConvC.getprestatus()){//sysj\ConveyorPlant.sysj line: 74, column: 24
          bottleLeftPos5RotaryGUI.setPresent();//sysj\ConveyorPlant.sysj line: 74, column: 45
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

  public void thread2095(int [] tdone, int [] ends){
        switch(S1888){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        if(rotatedUpdated_1.getprestatus()){//sysj\ConveyorPlant.sysj line: 67, column: 13
          bottleAtPos1M.setPresent();//sysj\ConveyorPlant.sysj line: 68, column: 6
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

  public void thread2094(int [] tdone, int [] ends){
        switch(S1906){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S1905){
          case 0 : 
            if(bottleAtPos1ConvC.getprestatus()){//sysj\ConveyorPlant.sysj line: 56, column: 12
              bottleAtPos1RotaryGUI.setPresent();//sysj\ConveyorPlant.sysj line: 57, column: 5
              currsigs.addElement(bottleAtPos1RotaryGUI);
              bottleAtPos1ConveyorGUI.setPresent();//sysj\ConveyorPlant.sysj line: 59, column: 5
              currsigs.addElement(bottleAtPos1ConveyorGUI);
              bottleAtPos1RC.setPresent();//sysj\ConveyorPlant.sysj line: 60, column: 5
              currsigs.addElement(bottleAtPos1RC);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 1 : 
            thread2095(tdone,ends);
            thread2096(tdone,ends);
            thread2097(tdone,ends);
            int biggest2098 = 0;
            if(ends[5]>=biggest2098){
              biggest2098=ends[5];
            }
            if(ends[6]>=biggest2098){
              biggest2098=ends[6];
            }
            if(ends[7]>=biggest2098){
              biggest2098=ends[7];
            }
            if(biggest2098 == 1){
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            //FINXME code
            if(biggest2098 == 0){
              S1906=0;
              active[4]=0;
              ends[4]=0;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2093(int [] tdone, int [] ends){
        switch(S1871){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S1857){
          case 0 : 
            S1857=0;
            S1857=1;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 1 : 
            if(bottleAtPos5.getprestatus()){//sysj\ConveyorPlant.sysj line: 43, column: 10
              S1857=2;
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
            S1857=2;
            System.out.println("bottle left pos 5");//sysj\ConveyorPlant.sysj line: 46, column: 4
            bottleLeftPos5M.setPresent();//sysj\ConveyorPlant.sysj line: 47, column: 4
            currsigs.addElement(bottleLeftPos5M);
            bottleLeftPos5ConvC.setPresent();//sysj\ConveyorPlant.sysj line: 48, column: 4
            currsigs.addElement(bottleLeftPos5ConvC);
            S1857=3;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 3 : 
            if(rotatedConvP.getprestatus()){//sysj\ConveyorPlant.sysj line: 49, column: 10
              S1857=0;
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

  public void thread2092(int [] tdone, int [] ends){
        switch(S1854){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S1853){
          case 0 : 
            switch(S1822){
              case 0 : 
                if(motConveyorOn.getprestatus()){//sysj\ConveyorPlant.sysj line: 25, column: 10
                  System.out.println("conveyor is moving");//sysj\ConveyorPlant.sysj line: 26, column: 4
                  S1822=1;
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
                S1822=1;
                System.out.println("bottle at pos1");//sysj\ConveyorPlant.sysj line: 29, column: 4
                S1822=2;
                bottleAtPos1ConvC.setPresent();//sysj\ConveyorPlant.sysj line: 32, column: 5
                currsigs.addElement(bottleAtPos1ConvC);
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
                break;
              
              case 2 : 
                if(rotatedConvP.getprestatus()){//sysj\ConveyorPlant.sysj line: 31, column: 10
                  System.out.println("made it into conveyor");//sysj\ConveyorPlant.sysj line: 23, column: 4
                  S1822=0;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  bottleAtPos1ConvC.setPresent();//sysj\ConveyorPlant.sysj line: 32, column: 5
                  currsigs.addElement(bottleAtPos1ConvC);
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                break;
              
            }
            break;
          
          case 1 : 
            S1853=1;
            S1854=0;
            active[2]=0;
            ends[2]=0;
            tdone[2]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread2090(int [] tdone, int [] ends){
        S1906=1;
    S1905=0;
    if(bottleAtPos1ConvC.getprestatus()){//sysj\ConveyorPlant.sysj line: 56, column: 12
      bottleAtPos1RotaryGUI.setPresent();//sysj\ConveyorPlant.sysj line: 57, column: 5
      currsigs.addElement(bottleAtPos1RotaryGUI);
      bottleAtPos1ConveyorGUI.setPresent();//sysj\ConveyorPlant.sysj line: 59, column: 5
      currsigs.addElement(bottleAtPos1ConveyorGUI);
      bottleAtPos1RC.setPresent();//sysj\ConveyorPlant.sysj line: 60, column: 5
      currsigs.addElement(bottleAtPos1RC);
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
    else {
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread2089(int [] tdone, int [] ends){
        S1871=1;
    S1857=0;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread2088(int [] tdone, int [] ends){
        S1854=1;
    S1853=0;
    System.out.println("made it into conveyor");//sysj\ConveyorPlant.sysj line: 23, column: 4
    S1822=0;
    active[2]=1;
    ends[2]=1;
    tdone[2]=1;
  }

  public void thread2086(int [] tdone, int [] ends){
        S1906=1;
    S1905=0;
    if(bottleAtPos1ConvC.getprestatus()){//sysj\ConveyorPlant.sysj line: 56, column: 12
      bottleAtPos1RotaryGUI.setPresent();//sysj\ConveyorPlant.sysj line: 57, column: 5
      currsigs.addElement(bottleAtPos1RotaryGUI);
      bottleAtPos1ConveyorGUI.setPresent();//sysj\ConveyorPlant.sysj line: 59, column: 5
      currsigs.addElement(bottleAtPos1ConveyorGUI);
      bottleAtPos1RC.setPresent();//sysj\ConveyorPlant.sysj line: 60, column: 5
      currsigs.addElement(bottleAtPos1RC);
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
    else {
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread2085(int [] tdone, int [] ends){
        S1871=1;
    S1857=0;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread2084(int [] tdone, int [] ends){
        S1854=1;
    S1853=0;
    System.out.println("made it into conveyor");//sysj\ConveyorPlant.sysj line: 23, column: 4
    S1822=0;
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
      switch(S2082){
        case 0 : 
          S2082=0;
          break RUN;
        
        case 1 : 
          S2082=2;
          S2082=2;
          rotatedUpdated_1.setClear();//sysj\ConveyorPlant.sysj line: 17, column: 2
          S2081=0;
          if(start.getprestatus()){//sysj\ConveyorPlant.sysj line: 19, column: 18
            S2081=1;
            thread2084(tdone,ends);
            thread2085(tdone,ends);
            thread2086(tdone,ends);
            int biggest2087 = 0;
            if(ends[2]>=biggest2087){
              biggest2087=ends[2];
            }
            if(ends[3]>=biggest2087){
              biggest2087=ends[3];
            }
            if(ends[4]>=biggest2087){
              biggest2087=ends[4];
            }
            if(biggest2087 == 1){
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
          rotatedUpdated_1.setClear();//sysj\ConveyorPlant.sysj line: 17, column: 2
          switch(S2081){
            case 0 : 
              if(start.getprestatus()){//sysj\ConveyorPlant.sysj line: 19, column: 18
                S2081=1;
                thread2088(tdone,ends);
                thread2089(tdone,ends);
                thread2090(tdone,ends);
                int biggest2091 = 0;
                if(ends[2]>=biggest2091){
                  biggest2091=ends[2];
                }
                if(ends[3]>=biggest2091){
                  biggest2091=ends[3];
                }
                if(ends[4]>=biggest2091){
                  biggest2091=ends[4];
                }
                if(biggest2091 == 1){
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
              thread2092(tdone,ends);
              thread2093(tdone,ends);
              thread2094(tdone,ends);
              int biggest2099 = 0;
              if(ends[2]>=biggest2099){
                biggest2099=ends[2];
              }
              if(ends[3]>=biggest2099){
                biggest2099=ends[3];
              }
              if(ends[4]>=biggest2099){
                biggest2099=ends[4];
              }
              if(biggest2099 == 1){
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              //FINXME code
              if(biggest2099 == 0){
                S2082=0;
                active[1]=0;
                ends[1]=0;
                S2082=0;
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
    rotatedUpdated_1 = new Signal();
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
          bottleAtPos5.gethook();
          rotatedConvP.gethook();
          start.gethook();
          df = true;
        }
        runClockDomain();
      }
      motConveyorOn.setpreclear();
      bottleAtPos5.setpreclear();
      rotatedConvP.setpreclear();
      start.setpreclear();
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
      rotatedUpdated_1.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = motConveyorOn.getStatus() ? motConveyorOn.setprepresent() : motConveyorOn.setpreclear();
      motConveyorOn.setpreval(motConveyorOn.getValue());
      motConveyorOn.setClear();
      dummyint = bottleAtPos5.getStatus() ? bottleAtPos5.setprepresent() : bottleAtPos5.setpreclear();
      bottleAtPos5.setpreval(bottleAtPos5.getValue());
      bottleAtPos5.setClear();
      dummyint = rotatedConvP.getStatus() ? rotatedConvP.setprepresent() : rotatedConvP.setpreclear();
      rotatedConvP.setpreval(rotatedConvP.getValue());
      rotatedConvP.setClear();
      dummyint = start.getStatus() ? start.setprepresent() : start.setpreclear();
      start.setpreval(start.getValue());
      start.setClear();
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
      rotatedUpdated_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        motConveyorOn.gethook();
        bottleAtPos5.gethook();
        rotatedConvP.gethook();
        start.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
