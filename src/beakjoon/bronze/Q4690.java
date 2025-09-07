package beakjoon.bronze;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Q4690 {
	public static void main(String[] args) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int A = 0;
		int B = 0;
		int C = 0;
		int D = 0;
		int sum = 0;

		for (int a = 3; a <= 100; a++) {
			A = a * a * a;
			for (int b = 2; b < a; b++) {
				B = b * b * b;
				for (int c = b + 1; c < a; c++) {
					C = c * c * c;
					if (A < B + C)
						break;
					for (int d = c + 1; d < a; d++) {
						D = d * d * d;
						sum = B + C + D;
						if (A == sum) {
							bw.append("Cube = " + a + ", Triple = (" + b + "," + c + "," + d + ")\n");
						} else if (A < sum) {
							break;
						}
					}
				}
			}
		}

		bw.flush();
	}
}
