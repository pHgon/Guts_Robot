import lejos.nxt.*;
import lejos.nxt.ColorSensor.Color;
import lejos.robotics.*;

public class ColorThread extends Thread{
	
	private int count;
	private boolean flag;
	
	public ColorThread(){
		this.count = 0;
		this.flag = false;
	}
	
	public int colorCounter(){
		this.flag = true;
		
		return this.count;
	}
	
	public void run(){
		boolean isWhite = false;
		ColorSensor color = new ColorSensor(SensorPort.S2);
		this.count = 0;
		
		while(!this.flag){
			if(color.getColorID() == 6) {
				if(!isWhite) {
					isWhite = true;
					this.count++;
				}
			}
			
			if(color.getColorID() == 7) {
				if(isWhite)
					isWhite = false;
			}
		}
	}
}
