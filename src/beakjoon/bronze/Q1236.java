package beakjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//성 지키기
public class Q1236 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		boolean[] rows = new boolean[R];
		boolean[] columns = new boolean[C];

		int need_R = R;
		int need_C = C;

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				char ch = str.charAt(j);
				if (ch == 'X') {
					if (!rows[i])
						need_R--;
					if (!columns[j])
						need_C--;
					rows[i] = true;
					columns[j] = true;
				}
			}
		}

		System.out.println(Math.max(need_R, need_C));
	}
}
