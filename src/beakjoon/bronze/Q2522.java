package beakjoon.bronze;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Q2522 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			for (int j = i; j < N; j++) {
				bw.append(" ");
			}
			for (int j = 0; j < i; j++) {
				bw.append("*");
			}
			bw.append("\n");
		}
		for (int i = N - 1; i > 0; i--) {
			for (int j = i; j < N; j++) {
				bw.append(" ");
			}
			for (int j = 0; j < i; j++) {
				bw.append("*");
			}
			bw.append("\n");
		}
		bw.flush();
		bw.close();
		sc.close();
	}
}
