package sw.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1873 {
	static int H, W; // 맵의 길이, 넓이
	static char[][] map; // 맵

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("data/sw/input1873.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1 ; t <= T ; t++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][];
			
			int r = -1;	//전차의 r좌표
			int c = -1;	//c좌표
			int d = -1; //방향 (상하좌우)
			
			//맵 넣기 + 전차 좌표 찾기
			String car = "^v<>";
			for(int i = 0 ; i < H ; i++) {
				String tmp = br.readLine();
				if(r == -1 && c == -1) {
					for(int j = 0 ; j < car.length() ; j++) {
						int idx = tmp.indexOf(car.charAt(j));
						if( idx != -1) {
							r = i;
							c = idx;
							d = j;
						}
					}
				}
				map[i] = tmp.toCharArray();
			}
			map[r][c] = '.';
			int N = Integer.parseInt(br.readLine());
			String line = br.readLine();
			
			for(int i = 0 ; i < line.length() ; i++) {
				char ch = line.charAt(i);
				if( ch == 'U' ) {
					d = 0;
					if(r - 1 >= 0 && map[r-1][c] == '.') r -= 1;
					continue;
				}
				if( ch == 'D' ) {
					d = 1;
					if(r + 1 < H && map[r+1][c] == '.') r += 1;
					continue;
				}
				if( ch == 'L' ) {
					d = 2;
					if(c - 1 >= 0 && map[r][c-1] == '.') c -= 1;
					continue;
				}
				if( ch == 'R' ) {
					d = 3;
					if(c + 1 < W && map[r][c+1] == '.') c += 1;
					continue;
				}
				if( ch == 'S') {
					int sr = r;
					int sc = c;
					while(true) {
						//방향, 현재좌표
						if(d == 0) sr -= 1;
						if(d == 1) sr += 1;
						if(d == 2) sc -= 1;
						if(d == 3) sc += 1;
						//쏜 다음 곳으로 가야한다
						if(sr < 0 || sr >= H || sc < 0 || sc >= W) {
							break;
						}
						if(map[sr][sc] == '*') {
							map[sr][sc] = '.';
							break;
						}
						if(map[sr][sc] == '#') {
							break;
						}
					}
				}
			}
			map[r][c] = car.charAt(d);
			sb.append("#").append(t).append(" ");
			for(int i = 0 ; i < H ; i++) {
				for(int j = 0 ; j < W ; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.print(sb.toString());
	}
}

	//너무 어렵게 생각했다. 다시할것
//	static String com = "ULDR";	//나오는 커멘드 (S제외) : 홀수 상하, 짝수 좌우
//	static String car = "^<v>"; //커멘드 나왔을 때 전차 모양(방향) : 홀수 상하, 짝수 좌우
//	static int[] dir = {-1, -1, 1, 1}; //커멘드 나왔을 때 봐야하는 위치 : 홀수 r, 짝수 c
//	static String map = ".-*#";	//필드에 나오는 것들 (전차 제외)
//	static int H, W;	//필드의 길이, 넓이
//	static char[][] field;	//필드
//	
//	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("data/sw/input1873.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		StringTokenizer st;
//		
//		int T = Integer.parseInt(br.readLine());
//		for(int t = 1 ; t <= T ; t++) {
//			st = new StringTokenizer(br.readLine());
//			H = Integer.parseInt(st.nextToken());
//			W = Integer.parseInt(st.nextToken());
//			field = new char[H][];
//			
//			int r = -1;	//전차의 r좌표
//			int c = -1;	//c좌표
//			
//			//맵 넣기 + 전차 좌표 찾기
//			for(int i = 0 ; i < H ; i++) {
//				String tmp = br.readLine();
//				if(r == -1 && c == -1) {
//					for(int j = 0 ; j < car.length() ; j++) {
//						int idx = tmp.indexOf(car.charAt(j));
//						if( idx != -1) {
//							r = i;
//							c = idx;
//						}
//					}
//				}
//				field[i] = tmp.toCharArray();
//			}
//			int N = Integer.parseInt(br.readLine());
//			String line = br.readLine();
//			
//			for(int i = 0 ; i < line.length() ; i++) {
//				int mm = com.indexOf(line.charAt(i));
//				int m = car.indexOf(field[r][c]);
//				field[r][c] = '.';
//				if(mm == -1) {
//					shoot(r, c, m); 
//					return;
//				}
//				if(mm % 2 == 0) r = move(r, c, mm);
//				else if(mm % 2 == 1) c = move(r, c, mm);
//				
//				field[r][c] = car.charAt(mm);
//			}
//			
//			sb.append("#").append(t).append(" ");
//			for(int i = 0 ; i < H ; i++) {
//				for(int j = 0 ; j < W ; j++) {
//					sb.append(field[i][j]);
//				}
//				sb.append("\n");
//			}
//		}
//		System.out.print(sb.toString());
//	}
//	
//	/**
//	 * 현재 좌표, 방향을 넣어주면 
//	 * @return 이동할 좌표
//	 */
//	static int move(int r, int c, int dirc) {
//		if(dirc % 2 == 0) {	//위아래
//			int res = r+dir[dirc];	
//			if(res < 0) return 0;
//			if(res >= H) return H-1;
//			if(map.indexOf(field[res][c]) == 0) {
//				return res;
//			}else {
//				return r;
//			}
//		}else {	//좌우
//			int res = c+dir[dirc];	
//			if(res < 0) return 0;
//			if(res >= W) return W-1;
//			if(map.indexOf(field[r][res]) == 0) {
//				return res;
//			}else {
//				return c;
//			}
//		}
//	}
//	
//	/**
//	 * 현재 좌표, 방향을 넣어주면
//	 * @return 부딛치는 좌표
//	 */
//	static void shoot(int r, int c, int dirc) {
//		int moveR = ((dirc+1)%2)*dir[dirc];
//		int moveC = (dirc%2)*dir[dirc];
//		while(true) {
//			r += moveR;
//			c += moveC;
//			if( r >= H || r < 0 || c >= W || c < 0) {
//				break;
//			}
//			int idx = map.indexOf(field[r][c]);
//			if( idx == 2) {
//				field[r][c] = '.';
//				break;
//			}else if(idx == 3) {
//				break;
//			}
//		}
//	}
