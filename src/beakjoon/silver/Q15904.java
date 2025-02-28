package beakjoon.silver;

import java.util.Scanner;

public class Q15904 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char[] arr = { 'U', 'C', 'P', 'C' };
		int cnt = 0;
		for (char c : str.toCharArray()) {
			if (arr[cnt] == c) {
				cnt++;
				if (cnt == 4)
					break;
			}
		}
		if(cnt == 4) {
			System.out.println("I love UCPC");
		}else {
			System.out.println("I hate UCPC");			
		}
	}
}
