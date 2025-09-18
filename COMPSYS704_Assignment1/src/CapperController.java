import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class CapperController extends ClockDomain{
  public CapperController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal capGripped = new Signal("capGripped", Signal.INPUT);
  public Signal letGo = new Signal("letGo", Signal.INPUT);
  public Signal bottleAtPos4 = new Signal("bottleAtPos4", Signal.INPUT);
  public Signal gripperZAxisLowered = new Signal("gripperZAxisLowered", Signal.INPUT);
  public Signal gripperZAxisLifted = new Signal("gripperZAxisLifted", Signal.INPUT);
  public Signal gripperTurnHomePos = new Signal("gripperTurnHomePos", Signal.INPUT);
  public Signal gripperTurnFinalPos = new Signal("gripperTurnFinalPos", Signal.INPUT);
  public Signal capperReady = new Signal("capperReady", Signal.OUTPUT);
  public Signal cylPos5ZaxisExtend = new Signal("cylPos5ZaxisExtend", Signal.OUTPUT);
  public Signal gripperTurnRetract = new Signal("gripperTurnRetract", Signal.OUTPUT);
  public Signal gripperTurnExtend = new Signal("gripperTurnExtend", Signal.OUTPUT);
  public Signal capGripperPos5Extend = new Signal("capGripperPos5Extend", Signal.OUTPUT);
  public Signal cylClampBottleExtend = new Signal("cylClampBottleExtend", Signal.OUTPUT);
  public Signal start = new Signal("start", Signal.OUTPUT);
  private int S1291 = 1;
  private int S1290 = 1;
  private int S5 = 1;
  private int S13 = 1;
  private int S21 = 1;
  private int S66 = 1;
  private int S65 = 1;
  private int S30 = 1;
  private int S38 = 1;
  private int S31 = 1;
  private int S43 = 1;
  private int S40 = 1;
  
  private int[] ends = new int[8];
  private int[] tdone = new int[8];
  
  public void thread1315(int [] tdone, int [] ends){
        S66=1;
    S65=0;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread1314(int [] tdone, int [] ends){
        S21=1;
    System.out.println("clamped");//sysj\CapperController.sysj line: 27, column: 6
    cylClampBottleExtend.setPresent();//sysj\CapperController.sysj line: 28, column: 6
    currsigs.addElement(cylClampBottleExtend);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread1313(int [] tdone, int [] ends){
        S13=1;
    System.out.println("lowering");//sysj\CapperController.sysj line: 20, column: 6
    cylPos5ZaxisExtend.setPresent();//sysj\CapperController.sysj line: 21, column: 6
    currsigs.addElement(cylPos5ZaxisExtend);
    active[2]=1;
    ends[2]=1;
    tdone[2]=1;
  }

  public void thread1310(int [] tdone, int [] ends){
        switch(S43){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        switch(S40){
          case 0 : 
            if(capGripped.getprestatus()){//sysj\CapperController.sysj line: 53, column: 14
              System.out.println("gripped");//sysj\CapperController.sysj line: 54, column: 7
              S40=1;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
          case 1 : 
            if(gripperTurnFinalPos.getprestatus()){//sysj\CapperController.sysj line: 56, column: 13
              System.out.println("fully twisted");//sysj\CapperController.sysj line: 57, column: 7
              ends[7]=2;
              tdone[7]=1;
            }
            else {
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1309(int [] tdone, int [] ends){
        switch(S38){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S31){
          case 0 : 
            S31=0;
            System.out.println("twisting");//sysj\CapperController.sysj line: 46, column: 7
            S31=1;
            gripperTurnExtend.setPresent();//sysj\CapperController.sysj line: 47, column: 7
            currsigs.addElement(gripperTurnExtend);
            active[6]=1;
            ends[6]=1;
            tdone[6]=1;
            break;
          
          case 1 : 
            gripperTurnExtend.setPresent();//sysj\CapperController.sysj line: 47, column: 7
            currsigs.addElement(gripperTurnExtend);
            active[6]=1;
            ends[6]=1;
            tdone[6]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread1308(int [] tdone, int [] ends){
        switch(S30){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        capGripperPos5Extend.setPresent();//sysj\CapperController.sysj line: 38, column: 7
        currsigs.addElement(capGripperPos5Extend);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread1306(int [] tdone, int [] ends){
        S43=1;
    S40=0;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread1305(int [] tdone, int [] ends){
        S38=1;
    S31=0;
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread1304(int [] tdone, int [] ends){
        S30=1;
    System.out.println("gripping");//sysj\CapperController.sysj line: 37, column: 7
    capGripperPos5Extend.setPresent();//sysj\CapperController.sysj line: 38, column: 7
    currsigs.addElement(capGripperPos5Extend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread1303(int [] tdone, int [] ends){
        switch(S66){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S65){
          case 0 : 
            if(gripperZAxisLowered.getprestatus()){//sysj\CapperController.sysj line: 34, column: 12
              S65=1;
              thread1304(tdone,ends);
              thread1305(tdone,ends);
              thread1306(tdone,ends);
              int biggest1307 = 0;
              if(ends[5]>=biggest1307){
                biggest1307=ends[5];
              }
              if(ends[6]>=biggest1307){
                biggest1307=ends[6];
              }
              if(ends[7]>=biggest1307){
                biggest1307=ends[7];
              }
              if(biggest1307 == 1){
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 1 : 
            thread1308(tdone,ends);
            thread1309(tdone,ends);
            thread1310(tdone,ends);
            int biggest1311 = 0;
            if(ends[5]>=biggest1311){
              biggest1311=ends[5];
            }
            if(ends[6]>=biggest1311){
              biggest1311=ends[6];
            }
            if(ends[7]>=biggest1311){
              biggest1311=ends[7];
            }
            if(biggest1311 == 1){
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            if(biggest1311 == 2){
              ends[4]=2;
              tdone[4]=1;
            }
            //FINXME code
            if(biggest1311 == 0){
              S66=0;
              active[4]=0;
              ends[4]=0;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1302(int [] tdone, int [] ends){
        switch(S21){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj\CapperController.sysj line: 28, column: 6
        currsigs.addElement(cylClampBottleExtend);
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
        break;
      
    }
  }

  public void thread1301(int [] tdone, int [] ends){
        switch(S13){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        cylPos5ZaxisExtend.setPresent();//sysj\CapperController.sysj line: 21, column: 6
        currsigs.addElement(cylPos5ZaxisExtend);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
        break;
      
    }
  }

  public void thread1299(int [] tdone, int [] ends){
        S66=1;
    S65=0;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread1298(int [] tdone, int [] ends){
        S21=1;
    System.out.println("clamped");//sysj\CapperController.sysj line: 27, column: 6
    cylClampBottleExtend.setPresent();//sysj\CapperController.sysj line: 28, column: 6
    currsigs.addElement(cylClampBottleExtend);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread1297(int [] tdone, int [] ends){
        S13=1;
    System.out.println("lowering");//sysj\CapperController.sysj line: 20, column: 6
    cylPos5ZaxisExtend.setPresent();//sysj\CapperController.sysj line: 21, column: 6
    currsigs.addElement(cylPos5ZaxisExtend);
    active[2]=1;
    ends[2]=1;
    tdone[2]=1;
  }

  public void thread1295(int [] tdone, int [] ends){
        S66=1;
    S65=0;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread1294(int [] tdone, int [] ends){
        S21=1;
    System.out.println("clamped");//sysj\CapperController.sysj line: 27, column: 6
    cylClampBottleExtend.setPresent();//sysj\CapperController.sysj line: 28, column: 6
    currsigs.addElement(cylClampBottleExtend);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread1293(int [] tdone, int [] ends){
        S13=1;
    System.out.println("lowering");//sysj\CapperController.sysj line: 20, column: 6
    cylPos5ZaxisExtend.setPresent();//sysj\CapperController.sysj line: 21, column: 6
    currsigs.addElement(cylPos5ZaxisExtend);
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
      switch(S1291){
        case 0 : 
          S1291=0;
          break RUN;
        
        case 1 : 
          S1291=2;
          S1291=2;
          S1290=0;
          active[1]=1;
          ends[1]=1;
          break RUN;
        
        case 2 : 
          switch(S1290){
            case 0 : 
              S1290=0;
              S1290=1;
              S5=0;
              if(bottleAtPos4.getprestatus()){//sysj\CapperController.sysj line: 10, column: 20
                start.setPresent();//sysj\CapperController.sysj line: 16, column: 4
                currsigs.addElement(start);
                S5=1;
                thread1293(tdone,ends);
                thread1294(tdone,ends);
                thread1295(tdone,ends);
                int biggest1296 = 0;
                if(ends[2]>=biggest1296){
                  biggest1296=ends[2];
                }
                if(ends[3]>=biggest1296){
                  biggest1296=ends[3];
                }
                if(ends[4]>=biggest1296){
                  biggest1296=ends[4];
                }
                if(biggest1296 == 1){
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
              else {
                capperReady.setPresent();//sysj\CapperController.sysj line: 11, column: 5
                currsigs.addElement(capperReady);
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            
            case 1 : 
              switch(S5){
                case 0 : 
                  if(bottleAtPos4.getprestatus()){//sysj\CapperController.sysj line: 10, column: 20
                    start.setPresent();//sysj\CapperController.sysj line: 16, column: 4
                    currsigs.addElement(start);
                    S5=1;
                    thread1297(tdone,ends);
                    thread1298(tdone,ends);
                    thread1299(tdone,ends);
                    int biggest1300 = 0;
                    if(ends[2]>=biggest1300){
                      biggest1300=ends[2];
                    }
                    if(ends[3]>=biggest1300){
                      biggest1300=ends[3];
                    }
                    if(ends[4]>=biggest1300){
                      biggest1300=ends[4];
                    }
                    if(biggest1300 == 1){
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  }
                  else {
                    capperReady.setPresent();//sysj\CapperController.sysj line: 11, column: 5
                    currsigs.addElement(capperReady);
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                
                case 1 : 
                  thread1301(tdone,ends);
                  thread1302(tdone,ends);
                  thread1303(tdone,ends);
                  int biggest1312 = 0;
                  if(ends[2]>=biggest1312){
                    biggest1312=ends[2];
                  }
                  if(ends[3]>=biggest1312){
                    biggest1312=ends[3];
                  }
                  if(ends[4]>=biggest1312){
                    biggest1312=ends[4];
                  }
                  if(biggest1312 == 1){
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  if(biggest1312 == 2){
                    ends[1]=2;
                    ;//sysj\CapperController.sysj line: 17, column: 4
                    S5=2;
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  //FINXME code
                  if(biggest1312 == 0){
                    S5=2;
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                
                case 2 : 
                  if(letGo.getprestatus()){//sysj\CapperController.sysj line: 63, column: 10
                    System.out.println("ungripped");//sysj\CapperController.sysj line: 65, column: 4
                    System.out.println("unclamped");//sysj\CapperController.sysj line: 66, column: 4
                    System.out.println("raising");//sysj\CapperController.sysj line: 67, column: 4
                    S5=3;
                    System.out.println("untwisting");//sysj\CapperController.sysj line: 70, column: 5
                    gripperTurnRetract.setPresent();//sysj\CapperController.sysj line: 71, column: 5
                    currsigs.addElement(gripperTurnRetract);
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  else {
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                
                case 3 : 
                  if(gripperTurnHomePos.getprestatus()){//sysj\CapperController.sysj line: 69, column: 10
                    System.out.println("fully untwisted");//sysj\CapperController.sysj line: 73, column: 4
                    S5=4;
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  else {
                    gripperTurnRetract.setPresent();//sysj\CapperController.sysj line: 71, column: 5
                    currsigs.addElement(gripperTurnRetract);
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                
                case 4 : 
                  if(gripperZAxisLifted.getprestatus()){//sysj\CapperController.sysj line: 75, column: 10
                    System.out.println("at top");//sysj\CapperController.sysj line: 76, column: 4
                    capperReady.setPresent();//sysj\CapperController.sysj line: 77, column: 4
                    currsigs.addElement(capperReady);
                    System.out.println("capperReady signal sent");//sysj\CapperController.sysj line: 78, column: 4
                    S5=5;
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  else {
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                
                case 5 : 
                  if(!bottleAtPos4.getprestatus()){//sysj\CapperController.sysj line: 79, column: 10
                    S5=0;
                    if(bottleAtPos4.getprestatus()){//sysj\CapperController.sysj line: 10, column: 20
                      start.setPresent();//sysj\CapperController.sysj line: 16, column: 4
                      currsigs.addElement(start);
                      S5=1;
                      thread1313(tdone,ends);
                      thread1314(tdone,ends);
                      thread1315(tdone,ends);
                      int biggest1316 = 0;
                      if(ends[2]>=biggest1316){
                        biggest1316=ends[2];
                      }
                      if(ends[3]>=biggest1316){
                        biggest1316=ends[3];
                      }
                      if(ends[4]>=biggest1316){
                        biggest1316=ends[4];
                      }
                      if(biggest1316 == 1){
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                    }
                    else {
                      capperReady.setPresent();//sysj\CapperController.sysj line: 11, column: 5
                      currsigs.addElement(capperReady);
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
              break;
            
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0};
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
          capGripped.gethook();
          letGo.gethook();
          bottleAtPos4.gethook();
          gripperZAxisLowered.gethook();
          gripperZAxisLifted.gethook();
          gripperTurnHomePos.gethook();
          gripperTurnFinalPos.gethook();
          df = true;
        }
        runClockDomain();
      }
      capGripped.setpreclear();
      letGo.setpreclear();
      bottleAtPos4.setpreclear();
      gripperZAxisLowered.setpreclear();
      gripperZAxisLifted.setpreclear();
      gripperTurnHomePos.setpreclear();
      gripperTurnFinalPos.setpreclear();
      capperReady.setpreclear();
      cylPos5ZaxisExtend.setpreclear();
      gripperTurnRetract.setpreclear();
      gripperTurnExtend.setpreclear();
      capGripperPos5Extend.setpreclear();
      cylClampBottleExtend.setpreclear();
      start.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = capGripped.getStatus() ? capGripped.setprepresent() : capGripped.setpreclear();
      capGripped.setpreval(capGripped.getValue());
      capGripped.setClear();
      dummyint = letGo.getStatus() ? letGo.setprepresent() : letGo.setpreclear();
      letGo.setpreval(letGo.getValue());
      letGo.setClear();
      dummyint = bottleAtPos4.getStatus() ? bottleAtPos4.setprepresent() : bottleAtPos4.setpreclear();
      bottleAtPos4.setpreval(bottleAtPos4.getValue());
      bottleAtPos4.setClear();
      dummyint = gripperZAxisLowered.getStatus() ? gripperZAxisLowered.setprepresent() : gripperZAxisLowered.setpreclear();
      gripperZAxisLowered.setpreval(gripperZAxisLowered.getValue());
      gripperZAxisLowered.setClear();
      dummyint = gripperZAxisLifted.getStatus() ? gripperZAxisLifted.setprepresent() : gripperZAxisLifted.setpreclear();
      gripperZAxisLifted.setpreval(gripperZAxisLifted.getValue());
      gripperZAxisLifted.setClear();
      dummyint = gripperTurnHomePos.getStatus() ? gripperTurnHomePos.setprepresent() : gripperTurnHomePos.setpreclear();
      gripperTurnHomePos.setpreval(gripperTurnHomePos.getValue());
      gripperTurnHomePos.setClear();
      dummyint = gripperTurnFinalPos.getStatus() ? gripperTurnFinalPos.setprepresent() : gripperTurnFinalPos.setpreclear();
      gripperTurnFinalPos.setpreval(gripperTurnFinalPos.getValue());
      gripperTurnFinalPos.setClear();
      capperReady.sethook();
      capperReady.setClear();
      cylPos5ZaxisExtend.sethook();
      cylPos5ZaxisExtend.setClear();
      gripperTurnRetract.sethook();
      gripperTurnRetract.setClear();
      gripperTurnExtend.sethook();
      gripperTurnExtend.setClear();
      capGripperPos5Extend.sethook();
      capGripperPos5Extend.setClear();
      cylClampBottleExtend.sethook();
      cylClampBottleExtend.setClear();
      start.sethook();
      start.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        capGripped.gethook();
        letGo.gethook();
        bottleAtPos4.gethook();
        gripperZAxisLowered.gethook();
        gripperZAxisLifted.gethook();
        gripperTurnHomePos.gethook();
        gripperTurnFinalPos.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
