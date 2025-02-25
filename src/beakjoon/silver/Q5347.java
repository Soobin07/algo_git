package beakjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q5347 {
	// 최대공약수(GCD) 구하는 함수 (유클리드 호제법)
	public static long gcd(long a, long b) {
		while (b != 0) {
			long temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

	// 최소공배수(LCM) 구하는 함수
	public static long lcm(long a, long b) {
		return (a * b) / gcd(a, b);
	}

	public static void main(String[] args) throws IOException {
		// 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

		// 각 테스트 케이스마다 a와 b를 읽어 최소공배수를 계산
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			System.out.println(lcm(a, b));
		}
	}
}
