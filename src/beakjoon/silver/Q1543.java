package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//문서 검색
public class Q1543 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] ori = br.readLine().toCharArray();
		char[] tar = br.readLine().toCharArray();

		int cnt = 0;
		// 시작점
		for (int i = 0; i <= ori.length - tar.length; i++) {
			int j = 0;
			// 비교하자
			for (; j < tar.length; j++) {
				// 다르면 멈추자
				if (ori[i + j] != tar[j])
					break;
			}
			// 전체 다 있으면?
			if (j == tar.length) {
				cnt++;
				i += (j - 1);
			}
		}

		System.out.println(cnt);
	}
}
