package beakjoon.bronze;

import java.util.Scanner;

//방학 숙제
public class Q5532 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt(); // 방학 총 남은 일 수
		double A = sc.nextInt(); // 풀어야 할 국어 페이지
		double B = sc.nextInt(); // 풀어야 할 수학 페이지
		int C = sc.nextInt(); // 하루에 풀 수 있는 최대 국어 페이지
		int D = sc.nextInt(); // 하루에 풀 수 있는 최대 수학 페이지
		System.out.println((int) (L - Math.max(Math.ceil(A / C), Math.ceil(B / D))));
	}
}
