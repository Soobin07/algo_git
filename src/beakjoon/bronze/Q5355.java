package beakjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q5355 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			double num = Double.parseDouble(st.nextToken());
			for (int i = 0; i < 3; i++) {
				if (!st.hasMoreTokens())
					break;
				String tmp = st.nextToken();
				if (tmp.equals("@")) {
					num *= 3;
				} else if (tmp.equals("%")) {
					num += 5;
				} else if (tmp.equals("#")) {
					num -= 7;
				}
			}
			System.out.printf("%.2f\n", num);
		}
	}
}
