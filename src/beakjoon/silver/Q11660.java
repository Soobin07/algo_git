package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q11660 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 표의 크기
		int M = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수

		long[][] sum_table = new long[N+1][N+1]; // 누적합 표
		for (int i = 1; i <= N; i++) {
			long sum = 0; // 앞에서부터 더해서
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				sum += Integer.parseInt(st.nextToken());
				sum_table[i][j] = sum;
			}
		}
		for(int i = 2 ; i <= N ; i++) {
			for(int j = 1 ; j <= N ; j++) {
				sum_table[i][j] += sum_table[i-1][j];
			}
		}

		// 합을 구해야 하는 경우
		int x1 = 0;
		int y1 = 0;
		int x2 = 0;
		int y2 = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			bw.append((sum_table[x2][y2] - sum_table[x2][y1-1] - sum_table[x1-1][y2] + sum_table[x1-1][y1-1]) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
