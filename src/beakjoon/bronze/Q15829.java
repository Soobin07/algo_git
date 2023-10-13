package beakjoon.bronze;

import java.util.Scanner;

public class Q15829 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = Integer.parseInt(sc.nextLine());
		String str = sc.nextLine();

		long[] arr = new long[L];
		arr[0] = 1;
		for (int i = 1; i < L; i++) {
			arr[i] = (arr[i - 1] * 31) % 1234567891;
		}

		long ans = 0L;
		for (int i = 0; i < L; i++) {
			ans = (ans + ((str.charAt(i) - 'a' + 1) * arr[i]) % 1234567891) % 1234567891;
		}

		System.out.println(ans % 1234567891);
	}
}
