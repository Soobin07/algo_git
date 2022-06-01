package beakjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

public class Q6603 {
	
	static int k;
	static int[] list, sel;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			k = sc.nextInt();
			if(k == 0) return;
			list = new int[k];
			
			for(int i = 0 ; i < k ; i++) {
				list[i] = sc.nextInt();
			}
			
			sel = new int[6];
			comb(0,0);
			System.out.println();
		}
	}
	static void comb(int idx, int sidx) {
		if(sidx == 6) {
			System.out.println(Arrays.toString(sel).replaceAll("[\\[\\,\\]]", ""));
			return;
		}
		if(idx >= k) return;
		
		//넣고
		sel[sidx] = list[idx];
		comb(idx+1, sidx+1);
		//안넣고
		comb(idx+1, sidx);
	}
}
