package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q2740 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int[][] A = new int[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
		for (int i = 0; i < A.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < A[i].length; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		int[][] B = new int[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
		for (int i = 0; i < B.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < B[i].length; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] ans = new int[A.length][B[0].length];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B[0].length; j++) {
				for (int k = 0; k < A[0].length; k++) {
					ans[i][j] += A[i][k] * B[k][j];
				}
			}
		}

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B[0].length; j++) {
				bw.append(ans[i][j] + " ");
			}
			bw.append("\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
