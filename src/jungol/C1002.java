package jungol;

import java.util.Scanner;

public class C1002 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = sc.nextInt();
		}
		int gcd = arr[0];
		int lcm = arr[0];
		for(int i = 1 ; i < N ; i++) {
			gcd = getGcd(gcd, arr[i]);
			lcm = (lcm/getGcd(lcm, arr[i]))*arr[i];
		}
		System.out.printf("%d %d", gcd, lcm);
	}
	//최대공약수
	public static int getGcd(int a, int b) {
		if(b == 0) return a;
		return getGcd(b, a%b);
	}
}
