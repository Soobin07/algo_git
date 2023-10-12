package beakjoon.bronze;

import java.util.Scanner;

public class Q10808 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int[] cnt = new int[26];
		
		String str = sc.next();
		for(int i = 0 ; i < str.length() ; i++) {
			cnt[str.charAt(i)-'a']++;
		}
		for(int i = 0 ; i < 26 ; i++) {
			sb.append(cnt[i]+" ");
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}
}
