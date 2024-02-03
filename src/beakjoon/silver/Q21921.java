package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q21921 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += Integer.parseInt(st.nextToken());
			arr[i] = sum;
		}

		int max = arr[M - 1];
		int cnt = 1;
		for (int i = M; i < N; i++) {
			int tmp = arr[i] - arr[i - M];
			if (tmp > max) {
				cnt = 1;
				max = tmp;
			} else if (tmp == max) {
				cnt++;
			}
		}

		if (max == 0) {
			bw.append("SAD");
		} else {
			bw.append(max + "\n");
			bw.append(cnt + "");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
