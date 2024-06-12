package beakjoon.bronze;

import java.util.Scanner;

//가희와 방어율 무시
public class Q25238 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();

		System.out.println(a * (100 - b) / 100 >= 100 ? "0" : "1");
	}
}
