package beakjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Baseball
public class Q10214 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int Y_sum = 0;
			int K_sum = 0;
			for (int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				Y_sum += Integer.parseInt(st.nextToken());
				K_sum += Integer.parseInt(st.nextToken());
			}

			String ans = "Draw";
			if (Y_sum > K_sum)
				ans = "Yonsei";
			else if (K_sum > Y_sum)
				ans = "Korea";

			System.out.println(ans);
		}
	}
}
