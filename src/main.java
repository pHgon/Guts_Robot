import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;

public class main {

	public static void main(String[] args) {
		UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S1);
		ColorThread color = new ColorThread();
		double position = 0;
		double gain = 0.93760262;
		
		LCD.clear();
		//dist1 = sonic.getDistance();
		Motor.B.setSpeed(150);
		Motor.C.setSpeed(150);
		Motor.B.backward();
		Motor.C.backward();
		
	
		while(position < 100) {
			color.start();
			position = gain * sonic.getDistance() + ((1 - gain) * ((color.colorCounter()/8)*13.8));
		}
		
		color.stopThread();
		Motor.B.stop();
		Motor.C.stop();
	}
}
