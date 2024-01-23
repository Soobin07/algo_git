package beakjoon.silver;

import java.util.HashMap;
import java.util.Scanner;

public class Q1340 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String Month_str = sc.next();
		int day = Integer.parseInt(sc.next().replace(",", ""));
		int year = Integer.parseInt(sc.next());
		String[] time = sc.next().split(":");

		boolean isodd = false;
		if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
			isodd = true;
		}
		HashMap<String, Integer> months = new HashMap<>();
		months.put("January", 1);
		months.put("February", 2);
		months.put("March", 3);
		months.put("April", 4);
		months.put("May", 5);
		months.put("June", 6);
		months.put("July", 7);
		months.put("August", 8);
		months.put("September", 9);
		months.put("October", 10);
		months.put("November", 11);
		months.put("December", 12);
		int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		long all_sum = (365 + (isodd ? 1 : 0)) * 24 * 60; // 1년을 분으로 환산
		long now_sum = -1;
		for (int i = 1; i < months.get(Month_str); i++) {
			now_sum += (days[i - 1]);
			if (i == 2 && isodd)
				now_sum += 1;
		}
		now_sum += day;
		now_sum *= (24 * 60);
		now_sum += Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);

		double ans = now_sum / (all_sum * 1d);
		System.out.println(ans * 100);
	}
}
