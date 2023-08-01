package beakjoon.golds;

import java.util.Arrays;
import java.util.Scanner;

public class Q2661 {
	static int[] sel;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		sel = new int[N];
		find(0);
	}
	
	static void find(int cnt) {
		// N자리 완성되면 종료
		if(cnt == N ) {
			System.out.println(Arrays.toString(sel).replaceAll("[\\[, \\]]", ""));
			System.exit(0);
		}
		
		// 1~3을 넣는다
		for(int i = 1 ; i <= 3 ; i++) {
			sel[cnt] = i;
			if(isOK(cnt+1))
				find(cnt+1);
		}
	}
	
	static boolean isOK(int cnt) {
		// 이전까지 숫자들과 비교한다 (비교할 수열 길이)
		inner : for(int n = 1 ; n <= cnt/2 ; n++) {
			//비교할 수열 칸
			for(int j = 1 ; j <= n ; j++) {
				if(sel[cnt - j - n] != sel[cnt - j]) {
					continue inner;
				}
			}
			// 나쁜 수열 확인
			return false;
		}
		return true;
	}
}
