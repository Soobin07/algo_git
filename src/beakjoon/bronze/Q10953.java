package beakjoon.bronze;

import java.util.Scanner;

public class Q10953 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for (int t = 0; t < T; t++) {
			String[] chs = sc.nextLine().split(",");
			System.out.println(Integer.parseInt(chs[0]) + Integer.parseInt(chs[1]));
		}
	}
}
