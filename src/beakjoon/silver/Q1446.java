package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//지름길
public class Q1446 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 지름길 갯수
		int D = Integer.parseInt(st.nextToken()); // 고속도로 길이

		int[] arr = new int[D + 1];

		// 지름길 사용 없이 그냥 갈 때 도착 시간
		for (int i = 1; i <= D; i++) {
			arr[i] = i;
		}

		// 지름길 입력
		int[][] roads = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			roads[i] = new int[] { start, end, time }; 
		}

		// 지름길 정렬 => 1. 끝이 앞 2. 시작이 앞 3. 시간이 짧음
		Arrays.sort(roads, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] != o2[1])
					return o1[1] - o2[1];
				if (o1[0] != o2[0])
					return o1[0] - o2[0];
				return o1[2] - o2[2];
			}
		});

		// 지름길 사용시
		for (int i = 0; i < N; i++) {
			int start = roads[i][0];
			int end = roads[i][1];
			int time = roads[i][2];

			// 갈 필요 없는 지름길은 안간다
			if (start < 0 || start > D || end < 0 || end > D)
				continue;

			// 지름길 사용이 이득인 경우
			if (arr[end] > arr[start] + time) {
				// 쭉 끝까지 간다
				for (int j = end; j <= D; j++) {
					// 지름길 사용해서 가는게 이득인 경우
					if (arr[j] > arr[start] + time + (j - end)) {
						arr[j] = arr[start] + time + (j - end);
					} else {
						// 이득이 아니면 멈춘다
						break;
					}
				}
			}
		}

		System.out.println(arr[D]);
	}
}
