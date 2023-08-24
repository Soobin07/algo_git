package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1965 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] array = new int[N];
		for(int i = 0 ; i < N ; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] cnt = new int[N];
		Arrays.fill(cnt, 1);
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < i ; j++) {
				if(array[i] > array[j]) {
					cnt[i] = Math.max(cnt[i], cnt[j]+1);
				}
			}
		}
		
		int max = 0;
		for(int i = 0 ; i < N ; i++) {
			max = Math.max(max, cnt[i]);
		}
		System.out.println(max);
	}
}
