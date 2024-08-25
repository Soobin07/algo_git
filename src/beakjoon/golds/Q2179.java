package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

//비슷한 단어
public class Q2179 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> arr = new ArrayList<>();

		int N = Integer.parseInt(br.readLine());
		for (int n = 0; n < N; n++) {
			String str = br.readLine();
			if (!arr.contains(str)) {
				arr.add(str);
			}
		}

		int cnt = 0;
		int idx_a = 0;
		int idx_b = 0;

		for (int a = 0; a < arr.size(); a++) {
			String str_a = arr.get(a);
			for (int b = a + 1; b < arr.size(); b++) {
				String str_b = arr.get(b);
				int min = Math.min(str_a.length(), str_b.length());
				boolean flag = true;
				for (int l = 0; l < min; l++) {
					if (str_a.charAt(l) != str_b.charAt(l)) {
						flag = false;
						if (cnt < l) {
							idx_a = a;
							idx_b = b;
							cnt = l;
						}
						break;
					}
				}
				if (flag && cnt < min) {
					idx_a = a;
					idx_b = b;
					cnt = min;
				}
			}
		}
		System.out.println(arr.get(idx_a));
		System.out.println(arr.get(idx_b));
	}
}
