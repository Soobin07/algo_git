package beakjoon.bronze;

import java.math.BigInteger;
import java.util.Scanner;

public class Q13227 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger A = new BigInteger(sc.next());
		BigInteger B = new BigInteger(sc.next());
		
		System.out.println(A.multiply(B).toString());
	}
}