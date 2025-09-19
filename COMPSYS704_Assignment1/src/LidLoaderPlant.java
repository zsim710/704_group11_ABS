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
  public Signal refill = new Signal("refill", Signal.INPUT);
  public Signal start = new Signal("start", Signal.INPUT);
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
  private int capcount_thread_6;//sysj\LidLoaderPlant.sysj line: 81, column: 3
  private int S7757 = 1;
  private int S6838 = 1;
  private int S6879 = 1;
  private int S6851 = 1;
  private int S6920 = 1;
  private int S6892 = 1;
  private int S6964 = 1;
  private int S6934 = 1;
  private int S6929 = 1;
  private int S7032 = 1;
  private int S6986 = 1;
  private int S6968 = 1;
  private int S7094 = 1;
  private int S7144 = 1;
  private int S7102 = 1;
  private int S7110 = 1;
  private int S7118 = 1;
  private int S7126 = 1;
  private int S7134 = 1;
  private int S7142 = 1;
  
  private int[] ends = new int[14];
  private int[] tdone = new int[14];
  
  public void thread7798(int [] tdone, int [] ends){
        switch(S7142){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        if(empty.getprestatus()){//sysj\LidLoaderPlant.sysj line: 109, column: 24
          emptyE.setPresent();//sysj\LidLoaderPlant.sysj line: 109, column: 31
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

  public void thread7797(int [] tdone, int [] ends){
        switch(S7134){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        if(armAtDest.getprestatus()){//sysj\LidLoaderPlant.sysj line: 107, column: 24
          armAtDestE.setPresent();//sysj\LidLoaderPlant.sysj line: 107, column: 35
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

  public void thread7796(int [] tdone, int [] ends){
        switch(S7126){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        if(armAtSource.getprestatus()){//sysj\LidLoaderPlant.sysj line: 105, column: 24
          armAtSourceE.setPresent();//sysj\LidLoaderPlant.sysj line: 105, column: 37
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

  public void thread7795(int [] tdone, int [] ends){
        switch(S7118){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        if(WPgripped.getprestatus()){//sysj\LidLoaderPlant.sysj line: 103, column: 24
          WPgrippedE.setPresent();//sysj\LidLoaderPlant.sysj line: 103, column: 35
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

  public void thread7794(int [] tdone, int [] ends){
        switch(S7110){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        if(pusherExtended.getprestatus()){//sysj\LidLoaderPlant.sysj line: 101, column: 24
          pusherExtendedE.setPresent();//sysj\LidLoaderPlant.sysj line: 101, column: 40
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

  public void thread7793(int [] tdone, int [] ends){
        switch(S7102){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        if(pusherRetracted.getprestatus()){//sysj\LidLoaderPlant.sysj line: 99, column: 24
          pusherRetractedE.setPresent();//sysj\LidLoaderPlant.sysj line: 99, column: 41
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

  public void thread7792(int [] tdone, int [] ends){
        switch(S7144){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        thread7793(tdone,ends);
        thread7794(tdone,ends);
        thread7795(tdone,ends);
        thread7796(tdone,ends);
        thread7797(tdone,ends);
        thread7798(tdone,ends);
        int biggest7799 = 0;
        if(ends[8]>=biggest7799){
          biggest7799=ends[8];
        }
        if(ends[9]>=biggest7799){
          biggest7799=ends[9];
        }
        if(ends[10]>=biggest7799){
          biggest7799=ends[10];
        }
        if(ends[11]>=biggest7799){
          biggest7799=ends[11];
        }
        if(ends[12]>=biggest7799){
          biggest7799=ends[12];
        }
        if(ends[13]>=biggest7799){
          biggest7799=ends[13];
        }
        if(biggest7799 == 1){
          active[7]=1;
          ends[7]=1;
          tdone[7]=1;
        }
        //FINXME code
        if(biggest7799 == 0){
          S7144=0;
          active[7]=0;
          ends[7]=0;
          tdone[7]=1;
        }
        break;
      
    }
  }

  public void thread7791(int [] tdone, int [] ends){
        switch(S7094){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        if(capDec_1.getprestatus()){//sysj\LidLoaderPlant.sysj line: 83, column: 12
          if(capcount_thread_6 > 0) {//sysj\LidLoaderPlant.sysj line: 84, column: 5
            capcount_thread_6 = capcount_thread_6 - 1;//sysj\LidLoaderPlant.sysj line: 85, column: 6
          }
          if(refill.getprestatus()){//sysj\LidLoaderPlant.sysj line: 87, column: 12
            capcount_thread_6 = 5;//sysj\LidLoaderPlant.sysj line: 88, column: 5
            if(capcount_thread_6 == 0){//sysj\LidLoaderPlant.sysj line: 91, column: 8
              empty.setPresent();//sysj\LidLoaderPlant.sysj line: 92, column: 6
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
            if(capcount_thread_6 == 0){//sysj\LidLoaderPlant.sysj line: 91, column: 8
              empty.setPresent();//sysj\LidLoaderPlant.sysj line: 92, column: 6
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
          if(refill.getprestatus()){//sysj\LidLoaderPlant.sysj line: 87, column: 12
            capcount_thread_6 = 5;//sysj\LidLoaderPlant.sysj line: 88, column: 5
            if(capcount_thread_6 == 0){//sysj\LidLoaderPlant.sysj line: 91, column: 8
              empty.setPresent();//sysj\LidLoaderPlant.sysj line: 92, column: 6
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
            if(capcount_thread_6 == 0){//sysj\LidLoaderPlant.sysj line: 91, column: 8
              empty.setPresent();//sysj\LidLoaderPlant.sysj line: 92, column: 6
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

  public void thread7790(int [] tdone, int [] ends){
        switch(S7032){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S6986){
          case 0 : 
            if(empty.getprestatus()){//sysj\LidLoaderPlant.sysj line: 66, column: 10
              S6986=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              switch(S6968){
                case 0 : 
                  if(pusherRetracted.getprestatus()){//sysj\LidLoaderPlant.sysj line: 68, column: 13
                    S6968=1;
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
                  if(pusherExtended.getprestatus()){//sysj\LidLoaderPlant.sysj line: 69, column: 13
                    capPos_1.setPresent();//sysj\LidLoaderPlant.sysj line: 71, column: 7
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(1);//sysj\LidLoaderPlant.sysj line: 71, column: 7
                    S6968=2;
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
                  if(pusherRetracted.getprestatus()){//sysj\LidLoaderPlant.sysj line: 72, column: 13
                    capDec_1.setPresent();//sysj\LidLoaderPlant.sysj line: 73, column: 7
                    currsigs.addElement(capDec_1);
                    S6968=0;
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
            if(refill.getprestatus()){//sysj\LidLoaderPlant.sysj line: 76, column: 10
              S6986=0;
              S6968=0;
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

  public void thread7789(int [] tdone, int [] ends){
        switch(S6964){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S6934){
          case 0 : 
            switch(S6929){
              case 0 : 
                if(!vacOn.getprestatus()){//sysj\LidLoaderPlant.sysj line: 46, column: 12
                  S6929=1;
                  if(armAtSource.getprestatus()){//sysj\LidLoaderPlant.sysj line: 49, column: 14
                    capPos_1.setPresent();//sysj\LidLoaderPlant.sysj line: 50, column: 7
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(1);//sysj\LidLoaderPlant.sysj line: 50, column: 7
                    S6934=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S6934=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  WPgripped.setPresent();//sysj\LidLoaderPlant.sysj line: 47, column: 7
                  currsigs.addElement(WPgripped);
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
              case 1 : 
                S6934=0;
                if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\LidLoaderPlant.sysj line: 43, column: 12
                  if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\LidLoaderPlant.sysj line: 44, column: 8
                    capPos_1.setPresent();//sysj\LidLoaderPlant.sysj line: 45, column: 6
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(0);//sysj\LidLoaderPlant.sysj line: 45, column: 6
                    S6929=0;
                    WPgripped.setPresent();//sysj\LidLoaderPlant.sysj line: 47, column: 7
                    currsigs.addElement(WPgripped);
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S6934=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  S6934=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
            }
            break;
          
          case 1 : 
            S6934=1;
            S6934=0;
            if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\LidLoaderPlant.sysj line: 43, column: 12
              if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\LidLoaderPlant.sysj line: 44, column: 8
                capPos_1.setPresent();//sysj\LidLoaderPlant.sysj line: 45, column: 6
                currsigs.addElement(capPos_1);
                capPos_1.setValue(0);//sysj\LidLoaderPlant.sysj line: 45, column: 6
                S6929=0;
                WPgripped.setPresent();//sysj\LidLoaderPlant.sysj line: 47, column: 7
                currsigs.addElement(WPgripped);
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S6934=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              S6934=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread7788(int [] tdone, int [] ends){
        switch(S6920){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S6892){
          case 0 : 
            if(pusherExtend.getprestatus()){//sysj\LidLoaderPlant.sysj line: 32, column: 10
              S6892=1;
              pusherExtended.setPresent();//sysj\LidLoaderPlant.sysj line: 36, column: 5
              currsigs.addElement(pusherExtended);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              pusherRetracted.setPresent();//sysj\LidLoaderPlant.sysj line: 33, column: 5
              currsigs.addElement(pusherRetracted);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 1 : 
            if(!pusherExtend.getprestatus()){//sysj\LidLoaderPlant.sysj line: 35, column: 10
              S6892=0;
              pusherRetracted.setPresent();//sysj\LidLoaderPlant.sysj line: 33, column: 5
              currsigs.addElement(pusherRetracted);
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
          
        }
        break;
      
    }
  }

  public void thread7787(int [] tdone, int [] ends){
        switch(S6879){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S6851){
          case 0 : 
            if(armSource.getprestatus()){//sysj\LidLoaderPlant.sysj line: 21, column: 10
              S6851=1;
              armAtSource.setPresent();//sysj\LidLoaderPlant.sysj line: 25, column: 5
              currsigs.addElement(armAtSource);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              armAtDest.setPresent();//sysj\LidLoaderPlant.sysj line: 22, column: 5
              currsigs.addElement(armAtDest);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 1 : 
            if(armDest.getprestatus()){//sysj\LidLoaderPlant.sysj line: 24, column: 10
              S6851=0;
              armAtDest.setPresent();//sysj\LidLoaderPlant.sysj line: 22, column: 5
              currsigs.addElement(armAtDest);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              armAtSource.setPresent();//sysj\LidLoaderPlant.sysj line: 25, column: 5
              currsigs.addElement(armAtSource);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread7784(int [] tdone, int [] ends){
        S7142=1;
    if(empty.getprestatus()){//sysj\LidLoaderPlant.sysj line: 109, column: 24
      emptyE.setPresent();//sysj\LidLoaderPlant.sysj line: 109, column: 31
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

  public void thread7783(int [] tdone, int [] ends){
        S7134=1;
    if(armAtDest.getprestatus()){//sysj\LidLoaderPlant.sysj line: 107, column: 24
      armAtDestE.setPresent();//sysj\LidLoaderPlant.sysj line: 107, column: 35
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

  public void thread7782(int [] tdone, int [] ends){
        S7126=1;
    if(armAtSource.getprestatus()){//sysj\LidLoaderPlant.sysj line: 105, column: 24
      armAtSourceE.setPresent();//sysj\LidLoaderPlant.sysj line: 105, column: 37
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

  public void thread7781(int [] tdone, int [] ends){
        S7118=1;
    if(WPgripped.getprestatus()){//sysj\LidLoaderPlant.sysj line: 103, column: 24
      WPgrippedE.setPresent();//sysj\LidLoaderPlant.sysj line: 103, column: 35
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

  public void thread7780(int [] tdone, int [] ends){
        S7110=1;
    if(pusherExtended.getprestatus()){//sysj\LidLoaderPlant.sysj line: 101, column: 24
      pusherExtendedE.setPresent();//sysj\LidLoaderPlant.sysj line: 101, column: 40
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

  public void thread7779(int [] tdone, int [] ends){
        S7102=1;
    if(pusherRetracted.getprestatus()){//sysj\LidLoaderPlant.sysj line: 99, column: 24
      pusherRetractedE.setPresent();//sysj\LidLoaderPlant.sysj line: 99, column: 41
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

  public void thread7778(int [] tdone, int [] ends){
        S7144=1;
    thread7779(tdone,ends);
    thread7780(tdone,ends);
    thread7781(tdone,ends);
    thread7782(tdone,ends);
    thread7783(tdone,ends);
    thread7784(tdone,ends);
    int biggest7785 = 0;
    if(ends[8]>=biggest7785){
      biggest7785=ends[8];
    }
    if(ends[9]>=biggest7785){
      biggest7785=ends[9];
    }
    if(ends[10]>=biggest7785){
      biggest7785=ends[10];
    }
    if(ends[11]>=biggest7785){
      biggest7785=ends[11];
    }
    if(ends[12]>=biggest7785){
      biggest7785=ends[12];
    }
    if(ends[13]>=biggest7785){
      biggest7785=ends[13];
    }
    if(biggest7785 == 1){
      active[7]=1;
      ends[7]=1;
      tdone[7]=1;
    }
  }

  public void thread7777(int [] tdone, int [] ends){
        S7094=1;
    capcount_thread_6 = 5;//sysj\LidLoaderPlant.sysj line: 81, column: 3
    if(capDec_1.getprestatus()){//sysj\LidLoaderPlant.sysj line: 83, column: 12
      if(capcount_thread_6 > 0) {//sysj\LidLoaderPlant.sysj line: 84, column: 5
        capcount_thread_6 = capcount_thread_6 - 1;//sysj\LidLoaderPlant.sysj line: 85, column: 6
      }
      if(refill.getprestatus()){//sysj\LidLoaderPlant.sysj line: 87, column: 12
        capcount_thread_6 = 5;//sysj\LidLoaderPlant.sysj line: 88, column: 5
        if(capcount_thread_6 == 0){//sysj\LidLoaderPlant.sysj line: 91, column: 8
          empty.setPresent();//sysj\LidLoaderPlant.sysj line: 92, column: 6
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
        if(capcount_thread_6 == 0){//sysj\LidLoaderPlant.sysj line: 91, column: 8
          empty.setPresent();//sysj\LidLoaderPlant.sysj line: 92, column: 6
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
      if(refill.getprestatus()){//sysj\LidLoaderPlant.sysj line: 87, column: 12
        capcount_thread_6 = 5;//sysj\LidLoaderPlant.sysj line: 88, column: 5
        if(capcount_thread_6 == 0){//sysj\LidLoaderPlant.sysj line: 91, column: 8
          empty.setPresent();//sysj\LidLoaderPlant.sysj line: 92, column: 6
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
        if(capcount_thread_6 == 0){//sysj\LidLoaderPlant.sysj line: 91, column: 8
          empty.setPresent();//sysj\LidLoaderPlant.sysj line: 92, column: 6
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

  public void thread7776(int [] tdone, int [] ends){
        S7032=1;
    S6986=0;
    S6968=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread7775(int [] tdone, int [] ends){
        S6964=1;
    S6934=0;
    if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\LidLoaderPlant.sysj line: 43, column: 12
      if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\LidLoaderPlant.sysj line: 44, column: 8
        capPos_1.setPresent();//sysj\LidLoaderPlant.sysj line: 45, column: 6
        currsigs.addElement(capPos_1);
        capPos_1.setValue(0);//sysj\LidLoaderPlant.sysj line: 45, column: 6
        S6929=0;
        WPgripped.setPresent();//sysj\LidLoaderPlant.sysj line: 47, column: 7
        currsigs.addElement(WPgripped);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        S6934=1;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
    }
    else {
      S6934=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread7774(int [] tdone, int [] ends){
        S6920=1;
    S6892=0;
    pusherRetracted.setPresent();//sysj\LidLoaderPlant.sysj line: 33, column: 5
    currsigs.addElement(pusherRetracted);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread7773(int [] tdone, int [] ends){
        S6879=1;
    S6851=0;
    armAtDest.setPresent();//sysj\LidLoaderPlant.sysj line: 22, column: 5
    currsigs.addElement(armAtDest);
    active[2]=1;
    ends[2]=1;
    tdone[2]=1;
  }

  public void thread7770(int [] tdone, int [] ends){
        S7142=1;
    if(empty.getprestatus()){//sysj\LidLoaderPlant.sysj line: 109, column: 24
      emptyE.setPresent();//sysj\LidLoaderPlant.sysj line: 109, column: 31
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

  public void thread7769(int [] tdone, int [] ends){
        S7134=1;
    if(armAtDest.getprestatus()){//sysj\LidLoaderPlant.sysj line: 107, column: 24
      armAtDestE.setPresent();//sysj\LidLoaderPlant.sysj line: 107, column: 35
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

  public void thread7768(int [] tdone, int [] ends){
        S7126=1;
    if(armAtSource.getprestatus()){//sysj\LidLoaderPlant.sysj line: 105, column: 24
      armAtSourceE.setPresent();//sysj\LidLoaderPlant.sysj line: 105, column: 37
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

  public void thread7767(int [] tdone, int [] ends){
        S7118=1;
    if(WPgripped.getprestatus()){//sysj\LidLoaderPlant.sysj line: 103, column: 24
      WPgrippedE.setPresent();//sysj\LidLoaderPlant.sysj line: 103, column: 35
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

  public void thread7766(int [] tdone, int [] ends){
        S7110=1;
    if(pusherExtended.getprestatus()){//sysj\LidLoaderPlant.sysj line: 101, column: 24
      pusherExtendedE.setPresent();//sysj\LidLoaderPlant.sysj line: 101, column: 40
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

  public void thread7765(int [] tdone, int [] ends){
        S7102=1;
    if(pusherRetracted.getprestatus()){//sysj\LidLoaderPlant.sysj line: 99, column: 24
      pusherRetractedE.setPresent();//sysj\LidLoaderPlant.sysj line: 99, column: 41
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

  public void thread7764(int [] tdone, int [] ends){
        S7144=1;
    thread7765(tdone,ends);
    thread7766(tdone,ends);
    thread7767(tdone,ends);
    thread7768(tdone,ends);
    thread7769(tdone,ends);
    thread7770(tdone,ends);
    int biggest7771 = 0;
    if(ends[8]>=biggest7771){
      biggest7771=ends[8];
    }
    if(ends[9]>=biggest7771){
      biggest7771=ends[9];
    }
    if(ends[10]>=biggest7771){
      biggest7771=ends[10];
    }
    if(ends[11]>=biggest7771){
      biggest7771=ends[11];
    }
    if(ends[12]>=biggest7771){
      biggest7771=ends[12];
    }
    if(ends[13]>=biggest7771){
      biggest7771=ends[13];
    }
    if(biggest7771 == 1){
      active[7]=1;
      ends[7]=1;
      tdone[7]=1;
    }
  }

  public void thread7763(int [] tdone, int [] ends){
        S7094=1;
    capcount_thread_6 = 5;//sysj\LidLoaderPlant.sysj line: 81, column: 3
    if(capDec_1.getprestatus()){//sysj\LidLoaderPlant.sysj line: 83, column: 12
      if(capcount_thread_6 > 0) {//sysj\LidLoaderPlant.sysj line: 84, column: 5
        capcount_thread_6 = capcount_thread_6 - 1;//sysj\LidLoaderPlant.sysj line: 85, column: 6
      }
      if(refill.getprestatus()){//sysj\LidLoaderPlant.sysj line: 87, column: 12
        capcount_thread_6 = 5;//sysj\LidLoaderPlant.sysj line: 88, column: 5
        if(capcount_thread_6 == 0){//sysj\LidLoaderPlant.sysj line: 91, column: 8
          empty.setPresent();//sysj\LidLoaderPlant.sysj line: 92, column: 6
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
        if(capcount_thread_6 == 0){//sysj\LidLoaderPlant.sysj line: 91, column: 8
          empty.setPresent();//sysj\LidLoaderPlant.sysj line: 92, column: 6
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
      if(refill.getprestatus()){//sysj\LidLoaderPlant.sysj line: 87, column: 12
        capcount_thread_6 = 5;//sysj\LidLoaderPlant.sysj line: 88, column: 5
        if(capcount_thread_6 == 0){//sysj\LidLoaderPlant.sysj line: 91, column: 8
          empty.setPresent();//sysj\LidLoaderPlant.sysj line: 92, column: 6
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
        if(capcount_thread_6 == 0){//sysj\LidLoaderPlant.sysj line: 91, column: 8
          empty.setPresent();//sysj\LidLoaderPlant.sysj line: 92, column: 6
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

  public void thread7762(int [] tdone, int [] ends){
        S7032=1;
    S6986=0;
    S6968=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread7761(int [] tdone, int [] ends){
        S6964=1;
    S6934=0;
    if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\LidLoaderPlant.sysj line: 43, column: 12
      if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\LidLoaderPlant.sysj line: 44, column: 8
        capPos_1.setPresent();//sysj\LidLoaderPlant.sysj line: 45, column: 6
        currsigs.addElement(capPos_1);
        capPos_1.setValue(0);//sysj\LidLoaderPlant.sysj line: 45, column: 6
        S6929=0;
        WPgripped.setPresent();//sysj\LidLoaderPlant.sysj line: 47, column: 7
        currsigs.addElement(WPgripped);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        S6934=1;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
    }
    else {
      S6934=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread7760(int [] tdone, int [] ends){
        S6920=1;
    S6892=0;
    pusherRetracted.setPresent();//sysj\LidLoaderPlant.sysj line: 33, column: 5
    currsigs.addElement(pusherRetracted);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread7759(int [] tdone, int [] ends){
        S6879=1;
    S6851=0;
    armAtDest.setPresent();//sysj\LidLoaderPlant.sysj line: 22, column: 5
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
      switch(S7757){
        case 0 : 
          S7757=0;
          break RUN;
        
        case 1 : 
          S7757=2;
          S7757=2;
          capDec_1.setClear();//sysj\LidLoaderPlant.sysj line: 13, column: 2
          capPos_1.setClear();//sysj\LidLoaderPlant.sysj line: 14, column: 2
          capPos_1.setPresent();//sysj\LidLoaderPlant.sysj line: 15, column: 2
          currsigs.addElement(capPos_1);
          capPos_1.setValue(0);//sysj\LidLoaderPlant.sysj line: 15, column: 2
          S6838=0;
          if(start.getprestatus()){//sysj\LidLoaderPlant.sysj line: 17, column: 19
            S6838=1;
            thread7759(tdone,ends);
            thread7760(tdone,ends);
            thread7761(tdone,ends);
            thread7762(tdone,ends);
            thread7763(tdone,ends);
            thread7764(tdone,ends);
            int biggest7772 = 0;
            if(ends[2]>=biggest7772){
              biggest7772=ends[2];
            }
            if(ends[3]>=biggest7772){
              biggest7772=ends[3];
            }
            if(ends[4]>=biggest7772){
              biggest7772=ends[4];
            }
            if(ends[5]>=biggest7772){
              biggest7772=ends[5];
            }
            if(ends[6]>=biggest7772){
              biggest7772=ends[6];
            }
            if(ends[7]>=biggest7772){
              biggest7772=ends[7];
            }
            if(biggest7772 == 1){
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
          capDec_1.setClear();//sysj\LidLoaderPlant.sysj line: 13, column: 2
          capPos_1.setClear();//sysj\LidLoaderPlant.sysj line: 14, column: 2
          switch(S6838){
            case 0 : 
              if(start.getprestatus()){//sysj\LidLoaderPlant.sysj line: 17, column: 19
                S6838=1;
                thread7773(tdone,ends);
                thread7774(tdone,ends);
                thread7775(tdone,ends);
                thread7776(tdone,ends);
                thread7777(tdone,ends);
                thread7778(tdone,ends);
                int biggest7786 = 0;
                if(ends[2]>=biggest7786){
                  biggest7786=ends[2];
                }
                if(ends[3]>=biggest7786){
                  biggest7786=ends[3];
                }
                if(ends[4]>=biggest7786){
                  biggest7786=ends[4];
                }
                if(ends[5]>=biggest7786){
                  biggest7786=ends[5];
                }
                if(ends[6]>=biggest7786){
                  biggest7786=ends[6];
                }
                if(ends[7]>=biggest7786){
                  biggest7786=ends[7];
                }
                if(biggest7786 == 1){
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
              thread7787(tdone,ends);
              thread7788(tdone,ends);
              thread7789(tdone,ends);
              thread7790(tdone,ends);
              thread7791(tdone,ends);
              thread7792(tdone,ends);
              int biggest7800 = 0;
              if(ends[2]>=biggest7800){
                biggest7800=ends[2];
              }
              if(ends[3]>=biggest7800){
                biggest7800=ends[3];
              }
              if(ends[4]>=biggest7800){
                biggest7800=ends[4];
              }
              if(ends[5]>=biggest7800){
                biggest7800=ends[5];
              }
              if(ends[6]>=biggest7800){
                biggest7800=ends[6];
              }
              if(ends[7]>=biggest7800){
                biggest7800=ends[7];
              }
              if(biggest7800 == 1){
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              //FINXME code
              if(biggest7800 == 0){
                S7757=0;
                active[1]=0;
                ends[1]=0;
                S7757=0;
                break RUN;
              }
            
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
          refill.gethook();
          start.gethook();
          df = true;
        }
        runClockDomain();
      }
      pusherExtend.setpreclear();
      vacOn.setpreclear();
      armSource.setpreclear();
      armDest.setpreclear();
      refill.setpreclear();
      start.setpreclear();
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
      dummyint = refill.getStatus() ? refill.setprepresent() : refill.setpreclear();
      refill.setpreval(refill.getValue());
      refill.setClear();
      dummyint = start.getStatus() ? start.setprepresent() : start.setpreclear();
      start.setpreval(start.getValue());
      start.setClear();
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
        refill.gethook();
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
