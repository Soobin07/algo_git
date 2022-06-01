package sw.d2;

import java.io.FileInputStream;
import java.util.Scanner;
// 지금은 검은색 / 끝이 올때, 그 앞까지 이어지는 하얀 칸의 수를 count하였다
public class SWEA1979 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("data/sw/input1979.txt"));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int T = sc.nextInt();
		for(int t = 1 ; t <= T ; t++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[][] board = new int[N][N];
			int ans = 0;
			
			//맵 만들기
			for(int i = 0 ; i < N ; i ++) {
				for(int j = 0 ; j < N ; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			
			//가로 검색
			for(int i = 0 ; i < N ; i++) {
				int tmp = 0;
				for(int j = 0 ; j < N ; j++) {
					if(board[i][j] == 1) tmp++;
					else {
						if(tmp == K) ans++;
						tmp = 0;
					}
				}
				if(tmp == K) ans++;
			}
			//세로 검색
			for(int j = 0 ; j < N ; j++) {
				int tmp = 0;
				for(int i = 0 ; i < N ; i++) {
					if(board[i][j] == 1) tmp++;
					else {
						if(tmp == K) ans++;
						tmp = 0;
					}
				}
				if(tmp == K) ans++;
			}
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.print(sb.toString());
	}
}
