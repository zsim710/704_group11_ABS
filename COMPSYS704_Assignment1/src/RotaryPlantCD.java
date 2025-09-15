import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.GUI;//sysj\RotaryPlant.sysj line: 1, column: 1

public class RotaryPlantCD extends ClockDomain{
  public RotaryPlantCD(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal rotaryTableTrigger = new Signal("rotaryTableTrigger", Signal.INPUT);
  public Signal rotated = new Signal("rotated", Signal.INPUT);
  public Signal wsActiveRP = new Signal("wsActiveRP", Signal.INPUT);
  public Signal bottleTotalRP = new Signal("bottleTotalRP", Signal.INPUT);
  public Signal BatchQuantityRP = new Signal("BatchQuantityRP", Signal.INPUT);
  public Signal tableAlignedWithSensor = new Signal("tableAlignedWithSensor", Signal.OUTPUT);
  public Signal rotation = new Signal("rotation", Signal.OUTPUT);
  public Signal bottleAtPos2 = new Signal("bottleAtPos2", Signal.OUTPUT);
  public Signal bottleAtPos3 = new Signal("bottleAtPos3", Signal.OUTPUT);
  public Signal bottleAtPos4 = new Signal("bottleAtPos4", Signal.OUTPUT);
  public Signal bottleAtPos5 = new Signal("bottleAtPos5", Signal.OUTPUT);
  private int S41508 = 1;
  private int S5799 = 1;
  private int S23639 = 1;
  private int S14718 = 1;
  private int S10257 = 1;
  private int S23653 = 1;
  
  private int[] ends = new int[4];
  private int[] tdone = new int[4];
  
  public void thread41514(int [] tdone, int [] ends){
        switch(S23653){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        if(rotated.getprestatus()){//sysj\RotaryPlant.sysj line: 75, column: 13
          rotation.setPresent();//sysj\RotaryPlant.sysj line: 76, column: 6
          currsigs.addElement(rotation);
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
      
    }
  }

  public void thread41513(int [] tdone, int [] ends){
        switch(S23639){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S14718){
          case 0 : 
            S14718=0;
            S14718=1;
            S10257=0;
            tableAlignedWithSensor.setPresent();//sysj\RotaryPlant.sysj line: 18, column: 6
            currsigs.addElement(tableAlignedWithSensor);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
            break;
          
          case 1 : 
            if(rotaryTableTrigger.getprestatus()){//sysj\RotaryPlant.sysj line: 16, column: 13
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              switch(S10257){
                case 0 : 
                  tableAlignedWithSensor.setPresent();//sysj\RotaryPlant.sysj line: 18, column: 6
                  currsigs.addElement(tableAlignedWithSensor);
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                  break;
                
                case 1 : 
                  if((Integer)(bottleTotalRP.getpreval() == null ? null : ((Integer)bottleTotalRP.getpreval())) < (Integer)(BatchQuantityRP.getpreval() == null ? null : ((Integer)BatchQuantityRP.getpreval()))){//sysj\RotaryPlant.sysj line: 22, column: 11
                    if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 2){//sysj\RotaryPlant.sysj line: 23, column: 11
                      bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 24, column: 9
                      currsigs.addElement(bottleAtPos2);
                      if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 3){//sysj\RotaryPlant.sysj line: 26, column: 11
                        bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 27, column: 9
                        currsigs.addElement(bottleAtPos2);
                        bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 28, column: 9
                        currsigs.addElement(bottleAtPos3);
                        if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 4){//sysj\RotaryPlant.sysj line: 30, column: 11
                          bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 31, column: 9
                          currsigs.addElement(bottleAtPos2);
                          bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 32, column: 9
                          currsigs.addElement(bottleAtPos3);
                          bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 33, column: 9
                          currsigs.addElement(bottleAtPos4);
                          if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 5){//sysj\RotaryPlant.sysj line: 35, column: 11
                            bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 36, column: 9
                            currsigs.addElement(bottleAtPos2);
                            bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 37, column: 9
                            currsigs.addElement(bottleAtPos3);
                            bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 38, column: 9
                            currsigs.addElement(bottleAtPos4);
                            bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 39, column: 9
                            currsigs.addElement(bottleAtPos5);
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
                          if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 5){//sysj\RotaryPlant.sysj line: 35, column: 11
                            bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 36, column: 9
                            currsigs.addElement(bottleAtPos2);
                            bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 37, column: 9
                            currsigs.addElement(bottleAtPos3);
                            bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 38, column: 9
                            currsigs.addElement(bottleAtPos4);
                            bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 39, column: 9
                            currsigs.addElement(bottleAtPos5);
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
                      else {
                        if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 4){//sysj\RotaryPlant.sysj line: 30, column: 11
                          bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 31, column: 9
                          currsigs.addElement(bottleAtPos2);
                          bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 32, column: 9
                          currsigs.addElement(bottleAtPos3);
                          bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 33, column: 9
                          currsigs.addElement(bottleAtPos4);
                          if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 5){//sysj\RotaryPlant.sysj line: 35, column: 11
                            bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 36, column: 9
                            currsigs.addElement(bottleAtPos2);
                            bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 37, column: 9
                            currsigs.addElement(bottleAtPos3);
                            bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 38, column: 9
                            currsigs.addElement(bottleAtPos4);
                            bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 39, column: 9
                            currsigs.addElement(bottleAtPos5);
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
                          if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 5){//sysj\RotaryPlant.sysj line: 35, column: 11
                            bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 36, column: 9
                            currsigs.addElement(bottleAtPos2);
                            bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 37, column: 9
                            currsigs.addElement(bottleAtPos3);
                            bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 38, column: 9
                            currsigs.addElement(bottleAtPos4);
                            bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 39, column: 9
                            currsigs.addElement(bottleAtPos5);
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
                    }
                    else {
                      if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 3){//sysj\RotaryPlant.sysj line: 26, column: 11
                        bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 27, column: 9
                        currsigs.addElement(bottleAtPos2);
                        bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 28, column: 9
                        currsigs.addElement(bottleAtPos3);
                        if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 4){//sysj\RotaryPlant.sysj line: 30, column: 11
                          bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 31, column: 9
                          currsigs.addElement(bottleAtPos2);
                          bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 32, column: 9
                          currsigs.addElement(bottleAtPos3);
                          bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 33, column: 9
                          currsigs.addElement(bottleAtPos4);
                          if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 5){//sysj\RotaryPlant.sysj line: 35, column: 11
                            bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 36, column: 9
                            currsigs.addElement(bottleAtPos2);
                            bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 37, column: 9
                            currsigs.addElement(bottleAtPos3);
                            bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 38, column: 9
                            currsigs.addElement(bottleAtPos4);
                            bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 39, column: 9
                            currsigs.addElement(bottleAtPos5);
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
                          if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 5){//sysj\RotaryPlant.sysj line: 35, column: 11
                            bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 36, column: 9
                            currsigs.addElement(bottleAtPos2);
                            bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 37, column: 9
                            currsigs.addElement(bottleAtPos3);
                            bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 38, column: 9
                            currsigs.addElement(bottleAtPos4);
                            bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 39, column: 9
                            currsigs.addElement(bottleAtPos5);
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
                      else {
                        if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 4){//sysj\RotaryPlant.sysj line: 30, column: 11
                          bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 31, column: 9
                          currsigs.addElement(bottleAtPos2);
                          bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 32, column: 9
                          currsigs.addElement(bottleAtPos3);
                          bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 33, column: 9
                          currsigs.addElement(bottleAtPos4);
                          if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 5){//sysj\RotaryPlant.sysj line: 35, column: 11
                            bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 36, column: 9
                            currsigs.addElement(bottleAtPos2);
                            bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 37, column: 9
                            currsigs.addElement(bottleAtPos3);
                            bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 38, column: 9
                            currsigs.addElement(bottleAtPos4);
                            bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 39, column: 9
                            currsigs.addElement(bottleAtPos5);
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
                          if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 5){//sysj\RotaryPlant.sysj line: 35, column: 11
                            bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 36, column: 9
                            currsigs.addElement(bottleAtPos2);
                            bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 37, column: 9
                            currsigs.addElement(bottleAtPos3);
                            bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 38, column: 9
                            currsigs.addElement(bottleAtPos4);
                            bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 39, column: 9
                            currsigs.addElement(bottleAtPos5);
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
                    }
                  }
                  else {
                    if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 4){//sysj\RotaryPlant.sysj line: 45, column: 11
                      bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 46, column: 9
                      currsigs.addElement(bottleAtPos2);
                      bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 47, column: 9
                      currsigs.addElement(bottleAtPos3);
                      bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 48, column: 9
                      currsigs.addElement(bottleAtPos4);
                      bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 49, column: 9
                      currsigs.addElement(bottleAtPos5);
                      if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 3){//sysj\RotaryPlant.sysj line: 51, column: 11
                        bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 52, column: 9
                        currsigs.addElement(bottleAtPos3);
                        bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 53, column: 9
                        currsigs.addElement(bottleAtPos4);
                        bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 54, column: 9
                        currsigs.addElement(bottleAtPos5);
                        if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 2){//sysj\RotaryPlant.sysj line: 56, column: 11
                          bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 57, column: 9
                          currsigs.addElement(bottleAtPos4);
                          bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 58, column: 9
                          currsigs.addElement(bottleAtPos5);
                          if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 1){//sysj\RotaryPlant.sysj line: 60, column: 11
                            bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 61, column: 9
                            currsigs.addElement(bottleAtPos5);
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
                          if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 1){//sysj\RotaryPlant.sysj line: 60, column: 11
                            bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 61, column: 9
                            currsigs.addElement(bottleAtPos5);
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
                      else {
                        if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 2){//sysj\RotaryPlant.sysj line: 56, column: 11
                          bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 57, column: 9
                          currsigs.addElement(bottleAtPos4);
                          bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 58, column: 9
                          currsigs.addElement(bottleAtPos5);
                          if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 1){//sysj\RotaryPlant.sysj line: 60, column: 11
                            bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 61, column: 9
                            currsigs.addElement(bottleAtPos5);
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
                          if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 1){//sysj\RotaryPlant.sysj line: 60, column: 11
                            bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 61, column: 9
                            currsigs.addElement(bottleAtPos5);
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
                    }
                    else {
                      if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 3){//sysj\RotaryPlant.sysj line: 51, column: 11
                        bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 52, column: 9
                        currsigs.addElement(bottleAtPos3);
                        bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 53, column: 9
                        currsigs.addElement(bottleAtPos4);
                        bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 54, column: 9
                        currsigs.addElement(bottleAtPos5);
                        if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 2){//sysj\RotaryPlant.sysj line: 56, column: 11
                          bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 57, column: 9
                          currsigs.addElement(bottleAtPos4);
                          bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 58, column: 9
                          currsigs.addElement(bottleAtPos5);
                          if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 1){//sysj\RotaryPlant.sysj line: 60, column: 11
                            bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 61, column: 9
                            currsigs.addElement(bottleAtPos5);
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
                          if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 1){//sysj\RotaryPlant.sysj line: 60, column: 11
                            bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 61, column: 9
                            currsigs.addElement(bottleAtPos5);
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
                      else {
                        if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 2){//sysj\RotaryPlant.sysj line: 56, column: 11
                          bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 57, column: 9
                          currsigs.addElement(bottleAtPos4);
                          bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 58, column: 9
                          currsigs.addElement(bottleAtPos5);
                          if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 1){//sysj\RotaryPlant.sysj line: 60, column: 11
                            bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 61, column: 9
                            currsigs.addElement(bottleAtPos5);
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
                          if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 1){//sysj\RotaryPlant.sysj line: 60, column: 11
                            bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 61, column: 9
                            currsigs.addElement(bottleAtPos5);
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
                    }
                  }
                  break;
                
              }
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread41511(int [] tdone, int [] ends){
        S23653=1;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread41510(int [] tdone, int [] ends){
        S23639=1;
    S14718=0;
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
      switch(S41508){
        case 0 : 
          S41508=0;
          break RUN;
        
        case 1 : 
          S41508=2;
          S41508=2;
          new Thread(new GUI()).start();//sysj\RotaryPlant.sysj line: 9, column: 3
          S5799=0;
          active[1]=1;
          ends[1]=1;
          break RUN;
        
        case 2 : 
          switch(S5799){
            case 0 : 
              S5799=0;
              S5799=1;
              thread41510(tdone,ends);
              thread41511(tdone,ends);
              int biggest41512 = 0;
              if(ends[2]>=biggest41512){
                biggest41512=ends[2];
              }
              if(ends[3]>=biggest41512){
                biggest41512=ends[3];
              }
              if(biggest41512 == 1){
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            
            case 1 : 
              thread41513(tdone,ends);
              thread41514(tdone,ends);
              int biggest41515 = 0;
              if(ends[2]>=biggest41515){
                biggest41515=ends[2];
              }
              if(ends[3]>=biggest41515){
                biggest41515=ends[3];
              }
              if(biggest41515 == 1){
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              //FINXME code
              if(biggest41515 == 0){
                S41508=0;
                active[1]=0;
                ends[1]=0;
                S41508=0;
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
          rotaryTableTrigger.gethook();
          rotated.gethook();
          wsActiveRP.gethook();
          bottleTotalRP.gethook();
          BatchQuantityRP.gethook();
          df = true;
        }
        runClockDomain();
      }
      rotaryTableTrigger.setpreclear();
      rotated.setpreclear();
      wsActiveRP.setpreclear();
      bottleTotalRP.setpreclear();
      BatchQuantityRP.setpreclear();
      tableAlignedWithSensor.setpreclear();
      rotation.setpreclear();
      bottleAtPos2.setpreclear();
      bottleAtPos3.setpreclear();
      bottleAtPos4.setpreclear();
      bottleAtPos5.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = rotaryTableTrigger.getStatus() ? rotaryTableTrigger.setprepresent() : rotaryTableTrigger.setpreclear();
      rotaryTableTrigger.setpreval(rotaryTableTrigger.getValue());
      rotaryTableTrigger.setClear();
      dummyint = rotated.getStatus() ? rotated.setprepresent() : rotated.setpreclear();
      rotated.setpreval(rotated.getValue());
      rotated.setClear();
      dummyint = wsActiveRP.getStatus() ? wsActiveRP.setprepresent() : wsActiveRP.setpreclear();
      wsActiveRP.setpreval(wsActiveRP.getValue());
      wsActiveRP.setClear();
      dummyint = bottleTotalRP.getStatus() ? bottleTotalRP.setprepresent() : bottleTotalRP.setpreclear();
      bottleTotalRP.setpreval(bottleTotalRP.getValue());
      bottleTotalRP.setClear();
      dummyint = BatchQuantityRP.getStatus() ? BatchQuantityRP.setprepresent() : BatchQuantityRP.setpreclear();
      BatchQuantityRP.setpreval(BatchQuantityRP.getValue());
      BatchQuantityRP.setClear();
      tableAlignedWithSensor.sethook();
      tableAlignedWithSensor.setClear();
      rotation.sethook();
      rotation.setClear();
      bottleAtPos2.sethook();
      bottleAtPos2.setClear();
      bottleAtPos3.sethook();
      bottleAtPos3.setClear();
      bottleAtPos4.sethook();
      bottleAtPos4.setClear();
      bottleAtPos5.sethook();
      bottleAtPos5.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        rotaryTableTrigger.gethook();
        rotated.gethook();
        wsActiveRP.gethook();
        bottleTotalRP.gethook();
        BatchQuantityRP.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
