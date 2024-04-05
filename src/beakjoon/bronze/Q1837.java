package beakjoon.bronze;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Q1837 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger P = new BigInteger(sc.next());
		int K = sc.nextInt();

		// K까지 소수를 찾는다
		boolean[] visit = new boolean[K];
		ArrayList<String> prime = new ArrayList<>();
		for (int i = 2; i < K; i++) {
			if (!visit[i]) {
				prime.add(String.valueOf(i));
				for (int j = i * 2; j < K; j += i) {
					visit[j] = true;
				}
			}
		}

		boolean flag = true;
		int ans = 0;
		// K보다 작은 소수들로 P를 나눠본다.
		for (int i = 0; i < prime.size(); i++) {
			if (P.mod(new BigInteger(prime.get(i))).compareTo(BigInteger.ZERO) == 0) {
				flag = false;
				ans = Integer.parseInt(prime.get(i));
				break;
			}
		}

		if (flag) {
			System.out.println("GOOD");
		} else {
			System.out.println("BAD " + ans);
		}
	}
}
