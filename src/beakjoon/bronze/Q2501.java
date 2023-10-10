package beakjoon.bronze;

import java.util.Scanner;

public class Q2501 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		boolean flag = false;
		
		for(int i = 1 ; i <= N ; i++) {
			if(N%i == 0)
				K--;
			if(K == 0) {
				System.out.println(i);
				flag = true;
				break;
			}
		}
		
		if(!flag)
			System.out.println(0);
	}
}
