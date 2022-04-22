package beakjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

public class Q21608 {
	static int N, ans;
	static int[] order;
	static boolean[] visited;
	static int like[][];
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt();
		like = new int[N*N+1][4];
		order = new int[N*N];
		visited = new boolean[N*N+1];
		for(int i = 1 ; i <= N*N ; i++) {
			int p = sc.nextInt();
			order[i-1] = p;
			for(int k = 0 ; k < 4 ; k++) {
				like[p][k] = sc.nextInt();
			}
		}
		makeMap(new int[N][N]);
		System.out.println(ans);
	}
	
	private static void makeMap(int[][] map) {
		for(int n = 0 ; n < N*N ; n++) {	//몇번째 순서
			int r = N;		//좌표 r값
			int c = N;		//좌표 c값
			int max = 0;	//해당 순서가 가질 수 있는 최대값
			int rem = 0;	//남은자리 숫자
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {	//위치
					if(map[i][j] != 0) continue;
					int cntL = 0;	//좋아하는 사람 있는 카운트
					int cntR = 0;	//빈자리 카운트
					findLike : for(int k = 0 ; k < 4 ; k++) {	//상하좌우
						int nr = i+dr[k];
						int nc = j+dc[k];
						if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
						if(map[nr][nc] == 0) {
							cntR++;
							continue;
						}
						for(int l = 0 ; l < 4 ; l++) {	//좋은 사람 있어?
							if(map[nr][nc] == like[order[n]][l]) {
								cntL++;
								continue findLike;
							}
						}
					}
					if(cntL > max) {
						r = i;
						c = j;
						max = cntL;
						rem = cntR;
					}else if(cntL == max) {
						if(rem < cntR) {
							r = i;
							c = j;
							max = cntL;
							rem = cntR;
						}else if(rem == cntR) {
							if(r > i) {
								r = i;
								c = j;
								max = cntL;
								rem = cntR;
							}else if(r == i) {
								if(c > j) {
									r = i;
									c = j;
									max = cntL;
									rem = cntR;
								}
							}
						}
					}
				}
			}
			map[r][c] = order[n];
		}
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				int cnt = 0;
				next : for(int k = 0 ; k < 4 ; k++) {	//사방
					int nr = i+dr[k];
					int nc = j+dc[k];
					if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
					for(int l = 0 ; l < 4 ; l++) {	//좋아하는 사람 있나
						if(map[nr][nc] == like[map[i][j]][l]) {
							cnt++;
						}
					}
				}
				order[map[i][j]-1] = cnt;
			}
		}
		int sum = 0;
		for(int i = 0 ; i < N*N ; i++) {
			if(order[i] == 0) continue;
			sum += Math.pow(10, order[i]-1);
		}
		ans = Math.max(ans, sum);
	}
}
