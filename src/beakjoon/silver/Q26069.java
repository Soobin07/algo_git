package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q26069 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		HashSet<String> dancing = new HashSet<>();
		dancing.add("ChongChong");
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String A = st.nextToken();
			String B = st.nextToken();

			if (dancing.contains(A)) {
				dancing.add(B);
			} else if (dancing.contains(B)) {
				dancing.add(A);
			}
		}

		System.out.println(dancing.size());
	}
}
