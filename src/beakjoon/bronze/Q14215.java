package beakjoon.bronze;

import java.util.Arrays;
import java.util.Scanner;

//세 막대
public class Q14215 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// a,b,c 입력
		int[] arr = new int[3];
		for (int i = 0; i < 3; i++) {
			arr[i] = sc.nextInt();
		}

		// 세 변을 정렬
		Arrays.sort(arr);

		// 두변의 길이 합이 한 변의 길이보다 커야 함
		int sum = arr[0] + arr[1];
		if (sum > arr[2]) {
			sum += arr[2];
		} else {
			sum = sum * 2 - 1;
		}
		System.out.println(sum);
	}
}
