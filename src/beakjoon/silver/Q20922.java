package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q20922 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[N+1];
		int[] cnt = new int[100_001];
		
		st = new StringTokenizer(br.readLine());
		int max_length = 0;
		int start_idx = 1;
		for(int i = 1 ; i <= N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			cnt[arr[i]]++;
			if(cnt[arr[i]] > K) {
				max_length = Math.max(max_length, i-start_idx);
				for(int j = start_idx ; j < i ; j++) {
					if(arr[j] == arr[i]) {
						start_idx = j+1;
						cnt[arr[i]]--;
						break;
					}
				}
			}
		}
		max_length = Math.max(max_length, N - (start_idx-1));
		System.out.println(max_length);
	}
}
