import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;

public class RobotMovement {
	public char orientation;
	public byte i_pos;
	public byte j_pos;
	private UltrasonicSensor sonic;
	
	public RobotMovement(byte i, byte j){
		this.orientation = 'N';
		this.i_pos = i;
		this.j_pos = j;
		this.sonic = new UltrasonicSensor(SensorPort.S2);
	}
	
	public void rotateLeft() {
		Motor.B.setSpeed(150);
		Motor.C.setSpeed(150);
		
		Motor.B.forward();
		Motor.C.backward();
		try {
			Thread.currentThread();
			Thread.sleep(3050);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Motor.B.stop();
		Motor.C.stop();
	}
	
	public void rotateRight() {
		Motor.B.setSpeed(150);
		Motor.C.setSpeed(150);
		
		Motor.C.forward();
		Motor.B.backward();
		try {
			Thread.currentThread();
			Thread.sleep(3050);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Motor.B.stop();
		Motor.C.stop();
	}
	
	public void rotateBack() {
		Motor.B.setSpeed(150);
		Motor.C.setSpeed(150);
		
		Motor.B.forward();
		Motor.C.backward();
		try {
			Thread.currentThread();
			Thread.sleep(6100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Motor.B.stop();
		Motor.C.stop();
	}
	
	public void rotateHeadLeft() {
		Motor.A.setSpeed(150);
		Motor.A.backward();
		try {
			Thread.currentThread();
			Thread.sleep(600);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Motor.A.stop();
	}
	
	public void rotateHeadRight() {
		Motor.A.setSpeed(150);
		Motor.A.forward();
		try {
			Thread.currentThread();
			Thread.sleep(600);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Motor.A.stop();
	}
	
	public void moveForward() {
		Motor.B.resetTachoCount();
		Motor.C.resetTachoCount();
		
		Motor.B.setSpeed(150);
		Motor.C.setSpeed(150);
		
		Motor.B.forward();
		Motor.C.forward();
		try {
			Thread.currentThread();
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Motor.B.stop();
		Motor.C.stop();
	}
	
	public void correctHead() {
		Motor.A.setSpeed(50);
		Motor.A.backward();
		try {
			Thread.currentThread();
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Motor.A.stop();
	}
	
	public String verifyObstacles() {
		String result = ""; // Center - Left - Right
		int dist_obst = 20;
		
		if(sonic.getDistance() < dist_obst) 
			result += "1";
		else
			result += "0";
		
		this.rotateHeadLeft();
		
		if(sonic.getDistance() < dist_obst) 
			result += "1";
		else
			result += "0";
		
		this.rotateHeadRight();
		this.rotateHeadRight();
		
		if(sonic.getDistance() < dist_obst) 
			result += "1";
		else
			result += "0";
		
		this.rotateHeadLeft();
		this.correctHead();
		
		return result;
	}
}
