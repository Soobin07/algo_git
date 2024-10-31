package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//N과 M(11)
public class Q15665 {
	static int N, M;
	static int[] selected;
	static int[] array;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		// N, M 입력
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // N개의 자연수
		M = Integer.parseInt(st.nextToken()); // M개를 고른 수열

		// 초기화
		array = new int[N];
		selected = new int[M];

		// 수열 받기
		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			array[n] = Integer.parseInt(st.nextToken());
		}

		// 수열 정렬
		Arrays.sort(array);

		// 하나씩 선택
		select(0, bw);

		// 출력

		bw.flush();
		bw.close();
		br.close();
	}

	static void select(int selected_cnt, BufferedWriter bw) throws Exception {
		if (selected_cnt == M) {
			for (int value : selected) {
				bw.append(value + " ");
			}
			bw.append("\n");
			return;
		}

		// 바로 직전 사용한 숫자 (같으면 넘어가게)
		int before_used = -1;
		for (int i = 0; i < N; i++) {
			if (before_used == array[i])
				continue;
			selected[selected_cnt] = array[i];
			before_used = array[i];
			select(selected_cnt + 1, bw);
		}
	}

}
