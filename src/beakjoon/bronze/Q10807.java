package beakjoon.bronze;

import java.util.Scanner;

public class Q10807 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int req = sc.nextInt();
		int ans = 0;
		for (int i = 0; i < N; i++) {
			if (arr[i] == req)
				ans++;
		}
		System.out.println(ans);
	}
}
