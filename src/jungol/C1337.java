package jungol;

import java.util.Scanner;

public class C1337 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[][] map = new char[N][N];
		
		int cnt = 0;
		int[] now = {-1,-1};
		int cycle = N;
		while(true) {
			for(int i = 0 ; i < cycle ; i++) {
				now[0]++;
				now[1]++;
				map[now[0]][now[1]] = (char)((cnt%10)+'0');
				cnt++;
			}
			cycle--;
			if(cycle == 0) break;
			
			for(int i = 0 ; i < cycle ; i++) {
				now[1]--;
				map[now[0]][now[1]] = (char)((cnt%10)+'0');
				cnt++;
			}
			cycle--;
			if(cycle == 0) break;
			
			for(int i = 0 ; i < cycle ; i++) {
				now[0]--;
				map[now[0]][now[1]] = (char)((cnt%10)+'0');
				cnt++;
			}
			cycle--;
			if(cycle==0) break;
		}
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j <= i  ; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
