package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//여왕벌
public class Q10836 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();

		int M = Integer.parseInt(st.nextToken()); // 격자칸 크기
		int N = Integer.parseInt(st.nextToken()); // 날짜 수

		// 애벌레 사이즈
		// 왼쪽 0번째 줄 애벌레의 크기와 1번째 열 부터 각 열 애벌레의 크기(동일)
		int[] size = new int[M * 2 - 1];
		Arrays.fill(size, 1);

		// 애벌레들 하루
		// 하루에 얼마나 자라나?
		for (int i = 0; i < N; i++) {
			// 0, 1, 2의 갯수
			st = new StringTokenizer(br.readLine());
			int zero = Integer.parseInt(st.nextToken());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());

			// 각각 얼마나 자랐나?
			// 0, 1, 2 넣기
			for (int m = 0; m < size.length; m++) {
				if (zero != 0) {
					size[m] += 0;
					zero--;
				} else if (one != 0) {
					size[m] += 1;
					one--;
				} else if (two != 0) {
					size[m] += 2;
					two--;
				}
			}
		}

		// 출력
		for (int i = 0; i < M; i++) {
			sb.append(size[M - 1 - i] + " ");
			for (int j = 1; j < M; j++) {
				sb.append(size[M - 1 + j] + " ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}
