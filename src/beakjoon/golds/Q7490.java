package beakjoon.golds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//0 만들기
public class Q7490 {
	static char[] arr;
	static StringBuffer sb;
	static StringBuffer sb_tmp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int TC = Integer.parseInt(br.readLine());
		sb = new StringBuffer();
		sb_tmp = new StringBuffer();

		while (TC-- > 0) {
			int N = Integer.parseInt(br.readLine());
			arr = new char[N - 1];
			sb.setLength(0);
			makeStak(0);
			bw.append(sb.toString());
			bw.append("\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	public static void makeStak(int now) {
		if (now == arr.length) {
			sb_tmp.setLength(0);
			long sum = 0L;
			String before = "1";
			for (int i = 1; i <= arr.length; i++) {
				char ch = arr[i - 1];
				if (ch == ' ') {
					before += (i + 1);
				} else {
					sum += Integer.parseInt(before);
					before = "" + (char) arr[i - 1] + (i + 1);
				}
				sb_tmp.append("" + i + arr[i - 1]);
			}
			sb_tmp.append(arr.length + 1);
			sum += Integer.parseInt(before);

			if (sum == 0) {
				sb.append(sb_tmp.toString());
				sb.append("\n");
			}
			return;
		}
		arr[now] = ' ';
		makeStak(now + 1);
		arr[now] = '+';
		makeStak(now + 1);
		arr[now] = '-';
		makeStak(now + 1);
	}
}
