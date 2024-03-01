package beakjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//대지
public class Q9063 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// 구슬 갯수
		int N = Integer.parseInt(br.readLine());

		// 최소, 최대값 (음수 포함 -> max_x 에 Min_value 넣음)
		int max_x = Integer.MIN_VALUE;
		int min_x = Integer.MAX_VALUE;
		int max_y = Integer.MIN_VALUE;
		int min_y = Integer.MAX_VALUE;

		// 구슬 전부 돌아다니며 최소, 최대값 찾기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			max_x = Math.max(max_x, x);
			min_x = Math.min(min_x, x);
			max_y = Math.max(max_y, y);
			min_y = Math.min(min_y, y);
		}

		// Math.abs(max_x - min_x) * y~~곱해준다
		long ans = Math.abs(max_x - min_x) * Math.abs(max_y - min_y);
		System.out.println(ans);

	}
}
