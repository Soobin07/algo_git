import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static boolean[][] map;
	static int M, N, K;
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		K = sc.nextInt();
		
		map = new boolean[M][N];
		for(int i = 0 ; i < K ; i++) {
			int y1 = sc.nextInt();
			int x1 = M - sc.nextInt();
			int y2 = sc.nextInt();
			int x2 = M - sc.nextInt();
			
			for(int x = x2 ; x < x1 ; x++) {
				for(int y = y1 ; y < y2 ; y++) {
					map[x][y] = true;
				}
			}
		}
		
		List<Integer> ans = new ArrayList<>();
		for(int i = 0 ; i < M ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(!map[i][j]) {
					bfs(new int[] {i, j}); 
					ans.add(cnt);
					cnt = 0;
				}
			}
		}
		
		Collections.sort(ans);
		System.out.println(ans.size());
		for(int i = 0 ; i < ans.size() ; i++) {
			System.out.print(ans.get(i)+" ");
		}
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static void bfs(int[] nod) {
		Queue<int[]> q = new LinkedList();
		q.add(nod);
		cnt++;
		map[nod[0]][nod[1]] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int i = 0 ; i < 4 ; i++) {
				int tmpr = dr[i] + now[0];
				int tmpc = dc[i] + now[1];
				if(tmpr < 0 || tmpc < 0 || tmpr >= M || tmpc >= N) continue;
				if(map[tmpr][tmpc]) continue;
				map[tmpr][tmpc] = true;
				cnt++;
				q.add(new int[] {tmpr, tmpc});
			}
		}
	}
}
