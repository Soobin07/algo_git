package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

//접두사
public class Q1141 {
	public static void main(String[] args) throws Exception {
		// 부분집합의 최대 크기?
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		ArrayList<String> arr = new ArrayList<>();
		arr.add(br.readLine());

		for (int i = 1; i < N; i++) {
			String str = br.readLine();
			Boolean flag = false;

			int j = arr.size() - 1;
			for (; j >= 0; j--) {
				// 겹치는거 있으면 더 긴 것만 남겨	=> 부분 집합의 최대 크기를 얻기 위해서는 겹치는 부분을 최소화 => 더 긴 것이 덜 겹칠 것이다.
				if (arr.get(j).startsWith(str) || str.startsWith(arr.get(j))) {
					if (arr.get(j).length() < str.length()) {
						arr.remove(j);
						if (!arr.contains(str)) {
							arr.add(j, str);
						}
					}
					flag = true;
				}
			}

			// 겹치는거 없음
			if (!flag) {
				arr.add(str);
			}
		}

		System.out.println(arr.size());
	}
}
