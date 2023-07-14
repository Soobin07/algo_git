package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11051 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long[][] pascal = new long[N+1][N+1];
		
		pascal[0][0] = 1;
		for(int i = 0 ; i < N+1 ; i++) {
			for(int j = 0 ; j <= i ; j++) {
				if(j == 0)
					pascal[i][j] = 1;
				else if(j == i)
					pascal[i][j] = 1;
				else
					pascal[i][j] = (pascal[i-1][j-1] + pascal[i-1][j]) % 10007;
			}
		}
		
		System.out.println(pascal[N][K]);
	}
}