package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

//킹
public class Q1063 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();

		// 움직이는 커맨드
		HashMap<Character, int[]> move = new HashMap<>();
		move.put('R', new int[] { 1, 0 });
		move.put('L', new int[] { -1, 0 });
		move.put('B', new int[] { 0, -1 });
		move.put('T', new int[] { 0, 1 });

		// 왕의 위치
		char[] king = st.nextToken().toCharArray();
		// 돌의 위치
		char[] stone = st.nextToken().toCharArray();

		int N = Integer.parseInt(st.nextToken());
		while (N-- > 0) {
			String now = br.readLine();
			int[] f = new int[2];

			for (int s = 0; s < now.length(); s++) {
				char c = now.charAt(s);
				int[] m = move.get(c);
				for (int i = 0; i < 2; i++) {
					f[i] += m[i];
				}
			}

			char[] dir = new char[] { (char) (king[0] + f[0]), (char) (king[1] + f[1]) };
			// 넘어가면 패스
			if (dir[0] > 'H' || dir[0] < 'A' || dir[1] > '8' || dir[1] < '1') {
				continue;
			}

			boolean flag = false;
			// 만약 king이 갈 위치에 돌이 있으면?
			if (dir[0] == stone[0] && dir[1] == stone[1]) {
				flag = true;
				// 돌 위치 + f가 맵 넘어가면 패스
				if (dir[0] + f[0] > 'H' || dir[0] + f[0] < 'A' || dir[1] + f[1] > '8' || dir[1] + f[1] < '1') {
					continue;
				}
			}

			// 둘 다 맵 안넘어가는 경우에는 그냥 king 이동해주고
			king = dir;
			// 킹과 돌이 부딪치면 돌을 한칸 옆으로
			if (flag) {
				stone[0] += f[0];
				stone[1] += f[1];
			}
		}

		// 프린트
		for (int i = 0; i < 2; i++) {
			sb.append(king[i]);
		}
		sb.append("\n");
		for (int i = 0; i < 2; i++) {
			sb.append(stone[i]);
		}
		
		System.out.print(sb.toString());
	}
}
