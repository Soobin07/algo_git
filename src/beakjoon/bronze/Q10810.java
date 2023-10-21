package beakjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q10810 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int no = Integer.parseInt(st.nextToken());
			for (int j = start; j <= end; j++) {
				arr[j] = no;
			}
		}

		for (int i = 1; i <= N; i++) {
			bw.append(arr[i] + " ");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
