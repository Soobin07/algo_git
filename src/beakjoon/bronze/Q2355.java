package beakjoon.bronze;

import java.util.Scanner;

//시그마
public class Q2355 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextInt();
		long B = sc.nextInt();

		//A와 B사이의 모든 수(A, B 포함) 다 더한다
		//범위 양 끝 숫자 평균 * 범위 안 숫자 갯수 / 2
		long ans = (A + B) * (Math.abs(B - A) + 1) / 2;

		System.out.println(ans);
	}
}
