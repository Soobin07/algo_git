package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q5635 {
	static class Person implements Comparable<Person> {
		String name;
		int year, month, day;

		public Person(String name, int year, int month, int day) {
			this.name = name;
			this.year = year;
			this.month = month;
			this.day = day;
		}

		public Person(String all) {
			String[] p = all.split(" ");
			this.name = p[0];
			this.year = Integer.parseInt(p[3]);
			this.month = Integer.parseInt(p[2]);
			this.day = Integer.parseInt(p[1]);
		}

		@Override
		public int compareTo(Person o) {
			if (year != o.year)
				return year - o.year;
			if (month != o.month)
				return month - o.month;
			return day - o.day;
		}

		@Override
		public String toString() {
			return name;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Person[] people = new Person[N];
		for (int i = 0; i < N; i++) {
			people[i] = new Person(br.readLine());
		}

		Arrays.sort(people);

		System.out.println(people[N - 1].toString());
		System.out.println(people[0].toString());
	}
}
