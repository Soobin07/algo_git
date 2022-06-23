package jungol;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class C1169 {
	static Set<String> set = new HashSet<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		if(M == 1) {
			point1(0, new int[N]);
		}else if(M == 2) {
			point2(1, 0, new int[N]);
		}else if(M == 3) {
			point3(0, new int[N], new boolean[7]);
		}
	}
	public static void point1(int sidx, int[] sel) {
		if(sidx == sel.length) {
			for(int i = 0 ; i < sel.length ; i++) {
				System.out.print(sel[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1 ; i <= 6 ; i++) {
			sel[sidx] = i;
			point1(sidx+1, sel);
		}
	}
	public static void point2(int idx, int sidx, int[] sel) {
		if(sidx == sel.length) {
			for(int i = 0 ; i < sel.length ; i++) {
				System.out.print(sel[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i = idx ; i <= 6 ; i++) {
			sel[sidx] = i;
			point2(i, sidx+1, sel);
		}
	}
	public static void point3(int sidx, int[] sel, boolean[] visit) {
		if(sidx == sel.length) {
			for(int i = 0 ; i < sel.length ; i++) {
				System.out.print(sel[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i = 1 ; i <= 6 ; i++) {
			if(!visit[i]) {
				visit[i] =  true;
				sel[sidx] = i;
				point3(sidx+1, sel, visit);
				visit[i] = false;
			}
		}
	}
}
