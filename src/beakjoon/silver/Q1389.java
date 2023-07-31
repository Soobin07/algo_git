package beakjoon.silver;

import java.util.Scanner;

public class Q1389 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] dist = new int[N+1][N+1];
		
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= N ; j++) {
				dist[i][j] = N+1;
				if(i==j)
					dist[i][j] = 0;
			}
		}
		
		int a = 0;
		int b = 0;
		for(int m = 0 ; m < M ; m++) {
			a = sc.nextInt();
			b = sc.nextInt();
			
			dist[a][b] = 1;
			dist[b][a] = 1;
		}
		
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= N ; j++) {
				for(int k = 1 ; k <= N ; k++) {
					if(dist[j][k] > dist[j][i] + dist[i][k]) {
						dist[j][k] = dist[j][i] + dist[i][k];
					}
				}
			}
		}
		
		int max = Integer.MAX_VALUE;
		int idx = -1;
		for(int i = 1 ; i <= N ; i++) {
			int total = 0;
			for(int j = 1 ; j <= N ; j++) {
				total += dist[i][j];
			}
			if(max > total) {
				max = total;
				idx = i;
			}
		}
		
		System.out.println(idx);
	}
}
