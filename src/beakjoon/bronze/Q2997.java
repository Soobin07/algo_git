package beakjoon.bronze;

import java.util.Arrays;
import java.util.Scanner;

public class Q2997 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] nums = new int[3];
		// 세 개의 정수를 입력받습니다.
		for (int i = 0; i < 3; i++) {
			nums[i] = sc.nextInt();
		}
		sc.close();

		// 입력받은 정수를 오름차순으로 정렬합니다.
		Arrays.sort(nums);

		int a = nums[0];
		int b = nums[1];
		int c = nums[2];

		int d1 = b - a; // 첫 번째와 두 번째 수의 차이
		int d2 = c - b; // 두 번째와 세 번째 수의 차이

		// 세 수가 연속된 등차수열인 경우
		if (d1 == d2) {
			// 빠진 수는 등차 d1만큼 작은 값 (또는 큰 값)이 될 수 있지만,
			// 여기서는 앞쪽 수가 빠진 것으로 간주하여 a - d1를 출력합니다.
			System.out.println(a - d1);
		} else if (d1 == 2 * d2) {
			// a와 b 사이에 빠진 수가 있는 경우: a + d2
			System.out.println(a + d2);
		} else if (d2 == 2 * d1) {
			// b와 c 사이에 빠진 수가 있는 경우: b + d1
			System.out.println(b + d1);
		}
	}
}
