import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int ans;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		ans = 0;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}//저장
		
		visit = new boolean[N][M];
		
		//첫수 잡기 (첫째줄 무조건 들어가야 함)
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				visit[i][j] = true;
				find1(i, j, map[i][j], 1);
				find2(i, j);
				visit[i][j] = false;
			}
		}
		System.out.println(ans);
	}
	//이어진 네개
	public static void find1(int r, int c, int sum, int depth) {
		if(depth >= 4) {
			ans = Math.max(sum, ans);
			return;
		}
		for(int i = 0 ; i < 4 ; i++) {
			int tmpr = r + dr[i];
			int tmpc = c + dc[i];
			if(tmpr < 0 || tmpc < 0 || tmpr >= map.length || tmpc >= map[0].length) continue;
			if(!visit[tmpr][tmpc]) {
				visit[tmpr][tmpc] = true;
				find1(tmpr, tmpc, sum + map[tmpr][tmpc], depth + 1);
				visit[tmpr][tmpc] = false;
			}
		}
	}
	
	//ㅗ 모양
	public static void find2(int r, int c) {
		if(c + 3 <= map[0].length) {
			int sum = 0;
			for(int i = 0 ; i < 3 ; i++) {
				sum += map[r][c + i];
			}	// ㅡ 더하기
			
			if(r > 0) {
				int tmp = map[r-1][c + 1];
				ans = Math.max(ans, sum + tmp);
			}//위로찾기
			if(r < map.length - 1) {
				int tmp = map[r + 1][c + 1];
				ans = Math.max(ans, sum + tmp);
			}//아래로 찾기
		}
		if(r + 3 <= map.length) {
			int sum = 0;
			for(int i = 0 ; i < 3 ; i++) {
				sum += map[r + i][c];
			}	// ㅣ 더하기
			
			if(c > 0) {
				int tmp = map[r + 1][c - 1];
				ans = Math.max(ans, sum + tmp);
			}//왼쪽 찾기
			if(c < map[0].length - 1) {
				int tmp = map[r + 1][c + 1];
				ans = Math.max(ans, sum + tmp);
			}	//오른쪽 찾기
		}
	}
}
