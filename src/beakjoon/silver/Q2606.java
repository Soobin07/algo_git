package beakjoon.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2606 {
	static int[][] link;
	static boolean[] visited;
	static int N, M, ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		visited = new boolean[N+1];
		
		M = sc.nextInt();
		link = new int[M][];
		for(int i = 0 ; i < M ; i++) {
			link[i] = new int[] {sc.nextInt(), sc.nextInt()};
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visited[1] = true;
		while(!q.isEmpty()) {
			int com = q.poll();
			for(int i = 0 ; i < M ; i++) {
				int combi = 0;
				if(com == link[i][0]) combi = link[i][1];
				if(com == link[i][1]) combi = link[i][0];
				
				if(combi != 0 && !visited[combi]) {
					visited[combi] = true;
					q.add(combi);
				}
			}
		}
		
		int cnt = 0;
		for(int i = 1 ; i <= N ; i++) {
			if(visited[i]) cnt++;
		}
		
		System.out.println(cnt-1);
	}
}
