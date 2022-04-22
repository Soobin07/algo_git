package beakjoon.bronze;

import java.util.Scanner;

public class Q11653 {
	public static void main(String[] args) {
		//소인수분해. 적은 수 부터 시작해서, n이 나누어떨어지는 수를 넣어줬다.
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i = 2 ; i <= n ; i++) {
			while(n%i ==0) {
				System.out.println(i);
				n /=i;
			}
		}
		
	}
}
