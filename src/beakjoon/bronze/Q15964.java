package beakjoon.bronze;

import java.util.Scanner;

public class Q15964 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextInt();
		long B = sc.nextInt();
		
		long ans = (A+B)*(A-B);
		System.out.println(ans);
	}
}
