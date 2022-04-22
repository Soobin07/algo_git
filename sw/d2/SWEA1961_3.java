package sw.d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//주성님 아이디어
//크게 도는 것을 밖의 인덱스로, 작게 도는 것을 안의 인덱스로
//인덱스 조절해서 푸는 방법
public class SWEA1961_3 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("data/sw/input1961.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());

			int[][] arr = new int[N][N]; // ori

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb.append("#").append(t).append("\n");
			for(int i = 0 ; i < N ; i++) {
				for(int j = N-1 ; j >= 0 ; j--)sb.append(arr[j][i]);
				sb.append(" ");
				for(int j = N-1 ; j >= 0 ; j--)sb.append(arr[N-1 -i][j]);
				sb.append(" ");
				for(int j = 0 ; j < N ; j++) sb.append(arr[j][N-1-i]);
				sb.append("\n");
			}
		}
		System.out.print(sb.toString());
	}
}
