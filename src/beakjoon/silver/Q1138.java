package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//한 줄로 서기
public class Q1138 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] left = new int[N];
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			left[i] = Integer.parseInt(st.nextToken());
			int empty = 0;
			for (int j = 0; j < N; j++) {
				if (arr[j] == 0)
					empty++;
				if (empty >= left[i] + 1 && arr[j] == 0) {
					arr[j] = i + 1;
					break;
				}
			}
		}

		// 출력
		for (int i = 0; i < N; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
