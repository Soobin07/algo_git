package beakjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q1934 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			int ans = A * B;
			// 큰수를 A로
			if (A < B) {
				int tmp = A;
				A = B;
				B = tmp;
			}
			int tmp = 0;
			while (B != 0) {
				tmp = A % B;
				A = B;
				B = tmp;
			}
			bw.append(ans / A + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
