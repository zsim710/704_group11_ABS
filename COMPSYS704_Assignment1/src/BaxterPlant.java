import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.GUI;//sysj\BaxterPlant.sysj line: 1, column: 1

public class BaxterPlant extends ClockDomain{
  public BaxterPlant(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal CMD = new Signal("CMD", Signal.INPUT);
  public Signal failT = new Signal("failT", Signal.INPUT);
  public Signal CMDfb = new Signal("CMDfb", Signal.OUTPUT);
  public Signal bottleAtLoad = new Signal("bottleAtLoad", Signal.OUTPUT);
  public Signal POSA = new Signal("POSA", Signal.OUTPUT);
  public Signal POSB = new Signal("POSB", Signal.OUTPUT);
  public Signal POSC = new Signal("POSC", Signal.OUTPUT);
  public Signal POSD = new Signal("POSD", Signal.OUTPUT);
  public Signal GripDat = new Signal("GripDat", Signal.OUTPUT);
  private String command_thread_1;//sysj\BaxterPlant.sysj line: 23, column: 4
  private java.lang.String []  parts_thread_1;//sysj\BaxterPlant.sysj line: 24, column: 4
  private int S464 = 1;
  private int S157 = 1;
  private int S160 = 1;
  
  private int[] ends = new int[2];
  private int[] tdone = new int[2];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S464){
        case 0 : 
          S464=0;
          break RUN;
        
        case 1 : 
          S464=2;
          S464=2;
          new Thread(new GUI()).start();//sysj\BaxterPlant.sysj line: 11, column: 2
          S157=0;
          active[1]=1;
          ends[1]=1;
          break RUN;
        
        case 2 : 
          switch(S157){
            case 0 : 
              S157=0;
              S157=1;
              bottleAtLoad.setPresent();//sysj\BaxterPlant.sysj line: 16, column: 3
              currsigs.addElement(bottleAtLoad);
              S160=0;
              if(failT.getprestatus()){//sysj\BaxterPlant.sysj line: 18, column: 11
                System.out.println("fail oii poopy");//sysj\BaxterPlant.sysj line: 19, column: 4
                if(CMD.getprestatus()){//sysj\BaxterPlant.sysj line: 22, column: 11
                  command_thread_1 = (String)(CMD.getpreval() == null ? null : ((String)CMD.getpreval()));//sysj\BaxterPlant.sysj line: 23, column: 4
                  parts_thread_1 = command_thread_1.split(" ");//sysj\BaxterPlant.sysj line: 24, column: 4
                  System.out.println(parts_thread_1[2]);//sysj\BaxterPlant.sysj line: 29, column: 4
                  if(parts_thread_1[2].equals("A")){//sysj\BaxterPlant.sysj line: 32, column: 4
                    POSA.setPresent();//sysj\BaxterPlant.sysj line: 33, column: 5
                    currsigs.addElement(POSA);
                    if(parts_thread_1[2].equals("close")){//sysj\BaxterPlant.sysj line: 46, column: 4
                      GripDat.setPresent();//sysj\BaxterPlant.sysj line: 47, column: 5
                      currsigs.addElement(GripDat);
                      CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                      currsigs.addElement(CMDfb);
                      S160=1;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                      currsigs.addElement(CMDfb);
                      S160=1;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  }
                  else {
                    if(parts_thread_1[2].equals("B")){//sysj\BaxterPlant.sysj line: 35, column: 11
                      POSB.setPresent();//sysj\BaxterPlant.sysj line: 36, column: 5
                      currsigs.addElement(POSB);
                      if(parts_thread_1[2].equals("close")){//sysj\BaxterPlant.sysj line: 46, column: 4
                        GripDat.setPresent();//sysj\BaxterPlant.sysj line: 47, column: 5
                        currsigs.addElement(GripDat);
                        CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                        currsigs.addElement(CMDfb);
                        S160=1;
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                      else {
                        CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                        currsigs.addElement(CMDfb);
                        S160=1;
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                    }
                    else {
                      if(parts_thread_1[2].equals("C")){//sysj\BaxterPlant.sysj line: 38, column: 11
                        POSC.setPresent();//sysj\BaxterPlant.sysj line: 39, column: 5
                        currsigs.addElement(POSC);
                        if(parts_thread_1[2].equals("close")){//sysj\BaxterPlant.sysj line: 46, column: 4
                          GripDat.setPresent();//sysj\BaxterPlant.sysj line: 47, column: 5
                          currsigs.addElement(GripDat);
                          CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                          currsigs.addElement(CMDfb);
                          S160=1;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                          currsigs.addElement(CMDfb);
                          S160=1;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(parts_thread_1[2].equals("D")){//sysj\BaxterPlant.sysj line: 41, column: 11
                          POSD.setPresent();//sysj\BaxterPlant.sysj line: 42, column: 5
                          currsigs.addElement(POSD);
                          if(parts_thread_1[2].equals("close")){//sysj\BaxterPlant.sysj line: 46, column: 4
                            GripDat.setPresent();//sysj\BaxterPlant.sysj line: 47, column: 5
                            currsigs.addElement(GripDat);
                            CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                            currsigs.addElement(CMDfb);
                            S160=1;
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                            currsigs.addElement(CMDfb);
                            S160=1;
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(parts_thread_1[2].equals("close")){//sysj\BaxterPlant.sysj line: 46, column: 4
                            GripDat.setPresent();//sysj\BaxterPlant.sysj line: 47, column: 5
                            currsigs.addElement(GripDat);
                            CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                            currsigs.addElement(CMDfb);
                            S160=1;
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                            currsigs.addElement(CMDfb);
                            S160=1;
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                  }
                }
                else {
                  CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                  currsigs.addElement(CMDfb);
                  S160=1;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
              else {
                if(CMD.getprestatus()){//sysj\BaxterPlant.sysj line: 22, column: 11
                  command_thread_1 = (String)(CMD.getpreval() == null ? null : ((String)CMD.getpreval()));//sysj\BaxterPlant.sysj line: 23, column: 4
                  parts_thread_1 = command_thread_1.split(" ");//sysj\BaxterPlant.sysj line: 24, column: 4
                  System.out.println(parts_thread_1[2]);//sysj\BaxterPlant.sysj line: 29, column: 4
                  if(parts_thread_1[2].equals("A")){//sysj\BaxterPlant.sysj line: 32, column: 4
                    POSA.setPresent();//sysj\BaxterPlant.sysj line: 33, column: 5
                    currsigs.addElement(POSA);
                    if(parts_thread_1[2].equals("close")){//sysj\BaxterPlant.sysj line: 46, column: 4
                      GripDat.setPresent();//sysj\BaxterPlant.sysj line: 47, column: 5
                      currsigs.addElement(GripDat);
                      CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                      currsigs.addElement(CMDfb);
                      S160=1;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                      currsigs.addElement(CMDfb);
                      S160=1;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  }
                  else {
                    if(parts_thread_1[2].equals("B")){//sysj\BaxterPlant.sysj line: 35, column: 11
                      POSB.setPresent();//sysj\BaxterPlant.sysj line: 36, column: 5
                      currsigs.addElement(POSB);
                      if(parts_thread_1[2].equals("close")){//sysj\BaxterPlant.sysj line: 46, column: 4
                        GripDat.setPresent();//sysj\BaxterPlant.sysj line: 47, column: 5
                        currsigs.addElement(GripDat);
                        CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                        currsigs.addElement(CMDfb);
                        S160=1;
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                      else {
                        CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                        currsigs.addElement(CMDfb);
                        S160=1;
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                    }
                    else {
                      if(parts_thread_1[2].equals("C")){//sysj\BaxterPlant.sysj line: 38, column: 11
                        POSC.setPresent();//sysj\BaxterPlant.sysj line: 39, column: 5
                        currsigs.addElement(POSC);
                        if(parts_thread_1[2].equals("close")){//sysj\BaxterPlant.sysj line: 46, column: 4
                          GripDat.setPresent();//sysj\BaxterPlant.sysj line: 47, column: 5
                          currsigs.addElement(GripDat);
                          CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                          currsigs.addElement(CMDfb);
                          S160=1;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                          currsigs.addElement(CMDfb);
                          S160=1;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(parts_thread_1[2].equals("D")){//sysj\BaxterPlant.sysj line: 41, column: 11
                          POSD.setPresent();//sysj\BaxterPlant.sysj line: 42, column: 5
                          currsigs.addElement(POSD);
                          if(parts_thread_1[2].equals("close")){//sysj\BaxterPlant.sysj line: 46, column: 4
                            GripDat.setPresent();//sysj\BaxterPlant.sysj line: 47, column: 5
                            currsigs.addElement(GripDat);
                            CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                            currsigs.addElement(CMDfb);
                            S160=1;
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                            currsigs.addElement(CMDfb);
                            S160=1;
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(parts_thread_1[2].equals("close")){//sysj\BaxterPlant.sysj line: 46, column: 4
                            GripDat.setPresent();//sysj\BaxterPlant.sysj line: 47, column: 5
                            currsigs.addElement(GripDat);
                            CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                            currsigs.addElement(CMDfb);
                            S160=1;
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                            currsigs.addElement(CMDfb);
                            S160=1;
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                  }
                }
                else {
                  CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                  currsigs.addElement(CMDfb);
                  S160=1;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
            
            case 1 : 
              switch(S160){
                case 0 : 
                  bottleAtLoad.setPresent();//sysj\BaxterPlant.sysj line: 16, column: 3
                  currsigs.addElement(bottleAtLoad);
                  S160=0;
                  if(failT.getprestatus()){//sysj\BaxterPlant.sysj line: 18, column: 11
                    System.out.println("fail oii poopy");//sysj\BaxterPlant.sysj line: 19, column: 4
                    if(CMD.getprestatus()){//sysj\BaxterPlant.sysj line: 22, column: 11
                      command_thread_1 = (String)(CMD.getpreval() == null ? null : ((String)CMD.getpreval()));//sysj\BaxterPlant.sysj line: 23, column: 4
                      parts_thread_1 = command_thread_1.split(" ");//sysj\BaxterPlant.sysj line: 24, column: 4
                      System.out.println(parts_thread_1[2]);//sysj\BaxterPlant.sysj line: 29, column: 4
                      if(parts_thread_1[2].equals("A")){//sysj\BaxterPlant.sysj line: 32, column: 4
                        POSA.setPresent();//sysj\BaxterPlant.sysj line: 33, column: 5
                        currsigs.addElement(POSA);
                        if(parts_thread_1[2].equals("close")){//sysj\BaxterPlant.sysj line: 46, column: 4
                          GripDat.setPresent();//sysj\BaxterPlant.sysj line: 47, column: 5
                          currsigs.addElement(GripDat);
                          CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                          currsigs.addElement(CMDfb);
                          S160=1;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                          currsigs.addElement(CMDfb);
                          S160=1;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(parts_thread_1[2].equals("B")){//sysj\BaxterPlant.sysj line: 35, column: 11
                          POSB.setPresent();//sysj\BaxterPlant.sysj line: 36, column: 5
                          currsigs.addElement(POSB);
                          if(parts_thread_1[2].equals("close")){//sysj\BaxterPlant.sysj line: 46, column: 4
                            GripDat.setPresent();//sysj\BaxterPlant.sysj line: 47, column: 5
                            currsigs.addElement(GripDat);
                            CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                            currsigs.addElement(CMDfb);
                            S160=1;
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                            currsigs.addElement(CMDfb);
                            S160=1;
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(parts_thread_1[2].equals("C")){//sysj\BaxterPlant.sysj line: 38, column: 11
                            POSC.setPresent();//sysj\BaxterPlant.sysj line: 39, column: 5
                            currsigs.addElement(POSC);
                            if(parts_thread_1[2].equals("close")){//sysj\BaxterPlant.sysj line: 46, column: 4
                              GripDat.setPresent();//sysj\BaxterPlant.sysj line: 47, column: 5
                              currsigs.addElement(GripDat);
                              CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                              currsigs.addElement(CMDfb);
                              S160=1;
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                            else {
                              CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                              currsigs.addElement(CMDfb);
                              S160=1;
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                          }
                          else {
                            if(parts_thread_1[2].equals("D")){//sysj\BaxterPlant.sysj line: 41, column: 11
                              POSD.setPresent();//sysj\BaxterPlant.sysj line: 42, column: 5
                              currsigs.addElement(POSD);
                              if(parts_thread_1[2].equals("close")){//sysj\BaxterPlant.sysj line: 46, column: 4
                                GripDat.setPresent();//sysj\BaxterPlant.sysj line: 47, column: 5
                                currsigs.addElement(GripDat);
                                CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                                currsigs.addElement(CMDfb);
                                S160=1;
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                                currsigs.addElement(CMDfb);
                                S160=1;
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(parts_thread_1[2].equals("close")){//sysj\BaxterPlant.sysj line: 46, column: 4
                                GripDat.setPresent();//sysj\BaxterPlant.sysj line: 47, column: 5
                                currsigs.addElement(GripDat);
                                CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                                currsigs.addElement(CMDfb);
                                S160=1;
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                                currsigs.addElement(CMDfb);
                                S160=1;
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                        }
                      }
                    }
                    else {
                      CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                      currsigs.addElement(CMDfb);
                      S160=1;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  }
                  else {
                    if(CMD.getprestatus()){//sysj\BaxterPlant.sysj line: 22, column: 11
                      command_thread_1 = (String)(CMD.getpreval() == null ? null : ((String)CMD.getpreval()));//sysj\BaxterPlant.sysj line: 23, column: 4
                      parts_thread_1 = command_thread_1.split(" ");//sysj\BaxterPlant.sysj line: 24, column: 4
                      System.out.println(parts_thread_1[2]);//sysj\BaxterPlant.sysj line: 29, column: 4
                      if(parts_thread_1[2].equals("A")){//sysj\BaxterPlant.sysj line: 32, column: 4
                        POSA.setPresent();//sysj\BaxterPlant.sysj line: 33, column: 5
                        currsigs.addElement(POSA);
                        if(parts_thread_1[2].equals("close")){//sysj\BaxterPlant.sysj line: 46, column: 4
                          GripDat.setPresent();//sysj\BaxterPlant.sysj line: 47, column: 5
                          currsigs.addElement(GripDat);
                          CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                          currsigs.addElement(CMDfb);
                          S160=1;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                          currsigs.addElement(CMDfb);
                          S160=1;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(parts_thread_1[2].equals("B")){//sysj\BaxterPlant.sysj line: 35, column: 11
                          POSB.setPresent();//sysj\BaxterPlant.sysj line: 36, column: 5
                          currsigs.addElement(POSB);
                          if(parts_thread_1[2].equals("close")){//sysj\BaxterPlant.sysj line: 46, column: 4
                            GripDat.setPresent();//sysj\BaxterPlant.sysj line: 47, column: 5
                            currsigs.addElement(GripDat);
                            CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                            currsigs.addElement(CMDfb);
                            S160=1;
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                            currsigs.addElement(CMDfb);
                            S160=1;
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(parts_thread_1[2].equals("C")){//sysj\BaxterPlant.sysj line: 38, column: 11
                            POSC.setPresent();//sysj\BaxterPlant.sysj line: 39, column: 5
                            currsigs.addElement(POSC);
                            if(parts_thread_1[2].equals("close")){//sysj\BaxterPlant.sysj line: 46, column: 4
                              GripDat.setPresent();//sysj\BaxterPlant.sysj line: 47, column: 5
                              currsigs.addElement(GripDat);
                              CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                              currsigs.addElement(CMDfb);
                              S160=1;
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                            else {
                              CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                              currsigs.addElement(CMDfb);
                              S160=1;
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                          }
                          else {
                            if(parts_thread_1[2].equals("D")){//sysj\BaxterPlant.sysj line: 41, column: 11
                              POSD.setPresent();//sysj\BaxterPlant.sysj line: 42, column: 5
                              currsigs.addElement(POSD);
                              if(parts_thread_1[2].equals("close")){//sysj\BaxterPlant.sysj line: 46, column: 4
                                GripDat.setPresent();//sysj\BaxterPlant.sysj line: 47, column: 5
                                currsigs.addElement(GripDat);
                                CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                                currsigs.addElement(CMDfb);
                                S160=1;
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                                currsigs.addElement(CMDfb);
                                S160=1;
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(parts_thread_1[2].equals("close")){//sysj\BaxterPlant.sysj line: 46, column: 4
                                GripDat.setPresent();//sysj\BaxterPlant.sysj line: 47, column: 5
                                currsigs.addElement(GripDat);
                                CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                                currsigs.addElement(CMDfb);
                                S160=1;
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                                currsigs.addElement(CMDfb);
                                S160=1;
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                        }
                      }
                    }
                    else {
                      CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                      currsigs.addElement(CMDfb);
                      S160=1;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  }
                
                case 1 : 
                  S160=1;
                  bottleAtLoad.setPresent();//sysj\BaxterPlant.sysj line: 16, column: 3
                  currsigs.addElement(bottleAtLoad);
                  S160=0;
                  if(failT.getprestatus()){//sysj\BaxterPlant.sysj line: 18, column: 11
                    System.out.println("fail oii poopy");//sysj\BaxterPlant.sysj line: 19, column: 4
                    if(CMD.getprestatus()){//sysj\BaxterPlant.sysj line: 22, column: 11
                      command_thread_1 = (String)(CMD.getpreval() == null ? null : ((String)CMD.getpreval()));//sysj\BaxterPlant.sysj line: 23, column: 4
                      parts_thread_1 = command_thread_1.split(" ");//sysj\BaxterPlant.sysj line: 24, column: 4
                      System.out.println(parts_thread_1[2]);//sysj\BaxterPlant.sysj line: 29, column: 4
                      if(parts_thread_1[2].equals("A")){//sysj\BaxterPlant.sysj line: 32, column: 4
                        POSA.setPresent();//sysj\BaxterPlant.sysj line: 33, column: 5
                        currsigs.addElement(POSA);
                        if(parts_thread_1[2].equals("close")){//sysj\BaxterPlant.sysj line: 46, column: 4
                          GripDat.setPresent();//sysj\BaxterPlant.sysj line: 47, column: 5
                          currsigs.addElement(GripDat);
                          CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                          currsigs.addElement(CMDfb);
                          S160=1;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                          currsigs.addElement(CMDfb);
                          S160=1;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(parts_thread_1[2].equals("B")){//sysj\BaxterPlant.sysj line: 35, column: 11
                          POSB.setPresent();//sysj\BaxterPlant.sysj line: 36, column: 5
                          currsigs.addElement(POSB);
                          if(parts_thread_1[2].equals("close")){//sysj\BaxterPlant.sysj line: 46, column: 4
                            GripDat.setPresent();//sysj\BaxterPlant.sysj line: 47, column: 5
                            currsigs.addElement(GripDat);
                            CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                            currsigs.addElement(CMDfb);
                            S160=1;
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                            currsigs.addElement(CMDfb);
                            S160=1;
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(parts_thread_1[2].equals("C")){//sysj\BaxterPlant.sysj line: 38, column: 11
                            POSC.setPresent();//sysj\BaxterPlant.sysj line: 39, column: 5
                            currsigs.addElement(POSC);
                            if(parts_thread_1[2].equals("close")){//sysj\BaxterPlant.sysj line: 46, column: 4
                              GripDat.setPresent();//sysj\BaxterPlant.sysj line: 47, column: 5
                              currsigs.addElement(GripDat);
                              CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                              currsigs.addElement(CMDfb);
                              S160=1;
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                            else {
                              CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                              currsigs.addElement(CMDfb);
                              S160=1;
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                          }
                          else {
                            if(parts_thread_1[2].equals("D")){//sysj\BaxterPlant.sysj line: 41, column: 11
                              POSD.setPresent();//sysj\BaxterPlant.sysj line: 42, column: 5
                              currsigs.addElement(POSD);
                              if(parts_thread_1[2].equals("close")){//sysj\BaxterPlant.sysj line: 46, column: 4
                                GripDat.setPresent();//sysj\BaxterPlant.sysj line: 47, column: 5
                                currsigs.addElement(GripDat);
                                CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                                currsigs.addElement(CMDfb);
                                S160=1;
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                                currsigs.addElement(CMDfb);
                                S160=1;
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(parts_thread_1[2].equals("close")){//sysj\BaxterPlant.sysj line: 46, column: 4
                                GripDat.setPresent();//sysj\BaxterPlant.sysj line: 47, column: 5
                                currsigs.addElement(GripDat);
                                CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                                currsigs.addElement(CMDfb);
                                S160=1;
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                                currsigs.addElement(CMDfb);
                                S160=1;
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                        }
                      }
                    }
                    else {
                      CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                      currsigs.addElement(CMDfb);
                      S160=1;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  }
                  else {
                    if(CMD.getprestatus()){//sysj\BaxterPlant.sysj line: 22, column: 11
                      command_thread_1 = (String)(CMD.getpreval() == null ? null : ((String)CMD.getpreval()));//sysj\BaxterPlant.sysj line: 23, column: 4
                      parts_thread_1 = command_thread_1.split(" ");//sysj\BaxterPlant.sysj line: 24, column: 4
                      System.out.println(parts_thread_1[2]);//sysj\BaxterPlant.sysj line: 29, column: 4
                      if(parts_thread_1[2].equals("A")){//sysj\BaxterPlant.sysj line: 32, column: 4
                        POSA.setPresent();//sysj\BaxterPlant.sysj line: 33, column: 5
                        currsigs.addElement(POSA);
                        if(parts_thread_1[2].equals("close")){//sysj\BaxterPlant.sysj line: 46, column: 4
                          GripDat.setPresent();//sysj\BaxterPlant.sysj line: 47, column: 5
                          currsigs.addElement(GripDat);
                          CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                          currsigs.addElement(CMDfb);
                          S160=1;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                          currsigs.addElement(CMDfb);
                          S160=1;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(parts_thread_1[2].equals("B")){//sysj\BaxterPlant.sysj line: 35, column: 11
                          POSB.setPresent();//sysj\BaxterPlant.sysj line: 36, column: 5
                          currsigs.addElement(POSB);
                          if(parts_thread_1[2].equals("close")){//sysj\BaxterPlant.sysj line: 46, column: 4
                            GripDat.setPresent();//sysj\BaxterPlant.sysj line: 47, column: 5
                            currsigs.addElement(GripDat);
                            CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                            currsigs.addElement(CMDfb);
                            S160=1;
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                            currsigs.addElement(CMDfb);
                            S160=1;
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(parts_thread_1[2].equals("C")){//sysj\BaxterPlant.sysj line: 38, column: 11
                            POSC.setPresent();//sysj\BaxterPlant.sysj line: 39, column: 5
                            currsigs.addElement(POSC);
                            if(parts_thread_1[2].equals("close")){//sysj\BaxterPlant.sysj line: 46, column: 4
                              GripDat.setPresent();//sysj\BaxterPlant.sysj line: 47, column: 5
                              currsigs.addElement(GripDat);
                              CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                              currsigs.addElement(CMDfb);
                              S160=1;
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                            else {
                              CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                              currsigs.addElement(CMDfb);
                              S160=1;
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                          }
                          else {
                            if(parts_thread_1[2].equals("D")){//sysj\BaxterPlant.sysj line: 41, column: 11
                              POSD.setPresent();//sysj\BaxterPlant.sysj line: 42, column: 5
                              currsigs.addElement(POSD);
                              if(parts_thread_1[2].equals("close")){//sysj\BaxterPlant.sysj line: 46, column: 4
                                GripDat.setPresent();//sysj\BaxterPlant.sysj line: 47, column: 5
                                currsigs.addElement(GripDat);
                                CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                                currsigs.addElement(CMDfb);
                                S160=1;
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                                currsigs.addElement(CMDfb);
                                S160=1;
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(parts_thread_1[2].equals("close")){//sysj\BaxterPlant.sysj line: 46, column: 4
                                GripDat.setPresent();//sysj\BaxterPlant.sysj line: 47, column: 5
                                currsigs.addElement(GripDat);
                                CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                                currsigs.addElement(CMDfb);
                                S160=1;
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                                currsigs.addElement(CMDfb);
                                S160=1;
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                        }
                      }
                    }
                    else {
                      CMDfb.setPresent();//sysj\BaxterPlant.sysj line: 54, column: 3
                      currsigs.addElement(CMDfb);
                      S160=1;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
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
          CMD.gethook();
          failT.gethook();
          df = true;
        }
        runClockDomain();
      }
      CMD.setpreclear();
      failT.setpreclear();
      CMDfb.setpreclear();
      bottleAtLoad.setpreclear();
      POSA.setpreclear();
      POSB.setpreclear();
      POSC.setpreclear();
      POSD.setpreclear();
      GripDat.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = CMD.getStatus() ? CMD.setprepresent() : CMD.setpreclear();
      CMD.setpreval(CMD.getValue());
      CMD.setClear();
      dummyint = failT.getStatus() ? failT.setprepresent() : failT.setpreclear();
      failT.setpreval(failT.getValue());
      failT.setClear();
      CMDfb.sethook();
      CMDfb.setClear();
      bottleAtLoad.sethook();
      bottleAtLoad.setClear();
      POSA.sethook();
      POSA.setClear();
      POSB.sethook();
      POSB.setClear();
      POSC.sethook();
      POSC.setClear();
      POSD.sethook();
      POSD.setClear();
      GripDat.sethook();
      GripDat.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        CMD.gethook();
        failT.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
