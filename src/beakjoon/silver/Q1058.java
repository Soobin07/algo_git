package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1058 {
	static String[] friendRelation;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		friendRelation = new String[N];
		for (int i = 0; i < N; i++) {
			friendRelation[i] = br.readLine();
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			boolean[] friend = new boolean[N];
			friend(1, friendRelation[i], friend);
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;
				if (friend[j])
					cnt++;
			}
			max = Math.max(cnt, max);
		}
		
		System.out.println(max);
	}

	static void friend(int no, String str, boolean[] friend) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'N')
				continue;
			friend[i] = true;
			if (no == 1) {
				friend(2, friendRelation[i], friend);
			}
		}
	}
}
