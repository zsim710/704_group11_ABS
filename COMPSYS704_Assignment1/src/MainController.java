import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class MainController extends ClockDomain{
  public MainController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal bottleAtPos1M = new Signal("bottleAtPos1M", Signal.INPUT);
  public Signal bottleLeftPos5M = new Signal("bottleLeftPos5M", Signal.INPUT);
  public Signal enable = new Signal("enable", Signal.INPUT);
  public Signal BatchQuantity = new Signal("BatchQuantity", Signal.INPUT);
  public Signal LiquidAmount1 = new Signal("LiquidAmount1", Signal.INPUT);
  public Signal LiquidAmount2 = new Signal("LiquidAmount2", Signal.INPUT);
  public Signal wsActive = new Signal("wsActive", Signal.OUTPUT);
  public Signal wsActiveRC = new Signal("wsActiveRC", Signal.OUTPUT);
  public Signal wsActiveRP = new Signal("wsActiveRP", Signal.OUTPUT);
  public Signal bottleTotal = new Signal("bottleTotal", Signal.OUTPUT);
  public Signal bottleTotalRC = new Signal("bottleTotalRC", Signal.OUTPUT);
  public Signal bottleTotalRP = new Signal("bottleTotalRP", Signal.OUTPUT);
  public Signal BatchQuantityRC = new Signal("BatchQuantityRC", Signal.OUTPUT);
  public Signal BatchQuantityRP = new Signal("BatchQuantityRP", Signal.OUTPUT);
  public Signal LiquidAmount1FP = new Signal("LiquidAmount1FP", Signal.OUTPUT);
  public Signal LiquidAmount2FP = new Signal("LiquidAmount2FP", Signal.OUTPUT);
  private int S4779 = 1;
  private int S4699 = 1;
  private int S4758 = 1;
  private int S4763 = 1;
  private int S4777 = 1;
  
  private int[] ends = new int[6];
  private int[] tdone = new int[6];
  
  public void thread4789(int [] tdone, int [] ends){
        switch(S4777){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        if(enable.getprestatus()){//sysj\MainController.sysj line: 56, column: 12
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        else {
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        break;
      
    }
  }

  public void thread4788(int [] tdone, int [] ends){
        switch(S4763){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        LiquidAmount1FP.setPresent();//sysj\MainController.sysj line: 46, column: 5
        currsigs.addElement(LiquidAmount1FP);
        LiquidAmount2FP.setPresent();//sysj\MainController.sysj line: 47, column: 5
        currsigs.addElement(LiquidAmount2FP);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread4787(int [] tdone, int [] ends){
        switch(S4758){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        if(wsActive.getprestatus()){//sysj\MainController.sysj line: 25, column: 12
          wsActiveRC.setPresent();//sysj\MainController.sysj line: 26, column: 5
          currsigs.addElement(wsActiveRC);
          wsActiveRC.setValue((wsActive.getpreval() == null ? null : ((Integer)wsActive.getpreval())));//sysj\MainController.sysj line: 26, column: 5
          wsActiveRP.setPresent();//sysj\MainController.sysj line: 27, column: 5
          currsigs.addElement(wsActiveRP);
          wsActiveRP.setValue((wsActive.getpreval() == null ? null : ((Integer)wsActive.getpreval())));//sysj\MainController.sysj line: 27, column: 5
          if(bottleTotal.getprestatus()){//sysj\MainController.sysj line: 30, column: 12
            bottleTotalRC.setPresent();//sysj\MainController.sysj line: 31, column: 5
            currsigs.addElement(bottleTotalRC);
            bottleTotalRC.setValue((bottleTotal.getpreval() == null ? null : ((Integer)bottleTotal.getpreval())));//sysj\MainController.sysj line: 31, column: 5
            bottleTotalRP.setPresent();//sysj\MainController.sysj line: 32, column: 5
            currsigs.addElement(bottleTotalRP);
            bottleTotalRP.setValue((bottleTotal.getpreval() == null ? null : ((Integer)bottleTotal.getpreval())));//sysj\MainController.sysj line: 32, column: 5
            if(BatchQuantity.getprestatus()){//sysj\MainController.sysj line: 35, column: 12
              BatchQuantityRC.setPresent();//sysj\MainController.sysj line: 36, column: 5
              currsigs.addElement(BatchQuantityRC);
              BatchQuantityRC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 36, column: 5
              BatchQuantityRP.setPresent();//sysj\MainController.sysj line: 37, column: 5
              currsigs.addElement(BatchQuantityRP);
              BatchQuantityRP.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 37, column: 5
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
          }
          else {
            if(BatchQuantity.getprestatus()){//sysj\MainController.sysj line: 35, column: 12
              BatchQuantityRC.setPresent();//sysj\MainController.sysj line: 36, column: 5
              currsigs.addElement(BatchQuantityRC);
              BatchQuantityRC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 36, column: 5
              BatchQuantityRP.setPresent();//sysj\MainController.sysj line: 37, column: 5
              currsigs.addElement(BatchQuantityRP);
              BatchQuantityRP.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 37, column: 5
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
          }
        }
        else {
          if(bottleTotal.getprestatus()){//sysj\MainController.sysj line: 30, column: 12
            bottleTotalRC.setPresent();//sysj\MainController.sysj line: 31, column: 5
            currsigs.addElement(bottleTotalRC);
            bottleTotalRC.setValue((bottleTotal.getpreval() == null ? null : ((Integer)bottleTotal.getpreval())));//sysj\MainController.sysj line: 31, column: 5
            bottleTotalRP.setPresent();//sysj\MainController.sysj line: 32, column: 5
            currsigs.addElement(bottleTotalRP);
            bottleTotalRP.setValue((bottleTotal.getpreval() == null ? null : ((Integer)bottleTotal.getpreval())));//sysj\MainController.sysj line: 32, column: 5
            if(BatchQuantity.getprestatus()){//sysj\MainController.sysj line: 35, column: 12
              BatchQuantityRC.setPresent();//sysj\MainController.sysj line: 36, column: 5
              currsigs.addElement(BatchQuantityRC);
              BatchQuantityRC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 36, column: 5
              BatchQuantityRP.setPresent();//sysj\MainController.sysj line: 37, column: 5
              currsigs.addElement(BatchQuantityRP);
              BatchQuantityRP.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 37, column: 5
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
          }
          else {
            if(BatchQuantity.getprestatus()){//sysj\MainController.sysj line: 35, column: 12
              BatchQuantityRC.setPresent();//sysj\MainController.sysj line: 36, column: 5
              currsigs.addElement(BatchQuantityRC);
              BatchQuantityRC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 36, column: 5
              BatchQuantityRP.setPresent();//sysj\MainController.sysj line: 37, column: 5
              currsigs.addElement(BatchQuantityRP);
              BatchQuantityRP.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 37, column: 5
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
          }
        }
        break;
      
    }
  }

  public void thread4786(int [] tdone, int [] ends){
        switch(S4699){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(bottleAtPos1M.getprestatus()){//sysj\MainController.sysj line: 11, column: 13
          wsActive.setPresent();//sysj\MainController.sysj line: 12, column: 6
          currsigs.addElement(wsActive);
          wsActive.setValue((Integer)(wsActive.getpreval() == null ? null : ((Integer)wsActive.getpreval())) + 1);//sysj\MainController.sysj line: 12, column: 6
          bottleTotal.setPresent();//sysj\MainController.sysj line: 13, column: 6
          currsigs.addElement(bottleTotal);
          bottleTotal.setValue((Integer)(bottleTotal.getpreval() == null ? null : ((Integer)bottleTotal.getpreval())) + 1);//sysj\MainController.sysj line: 13, column: 6
          if(bottleLeftPos5M.getprestatus()){//sysj\MainController.sysj line: 16, column: 13
            wsActive.setPresent();//sysj\MainController.sysj line: 17, column: 6
            currsigs.addElement(wsActive);
            wsActive.setValue((Integer)(wsActive.getpreval() == null ? null : ((Integer)wsActive.getpreval())) - 1);//sysj\MainController.sysj line: 17, column: 6
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
        else {
          if(bottleLeftPos5M.getprestatus()){//sysj\MainController.sysj line: 16, column: 13
            wsActive.setPresent();//sysj\MainController.sysj line: 17, column: 6
            currsigs.addElement(wsActive);
            wsActive.setValue((Integer)(wsActive.getpreval() == null ? null : ((Integer)wsActive.getpreval())) - 1);//sysj\MainController.sysj line: 17, column: 6
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
        break;
      
    }
  }

  public void thread4784(int [] tdone, int [] ends){
        S4777=1;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread4783(int [] tdone, int [] ends){
        S4763=1;
    LiquidAmount1FP.setPresent();//sysj\MainController.sysj line: 46, column: 5
    currsigs.addElement(LiquidAmount1FP);
    LiquidAmount2FP.setPresent();//sysj\MainController.sysj line: 47, column: 5
    currsigs.addElement(LiquidAmount2FP);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread4782(int [] tdone, int [] ends){
        S4758=1;
    if(wsActive.getprestatus()){//sysj\MainController.sysj line: 25, column: 12
      wsActiveRC.setPresent();//sysj\MainController.sysj line: 26, column: 5
      currsigs.addElement(wsActiveRC);
      wsActiveRC.setValue((wsActive.getpreval() == null ? null : ((Integer)wsActive.getpreval())));//sysj\MainController.sysj line: 26, column: 5
      wsActiveRP.setPresent();//sysj\MainController.sysj line: 27, column: 5
      currsigs.addElement(wsActiveRP);
      wsActiveRP.setValue((wsActive.getpreval() == null ? null : ((Integer)wsActive.getpreval())));//sysj\MainController.sysj line: 27, column: 5
      if(bottleTotal.getprestatus()){//sysj\MainController.sysj line: 30, column: 12
        bottleTotalRC.setPresent();//sysj\MainController.sysj line: 31, column: 5
        currsigs.addElement(bottleTotalRC);
        bottleTotalRC.setValue((bottleTotal.getpreval() == null ? null : ((Integer)bottleTotal.getpreval())));//sysj\MainController.sysj line: 31, column: 5
        bottleTotalRP.setPresent();//sysj\MainController.sysj line: 32, column: 5
        currsigs.addElement(bottleTotalRP);
        bottleTotalRP.setValue((bottleTotal.getpreval() == null ? null : ((Integer)bottleTotal.getpreval())));//sysj\MainController.sysj line: 32, column: 5
        if(BatchQuantity.getprestatus()){//sysj\MainController.sysj line: 35, column: 12
          BatchQuantityRC.setPresent();//sysj\MainController.sysj line: 36, column: 5
          currsigs.addElement(BatchQuantityRC);
          BatchQuantityRC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 36, column: 5
          BatchQuantityRP.setPresent();//sysj\MainController.sysj line: 37, column: 5
          currsigs.addElement(BatchQuantityRP);
          BatchQuantityRP.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 37, column: 5
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        else {
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
      }
      else {
        if(BatchQuantity.getprestatus()){//sysj\MainController.sysj line: 35, column: 12
          BatchQuantityRC.setPresent();//sysj\MainController.sysj line: 36, column: 5
          currsigs.addElement(BatchQuantityRC);
          BatchQuantityRC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 36, column: 5
          BatchQuantityRP.setPresent();//sysj\MainController.sysj line: 37, column: 5
          currsigs.addElement(BatchQuantityRP);
          BatchQuantityRP.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 37, column: 5
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        else {
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
      }
    }
    else {
      if(bottleTotal.getprestatus()){//sysj\MainController.sysj line: 30, column: 12
        bottleTotalRC.setPresent();//sysj\MainController.sysj line: 31, column: 5
        currsigs.addElement(bottleTotalRC);
        bottleTotalRC.setValue((bottleTotal.getpreval() == null ? null : ((Integer)bottleTotal.getpreval())));//sysj\MainController.sysj line: 31, column: 5
        bottleTotalRP.setPresent();//sysj\MainController.sysj line: 32, column: 5
        currsigs.addElement(bottleTotalRP);
        bottleTotalRP.setValue((bottleTotal.getpreval() == null ? null : ((Integer)bottleTotal.getpreval())));//sysj\MainController.sysj line: 32, column: 5
        if(BatchQuantity.getprestatus()){//sysj\MainController.sysj line: 35, column: 12
          BatchQuantityRC.setPresent();//sysj\MainController.sysj line: 36, column: 5
          currsigs.addElement(BatchQuantityRC);
          BatchQuantityRC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 36, column: 5
          BatchQuantityRP.setPresent();//sysj\MainController.sysj line: 37, column: 5
          currsigs.addElement(BatchQuantityRP);
          BatchQuantityRP.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 37, column: 5
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        else {
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
      }
      else {
        if(BatchQuantity.getprestatus()){//sysj\MainController.sysj line: 35, column: 12
          BatchQuantityRC.setPresent();//sysj\MainController.sysj line: 36, column: 5
          currsigs.addElement(BatchQuantityRC);
          BatchQuantityRC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 36, column: 5
          BatchQuantityRP.setPresent();//sysj\MainController.sysj line: 37, column: 5
          currsigs.addElement(BatchQuantityRP);
          BatchQuantityRP.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 37, column: 5
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        else {
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
      }
    }
  }

  public void thread4781(int [] tdone, int [] ends){
        S4699=1;
    if(bottleAtPos1M.getprestatus()){//sysj\MainController.sysj line: 11, column: 13
      wsActive.setPresent();//sysj\MainController.sysj line: 12, column: 6
      currsigs.addElement(wsActive);
      wsActive.setValue((Integer)(wsActive.getpreval() == null ? null : ((Integer)wsActive.getpreval())) + 1);//sysj\MainController.sysj line: 12, column: 6
      bottleTotal.setPresent();//sysj\MainController.sysj line: 13, column: 6
      currsigs.addElement(bottleTotal);
      bottleTotal.setValue((Integer)(bottleTotal.getpreval() == null ? null : ((Integer)bottleTotal.getpreval())) + 1);//sysj\MainController.sysj line: 13, column: 6
      if(bottleLeftPos5M.getprestatus()){//sysj\MainController.sysj line: 16, column: 13
        wsActive.setPresent();//sysj\MainController.sysj line: 17, column: 6
        currsigs.addElement(wsActive);
        wsActive.setValue((Integer)(wsActive.getpreval() == null ? null : ((Integer)wsActive.getpreval())) - 1);//sysj\MainController.sysj line: 17, column: 6
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
    else {
      if(bottleLeftPos5M.getprestatus()){//sysj\MainController.sysj line: 16, column: 13
        wsActive.setPresent();//sysj\MainController.sysj line: 17, column: 6
        currsigs.addElement(wsActive);
        wsActive.setValue((Integer)(wsActive.getpreval() == null ? null : ((Integer)wsActive.getpreval())) - 1);//sysj\MainController.sysj line: 17, column: 6
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

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S4779){
        case 0 : 
          S4779=0;
          break RUN;
        
        case 1 : 
          S4779=2;
          S4779=2;
          thread4781(tdone,ends);
          thread4782(tdone,ends);
          thread4783(tdone,ends);
          thread4784(tdone,ends);
          int biggest4785 = 0;
          if(ends[2]>=biggest4785){
            biggest4785=ends[2];
          }
          if(ends[3]>=biggest4785){
            biggest4785=ends[3];
          }
          if(ends[4]>=biggest4785){
            biggest4785=ends[4];
          }
          if(ends[5]>=biggest4785){
            biggest4785=ends[5];
          }
          if(biggest4785 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread4786(tdone,ends);
          thread4787(tdone,ends);
          thread4788(tdone,ends);
          thread4789(tdone,ends);
          int biggest4790 = 0;
          if(ends[2]>=biggest4790){
            biggest4790=ends[2];
          }
          if(ends[3]>=biggest4790){
            biggest4790=ends[3];
          }
          if(ends[4]>=biggest4790){
            biggest4790=ends[4];
          }
          if(ends[5]>=biggest4790){
            biggest4790=ends[5];
          }
          if(biggest4790 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest4790 == 0){
            S4779=0;
            active[1]=0;
            ends[1]=0;
            S4779=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0};
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
          bottleAtPos1M.gethook();
          bottleLeftPos5M.gethook();
          enable.gethook();
          BatchQuantity.gethook();
          LiquidAmount1.gethook();
          LiquidAmount2.gethook();
          df = true;
        }
        runClockDomain();
      }
      bottleAtPos1M.setpreclear();
      bottleLeftPos5M.setpreclear();
      enable.setpreclear();
      BatchQuantity.setpreclear();
      LiquidAmount1.setpreclear();
      LiquidAmount2.setpreclear();
      wsActive.setpreclear();
      wsActiveRC.setpreclear();
      wsActiveRP.setpreclear();
      bottleTotal.setpreclear();
      bottleTotalRC.setpreclear();
      bottleTotalRP.setpreclear();
      BatchQuantityRC.setpreclear();
      BatchQuantityRP.setpreclear();
      LiquidAmount1FP.setpreclear();
      LiquidAmount2FP.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = bottleAtPos1M.getStatus() ? bottleAtPos1M.setprepresent() : bottleAtPos1M.setpreclear();
      bottleAtPos1M.setpreval(bottleAtPos1M.getValue());
      bottleAtPos1M.setClear();
      dummyint = bottleLeftPos5M.getStatus() ? bottleLeftPos5M.setprepresent() : bottleLeftPos5M.setpreclear();
      bottleLeftPos5M.setpreval(bottleLeftPos5M.getValue());
      bottleLeftPos5M.setClear();
      dummyint = enable.getStatus() ? enable.setprepresent() : enable.setpreclear();
      enable.setpreval(enable.getValue());
      enable.setClear();
      dummyint = BatchQuantity.getStatus() ? BatchQuantity.setprepresent() : BatchQuantity.setpreclear();
      BatchQuantity.setpreval(BatchQuantity.getValue());
      BatchQuantity.setClear();
      dummyint = LiquidAmount1.getStatus() ? LiquidAmount1.setprepresent() : LiquidAmount1.setpreclear();
      LiquidAmount1.setpreval(LiquidAmount1.getValue());
      LiquidAmount1.setClear();
      dummyint = LiquidAmount2.getStatus() ? LiquidAmount2.setprepresent() : LiquidAmount2.setpreclear();
      LiquidAmount2.setpreval(LiquidAmount2.getValue());
      LiquidAmount2.setClear();
      wsActive.sethook();
      wsActive.setClear();
      wsActiveRC.sethook();
      wsActiveRC.setClear();
      wsActiveRP.sethook();
      wsActiveRP.setClear();
      bottleTotal.sethook();
      bottleTotal.setClear();
      bottleTotalRC.sethook();
      bottleTotalRC.setClear();
      bottleTotalRP.sethook();
      bottleTotalRP.setClear();
      BatchQuantityRC.sethook();
      BatchQuantityRC.setClear();
      BatchQuantityRP.sethook();
      BatchQuantityRP.setClear();
      LiquidAmount1FP.sethook();
      LiquidAmount1FP.setClear();
      LiquidAmount2FP.sethook();
      LiquidAmount2FP.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        bottleAtPos1M.gethook();
        bottleLeftPos5M.gethook();
        enable.gethook();
        BatchQuantity.gethook();
        LiquidAmount1.gethook();
        LiquidAmount2.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
