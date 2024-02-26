package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//스카이라인 쉬운거
public class Q1863 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());
		Stack<Integer> s = new Stack<>();
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken(); // x버리기
			int now = Integer.parseInt(st.nextToken());
			// 새 건물보다 이전 건물이 더 크면 cnt 세준다
			while (!s.isEmpty() && s.peek() > now) {
				s.pop();
				cnt++;
			}
			// 아무것도 없거나, 다음 건물이 더 크면 넣어준다
			// 넣는 상황 : now > 0 && (!s.isEmpty() && s.peek() != now)
			if (now > 0 && (s.isEmpty() || (!s.isEmpty() && s.peek() != now))) {
				s.add(now);
			}
		}
		cnt += s.size();
		System.out.println(cnt);
	}
}
