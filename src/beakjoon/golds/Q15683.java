package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15683 {
	static int[] direction;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int[][] map;
	static int N, M, cctv_cnt, ans, tmp_ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ans = Integer.MAX_VALUE;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		cctv_cnt = 0;
		
		map = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] >= 1 && map[i][j] <= 5)
					cctv_cnt++;
			}
		}
		
		direction = new int[cctv_cnt];
		selectDir(0);
		System.out.println(ans);
	}
	static void selectDir(int idx) {
		if(idx == cctv_cnt) {
			findCctv();
			return;
		}
		for(int i = 0 ; i < 4 ; i++) {
			direction[idx] = i;
			selectDir(idx+1);
		}
	}
	static void findCctv() {
		int tmp_cctv = 0;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(map[i][j] >= 1 && map[i][j] <= 5) {
					switch(map[i][j]) {
						case 1 : cctv_1(tmp_cctv, i, j); break;
						case 2 : cctv_2(tmp_cctv, i, j); break;
						case 3 : cctv_3(tmp_cctv, i, j); break;
						case 4 : cctv_4(tmp_cctv, i, j); break;
						case 5 : cctv_5(tmp_cctv, i, j); break;
					}
					tmp_cctv++;
				}
			}
		}
		clear();
		ans = Math.min(tmp_ans, ans);
	}
	static void clear() {
		tmp_ans = 0;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(map[i][j] == 0)
					tmp_ans++;
				if(map[i][j] == 7)
					map[i][j] = 0;
			}
		}
	}
	static void cctv_1(int tmp_cctv, int i, int j) {
		while(true) {
			i += dr[direction[tmp_cctv]];
			j += dc[direction[tmp_cctv]];
			if(i < 0 || i >= N || j < 0 || j >= M )
				return;
			if(map[i][j] == 6)
				return;
			if(map[i][j] == 0) {
				map[i][j] = 7;
			}
		}
	}
	static void cctv_2(int tmp_cctv, int i, int j) {
		for(int k = 0 ; k < 2 ; k++) {
			int tmp_i = i;
			int tmp_j = j;
			int tmp_d = direction[tmp_cctv] % 2 + k*2;
			if(tmp_d >= 4)
				tmp_d -= 4;
			while(true) {
				tmp_i += dr[tmp_d];
				tmp_j += dc[tmp_d];
				if(tmp_i < 0 || tmp_i >= N || tmp_j < 0 || tmp_j >= M )
					break;
				if(map[tmp_i][tmp_j] == 6)
					break;
				if(map[tmp_i][tmp_j] == 0) {
					map[tmp_i][tmp_j] = 7;
				}
			}
		}
	}
	static void cctv_3(int tmp_cctv, int i, int j) {
		for(int k = 0 ; k < 2 ; k++) {
			int tmp_i = i;
			int tmp_j = j;
			int tmp_d = direction[tmp_cctv] + k;
			if(tmp_d >= 4)
				tmp_d -= 4;
			while(true) {
				tmp_i += dr[tmp_d];
				tmp_j += dc[tmp_d];
				if(tmp_i < 0 || tmp_i >= N || tmp_j < 0 || tmp_j >= M )
					break;
				if(map[tmp_i][tmp_j] == 6)
					break;
				if(map[tmp_i][tmp_j] == 0) {
					map[tmp_i][tmp_j] = 7;
				}
			}
		}
	}
	static void cctv_4(int tmp_cctv, int i, int j) {
		for(int k = 0 ; k < 4 ; k++) {
			if(k == direction[tmp_cctv])
				continue;
			int tmp_i = i;
			int tmp_j = j;
			while(true) {
				tmp_i += dr[k];
				tmp_j += dc[k];
				if(tmp_i < 0 || tmp_i >= N || tmp_j < 0 || tmp_j >= M )
					break;
				if(map[tmp_i][tmp_j] == 6)
					break;
				if(map[tmp_i][tmp_j] == 0) {
					map[tmp_i][tmp_j] = 7;
				}
			}
		}
	}
	static void cctv_5(int tmp_cctv, int i, int j) {
		for(int k = 0 ; k < 4 ; k++) {
			int tmp_i = i;
			int tmp_j = j;
			while(true) {
				tmp_i += dr[k];
				tmp_j += dc[k];
				if(tmp_i < 0 || tmp_i >= N || tmp_j < 0 || tmp_j >= M )
					break;
				if(map[tmp_i][tmp_j] == 6)
					break;
				if(map[tmp_i][tmp_j] == 0) {
					map[tmp_i][tmp_j] = 7;
				}
			}
		}
	}
}
