package beakjoon.bronze;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Q9316 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			bw.append("Hello World, Judge " + i + "!\n");
		}

		bw.flush();
		bw.close();
		sc.close();
	}
}
