package beakjoon.platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Q1305 {
	static String origin;
	static int L;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		String origin = br.readLine();

		// 접두사, 접미사 동일한 문자열의 최대 길이 구하기
		int len = origin.length();
		int idx = 0;

		int[] table = new int[len];
		for (int i = 1; i < len; i++) {
			while (idx > 0 && origin.charAt(idx) != origin.charAt(i)) {
				idx = table[idx - 1];
			}
			if (origin.charAt(idx) == origin.charAt(i)) {
				idx++;
				table[i] = idx;
			}
		}

		System.out.println(L - table[L - 1]);
	}
}
