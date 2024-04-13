package beakjoon.silver;

import java.math.BigInteger;
import java.util.Scanner;

//1
public class Q4375 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		BigInteger ten = new BigInteger("10");
		BigInteger one = new BigInteger("1");
		BigInteger zero = new BigInteger("0");
		while (str != null && !str.isEmpty() && !str.equals("")) {
			BigInteger n = new BigInteger(str);
			BigInteger target = new BigInteger("1");

			while (target.mod(n).compareTo(zero) != 0) {
				target = target.multiply(ten);
				target = target.add(one);
			}

			System.out.println(target.toString().length());
			try {
				str = sc.nextLine();
			} catch (Exception e) {
				break;
			}
		}
	}
}
