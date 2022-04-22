package beakjoon.silver;

import java.util.Scanner;

public class Q1182 {
	
	static int[] arr;
	static int cnt;
	static int S;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		S = sc.nextInt();

		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		count(0, 0, 0);

		System.out.println(cnt);
	}

	static void count(int index, int sum, int countSum) {
		if (index == arr.length) {
			if (countSum > 0 && sum == S ) {
				cnt++;
			}
			return;
		}

		// 더할때
		count(index + 1, sum + arr[index], countSum + 1);
		// 안더할때
		count(index + 1, sum, countSum);
	}
}
