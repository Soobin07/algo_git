package beakjoon.bronze;

import java.util.Scanner;

public class Q10804 {
	static int[] arr;
	static int[] tmp;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		arr = new int[21];
		tmp = new int[21];
		for (int i = 1; i < 21; i++) {
			arr[i] = i;
		}

		for (int i = 0; i < 10; i++) {
			reverse(sc.nextInt(), sc.nextInt());
		}

		StringBuffer sb = new StringBuffer();
		for (int i = 1; i < 21; i++) {
			sb.append(arr[i] + " ");
		}
		sb.setLength(sb.length() - 1);

		System.out.println(sb.toString());
	}

	public static void reverse(int start, int end) {
		for (int i = 0; i <= end - start; i++) {
			tmp[start + i] = arr[end - i];
		}
		for (int i = 0; i <= end - start; i++) {
			arr[start + i] = tmp[start + i];
		}
	}
}
