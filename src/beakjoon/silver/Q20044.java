package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//Project Teams
public class Q20044 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N * 2];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N * 2; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			min = Math.min(arr[i] + arr[N * 2 - 1 - i], min);
		}
		
		System.out.println(min);
	}
}
