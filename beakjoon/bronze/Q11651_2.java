package beakjoon.bronze;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q11651_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int dots[][] = new int[n][2];
		for(int i = 0 ;i < n ; i++) {
			dots[i][0] = sc.nextInt();
			dots[i][1] = sc.nextInt();
		}
		Arrays.sort(dots, new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o2[1] - o1[1] > 0) return -1;
				if(o2[1] - o1[1] == 0) {
					if(o2[0] - o1[0] > 0) return -1; 
				}
				return 1;
			}
		});
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < 2 ; j++) {
				System.out.print(dots[i][j]+" ");
			}
			System.out.println();
		}
	}
}
