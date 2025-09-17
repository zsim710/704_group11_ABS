import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.GUI;//sysj\RotaryPlant.sysj line: 1, column: 1

public class RotaryPlant extends ClockDomain{
  public RotaryPlant(String name){super(name);}
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
  public Signal capOnBottleAtPos1RP = new Signal("capOnBottleAtPos1RP", Signal.INPUT);
  public Signal tableAlignedWithSensor = new Signal("tableAlignedWithSensor", Signal.OUTPUT);
  public Signal rotation = new Signal("rotation", Signal.OUTPUT);
  public Signal bottleAtPos2 = new Signal("bottleAtPos2", Signal.OUTPUT);
  public Signal bottleAtPos3 = new Signal("bottleAtPos3", Signal.OUTPUT);
  public Signal bottleAtPos4 = new Signal("bottleAtPos4", Signal.OUTPUT);
  public Signal bottleAtPos5 = new Signal("bottleAtPos5", Signal.OUTPUT);
  public Signal bottleAtPos2GUI = new Signal("bottleAtPos2GUI", Signal.OUTPUT);
  public Signal bottleAtPos3GUI = new Signal("bottleAtPos3GUI", Signal.OUTPUT);
  public Signal bottleAtPos4GUI = new Signal("bottleAtPos4GUI", Signal.OUTPUT);
  public Signal bottleAtPos5GUI = new Signal("bottleAtPos5GUI", Signal.OUTPUT);
  public Signal capOnBottleAtPos1GUI = new Signal("capOnBottleAtPos1GUI", Signal.OUTPUT);
  private int S80342 = 1;
  private int S7831 = 1;
  private int S44019 = 1;
  private int S25924 = 1;
  private int S44033 = 1;
  private int S44086 = 1;
  private int S44041 = 1;
  private int S44049 = 1;
  private int S44057 = 1;
  private int S44065 = 1;
  private int S44073 = 1;
  private int S44084 = 1;
  
  private int[] ends = new int[11];
  private int[] tdone = new int[11];
  
  public void thread80363(int [] tdone, int [] ends){
        switch(S44084){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        if(capOnBottleAtPos1RP.getprestatus()){//sysj\RotaryPlant.sysj line: 104, column: 25
          capOnBottleAtPos1GUI.setPresent();//sysj\RotaryPlant.sysj line: 104, column: 46
          currsigs.addElement(capOnBottleAtPos1GUI);
          System.out.println("received by plant, send to GUI");//sysj\RotaryPlant.sysj line: 105, column: 4
          active[10]=1;
          ends[10]=1;
          tdone[10]=1;
        }
        else {
          active[10]=1;
          ends[10]=1;
          tdone[10]=1;
        }
        break;
      
    }
  }

  public void thread80362(int [] tdone, int [] ends){
        switch(S44073){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        if(bottleAtPos5.getprestatus()){//sysj\RotaryPlant.sysj line: 102, column: 25
          bottleAtPos5GUI.setPresent();//sysj\RotaryPlant.sysj line: 102, column: 39
          currsigs.addElement(bottleAtPos5GUI);
          active[9]=1;
          ends[9]=1;
          tdone[9]=1;
        }
        else {
          active[9]=1;
          ends[9]=1;
          tdone[9]=1;
        }
        break;
      
    }
  }

  public void thread80361(int [] tdone, int [] ends){
        switch(S44065){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        if(bottleAtPos5.getprestatus()){//sysj\RotaryPlant.sysj line: 100, column: 25
          bottleAtPos5GUI.setPresent();//sysj\RotaryPlant.sysj line: 100, column: 39
          currsigs.addElement(bottleAtPos5GUI);
          active[8]=1;
          ends[8]=1;
          tdone[8]=1;
        }
        else {
          active[8]=1;
          ends[8]=1;
          tdone[8]=1;
        }
        break;
      
    }
  }

