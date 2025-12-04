package main;
import java.util.ArrayList;
import java.util.Random;

class WaterLevelObserver{
    public void update(int waterLevel){
        
    }
}
class Alarm extends WaterLevelObserver{
    @Override
    public void update(int waterLevel){
        System.out.println(waterLevel>=50 ? "Alarm ON ": "Alarm OFF");
    }
} 
class Display extends WaterLevelObserver{
    @Override
    public void update(int waterLevel){
        System.out.println("WaterLevel  :"+waterLevel);
    }
}
class SMSsender extends WaterLevelObserver{
    @Override
    public void update(int waterLevel){
        System.out.println("WETER Level..."+waterLevel);
    }
}

class ControlRoom{
    private ArrayList<WaterLevelObserver> observerList=new ArrayList<>();
    
    private int waterLevel;
    
    
    public void addWaterLevelObserver(WaterLevelObserver waterLevelObserver){
        observerList.add(waterLevelObserver);
    }
    
    public void setWaterLevel(int waterLevel){
        if (this.waterLevel!=waterLevel){
            this.waterLevel=waterLevel;            
        }
        notifyObserver();
    }
    public void notifyObserver(){
        for (WaterLevelObserver waterLevelObserver : observerList) {
            waterLevelObserver.update(waterLevel);
        }
       
    }
}
public class Demo {
     public static void main(String[] args) throws InterruptedException {
        ControlRoom controlRoom=new ControlRoom();
        controlRoom.addWaterLevelObserver(new Alarm());
        controlRoom.addWaterLevelObserver(new Alarm());
        controlRoom.addWaterLevelObserver(new Alarm());
        controlRoom.addWaterLevelObserver(new Display());
        controlRoom.addWaterLevelObserver(new Display());
        controlRoom.addWaterLevelObserver(new SMSsender());
        controlRoom.addWaterLevelObserver(new SMSsender());
        Random r= new Random();
        while (true) {            
            int waterLevel=r.nextInt(101);
            controlRoom.setWaterLevel(waterLevel);
            Thread.sleep(1000);
        }
    }
}