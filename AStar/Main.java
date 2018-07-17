import lejos.nxt.LCD;
import lejos.nxt.Motor;

public class Main {
	
	public byte manhattanDistance(byte a, byte b, byte c, byte d) {
		return (byte) Math.sqrt(Math.pow((a-c), 2)+Math.pow((b-d), 2));
	}
	
	public static void main(String args[]) {
		/*byte i, j;
		byte i_start = 0; 
		byte j_start = 0;
		byte i_end 	 = 7; 
		byte j_end 	 = 7;
		

		Node[][] world = new Node[8][8];
		
		for(i = 0; i < 8; i++) {
			for(j = 0; j < 8; j++) {	
				if(i == i_start && j == j_start)
					world[i][j] = new Node(true, false);
				else 
					if(i == i_end && j == j_end)
						world[i][j] = new Node(false, true);
					else
						world[i][j] = new Node(false, false);
			}
		}*/
		
		RobotMovement robot = new RobotMovement((byte) 0, (byte) 0);
		
		/*robot.rotateHeadLeft();
		robot.rotateHeadRight();
		robot.rotateHeadRight();
		robot.rotateHeadLeft();
		robot.correctHead();*/
		
		//robot.rotateRight();
		//robot.moveForward();
		
		/*String res = robot.verifyObstacles();
		
		LCD.drawInt(Integer.parseInt(res), 0, 0);
		
		try {
			Thread.currentThread();
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		

		//robot.rotateRight();
	}
}
