import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class ConveyorController extends ClockDomain{
  public ConveyorController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal bottleAtLoad = new Signal("bottleAtLoad", Signal.INPUT);
  public Signal bottleAtPos1ConvC = new Signal("bottleAtPos1ConvC", Signal.INPUT);
  public Signal bottleLeftPos5ConvC = new Signal("bottleLeftPos5ConvC", Signal.INPUT);
  public Signal wsActiveConvC = new Signal("wsActiveConvC", Signal.INPUT);
  public Signal bottleTotalConvC = new Signal("bottleTotalConvC", Signal.INPUT);
  public Signal BatchQuantityConvC = new Signal("BatchQuantityConvC", Signal.INPUT);
  public Signal start_conveyor = new Signal("start_conveyor", Signal.INPUT);
  public Signal motConveyorOn = new Signal("motConveyorOn", Signal.OUTPUT);
  public Signal start = new Signal("start", Signal.OUTPUT);
  private int S1816 = 1;
  private int S1605 = 1;
  private int S1619 = 1;
  private int S1618 = 1;
  
  private int[] ends = new int[2];
  private int[] tdone = new int[2];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S1816){
        case 0 : 
          S1816=0;
          break RUN;
        
        case 1 : 
          S1816=2;
          S1816=2;
          System.out.println("awaiting start");//sysj\ConveyorController.sysj line: 10, column: 2
          S1605=0;
          if(start_conveyor.getprestatus()){//sysj\ConveyorController.sysj line: 11, column: 18
            System.out.println("received start");//sysj\ConveyorController.sysj line: 12, column: 2
            start.setPresent();//sysj\ConveyorController.sysj line: 13, column: 2
            currsigs.addElement(start);
            S1605=1;
            if((Integer)(wsActiveConvC.getpreval() == null ? null : ((Integer)wsActiveConvC.getpreval())) > 4){//sysj\ConveyorController.sysj line: 20, column: 8
              S1619=0;
              motConveyorOn.setPresent();//sysj\ConveyorController.sysj line: 24, column: 6
              currsigs.addElement(motConveyorOn);
              active[1]=1;
              ends[1]=1;
              break RUN;
            }
            else {
              S1619=1;
              if((Integer)(wsActiveConvC.getpreval() == null ? null : ((Integer)wsActiveConvC.getpreval())) < 4 && (Integer)(bottleTotalConvC.getpreval() == null ? null : ((Integer)bottleTotalConvC.getpreval())) < (Integer)(BatchQuantityConvC.getpreval() == null ? null : ((Integer)BatchQuantityConvC.getpreval()))){//sysj\ConveyorController.sysj line: 28, column: 13
                S1618=0;
                motConveyorOn.setPresent();//sysj\ConveyorController.sysj line: 32, column: 6
                currsigs.addElement(motConveyorOn);
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                S1618=1;
                motConveyorOn.setPresent();//sysj\ConveyorController.sysj line: 40, column: 6
                currsigs.addElement(motConveyorOn);
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            }
          }
          else {
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          switch(S1605){
            case 0 : 
              if(start_conveyor.getprestatus()){//sysj\ConveyorController.sysj line: 11, column: 18
                System.out.println("received start");//sysj\ConveyorController.sysj line: 12, column: 2
                start.setPresent();//sysj\ConveyorController.sysj line: 13, column: 2
                currsigs.addElement(start);
                S1605=1;
                if((Integer)(wsActiveConvC.getpreval() == null ? null : ((Integer)wsActiveConvC.getpreval())) > 4){//sysj\ConveyorController.sysj line: 20, column: 8
                  S1619=0;
                  motConveyorOn.setPresent();//sysj\ConveyorController.sysj line: 24, column: 6
                  currsigs.addElement(motConveyorOn);
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
                else {
                  S1619=1;
                  if((Integer)(wsActiveConvC.getpreval() == null ? null : ((Integer)wsActiveConvC.getpreval())) < 4 && (Integer)(bottleTotalConvC.getpreval() == null ? null : ((Integer)bottleTotalConvC.getpreval())) < (Integer)(BatchQuantityConvC.getpreval() == null ? null : ((Integer)BatchQuantityConvC.getpreval()))){//sysj\ConveyorController.sysj line: 28, column: 13
                    S1618=0;
                    motConveyorOn.setPresent();//sysj\ConveyorController.sysj line: 32, column: 6
                    currsigs.addElement(motConveyorOn);
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  else {
                    S1618=1;
                    motConveyorOn.setPresent();//sysj\ConveyorController.sysj line: 40, column: 6
                    currsigs.addElement(motConveyorOn);
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                }
              }
              else {
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            
            case 1 : 
              switch(S1619){
                case 0 : 
                  if(bottleAtPos1ConvC.getprestatus() && bottleLeftPos5ConvC.getprestatus()){//sysj\ConveyorController.sysj line: 22, column: 11
                    if((Integer)(wsActiveConvC.getpreval() == null ? null : ((Integer)wsActiveConvC.getpreval())) > 4){//sysj\ConveyorController.sysj line: 20, column: 8
                      S1619=0;
                      motConveyorOn.setPresent();//sysj\ConveyorController.sysj line: 24, column: 6
                      currsigs.addElement(motConveyorOn);
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      S1619=1;
                      if((Integer)(wsActiveConvC.getpreval() == null ? null : ((Integer)wsActiveConvC.getpreval())) < 4 && (Integer)(bottleTotalConvC.getpreval() == null ? null : ((Integer)bottleTotalConvC.getpreval())) < (Integer)(BatchQuantityConvC.getpreval() == null ? null : ((Integer)BatchQuantityConvC.getpreval()))){//sysj\ConveyorController.sysj line: 28, column: 13
                        S1618=0;
                        motConveyorOn.setPresent();//sysj\ConveyorController.sysj line: 32, column: 6
                        currsigs.addElement(motConveyorOn);
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                      else {
                        S1618=1;
                        motConveyorOn.setPresent();//sysj\ConveyorController.sysj line: 40, column: 6
                        currsigs.addElement(motConveyorOn);
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                    }
                  }
                  else {
                    motConveyorOn.setPresent();//sysj\ConveyorController.sysj line: 24, column: 6
                    currsigs.addElement(motConveyorOn);
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                
                case 1 : 
                  switch(S1618){
                    case 0 : 
                      if(bottleAtPos1ConvC.getprestatus()){//sysj\ConveyorController.sysj line: 30, column: 11
                        if((Integer)(wsActiveConvC.getpreval() == null ? null : ((Integer)wsActiveConvC.getpreval())) > 4){//sysj\ConveyorController.sysj line: 20, column: 8
                          S1619=0;
                          motConveyorOn.setPresent();//sysj\ConveyorController.sysj line: 24, column: 6
                          currsigs.addElement(motConveyorOn);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          S1619=1;
                          if((Integer)(wsActiveConvC.getpreval() == null ? null : ((Integer)wsActiveConvC.getpreval())) < 4 && (Integer)(bottleTotalConvC.getpreval() == null ? null : ((Integer)bottleTotalConvC.getpreval())) < (Integer)(BatchQuantityConvC.getpreval() == null ? null : ((Integer)BatchQuantityConvC.getpreval()))){//sysj\ConveyorController.sysj line: 28, column: 13
                            S1618=0;
                            motConveyorOn.setPresent();//sysj\ConveyorController.sysj line: 32, column: 6
                            currsigs.addElement(motConveyorOn);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            S1618=1;
                            motConveyorOn.setPresent();//sysj\ConveyorController.sysj line: 40, column: 6
                            currsigs.addElement(motConveyorOn);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        motConveyorOn.setPresent();//sysj\ConveyorController.sysj line: 32, column: 6
                        currsigs.addElement(motConveyorOn);
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                    
                    case 1 : 
                      if(bottleLeftPos5ConvC.getprestatus()){//sysj\ConveyorController.sysj line: 38, column: 11
                        if((Integer)(wsActiveConvC.getpreval() == null ? null : ((Integer)wsActiveConvC.getpreval())) > 4){//sysj\ConveyorController.sysj line: 20, column: 8
                          S1619=0;
                          motConveyorOn.setPresent();//sysj\ConveyorController.sysj line: 24, column: 6
                          currsigs.addElement(motConveyorOn);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          S1619=1;
                          if((Integer)(wsActiveConvC.getpreval() == null ? null : ((Integer)wsActiveConvC.getpreval())) < 4 && (Integer)(bottleTotalConvC.getpreval() == null ? null : ((Integer)bottleTotalConvC.getpreval())) < (Integer)(BatchQuantityConvC.getpreval() == null ? null : ((Integer)BatchQuantityConvC.getpreval()))){//sysj\ConveyorController.sysj line: 28, column: 13
                            S1618=0;
                            motConveyorOn.setPresent();//sysj\ConveyorController.sysj line: 32, column: 6
                            currsigs.addElement(motConveyorOn);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            S1618=1;
                            motConveyorOn.setPresent();//sysj\ConveyorController.sysj line: 40, column: 6
                            currsigs.addElement(motConveyorOn);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        motConveyorOn.setPresent();//sysj\ConveyorController.sysj line: 40, column: 6
                        currsigs.addElement(motConveyorOn);
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                    
                  }
                  break;
                
              }
              break;
            
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1};
    char [] paused1 = {0, 0};
    char [] suspended1 = {0, 0};
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
          bottleAtLoad.gethook();
          bottleAtPos1ConvC.gethook();
          bottleLeftPos5ConvC.gethook();
          wsActiveConvC.gethook();
          bottleTotalConvC.gethook();
          BatchQuantityConvC.gethook();
          start_conveyor.gethook();
          df = true;
        }
        runClockDomain();
      }
      bottleAtLoad.setpreclear();
      bottleAtPos1ConvC.setpreclear();
      bottleLeftPos5ConvC.setpreclear();
      wsActiveConvC.setpreclear();
      bottleTotalConvC.setpreclear();
      BatchQuantityConvC.setpreclear();
      start_conveyor.setpreclear();
      motConveyorOn.setpreclear();
      start.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = bottleAtLoad.getStatus() ? bottleAtLoad.setprepresent() : bottleAtLoad.setpreclear();
      bottleAtLoad.setpreval(bottleAtLoad.getValue());
      bottleAtLoad.setClear();
      dummyint = bottleAtPos1ConvC.getStatus() ? bottleAtPos1ConvC.setprepresent() : bottleAtPos1ConvC.setpreclear();
      bottleAtPos1ConvC.setpreval(bottleAtPos1ConvC.getValue());
      bottleAtPos1ConvC.setClear();
      dummyint = bottleLeftPos5ConvC.getStatus() ? bottleLeftPos5ConvC.setprepresent() : bottleLeftPos5ConvC.setpreclear();
      bottleLeftPos5ConvC.setpreval(bottleLeftPos5ConvC.getValue());
      bottleLeftPos5ConvC.setClear();
      dummyint = wsActiveConvC.getStatus() ? wsActiveConvC.setprepresent() : wsActiveConvC.setpreclear();
      wsActiveConvC.setpreval(wsActiveConvC.getValue());
      wsActiveConvC.setClear();
      dummyint = bottleTotalConvC.getStatus() ? bottleTotalConvC.setprepresent() : bottleTotalConvC.setpreclear();
      bottleTotalConvC.setpreval(bottleTotalConvC.getValue());
      bottleTotalConvC.setClear();
      dummyint = BatchQuantityConvC.getStatus() ? BatchQuantityConvC.setprepresent() : BatchQuantityConvC.setpreclear();
      BatchQuantityConvC.setpreval(BatchQuantityConvC.getValue());
      BatchQuantityConvC.setClear();
      dummyint = start_conveyor.getStatus() ? start_conveyor.setprepresent() : start_conveyor.setpreclear();
      start_conveyor.setpreval(start_conveyor.getValue());
      start_conveyor.setClear();
      motConveyorOn.sethook();
      motConveyorOn.setClear();
      start.sethook();
      start.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        bottleAtLoad.gethook();
        bottleAtPos1ConvC.gethook();
        bottleLeftPos5ConvC.gethook();
        wsActiveConvC.gethook();
        bottleTotalConvC.gethook();
        BatchQuantityConvC.gethook();
        start_conveyor.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
