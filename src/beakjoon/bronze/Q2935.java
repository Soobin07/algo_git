package beakjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//소음
public class Q2935 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer A = new StringBuffer(br.readLine());
		char oper = br.readLine().charAt(0);
		String B = br.readLine();

		// 큰 것을 A에 넣자
		if (A.length() < B.length()) {
			String tmp = A.toString();
			A.setLength(0);
			A.append(B);
			B = tmp;
		}

		if (oper == '*') {
			for (int i = 0; i < B.length() - 1; i++) {
				A.append("0");
			}
		} else {
			A.setCharAt(A.length() - B.length(), (char) (A.charAt(A.length() - B.length()) + 1));
		}

		System.out.println(A.toString());
	}
}
