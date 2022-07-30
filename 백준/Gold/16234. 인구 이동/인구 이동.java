import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;


//변경된 부분+그 인접만 다시보기로 한번 더 해보자
public class Main {
	static int N, L, R;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean flag;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int days = 0;
		visit = new boolean[N][N];
		while(true) {
			flag = false;
			clear();
			for(int i = 0 ; i < N ; i++) {	//첫수잡기
				for(int j = 0 ; j < N ; j++) {
					if(!visit[i][j]) {
						groupping(i, j);
					}
				}
			}
			if(!flag) break;
			days++;
		}
		System.out.println(days);
	}
	public static void groupping(int ori_r, int ori_c) {
		Set<int[]> group = new HashSet<>();
		Queue<int[]> q = new LinkedList<>();
		
		int[] ori_tmp = new int[] {ori_r, ori_c};
		q.add(ori_tmp);
		group.add(ori_tmp);
		
		int sum = 0;
		int cnt = 0;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];
			
			if(visit[r][c]) continue;
			
			sum += map[r][c];
			visit[r][c] = true;
			cnt++;
			group.add(tmp);
			
			for(int i = 0 ; i < 4 ; i++) {
				int tmpr = r+dr[i];
				int tmpc = c+dc[i];
				
				//인덱스
				if(tmpr < 0 || tmpc < 0 || tmpr >= N || tmpc >= N) continue;
				//이미 간곳인가
				if(visit[tmpr][tmpc]) continue;
				//조건에 맞나
				int dif = Math.abs(map[r][c] - map[tmpr][tmpc]);
				if(dif > R || dif < L) continue;
				
				q.add(new int[] {tmpr, tmpc});
				
				if(!flag) flag = true;
			}
		}
		
		Iterator<int[]> it = group.iterator();
		for(int i = 0 ; i < group.size() ; i++) {
			int[] tmp = it.next();
			map[tmp[0]][tmp[1]] = sum / cnt;
		}
		
	}
	public static void clear() {
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				visit[i][j] = false;
			}
		}
	}
}
