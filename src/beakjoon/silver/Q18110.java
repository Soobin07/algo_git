package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q18110 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] array = new int[N];

		for (int n = 0; n < N; n++) {
			array[n] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(array);

		int exclude = (int) Math.round(N * 0.15);
		long sum = 0;
		for (int i = exclude; i < N - exclude; i++) {
			sum += array[i];
		}
		System.out.println(Math.round(1.0 * sum / (N - exclude * 2)));
	}
}
