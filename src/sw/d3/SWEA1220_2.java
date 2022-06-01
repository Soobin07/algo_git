package sw.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1220_2 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("data/sw/input1220.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		
		int T = 10;
		for(int t = 1 ; t <= T ; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			
			//맵 작성
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < N ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//A를 찾아서 내려보낸다
			//겹치는 A는 flag로 구분한다
			//A와 B가 만날 때 count 해준다
			int count = 0;
			for(int j = 0 ; j < N ; j++) {
				boolean flag = false;
				for(int i = 0 ; i < N ; i++) {
					if(map[i][j] == 1) {
						flag = true;
					}else if(map[i][j] == 2){
						if(flag) {
							count++;
							flag = false;
						}
					}
				}
			}
			System.out.printf("#%d %d %n", t, count);
		}
	}
}
