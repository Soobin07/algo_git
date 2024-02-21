package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//문자열 교환
public class Q1522 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] ori = br.readLine().toCharArray();
		char[] sorted = Arrays.copyOf(ori, ori.length);
		Arrays.sort(sorted);

		int min = ori.length;

		// 시작
		for (int i = 0; i < ori.length; i++) {
			int cnt = 0;
			for (int j = 0; j < sorted.length; j++) {
				if (sorted[j] != ori[(i + j) %  ori.length]) {
					cnt++;
				}
			}
			min = Math.min(min, (cnt + 1) / 2);
		}
		
		System.out.println(min);
	}
}
