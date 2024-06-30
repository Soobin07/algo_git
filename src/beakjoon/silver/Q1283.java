package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//단축키 지정
public class Q1283 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer ans = new StringBuffer();
		StringBuffer tmp = new StringBuffer();

		int N = Integer.parseInt(br.readLine());
		boolean[] used = new boolean[26];

		game: for (int i = 0; i < N; i++) {
			String str = br.readLine();

			tmp.setLength(0);
			// 1번. 옵션 단어 첫 글자 왼쪽부터
			String[] str_tmp = str.split(" ");
			for (int j = 0; j < str_tmp.length; j++) {
				char up = Character.toUpperCase(str_tmp[j].charAt(0));
				// 알파벳인가?
				if (up < 'A' || up > 'Z')
					continue;
				// 사용되었나?
				if (used[up - 'A'])
					continue;

				// 이걸로 쓰자
				used[up - 'A'] = true;
				for (int k = 0; k < j; k++) {
					ans.append(str_tmp[k] + " ");
				}
				tmp.append("[");
				tmp.append(str_tmp[j].charAt(0));
				tmp.append("]");
				for (int k = 1; k < str_tmp[j].length(); k++) {
					tmp.append(str_tmp[j].charAt(k));
				}
				ans.append(tmp.toString() + " ");
				for (int k = j + 1; k < str_tmp.length; k++) {
					ans.append(str_tmp[k] + " ");
				}
				ans.append("\n");
				continue game;
			}

			// 2번. 왼쪽부터 모두
			for (int j = 0; j < str.length(); j++) {
				char up = Character.toUpperCase(str.charAt(j));
				// 알파벳인가?
				if (up < 'A' || up > 'Z')
					continue;
				// 사용되었나?
				if (used[up - 'A'])
					continue;

				// 이걸로 사용하자
				used[up - 'A'] = true;
				tmp.append(str);
				tmp.insert(j, "[");
				tmp.insert(j + 2, "]");
				ans.append(tmp.toString() + "\n");
				continue game;
			}

			ans.append(str + "\n");
		}

		bw.append(ans.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
