import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] amount = new int[N+1];
		for(int i = 1 ; i <= N ; i++) {
			amount[i] = sc.nextInt();
		}
		
		int max = 0;
		
		if(N == 1) {
			max = amount[1];
		}else if(N == 2) {
			max = amount[1]+amount[2];
		}else {
			int[] dp = new int[N+1];
			dp[1] = amount[1];
			dp[2] = dp[1]+amount[2];
			for(int i = 3 ; i <= N ; i++) {
				dp[i] = Math.max(dp[i-1], amount[i] + Math.max(dp[i-2], dp[i-3]+amount[i-1]));
				max = Math.max(max, dp[i]);
			}
		}
		
		System.out.println(max);
	}
}
