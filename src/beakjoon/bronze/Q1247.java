package beakjoon.bronze;

import java.math.BigInteger;
import java.util.Scanner;

public class Q1247 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 0; tc < 3 ; tc++) {
			int n = Integer.parseInt(sc.nextLine());
			BigInteger ans = new BigInteger("0");
			for(int i = 0 ; i < n ; i++) {
				ans = ans.add(new BigInteger(sc.nextLine()));
			}
			
			if(ans.signum() == 0) {
				System.out.println(0);
			}else if(ans.signum() == 1) {
				System.out.println("+");
			}else {
				System.out.println("-");
			}
		}
	}
}
