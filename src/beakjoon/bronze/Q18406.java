package beakjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q18406 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer(br.readLine());
		
		int left = 0;
		int right = 0;
		
		for(int i = 0 ; i < sb.length()/2 ; i++) {
			left += sb.charAt(i);
		}
		for(int i = sb.length()/2 ; i < sb.length() ; i++) {
			right += sb.charAt(i);
		}
		
		if(left == right) {
			System.out.println("LUCKY");
		}else {
			System.out.println("READY");
		}
	}
}
