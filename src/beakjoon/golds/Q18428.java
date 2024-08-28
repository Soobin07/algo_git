package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q18428 {
	static char[][] map;					//맵
	static boolean isOK;					//가능한가
	static int tec_cnt;						//선생님 수
	static int[][] tecs;	//선생님들
	//4방 이동 위한 것
	static int[] dr = {-1, 0, 0, 1};
	static int[] dc = {0, 1, -1, 0};
	
	//장애물 칸 찾기
	static int[] select = new int[3];	//선택한 장애물 칸
	static int[][] void_map;			//빈 칸	
	static int void_cnt;				//빈 칸 숫자
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		tec_cnt = 0;
		void_cnt = 0;
		map = new char[N][N];
		void_map = new int[N*N][2];
		tecs = new int[N*N][2];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if(map[i][j] == 'T') {
					tecs[tec_cnt][0] = i; 
					tecs[tec_cnt][1] = j; 
					tec_cnt++;
				}else if(map[i][j] == 'S') {
					continue;
				}else {
					void_map[void_cnt][0] = i;
					void_map[void_cnt][1] = j;
					void_cnt++;
				}
			}
		}
		
		//빈 칸 중에 nC3 하기 -> 해당 위치에 장애물 넣고 확인하기
		select(0, 0);
		if(isOK)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
	static void select(int idx, int sel) {
		//3개 선택하면 장애물넣고 확인하는 시뮬레이션
		if(sel == 3) {
			//시뮬레이션 성공하면 가능한 것이다
			if(semulation()) {
				isOK = true;
			};
			return;
		}
		//3개 선택 다 못했는데 끝까지 가면 그냥 패스해라
		if(idx == void_cnt) {
			return;
		}
		select[sel] = idx;
		select(idx+1, sel+1);
		select(idx+1, sel);
	}
	static boolean semulation() {
		//임시로 장애물 3개 설치하자
		setObsToMap('O');
		//선생님별로 확인
		for(int t = 0 ; t < tec_cnt ; t++) {
			//4방위 확인
			for(int k = 0 ; k < 4 ; k++) {
				int tecR = tecs[t][0];
				int tecC = tecs[t][1];
				while(true) {
					tecR += dr[k];
					tecC += dc[k];
					//한번 벗어나면? 다음도 계속 벗어난다. 벗어나면 패스하자
					if(tecR >= map.length || tecR < 0 || tecC >= map.length || tecC < 0) {
						break;
					}
					//장애물에 닿으면? 그 다음은 못간다. 패스하자
					if(map[tecR][tecC] == 'O') {
						break;
					}
					//학생에 닿으면? GG 이번 MAP 확인할 필요가 없다
					if(map[tecR][tecC] == 'S') {
						setObsToMap('X');
						return false;
					}
				}
			}
		}
		//임시로 설치한 장애물 돌려놓자
		setObsToMap('X');
		//모든 선생님들이 학생에 닿지 않았다
		return true;
	}
	static void setObsToMap(char Ch) {
		for(int i = 0 ; i < 3 ; i++) {
			map[void_map[select[i]][0]][void_map[select[i]][1]] = Ch;
		}
	}
}
