package beakjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1551 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		String[] str = br.readLine().split(",");
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}

		for (int i = 0; i < K; i++) {
			arr = change(arr);
		}
		System.out.println(Arrays.toString(arr).replaceAll("[\\[\\] ]", ""));
	}

	static int[] change(int[] arr) {
		int[] tmp = new int[arr.length - 1];
		for (int i = 0; i < arr.length - 1; i++) {
			tmp[i] = arr[i + 1] - arr[i];
		}
		return tmp;
	}
}
