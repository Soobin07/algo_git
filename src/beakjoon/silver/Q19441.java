package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q19441 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		String str = br.readLine();

		// 햄버거 저장하기
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			if (str.charAt(i) == 'H')
				q.add(i);
		}

		// 먹을 수 있는 사람 숫자
		int ans = 0;
		// 앞에서부터
		for (int i = 0; i < N; i++) {
			// 사람이 있든 없든, i와 K만큼 떨어져 있으면 햄버거 지우기(못쓰는 햄버거)
			while (!q.isEmpty()) {
				if (i - K > q.peek()) {
					q.poll();
				} else {
					break;
				}
			}
			// 사람 찾아서
			if (str.charAt(i) == 'P') {
				// 가장 앞에 있는 햄버거 먹을 수 있는지 확인
				// 햄버거 남아 있어야 한다. 없으면 그냥 넘어가기
				if (!q.isEmpty() && Math.abs(q.peek() - i) <= K) {
					ans++;
					q.poll();
				}
				// 못먹으면 넘어가기
			}
		}

		bw.append(ans + "");
		bw.close();
		br.close();
	}
}
