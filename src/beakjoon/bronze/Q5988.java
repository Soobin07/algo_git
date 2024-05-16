package beakjoon.bronze;

import java.math.BigInteger;
import java.util.Scanner;

public class Q5988 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		BigInteger two = new BigInteger("2");
		BigInteger zero = new BigInteger("0");
		for (int n = 1; n <= N; n++) {
			System.out.println(new BigInteger(sc.next()).mod(two).compareTo(zero) == 0 ? "even" : "odd");
		}
	}
}
