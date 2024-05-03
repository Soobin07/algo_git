package beakjoon.bronze;

import java.util.Scanner;

//영수증
public class Q5565 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = sc.nextInt();

		for (int i = 0; i < 9; i++) {
			sum -= sc.nextInt();
		}

		System.out.println(sum);
	}
}
