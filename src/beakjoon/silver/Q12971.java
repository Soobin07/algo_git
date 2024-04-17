package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//숫자 놀이
public class Q12971 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 양의 정수 N을 다른 양의 정수 M으로 나눈 나머지는 0~M-1이하의 정수
		// 양의 정수 X1,2,3 고른다. 양의 정수 P1,2,3고른다
		// 단, P1>X1, P2>X2, P3>X3
		// 조건 만족하는 가장 작은 양의 정수 N
		// 조건
		// N을 P1로 나눈 나머지가 X1, P2로 나눈 나머지가 X2, P3으로 나눈 나머지가 X3

		// => N은 P1, P2, P3
		int P1 = Integer.parseInt(st.nextToken());
		int P2 = Integer.parseInt(st.nextToken());
		int P3 = Integer.parseInt(st.nextToken());
		int X1 = Integer.parseInt(st.nextToken());
		int X2 = Integer.parseInt(st.nextToken());
		int X3 = Integer.parseInt(st.nextToken());

		long max = lcm(lcm(P1, P2), P3);
		long ans = -1;
		for (int i = X1; i <= max; i += P1) {
			if (i % P2 == X2 && i % P3 == X3) {
				ans = i;
				break;
			}
		}

		System.out.println(ans);
	}

	// 최대공약수
	static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	// 최소공배수
	static int lcm(int a, int b) {
		return (a * b) / gcd(a, b);
	}
}
