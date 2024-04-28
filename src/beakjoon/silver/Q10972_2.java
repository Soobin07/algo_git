package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//다음 순열
public class Q10972_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		if (next(arr, N)) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < N; i++) {
				sb.append(arr[i] + " ");
			}
			sb.setLength(sb.length() - 1);
			System.out.println(sb.toString());
		} else {
			System.out.println(-1);
		}
	}

	static boolean next(int[] arr, int n) {
		int i = n - 1;
		while (i > 0 && arr[i - 1] >= arr[i])
			i -= 1;

		if (i <= 0)
			return false;

		int j = n - 1;
		while (arr[j] <= arr[i - 1])
			j -= 1;
		swap(arr, i - 1, j);
		j = n - 1;
		while (i < j) {
			swap(arr, i, j);
			i += 1;
			j -= 1;
		}
		return true;
	}

	static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
