package beakjoon.bronze;

import java.util.Scanner;
import java.util.StringTokenizer;

//오르막길
public class Q2846 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		StringTokenizer st = new StringTokenizer(sc.nextLine());

		int[] height = new int[N];
		// 길 높이
		for (int i = 0; i < N; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}

		// 가장 큰 오르막길의 크기 출력
		int ans = 0;
		int before = 0;
		for (int i = 1; i < N; i++) {
			int tmp = height[i] - height[i - 1];
			if (tmp > 0) {
				before += tmp;
			} else {
				ans = Math.max(ans, before);
				before = 0;
			}
		}

		if (before != 0) {
			ans = Math.max(ans, before);
		}

		System.out.println(ans);
	}
}
