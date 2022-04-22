package beakjoon.bronze;

import java.util.Scanner;

//시간초과
public class Q2748 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(f(n));
	}
	static int f(int n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		return f(n-1)+f(n-2);
	}
}
