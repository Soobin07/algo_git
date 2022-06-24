package jungol;

import java.util.Scanner;
import java.util.Stack;

public class C2858 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		int cnt = 0;
		Stack<Character> s = new Stack<>();
		for(int i = 0 ; i < str.length() ; i++) {
			char c = str.charAt(i);
			if(c == '(') s.add(c);
			else {
				if(str.charAt(i-1) == '(') {
					s.pop();
					cnt += s.size();
				}else {
					s.pop();
					cnt += 1;
				}
			}
		}
		System.out.println(cnt);
	}
}
