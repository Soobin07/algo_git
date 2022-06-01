package beakjoon.silver;

import java.util.Scanner;

public class Q1254 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		int left = 0;
		int right = str.length()-1;
		int L = left;
		int R = right;
		int cont = 0;
		while(L <= R) {
			if(str.charAt(L) != str.charAt(R)) {
				if(L == left) {
					left = L+1;
				}else {
					left = L-cont+1;
				}
				L = left;
				R = right;
				cont = 0;
			}else {
				cont++;
				L++;
				R--;
			}
		}
		System.out.println(str.length()+left);
	}
}
