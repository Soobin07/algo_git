package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class Q9375 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			HashMap<String, Integer> map = new HashMap<>();
			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				String w = st.nextToken();

				if (map.containsKey(w)) {
					map.replace(w, map.get(w) + 1);
				} else {
					map.put(w, 1);
				}
			}

			if (n == 0) {
				System.out.println(0);
				continue;
			}

			int mult = 1;
			Set<String> keyset = map.keySet();
			for (String key : keyset) {
				mult *= (int) (map.get(key) + 1);
			}

			System.out.println(mult - 1);
		}
	}
}
