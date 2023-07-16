package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q10610 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer(br.readLine());
		
		if(sb.indexOf("0") == -1) {
			System.out.println(-1);
		}else {
			long sum = 0;
			for(int i = 0 ; i < sb.length() ; i++) {
				sum += sb.charAt(i)-'0';
			}
			if(sum %3 != 0) {
				System.out.println(-1);
			}else {
				char[] arr = sb.toString().toCharArray();
				Arrays.sort(arr);
				sb = new StringBuffer();
				for(char c : arr) {
					sb.append(c);
				}
				sb.reverse();
				System.out.println(sb.toString());
			}
		}
		
	}
}
