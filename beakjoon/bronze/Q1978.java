package beakjoon.bronze;

import java.util.Scanner;

public class Q1978 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		int n = sc.nextInt();
		int num;
		outer: for(int i = 0 ; i < n ; i ++) {
			num = sc.nextInt();
			for(int j = 2; j < num ; j++) {
				if(num%j == 0) continue outer;
			}
			if(num != 1) count++;
		}
		System.out.println(count);
	}
}
