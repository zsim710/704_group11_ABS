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
  public Signal posOrder = new Signal("posOrder", Signal.INPUT);
  public Signal rotatedM = new Signal("rotatedM", Signal.INPUT);
  public Signal BatchQuantity = new Signal("BatchQuantity", Signal.INPUT);
  public Signal LiquidAmount1 = new Signal("LiquidAmount1", Signal.INPUT);
  public Signal LiquidAmount2 = new Signal("LiquidAmount2", Signal.INPUT);
  public Signal wsActiveRC = new Signal("wsActiveRC", Signal.OUTPUT);
  public Signal wsActiveRP = new Signal("wsActiveRP", Signal.OUTPUT);
  public Signal wsActiveConvC = new Signal("wsActiveConvC", Signal.OUTPUT);
  public Signal bottleTotalRC = new Signal("bottleTotalRC", Signal.OUTPUT);
  public Signal bottleTotalRP = new Signal("bottleTotalRP", Signal.OUTPUT);
  public Signal bottleTotalConvC = new Signal("bottleTotalConvC", Signal.OUTPUT);
  public Signal BatchQuantityRC = new Signal("BatchQuantityRC", Signal.OUTPUT);
  public Signal BatchQuantityRP = new Signal("BatchQuantityRP", Signal.OUTPUT);
  public Signal BatchQuantityConvC = new Signal("BatchQuantityConvC", Signal.OUTPUT);
  public Signal LiquidAmount1FC = new Signal("LiquidAmount1FC", Signal.OUTPUT);
  public Signal LiquidAmount2FC = new Signal("LiquidAmount2FC", Signal.OUTPUT);
  public Signal start_conveyor = new Signal("start_conveyor", Signal.OUTPUT);
  private Signal bottleTotal_1;
  private Signal wsActive_1;
  private int S4439 = 1;
  private int S4157 = 1;
  private int S4188 = 1;
  private int S4247 = 1;
  private int S4252 = 1;
  
  private int[] ends = new int[5];
  private int[] tdone = new int[5];
  
  public void thread4451(int [] tdone, int [] ends){
        switch(S4252){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        System.out.println("emitting liqs");//sysj\MainController.sysj line: 69, column: 4
        LiquidAmount1FC.setPresent();//sysj\MainController.sysj line: 70, column: 5
        currsigs.addElement(LiquidAmount1FC);
        LiquidAmount2FC.setPresent();//sysj\MainController.sysj line: 71, column: 5
        currsigs.addElement(LiquidAmount2FC);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread4450(int [] tdone, int [] ends){
        switch(S4247){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        if(wsActive_1.getprestatus()){//sysj\MainController.sysj line: 42, column: 12
          System.out.println("emitting wsActives" + (wsActive_1.getpreval() == null ? 0 : ((Integer)wsActive_1.getpreval()).intValue()));//sysj\MainController.sysj line: 43, column: 5
          wsActiveRC.setPresent();//sysj\MainController.sysj line: 44, column: 5
          currsigs.addElement(wsActiveRC);
          wsActiveRC.setValue((wsActive_1.getpreval() == null ? 0 : ((Integer)wsActive_1.getpreval()).intValue()));//sysj\MainController.sysj line: 44, column: 5
          wsActiveRP.setPresent();//sysj\MainController.sysj line: 45, column: 5
          currsigs.addElement(wsActiveRP);
          wsActiveRP.setValue((wsActive_1.getpreval() == null ? 0 : ((Integer)wsActive_1.getpreval()).intValue()));//sysj\MainController.sysj line: 45, column: 5
          wsActiveConvC.setPresent();//sysj\MainController.sysj line: 46, column: 5
          currsigs.addElement(wsActiveConvC);
          wsActiveConvC.setValue((wsActive_1.getpreval() == null ? 0 : ((Integer)wsActive_1.getpreval()).intValue()));//sysj\MainController.sysj line: 46, column: 5
          if(bottleTotal_1.getprestatus()){//sysj\MainController.sysj line: 49, column: 12
            System.out.println("emitting bottleTotals");//sysj\MainController.sysj line: 50, column: 5
            bottleTotalRC.setPresent();//sysj\MainController.sysj line: 51, column: 5
            currsigs.addElement(bottleTotalRC);
            bottleTotalRC.setValue((bottleTotal_1.getpreval() == null ? 0 : ((Integer)bottleTotal_1.getpreval()).intValue()));//sysj\MainController.sysj line: 51, column: 5
            bottleTotalRP.setPresent();//sysj\MainController.sysj line: 52, column: 5
            currsigs.addElement(bottleTotalRP);
            bottleTotalRP.setValue((bottleTotal_1.getpreval() == null ? 0 : ((Integer)bottleTotal_1.getpreval()).intValue()));//sysj\MainController.sysj line: 52, column: 5
            bottleTotalConvC.setPresent();//sysj\MainController.sysj line: 53, column: 5
            currsigs.addElement(bottleTotalConvC);
            bottleTotalConvC.setValue((bottleTotal_1.getpreval() == null ? 0 : ((Integer)bottleTotal_1.getpreval()).intValue()));//sysj\MainController.sysj line: 53, column: 5
            if(BatchQuantity.getprestatus()){//sysj\MainController.sysj line: 56, column: 12
              System.out.println("emitting batchQuants");//sysj\MainController.sysj line: 57, column: 5
              BatchQuantityRC.setPresent();//sysj\MainController.sysj line: 58, column: 5
              currsigs.addElement(BatchQuantityRC);
              BatchQuantityRC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 58, column: 5
              BatchQuantityRP.setPresent();//sysj\MainController.sysj line: 59, column: 5
              currsigs.addElement(BatchQuantityRP);
              BatchQuantityRP.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 59, column: 5
              BatchQuantityConvC.setPresent();//sysj\MainController.sysj line: 60, column: 5
              currsigs.addElement(BatchQuantityConvC);
              BatchQuantityConvC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 60, column: 5
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
            if(BatchQuantity.getprestatus()){//sysj\MainController.sysj line: 56, column: 12
              System.out.println("emitting batchQuants");//sysj\MainController.sysj line: 57, column: 5
              BatchQuantityRC.setPresent();//sysj\MainController.sysj line: 58, column: 5
              currsigs.addElement(BatchQuantityRC);
              BatchQuantityRC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 58, column: 5
              BatchQuantityRP.setPresent();//sysj\MainController.sysj line: 59, column: 5
              currsigs.addElement(BatchQuantityRP);
              BatchQuantityRP.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 59, column: 5
              BatchQuantityConvC.setPresent();//sysj\MainController.sysj line: 60, column: 5
              currsigs.addElement(BatchQuantityConvC);
              BatchQuantityConvC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 60, column: 5
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
          if(bottleTotal_1.getprestatus()){//sysj\MainController.sysj line: 49, column: 12
            System.out.println("emitting bottleTotals");//sysj\MainController.sysj line: 50, column: 5
            bottleTotalRC.setPresent();//sysj\MainController.sysj line: 51, column: 5
            currsigs.addElement(bottleTotalRC);
            bottleTotalRC.setValue((bottleTotal_1.getpreval() == null ? 0 : ((Integer)bottleTotal_1.getpreval()).intValue()));//sysj\MainController.sysj line: 51, column: 5
            bottleTotalRP.setPresent();//sysj\MainController.sysj line: 52, column: 5
            currsigs.addElement(bottleTotalRP);
            bottleTotalRP.setValue((bottleTotal_1.getpreval() == null ? 0 : ((Integer)bottleTotal_1.getpreval()).intValue()));//sysj\MainController.sysj line: 52, column: 5
            bottleTotalConvC.setPresent();//sysj\MainController.sysj line: 53, column: 5
            currsigs.addElement(bottleTotalConvC);
            bottleTotalConvC.setValue((bottleTotal_1.getpreval() == null ? 0 : ((Integer)bottleTotal_1.getpreval()).intValue()));//sysj\MainController.sysj line: 53, column: 5
            if(BatchQuantity.getprestatus()){//sysj\MainController.sysj line: 56, column: 12
              System.out.println("emitting batchQuants");//sysj\MainController.sysj line: 57, column: 5
              BatchQuantityRC.setPresent();//sysj\MainController.sysj line: 58, column: 5
              currsigs.addElement(BatchQuantityRC);
              BatchQuantityRC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 58, column: 5
              BatchQuantityRP.setPresent();//sysj\MainController.sysj line: 59, column: 5
              currsigs.addElement(BatchQuantityRP);
              BatchQuantityRP.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 59, column: 5
              BatchQuantityConvC.setPresent();//sysj\MainController.sysj line: 60, column: 5
              currsigs.addElement(BatchQuantityConvC);
              BatchQuantityConvC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 60, column: 5
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
            if(BatchQuantity.getprestatus()){//sysj\MainController.sysj line: 56, column: 12
              System.out.println("emitting batchQuants");//sysj\MainController.sysj line: 57, column: 5
              BatchQuantityRC.setPresent();//sysj\MainController.sysj line: 58, column: 5
              currsigs.addElement(BatchQuantityRC);
              BatchQuantityRC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 58, column: 5
              BatchQuantityRP.setPresent();//sysj\MainController.sysj line: 59, column: 5
              currsigs.addElement(BatchQuantityRP);
              BatchQuantityRP.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 59, column: 5
              BatchQuantityConvC.setPresent();//sysj\MainController.sysj line: 60, column: 5
              currsigs.addElement(BatchQuantityConvC);
              BatchQuantityConvC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 60, column: 5
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

  public void thread4449(int [] tdone, int [] ends){
        switch(S4188){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(rotatedM.getprestatus()){//sysj\MainController.sysj line: 21, column: 13
          System.out.println("received rotatedM");//sysj\MainController.sysj line: 23, column: 6
          wsActive_1.setPresent();//sysj\MainController.sysj line: 25, column: 6
          currsigs.addElement(wsActive_1);
          wsActive_1.setValue((Integer)(wsActive_1.getpreval() == null ? 0 : ((Integer)wsActive_1.getpreval()).intValue()) + 1);//sysj\MainController.sysj line: 25, column: 6
          System.out.println("wsActive" + (wsActive_1.getpreval() == null ? 0 : ((Integer)wsActive_1.getpreval()).intValue()));//sysj\MainController.sysj line: 26, column: 6
          bottleTotal_1.setPresent();//sysj\MainController.sysj line: 28, column: 6
          currsigs.addElement(bottleTotal_1);
          bottleTotal_1.setValue((Integer)(bottleTotal_1.getpreval() == null ? 0 : ((Integer)bottleTotal_1.getpreval()).intValue()) + 1);//sysj\MainController.sysj line: 28, column: 6
          System.out.println("bottleTotal" + (bottleTotal_1.getpreval() == null ? 0 : ((Integer)bottleTotal_1.getpreval()).intValue()));//sysj\MainController.sysj line: 29, column: 6
          if(bottleLeftPos5M.getprestatus()){//sysj\MainController.sysj line: 32, column: 13
            wsActive_1.setPresent();//sysj\MainController.sysj line: 33, column: 6
            currsigs.addElement(wsActive_1);
            wsActive_1.setValue((Integer)(wsActive_1.getpreval() == null ? 0 : ((Integer)wsActive_1.getpreval()).intValue()) - 1);//sysj\MainController.sysj line: 33, column: 6
            System.out.println("decremented wsActive");//sysj\MainController.sysj line: 34, column: 6
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
          if(bottleLeftPos5M.getprestatus()){//sysj\MainController.sysj line: 32, column: 13
            wsActive_1.setPresent();//sysj\MainController.sysj line: 33, column: 6
            currsigs.addElement(wsActive_1);
            wsActive_1.setValue((Integer)(wsActive_1.getpreval() == null ? 0 : ((Integer)wsActive_1.getpreval()).intValue()) - 1);//sysj\MainController.sysj line: 33, column: 6
            System.out.println("decremented wsActive");//sysj\MainController.sysj line: 34, column: 6
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

  public void thread4447(int [] tdone, int [] ends){
        S4252=1;
    System.out.println("emitting liqs");//sysj\MainController.sysj line: 69, column: 4
    LiquidAmount1FC.setPresent();//sysj\MainController.sysj line: 70, column: 5
    currsigs.addElement(LiquidAmount1FC);
    LiquidAmount2FC.setPresent();//sysj\MainController.sysj line: 71, column: 5
    currsigs.addElement(LiquidAmount2FC);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread4446(int [] tdone, int [] ends){
        S4247=1;
    if(wsActive_1.getprestatus()){//sysj\MainController.sysj line: 42, column: 12
      System.out.println("emitting wsActives" + (wsActive_1.getpreval() == null ? 0 : ((Integer)wsActive_1.getpreval()).intValue()));//sysj\MainController.sysj line: 43, column: 5
      wsActiveRC.setPresent();//sysj\MainController.sysj line: 44, column: 5
      currsigs.addElement(wsActiveRC);
      wsActiveRC.setValue((wsActive_1.getpreval() == null ? 0 : ((Integer)wsActive_1.getpreval()).intValue()));//sysj\MainController.sysj line: 44, column: 5
      wsActiveRP.setPresent();//sysj\MainController.sysj line: 45, column: 5
      currsigs.addElement(wsActiveRP);
      wsActiveRP.setValue((wsActive_1.getpreval() == null ? 0 : ((Integer)wsActive_1.getpreval()).intValue()));//sysj\MainController.sysj line: 45, column: 5
      wsActiveConvC.setPresent();//sysj\MainController.sysj line: 46, column: 5
      currsigs.addElement(wsActiveConvC);
      wsActiveConvC.setValue((wsActive_1.getpreval() == null ? 0 : ((Integer)wsActive_1.getpreval()).intValue()));//sysj\MainController.sysj line: 46, column: 5
      if(bottleTotal_1.getprestatus()){//sysj\MainController.sysj line: 49, column: 12
        System.out.println("emitting bottleTotals");//sysj\MainController.sysj line: 50, column: 5
        bottleTotalRC.setPresent();//sysj\MainController.sysj line: 51, column: 5
        currsigs.addElement(bottleTotalRC);
        bottleTotalRC.setValue((bottleTotal_1.getpreval() == null ? 0 : ((Integer)bottleTotal_1.getpreval()).intValue()));//sysj\MainController.sysj line: 51, column: 5
        bottleTotalRP.setPresent();//sysj\MainController.sysj line: 52, column: 5
        currsigs.addElement(bottleTotalRP);
        bottleTotalRP.setValue((bottleTotal_1.getpreval() == null ? 0 : ((Integer)bottleTotal_1.getpreval()).intValue()));//sysj\MainController.sysj line: 52, column: 5
        bottleTotalConvC.setPresent();//sysj\MainController.sysj line: 53, column: 5
        currsigs.addElement(bottleTotalConvC);
        bottleTotalConvC.setValue((bottleTotal_1.getpreval() == null ? 0 : ((Integer)bottleTotal_1.getpreval()).intValue()));//sysj\MainController.sysj line: 53, column: 5
        if(BatchQuantity.getprestatus()){//sysj\MainController.sysj line: 56, column: 12
          System.out.println("emitting batchQuants");//sysj\MainController.sysj line: 57, column: 5
          BatchQuantityRC.setPresent();//sysj\MainController.sysj line: 58, column: 5
          currsigs.addElement(BatchQuantityRC);
          BatchQuantityRC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 58, column: 5
          BatchQuantityRP.setPresent();//sysj\MainController.sysj line: 59, column: 5
          currsigs.addElement(BatchQuantityRP);
          BatchQuantityRP.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 59, column: 5
          BatchQuantityConvC.setPresent();//sysj\MainController.sysj line: 60, column: 5
          currsigs.addElement(BatchQuantityConvC);
          BatchQuantityConvC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 60, column: 5
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
        if(BatchQuantity.getprestatus()){//sysj\MainController.sysj line: 56, column: 12
          System.out.println("emitting batchQuants");//sysj\MainController.sysj line: 57, column: 5
          BatchQuantityRC.setPresent();//sysj\MainController.sysj line: 58, column: 5
          currsigs.addElement(BatchQuantityRC);
          BatchQuantityRC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 58, column: 5
          BatchQuantityRP.setPresent();//sysj\MainController.sysj line: 59, column: 5
          currsigs.addElement(BatchQuantityRP);
          BatchQuantityRP.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 59, column: 5
          BatchQuantityConvC.setPresent();//sysj\MainController.sysj line: 60, column: 5
          currsigs.addElement(BatchQuantityConvC);
          BatchQuantityConvC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 60, column: 5
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
      if(bottleTotal_1.getprestatus()){//sysj\MainController.sysj line: 49, column: 12
        System.out.println("emitting bottleTotals");//sysj\MainController.sysj line: 50, column: 5
        bottleTotalRC.setPresent();//sysj\MainController.sysj line: 51, column: 5
        currsigs.addElement(bottleTotalRC);
        bottleTotalRC.setValue((bottleTotal_1.getpreval() == null ? 0 : ((Integer)bottleTotal_1.getpreval()).intValue()));//sysj\MainController.sysj line: 51, column: 5
        bottleTotalRP.setPresent();//sysj\MainController.sysj line: 52, column: 5
        currsigs.addElement(bottleTotalRP);
        bottleTotalRP.setValue((bottleTotal_1.getpreval() == null ? 0 : ((Integer)bottleTotal_1.getpreval()).intValue()));//sysj\MainController.sysj line: 52, column: 5
        bottleTotalConvC.setPresent();//sysj\MainController.sysj line: 53, column: 5
        currsigs.addElement(bottleTotalConvC);
        bottleTotalConvC.setValue((bottleTotal_1.getpreval() == null ? 0 : ((Integer)bottleTotal_1.getpreval()).intValue()));//sysj\MainController.sysj line: 53, column: 5
        if(BatchQuantity.getprestatus()){//sysj\MainController.sysj line: 56, column: 12
          System.out.println("emitting batchQuants");//sysj\MainController.sysj line: 57, column: 5
          BatchQuantityRC.setPresent();//sysj\MainController.sysj line: 58, column: 5
          currsigs.addElement(BatchQuantityRC);
          BatchQuantityRC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 58, column: 5
          BatchQuantityRP.setPresent();//sysj\MainController.sysj line: 59, column: 5
          currsigs.addElement(BatchQuantityRP);
          BatchQuantityRP.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 59, column: 5
          BatchQuantityConvC.setPresent();//sysj\MainController.sysj line: 60, column: 5
          currsigs.addElement(BatchQuantityConvC);
          BatchQuantityConvC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 60, column: 5
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
        if(BatchQuantity.getprestatus()){//sysj\MainController.sysj line: 56, column: 12
          System.out.println("emitting batchQuants");//sysj\MainController.sysj line: 57, column: 5
          BatchQuantityRC.setPresent();//sysj\MainController.sysj line: 58, column: 5
          currsigs.addElement(BatchQuantityRC);
          BatchQuantityRC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 58, column: 5
          BatchQuantityRP.setPresent();//sysj\MainController.sysj line: 59, column: 5
          currsigs.addElement(BatchQuantityRP);
          BatchQuantityRP.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 59, column: 5
          BatchQuantityConvC.setPresent();//sysj\MainController.sysj line: 60, column: 5
          currsigs.addElement(BatchQuantityConvC);
          BatchQuantityConvC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 60, column: 5
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

  public void thread4445(int [] tdone, int [] ends){
        S4188=1;
    if(rotatedM.getprestatus()){//sysj\MainController.sysj line: 21, column: 13
      System.out.println("received rotatedM");//sysj\MainController.sysj line: 23, column: 6
      wsActive_1.setPresent();//sysj\MainController.sysj line: 25, column: 6
      currsigs.addElement(wsActive_1);
      wsActive_1.setValue((Integer)(wsActive_1.getpreval() == null ? 0 : ((Integer)wsActive_1.getpreval()).intValue()) + 1);//sysj\MainController.sysj line: 25, column: 6
      System.out.println("wsActive" + (wsActive_1.getpreval() == null ? 0 : ((Integer)wsActive_1.getpreval()).intValue()));//sysj\MainController.sysj line: 26, column: 6
      bottleTotal_1.setPresent();//sysj\MainController.sysj line: 28, column: 6
      currsigs.addElement(bottleTotal_1);
      bottleTotal_1.setValue((Integer)(bottleTotal_1.getpreval() == null ? 0 : ((Integer)bottleTotal_1.getpreval()).intValue()) + 1);//sysj\MainController.sysj line: 28, column: 6
      System.out.println("bottleTotal" + (bottleTotal_1.getpreval() == null ? 0 : ((Integer)bottleTotal_1.getpreval()).intValue()));//sysj\MainController.sysj line: 29, column: 6
      if(bottleLeftPos5M.getprestatus()){//sysj\MainController.sysj line: 32, column: 13
        wsActive_1.setPresent();//sysj\MainController.sysj line: 33, column: 6
        currsigs.addElement(wsActive_1);
        wsActive_1.setValue((Integer)(wsActive_1.getpreval() == null ? 0 : ((Integer)wsActive_1.getpreval()).intValue()) - 1);//sysj\MainController.sysj line: 33, column: 6
        System.out.println("decremented wsActive");//sysj\MainController.sysj line: 34, column: 6
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
      if(bottleLeftPos5M.getprestatus()){//sysj\MainController.sysj line: 32, column: 13
        wsActive_1.setPresent();//sysj\MainController.sysj line: 33, column: 6
        currsigs.addElement(wsActive_1);
        wsActive_1.setValue((Integer)(wsActive_1.getpreval() == null ? 0 : ((Integer)wsActive_1.getpreval()).intValue()) - 1);//sysj\MainController.sysj line: 33, column: 6
        System.out.println("decremented wsActive");//sysj\MainController.sysj line: 34, column: 6
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

  public void thread4443(int [] tdone, int [] ends){
        S4252=1;
    System.out.println("emitting liqs");//sysj\MainController.sysj line: 69, column: 4
    LiquidAmount1FC.setPresent();//sysj\MainController.sysj line: 70, column: 5
    currsigs.addElement(LiquidAmount1FC);
    LiquidAmount2FC.setPresent();//sysj\MainController.sysj line: 71, column: 5
    currsigs.addElement(LiquidAmount2FC);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread4442(int [] tdone, int [] ends){
        S4247=1;
    if(wsActive_1.getprestatus()){//sysj\MainController.sysj line: 42, column: 12
      System.out.println("emitting wsActives" + (wsActive_1.getpreval() == null ? 0 : ((Integer)wsActive_1.getpreval()).intValue()));//sysj\MainController.sysj line: 43, column: 5
      wsActiveRC.setPresent();//sysj\MainController.sysj line: 44, column: 5
      currsigs.addElement(wsActiveRC);
      wsActiveRC.setValue((wsActive_1.getpreval() == null ? 0 : ((Integer)wsActive_1.getpreval()).intValue()));//sysj\MainController.sysj line: 44, column: 5
      wsActiveRP.setPresent();//sysj\MainController.sysj line: 45, column: 5
      currsigs.addElement(wsActiveRP);
      wsActiveRP.setValue((wsActive_1.getpreval() == null ? 0 : ((Integer)wsActive_1.getpreval()).intValue()));//sysj\MainController.sysj line: 45, column: 5
      wsActiveConvC.setPresent();//sysj\MainController.sysj line: 46, column: 5
      currsigs.addElement(wsActiveConvC);
      wsActiveConvC.setValue((wsActive_1.getpreval() == null ? 0 : ((Integer)wsActive_1.getpreval()).intValue()));//sysj\MainController.sysj line: 46, column: 5
      if(bottleTotal_1.getprestatus()){//sysj\MainController.sysj line: 49, column: 12
        System.out.println("emitting bottleTotals");//sysj\MainController.sysj line: 50, column: 5
        bottleTotalRC.setPresent();//sysj\MainController.sysj line: 51, column: 5
        currsigs.addElement(bottleTotalRC);
        bottleTotalRC.setValue((bottleTotal_1.getpreval() == null ? 0 : ((Integer)bottleTotal_1.getpreval()).intValue()));//sysj\MainController.sysj line: 51, column: 5
        bottleTotalRP.setPresent();//sysj\MainController.sysj line: 52, column: 5
        currsigs.addElement(bottleTotalRP);
        bottleTotalRP.setValue((bottleTotal_1.getpreval() == null ? 0 : ((Integer)bottleTotal_1.getpreval()).intValue()));//sysj\MainController.sysj line: 52, column: 5
        bottleTotalConvC.setPresent();//sysj\MainController.sysj line: 53, column: 5
        currsigs.addElement(bottleTotalConvC);
        bottleTotalConvC.setValue((bottleTotal_1.getpreval() == null ? 0 : ((Integer)bottleTotal_1.getpreval()).intValue()));//sysj\MainController.sysj line: 53, column: 5
        if(BatchQuantity.getprestatus()){//sysj\MainController.sysj line: 56, column: 12
          System.out.println("emitting batchQuants");//sysj\MainController.sysj line: 57, column: 5
          BatchQuantityRC.setPresent();//sysj\MainController.sysj line: 58, column: 5
          currsigs.addElement(BatchQuantityRC);
          BatchQuantityRC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 58, column: 5
          BatchQuantityRP.setPresent();//sysj\MainController.sysj line: 59, column: 5
          currsigs.addElement(BatchQuantityRP);
          BatchQuantityRP.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 59, column: 5
          BatchQuantityConvC.setPresent();//sysj\MainController.sysj line: 60, column: 5
          currsigs.addElement(BatchQuantityConvC);
          BatchQuantityConvC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 60, column: 5
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
        if(BatchQuantity.getprestatus()){//sysj\MainController.sysj line: 56, column: 12
          System.out.println("emitting batchQuants");//sysj\MainController.sysj line: 57, column: 5
          BatchQuantityRC.setPresent();//sysj\MainController.sysj line: 58, column: 5
          currsigs.addElement(BatchQuantityRC);
          BatchQuantityRC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 58, column: 5
          BatchQuantityRP.setPresent();//sysj\MainController.sysj line: 59, column: 5
          currsigs.addElement(BatchQuantityRP);
          BatchQuantityRP.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 59, column: 5
          BatchQuantityConvC.setPresent();//sysj\MainController.sysj line: 60, column: 5
          currsigs.addElement(BatchQuantityConvC);
          BatchQuantityConvC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 60, column: 5
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
      if(bottleTotal_1.getprestatus()){//sysj\MainController.sysj line: 49, column: 12
        System.out.println("emitting bottleTotals");//sysj\MainController.sysj line: 50, column: 5
        bottleTotalRC.setPresent();//sysj\MainController.sysj line: 51, column: 5
        currsigs.addElement(bottleTotalRC);
        bottleTotalRC.setValue((bottleTotal_1.getpreval() == null ? 0 : ((Integer)bottleTotal_1.getpreval()).intValue()));//sysj\MainController.sysj line: 51, column: 5
        bottleTotalRP.setPresent();//sysj\MainController.sysj line: 52, column: 5
        currsigs.addElement(bottleTotalRP);
        bottleTotalRP.setValue((bottleTotal_1.getpreval() == null ? 0 : ((Integer)bottleTotal_1.getpreval()).intValue()));//sysj\MainController.sysj line: 52, column: 5
        bottleTotalConvC.setPresent();//sysj\MainController.sysj line: 53, column: 5
        currsigs.addElement(bottleTotalConvC);
        bottleTotalConvC.setValue((bottleTotal_1.getpreval() == null ? 0 : ((Integer)bottleTotal_1.getpreval()).intValue()));//sysj\MainController.sysj line: 53, column: 5
        if(BatchQuantity.getprestatus()){//sysj\MainController.sysj line: 56, column: 12
          System.out.println("emitting batchQuants");//sysj\MainController.sysj line: 57, column: 5
          BatchQuantityRC.setPresent();//sysj\MainController.sysj line: 58, column: 5
          currsigs.addElement(BatchQuantityRC);
          BatchQuantityRC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 58, column: 5
          BatchQuantityRP.setPresent();//sysj\MainController.sysj line: 59, column: 5
          currsigs.addElement(BatchQuantityRP);
          BatchQuantityRP.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 59, column: 5
          BatchQuantityConvC.setPresent();//sysj\MainController.sysj line: 60, column: 5
          currsigs.addElement(BatchQuantityConvC);
          BatchQuantityConvC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 60, column: 5
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
        if(BatchQuantity.getprestatus()){//sysj\MainController.sysj line: 56, column: 12
          System.out.println("emitting batchQuants");//sysj\MainController.sysj line: 57, column: 5
          BatchQuantityRC.setPresent();//sysj\MainController.sysj line: 58, column: 5
          currsigs.addElement(BatchQuantityRC);
          BatchQuantityRC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 58, column: 5
          BatchQuantityRP.setPresent();//sysj\MainController.sysj line: 59, column: 5
          currsigs.addElement(BatchQuantityRP);
          BatchQuantityRP.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 59, column: 5
          BatchQuantityConvC.setPresent();//sysj\MainController.sysj line: 60, column: 5
          currsigs.addElement(BatchQuantityConvC);
          BatchQuantityConvC.setValue((BatchQuantity.getpreval() == null ? null : ((Integer)BatchQuantity.getpreval())));//sysj\MainController.sysj line: 60, column: 5
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

  public void thread4441(int [] tdone, int [] ends){
        S4188=1;
    if(rotatedM.getprestatus()){//sysj\MainController.sysj line: 21, column: 13
      System.out.println("received rotatedM");//sysj\MainController.sysj line: 23, column: 6
      wsActive_1.setPresent();//sysj\MainController.sysj line: 25, column: 6
      currsigs.addElement(wsActive_1);
      wsActive_1.setValue((Integer)(wsActive_1.getpreval() == null ? 0 : ((Integer)wsActive_1.getpreval()).intValue()) + 1);//sysj\MainController.sysj line: 25, column: 6
      System.out.println("wsActive" + (wsActive_1.getpreval() == null ? 0 : ((Integer)wsActive_1.getpreval()).intValue()));//sysj\MainController.sysj line: 26, column: 6
      bottleTotal_1.setPresent();//sysj\MainController.sysj line: 28, column: 6
      currsigs.addElement(bottleTotal_1);
      bottleTotal_1.setValue((Integer)(bottleTotal_1.getpreval() == null ? 0 : ((Integer)bottleTotal_1.getpreval()).intValue()) + 1);//sysj\MainController.sysj line: 28, column: 6
      System.out.println("bottleTotal" + (bottleTotal_1.getpreval() == null ? 0 : ((Integer)bottleTotal_1.getpreval()).intValue()));//sysj\MainController.sysj line: 29, column: 6
      if(bottleLeftPos5M.getprestatus()){//sysj\MainController.sysj line: 32, column: 13
        wsActive_1.setPresent();//sysj\MainController.sysj line: 33, column: 6
        currsigs.addElement(wsActive_1);
        wsActive_1.setValue((Integer)(wsActive_1.getpreval() == null ? 0 : ((Integer)wsActive_1.getpreval()).intValue()) - 1);//sysj\MainController.sysj line: 33, column: 6
        System.out.println("decremented wsActive");//sysj\MainController.sysj line: 34, column: 6
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
      if(bottleLeftPos5M.getprestatus()){//sysj\MainController.sysj line: 32, column: 13
        wsActive_1.setPresent();//sysj\MainController.sysj line: 33, column: 6
        currsigs.addElement(wsActive_1);
        wsActive_1.setValue((Integer)(wsActive_1.getpreval() == null ? 0 : ((Integer)wsActive_1.getpreval()).intValue()) - 1);//sysj\MainController.sysj line: 33, column: 6
        System.out.println("decremented wsActive");//sysj\MainController.sysj line: 34, column: 6
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
      switch(S4439){
        case 0 : 
          S4439=0;
          break RUN;
        
        case 1 : 
          S4439=2;
          S4439=2;
          bottleTotal_1.setClear();//sysj\MainController.sysj line: 8, column: 1
          wsActive_1.setClear();//sysj\MainController.sysj line: 8, column: 1
          wsActive_1.setPresent();//sysj\MainController.sysj line: 10, column: 1
          currsigs.addElement(wsActive_1);
          wsActive_1.setValue(0);//sysj\MainController.sysj line: 10, column: 1
          bottleTotal_1.setPresent();//sysj\MainController.sysj line: 11, column: 1
          currsigs.addElement(bottleTotal_1);
          bottleTotal_1.setValue(0);//sysj\MainController.sysj line: 11, column: 1
          S4157=0;
          if(posOrder.getprestatus()){//sysj\MainController.sysj line: 13, column: 17
            System.out.println("emiting start conveyor");//sysj\MainController.sysj line: 15, column: 1
            start_conveyor.setPresent();//sysj\MainController.sysj line: 16, column: 1
            currsigs.addElement(start_conveyor);
            S4157=1;
            thread4441(tdone,ends);
            thread4442(tdone,ends);
            thread4443(tdone,ends);
            int biggest4444 = 0;
            if(ends[2]>=biggest4444){
              biggest4444=ends[2];
            }
            if(ends[3]>=biggest4444){
              biggest4444=ends[3];
            }
            if(ends[4]>=biggest4444){
              biggest4444=ends[4];
            }
            if(biggest4444 == 1){
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
          bottleTotal_1.setClear();//sysj\MainController.sysj line: 8, column: 1
          wsActive_1.setClear();//sysj\MainController.sysj line: 8, column: 1
          switch(S4157){
            case 0 : 
              if(posOrder.getprestatus()){//sysj\MainController.sysj line: 13, column: 17
                System.out.println("emiting start conveyor");//sysj\MainController.sysj line: 15, column: 1
                start_conveyor.setPresent();//sysj\MainController.sysj line: 16, column: 1
                currsigs.addElement(start_conveyor);
                S4157=1;
                thread4445(tdone,ends);
                thread4446(tdone,ends);
                thread4447(tdone,ends);
                int biggest4448 = 0;
                if(ends[2]>=biggest4448){
                  biggest4448=ends[2];
                }
                if(ends[3]>=biggest4448){
                  biggest4448=ends[3];
                }
                if(ends[4]>=biggest4448){
                  biggest4448=ends[4];
                }
                if(biggest4448 == 1){
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
            
            case 1 : 
              thread4449(tdone,ends);
              thread4450(tdone,ends);
              thread4451(tdone,ends);
              int biggest4452 = 0;
              if(ends[2]>=biggest4452){
                biggest4452=ends[2];
              }
              if(ends[3]>=biggest4452){
                biggest4452=ends[3];
              }
              if(ends[4]>=biggest4452){
                biggest4452=ends[4];
              }
              if(biggest4452 == 1){
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              //FINXME code
              if(biggest4452 == 0){
                S4439=0;
                active[1]=0;
                ends[1]=0;
                S4439=0;
                break RUN;
              }
            
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    bottleTotal_1 = new Signal();
    wsActive_1 = new Signal();
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
          posOrder.gethook();
          rotatedM.gethook();
          BatchQuantity.gethook();
          LiquidAmount1.gethook();
          LiquidAmount2.gethook();
          df = true;
        }
        runClockDomain();
      }
      bottleAtPos1M.setpreclear();
      bottleLeftPos5M.setpreclear();
      posOrder.setpreclear();
      rotatedM.setpreclear();
      BatchQuantity.setpreclear();
      LiquidAmount1.setpreclear();
      LiquidAmount2.setpreclear();
      wsActiveRC.setpreclear();
      wsActiveRP.setpreclear();
      wsActiveConvC.setpreclear();
      bottleTotalRC.setpreclear();
      bottleTotalRP.setpreclear();
      bottleTotalConvC.setpreclear();
      BatchQuantityRC.setpreclear();
      BatchQuantityRP.setpreclear();
      BatchQuantityConvC.setpreclear();
      LiquidAmount1FC.setpreclear();
      LiquidAmount2FC.setpreclear();
      start_conveyor.setpreclear();
      bottleTotal_1.setpreclear();
      wsActive_1.setpreclear();
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
      dummyint = posOrder.getStatus() ? posOrder.setprepresent() : posOrder.setpreclear();
      posOrder.setpreval(posOrder.getValue());
      posOrder.setClear();
      dummyint = rotatedM.getStatus() ? rotatedM.setprepresent() : rotatedM.setpreclear();
      rotatedM.setpreval(rotatedM.getValue());
      rotatedM.setClear();
      dummyint = BatchQuantity.getStatus() ? BatchQuantity.setprepresent() : BatchQuantity.setpreclear();
      BatchQuantity.setpreval(BatchQuantity.getValue());
      BatchQuantity.setClear();
      dummyint = LiquidAmount1.getStatus() ? LiquidAmount1.setprepresent() : LiquidAmount1.setpreclear();
      LiquidAmount1.setpreval(LiquidAmount1.getValue());
      LiquidAmount1.setClear();
      dummyint = LiquidAmount2.getStatus() ? LiquidAmount2.setprepresent() : LiquidAmount2.setpreclear();
      LiquidAmount2.setpreval(LiquidAmount2.getValue());
      LiquidAmount2.setClear();
      wsActiveRC.sethook();
      wsActiveRC.setClear();
      wsActiveRP.sethook();
      wsActiveRP.setClear();
      wsActiveConvC.sethook();
      wsActiveConvC.setClear();
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
      start_conveyor.sethook();
      start_conveyor.setClear();
      bottleTotal_1.setClear();
      wsActive_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        bottleAtPos1M.gethook();
        bottleLeftPos5M.gethook();
        posOrder.gethook();
        rotatedM.gethook();
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
