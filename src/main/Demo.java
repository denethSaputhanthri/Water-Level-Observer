package main;
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
        System.out.println("Water Level..."+waterLevel);
    }
}
class Splitter{
    public void splitter(int waterLevel){
        System.out.println(waterLevel>=75 ?"Spliter ON" :"Splitter OFF");
    }
}
class ControlRoom{
    private Alarm alarm;
    private Display display;
    private SMSsender sMSsender;
    private Splitter splitter;
    
    private int waterLevel;
    
    public void addSplitter(Splitter splitter){
        this.splitter=splitter;
    }
    public void addAlarm(Alarm alarm){
        this.alarm=alarm;
    }
    public void addDisplay(Display display){
        this.display=display;
    }
    public void addSMSsender(SMSsender sMSsender){
        this.sMSsender=sMSsender;
    }
    
    public void setWaterLevel(int waterLevel){
        if (this.waterLevel!=waterLevel){
            this.waterLevel=waterLevel;            
        }
        notifyDevices();
    }
    public void notifyDevices(){
        alarm.operateAlram(waterLevel);
        display.display(waterLevel);
        sMSsender.sendSMS(waterLevel);
        splitter.splitter(waterLevel);
    }
}
public class Demo {
     public static void main(String[] args) throws InterruptedException {
        ControlRoom controlRoom=new ControlRoom();
        controlRoom.addAlarm(new Alarm());
        controlRoom.addDisplay(new Display());
        controlRoom.addSMSsender(new SMSsender());
        controlRoom.addSplitter(new Splitter());
        
        Random r= new Random();
        while (true) {            
            int waterLevel=r.nextInt(101);
            controlRoom.setWaterLevel(waterLevel);
            Thread.sleep(1000);
        }
    }
}