package beakjoon.silver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

class Number implements Comparable<Number> {
	int num;
	String str;

	public Number(int num, String str) {
		this.num = num;
		this.str = str;
	}

	@Override
	public int compareTo(Number o) {
		return str.compareTo(o.str);
	}
}

public class Q1755 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int end = sc.nextInt();

		HashMap<Character, String> map = new HashMap<>();
		map.put('0', "zero");
		map.put('1', "one");
		map.put('2', "two");
		map.put('3', "three");
		map.put('4', "four");
		map.put('5', "five");
		map.put('6', "six");
		map.put('7', "seven");
		map.put('8', "eight");
		map.put('9', "nine");

		ArrayList<Number> list = new ArrayList<>();
		for (int i = start; i <= end; i++) {
			String str = String.valueOf(i);
			StringBuffer sb = new StringBuffer();
			for (int j = 0; j < str.length(); j++) {
				sb.append(map.get(str.charAt(j)));
				if (j != str.length() - 1) {
					sb.append(" ");
				}
			}
			list.add(new Number(i, sb.toString()));
		}

		Collections.sort(list);

		for (int i = 1; i <= list.size(); i++) {
			if (i % 10 == 0) {
				System.out.println(list.get(i - 1).num);
			} else {
				System.out.print(list.get(i - 1).num + " ");
			}
		}
	}
}
