package sw.d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2001 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("data/sw/input2001.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int N, M, max_sum, sum;
		int[][] map;
		for(int t = 1 ; t <= T ; t++) {
			max_sum = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			
			//맵에 파리 넣기
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < N ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//완전탐색
			for(int i = 0 ; i <= N-M ; i++) {
				for(int j = 0 ; j <= N-M ; j++) {	//여기까지 기준점 잡기
					sum = 0;
					for(int k = 0 ; k < M ; k++) {
						for(int k2 = 0; k2 < M ; k2++) {	//기준점부터 M*M돌며 더하기
							sum+= map[i+k][j+k2];
						}
					}
					if(max_sum < sum) max_sum = sum;
				}
			}
			
			sb.append("#").append(t).append(" ").append(max_sum).append("\n");
		}
		System.out.print(sb.toString());
	}
}
