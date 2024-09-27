package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//DNA 비밀번호
public class Q12891 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		String password = br.readLine();

		st = new StringTokenizer(br.readLine());
		int[] targets = new int[4];
		for (int i = 0; i < 4; i++) {
			targets[i] = Integer.parseInt(st.nextToken());
		}

		int ans = 0;
		int[] cnts = new int[4];

		for (int p = 0; p < P; p++) {
			char ch = password.charAt(p);
			if (ch == 'A')
				cnts[0]++;
			else if (ch == 'C')
				cnts[1]++;
			else if (ch == 'G')
				cnts[2]++;
			else if (ch == 'T')
				cnts[3]++;
		}

		if (isSame(targets, cnts))
			ans++;

		int start = 0; // 시작
		for (int i = P; i < S; i++) { // 끝
			char ch = password.charAt(start++);
			// 시작 제외
			if (ch == 'A')
				cnts[0]--;
			else if (ch == 'C')
				cnts[1]--;
			else if (ch == 'G')
				cnts[2]--;
			else if (ch == 'T')
				cnts[3]--;

			ch = password.charAt(i);
			// 뒤에 추가
			if (ch == 'A')
				cnts[0]++;
			else if (ch == 'C')
				cnts[1]++;
			else if (ch == 'G')
				cnts[2]++;
			else if (ch == 'T')
				cnts[3]++;

			if (isSame(targets, cnts))
				ans++;
		}

		System.out.println(ans);
	}

	static boolean isSame(int[] gijun, int[] pandan) {
		for (int i = 0; i < gijun.length; i++) {
			if (gijun[i] > pandan[i])
				return false;
		}
		return true;
	}
}
