package beakjoon.silver;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Q9575 {

	static String input1 = "2\r\n" + "6\r\n" + "100 1 10 100 1 1\r\n" + "7\r\n" + "3 53 53 53 53 53 53\r\n" + "6\r\n"
			+ "4 54 4 54 4 54\r\n" + "1\r\n" + "47\r\n" + "1\r\n" + "500\r\n" + "1\r\n" + "33"; // 2 0

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(input1);
		StringTokenizer st;

		int T = Integer.parseInt(sc.nextLine());

		for (int t = 0; t < T; t++) {
			
			Set<Integer> set = new HashSet<>();
			
			int[] arrA = new int[Integer.parseInt(sc.nextLine())];
			st = new StringTokenizer(sc.nextLine());
			for (int i = 0; i < arrA.length; i++) {
				arrA[i] = Integer.parseInt(st.nextToken());
			}

			int[] arrB = new int[Integer.parseInt(sc.nextLine())];
			st = new StringTokenizer(sc.nextLine());
			for (int i = 0; i < arrB.length; i++) {
				arrB[i] = Integer.parseInt(st.nextToken());
			}

			int[] arrC = new int[Integer.parseInt(sc.nextLine())];
			st = new StringTokenizer(sc.nextLine());
			for (int i = 0; i < arrC.length; i++) {
				arrC[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < arrA.length; i++) {
				for (int j = 0; j < arrB.length; j++) {
					for (int k = 0; k < arrC.length; k++) {
						int luck = arrA[i] + arrB[j] + arrC[k];
						int tmp = luck;
						while (tmp % 10 == 5 || tmp % 10 == 8) {
							if (tmp / 10 == 0 && (tmp % 10 == 5 || tmp % 10 == 8)) {
								set.add(luck);
							}
							tmp /= 10;
						}
					}
				}
			}
			System.out.println(set.size());
		}

	}
}
