package beakjoon.bronze;

import java.util.Scanner;

public class Q1264 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		sb.append(sc.nextLine());
		while(sc.hasNextLine() && !sb.toString().equals("#")) {
			int count = 0;
			for(char c : sb.toString().toCharArray()) {
				if("aieouAIEOU".contains(c+"")) {
					count++;
				}
			}
			System.out.println(count);
			sb.setLength(0);
			sb.append(sc.nextLine());
		}
	}
}
