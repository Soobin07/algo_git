package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q16918 {
	static char[][] map;
	static int time;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		//기본 정보(열, 행, Time) 받기
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		//Map 넣기
		map = new char[R][C];
		for(int i = 0 ; i < R ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < C ; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		boolean all = false;
		//1초 : 가만히
		time++;
		while(time < N) {
			//2초 : 모든 곳에 설치하기
			time++;
			if(time == N) {
				all = true;
				break;
			}
			//3초 : 폭발
			time++;
			bumb();
			if(time == N) {
				all = false;
				break;
			}
		}
		if(all) {
			for(int i = 0 ; i < R ; i++) {
				for(int j = 0 ; j < C ; j++) {
					bw.append('O');
				}
				bw.append('\n');
			}
		}else {
			for(int i = 0 ; i < R ; i++) {
				for(int j = 0 ; j < C ; j++) {
					bw.append(map[i][j]);
				}
				bw.append('\n');
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
	static void bumb() {
		int[] dr = {-1, 0, 0, 1};
		int[] dc = {0, -1, 1, 0};
		char[][] tmp = new char[map.length][map[0].length];
		for(int i = 0 ; i < map.length ; i++) {
			for(int j = 0 ; j < map[i].length ; j++) {
				tmp[i][j] = 'O';
			}
		}
		for(int i = 0 ; i < map.length ; i++) {
			for(int j = 0 ; j < map[i].length ; j++) {
				if(map[i][j] == 'O') {
					tmp[i][j] = '.';
					for(int k = 0 ; k < 4 ; k++) {
						if(i+dr[k] >= map.length || i+dr[k] < 0 || j+dc[k] >= map[i].length || j+dc[k] < 0)
							continue;
						tmp[i+dr[k]][j+dc[k]] = '.';
					}
				}
			}
		}
		map = tmp;
	}
}
