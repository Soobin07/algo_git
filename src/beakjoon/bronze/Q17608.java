package beakjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q17608 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int max = arr[N - 1];
		int cnt = 1;
		for (int i = N - 1; i >= 0; i--) {
			if (arr[i] > max) {
				cnt++;
				max = arr[i];
			}
		}
		
		System.out.println(cnt);
	}
}
