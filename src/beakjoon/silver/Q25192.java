package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

//인사성 밝은 곰곰이
public class Q25192 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		HashSet<String> visit = new HashSet<>();
		for (int n = 0; n < N; n++) {
			String name = br.readLine();
			if ("ENTER".equals(name)) {
				cnt += visit.size();
				visit.clear();
				continue;
			}
			visit.add(name);
		}
		cnt += visit.size();
		System.out.println(cnt);
	}
}
