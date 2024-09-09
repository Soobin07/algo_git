package beakjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//치킨 쿠폰
public class Q1673 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		String str = br.readLine();
		while (str != null && !str.isEmpty() && !str.equals("")) {
			st = new StringTokenizer(str);
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			int sum = n;
			int l = n;
			while (l >= k) {
				sum += (l / k);
				l = l / k + l % k;
			}

			bw.append(sum + "\n");
			str = br.readLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
