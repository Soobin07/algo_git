import java.util.Scanner;

public class Main {
	static int blue, white;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		map = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j ++) {
				map[i][j] = sc.nextInt();
			}
		}//맵 만들기
		
		marge(0, N, 0, N);
		System.out.println(white);
		System.out.println(blue);
	}
	public static void marge(int startR, int endR, int startC, int endC) {
		
		if(!isEnd(startR, endR, startC, endC)) {
			int midR = (startR + endR)/2;
			int midC = (startC + endC)/2;
			//1사분면
			marge(startR, midR, startC, midC);
			//2사분면
			marge(startR, midR, midC, endC);
			//3사분면
			marge(midR, endR, startC, midC);
			//4사분면
			marge(midR, endR, midC, endC);
		}else {
			if(map[startR][startC] == 1) blue++;
			else white++;
			return;
		}
	}
	public static boolean isEnd(int startR, int endR, int startC, int endC) {
		int strd = map[startR][startC];
		for(int i = startR ; i < endR; i++) {
			for(int j = startC ; j < endC ; j++) {
				if(strd != map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
