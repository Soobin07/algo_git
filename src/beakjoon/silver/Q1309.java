package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//동물원
public class Q1309 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] cnt = new int[N + 1];

		if (N == 1) {
			bw.append("3");
		} else {
			cnt[1] = 3;
			cnt[2] = 7;
			for (int i = 3; i <= N; i++) {
				cnt[i] = (2 * cnt[i - 1] + cnt[i - 2]) % 9901;
			}
			bw.append("" + cnt[N]);
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
