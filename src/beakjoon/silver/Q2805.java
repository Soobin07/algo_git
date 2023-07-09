package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2805 {
	static long M = 0L;
	static long ans = 0L;
	static long[] arr = null;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		M = Long.parseLong(st.nextToken());
		
		// 나무 array
		st = new StringTokenizer(br.readLine());
		arr = new long[N];
		long max = 0L;
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			max = Math.max(arr[i], max);
		}
		
		find(1, max+1);
		
		System.out.println(ans);
	}
	
	static void find(long min, long max) {
		if(min > max) return;
		long mid = (min + max)/2;
	
		long sum = 0L;
		for(int i = 0 ; i < arr.length ; i++) {
			if(arr[i] > mid)
				sum += arr[i] - mid;
		}
		
		if(M <= sum) {
			if(ans >= mid)
				return;
			else {
				ans = mid;
				find(mid+1, max);
			}
		}else {
			find(min, mid-1);
		}
	}
}
