package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q3986 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		Stack<Character> s = new Stack<>();
		String str = null;

		for (int i = 0; i < N; i++) {
			s.clear();
			str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				if (s.isEmpty()) {
					s.add(str.charAt(j));
					continue;
				}
				char c = s.pop();
				if (c == str.charAt(j)) {
					continue;
				} else {
					s.add(c);
					s.add(str.charAt(j));
				}
			}
			if (s.isEmpty()) {
				ans++;
			}
		}
		System.out.println(ans);
	}
}
