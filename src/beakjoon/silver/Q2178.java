package beakjoon.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2178 {
	static int N, M, answer;
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Node {
		int r;
		int c;
		int dist;

		public Node(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		answer = 0;

		map = new char[N][];
		for (int i = 0; i < N; i++) {
			map[i] = sc.next().toCharArray();
		}
		visited = new boolean[N][M];
		bfs();
		System.out.println(answer);
	}

	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		Node start = new Node(0, 0, 1);
		visited[start.r][start.c] = true;
		q.add(start);

		while (!q.isEmpty()) {
			Node n = q.poll();
			if(n.r == N-1 && n.c == M-1) {
				answer = n.dist;
			}
			for (int i = 0; i < 4; i++) {
				int nr = n.r + dr[i];
				int nc = n.c + dc[i];
				if (nr >= N || nr < 0 || nc >= M || nc < 0)
					continue;
				if(map[nr][nc] == '1' && !visited[nr][nc]) {
					visited[nr][nc] = true;
					q.add(new Node(nr, nc, n.dist+1));
				}
			}
		}
	}
}
