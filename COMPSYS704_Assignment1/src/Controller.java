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
  private int S435 = 1;
  private int S15 = 1;
  private int S230 = 1;
  private int S86 = 1;
  private int S18 = 1;
  private int S48 = 1;
  private int S59 = 1;
  private int S58 = 1;
  private int S433 = 1;
  private int S297 = 1;
  private int S239 = 1;
  private int S247 = 1;
  private int S255 = 1;
  private int S263 = 1;
  
  private int[] ends = new int[11];
  private int[] tdone = new int[11];
  
  public void thread463(int [] tdone, int [] ends){
        S263=1;
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

  public void thread462(int [] tdone, int [] ends){
        S255=1;
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

  public void thread461(int [] tdone, int [] ends){
        S247=1;
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

  public void thread460(int [] tdone, int [] ends){
        S239=1;
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

  public void thread458(int [] tdone, int [] ends){
        switch(S263){
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

  public void thread457(int [] tdone, int [] ends){
        switch(S255){
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

  public void thread456(int [] tdone, int [] ends){
        switch(S247){
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

  public void thread455(int [] tdone, int [] ends){
        switch(S239){
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

  public void thread454(int [] tdone, int [] ends){
        switch(S433){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S297){
          case 0 : 
            thread455(tdone,ends);
            thread456(tdone,ends);
            thread457(tdone,ends);
            thread458(tdone,ends);
            int biggest459 = 0;
            if(ends[7]>=biggest459){
              biggest459=ends[7];
            }
            if(ends[8]>=biggest459){
              biggest459=ends[8];
            }
            if(ends[9]>=biggest459){
              biggest459=ends[9];
            }
            if(ends[10]>=biggest459){
              biggest459=ends[10];
            }
            if(biggest459 == 1){
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            //FINXME code
            if(biggest459 == 0){
              S297=1;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
          case 1 : 
            S297=1;
            S297=0;
            if(modeM_1.getprestatus()){//sysj\controller.sysj line: 81, column: 12
              armDest.setPresent();//sysj\controller.sysj line: 82, column: 4
              currsigs.addElement(armDest);
              System.out.print("manual");//sysj\controller.sysj line: 85, column: 4
              thread460(tdone,ends);
              thread461(tdone,ends);
              thread462(tdone,ends);
              thread463(tdone,ends);
              int biggest464 = 0;
              if(ends[7]>=biggest464){
                biggest464=ends[7];
              }
              if(ends[8]>=biggest464){
                biggest464=ends[8];
              }
              if(ends[9]>=biggest464){
                biggest464=ends[9];
              }
              if(ends[10]>=biggest464){
                biggest464=ends[10];
              }
              if(biggest464 == 1){
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
            }
            else {
              S297=1;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread452(int [] tdone, int [] ends){
        switch(S59){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S58){
          case 0 : 
            if(WPgripped.getprestatus()){//sysj\controller.sysj line: 60, column: 11
              S58=1;
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
              S59=0;
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

  public void thread451(int [] tdone, int [] ends){
        switch(S48){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        if(armAtDest.getprestatus()){//sysj\controller.sysj line: 52, column: 11
          S48=0;
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

  public void thread449(int [] tdone, int [] ends){
        S59=1;
    S58=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread448(int [] tdone, int [] ends){
        S48=1;
    vacOn.setPresent();//sysj\controller.sysj line: 53, column: 6
    currsigs.addElement(vacOn);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread447(int [] tdone, int [] ends){
        switch(S230){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S86){
          case 0 : 
            switch(S18){
              case 0 : 
                if(request.getprestatus()){//sysj\controller.sysj line: 37, column: 10
                  S18=1;
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
                  S18=2;
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
                  S18=3;
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
                  S18=4;
                  thread448(tdone,ends);
                  thread449(tdone,ends);
                  int biggest450 = 0;
                  if(ends[4]>=biggest450){
                    biggest450=ends[4];
                  }
                  if(ends[5]>=biggest450){
                    biggest450=ends[5];
                  }
                  if(biggest450 == 1){
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
                thread451(tdone,ends);
                thread452(tdone,ends);
                int biggest453 = 0;
                if(ends[4]>=biggest453){
                  biggest453=ends[4];
                }
                if(ends[5]>=biggest453){
                  biggest453=ends[5];
                }
                if(biggest453 == 1){
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                //FINXME code
                if(biggest453 == 0){
                  S18=5;
                  armSource.setPresent();//sysj\controller.sysj line: 67, column: 5
                  currsigs.addElement(armSource);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                break;
              
              case 5 : 
                if(armAtSource.getprestatus()){//sysj\controller.sysj line: 66, column: 10
                  S86=1;
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
            S86=1;
            S86=0;
            if(modeA_1.getprestatus()){//sysj\controller.sysj line: 33, column: 11
              System.out.print("auto");//sysj\controller.sysj line: 35, column: 4
              S18=0;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S86=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread446(int [] tdone, int [] ends){
        switch(S15){
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

  public void thread443(int [] tdone, int [] ends){
        S263=1;
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

  public void thread442(int [] tdone, int [] ends){
        S255=1;
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

  public void thread441(int [] tdone, int [] ends){
        S247=1;
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

  public void thread440(int [] tdone, int [] ends){
        S239=1;
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

  public void thread439(int [] tdone, int [] ends){
        S433=1;
    S297=0;
    if(modeM_1.getprestatus()){//sysj\controller.sysj line: 81, column: 12
      armDest.setPresent();//sysj\controller.sysj line: 82, column: 4
      currsigs.addElement(armDest);
      System.out.print("manual");//sysj\controller.sysj line: 85, column: 4
      thread440(tdone,ends);
      thread441(tdone,ends);
      thread442(tdone,ends);
      thread443(tdone,ends);
      int biggest444 = 0;
      if(ends[7]>=biggest444){
        biggest444=ends[7];
      }
      if(ends[8]>=biggest444){
        biggest444=ends[8];
      }
      if(ends[9]>=biggest444){
        biggest444=ends[9];
      }
      if(ends[10]>=biggest444){
        biggest444=ends[10];
      }
      if(biggest444 == 1){
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
      }
    }
    else {
      S297=1;
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
  }

  public void thread438(int [] tdone, int [] ends){
        S230=1;
    S86=0;
    if(modeA_1.getprestatus()){//sysj\controller.sysj line: 33, column: 11
      System.out.print("auto");//sysj\controller.sysj line: 35, column: 4
      S18=0;
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
    else {
      S86=1;
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
  }

  public void thread437(int [] tdone, int [] ends){
        S15=1;
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
      switch(S435){
        case 0 : 
          S435=0;
          break RUN;
        
        case 1 : 
          S435=2;
          S435=2;
          modeA_1.setClear();//sysj\controller.sysj line: 9, column: 2
          modeM_1.setClear();//sysj\controller.sysj line: 9, column: 2
          thread437(tdone,ends);
          thread438(tdone,ends);
          thread439(tdone,ends);
          int biggest445 = 0;
          if(ends[2]>=biggest445){
            biggest445=ends[2];
          }
          if(ends[3]>=biggest445){
            biggest445=ends[3];
          }
          if(ends[6]>=biggest445){
            biggest445=ends[6];
          }
          if(biggest445 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          modeA_1.setClear();//sysj\controller.sysj line: 9, column: 2
          modeM_1.setClear();//sysj\controller.sysj line: 9, column: 2
          thread446(tdone,ends);
          thread447(tdone,ends);
          thread454(tdone,ends);
          int biggest465 = 0;
          if(ends[2]>=biggest465){
            biggest465=ends[2];
          }
          if(ends[3]>=biggest465){
            biggest465=ends[3];
          }
          if(ends[6]>=biggest465){
            biggest465=ends[6];
          }
          if(biggest465 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest465 == 0){
            S435=0;
            active[1]=0;
            ends[1]=0;
            S435=0;
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
