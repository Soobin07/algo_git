import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();	//tc 갯수 받기
		
		for(int t = 1 ; t <= T ; t++) {	//tc 갯수만큼 돌리기
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			for(int i = 0 ; i < M ; i++) {
				sc.nextInt();
				sc.nextInt();
			}
			System.out.println(N-1);
		}
	}
}
