package beakjoon.bronze;

import java.util.Scanner;

public class Q9517 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int N = sc.nextInt();

		int max_time = 3 * 60 + 30;
		int max_people = 8;

		int now_time = 0;
		int now_people = K - 1;
		for (int i = 0; i < N; i++) {
			int T = sc.nextInt();
			char Z = sc.next().charAt(0);

			now_time += T;
			if (now_time >= max_time) {
				System.out.println(now_people + 1);
				return;
			} else if (Z == 'T') {
				now_people += 1;
				now_people %= max_people;
			}
		}
		System.out.println(now_people + 1);
	}
}
