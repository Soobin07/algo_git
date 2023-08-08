package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q17086 {
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		boolean[][] visit = new boolean[N][M];
		
		Queue<int[]> que = new LinkedList<>();
		//map넣기
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				//아기상어 있는 곳에
				//1. map에 1 표시
				//2. que에 넣기
				if(st.nextToken().equals("1")) {
					map[i][j] = 1;
					int[] tmp = new int[] {i,j};
					que.add(tmp);
					visit[i][j] = true;
				}
			}
		}
		
		int[][] dist = new int[N][M];
		
		int[] dirX = {-1, -1, -1, 0, 0, 1, 1, 1};
		int[] dirY = {-1, 0, 1, -1, 1, -1, 0, 1};
		while(!que.isEmpty()) {
			int[] now = que.poll();
			for(int i = 0 ; i < 8 ; i++) {
				int[] next = {now[0]+dirX[i], now[1]+dirY[i]};
				if(next[0] >= N || next[1] >= M || next[0] < 0 || next[1] < 0)
					continue;
				if(visit[next[0]][next[1]])
					continue;
				visit[next[0]][next[1]] = true;
				dist[next[0]][next[1]] = dist[now[0]][now[1]] + 1;
				que.add(next);
			}
		}
		
		int max = 0;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				max = Math.max(max, dist[i][j]);
			}
		}
		
		System.out.println(max);
	}
}
