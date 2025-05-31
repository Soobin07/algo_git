package beakjoon.bronze;

import java.util.ArrayList;
import java.util.Scanner;

public class Q29731 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> str = new ArrayList<String>();
		str.add("Never gonna give you up");
		str.add("Never gonna let you down");
		str.add("Never gonna run around and desert you");
		str.add("Never gonna make you cry");
		str.add("Never gonna say goodbye");
		str.add("Never gonna tell a lie and hurt you");
		str.add("Never gonna stop");

		int N = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < N; i++) {
			if (!str.contains(sc.nextLine())) {
				System.out.println("Yes");
				return;
			}
		}
		System.out.println("No");

	}
}
