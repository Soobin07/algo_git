package beakjoon.silver;

import java.util.Scanner;
import java.util.Stack;

public class Q9012 {
	static String input1 = "6\r\n" + "(())())\r\n" + "(((()())()\r\n" + "(()())((()))\r\n" + "((()()(()))(((())))()\r\n"
			+ "()()()()(()()())()\r\n" + "(()((())()("; // NO NO YES NO YES NO
	static String input2 = "3\r\n" + "((\r\n" + "))\r\n" + "())(()"; // NO NO NO

	public static void main(String[] args) {
		Scanner sc = new Scanner(input1);
//		Scanner sc = new Scanner(System.in);

		int T = Integer.parseInt(sc.nextLine());
		for (int t = 1; t <= T; t++) {
			String ans = "YES";
			String line = sc.nextLine();
			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				if (c == '(') {
					stack.add(c);
				}else {
					if (stack.isEmpty()) {
						ans = "NO";
						break;
					}
					stack.pop();
				}
			}
			if (!stack.isEmpty()) {
				ans = "NO";
			}
			System.out.println(ans);
		}
		sc.close();
	}
}
