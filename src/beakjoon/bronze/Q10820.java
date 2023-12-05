package beakjoon.bronze;

import java.util.Scanner;

public class Q10820 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String str = sc.nextLine();
			if(str == null || str.equals("")) {
				break;
			}
			int[] arr = new int[4]; // 소, 대, 숫, 공
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);

				if (ch >= '0' && ch <= '9') {
					arr[2]++;
				} else if (ch >= 'a' && ch <= 'z') {
					arr[0]++;
				} else if (ch >= 'A' && ch <= 'Z') {
					arr[1]++;
				} else if (ch == ' ') {
					arr[3]++;
				}
			}
			System.out.println(arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3]);
		}

	}
}
