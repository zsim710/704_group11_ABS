import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.GUI;//sysj\LidLoaderPlant.sysj line: 1, column: 1

public class LidLoaderPlant extends ClockDomain{
  public LidLoaderPlant(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal pusherExtend = new Signal("pusherExtend", Signal.INPUT);
  public Signal vacOn = new Signal("vacOn", Signal.INPUT);
  public Signal armSource = new Signal("armSource", Signal.INPUT);
  public Signal armDest = new Signal("armDest", Signal.INPUT);
  public Signal enableLL = new Signal("enableLL", Signal.INPUT);
  public Signal refill = new Signal("refill", Signal.INPUT);
  public Signal pusherRetracted = new Signal("pusherRetracted", Signal.OUTPUT);
  public Signal pusherExtended = new Signal("pusherExtended", Signal.OUTPUT);
  public Signal WPgripped = new Signal("WPgripped", Signal.OUTPUT);
  public Signal armAtSource = new Signal("armAtSource", Signal.OUTPUT);
  public Signal armAtDest = new Signal("armAtDest", Signal.OUTPUT);
  public Signal empty = new Signal("empty", Signal.OUTPUT);
  public Signal pusherRetractedE = new Signal("pusherRetractedE", Signal.OUTPUT);
  public Signal pusherExtendedE = new Signal("pusherExtendedE", Signal.OUTPUT);
  public Signal WPgrippedE = new Signal("WPgrippedE", Signal.OUTPUT);
  public Signal armAtSourceE = new Signal("armAtSourceE", Signal.OUTPUT);
  public Signal armAtDestE = new Signal("armAtDestE", Signal.OUTPUT);
  public Signal emptyE = new Signal("emptyE", Signal.OUTPUT);
  private Signal capDec_1;
  private Signal capPos_1;
  private int capcount_thread_6;//sysj\LidLoaderPlant.sysj line: 82, column: 3
  private int S4111 = 1;
  private int S3502 = 1;
  private int S3456 = 1;
  private int S3555 = 1;
  private int S3509 = 1;
  private int S3599 = 1;
  private int S3569 = 1;
  private int S3564 = 1;
  private int S3667 = 1;
  private int S3621 = 1;
  private int S3603 = 1;
  private int S3729 = 1;
  private int S3779 = 1;
  private int S3737 = 1;
  private int S3745 = 1;
  private int S3753 = 1;
  private int S3761 = 1;
  private int S3769 = 1;
  private int S3777 = 1;
  
  private int[] ends = new int[14];
  private int[] tdone = new int[14];
  
  public void thread4138(int [] tdone, int [] ends){
        switch(S3777){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        if(empty.getprestatus()){//sysj\LidLoaderPlant.sysj line: 110, column: 24
          emptyE.setPresent();//sysj\LidLoaderPlant.sysj line: 110, column: 31
          currsigs.addElement(emptyE);
          active[13]=1;
          ends[13]=1;
          tdone[13]=1;
        }
        else {
          active[13]=1;
          ends[13]=1;
          tdone[13]=1;
        }
        break;
      
    }
  }

  public void thread4137(int [] tdone, int [] ends){
        switch(S3769){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        if(armAtDest.getprestatus()){//sysj\LidLoaderPlant.sysj line: 108, column: 24
          armAtDestE.setPresent();//sysj\LidLoaderPlant.sysj line: 108, column: 35
          currsigs.addElement(armAtDestE);
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

  public void thread4136(int [] tdone, int [] ends){
        switch(S3761){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        if(armAtSource.getprestatus()){//sysj\LidLoaderPlant.sysj line: 106, column: 24
          armAtSourceE.setPresent();//sysj\LidLoaderPlant.sysj line: 106, column: 37
          currsigs.addElement(armAtSourceE);
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

  public void thread4135(int [] tdone, int [] ends){
        switch(S3753){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        if(WPgripped.getprestatus()){//sysj\LidLoaderPlant.sysj line: 104, column: 24
          WPgrippedE.setPresent();//sysj\LidLoaderPlant.sysj line: 104, column: 35
          currsigs.addElement(WPgrippedE);
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

  public void thread4134(int [] tdone, int [] ends){
        switch(S3745){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        if(pusherExtended.getprestatus()){//sysj\LidLoaderPlant.sysj line: 102, column: 24
          pusherExtendedE.setPresent();//sysj\LidLoaderPlant.sysj line: 102, column: 40
          currsigs.addElement(pusherExtendedE);
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

  public void thread4133(int [] tdone, int [] ends){
        switch(S3737){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        if(pusherRetracted.getprestatus()){//sysj\LidLoaderPlant.sysj line: 100, column: 24
          pusherRetractedE.setPresent();//sysj\LidLoaderPlant.sysj line: 100, column: 41
          currsigs.addElement(pusherRetractedE);
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

  public void thread4132(int [] tdone, int [] ends){
        switch(S3779){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        thread4133(tdone,ends);
        thread4134(tdone,ends);
        thread4135(tdone,ends);
        thread4136(tdone,ends);
        thread4137(tdone,ends);
        thread4138(tdone,ends);
        int biggest4139 = 0;
        if(ends[8]>=biggest4139){
          biggest4139=ends[8];
        }
        if(ends[9]>=biggest4139){
          biggest4139=ends[9];
        }
        if(ends[10]>=biggest4139){
          biggest4139=ends[10];
        }
        if(ends[11]>=biggest4139){
          biggest4139=ends[11];
        }
        if(ends[12]>=biggest4139){
          biggest4139=ends[12];
        }
        if(ends[13]>=biggest4139){
          biggest4139=ends[13];
        }
        if(biggest4139 == 1){
          active[7]=1;
          ends[7]=1;
          tdone[7]=1;
        }
        //FINXME code
        if(biggest4139 == 0){
          S3779=0;
          active[7]=0;
          ends[7]=0;
          tdone[7]=1;
        }
        break;
      
    }
  }

  public void thread4131(int [] tdone, int [] ends){
        switch(S3729){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        if(capDec_1.getprestatus()){//sysj\LidLoaderPlant.sysj line: 84, column: 12
          if(capcount_thread_6 > 0) {//sysj\LidLoaderPlant.sysj line: 85, column: 5
            capcount_thread_6 = capcount_thread_6 - 1;//sysj\LidLoaderPlant.sysj line: 86, column: 6
          }
          if(refill.getprestatus()){//sysj\LidLoaderPlant.sysj line: 88, column: 12
            capcount_thread_6 = 5;//sysj\LidLoaderPlant.sysj line: 89, column: 5
            if(capcount_thread_6 == 0){//sysj\LidLoaderPlant.sysj line: 92, column: 8
              empty.setPresent();//sysj\LidLoaderPlant.sysj line: 93, column: 6
              currsigs.addElement(empty);
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
          else {
            if(capcount_thread_6 == 0){//sysj\LidLoaderPlant.sysj line: 92, column: 8
              empty.setPresent();//sysj\LidLoaderPlant.sysj line: 93, column: 6
              currsigs.addElement(empty);
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
        }
        else {
          if(refill.getprestatus()){//sysj\LidLoaderPlant.sysj line: 88, column: 12
            capcount_thread_6 = 5;//sysj\LidLoaderPlant.sysj line: 89, column: 5
            if(capcount_thread_6 == 0){//sysj\LidLoaderPlant.sysj line: 92, column: 8
              empty.setPresent();//sysj\LidLoaderPlant.sysj line: 93, column: 6
              currsigs.addElement(empty);
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
          else {
            if(capcount_thread_6 == 0){//sysj\LidLoaderPlant.sysj line: 92, column: 8
              empty.setPresent();//sysj\LidLoaderPlant.sysj line: 93, column: 6
              currsigs.addElement(empty);
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
        }
        break;
      
    }
  }

  public void thread4130(int [] tdone, int [] ends){
        switch(S3667){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S3621){
          case 0 : 
            if(empty.getprestatus()){//sysj\LidLoaderPlant.sysj line: 67, column: 10
              S3621=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              switch(S3603){
                case 0 : 
                  if(pusherRetracted.getprestatus()){//sysj\LidLoaderPlant.sysj line: 69, column: 13
                    S3603=1;
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
                  if(pusherExtended.getprestatus()){//sysj\LidLoaderPlant.sysj line: 70, column: 13
                    capPos_1.setPresent();//sysj\LidLoaderPlant.sysj line: 72, column: 7
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(1);//sysj\LidLoaderPlant.sysj line: 72, column: 7
                    S3603=2;
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
                  if(pusherRetracted.getprestatus()){//sysj\LidLoaderPlant.sysj line: 73, column: 13
                    capDec_1.setPresent();//sysj\LidLoaderPlant.sysj line: 74, column: 7
                    currsigs.addElement(capDec_1);
                    S3603=0;
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
            break;
          
          case 1 : 
            if(refill.getprestatus()){//sysj\LidLoaderPlant.sysj line: 77, column: 10
              S3621=0;
              S3603=0;
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

  public void thread4129(int [] tdone, int [] ends){
        switch(S3599){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S3569){
          case 0 : 
            switch(S3564){
              case 0 : 
                if(!vacOn.getprestatus()){//sysj\LidLoaderPlant.sysj line: 47, column: 12
                  S3564=1;
                  if(armAtSource.getprestatus()){//sysj\LidLoaderPlant.sysj line: 50, column: 14
                    capPos_1.setPresent();//sysj\LidLoaderPlant.sysj line: 51, column: 7
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(1);//sysj\LidLoaderPlant.sysj line: 51, column: 7
                    S3569=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S3569=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  WPgripped.setPresent();//sysj\LidLoaderPlant.sysj line: 48, column: 7
                  currsigs.addElement(WPgripped);
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
              case 1 : 
                S3569=0;
                if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\LidLoaderPlant.sysj line: 44, column: 12
                  if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\LidLoaderPlant.sysj line: 45, column: 8
                    capPos_1.setPresent();//sysj\LidLoaderPlant.sysj line: 46, column: 6
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(0);//sysj\LidLoaderPlant.sysj line: 46, column: 6
                    S3564=0;
                    WPgripped.setPresent();//sysj\LidLoaderPlant.sysj line: 48, column: 7
                    currsigs.addElement(WPgripped);
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S3569=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  S3569=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
            }
            break;
          
          case 1 : 
            S3569=1;
            S3569=0;
            if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\LidLoaderPlant.sysj line: 44, column: 12
              if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\LidLoaderPlant.sysj line: 45, column: 8
                capPos_1.setPresent();//sysj\LidLoaderPlant.sysj line: 46, column: 6
                currsigs.addElement(capPos_1);
                capPos_1.setValue(0);//sysj\LidLoaderPlant.sysj line: 46, column: 6
                S3564=0;
                WPgripped.setPresent();//sysj\LidLoaderPlant.sysj line: 48, column: 7
                currsigs.addElement(WPgripped);
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S3569=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              S3569=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread4128(int [] tdone, int [] ends){
        switch(S3555){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S3509){
          case 0 : 
            if(pusherExtend.getprestatus() && enableLL.getprestatus()){//sysj\LidLoaderPlant.sysj line: 31, column: 10
              S3509=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              pusherRetracted.setPresent();//sysj\LidLoaderPlant.sysj line: 32, column: 5
              currsigs.addElement(pusherRetracted);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 1 : 
            if(!enableLL.getprestatus()){//sysj\LidLoaderPlant.sysj line: 34, column: 10
              S3509=2;
              pusherExtended.setPresent();//sysj\LidLoaderPlant.sysj line: 36, column: 5
              currsigs.addElement(pusherExtended);
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
            if(!pusherExtend.getprestatus() && enableLL.getprestatus()){//sysj\LidLoaderPlant.sysj line: 35, column: 10
              S3509=3;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              pusherExtended.setPresent();//sysj\LidLoaderPlant.sysj line: 36, column: 5
              currsigs.addElement(pusherExtended);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 3 : 
            if(!enableLL.getprestatus()){//sysj\LidLoaderPlant.sysj line: 38, column: 10
              S3509=0;
              pusherRetracted.setPresent();//sysj\LidLoaderPlant.sysj line: 32, column: 5
              currsigs.addElement(pusherRetracted);
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

  public void thread4127(int [] tdone, int [] ends){
        switch(S3502){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S3456){
          case 0 : 
            if(armSource.getprestatus() && enableLL.getprestatus()){//sysj\LidLoaderPlant.sysj line: 18, column: 10
              S3456=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              armAtDest.setPresent();//sysj\LidLoaderPlant.sysj line: 19, column: 5
              currsigs.addElement(armAtDest);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 1 : 
            if(!enableLL.getprestatus()){//sysj\LidLoaderPlant.sysj line: 21, column: 10
              S3456=2;
              armAtSource.setPresent();//sysj\LidLoaderPlant.sysj line: 23, column: 5
              currsigs.addElement(armAtSource);
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
            if(armDest.getprestatus() && enableLL.getprestatus()){//sysj\LidLoaderPlant.sysj line: 22, column: 10
              S3456=3;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              armAtSource.setPresent();//sysj\LidLoaderPlant.sysj line: 23, column: 5
              currsigs.addElement(armAtSource);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 3 : 
            if(!enableLL.getprestatus()){//sysj\LidLoaderPlant.sysj line: 25, column: 10
              S3456=0;
              armAtDest.setPresent();//sysj\LidLoaderPlant.sysj line: 19, column: 5
              currsigs.addElement(armAtDest);
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

  public void thread4124(int [] tdone, int [] ends){
        S3777=1;
    if(empty.getprestatus()){//sysj\LidLoaderPlant.sysj line: 110, column: 24
      emptyE.setPresent();//sysj\LidLoaderPlant.sysj line: 110, column: 31
      currsigs.addElement(emptyE);
      active[13]=1;
      ends[13]=1;
      tdone[13]=1;
    }
    else {
      active[13]=1;
      ends[13]=1;
      tdone[13]=1;
    }
  }

  public void thread4123(int [] tdone, int [] ends){
        S3769=1;
    if(armAtDest.getprestatus()){//sysj\LidLoaderPlant.sysj line: 108, column: 24
      armAtDestE.setPresent();//sysj\LidLoaderPlant.sysj line: 108, column: 35
      currsigs.addElement(armAtDestE);
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

  public void thread4122(int [] tdone, int [] ends){
        S3761=1;
    if(armAtSource.getprestatus()){//sysj\LidLoaderPlant.sysj line: 106, column: 24
      armAtSourceE.setPresent();//sysj\LidLoaderPlant.sysj line: 106, column: 37
      currsigs.addElement(armAtSourceE);
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

  public void thread4121(int [] tdone, int [] ends){
        S3753=1;
    if(WPgripped.getprestatus()){//sysj\LidLoaderPlant.sysj line: 104, column: 24
      WPgrippedE.setPresent();//sysj\LidLoaderPlant.sysj line: 104, column: 35
      currsigs.addElement(WPgrippedE);
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

  public void thread4120(int [] tdone, int [] ends){
        S3745=1;
    if(pusherExtended.getprestatus()){//sysj\LidLoaderPlant.sysj line: 102, column: 24
      pusherExtendedE.setPresent();//sysj\LidLoaderPlant.sysj line: 102, column: 40
      currsigs.addElement(pusherExtendedE);
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

  public void thread4119(int [] tdone, int [] ends){
        S3737=1;
    if(pusherRetracted.getprestatus()){//sysj\LidLoaderPlant.sysj line: 100, column: 24
      pusherRetractedE.setPresent();//sysj\LidLoaderPlant.sysj line: 100, column: 41
      currsigs.addElement(pusherRetractedE);
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

  public void thread4118(int [] tdone, int [] ends){
        S3779=1;
    thread4119(tdone,ends);
    thread4120(tdone,ends);
    thread4121(tdone,ends);
    thread4122(tdone,ends);
    thread4123(tdone,ends);
    thread4124(tdone,ends);
    int biggest4125 = 0;
    if(ends[8]>=biggest4125){
      biggest4125=ends[8];
    }
    if(ends[9]>=biggest4125){
      biggest4125=ends[9];
    }
    if(ends[10]>=biggest4125){
      biggest4125=ends[10];
    }
    if(ends[11]>=biggest4125){
      biggest4125=ends[11];
    }
    if(ends[12]>=biggest4125){
      biggest4125=ends[12];
    }
    if(ends[13]>=biggest4125){
      biggest4125=ends[13];
    }
    if(biggest4125 == 1){
      active[7]=1;
      ends[7]=1;
      tdone[7]=1;
    }
  }

  public void thread4117(int [] tdone, int [] ends){
        S3729=1;
    capcount_thread_6 = 5;//sysj\LidLoaderPlant.sysj line: 82, column: 3
    if(capDec_1.getprestatus()){//sysj\LidLoaderPlant.sysj line: 84, column: 12
      if(capcount_thread_6 > 0) {//sysj\LidLoaderPlant.sysj line: 85, column: 5
        capcount_thread_6 = capcount_thread_6 - 1;//sysj\LidLoaderPlant.sysj line: 86, column: 6
      }
      if(refill.getprestatus()){//sysj\LidLoaderPlant.sysj line: 88, column: 12
        capcount_thread_6 = 5;//sysj\LidLoaderPlant.sysj line: 89, column: 5
        if(capcount_thread_6 == 0){//sysj\LidLoaderPlant.sysj line: 92, column: 8
          empty.setPresent();//sysj\LidLoaderPlant.sysj line: 93, column: 6
          currsigs.addElement(empty);
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
      else {
        if(capcount_thread_6 == 0){//sysj\LidLoaderPlant.sysj line: 92, column: 8
          empty.setPresent();//sysj\LidLoaderPlant.sysj line: 93, column: 6
          currsigs.addElement(empty);
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
    }
    else {
      if(refill.getprestatus()){//sysj\LidLoaderPlant.sysj line: 88, column: 12
        capcount_thread_6 = 5;//sysj\LidLoaderPlant.sysj line: 89, column: 5
        if(capcount_thread_6 == 0){//sysj\LidLoaderPlant.sysj line: 92, column: 8
          empty.setPresent();//sysj\LidLoaderPlant.sysj line: 93, column: 6
          currsigs.addElement(empty);
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
      else {
        if(capcount_thread_6 == 0){//sysj\LidLoaderPlant.sysj line: 92, column: 8
          empty.setPresent();//sysj\LidLoaderPlant.sysj line: 93, column: 6
          currsigs.addElement(empty);
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
    }
  }

  public void thread4116(int [] tdone, int [] ends){
        S3667=1;
    S3621=0;
    S3603=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread4115(int [] tdone, int [] ends){
        S3599=1;
    S3569=0;
    if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\LidLoaderPlant.sysj line: 44, column: 12
      if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\LidLoaderPlant.sysj line: 45, column: 8
        capPos_1.setPresent();//sysj\LidLoaderPlant.sysj line: 46, column: 6
        currsigs.addElement(capPos_1);
        capPos_1.setValue(0);//sysj\LidLoaderPlant.sysj line: 46, column: 6
        S3564=0;
        WPgripped.setPresent();//sysj\LidLoaderPlant.sysj line: 48, column: 7
        currsigs.addElement(WPgripped);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        S3569=1;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
    }
    else {
      S3569=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread4114(int [] tdone, int [] ends){
        S3555=1;
    S3509=0;
    pusherRetracted.setPresent();//sysj\LidLoaderPlant.sysj line: 32, column: 5
    currsigs.addElement(pusherRetracted);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread4113(int [] tdone, int [] ends){
        S3502=1;
    S3456=0;
    armAtDest.setPresent();//sysj\LidLoaderPlant.sysj line: 19, column: 5
    currsigs.addElement(armAtDest);
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
      switch(S4111){
        case 0 : 
          S4111=0;
          break RUN;
        
        case 1 : 
          S4111=2;
          S4111=2;
          capDec_1.setClear();//sysj\LidLoaderPlant.sysj line: 13, column: 2
          capPos_1.setClear();//sysj\LidLoaderPlant.sysj line: 14, column: 2
          capPos_1.setPresent();//sysj\LidLoaderPlant.sysj line: 15, column: 2
          currsigs.addElement(capPos_1);
          capPos_1.setValue(0);//sysj\LidLoaderPlant.sysj line: 15, column: 2
          thread4113(tdone,ends);
          thread4114(tdone,ends);
          thread4115(tdone,ends);
          thread4116(tdone,ends);
          thread4117(tdone,ends);
          thread4118(tdone,ends);
          int biggest4126 = 0;
          if(ends[2]>=biggest4126){
            biggest4126=ends[2];
          }
          if(ends[3]>=biggest4126){
            biggest4126=ends[3];
          }
          if(ends[4]>=biggest4126){
            biggest4126=ends[4];
          }
          if(ends[5]>=biggest4126){
            biggest4126=ends[5];
          }
          if(ends[6]>=biggest4126){
            biggest4126=ends[6];
          }
          if(ends[7]>=biggest4126){
            biggest4126=ends[7];
          }
          if(biggest4126 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          capDec_1.setClear();//sysj\LidLoaderPlant.sysj line: 13, column: 2
          capPos_1.setClear();//sysj\LidLoaderPlant.sysj line: 14, column: 2
          thread4127(tdone,ends);
          thread4128(tdone,ends);
          thread4129(tdone,ends);
          thread4130(tdone,ends);
          thread4131(tdone,ends);
          thread4132(tdone,ends);
          int biggest4140 = 0;
          if(ends[2]>=biggest4140){
            biggest4140=ends[2];
          }
          if(ends[3]>=biggest4140){
            biggest4140=ends[3];
          }
          if(ends[4]>=biggest4140){
            biggest4140=ends[4];
          }
          if(ends[5]>=biggest4140){
            biggest4140=ends[5];
          }
          if(ends[6]>=biggest4140){
            biggest4140=ends[6];
          }
          if(ends[7]>=biggest4140){
            biggest4140=ends[7];
          }
          if(biggest4140 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest4140 == 0){
            S4111=0;
            active[1]=0;
            ends[1]=0;
            S4111=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    capDec_1 = new Signal();
    capPos_1 = new Signal();
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
          pusherExtend.gethook();
          vacOn.gethook();
          armSource.gethook();
          armDest.gethook();
          enableLL.gethook();
          refill.gethook();
          df = true;
        }
        runClockDomain();
      }
      pusherExtend.setpreclear();
      vacOn.setpreclear();
      armSource.setpreclear();
      armDest.setpreclear();
      enableLL.setpreclear();
      refill.setpreclear();
      pusherRetracted.setpreclear();
      pusherExtended.setpreclear();
      WPgripped.setpreclear();
      armAtSource.setpreclear();
      armAtDest.setpreclear();
      empty.setpreclear();
      pusherRetractedE.setpreclear();
      pusherExtendedE.setpreclear();
      WPgrippedE.setpreclear();
      armAtSourceE.setpreclear();
      armAtDestE.setpreclear();
      emptyE.setpreclear();
      capDec_1.setpreclear();
      capPos_1.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = pusherExtend.getStatus() ? pusherExtend.setprepresent() : pusherExtend.setpreclear();
      pusherExtend.setpreval(pusherExtend.getValue());
      pusherExtend.setClear();
      dummyint = vacOn.getStatus() ? vacOn.setprepresent() : vacOn.setpreclear();
      vacOn.setpreval(vacOn.getValue());
      vacOn.setClear();
      dummyint = armSource.getStatus() ? armSource.setprepresent() : armSource.setpreclear();
      armSource.setpreval(armSource.getValue());
      armSource.setClear();
      dummyint = armDest.getStatus() ? armDest.setprepresent() : armDest.setpreclear();
      armDest.setpreval(armDest.getValue());
      armDest.setClear();
      dummyint = enableLL.getStatus() ? enableLL.setprepresent() : enableLL.setpreclear();
      enableLL.setpreval(enableLL.getValue());
      enableLL.setClear();
      dummyint = refill.getStatus() ? refill.setprepresent() : refill.setpreclear();
      refill.setpreval(refill.getValue());
      refill.setClear();
      pusherRetracted.sethook();
      pusherRetracted.setClear();
      pusherExtended.sethook();
      pusherExtended.setClear();
      WPgripped.sethook();
      WPgripped.setClear();
      armAtSource.sethook();
      armAtSource.setClear();
      armAtDest.sethook();
      armAtDest.setClear();
      empty.sethook();
      empty.setClear();
      pusherRetractedE.sethook();
      pusherRetractedE.setClear();
      pusherExtendedE.sethook();
      pusherExtendedE.setClear();
      WPgrippedE.sethook();
      WPgrippedE.setClear();
      armAtSourceE.sethook();
      armAtSourceE.setClear();
      armAtDestE.sethook();
      armAtDestE.setClear();
      emptyE.sethook();
      emptyE.setClear();
      capDec_1.setClear();
      capPos_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        pusherExtend.gethook();
        vacOn.gethook();
        armSource.gethook();
        armDest.gethook();
        enableLL.gethook();
        refill.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
