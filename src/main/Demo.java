package main;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.plaf.SliderUI;

class Alarm{
    public void operateAlram(int waterLevel){
        System.out.println(waterLevel>=50 ? "Alarm ON ": "Alarm OFF");
    }
} 
class Display{
    public void display(int waterLevel){
        System.out.println("WaterLevel  :"+waterLevel);
    }
}
class SMSsender{
    public void sendSMS(int waterLevel){
        System.out.println("WETER Level..."+waterLevel);
    }
}
class Splitter{
    public void splitter(int waterLevel){
        System.out.println(waterLevel>=75 ?"Spliter ON" :"Splitter OFF");
    }
}
class ControlRoom{
    private ArrayList<Alarm> alarmList=new ArrayList<>();
    private ArrayList<Display> displayList=new ArrayList<>();
    private ArrayList<SMSsender> sMSsenderList=new ArrayList<>();
    private ArrayList<Splitter> splitterList=new ArrayList<>();
    
    private int waterLevel;
    
    public void addSplitter(Splitter splitter){
        splitterList.add(splitter);
    }
    public void addAlarm(Alarm alarm){
        alarmList.add(alarm);
    }
    public void addDisplay(Display display){
        displayList.add(display);
    }
    public void addSMSsender(SMSsender sMSsender){
        sMSsenderList.add(sMSsender);
    }
    
    public void setWaterLevel(int waterLevel){
        if (this.waterLevel!=waterLevel){
            this.waterLevel=waterLevel;            
        }
        notifyDevices();
    }
    public void notifyDevices(){
        for (Alarm alarm : alarmList) {
            alarm.operateAlram(waterLevel);
        }
        for (Display display : displayList) {
            display.display(waterLevel);
        }
        for (SMSsender seMSsender : sMSsenderList) {
            seMSsender.sendSMS(waterLevel);
        }
        for (Splitter splitter : splitterList) {
            splitter.splitter(waterLevel);
        }
    }
}
public class Demo {
     public static void main(String[] args) throws InterruptedException {
        ControlRoom controlRoom=new ControlRoom();
        controlRoom.addAlarm(new Alarm());
        controlRoom.addAlarm(new Alarm());
        controlRoom.addDisplay(new Display());
        controlRoom.addDisplay(new Display());
        controlRoom.addDisplay(new Display());
        controlRoom.addSMSsender(new SMSsender());
        controlRoom.addSplitter(new Splitter());
        controlRoom.addSplitter(new Splitter());
        
        Random r= new Random();
        while (true) {            
            int waterLevel=r.nextInt(101);
            controlRoom.setWaterLevel(waterLevel);
            Thread.sleep(1000);
        }
    }
}