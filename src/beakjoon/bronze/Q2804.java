package beakjoon.bronze;

import java.util.Arrays;
import java.util.Scanner;

public class Q2804 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();

		char[][] arr = new char[B.length()][A.length()];
		for (int i = 0; i < B.length(); i++) {
			Arrays.fill(arr[i], '.');
		}
		outer: for (int i = 0; i < A.length(); i++) {
			char a = A.charAt(i);
			for (int j = 0; j < B.length(); j++) {
				if (a == B.charAt(j)) {
					arr[j] = A.toCharArray();
					for (int k = 0; k < B.length(); k++) {
						arr[k][i] = B.charAt(k);
					}
					break outer;
				}
			}
		}
		for (int i = 0; i < B.length(); i++) {
			System.out.println(Arrays.toString(arr[i]).replaceAll("[\\[\\], ]", ""));
		}
	}
}
