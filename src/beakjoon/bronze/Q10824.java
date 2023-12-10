package beakjoon.bronze;

import java.math.BigInteger;
import java.util.Scanner;

public class Q10824 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int D = sc.nextInt();
		
		String AB = ""+A+B;
		String CD = ""+C+D;
		
		BigInteger biAB = new BigInteger(AB);
		BigInteger biCD = new BigInteger(CD);
		
		BigInteger ans = biAB.add(biCD);
		System.out.println(ans.toString());
	}
}
