package beakjoon.bronze;

import java.util.Scanner;

public class Q28113 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		if(N <= B) {
			if(Math.max(B, N) < A) {
				System.out.println("Subway");
			}else if(Math.max(B, N) == A) {
				System.out.println("Anything");
			}else {
				System.out.println("Bus");
			}
		}else {
			System.out.println("Bus");
		}
	}
}
