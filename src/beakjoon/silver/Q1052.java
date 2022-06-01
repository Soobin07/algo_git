package beakjoon.silver;

import java.util.Scanner;

public class Q1052 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int cnt = 0;
		String str = "";

		boolean flag = false;
		while (!flag) {
			int cntB = 0;
			flag = true;
			str = Integer.toBinaryString(N+cnt);
			int last = 0;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '1') {
					cntB++;
					last = i;
				}
			}
			
			if(cntB > K) {
				cnt+= 1<<(str.length()-last-1);
				flag = false;
			}
		}
		System.out.println(cnt);
	}
}
