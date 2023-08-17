package beakjoon.bronze;

import java.util.Scanner;

public class Q17202 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[16];
		for (int j = 0; j < 2; j++) {
			String str = sc.nextLine();
			for (int i = 0; i < 8; i++) {
				arr[i * 2 + j] = str.charAt(i) - '0';
			}
		}

		int[] tmp = null;
		for (int i = 1; i < 15; i++) {
			tmp = new int[16 - i];
			for (int j = 0; j < tmp.length; j++) {
				tmp[j] = (arr[j] + arr[j + 1]) % 10;
			}
			arr = tmp;
		}
		System.out.println(arr[0]+""+arr[1]);
	}
}
