package beakjoon.bronze;

import java.util.HashMap;
import java.util.Scanner;

public class Q27889 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		HashMap<String, String> name = new HashMap<>();
		name.put("NLCS", "North London Collegiate School");
		name.put("BHA", "Branksome Hall Asia");
		name.put("KIS", "Korea International School");
		name.put("SJA", "St. Johnsbury Academy");

		System.out.println(name.get(str));
	}
}
