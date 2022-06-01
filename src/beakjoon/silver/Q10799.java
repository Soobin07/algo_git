package beakjoon.silver;

import java.util.Scanner;
import java.util.Stack;

public class Q10799 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> stack = new Stack<>();

		String line = sc.nextLine();
		int cnt = 0;
		for (int i = 0; i < line.length(); i++) {
			char ch = line.charAt(i);
			if(ch == '(') {
				stack.add('(');
				continue;
			}
			char pre = line.charAt(i-1);
			if(pre == ')') {
				stack.pop();
				cnt++;
				continue;
			}
			stack.pop();
			cnt += stack.size();
		}
		System.out.println(cnt);
	}
}
