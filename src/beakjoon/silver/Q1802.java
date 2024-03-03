package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q1802 {
	static String str;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			str = br.readLine();

			boolean flag = check(0, str.length() - 1);

			if (flag) {
				bw.append("YES");
			} else {
				bw.append("NO");
			}
			bw.append("\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	static boolean check(int start, int end) {
		if (start == end)
			return true;
		int mid = (start + end) / 2;
		for (int i = start; i < mid; i++) {
			if (str.charAt(i) == str.charAt(end - i))
				return false;
		}
		return check(start, mid - 1) && check(mid + 1, end);
	}
}
