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
  public Signal enableRP = new Signal("enableRP", Signal.INPUT);
  public Signal wsActiveRP = new Signal("wsActiveRP", Signal.INPUT);
  public Signal bottleTotalRP = new Signal("bottleTotalRP", Signal.INPUT);
  public Signal BatchQuantityRP = new Signal("BatchQuantityRP", Signal.INPUT);
  public Signal tableAlignedWithSensor = new Signal("tableAlignedWithSensor", Signal.OUTPUT);
  public Signal rotation = new Signal("rotation", Signal.OUTPUT);
  public Signal bottleAtPos2 = new Signal("bottleAtPos2", Signal.OUTPUT);
  public Signal bottleAtPos3 = new Signal("bottleAtPos3", Signal.OUTPUT);
  public Signal bottleAtPos4 = new Signal("bottleAtPos4", Signal.OUTPUT);
  public Signal bottleAtPos5 = new Signal("bottleAtPos5", Signal.OUTPUT);
  public Signal start = new Signal("start", Signal.OUTPUT);
  private int S8667 = 1;
  private int S8666 = 1;
  private int S8160 = 1;
  private int S7720 = 1;
  private int S7783 = 1;
  private int S8174 = 1;
  private int S8191 = 1;
  private int S8179 = 1;
  
  private int[] ends = new int[5];
  private int[] tdone = new int[5];
  
  public void thread8675(int [] tdone, int [] ends){
        switch(S8191){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S8179){
          case 0 : 
            if(rotaryTableTrigger.getprestatus()){//sysj\RotaryPlant.sysj line: 98, column: 21
              S8179=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              tableAlignedWithSensor.setPresent();//sysj\RotaryPlant.sysj line: 99, column: 6
              currsigs.addElement(tableAlignedWithSensor);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 1 : 
            S8179=1;
            S8179=0;
            if(rotaryTableTrigger.getprestatus()){//sysj\RotaryPlant.sysj line: 98, column: 21
              S8179=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              tableAlignedWithSensor.setPresent();//sysj\RotaryPlant.sysj line: 99, column: 6
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

  public void thread8674(int [] tdone, int [] ends){
        switch(S8174){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        if(rotated.getprestatus()){//sysj\RotaryPlant.sysj line: 85, column: 13
          rotation.setPresent();//sysj\RotaryPlant.sysj line: 86, column: 6
          currsigs.addElement(rotation);
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

  public void thread8673(int [] tdone, int [] ends){
        switch(S8160){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S7720){
          case 0 : 
            if(enableRP.getprestatus()){//sysj\RotaryPlant.sysj line: 17, column: 10
              System.out.println("received enable");//sysj\RotaryPlant.sysj line: 18, column: 4
              start.setPresent();//sysj\RotaryPlant.sysj line: 20, column: 4
              currsigs.addElement(start);
              System.out.println("emitted start");//sysj\RotaryPlant.sysj line: 21, column: 4
              S7720=1;
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
            S7720=1;
            S7720=2;
            if(rotaryTableTrigger.getprestatus()){//sysj\RotaryPlant.sysj line: 24, column: 23
              S7783=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              S7783=0;
              System.out.println("emitted aligned signal");//sysj\RotaryPlant.sysj line: 28, column: 7
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 2 : 
            switch(S7783){
              case 0 : 
                if(rotaryTableTrigger.getprestatus()){//sysj\RotaryPlant.sysj line: 24, column: 23
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  if((Integer)(bottleTotalRP.getpreval() == null ? null : ((Integer)bottleTotalRP.getpreval())) < (Integer)(BatchQuantityRP.getpreval() == null ? null : ((Integer)BatchQuantityRP.getpreval()))){//sysj\RotaryPlant.sysj line: 30, column: 11
                    if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 2){//sysj\RotaryPlant.sysj line: 31, column: 11
                      bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 32, column: 9
                      currsigs.addElement(bottleAtPos2);
                      System.out.println("awaiting disable");//sysj\RotaryPlant.sysj line: 74, column: 5
                      S7720=3;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 3){//sysj\RotaryPlant.sysj line: 34, column: 16
                        bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 35, column: 9
                        currsigs.addElement(bottleAtPos2);
                        bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 36, column: 9
                        currsigs.addElement(bottleAtPos3);
                        System.out.println("awaiting disable");//sysj\RotaryPlant.sysj line: 74, column: 5
                        S7720=3;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 4){//sysj\RotaryPlant.sysj line: 38, column: 16
                          bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 39, column: 9
                          currsigs.addElement(bottleAtPos2);
                          bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 40, column: 9
                          currsigs.addElement(bottleAtPos3);
                          bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 41, column: 9
                          currsigs.addElement(bottleAtPos4);
                          System.out.println("awaiting disable");//sysj\RotaryPlant.sysj line: 74, column: 5
                          S7720=3;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 5){//sysj\RotaryPlant.sysj line: 43, column: 16
                            bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 44, column: 9
                            currsigs.addElement(bottleAtPos2);
                            bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 45, column: 9
                            currsigs.addElement(bottleAtPos3);
                            bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 46, column: 9
                            currsigs.addElement(bottleAtPos4);
                            bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 47, column: 9
                            currsigs.addElement(bottleAtPos5);
                            System.out.println("awaiting disable");//sysj\RotaryPlant.sysj line: 74, column: 5
                            S7720=3;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            System.out.println("awaiting disable");//sysj\RotaryPlant.sysj line: 74, column: 5
                            S7720=3;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                        }
                      }
                    }
                  }
                  else {
                    if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 4){//sysj\RotaryPlant.sysj line: 53, column: 11
                      bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 54, column: 9
                      currsigs.addElement(bottleAtPos2);
                      bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 55, column: 9
                      currsigs.addElement(bottleAtPos3);
                      bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 56, column: 9
                      currsigs.addElement(bottleAtPos4);
                      bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 57, column: 9
                      currsigs.addElement(bottleAtPos5);
                      System.out.println("awaiting disable");//sysj\RotaryPlant.sysj line: 74, column: 5
                      S7720=3;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 3){//sysj\RotaryPlant.sysj line: 59, column: 16
                        bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 60, column: 9
                        currsigs.addElement(bottleAtPos3);
                        bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 61, column: 9
                        currsigs.addElement(bottleAtPos4);
                        bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 62, column: 9
                        currsigs.addElement(bottleAtPos5);
                        System.out.println("awaiting disable");//sysj\RotaryPlant.sysj line: 74, column: 5
                        S7720=3;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 2){//sysj\RotaryPlant.sysj line: 64, column: 16
                          bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 65, column: 9
                          currsigs.addElement(bottleAtPos4);
                          bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 66, column: 9
                          currsigs.addElement(bottleAtPos5);
                          System.out.println("awaiting disable");//sysj\RotaryPlant.sysj line: 74, column: 5
                          S7720=3;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 1){//sysj\RotaryPlant.sysj line: 68, column: 16
                            bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 69, column: 9
                            currsigs.addElement(bottleAtPos5);
                            System.out.println("awaiting disable");//sysj\RotaryPlant.sysj line: 74, column: 5
                            S7720=3;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            System.out.println("awaiting disable");//sysj\RotaryPlant.sysj line: 74, column: 5
                            S7720=3;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                        }
                      }
                    }
                  }
                }
                break;
              
              case 1 : 
                if(rotaryTableTrigger.getprestatus()){//sysj\RotaryPlant.sysj line: 24, column: 23
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S7783=0;
                  System.out.println("emitted aligned signal");//sysj\RotaryPlant.sysj line: 28, column: 7
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                break;
              
            }
            break;
          
          case 3 : 
            if(!enableRP.getprestatus()){//sysj\RotaryPlant.sysj line: 76, column: 11
              System.out.println("awaiting enable");//sysj\RotaryPlant.sysj line: 16, column: 4
              S7720=0;
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

  public void thread8671(int [] tdone, int [] ends){
        S8191=1;
    S8179=0;
    if(rotaryTableTrigger.getprestatus()){//sysj\RotaryPlant.sysj line: 98, column: 21
      S8179=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
    else {
      tableAlignedWithSensor.setPresent();//sysj\RotaryPlant.sysj line: 99, column: 6
      currsigs.addElement(tableAlignedWithSensor);
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread8670(int [] tdone, int [] ends){
        S8174=1;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread8669(int [] tdone, int [] ends){
        S8160=1;
    System.out.println("awaiting enable");//sysj\RotaryPlant.sysj line: 16, column: 4
    S7720=0;
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
      switch(S8667){
        case 0 : 
          S8667=0;
          break RUN;
        
        case 1 : 
          S8667=2;
          S8667=2;
          S8666=0;
          active[1]=1;
          ends[1]=1;
          break RUN;
        
        case 2 : 
          switch(S8666){
            case 0 : 
              S8666=0;
              S8666=1;
              thread8669(tdone,ends);
              thread8670(tdone,ends);
              thread8671(tdone,ends);
              int biggest8672 = 0;
              if(ends[2]>=biggest8672){
                biggest8672=ends[2];
              }
              if(ends[3]>=biggest8672){
                biggest8672=ends[3];
              }
              if(ends[4]>=biggest8672){
                biggest8672=ends[4];
              }
              if(biggest8672 == 1){
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            
            case 1 : 
              thread8673(tdone,ends);
              thread8674(tdone,ends);
              thread8675(tdone,ends);
              int biggest8676 = 0;
              if(ends[2]>=biggest8676){
                biggest8676=ends[2];
              }
              if(ends[3]>=biggest8676){
                biggest8676=ends[3];
              }
              if(ends[4]>=biggest8676){
                biggest8676=ends[4];
              }
              if(biggest8676 == 1){
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              //FINXME code
              if(biggest8676 == 0){
                S8667=0;
                active[1]=0;
                ends[1]=0;
                S8667=0;
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
          enableRP.gethook();
          wsActiveRP.gethook();
          bottleTotalRP.gethook();
          BatchQuantityRP.gethook();
          df = true;
        }
        runClockDomain();
      }
      rotaryTableTrigger.setpreclear();
      rotated.setpreclear();
      enableRP.setpreclear();
      wsActiveRP.setpreclear();
      bottleTotalRP.setpreclear();
      BatchQuantityRP.setpreclear();
      tableAlignedWithSensor.setpreclear();
      rotation.setpreclear();
      bottleAtPos2.setpreclear();
      bottleAtPos3.setpreclear();
      bottleAtPos4.setpreclear();
      bottleAtPos5.setpreclear();
      start.setpreclear();
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
      dummyint = enableRP.getStatus() ? enableRP.setprepresent() : enableRP.setpreclear();
      enableRP.setpreval(enableRP.getValue());
      enableRP.setClear();
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
      start.sethook();
      start.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        rotaryTableTrigger.gethook();
        rotated.gethook();
        enableRP.gethook();
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
