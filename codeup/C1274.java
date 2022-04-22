package codeup;

import java.util.Scanner;

public class C1274 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean isPrime = true;
		int num = sc.nextInt();
		
		int multiNum = 2;
		
		while(isPrime && multiNum < num) {
			
			if(num % multiNum == 0) {
				isPrime = false;
			}else {
				multiNum++;
			}
		}
		if(isPrime) {
			System.out.print("prime");
		}else {
			System.out.print("not prime");
		}
	}

}
