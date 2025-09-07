package beakjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1284 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "0";
		while (!(str = br.readLine()).equals("0")) {
			int cnt = 1;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '1') {
					cnt += 2;
				} else if (str.charAt(i) == '0') {
					cnt += 4;
				} else {
					cnt += 3;
				}
				cnt++;
			}

			System.out.println(cnt);
		}
	}
}
