package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Q19583 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String S = st.nextToken();
		String E = st.nextToken();
		String Q = st.nextToken();

		int startTime = Integer.parseInt(S.split(":")[0]) * 60 + Integer.parseInt(S.split(":")[1]);
		int endTime = Integer.parseInt(E.split(":")[0]) * 60 + Integer.parseInt(E.split(":")[1]);
		int streamTime = Integer.parseInt(Q.split(":")[0]) * 60 + Integer.parseInt(Q.split(":")[1]);

		Set<String> before = new HashSet<>();
		Set<String> chul = new HashSet<>();

		while (true) {
			String input = br.readLine();
			if (input == null || input.equals("") || input.equals(null)) {
				break;
			}

			st = new StringTokenizer(input, " ");
			String now = st.nextToken();
			int nowTime = Integer.parseInt(now.split(":")[0]) * 60 + Integer.parseInt(now.split(":")[1]);
			String nick = st.nextToken();

			if (nowTime <= startTime) {
				before.add(nick);
			} else if (before.contains(nick) && nowTime >= endTime && nowTime <= streamTime) {
				chul.add(nick);
			}
		}

		System.out.println(chul.size());
	}
}
