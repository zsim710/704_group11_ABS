import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class LidLoaderController extends ClockDomain{
  public LidLoaderController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal pusherRetracted = new Signal("pusherRetracted", Signal.INPUT);
  public Signal pusherExtended = new Signal("pusherExtended", Signal.INPUT);
  public Signal WPgripped = new Signal("WPgripped", Signal.INPUT);
  public Signal armAtSource = new Signal("armAtSource", Signal.INPUT);
  public Signal armAtDest = new Signal("armAtDest", Signal.INPUT);
  public Signal empty = new Signal("empty", Signal.INPUT);
  public Signal bottleAtPos3 = new Signal("bottleAtPos3", Signal.INPUT);
  public Signal mode = new Signal("mode", Signal.INPUT);
  public Signal pusherExtend = new Signal("pusherExtend", Signal.OUTPUT);
  public Signal vacOn = new Signal("vacOn", Signal.OUTPUT);
  public Signal armSource = new Signal("armSource", Signal.OUTPUT);
  public Signal armDest = new Signal("armDest", Signal.OUTPUT);
  public Signal lidLoaderReady = new Signal("lidLoaderReady", Signal.OUTPUT);
  private int S3315 = 1;
  private int S3313 = 1;
  private int S3112 = 1;
  private int S3134 = 1;
  private int S3145 = 1;
  private int S3144 = 1;
  
  private int[] ends = new int[4];
  private int[] tdone = new int[4];
  
  public void thread3321(int [] tdone, int [] ends){
        switch(S3145){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S3144){
          case 0 : 
            if(WPgripped.getprestatus()){//sysj\LidLoaderController.sysj line: 33, column: 11
              S3144=1;
              armDest.setPresent();//sysj\LidLoaderController.sysj line: 35, column: 6
              currsigs.addElement(armDest);
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
          
          case 1 : 
            if(armAtDest.getprestatus()){//sysj\LidLoaderController.sysj line: 34, column: 11
              S3145=0;
              active[3]=0;
              ends[3]=0;
              tdone[3]=1;
            }
            else {
              armDest.setPresent();//sysj\LidLoaderController.sysj line: 35, column: 6
              currsigs.addElement(armDest);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread3320(int [] tdone, int [] ends){
        switch(S3134){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(armAtDest.getprestatus()){//sysj\LidLoaderController.sysj line: 25, column: 11
          S3134=0;
          active[2]=0;
          ends[2]=0;
          tdone[2]=1;
        }
        else {
          vacOn.setPresent();//sysj\LidLoaderController.sysj line: 26, column: 6
          currsigs.addElement(vacOn);
          active[2]=1;
          ends[2]=1;
          tdone[2]=1;
        }
        break;
      
    }
  }

  public void thread3318(int [] tdone, int [] ends){
        S3145=1;
    S3144=0;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread3317(int [] tdone, int [] ends){
        S3134=1;
    vacOn.setPresent();//sysj\LidLoaderController.sysj line: 26, column: 6
    currsigs.addElement(vacOn);
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
      switch(S3315){
        case 0 : 
          S3315=0;
          break RUN;
        
        case 1 : 
          S3315=2;
          S3315=2;
          S3313=0;
          S3112=0;
          lidLoaderReady.setPresent();//sysj\LidLoaderController.sysj line: 9, column: 5
          currsigs.addElement(lidLoaderReady);
          active[1]=1;
          ends[1]=1;
          break RUN;
        
        case 2 : 
          switch(S3313){
            case 0 : 
              switch(S3112){
                case 0 : 
                  if(bottleAtPos3.getprestatus()){//sysj\LidLoaderController.sysj line: 8, column: 10
                    S3112=1;
                    armDest.setPresent();//sysj\LidLoaderController.sysj line: 13, column: 5
                    currsigs.addElement(armDest);
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  else {
                    lidLoaderReady.setPresent();//sysj\LidLoaderController.sysj line: 9, column: 5
                    currsigs.addElement(lidLoaderReady);
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                
                case 1 : 
                  if(armAtDest.getprestatus()){//sysj\LidLoaderController.sysj line: 12, column: 10
                    S3112=2;
                    pusherExtend.setPresent();//sysj\LidLoaderController.sysj line: 17, column: 5
                    currsigs.addElement(pusherExtend);
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  else {
                    armDest.setPresent();//sysj\LidLoaderController.sysj line: 13, column: 5
                    currsigs.addElement(armDest);
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                
                case 2 : 
                  if(pusherExtended.getprestatus()){//sysj\LidLoaderController.sysj line: 16, column: 10
                    S3112=3;
                    armSource.setPresent();//sysj\LidLoaderController.sysj line: 21, column: 5
                    currsigs.addElement(armSource);
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  else {
                    pusherExtend.setPresent();//sysj\LidLoaderController.sysj line: 17, column: 5
                    currsigs.addElement(pusherExtend);
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                
                case 3 : 
                  if(armAtSource.getprestatus()){//sysj\LidLoaderController.sysj line: 20, column: 10
                    S3112=4;
                    thread3317(tdone,ends);
                    thread3318(tdone,ends);
                    int biggest3319 = 0;
                    if(ends[2]>=biggest3319){
                      biggest3319=ends[2];
                    }
                    if(ends[3]>=biggest3319){
                      biggest3319=ends[3];
                    }
                    if(biggest3319 == 1){
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  }
                  else {
                    armSource.setPresent();//sysj\LidLoaderController.sysj line: 21, column: 5
                    currsigs.addElement(armSource);
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                
                case 4 : 
                  thread3320(tdone,ends);
                  thread3321(tdone,ends);
                  int biggest3322 = 0;
                  if(ends[2]>=biggest3322){
                    biggest3322=ends[2];
                  }
                  if(ends[3]>=biggest3322){
                    biggest3322=ends[3];
                  }
                  if(biggest3322 == 1){
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  //FINXME code
                  if(biggest3322 == 0){
                    S3112=5;
                    armSource.setPresent();//sysj\LidLoaderController.sysj line: 40, column: 5
                    currsigs.addElement(armSource);
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                
                case 5 : 
                  if(armAtSource.getprestatus()){//sysj\LidLoaderController.sysj line: 39, column: 10
                    S3112=0;
                    lidLoaderReady.setPresent();//sysj\LidLoaderController.sysj line: 9, column: 5
                    currsigs.addElement(lidLoaderReady);
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  else {
                    armSource.setPresent();//sysj\LidLoaderController.sysj line: 40, column: 5
                    currsigs.addElement(armSource);
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                
              }
              break;
            
            case 1 : 
              if(!bottleAtPos3.getprestatus()){//sysj\LidLoaderController.sysj line: 47, column: 9
                S3315=0;
                active[1]=0;
                ends[1]=0;
                S3315=0;
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
          pusherRetracted.gethook();
          pusherExtended.gethook();
          WPgripped.gethook();
          armAtSource.gethook();
          armAtDest.gethook();
          empty.gethook();
          bottleAtPos3.gethook();
          mode.gethook();
          df = true;
        }
        runClockDomain();
      }
      pusherRetracted.setpreclear();
      pusherExtended.setpreclear();
      WPgripped.setpreclear();
      armAtSource.setpreclear();
      armAtDest.setpreclear();
      empty.setpreclear();
      bottleAtPos3.setpreclear();
      mode.setpreclear();
      pusherExtend.setpreclear();
      vacOn.setpreclear();
      armSource.setpreclear();
      armDest.setpreclear();
      lidLoaderReady.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = pusherRetracted.getStatus() ? pusherRetracted.setprepresent() : pusherRetracted.setpreclear();
      pusherRetracted.setpreval(pusherRetracted.getValue());
      pusherRetracted.setClear();
      dummyint = pusherExtended.getStatus() ? pusherExtended.setprepresent() : pusherExtended.setpreclear();
      pusherExtended.setpreval(pusherExtended.getValue());
      pusherExtended.setClear();
      dummyint = WPgripped.getStatus() ? WPgripped.setprepresent() : WPgripped.setpreclear();
      WPgripped.setpreval(WPgripped.getValue());
      WPgripped.setClear();
      dummyint = armAtSource.getStatus() ? armAtSource.setprepresent() : armAtSource.setpreclear();
      armAtSource.setpreval(armAtSource.getValue());
      armAtSource.setClear();
      dummyint = armAtDest.getStatus() ? armAtDest.setprepresent() : armAtDest.setpreclear();
      armAtDest.setpreval(armAtDest.getValue());
      armAtDest.setClear();
      dummyint = empty.getStatus() ? empty.setprepresent() : empty.setpreclear();
      empty.setpreval(empty.getValue());
      empty.setClear();
      dummyint = bottleAtPos3.getStatus() ? bottleAtPos3.setprepresent() : bottleAtPos3.setpreclear();
      bottleAtPos3.setpreval(bottleAtPos3.getValue());
      bottleAtPos3.setClear();
      dummyint = mode.getStatus() ? mode.setprepresent() : mode.setpreclear();
      mode.setpreval(mode.getValue());
      mode.setClear();
      pusherExtend.sethook();
      pusherExtend.setClear();
      vacOn.sethook();
      vacOn.setClear();
      armSource.sethook();
      armSource.setClear();
      armDest.sethook();
      armDest.setClear();
      lidLoaderReady.sethook();
      lidLoaderReady.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        pusherRetracted.gethook();
        pusherExtended.gethook();
        WPgripped.gethook();
        armAtSource.gethook();
        armAtDest.gethook();
        empty.gethook();
        bottleAtPos3.gethook();
        mode.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
