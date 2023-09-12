package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q9251 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//String 2개를 받는다
		String str_A = br.readLine();
		String str_B = br.readLine();
		
		//String A와 B의 charAt을 비교하여 같아질 수 있는 숫자를 찾는다
		int[][] dp = new int[str_A.length()+1][str_B.length()+1];
		
		for(int i = 1 ; i <= str_A.length() ; i++) {
			for(int j = 1 ; j <= str_B.length() ; j++) {
				if(str_A.charAt(i-1) == str_B.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1]+1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		System.out.println(dp[str_A.length()][str_B.length()]);
	}
}
