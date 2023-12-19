package beakjoon.bronze;

import java.util.Scanner;

//저작권
public class Q2914 {
	public static void main(String[] args) {
		// 앨범 수록곡 중 저작권있는 멜로디 개수 / 앨범 수록곡 개수
		// 올림 해서 정수로
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt(); // 앨범 수록곡 개수
		int I = sc.nextInt(); // 평균값

		// 최소값
		int M = A * (I - 1) + 1;

		System.out.println(M);
	}
}
