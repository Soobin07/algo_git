package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class Q13414 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int K = Integer.parseInt(st.nextToken());// 수강가능인원
		int L = Integer.parseInt(st.nextToken());// 대기목록길이

		LinkedHashMap<String, Boolean> map = new LinkedHashMap<String, Boolean>();
		for (int i = 0; i < L; i++) {
			String id = br.readLine();
			map.remove(id);
			map.put(id, true);
		}

		int cnt = 0;
		for (String id : map.keySet()) {
			if (cnt++ == K)
				break;
			System.out.println(id);
		}
	}
}
