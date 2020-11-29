
package contest2020.c;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class IsoContest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Graph g = new Graph(N);
		for (int i = 0; i < N - 1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			g.addEdge(a, b);
		}
		System.out.print(1);
		for (int i = 0; i < 9; i++) {
			System.out.print(" " + g.bfs(0, i + 1));
			
		}
	}
}

class Graph {
	
	private int vertices;
	
	List<LinkedList<Integer>> adjacents;
	
	public Graph(int vertices) {
		adjacents = new ArrayList<>();
		
		for (int i = 0; i < vertices; i++) {
			adjacents.add(new LinkedList<>());
		}
		this.vertices = vertices;
	}
	
	public void addEdge(int v, int w) {
		adjacents.get(w).addLast(v);
	}
	
	public int bfs(int s, int l) {
		
		boolean[] visited = new boolean[vertices];
		int[] level = new int[vertices];
		
		for (int i = 0; i < vertices; i++) {
			visited[i] = false;
			level[i] = 0;
		}
		
		LinkedList<Integer> queue = new LinkedList<>();
		visited[s] = true;
		level[s] = 0;
		queue.addLast(s);
		
		while (!queue.isEmpty()) {
			s = queue.getFirst();
			queue.removeFirst();
			
			LinkedList<Integer> list = adjacents.get(s);
			for (Integer val : list) {
				if (!visited[val]) {
					visited[val] = true;
					level[val] = level[s] + 1;
					queue.addLast(val);
				}
			}
		}
		
		int count = 0;
		for (int i = 0; i < vertices; i++) {
			if (level[i] == l) {
				count++;
			}
		}
		
		return count;
	}
}
