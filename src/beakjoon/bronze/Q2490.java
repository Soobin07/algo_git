package beakjoon.bronze;

import java.util.Scanner;

//윷놀이
public class Q2490 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		// 0 : 배, 1 : 등
		// 도(1,3), 개(2,2), 걸(3,1), 윷(4,0), 모(0,4)

		for (int i = 0; i < 3; i++) {
			int[] arr = new int[2];

			for (int j = 0; j < 4; j++) {
				arr[sc.nextInt()]++;
			}

			char ch = (char) ('A' - 1 + arr[0]);
			if (arr[0] == 0) {
				ch += 5;
			}
			sb.append(ch + "\n");
		}
		System.out.print(sb.toString());
	}
}
