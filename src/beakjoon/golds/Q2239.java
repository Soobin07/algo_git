package beakjoon.golds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Q2239 {
	static int[][] map;
	static ArrayList<int[]> zero;
	static boolean isEnd;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 빈 칸 넣기
		zero = new ArrayList<>();
		// 맵 만들어 넣기
		map = new int[9][9];
		for (int i = 0; i < 9; i++) {
			String str = br.readLine();
			for (int j = 0; j < 9; j++) {
				map[i][j] = str.charAt(j) - '0';
				if (map[i][j] == 0) {
					zero.add(new int[] { i, j });
				}
			}
		}

		// 하나씩 넣어보며 확인
		check(0);
	}

	static void check(int idx) throws Exception {
		if(isEnd) {
			return;
		}
		if(idx >= zero.size()) {
			isEnd = true;
			print(map);
			return;
		}
		
		/*
		System.out.println(idx);
		print(map);
		System.out.println("========================");
		*/
		
		int[] dir = zero.get(idx);
		for (int i = 1; i <= 9; i++) {
			map[dir[0]][dir[1]] = i;
			boolean flag = true;
			// 세로 확인
			if (flag) {
				for (int j = 0; j < 9; j++) {
					if (j != dir[0] && map[j][dir[1]] == i) {
						// 통과 못함
						flag = false;
						break;
					}
				}
			}
			// 가로 확인
			if (flag) {
				for (int j = 0; j < 9; j++) {
					if (j != dir[1] && map[dir[0]][j] == i) {
						// 통과 못함
						flag = false;
						break;
					}
				}
			}
			// 3*3 확인
			if (flag) {
				outer : for(int r = (dir[0]/3)*3 ; r < (dir[0]/3)*3 + 3 ; r++) {
					for(int c = (dir[1]/3)*3 ; c < (dir[1]/3)*3 + 3 ; c++) {
						if(!(r == dir[0] && c == dir[1]) && map[r][c] == i) {
							//통과 못함
							flag = false;
							break outer;
						}
					}
				}
			}
			// 다음 수 확인해보자
			if (flag) {
				check(idx + 1);
			}
			// 안되면 0으로 변경
			map[dir[0]][dir[1]] = 0;
		}
	}
	static void print(int[][] map) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0 ; i < map.length ; i++) {
			for(int j = 0 ; j < map[i].length ; j++) {
				bw.append(map[i][j]+"");
			}
			bw.append("\n");
		}
		bw.flush();
		//bw.close();
	}
}
