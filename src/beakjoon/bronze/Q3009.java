package beakjoon.bronze;

import java.util.Scanner;

public class Q3009 {
	public static void main(String[] args) {
		//해당하는 숫자에 넣어준 후, 짝이 안맞는 (1인) 좌표를 찾아 출력
		Scanner sc = new Scanner(System.in);
		int[] w = new int[1000];
		int[] h = new int[1000];
		int ansW = 0;
		int ansH = 0;
		
		for(int i = 0 ; i < 3 ; i++) {
			w[sc.nextInt()-1]++;
			h[sc.nextInt()-1]++;
		}
		
		for(int i = 0 ; i < 1000 ; i++) {
			if(w[i] == 1) {
				ansW = i+1; break;
			}
		}
		for(int i = 0 ; i < 1000 ; i++) {
			if(h[i] == 1) {
				ansH = i+1; break;
			}
		}
		
		System.out.println(ansW+" "+ansH);
		
		
	}
}
