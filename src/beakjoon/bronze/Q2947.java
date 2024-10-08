package beakjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 나무 조각
public class Q2947 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[5];
		for (int i = 0; i < 5; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		if (ordered(arr))
			print(arr);        
		while (!ordered(arr)) {
			for (int i = 1; i < 5; i++) {
				if (arr[i - 1] > arr[i]) {
					int tmp = arr[i - 1];
					arr[i - 1] = arr[i];
					arr[i] = tmp;
					print(arr);
				}
			}
		}
	}

	public static boolean ordered(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[i - 1])
				return false;
		}
		return true;
	}

	public static void print(int[] arr) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i] + " ");
		}
		System.out.println(sb.toString());
	}
}
