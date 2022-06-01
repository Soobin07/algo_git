package beakjoon.silver;
//ctrl+w : 현재 이 창 사라짐

import java.util.Scanner;
import java.util.StringTokenizer;


//boolean[] checkNum = new boolean[범위+1 (0 안쓸거니까)]
//이걸로 해당 높이를 가진 땅이 없으면, 물의 높이 확인하는 것을 뛰어넘을 수 있다
public class Q2468 {
	static String input1 = "5\r\n" + 
			"6 8 2 6 2\r\n" + 
			"3 2 3 4 6\r\n" + 
			"6 7 3 3 2\r\n" + 
			"7 2 5 3 6\r\n" + 
			"8 9 5 2 7";	//5
	static String input2 = "7\r\n" + 
			"9 9 9 9 9 9 9\r\n" + 
			"9 2 1 2 1 2 9\r\n" + 
			"9 1 8 7 8 1 9\r\n" + 
			"9 2 7 9 7 2 9\r\n" + 
			"9 1 8 7 8 1 9\r\n" + 
			"9 2 1 2 1 2 9\r\n" + 
			"9 9 9 9 9 9 9";	//6
	
	static int N;	//맵의 크기
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(input2);
		StringTokenizer st;
		
		N = Integer.parseInt(sc.nextLine());
		map = new int[N][N];
		
		int maxH = 0;	//맵에서 가장 높은 숫자 구하기
		for(int i = 0 ; i < N ; i++) {		//맵 받기
			st = new StringTokenizer(sc.nextLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxH = Math.max(maxH, map[i][j]);
			}
		}
		
		int max = 1;	//비가 내리지 않았을 때, 영역 1개가 가장 작은 숫자일 것이다.
		for(int n = 1 ; n < maxH ; n++)	{	//비 높이 설정 ( 1부터 가장 높은 높이-1까지 돌린다 : 가장 높은 높이 이상이면 남은곳이 0이 되니까)
			int count = 0;	//해당 영역이 몇번째 영역인지 

			int[][] visit = new int[N][N];
			for(int r = 0 ; r < N ; r++) {
				for (int c = 0; c < N; c++) {	//전체 돌기
					if(map[r][c] > n && visit[r][c] == 0) {	//해당 비 높이에서 살아남은 지역이면 이어진 곳 찾기 + 이미 처리된 곳이 아니면 처리하러 가기
						find(r, c, n, ++count, visit);
					}
				}
			}
			max = Math.max(max, count);
		}
		
		System.out.println(max);
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static void find(int r, int c, int stdH, int countIdx, int[][] visit) {
		visit[r][c] = countIdx;	//처리되었다는 표시
		
		for(int k = 0 ; k < 4 ; k++) {	//사방탐색
			if(r+dr[k] < 0 || r+dr[k] >= N || c+dc[k] < 0 || c+dc[k] >= N) continue; //인덱스 넘어가는 곳 처리
			
			if(map[r+dr[k]][c+dc[k]] > stdH && visit[r+dr[k]][c+dc[k]] == 0) {	//사방탐색 시 해당 위치가 처리된 적 없는 곳이면
				find(r+dr[k],c+dc[k], stdH, countIdx, visit);	//그곳도 처리하러 가준다.
			}
		}
	}
}
