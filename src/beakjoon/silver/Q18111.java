package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q18111 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		//int[] counting = new int[257];
		int max = 0;
		
		int time = Integer.MAX_VALUE;
		int high = 0;
		
		//map 입력
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				//최빈도값 찾기 위함
				//counting[map[i][j]]++;
				//얘는 그냥 제일 위에서부터 브루트포스로 돌릴 경우
				max = Math.max(max, map[i][j]);
			}
		}
		
		//1. 그냥 가장 높은 값부터 브루트포스로 해결해본다
		int gap, tmp_time, tmp;
		for(int h = 256 ; h >= 0 ; h--) {
			gap = B;	// 필요한 블록 갯수
			tmp_time = 0;	//걸리는 시간
			for(int n = 0 ; n < N ; n++) {
				for(int m = 0 ; m < M ; m++) {
					if(map[n][m] > h) {
						//깎아야 함
						tmp = map[n][m]-h;
						gap += tmp;
						tmp_time += tmp*2;
					}else if(map[n][m] < h) {
						//붙여야 함
						tmp = h - map[n][m];
						gap -= tmp;
						tmp_time += tmp;
					}
				}
			}
			//가능
			if(gap >= 0 && tmp_time < time) {
				time = tmp_time;
				high = h;
			}
		}
		
		System.out.println(time+" "+high);
	}
}
