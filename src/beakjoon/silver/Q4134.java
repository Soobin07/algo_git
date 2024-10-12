package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

//다음 소수
public class Q4134 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		ArrayList<Integer> prime = new ArrayList<>();
		boolean[] not_prime = new boolean[63247]; // 63247 * 63247 >= 4_000_000_000 (최대 값)
		for (int i = 2; i < not_prime.length; i++) {
			if (not_prime[i])
				continue;
			for (int j = i * i; j < not_prime.length && j > 0; j += i)
				not_prime[j] = true;
			prime.add(i);
		}

		long tc = Long.parseLong(br.readLine());
		while (tc-- > 0) {
			long n = Long.parseLong(br.readLine());
			if (n <= 2) {
				System.out.println(2);
				continue;
			}
			while (true) {
				boolean flag = true;
				for (int i : prime) {
					if (i >= n)
						break;
					if (n % i == 0) {
						flag = false;
						break;
					}
				}
				if (flag)
					break;
				n++;
			}
			System.out.println(n);
		}

	}
}