package beakjoon.silver;

import java.util.Scanner;

public class Q5555 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String patt = sc.next();
		int N = sc.nextInt();

		int cnt = 0;
		for (int n = 0; n < N; n++) {
			String str = sc.next();
			str += str;
			if (str.contains(patt))
				cnt++;
		}

		System.out.println(cnt);
	}
}
