package beakjoon;

import java.util.Scanner;

public class Q5032 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int e = sc.nextInt();
		int f = sc.nextInt();
		int c = sc.nextInt();

		int cnt = 0;
		int sum = e + f;
		while (sum / c > 0) {
			int tmp = sum / c;
			cnt += tmp;
			sum %= c;
			sum += tmp;
		}

		System.out.println(cnt);
	}
}
