import java.util.Scanner;

public class Main {
	static int[] dp, cost;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		dp = new int[N+1];	
		cost = new int[N+1];
		
		for(int i = 1 ; i <= N ; i++) {
			cost[i] = sc.nextInt();
		}	//입력
		
		dp[1] = cost[1];
		for(int i = 2 ; i <= N ; i++) {
			dp[i] = cost[i];
			for(int j = 1 ; j < i ; j++) {
				dp[i] = Math.max(dp[i-j]+dp[j], dp[i]);
			}
		}
		System.out.println(dp[N]);
	}
}
