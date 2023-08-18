package beakjoon.bronze;

import java.math.BigInteger;
import java.util.Scanner;

public class Q11382 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger ans = new BigInteger(sc.next());
		ans = ans.add(new BigInteger(sc.next()));
		ans = ans.add(new BigInteger(sc.next()));
		System.out.println(ans.toString());
	}
}
