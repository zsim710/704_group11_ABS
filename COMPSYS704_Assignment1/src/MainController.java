import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.GUI;//sysj\simpleabro.sysj line: 1, column: 1

public class MainController extends ClockDomain{
  public MainController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal BottleQuantity = new Signal("BottleQuantity", Signal.INPUT);
  public Signal LiquidAmount1 = new Signal("LiquidAmount1", Signal.INPUT);
  public Signal LiquidAmount2 = new Signal("LiquidAmount2", Signal.INPUT);
  public Signal workPieceID = new Signal("workPieceID", Signal.INPUT);
  public Signal pos1 = new Signal("pos1", Signal.OUTPUT);
  public Signal pos2 = new Signal("pos2", Signal.OUTPUT);
  public Signal pos3 = new Signal("pos3", Signal.OUTPUT);
  public Signal pos4 = new Signal("pos4", Signal.OUTPUT);
  public Signal pos5 = new Signal("pos5", Signal.OUTPUT);
  private Signal totalBot_1;
  private long __start_thread_1;//sysj\simpleabro.sysj line: 20, column: 16
  private int S13641 = 1;
  private int S2360 = 1;
  private int S1838 = 1;
  private int S1825 = 1;
  
  private int[] ends = new int[2];
  private int[] tdone = new int[2];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S13641){
        case 0 : 
          S13641=0;
          break RUN;
        
        case 1 : 
          S13641=2;
          S13641=2;
          totalBot_1.setClear();//sysj\simpleabro.sysj line: 11, column: 2
          new Thread(new GUI()).start();//sysj\simpleabro.sysj line: 12, column: 2
          S2360=0;
          active[1]=1;
          ends[1]=1;
          break RUN;
        
        case 2 : 
          totalBot_1.setClear();//sysj\simpleabro.sysj line: 11, column: 2
          switch(S2360){
            case 0 : 
              S2360=0;
              S2360=1;
              if((Integer)(BottleQuantity.getpreval() == null ? null : ((Integer)BottleQuantity.getpreval())) == (Integer)(totalBot_1.getpreval() == null ? 0 : ((Integer)totalBot_1.getpreval()).intValue())){//sysj\simpleabro.sysj line: 17, column: 14
                ends[1]=2;
                ;//sysj\simpleabro.sysj line: 13, column: 3
                S13641=0;
                active[1]=0;
                ends[1]=0;
                S13641=0;
                break RUN;
              }
              else {
                S1838=0;
                __start_thread_1 = com.systemj.Timer.getMs();//sysj\simpleabro.sysj line: 20, column: 16
                S1825=0;
                if(com.systemj.Timer.getMs() - __start_thread_1 >= (5) * 1000){//sysj\simpleabro.sysj line: 20, column: 16
                  ends[1]=6;
                  ;//sysj\simpleabro.sysj line: 20, column: 16
                  pos1.setPresent();//sysj\simpleabro.sysj line: 22, column: 14
                  currsigs.addElement(pos1);
                  totalBot_1.setPresent();//sysj\simpleabro.sysj line: 23, column: 14
                  currsigs.addElement(totalBot_1);
                  totalBot_1.setValue((Integer)(totalBot_1.getpreval() == null ? 0 : ((Integer)totalBot_1.getpreval()).intValue()) + 1);//sysj\simpleabro.sysj line: 23, column: 14
                  S1838=1;
                  __start_thread_1 = com.systemj.Timer.getMs();//sysj\simpleabro.sysj line: 20, column: 16
                  if(com.systemj.Timer.getMs() - __start_thread_1 >= (5) * 1000){//sysj\simpleabro.sysj line: 20, column: 16
                    ends[1]=5;
                    ;//sysj\simpleabro.sysj line: 20, column: 16
                    pos2.setPresent();//sysj\simpleabro.sysj line: 26, column: 14
                    currsigs.addElement(pos2);
                    pos1.setPresent();//sysj\simpleabro.sysj line: 27, column: 14
                    currsigs.addElement(pos1);
                    totalBot_1.setPresent();//sysj\simpleabro.sysj line: 28, column: 14
                    currsigs.addElement(totalBot_1);
                    totalBot_1.setValue((Integer)(totalBot_1.getpreval() == null ? 0 : ((Integer)totalBot_1.getpreval()).intValue()) + 1);//sysj\simpleabro.sysj line: 28, column: 14
                    S1838=2;
                    __start_thread_1 = com.systemj.Timer.getMs();//sysj\simpleabro.sysj line: 20, column: 16
                    if(com.systemj.Timer.getMs() - __start_thread_1 >= (5) * 1000){//sysj\simpleabro.sysj line: 20, column: 16
                      ends[1]=4;
                      ;//sysj\simpleabro.sysj line: 20, column: 16
                      pos2.setPresent();//sysj\simpleabro.sysj line: 30, column: 14
                      currsigs.addElement(pos2);
                      pos1.setPresent();//sysj\simpleabro.sysj line: 31, column: 14
                      currsigs.addElement(pos1);
                      pos3.setPresent();//sysj\simpleabro.sysj line: 32, column: 14
                      currsigs.addElement(pos3);
                      totalBot_1.setPresent();//sysj\simpleabro.sysj line: 33, column: 14
                      currsigs.addElement(totalBot_1);
                      totalBot_1.setValue((Integer)(totalBot_1.getpreval() == null ? 0 : ((Integer)totalBot_1.getpreval()).intValue()) + 1);//sysj\simpleabro.sysj line: 33, column: 14
                      S1838=3;
                      __start_thread_1 = com.systemj.Timer.getMs();//sysj\simpleabro.sysj line: 20, column: 16
                      if(com.systemj.Timer.getMs() - __start_thread_1 >= (5) * 1000){//sysj\simpleabro.sysj line: 20, column: 16
                        ends[1]=3;
                        ;//sysj\simpleabro.sysj line: 20, column: 16
                        pos4.setPresent();//sysj\simpleabro.sysj line: 35, column: 14
                        currsigs.addElement(pos4);
                        pos2.setPresent();//sysj\simpleabro.sysj line: 36, column: 14
                        currsigs.addElement(pos2);
                        pos1.setPresent();//sysj\simpleabro.sysj line: 37, column: 14
                        currsigs.addElement(pos1);
                        pos3.setPresent();//sysj\simpleabro.sysj line: 38, column: 14
                        currsigs.addElement(pos3);
                        totalBot_1.setPresent();//sysj\simpleabro.sysj line: 39, column: 14
                        currsigs.addElement(totalBot_1);
                        totalBot_1.setValue((Integer)(totalBot_1.getpreval() == null ? 0 : ((Integer)totalBot_1.getpreval()).intValue()) + 1);//sysj\simpleabro.sysj line: 39, column: 14
                        S2360=0;
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
                    else {
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
                }
                else {
                  S1825=1;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
            
            case 1 : 
              switch(S1838){
                case 0 : 
                  switch(S1825){
                    case 0 : 
                      S1825=0;
                      if(com.systemj.Timer.getMs() - __start_thread_1 >= (5) * 1000){//sysj\simpleabro.sysj line: 20, column: 16
                        ends[1]=6;
                        ;//sysj\simpleabro.sysj line: 20, column: 16
                        pos1.setPresent();//sysj\simpleabro.sysj line: 22, column: 14
                        currsigs.addElement(pos1);
                        totalBot_1.setPresent();//sysj\simpleabro.sysj line: 23, column: 14
                        currsigs.addElement(totalBot_1);
                        totalBot_1.setValue((Integer)(totalBot_1.getpreval() == null ? 0 : ((Integer)totalBot_1.getpreval()).intValue()) + 1);//sysj\simpleabro.sysj line: 23, column: 14
                        S1838=1;
                        __start_thread_1 = com.systemj.Timer.getMs();//sysj\simpleabro.sysj line: 20, column: 16
                        if(com.systemj.Timer.getMs() - __start_thread_1 >= (5) * 1000){//sysj\simpleabro.sysj line: 20, column: 16
                          ends[1]=5;
                          ;//sysj\simpleabro.sysj line: 20, column: 16
                          pos2.setPresent();//sysj\simpleabro.sysj line: 26, column: 14
                          currsigs.addElement(pos2);
                          pos1.setPresent();//sysj\simpleabro.sysj line: 27, column: 14
                          currsigs.addElement(pos1);
                          totalBot_1.setPresent();//sysj\simpleabro.sysj line: 28, column: 14
                          currsigs.addElement(totalBot_1);
                          totalBot_1.setValue((Integer)(totalBot_1.getpreval() == null ? 0 : ((Integer)totalBot_1.getpreval()).intValue()) + 1);//sysj\simpleabro.sysj line: 28, column: 14
                          S1838=2;
                          __start_thread_1 = com.systemj.Timer.getMs();//sysj\simpleabro.sysj line: 20, column: 16
                          if(com.systemj.Timer.getMs() - __start_thread_1 >= (5) * 1000){//sysj\simpleabro.sysj line: 20, column: 16
                            ends[1]=4;
                            ;//sysj\simpleabro.sysj line: 20, column: 16
                            pos2.setPresent();//sysj\simpleabro.sysj line: 30, column: 14
                            currsigs.addElement(pos2);
                            pos1.setPresent();//sysj\simpleabro.sysj line: 31, column: 14
                            currsigs.addElement(pos1);
                            pos3.setPresent();//sysj\simpleabro.sysj line: 32, column: 14
                            currsigs.addElement(pos3);
                            totalBot_1.setPresent();//sysj\simpleabro.sysj line: 33, column: 14
                            currsigs.addElement(totalBot_1);
                            totalBot_1.setValue((Integer)(totalBot_1.getpreval() == null ? 0 : ((Integer)totalBot_1.getpreval()).intValue()) + 1);//sysj\simpleabro.sysj line: 33, column: 14
                            S1838=3;
                            __start_thread_1 = com.systemj.Timer.getMs();//sysj\simpleabro.sysj line: 20, column: 16
                            if(com.systemj.Timer.getMs() - __start_thread_1 >= (5) * 1000){//sysj\simpleabro.sysj line: 20, column: 16
                              ends[1]=3;
                              ;//sysj\simpleabro.sysj line: 20, column: 16
                              pos4.setPresent();//sysj\simpleabro.sysj line: 35, column: 14
                              currsigs.addElement(pos4);
                              pos2.setPresent();//sysj\simpleabro.sysj line: 36, column: 14
                              currsigs.addElement(pos2);
                              pos1.setPresent();//sysj\simpleabro.sysj line: 37, column: 14
                              currsigs.addElement(pos1);
                              pos3.setPresent();//sysj\simpleabro.sysj line: 38, column: 14
                              currsigs.addElement(pos3);
                              totalBot_1.setPresent();//sysj\simpleabro.sysj line: 39, column: 14
                              currsigs.addElement(totalBot_1);
                              totalBot_1.setValue((Integer)(totalBot_1.getpreval() == null ? 0 : ((Integer)totalBot_1.getpreval()).intValue()) + 1);//sysj\simpleabro.sysj line: 39, column: 14
                              S2360=0;
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
                          else {
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
                      }
                      else {
                        S1825=1;
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                    
                    case 1 : 
                      S1825=1;
                      S1825=0;
                      if(com.systemj.Timer.getMs() - __start_thread_1 >= (5) * 1000){//sysj\simpleabro.sysj line: 20, column: 16
                        ends[1]=6;
                        ;//sysj\simpleabro.sysj line: 20, column: 16
                        pos1.setPresent();//sysj\simpleabro.sysj line: 22, column: 14
                        currsigs.addElement(pos1);
                        totalBot_1.setPresent();//sysj\simpleabro.sysj line: 23, column: 14
                        currsigs.addElement(totalBot_1);
                        totalBot_1.setValue((Integer)(totalBot_1.getpreval() == null ? 0 : ((Integer)totalBot_1.getpreval()).intValue()) + 1);//sysj\simpleabro.sysj line: 23, column: 14
                        S1838=1;
                        __start_thread_1 = com.systemj.Timer.getMs();//sysj\simpleabro.sysj line: 20, column: 16
                        if(com.systemj.Timer.getMs() - __start_thread_1 >= (5) * 1000){//sysj\simpleabro.sysj line: 20, column: 16
                          ends[1]=5;
                          ;//sysj\simpleabro.sysj line: 20, column: 16
                          pos2.setPresent();//sysj\simpleabro.sysj line: 26, column: 14
                          currsigs.addElement(pos2);
                          pos1.setPresent();//sysj\simpleabro.sysj line: 27, column: 14
                          currsigs.addElement(pos1);
                          totalBot_1.setPresent();//sysj\simpleabro.sysj line: 28, column: 14
                          currsigs.addElement(totalBot_1);
                          totalBot_1.setValue((Integer)(totalBot_1.getpreval() == null ? 0 : ((Integer)totalBot_1.getpreval()).intValue()) + 1);//sysj\simpleabro.sysj line: 28, column: 14
                          S1838=2;
                          __start_thread_1 = com.systemj.Timer.getMs();//sysj\simpleabro.sysj line: 20, column: 16
                          if(com.systemj.Timer.getMs() - __start_thread_1 >= (5) * 1000){//sysj\simpleabro.sysj line: 20, column: 16
                            ends[1]=4;
                            ;//sysj\simpleabro.sysj line: 20, column: 16
                            pos2.setPresent();//sysj\simpleabro.sysj line: 30, column: 14
                            currsigs.addElement(pos2);
                            pos1.setPresent();//sysj\simpleabro.sysj line: 31, column: 14
                            currsigs.addElement(pos1);
                            pos3.setPresent();//sysj\simpleabro.sysj line: 32, column: 14
                            currsigs.addElement(pos3);
                            totalBot_1.setPresent();//sysj\simpleabro.sysj line: 33, column: 14
                            currsigs.addElement(totalBot_1);
                            totalBot_1.setValue((Integer)(totalBot_1.getpreval() == null ? 0 : ((Integer)totalBot_1.getpreval()).intValue()) + 1);//sysj\simpleabro.sysj line: 33, column: 14
                            S1838=3;
                            __start_thread_1 = com.systemj.Timer.getMs();//sysj\simpleabro.sysj line: 20, column: 16
                            if(com.systemj.Timer.getMs() - __start_thread_1 >= (5) * 1000){//sysj\simpleabro.sysj line: 20, column: 16
                              ends[1]=3;
                              ;//sysj\simpleabro.sysj line: 20, column: 16
                              pos4.setPresent();//sysj\simpleabro.sysj line: 35, column: 14
                              currsigs.addElement(pos4);
                              pos2.setPresent();//sysj\simpleabro.sysj line: 36, column: 14
                              currsigs.addElement(pos2);
                              pos1.setPresent();//sysj\simpleabro.sysj line: 37, column: 14
                              currsigs.addElement(pos1);
                              pos3.setPresent();//sysj\simpleabro.sysj line: 38, column: 14
                              currsigs.addElement(pos3);
                              totalBot_1.setPresent();//sysj\simpleabro.sysj line: 39, column: 14
                              currsigs.addElement(totalBot_1);
                              totalBot_1.setValue((Integer)(totalBot_1.getpreval() == null ? 0 : ((Integer)totalBot_1.getpreval()).intValue()) + 1);//sysj\simpleabro.sysj line: 39, column: 14
                              S2360=0;
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
                          else {
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
                      }
                      else {
                        S1825=1;
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                    
                  }
                  break;
                
                case 1 : 
                  if(com.systemj.Timer.getMs() - __start_thread_1 >= (5) * 1000){//sysj\simpleabro.sysj line: 20, column: 16
                    ends[1]=5;
                    ;//sysj\simpleabro.sysj line: 20, column: 16
                    pos2.setPresent();//sysj\simpleabro.sysj line: 26, column: 14
                    currsigs.addElement(pos2);
                    pos1.setPresent();//sysj\simpleabro.sysj line: 27, column: 14
                    currsigs.addElement(pos1);
                    totalBot_1.setPresent();//sysj\simpleabro.sysj line: 28, column: 14
                    currsigs.addElement(totalBot_1);
                    totalBot_1.setValue((Integer)(totalBot_1.getpreval() == null ? 0 : ((Integer)totalBot_1.getpreval()).intValue()) + 1);//sysj\simpleabro.sysj line: 28, column: 14
                    S1838=2;
                    __start_thread_1 = com.systemj.Timer.getMs();//sysj\simpleabro.sysj line: 20, column: 16
                    if(com.systemj.Timer.getMs() - __start_thread_1 >= (5) * 1000){//sysj\simpleabro.sysj line: 20, column: 16
                      ends[1]=4;
                      ;//sysj\simpleabro.sysj line: 20, column: 16
                      pos2.setPresent();//sysj\simpleabro.sysj line: 30, column: 14
                      currsigs.addElement(pos2);
                      pos1.setPresent();//sysj\simpleabro.sysj line: 31, column: 14
                      currsigs.addElement(pos1);
                      pos3.setPresent();//sysj\simpleabro.sysj line: 32, column: 14
                      currsigs.addElement(pos3);
                      totalBot_1.setPresent();//sysj\simpleabro.sysj line: 33, column: 14
                      currsigs.addElement(totalBot_1);
                      totalBot_1.setValue((Integer)(totalBot_1.getpreval() == null ? 0 : ((Integer)totalBot_1.getpreval()).intValue()) + 1);//sysj\simpleabro.sysj line: 33, column: 14
                      S1838=3;
                      __start_thread_1 = com.systemj.Timer.getMs();//sysj\simpleabro.sysj line: 20, column: 16
                      if(com.systemj.Timer.getMs() - __start_thread_1 >= (5) * 1000){//sysj\simpleabro.sysj line: 20, column: 16
                        ends[1]=3;
                        ;//sysj\simpleabro.sysj line: 20, column: 16
                        pos4.setPresent();//sysj\simpleabro.sysj line: 35, column: 14
                        currsigs.addElement(pos4);
                        pos2.setPresent();//sysj\simpleabro.sysj line: 36, column: 14
                        currsigs.addElement(pos2);
                        pos1.setPresent();//sysj\simpleabro.sysj line: 37, column: 14
                        currsigs.addElement(pos1);
                        pos3.setPresent();//sysj\simpleabro.sysj line: 38, column: 14
                        currsigs.addElement(pos3);
                        totalBot_1.setPresent();//sysj\simpleabro.sysj line: 39, column: 14
                        currsigs.addElement(totalBot_1);
                        totalBot_1.setValue((Integer)(totalBot_1.getpreval() == null ? 0 : ((Integer)totalBot_1.getpreval()).intValue()) + 1);//sysj\simpleabro.sysj line: 39, column: 14
                        S2360=0;
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
                    else {
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
                  if(com.systemj.Timer.getMs() - __start_thread_1 >= (5) * 1000){//sysj\simpleabro.sysj line: 20, column: 16
                    ends[1]=4;
                    ;//sysj\simpleabro.sysj line: 20, column: 16
                    pos2.setPresent();//sysj\simpleabro.sysj line: 30, column: 14
                    currsigs.addElement(pos2);
                    pos1.setPresent();//sysj\simpleabro.sysj line: 31, column: 14
                    currsigs.addElement(pos1);
                    pos3.setPresent();//sysj\simpleabro.sysj line: 32, column: 14
                    currsigs.addElement(pos3);
                    totalBot_1.setPresent();//sysj\simpleabro.sysj line: 33, column: 14
                    currsigs.addElement(totalBot_1);
                    totalBot_1.setValue((Integer)(totalBot_1.getpreval() == null ? 0 : ((Integer)totalBot_1.getpreval()).intValue()) + 1);//sysj\simpleabro.sysj line: 33, column: 14
                    S1838=3;
                    __start_thread_1 = com.systemj.Timer.getMs();//sysj\simpleabro.sysj line: 20, column: 16
                    if(com.systemj.Timer.getMs() - __start_thread_1 >= (5) * 1000){//sysj\simpleabro.sysj line: 20, column: 16
                      ends[1]=3;
                      ;//sysj\simpleabro.sysj line: 20, column: 16
                      pos4.setPresent();//sysj\simpleabro.sysj line: 35, column: 14
                      currsigs.addElement(pos4);
                      pos2.setPresent();//sysj\simpleabro.sysj line: 36, column: 14
                      currsigs.addElement(pos2);
                      pos1.setPresent();//sysj\simpleabro.sysj line: 37, column: 14
                      currsigs.addElement(pos1);
                      pos3.setPresent();//sysj\simpleabro.sysj line: 38, column: 14
                      currsigs.addElement(pos3);
                      totalBot_1.setPresent();//sysj\simpleabro.sysj line: 39, column: 14
                      currsigs.addElement(totalBot_1);
                      totalBot_1.setValue((Integer)(totalBot_1.getpreval() == null ? 0 : ((Integer)totalBot_1.getpreval()).intValue()) + 1);//sysj\simpleabro.sysj line: 39, column: 14
                      S2360=0;
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
                  else {
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                
                case 3 : 
                  if(com.systemj.Timer.getMs() - __start_thread_1 >= (5) * 1000){//sysj\simpleabro.sysj line: 20, column: 16
                    ends[1]=3;
                    ;//sysj\simpleabro.sysj line: 20, column: 16
                    pos4.setPresent();//sysj\simpleabro.sysj line: 35, column: 14
                    currsigs.addElement(pos4);
                    pos2.setPresent();//sysj\simpleabro.sysj line: 36, column: 14
                    currsigs.addElement(pos2);
                    pos1.setPresent();//sysj\simpleabro.sysj line: 37, column: 14
                    currsigs.addElement(pos1);
                    pos3.setPresent();//sysj\simpleabro.sysj line: 38, column: 14
                    currsigs.addElement(pos3);
                    totalBot_1.setPresent();//sysj\simpleabro.sysj line: 39, column: 14
                    currsigs.addElement(totalBot_1);
                    totalBot_1.setValue((Integer)(totalBot_1.getpreval() == null ? 0 : ((Integer)totalBot_1.getpreval()).intValue()) + 1);//sysj\simpleabro.sysj line: 39, column: 14
                    S2360=0;
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
    totalBot_1 = new Signal();
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
          BottleQuantity.gethook();
          LiquidAmount1.gethook();
          LiquidAmount2.gethook();
          workPieceID.gethook();
          df = true;
        }
        runClockDomain();
      }
      BottleQuantity.setpreclear();
      LiquidAmount1.setpreclear();
      LiquidAmount2.setpreclear();
      workPieceID.setpreclear();
      pos1.setpreclear();
      pos2.setpreclear();
      pos3.setpreclear();
      pos4.setpreclear();
      pos5.setpreclear();
      totalBot_1.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = BottleQuantity.getStatus() ? BottleQuantity.setprepresent() : BottleQuantity.setpreclear();
      BottleQuantity.setpreval(BottleQuantity.getValue());
      BottleQuantity.setClear();
      dummyint = LiquidAmount1.getStatus() ? LiquidAmount1.setprepresent() : LiquidAmount1.setpreclear();
      LiquidAmount1.setpreval(LiquidAmount1.getValue());
      LiquidAmount1.setClear();
      dummyint = LiquidAmount2.getStatus() ? LiquidAmount2.setprepresent() : LiquidAmount2.setpreclear();
      LiquidAmount2.setpreval(LiquidAmount2.getValue());
      LiquidAmount2.setClear();
      dummyint = workPieceID.getStatus() ? workPieceID.setprepresent() : workPieceID.setpreclear();
      workPieceID.setpreval(workPieceID.getValue());
      workPieceID.setClear();
      pos1.sethook();
      pos1.setClear();
      pos2.sethook();
      pos2.setClear();
      pos3.sethook();
      pos3.setClear();
      pos4.sethook();
      pos4.setClear();
      pos5.sethook();
      pos5.setClear();
      totalBot_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        BottleQuantity.gethook();
        LiquidAmount1.gethook();
        LiquidAmount2.gethook();
        workPieceID.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
