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
  public Signal motConveyorOn = new Signal("motConveyorOn", Signal.OUTPUT);
  private int S2116 = 1;
  private int S1842 = 1;
  private int S1868 = 1;
  private int S1867 = 1;
  
  private int[] ends = new int[2];
  private int[] tdone = new int[2];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S2116){
        case 0 : 
          S2116=0;
          break RUN;
        
        case 1 : 
          S2116=2;
          S2116=2;
          System.out.println("im waiting on loadsignal");//sysj\ConveyorController.sysj line: 11, column: 4
          S1842=0;
          active[1]=1;
          ends[1]=1;
          break RUN;
        
        case 2 : 
          switch(S1842){
            case 0 : 
              if(bottleAtLoad.getprestatus()){//sysj\ConveyorController.sysj line: 12, column: 10
                S1842=1;
                if((Integer)(wsActiveConvC.getpreval() == null ? null : ((Integer)wsActiveConvC.getpreval())) > 4){//sysj\ConveyorController.sysj line: 14, column: 8
                  S1868=0;
                  System.out.println("entered if");//sysj\ConveyorController.sysj line: 16, column: 6
                  motConveyorOn.setPresent();//sysj\ConveyorController.sysj line: 17, column: 6
                  currsigs.addElement(motConveyorOn);
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
                else {
                  S1868=1;
                  if((Integer)(wsActiveConvC.getpreval() == null ? null : ((Integer)wsActiveConvC.getpreval())) < 4 && (Integer)(bottleTotalConvC.getpreval() == null ? null : ((Integer)bottleTotalConvC.getpreval())) == (Integer)(BatchQuantityConvC.getpreval() == null ? null : ((Integer)BatchQuantityConvC.getpreval()))){//sysj\ConveyorController.sysj line: 21, column: 13
                    S1867=0;
                    System.out.println("end of batch");//sysj\ConveyorController.sysj line: 23, column: 5
                    motConveyorOn.setPresent();//sysj\ConveyorController.sysj line: 24, column: 6
                    currsigs.addElement(motConveyorOn);
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  else {
                    S1867=1;
                    System.out.println("we should be here");//sysj\ConveyorController.sysj line: 30, column: 6
                    motConveyorOn.setPresent();//sysj\ConveyorController.sysj line: 31, column: 6
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
              switch(S1868){
                case 0 : 
                  if(bottleAtPos1ConvC.getprestatus() && bottleLeftPos5ConvC.getprestatus()){//sysj\ConveyorController.sysj line: 15, column: 11
                    System.out.println("conveyor not moving");//sysj\ConveyorController.sysj line: 34, column: 4
                    System.out.println("im waiting on loadsignal");//sysj\ConveyorController.sysj line: 11, column: 4
                    S1842=0;
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  else {
                    motConveyorOn.setPresent();//sysj\ConveyorController.sysj line: 17, column: 6
                    currsigs.addElement(motConveyorOn);
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                
                case 1 : 
                  switch(S1867){
                    case 0 : 
                      if(bottleAtPos1ConvC.getprestatus()){//sysj\ConveyorController.sysj line: 22, column: 11
                        System.out.println("conveyor not moving");//sysj\ConveyorController.sysj line: 34, column: 4
                        System.out.println("im waiting on loadsignal");//sysj\ConveyorController.sysj line: 11, column: 4
                        S1842=0;
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                      else {
                        motConveyorOn.setPresent();//sysj\ConveyorController.sysj line: 24, column: 6
                        currsigs.addElement(motConveyorOn);
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                    
                    case 1 : 
                      if(bottleLeftPos5ConvC.getprestatus()){//sysj\ConveyorController.sysj line: 29, column: 11
                        System.out.println("conveyor not moving");//sysj\ConveyorController.sysj line: 34, column: 4
                        System.out.println("im waiting on loadsignal");//sysj\ConveyorController.sysj line: 11, column: 4
                        S1842=0;
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                      else {
                        motConveyorOn.setPresent();//sysj\ConveyorController.sysj line: 31, column: 6
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
      motConveyorOn.setpreclear();
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
      motConveyorOn.sethook();
      motConveyorOn.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        bottleAtLoad.gethook();
        bottleAtPos1ConvC.gethook();
        bottleLeftPos5ConvC.gethook();
        wsActiveConvC.gethook();
        bottleTotalConvC.gethook();
        BatchQuantityConvC.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
