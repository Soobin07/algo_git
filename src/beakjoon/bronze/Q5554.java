package beakjoon.bronze;

import java.util.Scanner;

//심부름 가는 길
public class Q5554 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 총 이동시간 몇 분 몇 초
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			sum += sc.nextInt();
		}
		System.out.println(sum / 60);
		System.out.println(sum % 60);
	}
}
