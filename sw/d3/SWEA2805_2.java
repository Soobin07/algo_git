package sw.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class SWEA2805_2 {
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
			//가운데 점 좌표와 값의 차이가 N/2인 곳 모두 수확
			int val = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(Math.abs(i-N/2)+Math.abs(j-N/2) <= N/2) val+= map[i][j];
				}
			}
			sb.append("#").append(t).append(" ").append(val).append("\n");
		}
		System.out.print(sb.toString());
	}
}
