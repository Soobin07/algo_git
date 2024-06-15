package beakjoon.bronze;

import java.util.Scanner;

//5와 6의 차이
public class Q2864 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();

		int max = Integer.parseInt(A) + Integer.parseInt(B);
		int min = Integer.parseInt(A) + Integer.parseInt(B);

		// 최대 => 5를 6으로
		String a = A;
		String b = B;
		if (A.contains("5")) {
			a = A.replace("5", "6");
		}
		if (B.contains("5")) {
			b = B.replace("5", "6");
		}
		max = Math.max(max, Integer.parseInt(a) + Integer.parseInt(b));

		// 최소 => 6을 5로
		a = A;
		b = B;
		if (A.contains("6")) {
			a = A.replace("6", "5");
		}
		if (B.contains("6")) {
			b = B.replace("6", "5");
		}
		min = Math.min(min, Integer.parseInt(a) + Integer.parseInt(b));

		System.out.println(min + " " + max);
	}
}
