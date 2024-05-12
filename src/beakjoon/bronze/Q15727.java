package beakjoon.bronze;

import java.util.Scanner;

public class Q15727 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int time = 0;
		while (true) {
			if (L <= 0)
				break;
			time++;
			L -= 5;
		}

		System.out.println(time);
	}
}