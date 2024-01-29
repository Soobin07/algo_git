package beakjoon.bronze;

import java.util.Scanner;

public class Q4999 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String say = sc.next();
		String hos = sc.next();

		if (say.contains(hos)) {
			System.out.println("go");
		} else {
			System.out.println("no");
		}
	}
}
