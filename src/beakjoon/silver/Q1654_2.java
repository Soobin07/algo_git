package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1654_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[K];
		long max = 0;
		for(int i = 0 ; i < K ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i] > max)
				max = arr[i];
		}
		long ans = find(arr, N, 1, max+1);
		System.out.println(ans);
	}
	static long find(int[] arr, int N, long min, long max) {
		if(min > max) return 0;
		long mid = (min + max) / 2;
		//만약 mid로 나눈 값이 N을 넘지 못하면 작은 수로 가고, 넘으면 큰 수로 간다
		int cnt = 0;
		for(int i = 0 ; i < arr.length ; i++) {
			cnt += arr[i]/mid;
		}
		if(min == mid)
			return mid;
		if(cnt < N) {
			long sml = find(arr, N, min, mid);
			return sml;
		}else {
			long big = find(arr, N, mid, max);
			return Math.max(mid, big);
		}
	}
}
