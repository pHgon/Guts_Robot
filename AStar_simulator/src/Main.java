import java.util.ArrayList;

public class Main {
	
	public static Node[][] world;
	
	public static ArrayList<Byte> bubbleSort(ArrayList<Byte> list){
		byte i, j;
		byte index_i, index_j, dist1, dist2; //dist1 e 2 sao os nodos a serem comparados
		
		for(i = 0; i < list.size(); i++) {	
			for(j = (byte) (i + 1); j < list.size(); j++) {	
				index_i = list.get(i);
				dist1 = (byte) ((int)world[(int)decodeIndex(index_i, true)][(int)decodeIndex(index_i, false)].end_dist + (int)world[(int)decodeIndex(index_i, true)][(int)decodeIndex(index_i, false)].init_dist);
				
				index_j = list.get(j);
				dist2 = (byte) ((int)world[(int)decodeIndex(index_j, true)][(int)decodeIndex(index_j, false)].end_dist + (int)world[(int)decodeIndex(index_j, true)][(int)decodeIndex(index_j, false)].init_dist);
				if (dist1 > dist2) {
					list.set(i, index_j);
					list.set(j, index_i);
				}
			}
		}
		
		return list;
	}
	
	public static byte manhattanDistance(byte a, byte b, byte c, byte d) {
		return (byte) (Math.abs(a-c) + Math.abs(b-d));
	}
	
	public static byte encodeIndex(byte i, byte j) {
		return Byte.parseByte(Byte.toString(i) + Byte.toString(j));
	}
	
	public static byte decodeIndex(byte value, boolean op) {
		if(op)
			return (byte) (Byte.parseByte(((Byte.toString(value)).substring(0, 1))) - 1);
		else
			return (byte) (Byte.parseByte(((Byte.toString(value)).substring(1, 2))) - 1);
	}
	
	public void insertOrdered(byte i, byte j, ArrayList<Byte> list) {	
		list.add(encodeIndex(i, j));
		
		bubbleSort(list);
	}
	
	public static void main(String[] args) {
		byte i, j;
		byte i_start = 4; 
		byte j_start = 3;
		byte i_end 	 = 1; 
		byte j_end 	 = 2;
		byte index;
		
		Robot guts = new Robot(i_start, j_start);

		world = new Node[5][5];
		
		ArrayList<Byte> closed_set = new ArrayList();
		ArrayList<Byte> open_set = new ArrayList();
		
		for(i = 0; i < 5; i++) {
			for(j = 0; j < 5; j++) {	
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
		
		
		world[2][3].is_obstacle = true;
		world[2][2].is_obstacle = true;
		world[2][1].is_obstacle = true;
		world[1][1].is_obstacle = true;
		
		open_set.add(encodeIndex((byte) (i_start + 1), (byte) (j_start + 1)));
				
		while (!open_set.isEmpty()) {
			index = open_set.get(0);
			open_set.remove(0);
			closed_set.add(index);
			
			i = (byte) (decodeIndex(index, true));
			j = (byte) (decodeIndex(index, false));
			
			if(world[i][j].is_end) {
				System.out.println("FIM");
				break;
			}
			
			guts.curr_node_i = i;
			guts.curr_node_j = j;
			
			System.out.println("Nodo atual: " + i + "," + j);
			if ((i - 1) >= 0){
				if(!world[i-1][j].is_obstacle && !closed_set.contains((byte)((i-1)*10 + j + 11)) && !open_set.contains((byte)((i-1)*10 + j + 11))) {
					open_set.add(encodeIndex((byte) (i - 1 + 1), (byte) (j + 1)));
					world[i-1][j].init_dist = manhattanDistance(i_start, j_start, (byte)(i - 1), (byte)(j));
					world[i-1][j].end_dist = manhattanDistance((byte)(i - 1), (byte)(j), i_end, j_end);
				}
			}
			if ((j - 1) >= 0){
				if(!world[i][j-1].is_obstacle && !closed_set.contains((byte)(i*10 + j - 1 + 11)) && !open_set.contains((byte)(i*10 + j - 1 + 11))) {
					open_set.add(encodeIndex((byte) (i + 1), (byte) (j + 1 - 1)));
					world[i][j-1].init_dist = manhattanDistance(i_start, j_start, (byte)(i), (byte)(j-1));
					world[i][j-1].end_dist = manhattanDistance((byte)(i), (byte)(j-1), i_end, j_end);
				}
			}
			if ((j + 1) < 5){
				if(!world[i][j+1].is_obstacle && !closed_set.contains((byte)(i*10 + j + 1 + 11)) && !open_set.contains((byte)(i*10 + j + 1 + 11))) {
					open_set.add(encodeIndex((byte) (i + 1), (byte) (j + 1 + 1)));
					world[i][j+1].init_dist = manhattanDistance(i_start, j_start, (byte)(i), (byte)(j+1));
					world[i][j+1].end_dist = manhattanDistance((byte)(i), (byte)(j+1), i_end, j_end);
				}
			}

			/* ORDENA A LISTA DOS NAO-VISITADOS POR DISTANCIA TOTAL */
			open_set = bubbleSort(open_set);
		
		}
	}
}
