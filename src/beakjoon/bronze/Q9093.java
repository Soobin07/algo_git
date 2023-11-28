package beakjoon.bronze;

import java.util.Scanner;

public class Q9093 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		StringBuffer ans = new StringBuffer();

		int T = Integer.parseInt(sc.nextLine());
		for (int t = 0; t < T; t++) {
			String str = sc.nextLine();
			String[] arr = str.split(" ");

			for (int i = 0; i < arr.length; i++) {
				sb.setLength(0); // 초기화
				sb.append(arr[i]); // 넣어주기
				sb.reverse(); // 뒤집기
				ans.append(sb.toString() + " ");
			}
			ans.setLength(ans.length() - 1);// 제일 뒤의 스페이스 없애기
			ans.append("\n"); // 줄바꿈
		}
		
		System.out.print(ans.toString());
	}
}
