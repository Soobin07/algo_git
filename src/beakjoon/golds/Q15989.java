package beakjoon.golds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//1,2,3 더하기 4
public class Q15989 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[][] arr = new int[10001][4];
		arr[0][1] = 1;
		arr[1][1] = 1;
		for (int i = 2; i <= 10000; i++) {
			arr[i][1] = arr[i - 1][1];
			arr[i][2] = arr[i - 2][1] + arr[i - 2][2];
			if (i >= 3)
				arr[i][3] = arr[i - 3][1] + arr[i - 3][2] + arr[i - 3][3];
		}

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			bw.append((arr[n][1] + arr[n][2] + arr[n][3]) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
