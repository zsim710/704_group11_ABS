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
  public Signal enableConvP = new Signal("enableConvP", Signal.OUTPUT);
  public Signal enableCapP = new Signal("enableCapP", Signal.OUTPUT);
  public Signal enableFP = new Signal("enableFP", Signal.OUTPUT);
  public Signal enableRP = new Signal("enableRP", Signal.OUTPUT);
  public Signal enableLL = new Signal("enableLL", Signal.OUTPUT);
  public Signal wsActive = new Signal("wsActive", Signal.OUTPUT);
  public Signal wsActiveRC = new Signal("wsActiveRC", Signal.OUTPUT);
  public Signal wsActiveRP = new Signal("wsActiveRP", Signal.OUTPUT);
  public Signal wsActiveConvC = new Signal("wsActiveConvC", Signal.OUTPUT);
  public Signal bottleTotal = new Signal("bottleTotal", Signal.OUTPUT);
  public Signal bottleTotalRC = new Signal("bottleTotalRC", Signal.OUTPUT);
  public Signal bottleTotalRP = new Signal("bottleTotalRP", Signal.OUTPUT);
  public Signal bottleTotalConvC = new Signal("bottleTotalConvC", Signal.OUTPUT);
  public Signal BatchQuantityRC = new Signal("BatchQuantityRC", Signal.OUTPUT);
  public Signal BatchQuantityRP = new Signal("BatchQuantityRP", Signal.OUTPUT);
  public Signal BatchQuantityConvC = new Signal("BatchQuantityConvC", Signal.OUTPUT);
  public Signal LiquidAmount1FC = new Signal("LiquidAmount1FC", Signal.OUTPUT);
  public Signal LiquidAmount2FC = new Signal("LiquidAmount2FC", Signal.OUTPUT);
  private int S5515 = 1;
  private int S4178 = 1;
  private int S4294 = 1;
  private int S4293 = 1;
  private int S4299 = 1;
  private int S5513 = 1;
  private int S4300 = 1;
  
  private int[] ends = new int[6];
  private int[] tdone = new int[6];
  
  public void thread5525(int [] tdone, int [] ends){
        switch(S5513){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S4300){
          case 0 : 
            S4300=0;
            S4300=1;
            active[5]=1;
            ends[5]=1;
            tdone[5]=1;
            break;
          
          case 1 : 
            S4300=1;
            System.out.println("2");//sysj\MainController.sysj line: 71, column: 4
            if(enable.getprestatus()){//sysj\MainController.sysj line: 72, column: 12
              System.out.println("3");//sysj\MainController.sysj line: 73, column: 5
              if((Integer)(bottleTotalRP.getpreval() == null ? null : ((Integer)bottleTotalRP.getpreval())) < (Integer)(BatchQuantityRP.getpreval() == null ? null : ((Integer)BatchQuantityRP.getpreval()))){//sysj\MainController.sysj line: 74, column: 9
                System.out.println("4");//sysj\MainController.sysj line: 75, column: 6
                if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 2){//sysj\MainController.sysj line: 76, column: 9
                  enableConvP.setPresent();//sysj\MainController.sysj line: 77, column: 7
                  currsigs.addElement(enableConvP);
                  enableFP.setPresent();//sysj\MainController.sysj line: 78, column: 7
                  currsigs.addElement(enableFP);
                  enableRP.setPresent();//sysj\MainController.sysj line: 79, column: 7
                  currsigs.addElement(enableRP);
                  System.out.println("1");//sysj\MainController.sysj line: 68, column: 4
                  S4300=0;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 3){//sysj\MainController.sysj line: 82, column: 14
                    enableConvP.setPresent();//sysj\MainController.sysj line: 83, column: 7
                    currsigs.addElement(enableConvP);
                    enableFP.setPresent();//sysj\MainController.sysj line: 84, column: 7
                    currsigs.addElement(enableFP);
                    enableRP.setPresent();//sysj\MainController.sysj line: 85, column: 7
                    currsigs.addElement(enableRP);
                    enableLL.setPresent();//sysj\MainController.sysj line: 86, column: 7
                    currsigs.addElement(enableLL);
                    System.out.println("1");//sysj\MainController.sysj line: 68, column: 4
                    S4300=0;
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  else {
                    if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 4){//sysj\MainController.sysj line: 88, column: 14
                      enableFP.setPresent();//sysj\MainController.sysj line: 89, column: 7
                      currsigs.addElement(enableFP);
                      enableCapP.setPresent();//sysj\MainController.sysj line: 90, column: 7
                      currsigs.addElement(enableCapP);
                      enableConvP.setPresent();//sysj\MainController.sysj line: 91, column: 7
                      currsigs.addElement(enableConvP);
                      enableRP.setPresent();//sysj\MainController.sysj line: 92, column: 7
                      currsigs.addElement(enableRP);
                      enableLL.setPresent();//sysj\MainController.sysj line: 93, column: 7
                      currsigs.addElement(enableLL);
                      System.out.println("1");//sysj\MainController.sysj line: 68, column: 4
                      S4300=0;
                      active[5]=1;
                      ends[5]=1;
                      tdone[5]=1;
                    }
                    else {
                      System.out.println("5");//sysj\MainController.sysj line: 96, column: 7
                      enableConvP.setPresent();//sysj\MainController.sysj line: 97, column: 7
                      currsigs.addElement(enableConvP);
                      System.out.println("1");//sysj\MainController.sysj line: 68, column: 4
                      S4300=0;
                      active[5]=1;
                      ends[5]=1;
                      tdone[5]=1;
                    }
                  }
                }
              }
              else {
                if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 4){//sysj\MainController.sysj line: 102, column: 9
                  enableFP.setPresent();//sysj\MainController.sysj line: 103, column: 7
                  currsigs.addElement(enableFP);
                  enableCapP.setPresent();//sysj\MainController.sysj line: 104, column: 7
                  currsigs.addElement(enableCapP);
                  enableConvP.setPresent();//sysj\MainController.sysj line: 105, column: 7
                  currsigs.addElement(enableConvP);
                  enableRP.setPresent();//sysj\MainController.sysj line: 106, column: 7
                  currsigs.addElement(enableRP);
                  enableLL.setPresent();//sysj\MainController.sysj line: 107, column: 7
                  currsigs.addElement(enableLL);
                  System.out.println("1");//sysj\MainController.sysj line: 68, column: 4
                  S4300=0;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 3){//sysj\MainController.sysj line: 109, column: 14
                    enableCapP.setPresent();//sysj\MainController.sysj line: 110, column: 7
                    currsigs.addElement(enableCapP);
                    enableConvP.setPresent();//sysj\MainController.sysj line: 111, column: 7
                    currsigs.addElement(enableConvP);
                    enableRP.setPresent();//sysj\MainController.sysj line: 112, column: 7
                    currsigs.addElement(enableRP);
                    enableLL.setPresent();//sysj\MainController.sysj line: 113, column: 7
                    currsigs.addElement(enableLL);
                    System.out.println("1");//sysj\MainController.sysj line: 68, column: 4
                    S4300=0;
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  else {
                    if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 2){//sysj\MainController.sysj line: 115, column: 14
                      enableCapP.setPresent();//sysj\MainController.sysj line: 116, column: 7
                      currsigs.addElement(enableCapP);
                      enableConvP.setPresent();//sysj\MainController.sysj line: 117, column: 7
                      currsigs.addElement(enableConvP);
                      enableRP.setPresent();//sysj\MainController.sysj line: 118, column: 7
                      currsigs.addElement(enableRP);
                      System.out.println("1");//sysj\MainController.sysj line: 68, column: 4
                      S4300=0;
                      active[5]=1;
                      ends[5]=1;
                      tdone[5]=1;
                    }
                    else {
                      if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 1){//sysj\MainController.sysj line: 121, column: 14
                        enableConvP.setPresent();//sysj\MainController.sysj line: 122, column: 7
                        currsigs.addElement(enableConvP);
                        enableRP.setPresent();//sysj\MainController.sysj line: 123, column: 7
                        currsigs.addElement(enableRP);
                        System.out.println("1");//sysj\MainController.sysj line: 68, column: 4
                        S4300=0;
                        active[5]=1;
                        ends[5]=1;
                        tdone[5]=1;
                      }
                      else {
                        enableConvP.setPresent();//sysj\MainController.sysj line: 127, column: 7
                        currsigs.addElement(enableConvP);
                        System.out.println("1");//sysj\MainController.sysj line: 68, column: 4
                        S4300=0;
                        active[5]=1;
                        ends[5]=1;
                        tdone[5]=1;
                      }
                    }
                  }
                }
              }
            }
            else {
              System.out.println("1");//sysj\MainController.sysj line: 68, column: 4
              S4300=0;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread5524(int [] tdone, int [] ends){
        switch(S4299){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        System.out.println("emeitting liqs");//sysj\MainController.sysj line: 58, column: 4
        LiquidAmount1FC.setPresent();//sysj\MainController.sysj line: 59, column: 5
        currsigs.addElement(LiquidAmount1FC);
        LiquidAmount2FC.setPresent();//sysj\MainController.sysj line: 60, column: 5
        currsigs.addElement(LiquidAmount2FC);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread5523(int [] tdone, int [] ends){
        switch(S4294){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S4293){
          case 0 : 
            S4293=0;
            S4293=1;
            if(wsActive.getprestatus()){//sysj\MainController.sysj line: 31, column: 12
              System.out.println("emeitting wsActives" + (wsActive.getpreval() == null ? null : ((Integer)wsActive.getpreval())));//sysj\MainController.sysj line: 32, column: 5
              wsActiveRC.setPresent();//sysj\MainController.sysj line: 33, column: 5
              currsigs.addElement(wsActiveRC);
              wsActiveRC.setValue((wsActive.getpreval() == null ? null : ((Integer)wsActive.getpreval())));//sysj\MainController.sysj line: 33, column: 5
              wsActiveRP.setPresent();//sysj\MainController.sysj line: 34, column: 5
              currsigs.addElement(wsActiveRP);
              wsActiveRP.setValue((wsActive.getpreval() == null ? null : ((Integer)wsActive.getpreval())));//sysj\MainController.sysj line: 34, column: 5
              wsActiveConvC.setPresent();//sysj\MainController.sysj line: 35, column: 5
              currsigs.addElement(wsActiveConvC);
              wsActiveConvC.setValue((wsActive.getpreval() == null ? null : ((Integer)wsActive.getpreval())));//sysj\MainController.sysj line: 35, column: 5
              if(bottleTotal.getprestatus()){//sysj\MainController.sysj line: 38, column: 12
                System.out.println("emeitting bottleTotals");//sysj\MainController.sysj line: 39, column: 5
                bottleTotalRC.setPresent();//sysj\MainController.sysj line: 40, column: 5
                currsigs.addElement(bottleTotalRC);
                bottleTotalRC.setValue((bottleTotal.getpreval() == null ? null : ((Integer)bottleTotal.getpreval())));//sysj\MainController.sysj line: 40, column: 5
                bottleTotalRP.setPresent();//sysj\MainController.sysj line: 41, column: 5
                currsigs.addElement(bottleTotalRP);
                bottleTotalRP.setValue((bottleTotal.getpreval() == null ? null : ((Integer)bottleTotal.getpreval())));//sysj\MainController.sysj line: 41, column: 5
                bottleTotalConvC.setPresent();//sysj\MainController.sysj line: 42, column: 5
                currsigs.addElement(bottleTotalConvC);
                bottleTotalConvC.setValue((bottleTotal.getpreval() == null ? null : ((Integer)bottleTotal.getpreval())));//sysj\MainController.sysj line: 42, column: 5
                if(BatchQuantity.getprestatus()){//sysj\MainController.sysj line: 45, column: 12
                  System.out.println("emeitting batchQuants");//sysj\MainController.sysj line: 46, column: 5
                  BatchQuantityRC.setPresent();//sysj\MainController.sysj line: 47, column: 5
                  currsigs.addElement(BatchQuantityRC);
                  BatchQuantityRC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 47, column: 5
                  BatchQuantityRP.setPresent();//sysj\MainController.sysj line: 48, column: 5
                  currsigs.addElement(BatchQuantityRP);
                  BatchQuantityRP.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 48, column: 5
                  BatchQuantityConvC.setPresent();//sysj\MainController.sysj line: 49, column: 5
                  currsigs.addElement(BatchQuantityConvC);
                  BatchQuantityConvC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 49, column: 5
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
                if(BatchQuantity.getprestatus()){//sysj\MainController.sysj line: 45, column: 12
                  System.out.println("emeitting batchQuants");//sysj\MainController.sysj line: 46, column: 5
                  BatchQuantityRC.setPresent();//sysj\MainController.sysj line: 47, column: 5
                  currsigs.addElement(BatchQuantityRC);
                  BatchQuantityRC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 47, column: 5
                  BatchQuantityRP.setPresent();//sysj\MainController.sysj line: 48, column: 5
                  currsigs.addElement(BatchQuantityRP);
                  BatchQuantityRP.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 48, column: 5
                  BatchQuantityConvC.setPresent();//sysj\MainController.sysj line: 49, column: 5
                  currsigs.addElement(BatchQuantityConvC);
                  BatchQuantityConvC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 49, column: 5
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
              if(bottleTotal.getprestatus()){//sysj\MainController.sysj line: 38, column: 12
                System.out.println("emeitting bottleTotals");//sysj\MainController.sysj line: 39, column: 5
                bottleTotalRC.setPresent();//sysj\MainController.sysj line: 40, column: 5
                currsigs.addElement(bottleTotalRC);
                bottleTotalRC.setValue((bottleTotal.getpreval() == null ? null : ((Integer)bottleTotal.getpreval())));//sysj\MainController.sysj line: 40, column: 5
                bottleTotalRP.setPresent();//sysj\MainController.sysj line: 41, column: 5
                currsigs.addElement(bottleTotalRP);
                bottleTotalRP.setValue((bottleTotal.getpreval() == null ? null : ((Integer)bottleTotal.getpreval())));//sysj\MainController.sysj line: 41, column: 5
                bottleTotalConvC.setPresent();//sysj\MainController.sysj line: 42, column: 5
                currsigs.addElement(bottleTotalConvC);
                bottleTotalConvC.setValue((bottleTotal.getpreval() == null ? null : ((Integer)bottleTotal.getpreval())));//sysj\MainController.sysj line: 42, column: 5
                if(BatchQuantity.getprestatus()){//sysj\MainController.sysj line: 45, column: 12
                  System.out.println("emeitting batchQuants");//sysj\MainController.sysj line: 46, column: 5
                  BatchQuantityRC.setPresent();//sysj\MainController.sysj line: 47, column: 5
                  currsigs.addElement(BatchQuantityRC);
                  BatchQuantityRC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 47, column: 5
                  BatchQuantityRP.setPresent();//sysj\MainController.sysj line: 48, column: 5
                  currsigs.addElement(BatchQuantityRP);
                  BatchQuantityRP.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 48, column: 5
                  BatchQuantityConvC.setPresent();//sysj\MainController.sysj line: 49, column: 5
                  currsigs.addElement(BatchQuantityConvC);
                  BatchQuantityConvC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 49, column: 5
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
                if(BatchQuantity.getprestatus()){//sysj\MainController.sysj line: 45, column: 12
                  System.out.println("emeitting batchQuants");//sysj\MainController.sysj line: 46, column: 5
                  BatchQuantityRC.setPresent();//sysj\MainController.sysj line: 47, column: 5
                  currsigs.addElement(BatchQuantityRC);
                  BatchQuantityRC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 47, column: 5
                  BatchQuantityRP.setPresent();//sysj\MainController.sysj line: 48, column: 5
                  currsigs.addElement(BatchQuantityRP);
                  BatchQuantityRP.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 48, column: 5
                  BatchQuantityConvC.setPresent();//sysj\MainController.sysj line: 49, column: 5
                  currsigs.addElement(BatchQuantityConvC);
                  BatchQuantityConvC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 49, column: 5
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
          
          case 1 : 
            if(wsActive.getprestatus()){//sysj\MainController.sysj line: 31, column: 12
              System.out.println("emeitting wsActives" + (wsActive.getpreval() == null ? null : ((Integer)wsActive.getpreval())));//sysj\MainController.sysj line: 32, column: 5
              wsActiveRC.setPresent();//sysj\MainController.sysj line: 33, column: 5
              currsigs.addElement(wsActiveRC);
              wsActiveRC.setValue((wsActive.getpreval() == null ? null : ((Integer)wsActive.getpreval())));//sysj\MainController.sysj line: 33, column: 5
              wsActiveRP.setPresent();//sysj\MainController.sysj line: 34, column: 5
              currsigs.addElement(wsActiveRP);
              wsActiveRP.setValue((wsActive.getpreval() == null ? null : ((Integer)wsActive.getpreval())));//sysj\MainController.sysj line: 34, column: 5
              wsActiveConvC.setPresent();//sysj\MainController.sysj line: 35, column: 5
              currsigs.addElement(wsActiveConvC);
              wsActiveConvC.setValue((wsActive.getpreval() == null ? null : ((Integer)wsActive.getpreval())));//sysj\MainController.sysj line: 35, column: 5
              if(bottleTotal.getprestatus()){//sysj\MainController.sysj line: 38, column: 12
                System.out.println("emeitting bottleTotals");//sysj\MainController.sysj line: 39, column: 5
                bottleTotalRC.setPresent();//sysj\MainController.sysj line: 40, column: 5
                currsigs.addElement(bottleTotalRC);
                bottleTotalRC.setValue((bottleTotal.getpreval() == null ? null : ((Integer)bottleTotal.getpreval())));//sysj\MainController.sysj line: 40, column: 5
                bottleTotalRP.setPresent();//sysj\MainController.sysj line: 41, column: 5
                currsigs.addElement(bottleTotalRP);
                bottleTotalRP.setValue((bottleTotal.getpreval() == null ? null : ((Integer)bottleTotal.getpreval())));//sysj\MainController.sysj line: 41, column: 5
                bottleTotalConvC.setPresent();//sysj\MainController.sysj line: 42, column: 5
                currsigs.addElement(bottleTotalConvC);
                bottleTotalConvC.setValue((bottleTotal.getpreval() == null ? null : ((Integer)bottleTotal.getpreval())));//sysj\MainController.sysj line: 42, column: 5
                if(BatchQuantity.getprestatus()){//sysj\MainController.sysj line: 45, column: 12
                  System.out.println("emeitting batchQuants");//sysj\MainController.sysj line: 46, column: 5
                  BatchQuantityRC.setPresent();//sysj\MainController.sysj line: 47, column: 5
                  currsigs.addElement(BatchQuantityRC);
                  BatchQuantityRC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 47, column: 5
                  BatchQuantityRP.setPresent();//sysj\MainController.sysj line: 48, column: 5
                  currsigs.addElement(BatchQuantityRP);
                  BatchQuantityRP.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 48, column: 5
                  BatchQuantityConvC.setPresent();//sysj\MainController.sysj line: 49, column: 5
                  currsigs.addElement(BatchQuantityConvC);
                  BatchQuantityConvC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 49, column: 5
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
                if(BatchQuantity.getprestatus()){//sysj\MainController.sysj line: 45, column: 12
                  System.out.println("emeitting batchQuants");//sysj\MainController.sysj line: 46, column: 5
                  BatchQuantityRC.setPresent();//sysj\MainController.sysj line: 47, column: 5
                  currsigs.addElement(BatchQuantityRC);
                  BatchQuantityRC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 47, column: 5
                  BatchQuantityRP.setPresent();//sysj\MainController.sysj line: 48, column: 5
                  currsigs.addElement(BatchQuantityRP);
                  BatchQuantityRP.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 48, column: 5
                  BatchQuantityConvC.setPresent();//sysj\MainController.sysj line: 49, column: 5
                  currsigs.addElement(BatchQuantityConvC);
                  BatchQuantityConvC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 49, column: 5
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
              if(bottleTotal.getprestatus()){//sysj\MainController.sysj line: 38, column: 12
                System.out.println("emeitting bottleTotals");//sysj\MainController.sysj line: 39, column: 5
                bottleTotalRC.setPresent();//sysj\MainController.sysj line: 40, column: 5
                currsigs.addElement(bottleTotalRC);
                bottleTotalRC.setValue((bottleTotal.getpreval() == null ? null : ((Integer)bottleTotal.getpreval())));//sysj\MainController.sysj line: 40, column: 5
                bottleTotalRP.setPresent();//sysj\MainController.sysj line: 41, column: 5
                currsigs.addElement(bottleTotalRP);
                bottleTotalRP.setValue((bottleTotal.getpreval() == null ? null : ((Integer)bottleTotal.getpreval())));//sysj\MainController.sysj line: 41, column: 5
                bottleTotalConvC.setPresent();//sysj\MainController.sysj line: 42, column: 5
                currsigs.addElement(bottleTotalConvC);
                bottleTotalConvC.setValue((bottleTotal.getpreval() == null ? null : ((Integer)bottleTotal.getpreval())));//sysj\MainController.sysj line: 42, column: 5
                if(BatchQuantity.getprestatus()){//sysj\MainController.sysj line: 45, column: 12
                  System.out.println("emeitting batchQuants");//sysj\MainController.sysj line: 46, column: 5
                  BatchQuantityRC.setPresent();//sysj\MainController.sysj line: 47, column: 5
                  currsigs.addElement(BatchQuantityRC);
                  BatchQuantityRC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 47, column: 5
                  BatchQuantityRP.setPresent();//sysj\MainController.sysj line: 48, column: 5
                  currsigs.addElement(BatchQuantityRP);
                  BatchQuantityRP.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 48, column: 5
                  BatchQuantityConvC.setPresent();//sysj\MainController.sysj line: 49, column: 5
                  currsigs.addElement(BatchQuantityConvC);
                  BatchQuantityConvC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 49, column: 5
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
                if(BatchQuantity.getprestatus()){//sysj\MainController.sysj line: 45, column: 12
                  System.out.println("emeitting batchQuants");//sysj\MainController.sysj line: 46, column: 5
                  BatchQuantityRC.setPresent();//sysj\MainController.sysj line: 47, column: 5
                  currsigs.addElement(BatchQuantityRC);
                  BatchQuantityRC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 47, column: 5
                  BatchQuantityRP.setPresent();//sysj\MainController.sysj line: 48, column: 5
                  currsigs.addElement(BatchQuantityRP);
                  BatchQuantityRP.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 48, column: 5
                  BatchQuantityConvC.setPresent();//sysj\MainController.sysj line: 49, column: 5
                  currsigs.addElement(BatchQuantityConvC);
                  BatchQuantityConvC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 49, column: 5
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
        break;
      
    }
  }

  public void thread5522(int [] tdone, int [] ends){
        switch(S4178){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(bottleAtPos1M.getprestatus()){//sysj\MainController.sysj line: 13, column: 13
          System.out.println("received bottleAtPos1M");//sysj\MainController.sysj line: 14, column: 6
          wsActive.setPresent();//sysj\MainController.sysj line: 15, column: 6
          currsigs.addElement(wsActive);
          wsActive.setValue((Integer)(wsActive.getpreval() == null ? null : ((Integer)wsActive.getpreval())) + 1);//sysj\MainController.sysj line: 15, column: 6
          System.out.println("wsActive" + (wsActive.getpreval() == null ? null : ((Integer)wsActive.getpreval())));//sysj\MainController.sysj line: 16, column: 6
          bottleTotal.setPresent();//sysj\MainController.sysj line: 17, column: 6
          currsigs.addElement(bottleTotal);
          bottleTotal.setValue((Integer)(bottleTotal.getpreval() == null ? null : ((Integer)bottleTotal.getpreval())) + 1);//sysj\MainController.sysj line: 17, column: 6
          System.out.println("bottleTotal" + (bottleTotal.getpreval() == null ? null : ((Integer)bottleTotal.getpreval())));//sysj\MainController.sysj line: 18, column: 6
          if(bottleLeftPos5M.getprestatus()){//sysj\MainController.sysj line: 21, column: 13
            wsActive.setPresent();//sysj\MainController.sysj line: 22, column: 6
            currsigs.addElement(wsActive);
            wsActive.setValue((Integer)(wsActive.getpreval() == null ? null : ((Integer)wsActive.getpreval())) - 1);//sysj\MainController.sysj line: 22, column: 6
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
          if(bottleLeftPos5M.getprestatus()){//sysj\MainController.sysj line: 21, column: 13
            wsActive.setPresent();//sysj\MainController.sysj line: 22, column: 6
            currsigs.addElement(wsActive);
            wsActive.setValue((Integer)(wsActive.getpreval() == null ? null : ((Integer)wsActive.getpreval())) - 1);//sysj\MainController.sysj line: 22, column: 6
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

  public void thread5520(int [] tdone, int [] ends){
        S5513=1;
    System.out.println("1");//sysj\MainController.sysj line: 68, column: 4
    S4300=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread5519(int [] tdone, int [] ends){
        S4299=1;
    System.out.println("emeitting liqs");//sysj\MainController.sysj line: 58, column: 4
    LiquidAmount1FC.setPresent();//sysj\MainController.sysj line: 59, column: 5
    currsigs.addElement(LiquidAmount1FC);
    LiquidAmount2FC.setPresent();//sysj\MainController.sysj line: 60, column: 5
    currsigs.addElement(LiquidAmount2FC);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread5518(int [] tdone, int [] ends){
        S4294=1;
    S4293=0;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread5517(int [] tdone, int [] ends){
        S4178=1;
    wsActive.setPresent();//sysj\MainController.sysj line: 8, column: 3
    currsigs.addElement(wsActive);
    wsActive.setValue(0);//sysj\MainController.sysj line: 8, column: 3
    bottleTotal.setPresent();//sysj\MainController.sysj line: 9, column: 3
    currsigs.addElement(bottleTotal);
    bottleTotal.setValue(0);//sysj\MainController.sysj line: 9, column: 3
    if(bottleAtPos1M.getprestatus()){//sysj\MainController.sysj line: 13, column: 13
      System.out.println("received bottleAtPos1M");//sysj\MainController.sysj line: 14, column: 6
      wsActive.setPresent();//sysj\MainController.sysj line: 15, column: 6
      currsigs.addElement(wsActive);
      wsActive.setValue((Integer)(wsActive.getpreval() == null ? null : ((Integer)wsActive.getpreval())) + 1);//sysj\MainController.sysj line: 15, column: 6
      System.out.println("wsActive" + (wsActive.getpreval() == null ? null : ((Integer)wsActive.getpreval())));//sysj\MainController.sysj line: 16, column: 6
      bottleTotal.setPresent();//sysj\MainController.sysj line: 17, column: 6
      currsigs.addElement(bottleTotal);
      bottleTotal.setValue((Integer)(bottleTotal.getpreval() == null ? null : ((Integer)bottleTotal.getpreval())) + 1);//sysj\MainController.sysj line: 17, column: 6
      System.out.println("bottleTotal" + (bottleTotal.getpreval() == null ? null : ((Integer)bottleTotal.getpreval())));//sysj\MainController.sysj line: 18, column: 6
      if(bottleLeftPos5M.getprestatus()){//sysj\MainController.sysj line: 21, column: 13
        wsActive.setPresent();//sysj\MainController.sysj line: 22, column: 6
        currsigs.addElement(wsActive);
        wsActive.setValue((Integer)(wsActive.getpreval() == null ? null : ((Integer)wsActive.getpreval())) - 1);//sysj\MainController.sysj line: 22, column: 6
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
      if(bottleLeftPos5M.getprestatus()){//sysj\MainController.sysj line: 21, column: 13
        wsActive.setPresent();//sysj\MainController.sysj line: 22, column: 6
        currsigs.addElement(wsActive);
        wsActive.setValue((Integer)(wsActive.getpreval() == null ? null : ((Integer)wsActive.getpreval())) - 1);//sysj\MainController.sysj line: 22, column: 6
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
      switch(S5515){
        case 0 : 
          S5515=0;
          break RUN;
        
        case 1 : 
          S5515=2;
          S5515=2;
          thread5517(tdone,ends);
          thread5518(tdone,ends);
          thread5519(tdone,ends);
          thread5520(tdone,ends);
          int biggest5521 = 0;
          if(ends[2]>=biggest5521){
            biggest5521=ends[2];
          }
          if(ends[3]>=biggest5521){
            biggest5521=ends[3];
          }
          if(ends[4]>=biggest5521){
            biggest5521=ends[4];
          }
          if(ends[5]>=biggest5521){
            biggest5521=ends[5];
          }
          if(biggest5521 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread5522(tdone,ends);
          thread5523(tdone,ends);
          thread5524(tdone,ends);
          thread5525(tdone,ends);
          int biggest5526 = 0;
          if(ends[2]>=biggest5526){
            biggest5526=ends[2];
          }
          if(ends[3]>=biggest5526){
            biggest5526=ends[3];
          }
          if(ends[4]>=biggest5526){
            biggest5526=ends[4];
          }
          if(ends[5]>=biggest5526){
            biggest5526=ends[5];
          }
          if(biggest5526 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest5526 == 0){
            S5515=0;
            active[1]=0;
            ends[1]=0;
            S5515=0;
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
      enableConvP.setpreclear();
      enableCapP.setpreclear();
      enableFP.setpreclear();
      enableRP.setpreclear();
      enableLL.setpreclear();
      wsActive.setpreclear();
      wsActiveRC.setpreclear();
      wsActiveRP.setpreclear();
      wsActiveConvC.setpreclear();
      bottleTotal.setpreclear();
      bottleTotalRC.setpreclear();
      bottleTotalRP.setpreclear();
      bottleTotalConvC.setpreclear();
      BatchQuantityRC.setpreclear();
      BatchQuantityRP.setpreclear();
      BatchQuantityConvC.setpreclear();
      LiquidAmount1FC.setpreclear();
      LiquidAmount2FC.setpreclear();
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
      enableConvP.sethook();
      enableConvP.setClear();
      enableCapP.sethook();
      enableCapP.setClear();
      enableFP.sethook();
      enableFP.setClear();
      enableRP.sethook();
      enableRP.setClear();
      enableLL.sethook();
      enableLL.setClear();
      wsActive.sethook();
      wsActive.setClear();
      wsActiveRC.sethook();
      wsActiveRC.setClear();
      wsActiveRP.sethook();
      wsActiveRP.setClear();
      wsActiveConvC.sethook();
      wsActiveConvC.setClear();
      bottleTotal.sethook();
      bottleTotal.setClear();
      bottleTotalRC.sethook();
      bottleTotalRC.setClear();
      bottleTotalRP.sethook();
      bottleTotalRP.setClear();
      bottleTotalConvC.sethook();
      bottleTotalConvC.setClear();
      BatchQuantityRC.sethook();
      BatchQuantityRC.setClear();
      BatchQuantityRP.sethook();
      BatchQuantityRP.setClear();
      BatchQuantityConvC.sethook();
      BatchQuantityConvC.setClear();
      LiquidAmount1FC.sethook();
      LiquidAmount1FC.setClear();
      LiquidAmount2FC.sethook();
      LiquidAmount2FC.setClear();
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
