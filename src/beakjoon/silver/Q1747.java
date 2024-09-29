package beakjoon.silver;

import java.util.ArrayList;
import java.util.Scanner;

public class Q1747 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int Max = 2_000_000;
		int N = sc.nextInt();

		// pal & prime만 넣기
		ArrayList<Integer> prime = new ArrayList<>();

		// 소수 찾기
		boolean[] isNotPrime = new boolean[Max + 1];
		for (int i = 2; i <= Max; i++) {
			if (isNotPrime[i])
				continue;
			if (isPal(i))
				prime.add(i);
			for (int j = i * i; j <= Max && j > 0; j += i) {
				isNotPrime[j] = true;
			}
		}

		for (int i : prime) {
			if (i >= N) {
				System.out.println(i);
				return;
			}
		}
	}

	static boolean isPal(int n) {
		String str = String.valueOf(n);
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i))
				return false;
		}
		return true;
	}
}
