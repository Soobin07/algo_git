package beakjoon.silver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Q1302 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		HashMap<String, Integer> cnt = new HashMap<>();
		int N = sc.nextInt();

		String top = "";
		int top_cnt = 0;
		for (int i = 0; i < N; i++) {
			String tmp = sc.next();
			int tmp_cnt = 1;
			if (cnt.containsKey(tmp)) {
				tmp_cnt = cnt.get(tmp) + 1;
				cnt.replace(tmp, tmp_cnt);
			} else {
				cnt.put(tmp, tmp_cnt);
			}

			if (top_cnt < tmp_cnt) {
				top_cnt = tmp_cnt;
				top = tmp;
			} else if (top_cnt == tmp_cnt) {
				List<String> tmp_arr = new ArrayList<>();
				tmp_arr.add(top);
				tmp_arr.add(tmp);
				Collections.sort(tmp_arr, String.CASE_INSENSITIVE_ORDER);
				top = tmp_arr.get(0);
			}
		}

		System.out.println(top);
	}
}
