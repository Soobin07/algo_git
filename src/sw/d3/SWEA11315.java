package sw.d3;

import java.io.FileInputStream;
import java.util.Scanner;

//for, while로 4방탐색 하는 부분을
//메서드 하나를 이용하여, 현재 i와 j를 가져가서 (방향에 맞게) i에 넣어주어 카운트를 셀 수 있다
//4방을 보는데 그 4방의 값을 따로 카운트하여 그중 하나가 4가 넘으면 (0에서 시작하니까..) true를 return한다
public class SWEA11315 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("data/sw/input11315.txt"));
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int[] dr = { 1, 1, 1, 0 };
		int[] dc = { -1, 0, 1, 1 };
		char[][] map = new char[20][];

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			String ans = "NO";
			int N = sc.nextInt();
			for (int i = 0; i < N; i++) {
				map[i] = sc.next().toCharArray();
			} // 입력 끝
			
			outer : for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 'o') {
						for (int k = 0; k < 4; k++) {
							int cnt = 1;
							int r = i;
							int c = j;
							while (true) {
								r += dr[k];
								c += dc[k];
								if(r < 0 || r >= N || c < 0 || c >= N) break;
								if(map[r][c] != 'o') break;
								if(cnt == 5) break;
								cnt++;
							}
							if(cnt == 5) {
								ans = "YES";
								break outer;
							}
						}
					}
				} // 맵 j 탐색 끝
			} // 맵 i 탐색 끝
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}//테스트 반복문 끝
		System.out.print(sb.toString());
	}
}
