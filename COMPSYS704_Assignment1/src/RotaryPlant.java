import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.GUI;//sysj\RotaryPlant.sysj line: 1, column: 1

public class RotaryPlant extends ClockDomain{
  public RotaryPlant(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal rotaryTableTrigger = new Signal("rotaryTableTrigger", Signal.INPUT);
  public Signal rotated = new Signal("rotated", Signal.INPUT);
  public Signal start_r = new Signal("start_r", Signal.INPUT);
  public Signal wsActiveRP = new Signal("wsActiveRP", Signal.INPUT);
  public Signal bottleTotalRP = new Signal("bottleTotalRP", Signal.INPUT);
  public Signal BatchQuantityRP = new Signal("BatchQuantityRP", Signal.INPUT);
  public Signal tableAlignedWithSensor = new Signal("tableAlignedWithSensor", Signal.OUTPUT);
  public Signal rotation = new Signal("rotation", Signal.OUTPUT);
  public Signal bottleAtPos2 = new Signal("bottleAtPos2", Signal.OUTPUT);
  public Signal bottleAtPos3 = new Signal("bottleAtPos3", Signal.OUTPUT);
  public Signal bottleAtPos4 = new Signal("bottleAtPos4", Signal.OUTPUT);
  public Signal bottleAtPos5 = new Signal("bottleAtPos5", Signal.OUTPUT);
  private int S16636 = 1;
  private int S12156 = 1;
  private int S13598 = 1;
  private int S12227 = 1;
  private int S13620 = 1;
  private int S13649 = 1;
  private int S13629 = 1;
  
  private int[] ends = new int[5];
  private int[] tdone = new int[5];
  
  public void thread16648(int [] tdone, int [] ends){
        switch(S13649){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S13629){
          case 0 : 
            if(rotaryTableTrigger.getprestatus()){//sysj\RotaryPlant.sysj line: 103, column: 21
              S13629=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              tableAlignedWithSensor.setPresent();//sysj\RotaryPlant.sysj line: 105, column: 6
              currsigs.addElement(tableAlignedWithSensor);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 1 : 
            S13629=1;
            S13629=0;
            if(rotaryTableTrigger.getprestatus()){//sysj\RotaryPlant.sysj line: 103, column: 21
              S13629=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              System.out.println("emitting aligned sensor");//sysj\RotaryPlant.sysj line: 104, column: 6
              tableAlignedWithSensor.setPresent();//sysj\RotaryPlant.sysj line: 105, column: 6
              currsigs.addElement(tableAlignedWithSensor);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread16647(int [] tdone, int [] ends){
        switch(S13620){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        if(rotated.getprestatus()){//sysj\RotaryPlant.sysj line: 90, column: 13
          rotation.setPresent();//sysj\RotaryPlant.sysj line: 91, column: 6
          currsigs.addElement(rotation);
          System.out.println("recieved rotation");//sysj\RotaryPlant.sysj line: 92, column: 6
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
  }

  public void thread16646(int [] tdone, int [] ends){
        switch(S13598){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S12227){
          case 0 : 
            if(rotaryTableTrigger.getprestatus()){//sysj\RotaryPlant.sysj line: 18, column: 23
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              if((Integer)(bottleTotalRP.getpreval() == null ? null : ((Integer)bottleTotalRP.getpreval())) < (Integer)(BatchQuantityRP.getpreval() == null ? null : ((Integer)BatchQuantityRP.getpreval()))){//sysj\RotaryPlant.sysj line: 22, column: 11
                if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 2){//sysj\RotaryPlant.sysj line: 23, column: 11
                  bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 24, column: 9
                  currsigs.addElement(bottleAtPos2);
                  System.out.println("emitted botteAtPos2");//sysj\RotaryPlant.sysj line: 25, column: 9
                  System.out.println("awaiting disable");//sysj\RotaryPlant.sysj line: 81, column: 5
                  if(rotaryTableTrigger.getprestatus()){//sysj\RotaryPlant.sysj line: 18, column: 23
                    S12227=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S12227=0;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
                else {
                  if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 3){//sysj\RotaryPlant.sysj line: 27, column: 16
                    bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 28, column: 9
                    currsigs.addElement(bottleAtPos2);
                    bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 29, column: 9
                    currsigs.addElement(bottleAtPos3);
                    System.out.println("emitted botteAtPos3");//sysj\RotaryPlant.sysj line: 30, column: 9
                    System.out.println("awaiting disable");//sysj\RotaryPlant.sysj line: 81, column: 5
                    if(rotaryTableTrigger.getprestatus()){//sysj\RotaryPlant.sysj line: 18, column: 23
                      S12227=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S12227=0;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                  }
                  else {
                    if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 4){//sysj\RotaryPlant.sysj line: 32, column: 16
                      bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 33, column: 9
                      currsigs.addElement(bottleAtPos2);
                      bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 34, column: 9
                      currsigs.addElement(bottleAtPos3);
                      bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 35, column: 9
                      currsigs.addElement(bottleAtPos4);
                      System.out.println("emitted botteAtPos4");//sysj\RotaryPlant.sysj line: 36, column: 9
                      System.out.println("awaiting disable");//sysj\RotaryPlant.sysj line: 81, column: 5
                      if(rotaryTableTrigger.getprestatus()){//sysj\RotaryPlant.sysj line: 18, column: 23
                        S12227=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S12227=0;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                    else {
                      if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 5){//sysj\RotaryPlant.sysj line: 38, column: 16
                        bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 39, column: 9
                        currsigs.addElement(bottleAtPos2);
                        bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 40, column: 9
                        currsigs.addElement(bottleAtPos3);
                        bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 41, column: 9
                        currsigs.addElement(bottleAtPos4);
                        bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 42, column: 9
                        currsigs.addElement(bottleAtPos5);
                        System.out.println("emitted botteAtPos5");//sysj\RotaryPlant.sysj line: 43, column: 9
                        System.out.println("awaiting disable");//sysj\RotaryPlant.sysj line: 81, column: 5
                        if(rotaryTableTrigger.getprestatus()){//sysj\RotaryPlant.sysj line: 18, column: 23
                          S12227=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S12227=0;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                      }
                      else {
                        System.out.println("print error");//sysj\RotaryPlant.sysj line: 46, column: 9
                        System.out.println("awaiting disable");//sysj\RotaryPlant.sysj line: 81, column: 5
                        if(rotaryTableTrigger.getprestatus()){//sysj\RotaryPlant.sysj line: 18, column: 23
                          S12227=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S12227=0;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                      }
                    }
                  }
                }
              }
              else {
                if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 4){//sysj\RotaryPlant.sysj line: 52, column: 11
                  bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 53, column: 9
                  currsigs.addElement(bottleAtPos2);
                  bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 54, column: 9
                  currsigs.addElement(bottleAtPos3);
                  bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 55, column: 9
                  currsigs.addElement(bottleAtPos4);
                  bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 56, column: 9
                  currsigs.addElement(bottleAtPos5);
                  System.out.println("awaiting disable");//sysj\RotaryPlant.sysj line: 81, column: 5
                  if(rotaryTableTrigger.getprestatus()){//sysj\RotaryPlant.sysj line: 18, column: 23
                    S12227=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S12227=0;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
                else {
                  if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 3){//sysj\RotaryPlant.sysj line: 58, column: 16
                    bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 59, column: 9
                    currsigs.addElement(bottleAtPos3);
                    bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 60, column: 9
                    currsigs.addElement(bottleAtPos4);
                    bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 61, column: 9
                    currsigs.addElement(bottleAtPos5);
                    System.out.println("stopped emitting botteAtPos2");//sysj\RotaryPlant.sysj line: 62, column: 9
                    System.out.println("awaiting disable");//sysj\RotaryPlant.sysj line: 81, column: 5
                    if(rotaryTableTrigger.getprestatus()){//sysj\RotaryPlant.sysj line: 18, column: 23
                      S12227=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S12227=0;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                  }
                  else {
                    if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 2){//sysj\RotaryPlant.sysj line: 64, column: 16
                      bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 65, column: 9
                      currsigs.addElement(bottleAtPos4);
                      bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 66, column: 9
                      currsigs.addElement(bottleAtPos5);
                      System.out.println("stopped emitting botteAtPos3");//sysj\RotaryPlant.sysj line: 67, column: 9
                      System.out.println("awaiting disable");//sysj\RotaryPlant.sysj line: 81, column: 5
                      if(rotaryTableTrigger.getprestatus()){//sysj\RotaryPlant.sysj line: 18, column: 23
                        S12227=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S12227=0;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                    else {
                      if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 1){//sysj\RotaryPlant.sysj line: 70, column: 16
                        bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 71, column: 9
                        currsigs.addElement(bottleAtPos5);
                        System.out.println("stopped emitting botteAtPos4");//sysj\RotaryPlant.sysj line: 72, column: 9
                        System.out.println("awaiting disable");//sysj\RotaryPlant.sysj line: 81, column: 5
                        if(rotaryTableTrigger.getprestatus()){//sysj\RotaryPlant.sysj line: 18, column: 23
                          S12227=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S12227=0;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                      }
                      else {
                        System.out.println("error 2");//sysj\RotaryPlant.sysj line: 76, column: 9
                        System.out.println("awaiting disable");//sysj\RotaryPlant.sysj line: 81, column: 5
                        if(rotaryTableTrigger.getprestatus()){//sysj\RotaryPlant.sysj line: 18, column: 23
                          S12227=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S12227=0;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                      }
                    }
                  }
                }
              }
            }
            break;
          
          case 1 : 
            if(rotaryTableTrigger.getprestatus()){//sysj\RotaryPlant.sysj line: 18, column: 23
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              S12227=0;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread16644(int [] tdone, int [] ends){
        S13649=1;
    S13629=0;
    if(rotaryTableTrigger.getprestatus()){//sysj\RotaryPlant.sysj line: 103, column: 21
      S13629=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
    else {
      System.out.println("emitting aligned sensor");//sysj\RotaryPlant.sysj line: 104, column: 6
      tableAlignedWithSensor.setPresent();//sysj\RotaryPlant.sysj line: 105, column: 6
      currsigs.addElement(tableAlignedWithSensor);
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread16643(int [] tdone, int [] ends){
        S13620=1;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread16642(int [] tdone, int [] ends){
        S13598=1;
    if(rotaryTableTrigger.getprestatus()){//sysj\RotaryPlant.sysj line: 18, column: 23
      S12227=1;
      active[2]=1;
      ends[2]=1;
      tdone[2]=1;
    }
    else {
      S12227=0;
      active[2]=1;
      ends[2]=1;
      tdone[2]=1;
    }
  }

  public void thread16640(int [] tdone, int [] ends){
        S13649=1;
    S13629=0;
    if(rotaryTableTrigger.getprestatus()){//sysj\RotaryPlant.sysj line: 103, column: 21
      S13629=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
    else {
      System.out.println("emitting aligned sensor");//sysj\RotaryPlant.sysj line: 104, column: 6
      tableAlignedWithSensor.setPresent();//sysj\RotaryPlant.sysj line: 105, column: 6
      currsigs.addElement(tableAlignedWithSensor);
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread16639(int [] tdone, int [] ends){
        S13620=1;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread16638(int [] tdone, int [] ends){
        S13598=1;
    if(rotaryTableTrigger.getprestatus()){//sysj\RotaryPlant.sysj line: 18, column: 23
      S12227=1;
      active[2]=1;
      ends[2]=1;
      tdone[2]=1;
    }
    else {
      S12227=0;
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
      switch(S16636){
        case 0 : 
          S16636=0;
          break RUN;
        
        case 1 : 
          S16636=2;
          S16636=2;
          System.out.println("awaiting start");//sysj\RotaryPlant.sysj line: 10, column: 3
          S12156=0;
          if(start_r.getprestatus()){//sysj\RotaryPlant.sysj line: 11, column: 19
            System.out.println("received start");//sysj\RotaryPlant.sysj line: 12, column: 3
            S12156=1;
            thread16638(tdone,ends);
            thread16639(tdone,ends);
            thread16640(tdone,ends);
            int biggest16641 = 0;
            if(ends[2]>=biggest16641){
              biggest16641=ends[2];
            }
            if(ends[3]>=biggest16641){
              biggest16641=ends[3];
            }
            if(ends[4]>=biggest16641){
              biggest16641=ends[4];
            }
            if(biggest16641 == 1){
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
          switch(S12156){
            case 0 : 
              if(start_r.getprestatus()){//sysj\RotaryPlant.sysj line: 11, column: 19
                System.out.println("received start");//sysj\RotaryPlant.sysj line: 12, column: 3
                S12156=1;
                thread16642(tdone,ends);
                thread16643(tdone,ends);
                thread16644(tdone,ends);
                int biggest16645 = 0;
                if(ends[2]>=biggest16645){
                  biggest16645=ends[2];
                }
                if(ends[3]>=biggest16645){
                  biggest16645=ends[3];
                }
                if(ends[4]>=biggest16645){
                  biggest16645=ends[4];
                }
                if(biggest16645 == 1){
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
              thread16646(tdone,ends);
              thread16647(tdone,ends);
              thread16648(tdone,ends);
              int biggest16649 = 0;
              if(ends[2]>=biggest16649){
                biggest16649=ends[2];
              }
              if(ends[3]>=biggest16649){
                biggest16649=ends[3];
              }
              if(ends[4]>=biggest16649){
                biggest16649=ends[4];
              }
              if(biggest16649 == 1){
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              //FINXME code
              if(biggest16649 == 0){
                S16636=0;
                active[1]=0;
                ends[1]=0;
                S16636=0;
                break RUN;
              }
            
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0};
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
          rotaryTableTrigger.gethook();
          rotated.gethook();
          start_r.gethook();
          wsActiveRP.gethook();
          bottleTotalRP.gethook();
          BatchQuantityRP.gethook();
          df = true;
        }
        runClockDomain();
      }
      rotaryTableTrigger.setpreclear();
      rotated.setpreclear();
      start_r.setpreclear();
      wsActiveRP.setpreclear();
      bottleTotalRP.setpreclear();
      BatchQuantityRP.setpreclear();
      tableAlignedWithSensor.setpreclear();
      rotation.setpreclear();
      bottleAtPos2.setpreclear();
      bottleAtPos3.setpreclear();
      bottleAtPos4.setpreclear();
      bottleAtPos5.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = rotaryTableTrigger.getStatus() ? rotaryTableTrigger.setprepresent() : rotaryTableTrigger.setpreclear();
      rotaryTableTrigger.setpreval(rotaryTableTrigger.getValue());
      rotaryTableTrigger.setClear();
      dummyint = rotated.getStatus() ? rotated.setprepresent() : rotated.setpreclear();
      rotated.setpreval(rotated.getValue());
      rotated.setClear();
      dummyint = start_r.getStatus() ? start_r.setprepresent() : start_r.setpreclear();
      start_r.setpreval(start_r.getValue());
      start_r.setClear();
      dummyint = wsActiveRP.getStatus() ? wsActiveRP.setprepresent() : wsActiveRP.setpreclear();
      wsActiveRP.setpreval(wsActiveRP.getValue());
      wsActiveRP.setClear();
      dummyint = bottleTotalRP.getStatus() ? bottleTotalRP.setprepresent() : bottleTotalRP.setpreclear();
      bottleTotalRP.setpreval(bottleTotalRP.getValue());
      bottleTotalRP.setClear();
      dummyint = BatchQuantityRP.getStatus() ? BatchQuantityRP.setprepresent() : BatchQuantityRP.setpreclear();
      BatchQuantityRP.setpreval(BatchQuantityRP.getValue());
      BatchQuantityRP.setClear();
      tableAlignedWithSensor.sethook();
      tableAlignedWithSensor.setClear();
      rotation.sethook();
      rotation.setClear();
      bottleAtPos2.sethook();
      bottleAtPos2.setClear();
      bottleAtPos3.sethook();
      bottleAtPos3.setClear();
      bottleAtPos4.sethook();
      bottleAtPos4.setClear();
      bottleAtPos5.sethook();
      bottleAtPos5.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        rotaryTableTrigger.gethook();
        rotated.gethook();
        start_r.gethook();
        wsActiveRP.gethook();
        bottleTotalRP.gethook();
        BatchQuantityRP.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
