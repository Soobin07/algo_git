package beakjoon.bronze;

import java.util.Scanner;

public class Q2752 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		if(a > b) {
			int tmp = b;
			b = a;
			a = tmp;
		}
		
		int c = sc.nextInt();
		if(b > c) {
			int tmp = c;
			c = b;
			b = tmp;
			
			if(a > b) {
				tmp = b;
				b = a;
				a = tmp;
			}
		}
		
		System.out.println(a+" "+b+" "+c);
	}
}
