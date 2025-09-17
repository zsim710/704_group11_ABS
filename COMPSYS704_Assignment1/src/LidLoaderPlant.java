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
  public Signal enable = new Signal("enable", Signal.INPUT);
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
  private int S6141 = 1;
  private int S4868 = 1;
  private int S4822 = 1;
  private int S4921 = 1;
  private int S4875 = 1;
  private int S4965 = 1;
  private int S4935 = 1;
  private int S4930 = 1;
  private int S5033 = 1;
  private int S4987 = 1;
  private int S4969 = 1;
  private int S5095 = 1;
  private int S5145 = 1;
  private int S5103 = 1;
  private int S5111 = 1;
  private int S5119 = 1;
  private int S5127 = 1;
  private int S5135 = 1;
  private int S5143 = 1;
  
  private int[] ends = new int[14];
  private int[] tdone = new int[14];
  
  public void thread6168(int [] tdone, int [] ends){
        switch(S5143){
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

  public void thread6167(int [] tdone, int [] ends){
        switch(S5135){
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

  public void thread6166(int [] tdone, int [] ends){
        switch(S5127){
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

  public void thread6165(int [] tdone, int [] ends){
        switch(S5119){
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

  public void thread6164(int [] tdone, int [] ends){
        switch(S5111){
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

  public void thread6163(int [] tdone, int [] ends){
        switch(S5103){
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

  public void thread6162(int [] tdone, int [] ends){
        switch(S5145){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        thread6163(tdone,ends);
        thread6164(tdone,ends);
        thread6165(tdone,ends);
        thread6166(tdone,ends);
        thread6167(tdone,ends);
        thread6168(tdone,ends);
        int biggest6169 = 0;
        if(ends[8]>=biggest6169){
          biggest6169=ends[8];
        }
        if(ends[9]>=biggest6169){
          biggest6169=ends[9];
        }
        if(ends[10]>=biggest6169){
          biggest6169=ends[10];
        }
        if(ends[11]>=biggest6169){
          biggest6169=ends[11];
        }
        if(ends[12]>=biggest6169){
          biggest6169=ends[12];
        }
        if(ends[13]>=biggest6169){
          biggest6169=ends[13];
        }
        if(biggest6169 == 1){
          active[7]=1;
          ends[7]=1;
          tdone[7]=1;
        }
        //FINXME code
        if(biggest6169 == 0){
          S5145=0;
          active[7]=0;
          ends[7]=0;
          tdone[7]=1;
        }
        break;
      
    }
  }

  public void thread6161(int [] tdone, int [] ends){
        switch(S5095){
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

  public void thread6160(int [] tdone, int [] ends){
        switch(S5033){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S4987){
          case 0 : 
            if(empty.getprestatus()){//sysj\LidLoaderPlant.sysj line: 67, column: 10
              S4987=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              switch(S4969){
                case 0 : 
                  if(pusherRetracted.getprestatus()){//sysj\LidLoaderPlant.sysj line: 69, column: 13
                    S4969=1;
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
                    S4969=2;
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
                    S4969=0;
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
              S4987=0;
              S4969=0;
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

  public void thread6159(int [] tdone, int [] ends){
        switch(S4965){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S4935){
          case 0 : 
            switch(S4930){
              case 0 : 
                if(!vacOn.getprestatus()){//sysj\LidLoaderPlant.sysj line: 47, column: 12
                  S4930=1;
                  if(armAtSource.getprestatus()){//sysj\LidLoaderPlant.sysj line: 50, column: 14
                    capPos_1.setPresent();//sysj\LidLoaderPlant.sysj line: 51, column: 7
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(1);//sysj\LidLoaderPlant.sysj line: 51, column: 7
                    S4935=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S4935=1;
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
                S4935=0;
                if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\LidLoaderPlant.sysj line: 44, column: 12
                  if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\LidLoaderPlant.sysj line: 45, column: 8
                    capPos_1.setPresent();//sysj\LidLoaderPlant.sysj line: 46, column: 6
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(0);//sysj\LidLoaderPlant.sysj line: 46, column: 6
                    S4930=0;
                    WPgripped.setPresent();//sysj\LidLoaderPlant.sysj line: 48, column: 7
                    currsigs.addElement(WPgripped);
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S4935=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  S4935=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
            }
            break;
          
          case 1 : 
            S4935=1;
            S4935=0;
            if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\LidLoaderPlant.sysj line: 44, column: 12
              if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\LidLoaderPlant.sysj line: 45, column: 8
                capPos_1.setPresent();//sysj\LidLoaderPlant.sysj line: 46, column: 6
                currsigs.addElement(capPos_1);
                capPos_1.setValue(0);//sysj\LidLoaderPlant.sysj line: 46, column: 6
                S4930=0;
                WPgripped.setPresent();//sysj\LidLoaderPlant.sysj line: 48, column: 7
                currsigs.addElement(WPgripped);
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S4935=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              S4935=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread6158(int [] tdone, int [] ends){
        switch(S4921){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S4875){
          case 0 : 
            if(pusherExtend.getprestatus() && enable.getprestatus()){//sysj\LidLoaderPlant.sysj line: 31, column: 10
              S4875=1;
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
            if(!enable.getprestatus()){//sysj\LidLoaderPlant.sysj line: 34, column: 10
              S4875=2;
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
            if(!pusherExtend.getprestatus() && enable.getprestatus()){//sysj\LidLoaderPlant.sysj line: 35, column: 10
              S4875=3;
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
            if(!enable.getprestatus()){//sysj\LidLoaderPlant.sysj line: 38, column: 10
              S4875=0;
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

  public void thread6157(int [] tdone, int [] ends){
        switch(S4868){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S4822){
          case 0 : 
            if(armSource.getprestatus() && enable.getprestatus()){//sysj\LidLoaderPlant.sysj line: 18, column: 10
              S4822=1;
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
            if(!enable.getprestatus()){//sysj\LidLoaderPlant.sysj line: 21, column: 10
              S4822=2;
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
            if(armDest.getprestatus() && enable.getprestatus()){//sysj\LidLoaderPlant.sysj line: 22, column: 10
              S4822=3;
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
            if(!enable.getprestatus()){//sysj\LidLoaderPlant.sysj line: 25, column: 10
              S4822=0;
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

  public void thread6154(int [] tdone, int [] ends){
        S5143=1;
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

  public void thread6153(int [] tdone, int [] ends){
        S5135=1;
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

  public void thread6152(int [] tdone, int [] ends){
        S5127=1;
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

  public void thread6151(int [] tdone, int [] ends){
        S5119=1;
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

  public void thread6150(int [] tdone, int [] ends){
        S5111=1;
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

  public void thread6149(int [] tdone, int [] ends){
        S5103=1;
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

  public void thread6148(int [] tdone, int [] ends){
        S5145=1;
    thread6149(tdone,ends);
    thread6150(tdone,ends);
    thread6151(tdone,ends);
    thread6152(tdone,ends);
    thread6153(tdone,ends);
    thread6154(tdone,ends);
    int biggest6155 = 0;
    if(ends[8]>=biggest6155){
      biggest6155=ends[8];
    }
    if(ends[9]>=biggest6155){
      biggest6155=ends[9];
    }
    if(ends[10]>=biggest6155){
      biggest6155=ends[10];
    }
    if(ends[11]>=biggest6155){
      biggest6155=ends[11];
    }
    if(ends[12]>=biggest6155){
      biggest6155=ends[12];
    }
    if(ends[13]>=biggest6155){
      biggest6155=ends[13];
    }
    if(biggest6155 == 1){
      active[7]=1;
      ends[7]=1;
      tdone[7]=1;
    }
  }

  public void thread6147(int [] tdone, int [] ends){
        S5095=1;
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

  public void thread6146(int [] tdone, int [] ends){
        S5033=1;
    S4987=0;
    S4969=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread6145(int [] tdone, int [] ends){
        S4965=1;
    S4935=0;
    if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\LidLoaderPlant.sysj line: 44, column: 12
      if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\LidLoaderPlant.sysj line: 45, column: 8
        capPos_1.setPresent();//sysj\LidLoaderPlant.sysj line: 46, column: 6
        currsigs.addElement(capPos_1);
        capPos_1.setValue(0);//sysj\LidLoaderPlant.sysj line: 46, column: 6
        S4930=0;
        WPgripped.setPresent();//sysj\LidLoaderPlant.sysj line: 48, column: 7
        currsigs.addElement(WPgripped);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        S4935=1;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
    }
    else {
      S4935=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread6144(int [] tdone, int [] ends){
        S4921=1;
    S4875=0;
    pusherRetracted.setPresent();//sysj\LidLoaderPlant.sysj line: 32, column: 5
    currsigs.addElement(pusherRetracted);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread6143(int [] tdone, int [] ends){
        S4868=1;
    S4822=0;
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
      switch(S6141){
        case 0 : 
          S6141=0;
          break RUN;
        
        case 1 : 
          S6141=2;
          S6141=2;
          new Thread(new GUI()).start();//sysj\LidLoaderPlant.sysj line: 11, column: 2
          capDec_1.setClear();//sysj\LidLoaderPlant.sysj line: 13, column: 2
          capPos_1.setClear();//sysj\LidLoaderPlant.sysj line: 14, column: 2
          capPos_1.setPresent();//sysj\LidLoaderPlant.sysj line: 15, column: 2
          currsigs.addElement(capPos_1);
          capPos_1.setValue(0);//sysj\LidLoaderPlant.sysj line: 15, column: 2
          thread6143(tdone,ends);
          thread6144(tdone,ends);
          thread6145(tdone,ends);
          thread6146(tdone,ends);
          thread6147(tdone,ends);
          thread6148(tdone,ends);
          int biggest6156 = 0;
          if(ends[2]>=biggest6156){
            biggest6156=ends[2];
          }
          if(ends[3]>=biggest6156){
            biggest6156=ends[3];
          }
          if(ends[4]>=biggest6156){
            biggest6156=ends[4];
          }
          if(ends[5]>=biggest6156){
            biggest6156=ends[5];
          }
          if(ends[6]>=biggest6156){
            biggest6156=ends[6];
          }
          if(ends[7]>=biggest6156){
            biggest6156=ends[7];
          }
          if(biggest6156 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          capDec_1.setClear();//sysj\LidLoaderPlant.sysj line: 13, column: 2
          capPos_1.setClear();//sysj\LidLoaderPlant.sysj line: 14, column: 2
          thread6157(tdone,ends);
          thread6158(tdone,ends);
          thread6159(tdone,ends);
          thread6160(tdone,ends);
          thread6161(tdone,ends);
          thread6162(tdone,ends);
          int biggest6170 = 0;
          if(ends[2]>=biggest6170){
            biggest6170=ends[2];
          }
          if(ends[3]>=biggest6170){
            biggest6170=ends[3];
          }
          if(ends[4]>=biggest6170){
            biggest6170=ends[4];
          }
          if(ends[5]>=biggest6170){
            biggest6170=ends[5];
          }
          if(ends[6]>=biggest6170){
            biggest6170=ends[6];
          }
          if(ends[7]>=biggest6170){
            biggest6170=ends[7];
          }
          if(biggest6170 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest6170 == 0){
            S6141=0;
            active[1]=0;
            ends[1]=0;
            S6141=0;
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
          enable.gethook();
          refill.gethook();
          df = true;
        }
        runClockDomain();
      }
      pusherExtend.setpreclear();
      vacOn.setpreclear();
      armSource.setpreclear();
      armDest.setpreclear();
      enable.setpreclear();
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
      dummyint = enable.getStatus() ? enable.setprepresent() : enable.setpreclear();
      enable.setpreval(enable.getValue());
      enable.setClear();
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
        enable.gethook();
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
