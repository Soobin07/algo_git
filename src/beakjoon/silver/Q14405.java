package beakjoon.silver;

import java.util.Scanner;

public class Q14405 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		String[] pkc = { "pi", "ka", "chu" };
		for (int i = 0; i < str.length(); i++) {
			boolean flag = false;
			for (int j = 0; j < 3; j++) {
				if (str.startsWith(pkc[j], i)) {
					i += (pkc[j].length() - 1);
					flag = true;
					continue;
				}
			}
			if (!flag) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
}
