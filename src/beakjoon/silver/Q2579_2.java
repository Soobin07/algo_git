package beakjoon.silver;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q2579_2 {
	static String input1 = "11\r\n" + 
			"1\r\n" + 
			"6\r\n" + 
			"4\r\n" + 
			"7\r\n" + 
			"3\r\n" + 
			"7\r\n" + 
			"5\r\n" + 
			"2\r\n" + 
			"1\r\n" + 
			"5\r\n" + 
			"3";//32
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] scores = new int[N];
		//본인 포함할 때 max
		int[] maxes = new int[N+1];
		
		int ans = 0;
		
		for(int i = 0 ; i < N ; i++) {
			scores[i] = sc.nextInt();
		}
		
		if(N >= 1) {
			maxes[0] = 0;
			maxes[1] = maxes[0]+scores[0];
			ans = maxes[1];
		}
		if(N >= 2) {
			maxes[2] = maxes[1]+scores[1];
			ans = maxes[2];
		}
		
		if(N >= 3) {
			for(int i = 2 ; i < N ; i++) {
				maxes[i+1] = Math.max(maxes[i-2]+scores[i-1]+scores[i],  maxes[i-1]+scores[i]);
//				if(scores[i-2] < scores[i-1]) {
//					maxes[i+1] = maxes[i-2]+scores[i-1]+scores[i];
//				}else {
//					maxes[i+1] = maxes[i-1]+scores[i];
//				}
			}
			ans = maxes[N-2]+scores[N-1] > maxes[N-3]+scores[N-1]+scores[N-2]? maxes[N-2]+scores[N-1] : maxes[N-3]+scores[N-1]+scores[N-2];
		}
		System.out.println(ans);
	}
}
