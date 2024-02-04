package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//수 이어 쓰기
//헷갈리면 일단 브루트포스! 그 후 개선하기!
public class Q1515 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int num = 0;
		String str = br.readLine();
		int idx = 0;
		outer: while (num++ <= 30000) {
			String tmp = String.valueOf(num);
			for (int i = 0; i < tmp.length(); i++) {
				if (tmp.charAt(i) == str.charAt(idx))
					idx++;
				if (idx == str.length()) {
					bw.append(num + "");
					break outer;
				}
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
