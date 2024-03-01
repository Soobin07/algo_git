package beakjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//직사각형
public class Q27323 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());

		System.out.println(A * B);
	}
}
