package beakjoon.bronze;

import java.util.Scanner;

public class Q19698 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();
		int H = sc.nextInt();
		int L = sc.nextInt();

		int w = W / L;
		int h = H / L;
		int ans = w * h;
		if (ans >= N) {
			ans = N;
		}
		System.out.println(ans);
	}
}
