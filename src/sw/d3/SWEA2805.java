package sw.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class SWEA2805 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("data/sw/input2805.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1 ; t <= T ; t++) {
			int N = Integer.parseInt(br.readLine());	//농장 크기 N
			int[][] map = new int[N][N];
			
			//맵 넣기
			for(int i = 0 ; i < N ; i++) {
				String line = br.readLine();
				for(int j = 0 ; j < N ; j++) {
					map[i][j] = line.charAt(j)-'0';
				}
			}
			
			int val = 0;
			//제일 위 ~ N/2 까지
			for(int i = 0 ; i <= N/2 ; i++) {
				val += map[i][N/2];
				for(int j = 1 ; j <= i ; j++) {
					val += map[i][N/2+j];
					val += map[i][N/2-j];
				}
			}
			// N/2+1 ~ 끝까지
			for(int i = N-1; i > N/2 ; i--) {
				val += map[i][N/2];
				for(int j = 1 ; j <= N-1-i ; j++) {
					val += map[i][N/2+j];
					val += map[i][N/2-j];
				}
			}
			sb.append("#").append(t).append(" ").append(val).append("\n");
		}
		System.out.print(sb.toString());
	}
}
