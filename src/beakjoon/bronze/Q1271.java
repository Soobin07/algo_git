package beakjoon.bronze;

import java.math.BigInteger;
import java.util.Scanner;

public class Q1271 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger n = new BigInteger(sc.next());
		BigInteger m = new BigInteger(sc.next());
		
		System.out.println(n.divide(m).toString());
		System.out.println(n.mod(m).toString()); 
	}
}
