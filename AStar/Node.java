
public class Node {
	public byte end_dist;      // Distancia nodo Atual ate o Fim
	public byte init_dist; 	   // Distancia nodo Inicial ate o Atual
	public boolean is_obstacle; // E obstaculo
	public boolean is_end;      // E posicao Fim
	public boolean is_start;    // E posicao Inicio
	
	
	public Node(boolean start, boolean end) {
		this.end_dist = 0;
		this.init_dist = 0;
		this.is_obstacle = false;
		this.is_end = end;
		this.is_start = start;
	}
	
}
