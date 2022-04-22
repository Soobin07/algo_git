package jungol;

import java.util.Scanner;
import java.util.StringTokenizer;

//열심히 해서 남겨둠 (대각선 열심히 만들었네)
public class C1733 {
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
		
		boolean isEnd = false;	//승부났는지 확인
		int ans = 0;		//정답 (1, 2, 0)
		int[][] dir = new int[2][2];	//첫 돌 확인용(0 : 검 , 1 : 흰)
		
		//맵 작성
		int[][] map = new int[19][19];
		for(int i = 0 ;i < 19 ; i++) {
			st = new StringTokenizer(sc.nextLine());
			for(int j = 0 ; j < 19 ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//가로
		for(int i = 0 ;i < 19 ; i++) {
			int tmp_b = 0;
			int tmp_w = 0;
			int max_b = 0;
			int max_w = 0;
			
			for(int j = 0 ; j < 19 ; j++) {
				if(map[i][j]==1) {
					tmp_b++;
					max_w = Math.max(max_w, tmp_w);
					tmp_w = 0;
				}else if(map[i][j]==2) {
					tmp_w++;
					max_b = Math.max(max_b, tmp_b);
					tmp_b = 0;
				}else {
					max_w = Math.max(max_w, tmp_w);
					tmp_w = 0;
					max_b = Math.max(max_b, tmp_b);
					tmp_b = 0;
				}
			}
			if(max_b == 5) {
				ans = 1;
				isEnd = true;
				break;
			}else if(max_w == 5) {
				ans = 2;
				isEnd = true;
				break;
			}
		}
		//세로
		if(!isEnd) {
			for(int j = 0 ;j < 19 ; j++) {
				int tmp_b = 0;
				int tmp_w = 0;
				int max_b = 0;
				int max_w = 0;
				for(int i = 0 ; i < 19 ; i++) {
					if(map[i][j]==1) {
						tmp_b++;
						max_w = Math.max(max_w, tmp_w);
						tmp_w = 0;
					}else if(map[i][j]==2) {
						tmp_w++;
						max_b = Math.max(max_b, tmp_b);
						tmp_b = 0;
					}else {
						max_w = Math.max(max_w, tmp_w);
						tmp_w = 0;
						max_b = Math.max(max_b, tmp_b);
						tmp_b = 0;
					}
				}
				if(max_b == 5) {
					ans = 1;
					isEnd = true;
					break;
				}else if(max_w == 5) {
					ans = 2;
					isEnd = true;
					break;
				}
			}
		}
		//대각선 우상향
		if(!isEnd) {
			for(int i = 0 ;i < 19 ; i++) {
				int tmp_b = 0;
				int tmp_w = 0;
				int max_b = 0;
				int max_w = 0;
				for(int j = 0 ; j <= i ; j++) {
					if(map[i-j][j]==1) {
						tmp_b++;
						max_w = Math.max(max_w, tmp_w);
						tmp_w = 0;
					}else if(map[i-j][j]==2) {
						tmp_w++;
						max_b = Math.max(max_b, tmp_b);
						tmp_b = 0;
					}else {
						max_w = Math.max(max_w, tmp_w);
						tmp_w = 0;
						max_b = Math.max(max_b, tmp_b);
						tmp_b = 0;
					}
				}
				if(max_b == 5) {
					ans = 1;
					isEnd = true;
					break;
				}else if(max_w == 5) {
					ans = 2;
					isEnd = true;
					break;
				}
			}
			for(int j = 18 ;j >= 1 ; j--) {
				int tmp_b = 0;
				int tmp_w = 0;
				int max_b = 0;
				int max_w = 0;
				for(int i = 0 ; i <= 18-j ; i++) {
					if(map[18-i][j+i]==1) {
						tmp_b++;
						max_w = Math.max(max_w, tmp_w);
						tmp_w = 0;
					}else if(map[18-i][j+i]==2) {
						tmp_w++;
						max_b = Math.max(max_b, tmp_b);
						tmp_b = 0;
					}else {
						max_w = Math.max(max_w, tmp_w);
						tmp_w = 0;
						max_b = Math.max(max_b, tmp_b);
						tmp_b = 0;
					}
				}
				if(max_b == 5) {
					ans = 1;
					isEnd = true;
					break;
				}else if(max_w == 5) {
					ans = 2;
					isEnd = true;
					break;
				}
			}
		}
		//대각선 우하향
		if(!isEnd) {
			for(int j = 18 ;j >= 0 ; j--) {
				int tmp_b = 0;
				int tmp_w = 0;
				int max_b = 0;
				int max_w = 0;
				for(int i = 0 ; i <= 18-j ; i++) {
					if(map[i][j+i]==1) {
						tmp_b++;
						max_w = Math.max(max_w, tmp_w);
						tmp_w = 0;
					}else if(map[i][j+i]==2) {
						tmp_w++;
						max_b = Math.max(max_b, tmp_b);
						tmp_b = 0;
					}else {
						max_w = Math.max(max_w, tmp_w);
						tmp_w = 0;
						max_b = Math.max(max_b, tmp_b);
						tmp_b = 0;
					}
				}
				if(max_b == 5) {
					ans = 1;
					isEnd = true;
					break;
				}else if(max_w == 5) {
					ans = 2;
					isEnd = true;
					break;
				}
			}
			for(int i = 18 ;i >= 1 ; i--) {
				int tmp_b = 0;
				int tmp_w = 0;
				int max_b = 0;
				int max_w = 0;
				for(int j = 0 ; j <= 18-i ; j++) {
					if(map[i+j][j]==1) {
						tmp_b++;
						max_w = Math.max(max_w, tmp_w);
						tmp_w = 0;
					}else if(map[i+j][j]==2) {
						tmp_w++;
						max_b = Math.max(max_b, tmp_b);
						tmp_b = 0;
					}else {
						max_w = Math.max(max_w, tmp_w);
						tmp_w = 0;
						max_b = Math.max(max_b, tmp_b);
						tmp_b = 0;
					}
				}
				if(max_b == 5) {
					ans = 1;
					isEnd = true;
					break;
				}else if(max_w == 5) {
					ans = 2;
					isEnd = true;
					break;
				}
			}
		}
		System.out.println(ans);
	}
}
