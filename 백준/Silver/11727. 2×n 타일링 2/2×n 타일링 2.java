import java.util.Scanner;

public class Main {
	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if(N > 1) {
			dp = new int[N+1];
			dp[1] = 1; 
			dp[2] = 3;
			
			for(int i = 3 ; i <= N ; i++) {
				dp[i] = (2*dp[i-2]+dp[i-1])%10007;
			}
			
			System.out.println(dp[N]%10007);
		}else {
			System.out.println(1);
		}
	}
}
