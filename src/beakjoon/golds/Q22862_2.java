package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q22862_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
	
		boolean[] isOdd = new boolean[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i <= N ; i++) {
			if(Integer.parseInt(st.nextToken()) % 2 == 1) {
				isOdd[i] = true;
			}
		}
		
		int start = 1;
		int end = 1;
		int odd_count = 0;
		int max = 0;
		while(end <= N) {
			if(odd_count < K) {
				if(isOdd[end]) odd_count++;
				end++;
				max = Math.max(end - start - odd_count, max);
			}else {
				if(!isOdd[end]) {
					end++;
					max = Math.max(end - start - odd_count, max);
				}else {
					if(isOdd[start]) odd_count--;
					start++;
				}
			}
		}
		System.out.println(max);
	}
}
