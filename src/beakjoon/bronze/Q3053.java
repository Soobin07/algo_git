package beakjoon.bronze;

import java.util.Scanner;

public class Q3053 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		System.out.printf("%.5f \n%.5f", Math.PI*R*R, R*R*2.0);
	}
}
