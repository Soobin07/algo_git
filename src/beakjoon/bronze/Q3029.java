package beakjoon.bronze;

import java.util.Scanner;

public class Q3029 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] now = sc.next().split(":");
		String[] theTime = sc.next().split(":");

		int res = 0;
		int[] wait = new int[3];
		for (int i = 0; i < 3; i++) {
			int n = Integer.parseInt(now[3 - i - 1]);
			int t = Integer.parseInt(theTime[3 - i - 1]) + res;
			res = 0;
			if (t - n >= 0) {
				wait[3 - i - 1] = (t - n);
			} else {
				res = -1;
				if (i < 2) {
					wait[3 - i - 1] = (60 + t - n);
				} else {
					wait[3 - i - 1] = (24 + t - n);
				}
			}
		}
		if (wait[0] == 0 && wait[1] == 0 && wait[2] == 0) {
			System.out.println("24:00:00");
		}else {
			System.out.printf("%02d:%02d:%02d", wait[0], wait[1], wait[2]);
		}
	}
}
