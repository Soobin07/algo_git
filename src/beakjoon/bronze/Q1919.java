package beakjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//애너그램 만들기
public class Q1919 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] cnt = new int[26];
		String one = br.readLine();
		for (int i = 0; i < one.length(); i++) {
			cnt[one.charAt(i) - 'a']++;
		}

		String two = br.readLine();
		for (int i = 0; i < two.length(); i++) {
			cnt[two.charAt(i) - 'a']--;
		}

		int sum = 0;
		for (int i = 0; i < cnt.length; i++) {
			sum += Math.abs(cnt[i]);
		}
		System.out.println(sum);
	}
}
