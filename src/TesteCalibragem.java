import lejos.nxt.*;
import lejos.nxt.ColorSensor.Color;
import lejos.robotics.*;

public class TesteCalibragem{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S1);
		int dist1, dist2;
		
		ColorThread color = new ColorThread();
		
		LCD.clear();
		//dist1 = sonic.getDistance();
		Motor.B.setSpeed(100);
		Motor.C.setSpeed(100);
		Motor.B.backward();
		Motor.C.backward();
		
		color.start();
		
//		try {
//			Thread.currentThread().sleep(7500);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		try {
			Thread.currentThread().sleep(750);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Motor.B.stop();
		Motor.C.stop();
		LCD.drawInt(color.colorCounter(), 0, 0);
		
		//escreve distancia medida em cm
		//dist2 = sonic.getDistance();
		//LCD.drawInt(dist1, 0, 0);
		//LCD.drawInt(dist2, 0, 1);
		//LCD.drawInt(dist2 - dist1, 0, 2);
		
		
		try {
			Thread.currentThread().sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//
		
		/*
		Motor.B.backward();
		Motor.C.backward();
		try {
			Thread.currentThread().sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Motor.B.stop();
		Motor.C.stop();
		*/
	}

}
