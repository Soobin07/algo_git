package beakjoon.platinum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

//시저 암호
public class Q1893 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int TC = Integer.parseInt(br.readLine());
		while (TC-- > 0) {
			ArrayList<Integer> ans = new ArrayList<>();
			String order = br.readLine();
			String origin = br.readLine();
			String changed = br.readLine();

			int[] table = makeTable(origin);
			for (int shift = 0; shift < order.length(); shift++) {
				String tmp_origin = shift(order, origin, shift);
				if (KMP(changed, tmp_origin, table) == 1) {
					ans.add(shift);
				}
			}

			if (ans.size() == 0) {
				// 답이 없다
				bw.append("no solution\n");
			} else if (ans.size() == 1) {
				bw.append("unique: ");
				bw.append(ans.get(0) + "\n");
			} else {
				// 여러개
				bw.append("ambiguous: ");
				for (int i = 0; i < ans.size() - 1; i++) {
					bw.append(ans.get(i) + " ");
				}
				bw.append(ans.get(ans.size() - 1) + "\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}

	static int KMP(String origin, String pattern, int[] table) {
		int l1 = origin.length();
		int l2 = pattern.length();

		int cnt = 0;
		int idx = 0;

		for (int i = 0; i < l1; i++) {
			while (idx > 0 && origin.charAt(i) != pattern.charAt(idx)) {
				idx = table[idx - 1];
			}
			if (origin.charAt(i) == pattern.charAt(idx)) {
				if (idx == l2 - 1) {
					idx = table[idx];
					cnt++;
				} else {
					idx++;
				}
			}
		}

		return cnt;
	}

	static String shift(String order, String origin, int shift) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < origin.length(); i++) {
			sb.append(order.charAt((order.indexOf(origin.charAt(i)) + shift) % order.length()));
		}
		return sb.toString();
	}

	static int[] makeTable(String pattern) {
		int l1 = pattern.length();
		int[] table = new int[l1];

		int idx = 0;
		for (int i = 1; i < l1; i++) {
			while (idx > 0 && pattern.charAt(i) != pattern.charAt(idx)) {
				idx = table[idx - 1];
			}
			if (pattern.charAt(i) == pattern.charAt(idx)) {
				idx++;
				table[i] = idx;
			}
		}
		return table;
	}
}
