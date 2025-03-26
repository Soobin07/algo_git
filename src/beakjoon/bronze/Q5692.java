package beakjoon.bronze;

import java.util.Scanner;

public class Q5692 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5 + 1];
		arr[0] = 1;
		for (int i = 1; i < arr.length; i++) {
			arr[i] = arr[i - 1] * i;
		}
		while (true) {
			String str = sc.next();
			if (str.equals("0"))
				return;
			long sum = 0;
			for (int i = 0; i < str.length(); i++) {
				sum += (str.charAt(i) - '0') * arr[str.length() - i];
			}

			System.out.println(sum);
		}
	}
}
