import lejos.nxt.*;
import lejos.nxt.ColorSensor.Color;
import lejos.robotics.*;

public class ColorThread extends Thread{
	
	private int count;
	private boolean running;
	private boolean isWhite;
	
	public ColorThread(){
		this.count = 0;
		this.running = true;
		this.isWhite = false;
	}
	
	public int colorCounter(){
		return this.count;
	}
	
	public void stopThread() {
		this.running = false;
	}
	
	public void run(){
		ColorSensor color = new ColorSensor(SensorPort.S2);
		
		while(running){
			if(color.getColorID() == 6) {
				if(!this.isWhite) {
					this.isWhite = true;
					this.count++;
				}
			}
			
			if(color.getColorID() == 7) {
				if(this.isWhite)
					this.isWhite = false;
			}
		}
	}
}