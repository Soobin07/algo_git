package sw.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA7236 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("data/sw/input7236.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
		int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};

		int T = Integer.parseInt(br.readLine());
		for(int t = 1 ; t <= T ; t++) {
			int N = Integer.parseInt(br.readLine());	//구역 한쪽 변의 길이
			char[][] map = new char[N][N];	//구역
			int max_depth = 0;
			
			//맵 넣기
			for(int n = 0 ; n < N ; n++) {
				String line = br.readLine();
				for(int j = 0 ; j < N ; j++) {
					map[n][j] = line.charAt(2*j);
				}
			}
			//한칸씩 잡고 팔방탐색
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {	// 시작점 잡기
					int depth = 0;
					if(map[i][j] != 'W') continue;
					for(int k = 0 ; k < 8 ; k++) {	//8방탐색
						int nr = i+dr[k];
						int nc = j+dc[k];
						if(nr >=0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == 'W') {	//좌표값이 맵 안이고 값이 W일때
							depth++;	//깊이 더해준다
						}
					}
					if(depth == 0) depth++;	//조건. 둘러싼 모든 영역이 땅인 경우 그 구획의 물 깊이는 1
					max_depth = max_depth > depth ? max_depth : depth;
				}
			}
			sb.append("#").append(t).append(" ").append(max_depth).append("\n");
		}
		System.out.println(sb.toString());
	}
}
