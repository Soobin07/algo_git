package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q13241 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		if (A > B) {
			bw.write(A * B / find(A, B) + "\n");
		} else if (A < B) {
			bw.write(A * B / find(B, A) + "\n");
		} else {
			bw.write(A + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	static long find(long A, long B) {
		while (B != 0) {
			long R = A % B; // 나머지
			A = B;
			B = R;
		}
		return A;
	}
}
