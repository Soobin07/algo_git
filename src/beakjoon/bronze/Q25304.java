package beakjoon.bronze;

import java.util.Scanner;

public class Q25304 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		long sum = sc.nextLong();
		int N = sc.nextInt();
		
		long tmp = 0;
		for(int i = 0 ; i < N ; i++) {
			tmp += sc.nextInt()*sc.nextInt();
		}
		
		if(sum == tmp)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
