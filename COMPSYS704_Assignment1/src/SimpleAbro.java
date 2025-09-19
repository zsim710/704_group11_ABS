import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class SimpleAbro extends ClockDomain{
  public SimpleAbro(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal batchQuantity = new Signal("batchQuantity", Signal.INPUT);
  public Signal liquidAmount1 = new Signal("liquidAmount1", Signal.INPUT);
  public Signal liquidAmount2 = new Signal("liquidAmount2", Signal.INPUT);
  public Signal O = new Signal("O", Signal.OUTPUT);
  private long __start_thread_1;//sysj\simpleabro.sysj line: 9, column: 9
  private int S2241 = 1;
  private int S2209 = 1;
  
  private int[] ends = new int[2];
  private int[] tdone = new int[2];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S2241){
        case 0 : 
          S2241=0;
          break RUN;
        
        case 1 : 
          S2241=2;
          S2241=2;
          S2209=0;
          __start_thread_1 = com.systemj.Timer.getMs();//sysj\simpleabro.sysj line: 9, column: 9
          if(com.systemj.Timer.getMs() - __start_thread_1 >= (2) * 1000){//sysj\simpleabro.sysj line: 9, column: 9
            ends[1]=2;
            ;//sysj\simpleabro.sysj line: 9, column: 9
            System.out.println((batchQuantity.getpreval() == null ? 0 : ((Integer)batchQuantity.getpreval()).intValue()));//sysj\simpleabro.sysj line: 11, column: 13
            S2209=1;
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          else {
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          switch(S2209){
            case 0 : 
              if(com.systemj.Timer.getMs() - __start_thread_1 >= (2) * 1000){//sysj\simpleabro.sysj line: 9, column: 9
                ends[1]=2;
                ;//sysj\simpleabro.sysj line: 9, column: 9
                System.out.println((batchQuantity.getpreval() == null ? 0 : ((Integer)batchQuantity.getpreval()).intValue()));//sysj\simpleabro.sysj line: 11, column: 13
                S2209=1;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            
            case 1 : 
              S2209=1;
              S2209=0;
              __start_thread_1 = com.systemj.Timer.getMs();//sysj\simpleabro.sysj line: 9, column: 9
              if(com.systemj.Timer.getMs() - __start_thread_1 >= (2) * 1000){//sysj\simpleabro.sysj line: 9, column: 9
                ends[1]=2;
                ;//sysj\simpleabro.sysj line: 9, column: 9
                System.out.println((batchQuantity.getpreval() == null ? 0 : ((Integer)batchQuantity.getpreval()).intValue()));//sysj\simpleabro.sysj line: 11, column: 13
                S2209=1;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            
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
          batchQuantity.gethook();
          liquidAmount1.gethook();
          liquidAmount2.gethook();
          df = true;
        }
        runClockDomain();
      }
      batchQuantity.setpreclear();
      liquidAmount1.setpreclear();
      liquidAmount2.setpreclear();
      O.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = batchQuantity.getStatus() ? batchQuantity.setprepresent() : batchQuantity.setpreclear();
      batchQuantity.setpreval(batchQuantity.getValue());
      batchQuantity.setClear();
      dummyint = liquidAmount1.getStatus() ? liquidAmount1.setprepresent() : liquidAmount1.setpreclear();
      liquidAmount1.setpreval(liquidAmount1.getValue());
      liquidAmount1.setClear();
      dummyint = liquidAmount2.getStatus() ? liquidAmount2.setprepresent() : liquidAmount2.setpreclear();
      liquidAmount2.setpreval(liquidAmount2.getValue());
      liquidAmount2.setClear();
      O.sethook();
      O.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        batchQuantity.gethook();
        liquidAmount1.gethook();
        liquidAmount2.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