  public void thread80360(int [] tdone, int [] ends){
        switch(S44057){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        if(bottleAtPos4.getprestatus()){//sysj\RotaryPlant.sysj line: 98, column: 25
          bottleAtPos4GUI.setPresent();//sysj\RotaryPlant.sysj line: 98, column: 39
          currsigs.addElement(bottleAtPos4GUI);
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
      
    }
  }

  public void thread80359(int [] tdone, int [] ends){
        switch(S44049){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        if(bottleAtPos3.getprestatus()){//sysj\RotaryPlant.sysj line: 96, column: 25
          bottleAtPos3GUI.setPresent();//sysj\RotaryPlant.sysj line: 96, column: 39
          currsigs.addElement(bottleAtPos3GUI);
          active[6]=1;
          ends[6]=1;
          tdone[6]=1;
        }
        else {
          active[6]=1;
          ends[6]=1;
          tdone[6]=1;
        }
        break;
      
    }
  }

  public void thread80358(int [] tdone, int [] ends){
        switch(S44041){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        if(bottleAtPos2.getprestatus()){//sysj\RotaryPlant.sysj line: 94, column: 25
          bottleAtPos2GUI.setPresent();//sysj\RotaryPlant.sysj line: 94, column: 39
          currsigs.addElement(bottleAtPos2GUI);
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

  public void thread80357(int [] tdone, int [] ends){
        switch(S44086){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        thread80358(tdone,ends);
        thread80359(tdone,ends);
        thread80360(tdone,ends);
        thread80361(tdone,ends);
        thread80362(tdone,ends);
        thread80363(tdone,ends);
        int biggest80364 = 0;
        if(ends[5]>=biggest80364){
          biggest80364=ends[5];
        }
        if(ends[6]>=biggest80364){
          biggest80364=ends[6];
        }
        if(ends[7]>=biggest80364){
          biggest80364=ends[7];
        }
        if(ends[8]>=biggest80364){
          biggest80364=ends[8];
        }
        if(ends[9]>=biggest80364){
          biggest80364=ends[9];
        }
        if(ends[10]>=biggest80364){
          biggest80364=ends[10];
        }
        if(biggest80364 == 1){
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
        //FINXME code
        if(biggest80364 == 0){
          S44086=0;
          active[4]=0;
          ends[4]=0;
          tdone[4]=1;
        }
        break;
      
    }
  }

  public void thread80356(int [] tdone, int [] ends){
        switch(S44033){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        if(rotated.getprestatus()){//sysj\RotaryPlant.sysj line: 85, column: 13
          rotation.setPresent();//sysj\RotaryPlant.sysj line: 86, column: 6
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

  public void thread80355(int [] tdone, int [] ends){
        switch(S44019){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S25924){
          case 0 : 
            S25924=0;
            S25924=1;
            tableAlignedWithSensor.setPresent();//sysj\RotaryPlant.sysj line: 24, column: 6
            currsigs.addElement(tableAlignedWithSensor);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
            break;
          
          case 1 : 
            if(rotaryTableTrigger.getprestatus()){//sysj\RotaryPlant.sysj line: 22, column: 13
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              if((Integer)(bottleTotalRP.getpreval() == null ? null : ((Integer)bottleTotalRP.getpreval())) < (Integer)(BatchQuantityRP.getpreval() == null ? null : ((Integer)BatchQuantityRP.getpreval()))){//sysj\RotaryPlant.sysj line: 29, column: 11
                if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 2){//sysj\RotaryPlant.sysj line: 30, column: 11
                  System.out.println("2 active");//sysj\RotaryPlant.sysj line: 31, column: 9
                  bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 32, column: 9
                  currsigs.addElement(bottleAtPos2);
                  if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 3){//sysj\RotaryPlant.sysj line: 34, column: 11
                    System.out.println("2, 3 active");//sysj\RotaryPlant.sysj line: 35, column: 9
                    bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 36, column: 9
                    currsigs.addElement(bottleAtPos2);
                    bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 37, column: 9
                    currsigs.addElement(bottleAtPos3);
                    if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 4){//sysj\RotaryPlant.sysj line: 39, column: 11
                      System.out.println("2, 3, 4 active");//sysj\RotaryPlant.sysj line: 40, column: 9
                      bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 41, column: 9
                      currsigs.addElement(bottleAtPos2);
                      bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 42, column: 9
                      currsigs.addElement(bottleAtPos3);
                      bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 43, column: 9
                      currsigs.addElement(bottleAtPos4);
                      if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 5){//sysj\RotaryPlant.sysj line: 45, column: 11
                        System.out.println("2, 3, 4, 5 active");//sysj\RotaryPlant.sysj line: 46, column: 9
                        bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 47, column: 9
                        currsigs.addElement(bottleAtPos2);
                        bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 48, column: 9
                        currsigs.addElement(bottleAtPos3);
                        bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 49, column: 9
                        currsigs.addElement(bottleAtPos4);
                        bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 50, column: 9
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
                      if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 5){//sysj\RotaryPlant.sysj line: 45, column: 11
                        System.out.println("2, 3, 4, 5 active");//sysj\RotaryPlant.sysj line: 46, column: 9
                        bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 47, column: 9
                        currsigs.addElement(bottleAtPos2);
                        bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 48, column: 9
                        currsigs.addElement(bottleAtPos3);
                        bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 49, column: 9
                        currsigs.addElement(bottleAtPos4);
                        bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 50, column: 9
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
                    if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 4){//sysj\RotaryPlant.sysj line: 39, column: 11
                      System.out.println("2, 3, 4 active");//sysj\RotaryPlant.sysj line: 40, column: 9
                      bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 41, column: 9
                      currsigs.addElement(bottleAtPos2);
                      bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 42, column: 9
                      currsigs.addElement(bottleAtPos3);
                      bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 43, column: 9
                      currsigs.addElement(bottleAtPos4);
                      if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 5){//sysj\RotaryPlant.sysj line: 45, column: 11
                        System.out.println("2, 3, 4, 5 active");//sysj\RotaryPlant.sysj line: 46, column: 9
                        bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 47, column: 9
                        currsigs.addElement(bottleAtPos2);
                        bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 48, column: 9
                        currsigs.addElement(bottleAtPos3);
                        bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 49, column: 9
                        currsigs.addElement(bottleAtPos4);
                        bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 50, column: 9
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
                      if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 5){//sysj\RotaryPlant.sysj line: 45, column: 11
                        System.out.println("2, 3, 4, 5 active");//sysj\RotaryPlant.sysj line: 46, column: 9
                        bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 47, column: 9
                        currsigs.addElement(bottleAtPos2);
                        bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 48, column: 9
                        currsigs.addElement(bottleAtPos3);
                        bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 49, column: 9
                        currsigs.addElement(bottleAtPos4);
                        bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 50, column: 9
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
                  if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 3){//sysj\RotaryPlant.sysj line: 34, column: 11
                    System.out.println("2, 3 active");//sysj\RotaryPlant.sysj line: 35, column: 9
                    bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 36, column: 9
                    currsigs.addElement(bottleAtPos2);
                    bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 37, column: 9
                    currsigs.addElement(bottleAtPos3);
                    if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 4){//sysj\RotaryPlant.sysj line: 39, column: 11
                      System.out.println("2, 3, 4 active");//sysj\RotaryPlant.sysj line: 40, column: 9
                      bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 41, column: 9
                      currsigs.addElement(bottleAtPos2);
                      bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 42, column: 9
                      currsigs.addElement(bottleAtPos3);
                      bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 43, column: 9
                      currsigs.addElement(bottleAtPos4);
                      if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 5){//sysj\RotaryPlant.sysj line: 45, column: 11
                        System.out.println("2, 3, 4, 5 active");//sysj\RotaryPlant.sysj line: 46, column: 9
                        bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 47, column: 9
                        currsigs.addElement(bottleAtPos2);
                        bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 48, column: 9
                        currsigs.addElement(bottleAtPos3);
                        bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 49, column: 9
                        currsigs.addElement(bottleAtPos4);
                        bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 50, column: 9
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
                      if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 5){//sysj\RotaryPlant.sysj line: 45, column: 11
                        System.out.println("2, 3, 4, 5 active");//sysj\RotaryPlant.sysj line: 46, column: 9
                        bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 47, column: 9
                        currsigs.addElement(bottleAtPos2);
                        bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 48, column: 9
                        currsigs.addElement(bottleAtPos3);
                        bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 49, column: 9
                        currsigs.addElement(bottleAtPos4);
                        bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 50, column: 9
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
                    if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 4){//sysj\RotaryPlant.sysj line: 39, column: 11
                      System.out.println("2, 3, 4 active");//sysj\RotaryPlant.sysj line: 40, column: 9
                      bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 41, column: 9
                      currsigs.addElement(bottleAtPos2);
                      bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 42, column: 9
                      currsigs.addElement(bottleAtPos3);
                      bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 43, column: 9
                      currsigs.addElement(bottleAtPos4);
                      if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 5){//sysj\RotaryPlant.sysj line: 45, column: 11
                        System.out.println("2, 3, 4, 5 active");//sysj\RotaryPlant.sysj line: 46, column: 9
                        bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 47, column: 9
                        currsigs.addElement(bottleAtPos2);
                        bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 48, column: 9
                        currsigs.addElement(bottleAtPos3);
                        bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 49, column: 9
                        currsigs.addElement(bottleAtPos4);
                        bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 50, column: 9
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
                      if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 5){//sysj\RotaryPlant.sysj line: 45, column: 11
                        System.out.println("2, 3, 4, 5 active");//sysj\RotaryPlant.sysj line: 46, column: 9
                        bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 47, column: 9
                        currsigs.addElement(bottleAtPos2);
                        bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 48, column: 9
                        currsigs.addElement(bottleAtPos3);
                        bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 49, column: 9
                        currsigs.addElement(bottleAtPos4);
                        bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 50, column: 9
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
                if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 4){//sysj\RotaryPlant.sysj line: 56, column: 11
                  bottleAtPos2.setPresent();//sysj\RotaryPlant.sysj line: 57, column: 9
                  currsigs.addElement(bottleAtPos2);
                  bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 58, column: 9
                  currsigs.addElement(bottleAtPos3);
                  bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 59, column: 9
                  currsigs.addElement(bottleAtPos4);
                  bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 60, column: 9
                  currsigs.addElement(bottleAtPos5);
                  if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 3){//sysj\RotaryPlant.sysj line: 62, column: 11
                    bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 63, column: 9
                    currsigs.addElement(bottleAtPos3);
                    bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 64, column: 9
                    currsigs.addElement(bottleAtPos4);
                    bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 65, column: 9
                    currsigs.addElement(bottleAtPos5);
                    if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 2){//sysj\RotaryPlant.sysj line: 67, column: 11
                      bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 68, column: 9
                      currsigs.addElement(bottleAtPos4);
                      bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 69, column: 9
                      currsigs.addElement(bottleAtPos5);
                      if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 1){//sysj\RotaryPlant.sysj line: 71, column: 11
                        bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 72, column: 9
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
                      if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 1){//sysj\RotaryPlant.sysj line: 71, column: 11
                        bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 72, column: 9
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
                    if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 2){//sysj\RotaryPlant.sysj line: 67, column: 11
                      bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 68, column: 9
                      currsigs.addElement(bottleAtPos4);
                      bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 69, column: 9
                      currsigs.addElement(bottleAtPos5);
                      if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 1){//sysj\RotaryPlant.sysj line: 71, column: 11
                        bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 72, column: 9
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
                      if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 1){//sysj\RotaryPlant.sysj line: 71, column: 11
                        bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 72, column: 9
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
                  if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 3){//sysj\RotaryPlant.sysj line: 62, column: 11
                    bottleAtPos3.setPresent();//sysj\RotaryPlant.sysj line: 63, column: 9
                    currsigs.addElement(bottleAtPos3);
                    bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 64, column: 9
                    currsigs.addElement(bottleAtPos4);
                    bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 65, column: 9
                    currsigs.addElement(bottleAtPos5);
                    if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 2){//sysj\RotaryPlant.sysj line: 67, column: 11
                      bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 68, column: 9
                      currsigs.addElement(bottleAtPos4);
                      bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 69, column: 9
                      currsigs.addElement(bottleAtPos5);
                      if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 1){//sysj\RotaryPlant.sysj line: 71, column: 11
                        bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 72, column: 9
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
                      if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 1){//sysj\RotaryPlant.sysj line: 71, column: 11
                        bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 72, column: 9
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
                    if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 2){//sysj\RotaryPlant.sysj line: 67, column: 11
                      bottleAtPos4.setPresent();//sysj\RotaryPlant.sysj line: 68, column: 9
                      currsigs.addElement(bottleAtPos4);
                      bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 69, column: 9
                      currsigs.addElement(bottleAtPos5);
                      if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 1){//sysj\RotaryPlant.sysj line: 71, column: 11
                        bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 72, column: 9
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
                      if((Integer)(wsActiveRP.getpreval() == null ? null : ((Integer)wsActiveRP.getpreval())) == 1){//sysj\RotaryPlant.sysj line: 71, column: 11
                        bottleAtPos5.setPresent();//sysj\RotaryPlant.sysj line: 72, column: 9
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
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread80352(int [] tdone, int [] ends){
        S44084=1;
    if(capOnBottleAtPos1RP.getprestatus()){//sysj\RotaryPlant.sysj line: 104, column: 25
      capOnBottleAtPos1GUI.setPresent();//sysj\RotaryPlant.sysj line: 104, column: 46
      currsigs.addElement(capOnBottleAtPos1GUI);
      System.out.println("received by plant, send to GUI");//sysj\RotaryPlant.sysj line: 105, column: 4
      active[10]=1;
      ends[10]=1;
      tdone[10]=1;
    }
    else {
      active[10]=1;
      ends[10]=1;
      tdone[10]=1;
    }
  }

  public void thread80351(int [] tdone, int [] ends){
        S44073=1;
    if(bottleAtPos5.getprestatus()){//sysj\RotaryPlant.sysj line: 102, column: 25
      bottleAtPos5GUI.setPresent();//sysj\RotaryPlant.sysj line: 102, column: 39
      currsigs.addElement(bottleAtPos5GUI);
      active[9]=1;
      ends[9]=1;
      tdone[9]=1;
    }
    else {
      active[9]=1;
      ends[9]=1;
      tdone[9]=1;
    }
  }

  public void thread80350(int [] tdone, int [] ends){
        S44065=1;
    if(bottleAtPos5.getprestatus()){//sysj\RotaryPlant.sysj line: 100, column: 25
      bottleAtPos5GUI.setPresent();//sysj\RotaryPlant.sysj line: 100, column: 39
      currsigs.addElement(bottleAtPos5GUI);
      active[8]=1;
      ends[8]=1;
      tdone[8]=1;
    }
    else {
      active[8]=1;
      ends[8]=1;
      tdone[8]=1;
    }
  }

  public void thread80349(int [] tdone, int [] ends){
        S44057=1;
    if(bottleAtPos4.getprestatus()){//sysj\RotaryPlant.sysj line: 98, column: 25
      bottleAtPos4GUI.setPresent();//sysj\RotaryPlant.sysj line: 98, column: 39
      currsigs.addElement(bottleAtPos4GUI);
      active[7]=1;
      ends[7]=1;
      tdone[7]=1;
    }
    else {
      active[7]=1;
      ends[7]=1;
      tdone[7]=1;
    }
  }

  public void thread80348(int [] tdone, int [] ends){
        S44049=1;
    if(bottleAtPos3.getprestatus()){//sysj\RotaryPlant.sysj line: 96, column: 25
      bottleAtPos3GUI.setPresent();//sysj\RotaryPlant.sysj line: 96, column: 39
      currsigs.addElement(bottleAtPos3GUI);
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
    else {
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
  }

  public void thread80347(int [] tdone, int [] ends){
        S44041=1;
    if(bottleAtPos2.getprestatus()){//sysj\RotaryPlant.sysj line: 94, column: 25
      bottleAtPos2GUI.setPresent();//sysj\RotaryPlant.sysj line: 94, column: 39
      currsigs.addElement(bottleAtPos2GUI);
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
    else {
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
  }

  public void thread80346(int [] tdone, int [] ends){
        S44086=1;
    thread80347(tdone,ends);
    thread80348(tdone,ends);
    thread80349(tdone,ends);
    thread80350(tdone,ends);
    thread80351(tdone,ends);
    thread80352(tdone,ends);
    int biggest80353 = 0;
    if(ends[5]>=biggest80353){
      biggest80353=ends[5];
    }
    if(ends[6]>=biggest80353){
      biggest80353=ends[6];
    }
    if(ends[7]>=biggest80353){
      biggest80353=ends[7];
    }
    if(ends[8]>=biggest80353){
      biggest80353=ends[8];
    }
    if(ends[9]>=biggest80353){
      biggest80353=ends[9];
    }
    if(ends[10]>=biggest80353){
      biggest80353=ends[10];
    }
    if(biggest80353 == 1){
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread80345(int [] tdone, int [] ends){
        S44033=1;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread80344(int [] tdone, int [] ends){
        S44019=1;
    S25924=0;
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
      switch(S80342){
        case 0 : 
          S80342=0;
          break RUN;
        
        case 1 : 
          S80342=2;
          S80342=2;
          new Thread(new GUI()).start();//sysj\RotaryPlant.sysj line: 15, column: 3
          S7831=0;
          active[1]=1;
          ends[1]=1;
          break RUN;
        
        case 2 : 
          switch(S7831){
            case 0 : 
              S7831=0;
              S7831=1;
              thread80344(tdone,ends);
              thread80345(tdone,ends);
              thread80346(tdone,ends);
              int biggest80354 = 0;
              if(ends[2]>=biggest80354){
                biggest80354=ends[2];
              }
              if(ends[3]>=biggest80354){
                biggest80354=ends[3];
              }
              if(ends[4]>=biggest80354){
                biggest80354=ends[4];
              }
              if(biggest80354 == 1){
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            
            case 1 : 
              thread80355(tdone,ends);
              thread80356(tdone,ends);
              thread80357(tdone,ends);
              int biggest80365 = 0;
              if(ends[2]>=biggest80365){
                biggest80365=ends[2];
              }
              if(ends[3]>=biggest80365){
                biggest80365=ends[3];
              }
              if(ends[4]>=biggest80365){
                biggest80365=ends[4];
              }
              if(biggest80365 == 1){
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              //FINXME code
              if(biggest80365 == 0){
                S80342=0;
                active[1]=0;
                ends[1]=0;
                S80342=0;
                break RUN;
              }
            
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
          capOnBottleAtPos1RP.gethook();
          df = true;
        }
        runClockDomain();
      }
      rotaryTableTrigger.setpreclear();
      rotated.setpreclear();
      wsActiveRP.setpreclear();
      bottleTotalRP.setpreclear();
      BatchQuantityRP.setpreclear();
      capOnBottleAtPos1RP.setpreclear();
      tableAlignedWithSensor.setpreclear();
      rotation.setpreclear();
      bottleAtPos2.setpreclear();
      bottleAtPos3.setpreclear();
      bottleAtPos4.setpreclear();
      bottleAtPos5.setpreclear();
      bottleAtPos2GUI.setpreclear();
      bottleAtPos3GUI.setpreclear();
      bottleAtPos4GUI.setpreclear();
      bottleAtPos5GUI.setpreclear();
      capOnBottleAtPos1GUI.setpreclear();
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
      dummyint = capOnBottleAtPos1RP.getStatus() ? capOnBottleAtPos1RP.setprepresent() : capOnBottleAtPos1RP.setpreclear();
      capOnBottleAtPos1RP.setpreval(capOnBottleAtPos1RP.getValue());
      capOnBottleAtPos1RP.setClear();
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
      bottleAtPos2GUI.sethook();
      bottleAtPos2GUI.setClear();
      bottleAtPos3GUI.sethook();
      bottleAtPos3GUI.setClear();
      bottleAtPos4GUI.sethook();
      bottleAtPos4GUI.setClear();
      bottleAtPos5GUI.sethook();
      bottleAtPos5GUI.setClear();
      capOnBottleAtPos1GUI.sethook();
      capOnBottleAtPos1GUI.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        rotaryTableTrigger.gethook();
        rotated.gethook();
        wsActiveRP.gethook();
        bottleTotalRP.gethook();
        BatchQuantityRP.gethook();
        capOnBottleAtPos1RP.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
