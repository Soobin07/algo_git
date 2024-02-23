package beakjoon.golds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Q20437 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 게임의 수
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			// 문자열
			String str = br.readLine();
			// 정수 K
			int K = Integer.parseInt(br.readLine());

			// 해당 char이 들어있는 idx 확인
			ArrayList<Integer>[] arr = new ArrayList[26];
			for (int i = 0; i < 26; i++) {
				arr[i] = new ArrayList<>();
			}

			// 앞에서부터 해당 char의 arraylist에 idx를 넣어 정리
			for (int i = 0; i < str.length(); i++) {
				arr[str.charAt(i) - 'a'].add(i);
			}

			int min = str.length();
			int max = 0;
			boolean flug = false; // k개 이상 있는게 있나?
			// 앞에서부터 k개 있는지 확인
			for (int i = 0; i < 26; i++) {
				if (arr[i].size() < K)
					continue;

				// k개 이상 있으면
				for (int j = 0; j < arr[i].size() - K + 1; j++) {
					// 1. 가장 짧은 길이 확인
					min = Math.min(min, arr[i].get(j + K - 1) - arr[i].get(j) + 1);
					// 2. 가장 긴 길이 확인
					max = Math.max(max, arr[i].get(j + K - 1) - arr[i].get(j) + 1);
				}

				flug = true;
			}

			if (flug) {
				bw.append(min + " " + max + "\n");
			} else {
				bw.append("-1\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
