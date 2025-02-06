package beakjoon.bronze;

import java.math.BigInteger;
import java.util.Scanner;

public class Q5893 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		BigInteger num = new BigInteger(str, 2);
		num = num.multiply(BigInteger.valueOf(17));
		System.out.println(num.toString(2));
	}
}
