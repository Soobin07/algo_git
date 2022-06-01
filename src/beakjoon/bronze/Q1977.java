package beakjoon.bronze;

import java.util.Scanner;

public class Q1977 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int small = sc.nextInt();
		int big = sc.nextInt();
		int min = Integer.MAX_VALUE;
		
		int sum = 0;
		for(int i = 1 ; ; i++) {
			int i2 = i*i;
			if(i2 >= small && i2 <= big) {
				if(i2 < min) min = i2;
				sum+= i2;
			}
			if(i2 >= big) {
				break;
			}
		}
		
		if(sum != 0) {
			System.out.println(sum);
			System.out.println(min);
		}else {
			System.out.println(-1);
		}
	}
}
