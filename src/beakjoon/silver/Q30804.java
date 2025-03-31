package beakjoon.silver;

import java.io.*;
import java.util.*;

public class Q30804 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] fruits = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			fruits[i] = Integer.parseInt(st.nextToken());
		}

		Map<Integer, Integer> map = new HashMap<>();
		int left = 0;
		int answer = 0;

		for (int right = 0; right < N; right++) {
			map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

			while (map.size() > 2) {
				map.put(fruits[left], map.get(fruits[left]) - 1);
				if (map.get(fruits[left]) == 0) {
					map.remove(fruits[left]);
				}
				left++;
			}

			answer = Math.max(answer, right - left + 1);
		}

		System.out.println(answer);
	}
}
