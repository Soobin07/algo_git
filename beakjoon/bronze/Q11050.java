package beakjoon.bronze;

import java.util.Scanner;

public class Q11050 {
	public static void main(String[] args) {
		//이항계수 = n! / (r!(n-r)!) 이고, n/r로 표시
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		System.out.println((fac(n)/(fac(r)*fac(n-r))));
	}
	static int fac(int n) {
		int result = 1;
		for(int i = 1 ; i <= n ; i++) {
			result *= i;
		}
		return result;
	}
}
