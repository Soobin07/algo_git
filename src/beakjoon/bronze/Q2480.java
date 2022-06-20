package beakjoon.bronze;

import java.util.Scanner;

public class Q2480 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] cnt = new int[7];
		for(int i = 0 ; i < 3 ; i++) {
			cnt[sc.nextInt()]++;
		}
		int maxCnt = 0;
		int maxIdx = 0;
		int biggest = 0;
		for(int i = 1 ; i <= 6 ; i++) {
			if(cnt[i] == 3) {
				maxCnt = 3;
				maxIdx = i;
			}else if(cnt[i] == 2) {
				maxCnt = 2;
				maxIdx = i;
			}else if(cnt[i] == 1){
				biggest = Math.max(biggest, i);
			}
		}
		
		if(maxCnt == 3) {
			System.out.println(10000+maxIdx*1000);
		}else if(maxCnt == 2) {
			System.out.println(1000+maxIdx*100);
		}else {
			System.out.println(biggest*100);
		}
	}
}
