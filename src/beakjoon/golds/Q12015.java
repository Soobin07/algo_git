package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q12015 {
	static int[] arr, max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		max = new int[N + 1];
		int size = 1;
		max[1] = arr[0];

		for (int i = 1; i < N; i++) {
			if (max[size] < arr[i]) {
				size++;
				max[size] = arr[i];
				continue;
			}
			int tmp = find(1, size, arr[i]);
			if (tmp != -1)
				max[tmp] = arr[i];
		}
		System.out.println(size);
	}

	static int find(int start, int end, int stad) {
		int mid = 0;
		while (end > start) {
			mid = (start + end) / 2;
			if (max[mid] < stad)
				start = mid + 1;
			else if (max[mid] > stad)
				end = mid;
			else
				return -1;
		}
		return end;
	}

}
