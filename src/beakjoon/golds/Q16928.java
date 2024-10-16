package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//뱀과 사다리 게임
public class Q16928 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 사다리의 수
		int M = Integer.parseInt(st.nextToken()); // 뱀의 수

		HashMap<Integer, Integer> ladder = new HashMap<>();
		// 사다리 정리
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			ladder.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		HashMap<Integer, Integer> snake = new HashMap<>();
		// 뱀 정리
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			snake.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		int ans = Integer.MAX_VALUE;
		int[] min_cnt = new int[101];
		Arrays.fill(min_cnt, Integer.MAX_VALUE);
		min_cnt[0] = 0;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 1, 0 });
		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int i = 1; i <= 6; i++) {
				int next = now[0] + i;
				if (snake.containsKey(next))
					next = snake.get(next);
				if (ladder.containsKey(next))
					next = ladder.get(next);
				if (next == 100) {
					ans = Math.min(ans, now[1] + 1);
					break;
				}
				if (min_cnt[next] < now[1] + 1)
					continue;

				min_cnt[next] = now[1] + 1;
				q.add(new int[] { next, now[1] + 1 });
			}
		}

		System.out.println(ans);
	}
}
