package beakjoon.bronze;

import java.util.Scanner;

public class Q23795 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int bat = sc.nextInt();
		int sum = 0;
		while (bat != -1) {
			sum += bat;
			bat = sc.nextInt();
		}
		System.out.println(sum);
	}
}
