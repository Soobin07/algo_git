package beakjoon.silver;

import java.util.Scanner;

//약수의 합2
/* 자연수 72의 소인수분해 : 2^3 * 3^2 
 * 양의 약수 갯수 : (3 + 1) * (2 + 1) = 12
 * 양의 약수의 합 : (1 + 2 + 2^2 + 2^3) * (1 + 3 + 3^2) = 195
 * 양의 약수의 곱 : 72^6 (자연수 ^ 약수 갯수/2)
 * 
 * 근데 여기서는 약수의 합(f(a))을 합한 것(g(a))을 찾고 있다
 */
public class Q17427 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long ans = 0L;

		for (int i = 1; i <= N; i++) {
			ans += i * (N / i);
		}

		System.out.println(ans);
	}
}
