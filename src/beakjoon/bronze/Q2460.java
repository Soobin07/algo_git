package beakjoon.bronze;

import java.util.Scanner;

//지능형 기차2
public class Q2460 {
	public static void main(String[] args) {
		// 기차에 사람이 가장 많은 때 수 계산
		Scanner sc = new Scanner(System.in);
		int max = 0;
		int now = 0;
		for (int i = 0; i < 10; i++) {
			now -= sc.nextInt();	//내릴사람 내리기
			now += sc.nextInt();	//탈 사람 타기
			max = Math.max(max, now);
		}
		
		System.out.println(max);
	}
}
