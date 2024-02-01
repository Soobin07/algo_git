package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 어두운 굴다리
public class Q17266 {
	// 방안 1
	// 가능하지만 너무 느림
//	static int min, N, M;
//	static boolean[] answer;
//	static boolean[] comp;
//	static int[] arr;
//
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//		StringTokenizer st = null;
//
//		N = Integer.parseInt(br.readLine());
//		M = Integer.parseInt(br.readLine());
//		min = Integer.MAX_VALUE;
//
//		answer = new boolean[N];
//		for (int i = 0; i < N; i++) {
//			answer[i] = true;
//		}
//
//		arr = new int[M];
//		st = new StringTokenizer(br.readLine());
//		for (int i = 0; i < M; i++) {
//			arr[i] = Integer.parseInt(st.nextToken());
//		}
//
//		find(0, N);
//
//		System.out.println(min);
//	}
//
//	static void find(int start, int end) {
//		if (start > end) {
//			return;
//		}
//
//		comp = new boolean[N];
//		int mid = (start + end) / 2;
//
//		// 가로등 별로 불 비추어주기
//		for (int i = 0; i < arr.length; i++) {
//			// 앞쪽 비춰주기
//			Arrays.fill(comp, (arr[i] - mid) < 0 ? 0 : (arr[i] - mid), (arr[i] + 1) >= N ? N : (arr[i] + 1), true);
//			// 뒤쪽 비춰주기
//			if (arr[i] < N)
//				Arrays.fill(comp, arr[i], (arr[i] + mid) >= N ? (N) : (arr[i] + mid), true);
//		}
//
//		if (Arrays.equals(answer, comp)) {
//			min = mid;
//			find(start, mid - 1);
//		} else {
//			find(mid + 1, end);
//		}
//	}

	// 방안2
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		int[] arr = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 제일 앞에 있는 가로등 ~ 0 까지 거리 = 처음 나오는 최소 거리
		int min = arr[0] == 0 ? 1 : arr[0];
		for (int i = 1; i < M; i++) {
			// 두 가로등 사이를 전부 비출 수 있는 거리를 비교한다
			// +1 : 올림 하기 위해. /2 : 두 가로등의 사이를 비추려면 양쪽에서 비추면 되니까
			min = Math.max(min, (arr[i] - arr[i - 1] + 1) / 2);
		}
		// 마지막 가로등 ~ N까지의 거리 = 마지막으로 비교해야 하는 최소 거리
		min = Math.max(min, N - arr[M - 1]);

		System.out.println(min);
	}
}
