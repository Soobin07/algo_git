package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q24479 {
	static boolean[] visit;
	static int[] order;
	static ArrayList[] map;
	static int cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		visit = new boolean[N+1];
		order = new int[N+1];
		map = new ArrayList[N+1];
		for(int i = 1 ; i <= N ; i++) {
			map[i] = new ArrayList<Integer>();
		}
		cnt = 1;
		
		int a = 0;
		int b = 0;
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			map[a].add(b);
			map[b].add(a);
		}
		for(int i = 1 ; i <= N ; i++) {
			Collections.sort(map[i]);
		}
		dfs(R);
		for(int i = 1 ; i <= N ; i++) {
			System.out.println(order[i]);
		}
	}
	static void dfs(int start) {
		visit[start] = true;
		order[start] = cnt++;
		for(int i = 0 ; i < map[start].size() ; i++) {
			if(!visit[(int) map[start].get(i)]) {
				dfs((int) map[start].get(i));
			}
		}
	}
}
