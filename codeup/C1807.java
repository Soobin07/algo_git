package codeup;

import java.util.Scanner;

public class C1807 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int end = sc.nextInt();
		
		int max_count = 0;
		int max_n = 0;
		int count = 0;
		int n = 0;
		
		for(int i = start ; i <= end ; i++) {
			n = i;
			count = 0;
			if(n == 1) {
				max_n = 1;
				continue;
			}
			while(n != 1) {
				if(n % 2 == 0) {
					n = n/2;
					count++;
				}else {
					n = 3*n + 1;
					count++;
				}
			}
			if(max_count < count) {
				max_count = count;
				max_n = i;
			}
		}
		System.out.println(max_n +" "+(max_count+1));
		sc.close();
	}
}
