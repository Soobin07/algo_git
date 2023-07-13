package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q3273 {
	static int[] arr;
	static int count;
	static int x;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		x = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		
		int L = 0;
		int R = n-1;
		long sum = 0;
		int ans = 0;
		
		while(L < R) {
			sum = arr[L]+arr[R];
			if(sum == x) {
				ans++;
				L++;
				R--;
			}else if(sum > x) {
				R--;
			}else {
				L++;
			}
		}
		System.out.println(ans);
	}
}
