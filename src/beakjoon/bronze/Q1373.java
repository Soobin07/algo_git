package beakjoon.bronze;

import java.util.Scanner;

//2진수 8진수
public class Q1373 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();

		// 2진수 받기
		String two = sc.next();

		/*
		 * //불가능. 이유? 100만자리였음. // 10진수로 변환 long N = 0; for (int i = 0; i <
		 * two.length(); i++) { N += (two.charAt(two.length() - 1 - i) - '0') *
		 * Math.pow(2, i); } // 8진수로 변환 while (true) { if(N == 0) { break; } sb.append(N
		 * % 8); N /= 8; }
		 */

		// 2진수 3자리 => 8진수 1자리
		// 시작수
		for (int i = two.length() - 1; i >= 0; i -= 3) {
			// 3자리를 하나의 숫자로 바꿈
			int N = 0;
			for (int j = 0; j < 3; j++) {
				//제일 끝은 음수가 나올 수 있으니 방어용
				if(i - j >= 0)
					N += (two.charAt(i - j) - '0') * Math.pow(2, j);
			}
			sb.append(N);
		}
		// 작은 수 부터 들어갔으니 reverse
		System.out.println(sb.reverse().toString());
	}
}
