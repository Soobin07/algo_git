package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

//영단어 암기는 괴로워
public class Q20920 {
	static class Word implements Comparable<Word> {
		String str;
		int cnt;
		int length;

		public Word(String str) {
			this.str = str;
			this.length = str.length();
			this.cnt = 1;
		}

		public Word(String str, int cnt) {
			this.str = str;
			this.length = str.length();
			this.cnt = cnt;
		}

		public void plus(int i) {
			cnt += i;
		}

		@Override
		public int compareTo(Word o) {
			if (o.cnt != this.cnt)
				return o.cnt - this.cnt;
			if (o.length != this.length)
				return o.length - this.length;

			for (int i = 0; i < this.length; i++) {
				if (o.str.charAt(i) != this.str.charAt(i))
					return this.str.charAt(i) - o.str.charAt(i);
			}

			return 0;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());// 나오는 단어 개수
		int M = Integer.parseInt(st.nextToken());// 길이 기준

		HashMap<String, Integer> dict = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			// 길이 확인하여 M과 길이가 같거나 더 긴 것만 넣는다
			if (tmp.length() >= M) {
				// 사전에 저장한다
				if (!dict.containsKey(tmp)) {
					dict.put(tmp, 1);
				} else {
					dict.replace(tmp, dict.get(tmp) + 1);
				}
			}
		}

		Word[] word_book = new Word[dict.size()];
		int idx = 0;
		for (String str : dict.keySet()) {
			word_book[idx++] = new Word(str, dict.get(str));
		}

		Arrays.sort(word_book);

		for (Word w : word_book) {
			bw.append(w.str + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
