package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2293 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] coin = new int[n + 1];
		int[] arr = new int[k + 1];
		arr[0] = 1;
		for (int i = 1; i <= n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
			for (int j = coin[i]; j <= k; j++) {
				arr[j] += arr[j - coin[i]];
			}
		}

		System.out.println(arr[k]);
	}
}
