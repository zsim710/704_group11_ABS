import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.GUI;//sysj\RotaryPlant.sysj line: 1, column: 1

public class RotaryPlantCD extends ClockDomain{
  public RotaryPlantCD(String name){super(name);}
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
  private int S11826 = 1;
  private int S5817 = 1;
  private int S8807 = 1;
  private int S5819 = 1;
  private int S8821 = 1;
  
  private int[] ends = new int[4];
  private int[] tdone = new int[4];
  
  public void thread11832(int [] tdone, int [] ends){
        switch(S8821){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        if(rotated.getprestatus()){//sysj\RotaryPlant.sysj line: 78, column: 13
          rotation.setPresent();//sysj\RotaryPlant.sysj line: 79, column: 6
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

  public void thread11831(int [] tdone, int [] ends){
        switch(S8807){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S5819){
          case 0 : 
            if(enableRP.getprestatus()){//sysj\RotaryPlant.sysj line: 16, column: 10
              start.setPresent();//sysj\RotaryPlant.sysj line: 17, column: 4
              currsigs.addElement(start);
              S5819=1;
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
            S5819=1;
            S5819=2;
            tableAlignedWithSensor.setPresent();//sysj\RotaryPlant.sysj line: 21, column: 6
            currsigs.addElement(tableAlignedWithSensor);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
            break;
          
          case 2 : 
            if(rotaryTableTrigger.getprestatus()){//sysj\RotaryPlant.sysj line: 19, column: 13
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              if((Integer)(bottleTotalRP.getpreval() == null ? null : ((Integer)bottleTotalRP.getpreval())) < (Integer)(BatchQuantityRP.getpreval() == null ? null : ((Integer)BatchQuantityRP.getpreval()))){//sysj\RotaryPlant.sysj line: 25, column: 11
                if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 2){//sysj\RotaryPlant.sysj line: 26, column: 11
                  bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 27, column: 9
                  currsigs.addElement(bottleAtPos2);
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 3){//sysj\RotaryPlant.sysj line: 29, column: 16
                    bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 30, column: 9
                    currsigs.addElement(bottleAtPos2);
                    bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 31, column: 9
                    currsigs.addElement(bottleAtPos3);
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 4){//sysj\RotaryPlant.sysj line: 33, column: 16
                      bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 34, column: 9
                      currsigs.addElement(bottleAtPos2);
                      bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 35, column: 9
                      currsigs.addElement(bottleAtPos3);
                      bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 36, column: 9
                      currsigs.addElement(bottleAtPos4);
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
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
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                  }
                }
              }
              else {
                if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 4){//sysj\RotaryPlant.sysj line: 48, column: 11
                  bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 49, column: 9
                  currsigs.addElement(bottleAtPos2);
                  bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 50, column: 9
                  currsigs.addElement(bottleAtPos3);
                  bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 51, column: 9
                  currsigs.addElement(bottleAtPos4);
                  bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 52, column: 9
                  currsigs.addElement(bottleAtPos5);
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 3){//sysj\RotaryPlant.sysj line: 54, column: 16
                    bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 55, column: 9
                    currsigs.addElement(bottleAtPos3);
                    bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 56, column: 9
                    currsigs.addElement(bottleAtPos4);
                    bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 57, column: 9
                    currsigs.addElement(bottleAtPos5);
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 2){//sysj\RotaryPlant.sysj line: 59, column: 16
                      bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 60, column: 9
                      currsigs.addElement(bottleAtPos4);
                      bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 61, column: 9
                      currsigs.addElement(bottleAtPos5);
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 1){//sysj\RotaryPlant.sysj line: 63, column: 16
                        bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 64, column: 9
                        currsigs.addElement(bottleAtPos5);
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
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
          
        }
        break;
      
    }
  }

  public void thread11829(int [] tdone, int [] ends){
        S8821=1;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread11828(int [] tdone, int [] ends){
        S8807=1;
    S5819=0;
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
      switch(S11826){
        case 0 : 
          S11826=0;
          break RUN;
        
        case 1 : 
          S11826=2;
          S11826=2;
          new Thread(new GUI()).start();//sysj\RotaryPlant.sysj line: 10, column: 3
          S5817=0;
          active[1]=1;
          ends[1]=1;
          break RUN;
        
        case 2 : 
          switch(S5817){
            case 0 : 
              S5817=0;
              S5817=1;
              thread11828(tdone,ends);
              thread11829(tdone,ends);
              int biggest11830 = 0;
              if(ends[2]>=biggest11830){
                biggest11830=ends[2];
              }
              if(ends[3]>=biggest11830){
                biggest11830=ends[3];
              }
              if(biggest11830 == 1){
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            
            case 1 : 
              thread11831(tdone,ends);
              thread11832(tdone,ends);
              int biggest11833 = 0;
              if(ends[2]>=biggest11833){
                biggest11833=ends[2];
              }
              if(ends[3]>=biggest11833){
                biggest11833=ends[3];
              }
              if(biggest11833 == 1){
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              //FINXME code
              if(biggest11833 == 0){
                S11826=0;
                active[1]=0;
                ends[1]=0;
                S11826=0;
                break RUN;
              }
            
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0};
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
