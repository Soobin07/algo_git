package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q12852 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int X = Integer.parseInt(br.readLine());

		int[] dp = new int[X + 1];
		int[] trace = new int[X + 1];

		for (int i = 2; i <= X; i++) {
			dp[i] = dp[i - 1] + 1;
			trace[i] = i - 1;

			if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
				dp[i] = dp[i / 2] + 1;
				trace[i] = i / 2;
			}
			if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
				dp[i] = dp[i / 3] + 1;
				trace[i] = i / 3;
			}
		}

		bw.append(dp[X] + "\n");
		while (X > 0) {
			bw.append(X + " ");
			X = trace[X];
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
