package jungol;

import java.util.Arrays;
import java.util.Scanner;

public class C2817 {
	static int[] select, arr;
	static int K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		arr = new int[K];
		for(int i = 0 ; i < K ; i++) {
			arr[i] = sc.nextInt();
		}
		select = new int[6];
		comb(0,0);
	}
	static void comb(int idx, int sidx) {
		if(sidx == 6) {
			System.out.println(Arrays.toString(select).replaceAll("[\\[,\\],\\,]", ""));
			return;
		}
		if(idx >= K) return;
		
		select[sidx] = arr[idx];
		//선택O
		comb(idx+1, sidx+1);
		//X
		comb(idx+1, sidx);
	}
}
