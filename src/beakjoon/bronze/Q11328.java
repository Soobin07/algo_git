package beakjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//Strfry
public class Q11328 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int[] cnt = new int['z' - 'a' + 1];

		int N = Integer.parseInt(br.readLine());

		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			Arrays.fill(cnt, 0);
			String A = st.nextToken();
			String B = st.nextToken();

			for (int i = 0; i < A.length(); i++) {
				cnt[A.charAt(i) - 'a']++;
			}

			for (int i = 0; i < B.length(); i++) {
				cnt[B.charAt(i) - 'a']--;
			}

			boolean flag = true;
			for (int i = 0; i < cnt.length; i++) {
				if (cnt[i] == 0)
					continue;
				flag = false;
			}

			if (flag) {
				bw.append("Possible\n");
			} else {
				bw.append("Impossible\n");
			}
		} 

		bw.flush();
		bw.close();
		br.close();
	}
}
