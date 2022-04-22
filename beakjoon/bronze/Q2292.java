package beakjoon.bronze;

import java.util.Scanner;

public class Q2292 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int line= 1;
		int start = 1;
		
		while(n > start) {
			start += line*6;
			line++;
			if(n <= start) break;
		}
		
		System.out.println(line);
	}
}
