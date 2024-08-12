package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q16139 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		String str = br.readLine();
		int[][] cnt = new int[str.length() + 1][26];
		for (int i = 1; i <= str.length(); i++) {
			for (int j = 0; j < 26; j++) {
				cnt[i][j] = cnt[i - 1][j];
			}
			cnt[i][str.charAt(i - 1) - 'a']++;
		}

		int a = Integer.parseInt(br.readLine());
		for (int i = 0; i < a; i++) {
			st = new StringTokenizer(br.readLine());
			int chr = st.nextToken().charAt(0) - 'a';
			int s = Integer.parseInt(st.nextToken()) + 1;
			int e = Integer.parseInt(st.nextToken()) + 1;

			bw.append(cnt[e][chr] - cnt[s - 1][chr] + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
