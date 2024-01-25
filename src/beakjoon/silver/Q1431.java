package beakjoon.silver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Q1431 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		ArrayList<String> arr = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			arr.add(sc.next());
		}

		Collections.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length()) {
					int sum1 = 0;
					int sum2 = 0;

					for (int i = 0; i < o1.length(); i++) {
						char c_o1 = o1.charAt(i);
						char c_o2 = o2.charAt(i);
						if (c_o1 >= '0' && c_o1 <= '9') {
							sum1 += (c_o1 - '0');
						}
						if (c_o2 >= '0' && c_o2 <= '9') {
							sum2 += (c_o2 - '0');
						}
					}

					if (sum1 == sum2) {
						for (int i = 0; i < o1.length(); i++) {
							char c_o1 = o1.charAt(i);
							char c_o2 = o2.charAt(i);
							if (c_o1 == c_o2)
								continue;
							return c_o1 - c_o2;
						}
					}
					return sum1 - sum2;
				}
				return o1.length() - o2.length();
			}
		});

		for (int i = 0; i < N; i++) {
			System.out.println(arr.get(i));
		}
	}
}
