package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//다리 만들기
public class Q2146_2 {
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int N, island_no, min;
	static int[][] islands, cost;
	static Queue<int[]> numbering_queue;
	static Queue<int[]> all_queue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		islands = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				islands[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		numbering_queue = new LinkedList<>();
		all_queue = new LinkedList<>();
		island_no = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (islands[i][j] != 1)
					continue;
				numbering_islands(i, j);
			}
		}

		min = Integer.MAX_VALUE;
		cost = new int[N][N];
		bridge();

		System.out.println(min);
	}

	static void numbering_islands(int ori_r, int ori_c) {
		numbering_queue.clear();
		island_no++;
		islands[ori_r][ori_c] = island_no;
		int[] first_land = { ori_r, ori_c, island_no };
		numbering_queue.add(first_land);
		all_queue.add(first_land);

		while (!numbering_queue.isEmpty()) {
			int[] node = numbering_queue.poll();
			for (int d = 0; d < 4; d++) {
				int r = node[0] + dr[d];
				int c = node[1] + dc[d];
				if (r < 0 || c < 0 || r >= N || c >= N)
					continue;
				if (islands[r][c] != 1)
					continue;

				islands[r][c] = island_no;
				int[] now = new int[] { r, c, island_no };
				numbering_queue.add(now);
				all_queue.add(now);
			}
		}
	}

	static void bridge() {
		while (!all_queue.isEmpty()) {
			int[] node = all_queue.poll();
			int len = cost[node[0]][node[1]];
			for (int d = 0; d < 4; d++) {
				int r = node[0] + dr[d];
				int c = node[1] + dc[d];
				if (r < 0 || c < 0 || r >= N || c >= N)
					continue;
				int isNum = islands[r][c];

				if (isNum == node[2])
					continue;
				if (isNum == 0) {
					cost[r][c] = len + 1;
					islands[r][c] = node[2];
					all_queue.add(new int[] { r, c, node[2] });
				} else {
					min = Math.min(min, len + cost[r][c]);
				}
			}
		}
	}
}
