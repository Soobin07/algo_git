import java.util.Scanner;

public class Main {	//RGB거리
	static int min;	//최소값
	static int N;	//집의 갯수
	static int[][] cost;	//집 칠하는 비용
	static int[][] dp;	//집 칠하는 비용들의 최소비용
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		cost = new int[N+1][3];
		dp = new int[N+1][3];
		
		cost[0][0] = cost[0][1] = cost[0][2] = 0;
		dp[0][0] = dp[0][1] = dp[0][2] = 0;
		for(int i = 1 ; i <= N ; i++) {
			cost[i][0] = sc.nextInt();	//R
			cost[i][1] = sc.nextInt();	//G
			cost[i][2] = sc.nextInt();	//B
		}	//cost 입력 완료
		
		 for(int i = 1 ; i <= N ; i++) {
			 dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2])+cost[i][0];
			 dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2])+cost[i][1];
			 dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1])+cost[i][2];
		 }
		 
		 System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));
	}
}
