package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//최대공약수
public class Q1850 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();

		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		if (A < B) {
			long tmp = A;
			A = B;
			B = tmp;
		}

		long end = GCD(A, B);
		for (long a = 0; a < end; a++) {
			bw.append("1");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	static long GCD(long A, long B) {
		long tmp = 0;
		while (B != 0) {
			tmp = A % B;
			A = B;
			B = tmp;
		}
		return A;
	}
}