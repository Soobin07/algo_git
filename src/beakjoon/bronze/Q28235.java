package beakjoon.bronze;

import java.util.HashMap;
import java.util.Scanner;

public class Q28235 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, String> cheer = new HashMap<>();
		cheer.put("SONGDO", "HIGHSCHOOL");
		cheer.put("CODE", "MASTER");
		cheer.put("2023", "0611");
		cheer.put("ALGORITHM", "CONTEST");
		System.out.println(cheer.get(sc.nextLine()));
	}
}
