package beakjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

public class Q1024 {
	static String input1 = "18 2"; // 5 6 7
	static String input2 = "18 4"; // 3 4 5 6
	static String input3 = "18 5"; // -1
	static String input4 = "45 10"; // 0 1 2 3 4 5 6 7 8 9
	static String input5 = "1000000000 2"; // 199999998 199999999 200000000 200000001 200000002
	static String input6 = "17 2"; // 8 9
	static String input7 = "5050 99"; // 1 ~ 100

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(input4);

		int N = sc.nextInt();
		int L = sc.nextInt();

		int len = L;
		int[] ans = { -1 };
		while (true) {
			if (len > 100)
				break;
			if (len % 2 == 1 && N % len == 0 && (N / len) * len == N) {
				ans = new int[len];
				for (int i = 0; i < len; i++) {
					ans[i] = (N / len) - (len / 2) + i;
				}
				break;
			}
			if (len % 2 == 0 && (N / (len / 2)) % 2 == 1 && (N / (len / 2)) * (len / 2) == N) {
				ans = new int[len];
				for (int i = 0; i < len; i++) {
					ans[i] = (N / len) - (len / 2) + 1 + i;
				}
				break;
			}
			len++;
		}
		if (ans[0] < 0) {
			System.out.println(-1);
		} else {
			System.out.println(Arrays.toString(ans).replaceAll("[\\[\\,\\]]", ""));
		}
	}
}
