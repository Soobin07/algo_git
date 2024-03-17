package beakjoon.bronze;

import java.math.BigInteger;
import java.util.Scanner;

//긴자리 계산
public class Q2338 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger A = new BigInteger(sc.nextLine());
		BigInteger B = new BigInteger(sc.nextLine());
		
		System.out.println(A.add(B).toString());
		System.out.println(A.add(B.multiply(new BigInteger("-1"))));
		System.out.println(A.multiply(B).toString());
	}
}
