package beakjoon.bronze;

import java.util.Scanner;

public class Q2231 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	//목표
		
		int ans = 0;
		for(int i = 0; i < N ; i++) {
			int tmp = i;
			int sum = i;
			while(tmp/10 != 0) {
				sum += tmp%10;
				tmp /= 10;
			}
			sum += tmp;
			
			if(sum == N) {
				ans = i;
				break;
			}
		}
		
		System.out.println(ans);
	}
}
