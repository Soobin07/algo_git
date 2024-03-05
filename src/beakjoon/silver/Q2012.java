package beakjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

// 등수 매기기
public class Q2012 {
	public static void main(String[] args) {
		// 불만도 최소화 = ans
		Scanner sc = new Scanner(System.in);

		// 총 인원
		int N = sc.nextInt();

		// 예상 순위
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		// 정렬
		Arrays.sort(arr);
		// 앞에서부터 1위 주고, 불만도 더해주기
		long sum = 0;
		for (int i = 0; i < N; i++) {
			sum += Math.abs(arr[i] - (i + 1));
		}

		System.out.println(sum);
	}
}
