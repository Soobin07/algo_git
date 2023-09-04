package beakjoon.golds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q27172 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		int[] cards = new int[N];
		int[] points = new int[N];
		int max = 0;
		// card 넣기
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, cards[i]);
		}

		//
		int[] arr = new int[max + 1];
		for (int i = 0; i < N; i++) {
			arr[cards[i]] = (i + 1);
		}

		for (int i = 0; i < N; i++) {
			for (int j = cards[i] * 2; j <= max; j += cards[i]) {
				if (arr[j] != 0) {
					points[arr[j] - 1]--;
					points[i]++;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			bw.append(points[i] + " ");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
