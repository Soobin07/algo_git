package beakjoon.bronze;

import java.util.Scanner;

public class Q4796 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();

		int cnt = 1;
		while (true) {
			// 휴가 V일, 연속하는 P일 중 L일동안만 사용할 수 있다
			int L = sc.nextInt();
			int P = sc.nextInt();
			int V = sc.nextInt();

			// 0,0,0이 나오면 종료한다
			if (L == 0 && P == 0 && V == 0) {
				break;
			}

			// 휴가 V 를 P로 나누어 L을 곱하면 => 그만큼 사용할 수 있음
			// 휴가 나머지를 L과 비교하여 더 작은 것을 더해준다
			int ans = ((V / P) * L) + Math.min(L, (V % P));

			sb.append("Case " + cnt + ": " + ans + "\n");
			cnt++;
		}
		System.out.print(sb.toString());
	}
}
