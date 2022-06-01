package beakjoon.silver;

import java.util.Scanner;

//long 범위를 벗어나는 수가 있을 수도 있다!
//특히 팩토리얼!! 많이 커진다구!
public class Q1676 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int cnt2 = 0;
		int cnt5 = 0;

		for (int i = 2; i <= N; i++) {
			int tmp = i;
			while (tmp / 2 > 0 && tmp % 2 == 0) {
				cnt2++;
				tmp /= 2;
			}
			while (tmp / 5 > 0 && tmp % 5 == 0) {
				cnt5++;
				tmp /= 5;
			}
		}
		
		System.out.println(cnt2 > cnt5 ? cnt5 : cnt2);
	}
}
