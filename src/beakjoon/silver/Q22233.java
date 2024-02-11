package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

//가희와 키워드
public class Q22233 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 키워드 갯수
		int M = Integer.parseInt(st.nextToken()); // 블로그 글 갯수

		HashSet<String> words = new HashSet<>();
		for (int i = 0; i < N; i++) {
			words.add(br.readLine());
		}

		// 블로그 글 쓰기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), ",");
			while (st.hasMoreTokens()) {
				String str = st.nextToken();
				if (words.contains(str)) {
					words.remove(str);
				}
			}
			bw.append(words.size() + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
