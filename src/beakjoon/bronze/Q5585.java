package beakjoon.bronze;

import java.util.Scanner;

public class Q5585 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int pay = sc.nextInt();
		
		int cnt = 0;
		int[] arr = {500, 100, 50, 10, 5, 1};
		
		int change = 1000 - pay; 
		for(int i = 0 ; i < arr.length ; i++) {
			if(change / arr[i] >= 1) {
				int tmp = (change / arr[i]);
				cnt += tmp;
				change -= tmp*arr[i];
			}
		}
		
		System.out.println(cnt);
	}
}
