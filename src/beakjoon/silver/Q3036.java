package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q3036 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int first = Integer.parseInt(st.nextToken());

		for (int i = 1; i < N; i++) {
			int second = Integer.parseInt(st.nextToken());

			int a = first;
			int b = second;
			if (first < second) {
				a = second;
				b = first;
			}

			while (b != 0) {
				int tmp = a % b;
				a = b;
				b = tmp;
			}

			bw.append((first / a) + "/" + (second / a) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
