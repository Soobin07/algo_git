package beakjoon.bronze;

import java.util.Scanner;

public class Q27866 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int N = Integer.parseInt(sc.nextLine());

		System.out.println(str.charAt(N - 1));
	}
}
