import java.util.ArrayList;

public class Main {
	
	public static Node[][] world;
	
	public void bubbleSort(ArrayList<Byte> list){
		byte i, j;
		
		for(i = 0; i < list.size(); i++) {
			for(j = 1; j < i; j++) {
			}
		}
	}
	
	public static byte manhattanDistance(byte a, byte b, byte c, byte d) {
		return (byte) Math.sqrt(Math.pow((a-c), 2)+Math.pow((b-d), 2));
	}
	
	public static byte encodeIndex(byte i, byte j) {
		return Byte.parseByte(Byte.toString(i) + Byte.toString(j));
	}
	
	public static byte decodeIndex(byte value, boolean op) {
		if(op) {
			return Byte.parseByte(((Byte.toString(value)).substring(0, 1)));
		}
		else
			return Byte.parseByte(((Byte.toString(value)).substring(1, 2)));
	}
	
	public void insertOrdered(byte i, byte j, ArrayList<Byte> list) {	
		list.add(encodeIndex(i, j));
		
		bubbleSort(list);
	}
	
	public static void main(String[] args) {
	
		byte i, j;
		byte i_start = 0; 
		byte j_start = 0;
		byte i_end 	 = 7; 
		byte j_end 	 = 7;
		byte index;
		
		Robot robot = new Robot();

		world = new Node[8][8];
		
		ArrayList<Byte> closed_set = new ArrayList();
		ArrayList<Byte> open_set = new ArrayList();
		
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
		}
		
		world[i_start][j_start].end_dist = manhattanDistance(i_start, j_start, i_end, j_end);
		
		open_set.add(encodeIndex(i_start, j_start));
		
		while (!open_set.isEmpty()) {
			index = open_set.get(0);
			open_set.remove(0);
			closed_set.add(index);
			
			i = decodeIndex(index, true);
			j = decodeIndex(index, false);
			
			if(world[i][j].is_end) {
				System.out.println("FIM");
				break;
			}
			
			if(robot.dir.equalsIgnoreCase("norte")) {
				if(!world[i-1][j].is_obstacle)
					open_set.add((byte) 0);
				if(!world[i][j-1].is_obstacle)
					open_set.add((byte) 0);
				if(!world[i][j+1].is_obstacle)
					open_set.add((byte) 0);
			} else if(robot.dir.equalsIgnoreCase("sul")) {
				if(!world[i+1][j].is_obstacle)
					open_set.add((byte) 0);
				if(!world[i][j-1].is_obstacle)
					open_set.add((byte) 0);
				if(!world[i][j+1].is_obstacle)
					open_set.add((byte) 0);
			} else if(robot.dir.equalsIgnoreCase("leste")) {
				if(!world[i][j+1].is_obstacle)
					open_set.add((byte) 0);
				if(!world[i-1][j].is_obstacle)
					open_set.add((byte) 0);
				if(!world[i+1][j].is_obstacle)
					open_set.add((byte) 0);
			} else if(robot.dir.equalsIgnoreCase("leste")) {
				if(!world[i][j-1].is_obstacle)
					open_set.add((byte) 0);
				if(!world[i-1][j].is_obstacle)
					open_set.add((byte) 0);
				if(!world[i+1][j].is_obstacle)
					open_set.add((byte) 0);
			}
		}
	}
}
