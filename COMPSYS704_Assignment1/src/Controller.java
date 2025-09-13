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
  private int S807 = 1;
  private int S387 = 1;
  private int S602 = 1;
  private int S458 = 1;
  private int S390 = 1;
  private int S420 = 1;
  private int S431 = 1;
  private int S430 = 1;
  private int S805 = 1;
  private int S669 = 1;
  private int S611 = 1;
  private int S619 = 1;
  private int S627 = 1;
  private int S635 = 1;
  
  private int[] ends = new int[11];
  private int[] tdone = new int[11];
  
  public void thread835(int [] tdone, int [] ends){
        S635=1;
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

  public void thread834(int [] tdone, int [] ends){
        S627=1;
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

  public void thread833(int [] tdone, int [] ends){
        S619=1;
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

  public void thread832(int [] tdone, int [] ends){
        S611=1;
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

  public void thread830(int [] tdone, int [] ends){
        switch(S635){
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

  public void thread829(int [] tdone, int [] ends){
        switch(S627){
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

  public void thread828(int [] tdone, int [] ends){
        switch(S619){
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

  public void thread827(int [] tdone, int [] ends){
        switch(S611){
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

  public void thread826(int [] tdone, int [] ends){
        switch(S805){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S669){
          case 0 : 
            thread827(tdone,ends);
            thread828(tdone,ends);
            thread829(tdone,ends);
            thread830(tdone,ends);
            int biggest831 = 0;
            if(ends[7]>=biggest831){
              biggest831=ends[7];
            }
            if(ends[8]>=biggest831){
              biggest831=ends[8];
            }
            if(ends[9]>=biggest831){
              biggest831=ends[9];
            }
            if(ends[10]>=biggest831){
              biggest831=ends[10];
            }
            if(biggest831 == 1){
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            //FINXME code
            if(biggest831 == 0){
              S669=1;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
          case 1 : 
            S669=1;
            S669=0;
            if(modeM_1.getprestatus()){//sysj\controller.sysj line: 81, column: 12
              armDest.setPresent();//sysj\controller.sysj line: 82, column: 4
              currsigs.addElement(armDest);
              System.out.print("manual");//sysj\controller.sysj line: 85, column: 4
              thread832(tdone,ends);
              thread833(tdone,ends);
              thread834(tdone,ends);
              thread835(tdone,ends);
              int biggest836 = 0;
              if(ends[7]>=biggest836){
                biggest836=ends[7];
              }
              if(ends[8]>=biggest836){
                biggest836=ends[8];
              }
              if(ends[9]>=biggest836){
                biggest836=ends[9];
              }
              if(ends[10]>=biggest836){
                biggest836=ends[10];
              }
              if(biggest836 == 1){
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
            }
            else {
              S669=1;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread824(int [] tdone, int [] ends){
        switch(S431){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S430){
          case 0 : 
            if(WPgripped.getprestatus()){//sysj\controller.sysj line: 60, column: 11
              S430=1;
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
              S431=0;
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

  public void thread823(int [] tdone, int [] ends){
        switch(S420){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        if(armAtDest.getprestatus()){//sysj\controller.sysj line: 52, column: 11
          S420=0;
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

  public void thread821(int [] tdone, int [] ends){
        S431=1;
    S430=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread820(int [] tdone, int [] ends){
        S420=1;
    vacOn.setPresent();//sysj\controller.sysj line: 53, column: 6
    currsigs.addElement(vacOn);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread819(int [] tdone, int [] ends){
        switch(S602){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S458){
          case 0 : 
            switch(S390){
              case 0 : 
                if(request.getprestatus()){//sysj\controller.sysj line: 37, column: 10
                  S390=1;
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
                  S390=2;
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
                  S390=3;
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
                  S390=4;
                  thread820(tdone,ends);
                  thread821(tdone,ends);
                  int biggest822 = 0;
                  if(ends[4]>=biggest822){
                    biggest822=ends[4];
                  }
                  if(ends[5]>=biggest822){
                    biggest822=ends[5];
                  }
                  if(biggest822 == 1){
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
                thread823(tdone,ends);
                thread824(tdone,ends);
                int biggest825 = 0;
                if(ends[4]>=biggest825){
                  biggest825=ends[4];
                }
                if(ends[5]>=biggest825){
                  biggest825=ends[5];
                }
                if(biggest825 == 1){
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                //FINXME code
                if(biggest825 == 0){
                  S390=5;
                  armSource.setPresent();//sysj\controller.sysj line: 67, column: 5
                  currsigs.addElement(armSource);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                break;
              
              case 5 : 
                if(armAtSource.getprestatus()){//sysj\controller.sysj line: 66, column: 10
                  S458=1;
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
            S458=1;
            S458=0;
            if(modeA_1.getprestatus()){//sysj\controller.sysj line: 33, column: 11
              System.out.print("auto");//sysj\controller.sysj line: 35, column: 4
              S390=0;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S458=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread818(int [] tdone, int [] ends){
        switch(S387){
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

  public void thread815(int [] tdone, int [] ends){
        S635=1;
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

  public void thread814(int [] tdone, int [] ends){
        S627=1;
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

  public void thread813(int [] tdone, int [] ends){
        S619=1;
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

  public void thread812(int [] tdone, int [] ends){
        S611=1;
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

  public void thread811(int [] tdone, int [] ends){
        S805=1;
    S669=0;
    if(modeM_1.getprestatus()){//sysj\controller.sysj line: 81, column: 12
      armDest.setPresent();//sysj\controller.sysj line: 82, column: 4
      currsigs.addElement(armDest);
      System.out.print("manual");//sysj\controller.sysj line: 85, column: 4
      thread812(tdone,ends);
      thread813(tdone,ends);
      thread814(tdone,ends);
      thread815(tdone,ends);
      int biggest816 = 0;
      if(ends[7]>=biggest816){
        biggest816=ends[7];
      }
      if(ends[8]>=biggest816){
        biggest816=ends[8];
      }
      if(ends[9]>=biggest816){
        biggest816=ends[9];
      }
      if(ends[10]>=biggest816){
        biggest816=ends[10];
      }
      if(biggest816 == 1){
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
      }
    }
    else {
      S669=1;
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
  }

  public void thread810(int [] tdone, int [] ends){
        S602=1;
    S458=0;
    if(modeA_1.getprestatus()){//sysj\controller.sysj line: 33, column: 11
      System.out.print("auto");//sysj\controller.sysj line: 35, column: 4
      S390=0;
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
    else {
      S458=1;
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
  }

  public void thread809(int [] tdone, int [] ends){
        S387=1;
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
      switch(S807){
        case 0 : 
          S807=0;
          break RUN;
        
        case 1 : 
          S807=2;
          S807=2;
          modeA_1.setClear();//sysj\controller.sysj line: 9, column: 2
          modeM_1.setClear();//sysj\controller.sysj line: 9, column: 2
          thread809(tdone,ends);
          thread810(tdone,ends);
          thread811(tdone,ends);
          int biggest817 = 0;
          if(ends[2]>=biggest817){
            biggest817=ends[2];
          }
          if(ends[3]>=biggest817){
            biggest817=ends[3];
          }
          if(ends[6]>=biggest817){
            biggest817=ends[6];
          }
          if(biggest817 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          modeA_1.setClear();//sysj\controller.sysj line: 9, column: 2
          modeM_1.setClear();//sysj\controller.sysj line: 9, column: 2
          thread818(tdone,ends);
          thread819(tdone,ends);
          thread826(tdone,ends);
          int biggest837 = 0;
          if(ends[2]>=biggest837){
            biggest837=ends[2];
          }
          if(ends[3]>=biggest837){
            biggest837=ends[3];
          }
          if(ends[6]>=biggest837){
            biggest837=ends[6];
          }
          if(biggest837 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest837 == 0){
            S807=0;
            active[1]=0;
            ends[1]=0;
            S807=0;
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
