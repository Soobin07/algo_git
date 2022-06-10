package jungol;

import java.util.Scanner;

public class C1331 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		char[][] map = new char[N*2-1][N*2-1];
		int[] now = {-1, N};
		int cnt = N;
		char spel = 'A';
		
		while(true) {
			for(int i = 0 ; i < cnt ; i++) {
				now[0]++;
				now[1]--;
				map[now[0]][now[1]] = spel++;
				if(spel > 'Z') spel = 'A';
			}
			cnt--;
			if(cnt == 0) break;
			for(int i = 0 ; i < cnt ; i++) {
				now[0]++;
				now[1]++;
				map[now[0]][now[1]] = spel++;
				if(spel > 'Z') spel = 'A';
			}
			for(int i = 0 ; i < cnt ; i++) {
				now[0]--;
				now[1]++;
				map[now[0]][now[1]] = spel++;
				if(spel > 'Z') spel = 'A';
			}
			cnt--;
			for(int i = 0 ; i < cnt ; i++) {
				now[0]--;
				now[1]--;
				map[now[0]][now[1]] = spel++;
				if(spel > 'Z') spel = 'A';
			}
			cnt++;
			now[0]--;
		}
		
		for(int i = 0 ; i < N*2-1 ; i++) {
			for(int j = 0 ; j < N*2-1 ; j++) {
				if(map[i][j] != '\u0000') 
					System.out.print(map[i][j]+" ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
		
	}
}
