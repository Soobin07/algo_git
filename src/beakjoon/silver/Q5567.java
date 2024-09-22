package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//결혼식
public class Q5567 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine()); // 동기 수
		int M = Integer.parseInt(br.readLine()); // 리스트 길이

		// 결혼식에 초대하는 동기의 수 찾기 (자기 친구, 친구의 친구)

		// 친구 관계
		ArrayList<Integer>[] list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);	//b와 a도 친구다
		}

		// 초대 여부
		boolean[] invite = new boolean[N + 1];
		Queue<Integer> q = new LinkedList<>();
		for (int num : list[1]) {
			invite[num] = true;
			q.add(num);
		}
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int num : list[now]) {
				invite[num] = true;
			}
		}

		int cnt = 0;
		for (int i = 2; i <= N; i++) {
			if (invite[i])
				cnt++;
		}

		System.out.println(cnt);
	}
}
