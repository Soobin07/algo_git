package beakjoon.bronze;

import java.util.Scanner;

public class Q9506 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		String isNot = " is NOT perfect.";
		boolean[] arr = null;

		int n = sc.nextInt();
		while (n != -1) {
			int sum = 0;
			boolean flag = true;
			arr = new boolean[n];
			for (int i = 1; i < n; i++) {
				if (n % i == 0) {
					arr[i] = true;
					sum += i;
				}
				if (sum > n) {
					flag = false;
					break;
				}
			}

			if (flag && sum == n) {
				sb.append(n + " =");
				for (int i = 1; i < n; i++) {
					if (arr[i]) {
						sb.append(" " + i + " +");
					}
				}
				sb.setLength(sb.length() - 2);
				sb.append("\n");
			} else {
				sb.append(n + isNot + "\n");
			}

			// 다음 수 가져오기
			n = sc.nextInt();
		}

		System.out.print(sb.toString());
	}
}
