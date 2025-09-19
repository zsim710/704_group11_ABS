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
  public Signal rotaryTableTriggerConvP = new Signal("rotaryTableTriggerConvP", Signal.INPUT);
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
  private int S2208 = 1;
  private int S2207 = 1;
  private int S1846 = 1;
  private int S1845 = 1;
  private int S1747 = 1;
  private int S1752 = 1;
  private int S1757 = 1;
  private int S1863 = 1;
  private int S1849 = 1;
  private int S1898 = 1;
  private int S1897 = 1;
  private int S1880 = 1;
  private int S1888 = 1;
  private int S1896 = 1;
  
  private int[] ends = new int[10];
  private int[] tdone = new int[10];
  
  public void thread2229(int [] tdone, int [] ends){
        switch(S1896){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        if(motConveyorOn.getprestatus()){//sysj\ConveyorPlant.sysj line: 82, column: 25
          bottleAtLoadGUI.setPresent();//sysj\ConveyorPlant.sysj line: 82, column: 40
          currsigs.addElement(bottleAtLoadGUI);
          active[9]=1;
          ends[9]=1;
          tdone[9]=1;
        }
        else {
          active[9]=1;
          ends[9]=1;
          tdone[9]=1;
        }
        break;
      
    }
  }

  public void thread2228(int [] tdone, int [] ends){
        switch(S1888){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        if(bottleLeftPos5ConvC.getprestatus()){//sysj\ConveyorPlant.sysj line: 80, column: 24
          bottleLeftPos5RotaryGUI.setPresent();//sysj\ConveyorPlant.sysj line: 80, column: 45
          currsigs.addElement(bottleLeftPos5RotaryGUI);
          active[8]=1;
          ends[8]=1;
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

  public void thread2227(int [] tdone, int [] ends){
        switch(S1880){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        if(rotatedUpdated_1.getprestatus()){//sysj\ConveyorPlant.sysj line: 73, column: 13
          bottleAtPos1M.setPresent();//sysj\ConveyorPlant.sysj line: 74, column: 6
          currsigs.addElement(bottleAtPos1M);
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

  public void thread2226(int [] tdone, int [] ends){
        switch(S1898){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S1897){
          case 0 : 
            if(bottleAtPos1ConvC.getprestatus()){//sysj\ConveyorPlant.sysj line: 61, column: 12
              bottleAtPos1RotaryGUI.setPresent();//sysj\ConveyorPlant.sysj line: 62, column: 5
              currsigs.addElement(bottleAtPos1RotaryGUI);
              bottleAtPos1ConveyorGUI.setPresent();//sysj\ConveyorPlant.sysj line: 64, column: 5
              currsigs.addElement(bottleAtPos1ConveyorGUI);
              System.out.println("emitted bottleAtPos1RC");//sysj\ConveyorPlant.sysj line: 66, column: 5
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
          
          case 1 : 
            thread2227(tdone,ends);
            thread2228(tdone,ends);
            thread2229(tdone,ends);
            int biggest2230 = 0;
            if(ends[7]>=biggest2230){
              biggest2230=ends[7];
            }
            if(ends[8]>=biggest2230){
              biggest2230=ends[8];
            }
            if(ends[9]>=biggest2230){
              biggest2230=ends[9];
            }
            if(biggest2230 == 1){
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            //FINXME code
            if(biggest2230 == 0){
              S1898=0;
              active[6]=0;
              ends[6]=0;
              tdone[6]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2225(int [] tdone, int [] ends){
        switch(S1863){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S1849){
          case 0 : 
            S1849=0;
            S1849=1;
            active[5]=1;
            ends[5]=1;
            tdone[5]=1;
            break;
          
          case 1 : 
            if(bottleAtPos5.getprestatus()){//sysj\ConveyorPlant.sysj line: 48, column: 10
              S1849=2;
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
          
          case 2 : 
            S1849=2;
            System.out.println("bottle left pos 5");//sysj\ConveyorPlant.sysj line: 51, column: 4
            bottleLeftPos5M.setPresent();//sysj\ConveyorPlant.sysj line: 52, column: 4
            currsigs.addElement(bottleLeftPos5M);
            bottleLeftPos5ConvC.setPresent();//sysj\ConveyorPlant.sysj line: 53, column: 4
            currsigs.addElement(bottleLeftPos5ConvC);
            S1849=3;
            active[5]=1;
            ends[5]=1;
            tdone[5]=1;
            break;
          
          case 3 : 
            if(rotatedConvP.getprestatus()){//sysj\ConveyorPlant.sysj line: 54, column: 10
              S1849=0;
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
        break;
      
    }
  }

  public void thread2223(int [] tdone, int [] ends){
        switch(S1757){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        bottleAtPos1RC.setPresent();//sysj\ConveyorPlant.sysj line: 35, column: 6
        currsigs.addElement(bottleAtPos1RC);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread2222(int [] tdone, int [] ends){
        switch(S1752){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        bottleAtPos1ConvC.setPresent();//sysj\ConveyorPlant.sysj line: 33, column: 6
        currsigs.addElement(bottleAtPos1ConvC);
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
        break;
      
    }
  }

  public void thread2220(int [] tdone, int [] ends){
        S1757=1;
    bottleAtPos1RC.setPresent();//sysj\ConveyorPlant.sysj line: 35, column: 6
    currsigs.addElement(bottleAtPos1RC);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread2219(int [] tdone, int [] ends){
        S1752=1;
    bottleAtPos1ConvC.setPresent();//sysj\ConveyorPlant.sysj line: 33, column: 6
    currsigs.addElement(bottleAtPos1ConvC);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread2218(int [] tdone, int [] ends){
        switch(S1846){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S1845){
          case 0 : 
            switch(S1747){
              case 0 : 
                if(motConveyorOn.getprestatus()){//sysj\ConveyorPlant.sysj line: 25, column: 10
                  System.out.println("conveyor is moving");//sysj\ConveyorPlant.sysj line: 26, column: 4
                  S1747=1;
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
                S1747=1;
                System.out.println("bottle at pos1");//sysj\ConveyorPlant.sysj line: 29, column: 4
                S1747=2;
                thread2219(tdone,ends);
                thread2220(tdone,ends);
                int biggest2221 = 0;
                if(ends[3]>=biggest2221){
                  biggest2221=ends[3];
                }
                if(ends[4]>=biggest2221){
                  biggest2221=ends[4];
                }
                if(biggest2221 == 1){
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                break;
              
              case 2 : 
                if(rotaryTableTriggerConvP.getprestatus()){//sysj\ConveyorPlant.sysj line: 31, column: 10
                  System.out.println("made it into conveyor");//sysj\ConveyorPlant.sysj line: 23, column: 4
                  S1747=0;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  thread2222(tdone,ends);
                  thread2223(tdone,ends);
                  int biggest2224 = 0;
                  if(ends[3]>=biggest2224){
                    biggest2224=ends[3];
                  }
                  if(ends[4]>=biggest2224){
                    biggest2224=ends[4];
                  }
                  if(biggest2224 == 1){
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  //FINXME code
                  if(biggest2224 == 0){
                    System.out.println("made it into conveyor");//sysj\ConveyorPlant.sysj line: 23, column: 4
                    S1747=0;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 1 : 
            S1845=1;
            S1845=2;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
            break;
          
          case 2 : 
            S1845=2;
            S1846=0;
            active[2]=0;
            ends[2]=0;
            tdone[2]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread2216(int [] tdone, int [] ends){
        S1898=1;
    S1897=0;
    if(bottleAtPos1ConvC.getprestatus()){//sysj\ConveyorPlant.sysj line: 61, column: 12
      bottleAtPos1RotaryGUI.setPresent();//sysj\ConveyorPlant.sysj line: 62, column: 5
      currsigs.addElement(bottleAtPos1RotaryGUI);
      bottleAtPos1ConveyorGUI.setPresent();//sysj\ConveyorPlant.sysj line: 64, column: 5
      currsigs.addElement(bottleAtPos1ConveyorGUI);
      System.out.println("emitted bottleAtPos1RC");//sysj\ConveyorPlant.sysj line: 66, column: 5
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

  public void thread2215(int [] tdone, int [] ends){
        S1863=1;
    S1849=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread2214(int [] tdone, int [] ends){
        S1846=1;
    S1845=0;
    System.out.println("made it into conveyor");//sysj\ConveyorPlant.sysj line: 23, column: 4
    S1747=0;
    active[2]=1;
    ends[2]=1;
    tdone[2]=1;
  }

  public void thread2212(int [] tdone, int [] ends){
        S1898=1;
    S1897=0;
    if(bottleAtPos1ConvC.getprestatus()){//sysj\ConveyorPlant.sysj line: 61, column: 12
      bottleAtPos1RotaryGUI.setPresent();//sysj\ConveyorPlant.sysj line: 62, column: 5
      currsigs.addElement(bottleAtPos1RotaryGUI);
      bottleAtPos1ConveyorGUI.setPresent();//sysj\ConveyorPlant.sysj line: 64, column: 5
      currsigs.addElement(bottleAtPos1ConveyorGUI);
      System.out.println("emitted bottleAtPos1RC");//sysj\ConveyorPlant.sysj line: 66, column: 5
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

  public void thread2211(int [] tdone, int [] ends){
        S1863=1;
    S1849=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread2210(int [] tdone, int [] ends){
        S1846=1;
    S1845=0;
    System.out.println("made it into conveyor");//sysj\ConveyorPlant.sysj line: 23, column: 4
    S1747=0;
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
      switch(S2208){
        case 0 : 
          S2208=0;
          break RUN;
        
        case 1 : 
          S2208=2;
          S2208=2;
          rotatedUpdated_1.setClear();//sysj\ConveyorPlant.sysj line: 17, column: 2
          S2207=0;
          if(start.getprestatus()){//sysj\ConveyorPlant.sysj line: 19, column: 18
            S2207=1;
            thread2210(tdone,ends);
            thread2211(tdone,ends);
            thread2212(tdone,ends);
            int biggest2213 = 0;
            if(ends[2]>=biggest2213){
              biggest2213=ends[2];
            }
            if(ends[5]>=biggest2213){
              biggest2213=ends[5];
            }
            if(ends[6]>=biggest2213){
              biggest2213=ends[6];
            }
            if(biggest2213 == 1){
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
          switch(S2207){
            case 0 : 
              if(start.getprestatus()){//sysj\ConveyorPlant.sysj line: 19, column: 18
                S2207=1;
                thread2214(tdone,ends);
                thread2215(tdone,ends);
                thread2216(tdone,ends);
                int biggest2217 = 0;
                if(ends[2]>=biggest2217){
                  biggest2217=ends[2];
                }
                if(ends[5]>=biggest2217){
                  biggest2217=ends[5];
                }
                if(ends[6]>=biggest2217){
                  biggest2217=ends[6];
                }
                if(biggest2217 == 1){
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
              thread2218(tdone,ends);
              thread2225(tdone,ends);
              thread2226(tdone,ends);
              int biggest2231 = 0;
              if(ends[2]>=biggest2231){
                biggest2231=ends[2];
              }
              if(ends[5]>=biggest2231){
                biggest2231=ends[5];
              }
              if(ends[6]>=biggest2231){
                biggest2231=ends[6];
              }
              if(biggest2231 == 1){
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              //FINXME code
              if(biggest2231 == 0){
                S2208=0;
                active[1]=0;
                ends[1]=0;
                S2208=0;
                break RUN;
              }
            
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
          rotaryTableTriggerConvP.gethook();
          df = true;
        }
        runClockDomain();
      }
      motConveyorOn.setpreclear();
      bottleAtPos5.setpreclear();
      rotatedConvP.setpreclear();
      start.setpreclear();
      rotaryTableTriggerConvP.setpreclear();
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
      dummyint = rotaryTableTriggerConvP.getStatus() ? rotaryTableTriggerConvP.setprepresent() : rotaryTableTriggerConvP.setpreclear();
      rotaryTableTriggerConvP.setpreval(rotaryTableTriggerConvP.getValue());
      rotaryTableTriggerConvP.setClear();
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
        rotaryTableTriggerConvP.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
