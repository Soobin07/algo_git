package jungol;

import java.util.Scanner;

public class C2811 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0 ; i < 5 ; i++) {
			int num = sc.nextInt();
			if(num == 1) System.out.println("number one");
			else if(prime(num)) System.out.println("prime number");
			else System.out.println("composite number");
		}
		
	}
	public static boolean prime(int num) {
		for(int i = 2 ; i*i <= num ; i++) {
			if(num % i == 0) return false;
		}
		return true;
	}
}
