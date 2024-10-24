package beakjoon.bronze;

import java.util.Arrays;
import java.util.Scanner;

public class Q3047 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[3];
		for (int i = 0; i < 3; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);

		StringBuffer sb = new StringBuffer();
		String str = sc.next();
		for (int i = 0; i < 3; i++) {
			sb.append(arr[str.charAt(i) - 'A'] + " ");
		}

		System.out.println(sb.toString());
	}
}
