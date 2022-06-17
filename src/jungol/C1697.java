package jungol;

import java.util.Scanner;

public class C1697 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int start = 0;
		int end = 0;
		
		for(int i = 0 ; i < N ; i++) {
			char next = sc.next().charAt(0);
			switch(next) {
				case 'i' :
					arr[end++] = sc.nextInt();
					break;
				case 'o' :
					if(start == end) System.out.println("empty");
					else {
						System.out.println(arr[start++]);
					}
					break;
				case 'c' :
					System.out.println(end-start);
					break;
			}
		}
	}
}
