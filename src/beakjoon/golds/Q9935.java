package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q9935 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String patt = br.readLine();

		// 실제로 줄이기에는 문자열의 길이 1_000_000이 너무 큰데

		// 1. 그냥 안나올 때 까지 계속 돌려보기 => 1%에서 틀렸습니다
		/*
		 * while (str.contains(patt)) { str = str.replaceAll("[" + patt + "]", ""); }
		 * 
		 * if (str.equals("")) System.out.print("FRULA"); else System.out.print(str);
		 */

		
		int len_p = patt.length();
		Stack<Character> s = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			s.push(str.charAt(i));
			if (s.size() >= len_p) {
				boolean flag = true;
				for (int j = 0; j < len_p; j++) {
					if (s.get(s.size() - len_p + j) != patt.charAt(j)) {
						flag = false;
						break;
					}
				}
				if (flag) {
					for (int j = 0; j < len_p; j++) {
						s.pop();
					}
				}
			}
		}
		StringBuffer sb = new StringBuffer();
		for (Character c : s) {
			sb.append(c);
		}

		if (sb.length() == 0)
			System.out.println("FRULA");
		else
			System.out.println(sb.toString());
	}
}
