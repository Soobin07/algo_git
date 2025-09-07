package beakjoon.bronze;

import java.util.LinkedList;
import java.util.Scanner;

public class Q21756 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		LinkedList<Integer> arr = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			arr.add(i);
		}

		while (arr.size() != 1) {
			for (int i = arr.size() - 1; i >= 0; i--) {
				if (i % 2 == 0) {
					arr.remove(i);
				}
			}
		}
		System.out.println(arr.get(0));

	}
}
