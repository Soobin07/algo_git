package beakjoon.silver;

import java.util.Scanner;

//게임
public class Q1072 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double X = sc.nextInt();
		double Y = sc.nextInt();

		int Z = (int) ((double) (Y * 100 / X));

		if (Z >= 99) {
			System.out.println(-1);
		} else {
			int min = 0;
			int max = (int) X;
			int mid = 0;
			while (min <= max) {
				mid = (max + min) / 2;
				int tmp = (int) ((double) ((Y + mid) * 100 / (X + mid)));
				if(Z < tmp) {
					max = mid - 1;
				}else {
					min = mid + 1;
				}
			}
			System.out.println(min);
		}
	}
}
