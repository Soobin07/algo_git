package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//N과 M(10)
public class Q15664 {
	static int N, M;
	static int[] array;
	static int[] selected;
	static ArrayList<String> used;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		// N, M 받기
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // N개 자연수
		M = Integer.parseInt(st.nextToken()); // 출력할 길이가 M인 수열

		// 초기화
		array = new int[N];
		selected = new int[M];
		used = new ArrayList<String>();

		// 수열 받기
		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			array[n] = Integer.parseInt(st.nextToken());
		}

		// 수열 정렬
		Arrays.sort(array);

		// 하나씩 선택
		select(0, 0);

		// 출력
		for (int i = 0; i < used.size(); i++) {
			bw.append(used.get(i) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	static void select(int idx, int selected_cnt) {
		if (selected_cnt == M) {
			String str = toString(selected);
			if (!used.contains(str)) {
				used.add(str);
			}
			return;
		}

		for (int i = idx; i < N; i++) {
			selected[selected_cnt] = array[i];
			select(i + 1, selected_cnt + 1);
		}
	}

	static String toString(int[] array) {
		return Arrays.toString(array).replaceAll("[\\[,\\]]", "");
	}
}
