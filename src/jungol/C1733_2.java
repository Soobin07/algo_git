package jungol;

import java.util.Scanner;
import java.util.StringTokenizer;

//56점. 
public class C1733_2 {
	static String input1 = "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 1 2 0 0 2 2 2 1 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 1 2 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 1 2 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 1 2 2 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 1 1 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 2 1 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0";
	
	public static void main(String[] args) {
//		Scanner sc= new Scanner(System.in);
		Scanner sc= new Scanner(input1);
		StringTokenizer st;
		
		int ans = 0;		//정답 (1, 2, 0)
		int r = 0; 		//첫 돌의 r
		int c = 0;		//첫 돌의 c
		
		//맵 작성
		int[][] map = new int[19][19];
		for(int i = 0 ;i < 19 ; i++) {
			st = new StringTokenizer(sc.nextLine());
			for(int j = 0 ; j < 19 ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//팔방탐색용 델타
		int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
		int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
		
		outer : for(int i = 0 ; i < 19 ; i++) {	//시작점의 r
			for(int j = 0 ; j < 19 ; j++) {	//시작점의 c
				int color = map[i][j];
				if(map[i][j] != 0) {
					for(int k = 0 ; k < 8 ; k++) {	//8방탐색용 for문
						int cnt = 0;	// 같은 색 나오는 갯수	
						int dri = i;	// r 확인하는 인덱스 
						int dci = j;	// c 확인하는 인덱스
						while(true) {//다른 색 나올 때 까지 계속 그 방향으로 가
							if(dri+dr[k] >= 19 || dri+dr[k] < 0 || dci+dc[k] >= 19 || dci+dc[k] < 0) {	//판 벗어나면
								break;	//멈춰
							}
							dri += dr[k];
							dci += dc[k];
							
							if(map[dri][dci] == color) cnt++;	//이어지면 카운트 더해줘라
							else break; //다른색 나오면 멈춰
							
							if(cnt > 4) break;	//카운트가 5부터는 멈춰!
						}
						if(cnt == 4) {	//이건 끝났다
							r = i;
							c = j;
							ans = color;
							break outer;
						}
					}
				}
			}
		}
		System.out.println(ans);
		if(ans != 0) System.out.println((r+1)+" "+(c+1));
	}
}
