package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

//카드
public class Q11652 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<Long, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			long num = Long.parseLong(br.readLine());
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		int cnt_max = 0;
		long min = 0;
		for (long l : map.keySet()) {
			int cnt = map.get(l);
			if (cnt < cnt_max)
				continue;
			if ((cnt > cnt_max) || (cnt == cnt_max && min > l)) {
				cnt_max = cnt;
				min = l;
			}
		}

		System.out.println(min);
	}
}
