import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class Controller extends ClockDomain{
  public Controller(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal pusherRetracted = new Signal("pusherRetracted", Signal.INPUT);
  public Signal pusherExtended = new Signal("pusherExtended", Signal.INPUT);
  public Signal WPgripped = new Signal("WPgripped", Signal.INPUT);
  public Signal armAtSource = new Signal("armAtSource", Signal.INPUT);
  public Signal armAtDest = new Signal("armAtDest", Signal.INPUT);
  public Signal empty = new Signal("empty", Signal.INPUT);
  public Signal request = new Signal("request", Signal.INPUT);
  public Signal mode = new Signal("mode", Signal.INPUT);
  public Signal pusherExtendM = new Signal("pusherExtendM", Signal.INPUT);
  public Signal vacOnM = new Signal("vacOnM", Signal.INPUT);
  public Signal armSourceM = new Signal("armSourceM", Signal.INPUT);
  public Signal armDestM = new Signal("armDestM", Signal.INPUT);
  public Signal pusherExtend = new Signal("pusherExtend", Signal.OUTPUT);
  public Signal vacOn = new Signal("vacOn", Signal.OUTPUT);
  public Signal armSource = new Signal("armSource", Signal.OUTPUT);
  public Signal armDest = new Signal("armDest", Signal.OUTPUT);
  private Signal modeA_1;
  private Signal modeM_1;
  private int S2038 = 1;
  private int S1618 = 1;
  private int S1833 = 1;
  private int S1689 = 1;
  private int S1621 = 1;
  private int S1651 = 1;
  private int S1662 = 1;
  private int S1661 = 1;
  private int S2036 = 1;
  private int S1900 = 1;
  private int S1842 = 1;
  private int S1850 = 1;
  private int S1858 = 1;
  private int S1866 = 1;
  
  private int[] ends = new int[11];
  private int[] tdone = new int[11];
  
  public void thread2066(int [] tdone, int [] ends){
        S1866=1;
    if(armDestM.getprestatus()){//sysj\controller.sysj line: 122, column: 14
      armDest.setPresent();//sysj\controller.sysj line: 123, column: 7
      currsigs.addElement(armDest);
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

  public void thread2065(int [] tdone, int [] ends){
        S1858=1;
    if(armSourceM.getprestatus()){//sysj\controller.sysj line: 111, column: 14
      armSource.setPresent();//sysj\controller.sysj line: 112, column: 7
      currsigs.addElement(armSource);
      active[9]=1;
      ends[9]=1;
      tdone[9]=1;
    }
    else {
      active[9]=1;
      ends[9]=1;
      tdone[9]=1;
    }
  }

  public void thread2064(int [] tdone, int [] ends){
        S1850=1;
    if(pusherExtendM.getprestatus()){//sysj\controller.sysj line: 100, column: 14
      pusherExtend.setPresent();//sysj\controller.sysj line: 101, column: 7
      currsigs.addElement(pusherExtend);
      active[8]=1;
      ends[8]=1;
      tdone[8]=1;
    }
    else {
      active[8]=1;
      ends[8]=1;
      tdone[8]=1;
    }
  }

  public void thread2063(int [] tdone, int [] ends){
        S1842=1;
    if(vacOnM.getprestatus()){//sysj\controller.sysj line: 89, column: 14
      vacOn.setPresent();//sysj\controller.sysj line: 90, column: 7
      currsigs.addElement(vacOn);
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

  public void thread2061(int [] tdone, int [] ends){
        switch(S1866){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        if(armDestM.getprestatus()){//sysj\controller.sysj line: 122, column: 14
          armDest.setPresent();//sysj\controller.sysj line: 123, column: 7
          currsigs.addElement(armDest);
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

  public void thread2060(int [] tdone, int [] ends){
        switch(S1858){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        if(armSourceM.getprestatus()){//sysj\controller.sysj line: 111, column: 14
          armSource.setPresent();//sysj\controller.sysj line: 112, column: 7
          currsigs.addElement(armSource);
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

  public void thread2059(int [] tdone, int [] ends){
        switch(S1850){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        if(pusherExtendM.getprestatus()){//sysj\controller.sysj line: 100, column: 14
          pusherExtend.setPresent();//sysj\controller.sysj line: 101, column: 7
          currsigs.addElement(pusherExtend);
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

  public void thread2058(int [] tdone, int [] ends){
        switch(S1842){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        if(vacOnM.getprestatus()){//sysj\controller.sysj line: 89, column: 14
          vacOn.setPresent();//sysj\controller.sysj line: 90, column: 7
          currsigs.addElement(vacOn);
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

  public void thread2057(int [] tdone, int [] ends){
        switch(S2036){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S1900){
          case 0 : 
            thread2058(tdone,ends);
            thread2059(tdone,ends);
            thread2060(tdone,ends);
            thread2061(tdone,ends);
            int biggest2062 = 0;
            if(ends[7]>=biggest2062){
              biggest2062=ends[7];
            }
            if(ends[8]>=biggest2062){
              biggest2062=ends[8];
            }
            if(ends[9]>=biggest2062){
              biggest2062=ends[9];
            }
            if(ends[10]>=biggest2062){
              biggest2062=ends[10];
            }
            if(biggest2062 == 1){
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            //FINXME code
            if(biggest2062 == 0){
              S1900=1;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
          case 1 : 
            S1900=1;
            S1900=0;
            if(modeM_1.getprestatus()){//sysj\controller.sysj line: 81, column: 12
              armDest.setPresent();//sysj\controller.sysj line: 82, column: 4
              currsigs.addElement(armDest);
              System.out.print("manual");//sysj\controller.sysj line: 85, column: 4
              thread2063(tdone,ends);
              thread2064(tdone,ends);
              thread2065(tdone,ends);
              thread2066(tdone,ends);
              int biggest2067 = 0;
              if(ends[7]>=biggest2067){
                biggest2067=ends[7];
              }
              if(ends[8]>=biggest2067){
                biggest2067=ends[8];
              }
              if(ends[9]>=biggest2067){
                biggest2067=ends[9];
              }
              if(ends[10]>=biggest2067){
                biggest2067=ends[10];
              }
              if(biggest2067 == 1){
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
            }
            else {
              S1900=1;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2055(int [] tdone, int [] ends){
        switch(S1662){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S1661){
          case 0 : 
            if(WPgripped.getprestatus()){//sysj\controller.sysj line: 60, column: 11
              S1661=1;
              armDest.setPresent();//sysj\controller.sysj line: 62, column: 6
              currsigs.addElement(armDest);
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
          
          case 1 : 
            if(armAtDest.getprestatus()){//sysj\controller.sysj line: 61, column: 11
              S1662=0;
              active[5]=0;
              ends[5]=0;
              tdone[5]=1;
            }
            else {
              armDest.setPresent();//sysj\controller.sysj line: 62, column: 6
              currsigs.addElement(armDest);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2054(int [] tdone, int [] ends){
        switch(S1651){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        if(armAtDest.getprestatus()){//sysj\controller.sysj line: 52, column: 11
          S1651=0;
          active[4]=0;
          ends[4]=0;
          tdone[4]=1;
        }
        else {
          vacOn.setPresent();//sysj\controller.sysj line: 53, column: 6
          currsigs.addElement(vacOn);
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
        break;
      
    }
  }

  public void thread2052(int [] tdone, int [] ends){
        S1662=1;
    S1661=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread2051(int [] tdone, int [] ends){
        S1651=1;
    vacOn.setPresent();//sysj\controller.sysj line: 53, column: 6
    currsigs.addElement(vacOn);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread2050(int [] tdone, int [] ends){
        switch(S1833){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S1689){
          case 0 : 
            switch(S1621){
              case 0 : 
                if(request.getprestatus()){//sysj\controller.sysj line: 37, column: 10
                  S1621=1;
                  armDest.setPresent();//sysj\controller.sysj line: 40, column: 5
                  currsigs.addElement(armDest);
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
                if(armAtDest.getprestatus()){//sysj\controller.sysj line: 39, column: 10
                  S1621=2;
                  pusherExtend.setPresent();//sysj\controller.sysj line: 44, column: 5
                  currsigs.addElement(pusherExtend);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  armDest.setPresent();//sysj\controller.sysj line: 40, column: 5
                  currsigs.addElement(armDest);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                break;
              
              case 2 : 
                if(pusherExtended.getprestatus()){//sysj\controller.sysj line: 43, column: 10
                  S1621=3;
                  armSource.setPresent();//sysj\controller.sysj line: 48, column: 5
                  currsigs.addElement(armSource);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  pusherExtend.setPresent();//sysj\controller.sysj line: 44, column: 5
                  currsigs.addElement(pusherExtend);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                break;
              
              case 3 : 
                if(armAtSource.getprestatus()){//sysj\controller.sysj line: 47, column: 10
                  S1621=4;
                  thread2051(tdone,ends);
                  thread2052(tdone,ends);
                  int biggest2053 = 0;
                  if(ends[4]>=biggest2053){
                    biggest2053=ends[4];
                  }
                  if(ends[5]>=biggest2053){
                    biggest2053=ends[5];
                  }
                  if(biggest2053 == 1){
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                }
                else {
                  armSource.setPresent();//sysj\controller.sysj line: 48, column: 5
                  currsigs.addElement(armSource);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                break;
              
              case 4 : 
                thread2054(tdone,ends);
                thread2055(tdone,ends);
                int biggest2056 = 0;
                if(ends[4]>=biggest2056){
                  biggest2056=ends[4];
                }
                if(ends[5]>=biggest2056){
                  biggest2056=ends[5];
                }
                if(biggest2056 == 1){
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                //FINXME code
                if(biggest2056 == 0){
                  S1621=5;
                  armSource.setPresent();//sysj\controller.sysj line: 67, column: 5
                  currsigs.addElement(armSource);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                break;
              
              case 5 : 
                if(armAtSource.getprestatus()){//sysj\controller.sysj line: 66, column: 10
                  S1689=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  armSource.setPresent();//sysj\controller.sysj line: 67, column: 5
                  currsigs.addElement(armSource);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                break;
              
            }
            break;
          
          case 1 : 
            S1689=1;
            S1689=0;
            if(modeA_1.getprestatus()){//sysj\controller.sysj line: 33, column: 11
              System.out.print("auto");//sysj\controller.sysj line: 35, column: 4
              S1621=0;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S1689=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2049(int [] tdone, int [] ends){
        switch(S1618){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(mode.getprestatus()){//sysj\controller.sysj line: 14, column: 11
          if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\controller.sysj line: 16, column: 8
            modeA_1.setPresent();//sysj\controller.sysj line: 17, column: 5
            currsigs.addElement(modeA_1);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 1){//sysj\controller.sysj line: 19, column: 13
              modeM_1.setPresent();//sysj\controller.sysj line: 20, column: 6
              currsigs.addElement(modeM_1);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              modeA_1.setPresent();//sysj\controller.sysj line: 22, column: 9
              currsigs.addElement(modeA_1);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
          }
        }
        else {
          active[2]=1;
          ends[2]=1;
          tdone[2]=1;
        }
        break;
      
    }
  }

  public void thread2046(int [] tdone, int [] ends){
        S1866=1;
    if(armDestM.getprestatus()){//sysj\controller.sysj line: 122, column: 14
      armDest.setPresent();//sysj\controller.sysj line: 123, column: 7
      currsigs.addElement(armDest);
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

  public void thread2045(int [] tdone, int [] ends){
        S1858=1;
    if(armSourceM.getprestatus()){//sysj\controller.sysj line: 111, column: 14
      armSource.setPresent();//sysj\controller.sysj line: 112, column: 7
      currsigs.addElement(armSource);
      active[9]=1;
      ends[9]=1;
      tdone[9]=1;
    }
    else {
      active[9]=1;
      ends[9]=1;
      tdone[9]=1;
    }
  }

  public void thread2044(int [] tdone, int [] ends){
        S1850=1;
    if(pusherExtendM.getprestatus()){//sysj\controller.sysj line: 100, column: 14
      pusherExtend.setPresent();//sysj\controller.sysj line: 101, column: 7
      currsigs.addElement(pusherExtend);
      active[8]=1;
      ends[8]=1;
      tdone[8]=1;
    }
    else {
      active[8]=1;
      ends[8]=1;
      tdone[8]=1;
    }
  }

  public void thread2043(int [] tdone, int [] ends){
        S1842=1;
    if(vacOnM.getprestatus()){//sysj\controller.sysj line: 89, column: 14
      vacOn.setPresent();//sysj\controller.sysj line: 90, column: 7
      currsigs.addElement(vacOn);
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

  public void thread2042(int [] tdone, int [] ends){
        S2036=1;
    S1900=0;
    if(modeM_1.getprestatus()){//sysj\controller.sysj line: 81, column: 12
      armDest.setPresent();//sysj\controller.sysj line: 82, column: 4
      currsigs.addElement(armDest);
      System.out.print("manual");//sysj\controller.sysj line: 85, column: 4
      thread2043(tdone,ends);
      thread2044(tdone,ends);
      thread2045(tdone,ends);
      thread2046(tdone,ends);
      int biggest2047 = 0;
      if(ends[7]>=biggest2047){
        biggest2047=ends[7];
      }
      if(ends[8]>=biggest2047){
        biggest2047=ends[8];
      }
      if(ends[9]>=biggest2047){
        biggest2047=ends[9];
      }
      if(ends[10]>=biggest2047){
        biggest2047=ends[10];
      }
      if(biggest2047 == 1){
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
      }
    }
    else {
      S1900=1;
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
  }

  public void thread2041(int [] tdone, int [] ends){
        S1833=1;
    S1689=0;
    if(modeA_1.getprestatus()){//sysj\controller.sysj line: 33, column: 11
      System.out.print("auto");//sysj\controller.sysj line: 35, column: 4
      S1621=0;
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
    else {
      S1689=1;
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
  }

  public void thread2040(int [] tdone, int [] ends){
        S1618=1;
    if(mode.getprestatus()){//sysj\controller.sysj line: 14, column: 11
      if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\controller.sysj line: 16, column: 8
        modeA_1.setPresent();//sysj\controller.sysj line: 17, column: 5
        currsigs.addElement(modeA_1);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 1){//sysj\controller.sysj line: 19, column: 13
          modeM_1.setPresent();//sysj\controller.sysj line: 20, column: 6
          currsigs.addElement(modeM_1);
          active[2]=1;
          ends[2]=1;
          tdone[2]=1;
        }
        else {
          modeA_1.setPresent();//sysj\controller.sysj line: 22, column: 9
          currsigs.addElement(modeA_1);
          active[2]=1;
          ends[2]=1;
          tdone[2]=1;
        }
      }
    }
    else {
      active[2]=1;
      ends[2]=1;
      tdone[2]=1;
    }
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S2038){
        case 0 : 
          S2038=0;
          break RUN;
        
        case 1 : 
          S2038=2;
          S2038=2;
          modeA_1.setClear();//sysj\controller.sysj line: 9, column: 2
          modeM_1.setClear();//sysj\controller.sysj line: 9, column: 2
          thread2040(tdone,ends);
          thread2041(tdone,ends);
          thread2042(tdone,ends);
          int biggest2048 = 0;
          if(ends[2]>=biggest2048){
            biggest2048=ends[2];
          }
          if(ends[3]>=biggest2048){
            biggest2048=ends[3];
          }
          if(ends[6]>=biggest2048){
            biggest2048=ends[6];
          }
          if(biggest2048 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          modeA_1.setClear();//sysj\controller.sysj line: 9, column: 2
          modeM_1.setClear();//sysj\controller.sysj line: 9, column: 2
          thread2049(tdone,ends);
          thread2050(tdone,ends);
          thread2057(tdone,ends);
          int biggest2068 = 0;
          if(ends[2]>=biggest2068){
            biggest2068=ends[2];
          }
          if(ends[3]>=biggest2068){
            biggest2068=ends[3];
          }
          if(ends[6]>=biggest2068){
            biggest2068=ends[6];
          }
          if(biggest2068 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest2068 == 0){
            S2038=0;
            active[1]=0;
            ends[1]=0;
            S2038=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    modeA_1 = new Signal();
    modeM_1 = new Signal();
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
          pusherRetracted.gethook();
          pusherExtended.gethook();
          WPgripped.gethook();
          armAtSource.gethook();
          armAtDest.gethook();
          empty.gethook();
          request.gethook();
          mode.gethook();
          pusherExtendM.gethook();
          vacOnM.gethook();
          armSourceM.gethook();
          armDestM.gethook();
          df = true;
        }
        runClockDomain();
      }
      pusherRetracted.setpreclear();
      pusherExtended.setpreclear();
      WPgripped.setpreclear();
      armAtSource.setpreclear();
      armAtDest.setpreclear();
      empty.setpreclear();
      request.setpreclear();
      mode.setpreclear();
      pusherExtendM.setpreclear();
      vacOnM.setpreclear();
      armSourceM.setpreclear();
      armDestM.setpreclear();
      pusherExtend.setpreclear();
      vacOn.setpreclear();
      armSource.setpreclear();
      armDest.setpreclear();
      modeA_1.setpreclear();
      modeM_1.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = pusherRetracted.getStatus() ? pusherRetracted.setprepresent() : pusherRetracted.setpreclear();
      pusherRetracted.setpreval(pusherRetracted.getValue());
      pusherRetracted.setClear();
      dummyint = pusherExtended.getStatus() ? pusherExtended.setprepresent() : pusherExtended.setpreclear();
      pusherExtended.setpreval(pusherExtended.getValue());
      pusherExtended.setClear();
      dummyint = WPgripped.getStatus() ? WPgripped.setprepresent() : WPgripped.setpreclear();
      WPgripped.setpreval(WPgripped.getValue());
      WPgripped.setClear();
      dummyint = armAtSource.getStatus() ? armAtSource.setprepresent() : armAtSource.setpreclear();
      armAtSource.setpreval(armAtSource.getValue());
      armAtSource.setClear();
      dummyint = armAtDest.getStatus() ? armAtDest.setprepresent() : armAtDest.setpreclear();
      armAtDest.setpreval(armAtDest.getValue());
      armAtDest.setClear();
      dummyint = empty.getStatus() ? empty.setprepresent() : empty.setpreclear();
      empty.setpreval(empty.getValue());
      empty.setClear();
      dummyint = request.getStatus() ? request.setprepresent() : request.setpreclear();
      request.setpreval(request.getValue());
      request.setClear();
      dummyint = mode.getStatus() ? mode.setprepresent() : mode.setpreclear();
      mode.setpreval(mode.getValue());
      mode.setClear();
      dummyint = pusherExtendM.getStatus() ? pusherExtendM.setprepresent() : pusherExtendM.setpreclear();
      pusherExtendM.setpreval(pusherExtendM.getValue());
      pusherExtendM.setClear();
      dummyint = vacOnM.getStatus() ? vacOnM.setprepresent() : vacOnM.setpreclear();
      vacOnM.setpreval(vacOnM.getValue());
      vacOnM.setClear();
      dummyint = armSourceM.getStatus() ? armSourceM.setprepresent() : armSourceM.setpreclear();
      armSourceM.setpreval(armSourceM.getValue());
      armSourceM.setClear();
      dummyint = armDestM.getStatus() ? armDestM.setprepresent() : armDestM.setpreclear();
      armDestM.setpreval(armDestM.getValue());
      armDestM.setClear();
      pusherExtend.sethook();
      pusherExtend.setClear();
      vacOn.sethook();
      vacOn.setClear();
      armSource.sethook();
      armSource.setClear();
      armDest.sethook();
      armDest.setClear();
      modeA_1.setClear();
      modeM_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        pusherRetracted.gethook();
        pusherExtended.gethook();
        WPgripped.gethook();
        armAtSource.gethook();
        armAtDest.gethook();
        empty.gethook();
        request.gethook();
        mode.gethook();
        pusherExtendM.gethook();
        vacOnM.gethook();
        armSourceM.gethook();
        armDestM.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
