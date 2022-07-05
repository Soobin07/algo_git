import java.util.Scanner;

public class Main {
	static int C = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 0 ; t < T ; t++) {
			int N = sc.nextInt();
			C = 0;	//답 초기화
			sum(N, 0);
			System.out.println(C);
		}
	}
	public static void sum(int N, int S) {
		if(S >= N) {	
			//다 더해서 N 되면
			if(S == N) C++;
			return;
		}
		for(int i = 1 ; i <= 3 ; i++) {
			sum(N, S+i);
		}
	}
}
