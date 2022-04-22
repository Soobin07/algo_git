package codeup;

import java.util.Scanner;

public class C1354 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		
		for(int i = 0 ; i < number ; i++) {
			for(int j = i ; j < number ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
