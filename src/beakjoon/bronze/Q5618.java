package beakjoon.bronze;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Q5618 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = sc.nextInt();

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);
		bw.append("1\n");

		for (int i = 2; i <= arr[0]; i++) {
			boolean flag = true;
			for (int n = 0; n < N; n++) {
				if (arr[n] % i != 0) {
					flag = false;
					break;
				}
			}
			if (flag)
				bw.append(i + "\n");
		}

		bw.flush();
		bw.close();
		sc.close();
	}
}
