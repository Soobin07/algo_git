package sw.d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1961_2 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("data/sw/input1961.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());

			int[][] arr = new int[N][N]; // ori
			int[][] arr1 = new int[N][N]; // 1번째
			int[][] arr2 = new int[N][N]; // 2번째
			int[][] arr3 = new int[N][N]; // 3번째

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			arr1 = turn(arr, N);
			arr2 = turn(arr1, N);
			arr3 = turn(arr2, N);
			
			
			sb.append("#").append(t).append("\n");
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					sb.append(arr1[i][j]);
				}
				sb.append(" ");
				for(int j = 0 ; j < N ; j++) {
					sb.append(arr2[i][j]);
				}
				sb.append(" ");
				for(int j = 0 ; j < N ; j++) {
					sb.append(arr3[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.print(sb.toString());
	}
	static int[][] turn(int[][] ori, int N){
		int[][] arr = new int[N][N];
		int r = 0;
		int c = 0;
		for (int j = 0; j < N; j++) {
			for (int i = N - 1; i >= 0; i--) {
				arr[r][c++] = ori[i][j];
			}
			r++;
			c = 0;
		}
		return arr;
	}
}
