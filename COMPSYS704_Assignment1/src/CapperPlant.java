import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.GUI;//sysj\CapperPlant.sysj line: 1, column: 1

public class CapperPlant extends ClockDomain{
  public CapperPlant(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal cylPos5ZaxisExtend = new Signal("cylPos5ZaxisExtend", Signal.INPUT);
  public Signal gripperTurnRetract = new Signal("gripperTurnRetract", Signal.INPUT);
  public Signal gripperTurnExtend = new Signal("gripperTurnExtend", Signal.INPUT);
  public Signal capGripperPos5Extend = new Signal("capGripperPos5Extend", Signal.INPUT);
  public Signal cylClampBottleExtend = new Signal("cylClampBottleExtend", Signal.INPUT);
  public Signal enableCapP = new Signal("enableCapP", Signal.INPUT);
  public Signal gripperZAxisLowered = new Signal("gripperZAxisLowered", Signal.OUTPUT);
  public Signal gripperZAxisLifted = new Signal("gripperZAxisLifted", Signal.OUTPUT);
  public Signal gripperTurnHomePos = new Signal("gripperTurnHomePos", Signal.OUTPUT);
  public Signal gripperTurnFinalPos = new Signal("gripperTurnFinalPos", Signal.OUTPUT);
  public Signal start = new Signal("start", Signal.OUTPUT);
  public Signal capGripped = new Signal("capGripped", Signal.OUTPUT);
  public Signal letGo = new Signal("letGo", Signal.OUTPUT);
  public Signal bottleAtPos4E = new Signal("bottleAtPos4E", Signal.OUTPUT);
  public Signal gripperZAxisLoweredE = new Signal("gripperZAxisLoweredE", Signal.OUTPUT);
  public Signal gripperZAxisLiftedE = new Signal("gripperZAxisLiftedE", Signal.OUTPUT);
  public Signal gripperTurnHomePosE = new Signal("gripperTurnHomePosE", Signal.OUTPUT);
  public Signal gripperTurnFinalPosE = new Signal("gripperTurnFinalPosE", Signal.OUTPUT);
  public Signal capIsGrippedE = new Signal("capIsGrippedE", Signal.OUTPUT);
  public Signal capperDoneGUI = new Signal("capperDoneGUI", Signal.OUTPUT);
  public Signal gripperClampGUI = new Signal("gripperClampGUI", Signal.OUTPUT);
  public Signal bottleAtPos4GUI = new Signal("bottleAtPos4GUI", Signal.OUTPUT);
  public Signal capperIdleGUI = new Signal("capperIdleGUI", Signal.OUTPUT);
  private Signal idle_1;
  private int S1808 = 1;
  private int S1264 = 1;
  private int S990 = 1;
  private int S963 = 1;
  private int S971 = 1;
  private int S1001 = 1;
  private int S1011 = 1;
  private int S1004 = 1;
  private int S1341 = 1;
  private int S1289 = 1;
  private int S1375 = 1;
  private int S1349 = 1;
  private int S1343 = 1;
  private int S1357 = 1;
  private int S1365 = 1;
  private int S1373 = 1;
  
  private int[] ends = new int[13];
  private int[] tdone = new int[13];
  
  public void thread1837(int [] tdone, int [] ends){
        switch(S1373){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        if(idle_1.getprestatus()){//sysj\CapperPlant.sysj line: 106, column: 24
          capperIdleGUI.setPresent();//sysj\CapperPlant.sysj line: 106, column: 30
          currsigs.addElement(capperIdleGUI);
          active[12]=1;
          ends[12]=1;
          tdone[12]=1;
        }
        else {
          active[12]=1;
          ends[12]=1;
          tdone[12]=1;
        }
        break;
      
    }
  }

  public void thread1836(int [] tdone, int [] ends){
        switch(S1365){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        if(start.getprestatus()){//sysj\CapperPlant.sysj line: 104, column: 24
          bottleAtPos4GUI.setPresent();//sysj\CapperPlant.sysj line: 104, column: 31
          currsigs.addElement(bottleAtPos4GUI);
          active[11]=1;
          ends[11]=1;
          tdone[11]=1;
        }
        else {
          active[11]=1;
          ends[11]=1;
          tdone[11]=1;
        }
        break;
      
    }
  }

  public void thread1835(int [] tdone, int [] ends){
        switch(S1357){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        if(capGripped.getprestatus()){//sysj\CapperPlant.sysj line: 102, column: 24
          gripperClampGUI.setPresent();//sysj\CapperPlant.sysj line: 102, column: 36
          currsigs.addElement(gripperClampGUI);
          active[10]=1;
          ends[10]=1;
          tdone[10]=1;
        }
        else {
          active[10]=1;
          ends[10]=1;
          tdone[10]=1;
        }
        break;
      
    }
  }

  public void thread1834(int [] tdone, int [] ends){
        switch(S1349){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        switch(S1343){
          case 0 : 
            S1343=0;
            if(letGo.getprestatus()){//sysj\CapperPlant.sysj line: 100, column: 24
              capperDoneGUI.setPresent();//sysj\CapperPlant.sysj line: 100, column: 31
              currsigs.addElement(capperDoneGUI);
              S1343=1;
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              S1343=1;
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            break;
          
          case 1 : 
            S1343=1;
            S1343=0;
            if(letGo.getprestatus()){//sysj\CapperPlant.sysj line: 100, column: 24
              capperDoneGUI.setPresent();//sysj\CapperPlant.sysj line: 100, column: 31
              currsigs.addElement(capperDoneGUI);
              S1343=1;
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              S1343=1;
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1833(int [] tdone, int [] ends){
        switch(S1375){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        thread1834(tdone,ends);
        thread1835(tdone,ends);
        thread1836(tdone,ends);
        thread1837(tdone,ends);
        int biggest1838 = 0;
        if(ends[9]>=biggest1838){
          biggest1838=ends[9];
        }
        if(ends[10]>=biggest1838){
          biggest1838=ends[10];
        }
        if(ends[11]>=biggest1838){
          biggest1838=ends[11];
        }
        if(ends[12]>=biggest1838){
          biggest1838=ends[12];
        }
        if(biggest1838 == 1){
          active[8]=1;
          ends[8]=1;
          tdone[8]=1;
        }
        //FINXME code
        if(biggest1838 == 0){
          S1375=0;
          active[8]=0;
          ends[8]=0;
          tdone[8]=1;
        }
        break;
      
    }
  }

  public void thread1832(int [] tdone, int [] ends){
        switch(S1341){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        switch(S1289){
          case 0 : 
            if(gripperTurnExtend.getprestatus()){//sysj\CapperPlant.sysj line: 85, column: 11
              S1289=1;
              System.out.println("fully twisted");//sysj\CapperPlant.sysj line: 92, column: 5
              gripperTurnFinalPos.setPresent();//sysj\CapperPlant.sysj line: 93, column: 5
              currsigs.addElement(gripperTurnFinalPos);
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              gripperTurnHomePos.setPresent();//sysj\CapperPlant.sysj line: 87, column: 5
              currsigs.addElement(gripperTurnHomePos);
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
          case 1 : 
            if(gripperTurnRetract.getprestatus()){//sysj\CapperPlant.sysj line: 91, column: 10
              S1289=0;
              System.out.println("fully untwisted");//sysj\CapperPlant.sysj line: 86, column: 5
              gripperTurnHomePos.setPresent();//sysj\CapperPlant.sysj line: 87, column: 5
              currsigs.addElement(gripperTurnHomePos);
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              gripperTurnFinalPos.setPresent();//sysj\CapperPlant.sysj line: 93, column: 5
              currsigs.addElement(gripperTurnFinalPos);
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1830(int [] tdone, int [] ends){
        switch(S1011){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S1004){
          case 0 : 
            if(enableCapP.getprestatus()){//sysj\CapperPlant.sysj line: 55, column: 12
              System.out.println("cap gripped sent");//sysj\CapperPlant.sysj line: 56, column: 6
              S1004=1;
              capGripped.setPresent();//sysj\CapperPlant.sysj line: 57, column: 6
              currsigs.addElement(capGripped);
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
            capGripped.setPresent();//sysj\CapperPlant.sysj line: 57, column: 6
            currsigs.addElement(capGripped);
            active[6]=1;
            ends[6]=1;
            tdone[6]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread1829(int [] tdone, int [] ends){
        switch(S1001){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        gripperZAxisLowered.setPresent();//sysj\CapperPlant.sysj line: 50, column: 6
        currsigs.addElement(gripperZAxisLowered);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread1827(int [] tdone, int [] ends){
        S1011=1;
    System.out.println("waiting for gripped enable");//sysj\CapperPlant.sysj line: 54, column: 6
    S1004=0;
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread1826(int [] tdone, int [] ends){
        S1001=1;
    System.out.println("gripper at bottom");//sysj\CapperPlant.sysj line: 49, column: 6
    gripperZAxisLowered.setPresent();//sysj\CapperPlant.sysj line: 50, column: 6
    currsigs.addElement(gripperZAxisLowered);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread1824(int [] tdone, int [] ends){
        switch(S971){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        gripperZAxisLifted.setPresent();//sysj\CapperPlant.sysj line: 34, column: 6
        currsigs.addElement(gripperZAxisLifted);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread1823(int [] tdone, int [] ends){
        switch(S963){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        start.setPresent();//sysj\CapperPlant.sysj line: 29, column: 6
        currsigs.addElement(start);
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
        break;
      
    }
  }

  public void thread1821(int [] tdone, int [] ends){
        S971=1;
    System.out.println("sustaining gripper at top");//sysj\CapperPlant.sysj line: 33, column: 6
    gripperZAxisLifted.setPresent();//sysj\CapperPlant.sysj line: 34, column: 6
    currsigs.addElement(gripperZAxisLifted);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread1820(int [] tdone, int [] ends){
        S963=1;
    System.out.println("sending start signal");//sysj\CapperPlant.sysj line: 28, column: 6
    start.setPresent();//sysj\CapperPlant.sysj line: 29, column: 6
    currsigs.addElement(start);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread1819(int [] tdone, int [] ends){
        switch(S1264){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S990){
          case 0 : 
            if(enableCapP.getprestatus()){//sysj\CapperPlant.sysj line: 21, column: 10
              S990=1;
              thread1820(tdone,ends);
              thread1821(tdone,ends);
              int biggest1822 = 0;
              if(ends[3]>=biggest1822){
                biggest1822=ends[3];
              }
              if(ends[4]>=biggest1822){
                biggest1822=ends[4];
              }
              if(biggest1822 == 1){
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
            }
            else {
              idle_1.setPresent();//sysj\CapperPlant.sysj line: 23, column: 5
              currsigs.addElement(idle_1);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 1 : 
            if(cylPos5ZaxisExtend.getprestatus()){//sysj\CapperPlant.sysj line: 26, column: 10
              S990=2;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              thread1823(tdone,ends);
              thread1824(tdone,ends);
              int biggest1825 = 0;
              if(ends[3]>=biggest1825){
                biggest1825=ends[3];
              }
              if(ends[4]>=biggest1825){
                biggest1825=ends[4];
              }
              if(biggest1825 == 1){
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              //FINXME code
              if(biggest1825 == 0){
                S990=2;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
            }
            break;
          
          case 2 : 
            if(!enableCapP.getprestatus()){//sysj\CapperPlant.sysj line: 44, column: 10
              System.out.println("reached here 2");//sysj\CapperPlant.sysj line: 45, column: 4
              S990=3;
              thread1826(tdone,ends);
              thread1827(tdone,ends);
              int biggest1828 = 0;
              if(ends[5]>=biggest1828){
                biggest1828=ends[5];
              }
              if(ends[6]>=biggest1828){
                biggest1828=ends[6];
              }
              if(biggest1828 == 1){
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
          
          case 3 : 
            if(!cylPos5ZaxisExtend.getprestatus()){//sysj\CapperPlant.sysj line: 47, column: 10
              System.out.println("reached here 3");//sysj\CapperPlant.sysj line: 61, column: 4
              S990=4;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              thread1829(tdone,ends);
              thread1830(tdone,ends);
              int biggest1831 = 0;
              if(ends[5]>=biggest1831){
                biggest1831=ends[5];
              }
              if(ends[6]>=biggest1831){
                biggest1831=ends[6];
              }
              if(biggest1831 == 1){
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              //FINXME code
              if(biggest1831 == 0){
                System.out.println("reached here 3");//sysj\CapperPlant.sysj line: 61, column: 4
                S990=4;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
            }
            break;
          
          case 4 : 
            if(!enableCapP.getprestatus()){//sysj\CapperPlant.sysj line: 63, column: 10
              System.out.println("waiting for letgo enable");//sysj\CapperPlant.sysj line: 64, column: 4
              S990=5;
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
          
          case 5 : 
            if(enableCapP.getprestatus()){//sysj\CapperPlant.sysj line: 66, column: 10
              S990=6;
              System.out.println("let go emitted");//sysj\CapperPlant.sysj line: 68, column: 5
              letGo.setPresent();//sysj\CapperPlant.sysj line: 69, column: 5
              currsigs.addElement(letGo);
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
          
          case 6 : 
            if(gripperTurnRetract.getprestatus()){//sysj\CapperPlant.sysj line: 67, column: 10
              System.out.println("looped");//sysj\CapperPlant.sysj line: 72, column: 4
              S990=0;
              System.out.println("capper is idle");//sysj\CapperPlant.sysj line: 22, column: 5
              idle_1.setPresent();//sysj\CapperPlant.sysj line: 23, column: 5
              currsigs.addElement(idle_1);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              letGo.setPresent();//sysj\CapperPlant.sysj line: 69, column: 5
              currsigs.addElement(letGo);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1816(int [] tdone, int [] ends){
        S1373=1;
    if(idle_1.getprestatus()){//sysj\CapperPlant.sysj line: 106, column: 24
      capperIdleGUI.setPresent();//sysj\CapperPlant.sysj line: 106, column: 30
      currsigs.addElement(capperIdleGUI);
      active[12]=1;
      ends[12]=1;
      tdone[12]=1;
    }
    else {
      active[12]=1;
      ends[12]=1;
      tdone[12]=1;
    }
  }

  public void thread1815(int [] tdone, int [] ends){
        S1365=1;
    if(start.getprestatus()){//sysj\CapperPlant.sysj line: 104, column: 24
      bottleAtPos4GUI.setPresent();//sysj\CapperPlant.sysj line: 104, column: 31
      currsigs.addElement(bottleAtPos4GUI);
      active[11]=1;
      ends[11]=1;
      tdone[11]=1;
    }
    else {
      active[11]=1;
      ends[11]=1;
      tdone[11]=1;
    }
  }

  public void thread1814(int [] tdone, int [] ends){
        S1357=1;
    if(capGripped.getprestatus()){//sysj\CapperPlant.sysj line: 102, column: 24
      gripperClampGUI.setPresent();//sysj\CapperPlant.sysj line: 102, column: 36
      currsigs.addElement(gripperClampGUI);
      active[10]=1;
      ends[10]=1;
      tdone[10]=1;
    }
    else {
      active[10]=1;
      ends[10]=1;
      tdone[10]=1;
    }
  }

  public void thread1813(int [] tdone, int [] ends){
        S1349=1;
    S1343=0;
    if(letGo.getprestatus()){//sysj\CapperPlant.sysj line: 100, column: 24
      capperDoneGUI.setPresent();//sysj\CapperPlant.sysj line: 100, column: 31
      currsigs.addElement(capperDoneGUI);
      S1343=1;
      active[9]=1;
      ends[9]=1;
      tdone[9]=1;
    }
    else {
      S1343=1;
      active[9]=1;
      ends[9]=1;
      tdone[9]=1;
    }
  }

  public void thread1812(int [] tdone, int [] ends){
        S1375=1;
    thread1813(tdone,ends);
    thread1814(tdone,ends);
    thread1815(tdone,ends);
    thread1816(tdone,ends);
    int biggest1817 = 0;
    if(ends[9]>=biggest1817){
      biggest1817=ends[9];
    }
    if(ends[10]>=biggest1817){
      biggest1817=ends[10];
    }
    if(ends[11]>=biggest1817){
      biggest1817=ends[11];
    }
    if(ends[12]>=biggest1817){
      biggest1817=ends[12];
    }
    if(biggest1817 == 1){
      active[8]=1;
      ends[8]=1;
      tdone[8]=1;
    }
  }

  public void thread1811(int [] tdone, int [] ends){
        S1341=1;
    S1289=0;
    System.out.println("fully untwisted");//sysj\CapperPlant.sysj line: 86, column: 5
    gripperTurnHomePos.setPresent();//sysj\CapperPlant.sysj line: 87, column: 5
    currsigs.addElement(gripperTurnHomePos);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread1810(int [] tdone, int [] ends){
        S1264=1;
    S990=0;
    System.out.println("capper is idle");//sysj\CapperPlant.sysj line: 22, column: 5
    idle_1.setPresent();//sysj\CapperPlant.sysj line: 23, column: 5
    currsigs.addElement(idle_1);
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
      switch(S1808){
        case 0 : 
          S1808=0;
          break RUN;
        
        case 1 : 
          S1808=2;
          S1808=2;
          new Thread(new GUI()).start();//sysj\CapperPlant.sysj line: 14, column: 2
          idle_1.setClear();//sysj\CapperPlant.sysj line: 16, column: 2
          thread1810(tdone,ends);
          thread1811(tdone,ends);
          thread1812(tdone,ends);
          int biggest1818 = 0;
          if(ends[2]>=biggest1818){
            biggest1818=ends[2];
          }
          if(ends[7]>=biggest1818){
            biggest1818=ends[7];
          }
          if(ends[8]>=biggest1818){
            biggest1818=ends[8];
          }
          if(biggest1818 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          idle_1.setClear();//sysj\CapperPlant.sysj line: 16, column: 2
          thread1819(tdone,ends);
          thread1832(tdone,ends);
          thread1833(tdone,ends);
          int biggest1839 = 0;
          if(ends[2]>=biggest1839){
            biggest1839=ends[2];
          }
          if(ends[7]>=biggest1839){
            biggest1839=ends[7];
          }
          if(ends[8]>=biggest1839){
            biggest1839=ends[8];
          }
          if(biggest1839 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest1839 == 0){
            S1808=0;
            active[1]=0;
            ends[1]=0;
            S1808=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    idle_1 = new Signal();
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
          cylPos5ZaxisExtend.gethook();
          gripperTurnRetract.gethook();
          gripperTurnExtend.gethook();
          capGripperPos5Extend.gethook();
          cylClampBottleExtend.gethook();
          enableCapP.gethook();
          df = true;
        }
        runClockDomain();
      }
      cylPos5ZaxisExtend.setpreclear();
      gripperTurnRetract.setpreclear();
      gripperTurnExtend.setpreclear();
      capGripperPos5Extend.setpreclear();
      cylClampBottleExtend.setpreclear();
      enableCapP.setpreclear();
      gripperZAxisLowered.setpreclear();
      gripperZAxisLifted.setpreclear();
      gripperTurnHomePos.setpreclear();
      gripperTurnFinalPos.setpreclear();
      start.setpreclear();
      capGripped.setpreclear();
      letGo.setpreclear();
      bottleAtPos4E.setpreclear();
      gripperZAxisLoweredE.setpreclear();
      gripperZAxisLiftedE.setpreclear();
      gripperTurnHomePosE.setpreclear();
      gripperTurnFinalPosE.setpreclear();
      capIsGrippedE.setpreclear();
      capperDoneGUI.setpreclear();
      gripperClampGUI.setpreclear();
      bottleAtPos4GUI.setpreclear();
      capperIdleGUI.setpreclear();
      idle_1.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = cylPos5ZaxisExtend.getStatus() ? cylPos5ZaxisExtend.setprepresent() : cylPos5ZaxisExtend.setpreclear();
      cylPos5ZaxisExtend.setpreval(cylPos5ZaxisExtend.getValue());
      cylPos5ZaxisExtend.setClear();
      dummyint = gripperTurnRetract.getStatus() ? gripperTurnRetract.setprepresent() : gripperTurnRetract.setpreclear();
      gripperTurnRetract.setpreval(gripperTurnRetract.getValue());
      gripperTurnRetract.setClear();
      dummyint = gripperTurnExtend.getStatus() ? gripperTurnExtend.setprepresent() : gripperTurnExtend.setpreclear();
      gripperTurnExtend.setpreval(gripperTurnExtend.getValue());
      gripperTurnExtend.setClear();
      dummyint = capGripperPos5Extend.getStatus() ? capGripperPos5Extend.setprepresent() : capGripperPos5Extend.setpreclear();
      capGripperPos5Extend.setpreval(capGripperPos5Extend.getValue());
      capGripperPos5Extend.setClear();
      dummyint = cylClampBottleExtend.getStatus() ? cylClampBottleExtend.setprepresent() : cylClampBottleExtend.setpreclear();
      cylClampBottleExtend.setpreval(cylClampBottleExtend.getValue());
      cylClampBottleExtend.setClear();
      dummyint = enableCapP.getStatus() ? enableCapP.setprepresent() : enableCapP.setpreclear();
      enableCapP.setpreval(enableCapP.getValue());
      enableCapP.setClear();
      gripperZAxisLowered.sethook();
      gripperZAxisLowered.setClear();
      gripperZAxisLifted.sethook();
      gripperZAxisLifted.setClear();
      gripperTurnHomePos.sethook();
      gripperTurnHomePos.setClear();
      gripperTurnFinalPos.sethook();
      gripperTurnFinalPos.setClear();
      start.sethook();
      start.setClear();
      capGripped.sethook();
      capGripped.setClear();
      letGo.sethook();
      letGo.setClear();
      bottleAtPos4E.sethook();
      bottleAtPos4E.setClear();
      gripperZAxisLoweredE.sethook();
      gripperZAxisLoweredE.setClear();
      gripperZAxisLiftedE.sethook();
      gripperZAxisLiftedE.setClear();
      gripperTurnHomePosE.sethook();
      gripperTurnHomePosE.setClear();
      gripperTurnFinalPosE.sethook();
      gripperTurnFinalPosE.setClear();
      capIsGrippedE.sethook();
      capIsGrippedE.setClear();
      capperDoneGUI.sethook();
      capperDoneGUI.setClear();
      gripperClampGUI.sethook();
      gripperClampGUI.setClear();
      bottleAtPos4GUI.sethook();
      bottleAtPos4GUI.setClear();
      capperIdleGUI.sethook();
      capperIdleGUI.setClear();
      idle_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        cylPos5ZaxisExtend.gethook();
        gripperTurnRetract.gethook();
        gripperTurnExtend.gethook();
        capGripperPos5Extend.gethook();
        cylClampBottleExtend.gethook();
        enableCapP.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
