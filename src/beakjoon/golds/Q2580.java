package beakjoon.golds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2580 {
	static ArrayList<int[]> zeros;	//0의 좌표
	static int[][] map;	//스도쿠 판
	static boolean isEnd;	//끝났나?
	public static void main(String[] args) throws Exception {
		//io 관련 변수 선언 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		//필드변수 초기화
		zeros = new ArrayList<>();
		map = new int[9][9];
		
		//스도쿠 판 넣어주기 + 0의 좌표 넣어주기
		for(int i = 0 ; i < 9 ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 9 ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0)
					zeros.add(new int[] {i, j});
			}
		}
		
		//채우기 위한 함수 호출
		fill_map(0);
		
		//스도쿠 판 출력하기
		for(int i = 0 ; i < 9 ; i++) {
			bw.append(Arrays.toString(map[i]).replaceAll("[\\[\\,\\]]", "")+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	static void fill_map(int zero_idx) {
		if(isEnd)
			return;
		if(zeros.size() == zero_idx && !isEnd) {
			isEnd = true;
			return;
		}
		int[] map_idx = zeros.get(zero_idx);
		outer : for(int i = 1 ; i <= 9 ; i++) {
			//해당 칸에 1~9까지 채운다 가정했을 때,
			//가로로 겹치는거 없는지 확인
			for(int j = 0 ; j < 9 ; j++) {
				if(map[map_idx[0]][j] == i)
					continue outer;
			}
			//세로로 겹치는거 없는지 확인
			for(int j = 0 ; j < 9 ; j++) {
				if(map[j][map_idx[1]] == i)
					continue outer;
			}
			//3*3에 겹치는거 없는지 확인
			for(int r = (map_idx[0]/3)*3 ; r < (map_idx[0]/3)*3 + 3 ; r++) {
				for(int c = (map_idx[1]/3)*3 ; c < (map_idx[1]/3)*3 + 3 ; c++) {
					if(map[r][c] == i)
						continue outer;
				}
			}
			
			//겹치는거 없으면 칸 채우고 다음 칸 채우러 가보자
			map[map_idx[0]][map_idx[1]] = i;
			fill_map(zero_idx+1);
			
		}
		//다 돌았는데 답이 없다면 초기화 시키자
		if(!isEnd)
			map[map_idx[0]][map_idx[1]] = 0;
	}
}
