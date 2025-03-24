package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Q4358 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> cnts = new HashMap<String, Integer>();
		int all_cnt = 0;
		String tree = null;
		while ((tree = br.readLine()) != null && !tree.isEmpty()) {
			all_cnt++;
			cnts.put(tree, cnts.getOrDefault(tree, 0) + 1);
		}

		String[] name = cnts.keySet().toArray(new String[0]);
		Arrays.sort(name);

		for (int i = 0; i < name.length; i++) {
			System.out.printf("%s %.4f\n", name[i], (cnts.get(name[i]) * 1D / all_cnt) * 100);
		}
	}
}
