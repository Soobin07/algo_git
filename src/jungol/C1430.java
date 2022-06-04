package jungol;

import java.util.Scanner;

public class C1430 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int all = sc.nextInt()*sc.nextInt()*sc.nextInt();
		int[] count = new int[10];
		while(all != 0) {
			int tmp = all%10;
			count[tmp]++;
			all/=10;
		}
		for(int i = 0 ; i < 10 ; i++) {
			System.out.println(count[i]);
		}
	}
}
