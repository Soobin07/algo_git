package beakjoon.bronze;

import java.util.Scanner;

public class Q14720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int cnt = 0;
		int now = 0;
		for (int i = 0; i < N; i++) {
			if (now == arr[i]) {
				cnt++;
				now = (now + 1) % 3;
			}
		}
		System.out.println(cnt);
	}
}