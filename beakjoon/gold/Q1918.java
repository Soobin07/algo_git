package beakjoon.gold;

import java.util.Scanner;
import java.util.Stack;

public class Q1918 {
	//1. 식을 받고 char[]로 바꾼다
	//2. stack을 선언한다.
	//3. for로 char[]를 탐색하여 연산자이면 stack에 넣고, 알파벳이면 그대로 출력에 넣는다
	//3-1. +- 오면 스텍에 아무것도 없거나 스텍 제일 위에 (가 나올 때 까지 stack.pop하여 출력에 넣는다
	//3-2. */ 면 스텍에 아무것도 없거나 제일 위에 +-(가 올 때 까지 stack.pop하여 출력에 넣는다
	//4. (면 무조건 stack에 넣고, )가 오면 (가 나올 때 까지 stack.pop하여 출력에 넣는다
	//5. 식이 다 끝나면 stack에 남은 연산자를 출력에 넣는다.
	
	static String input1 = "A*(B+C)";	//ABC+*
	static String input2 = "A+B";		//AB+
	static String input3 = "A+B*C";		//ABC*+
	static String input4 = "A+B*C-D/E";	//ABC*+DE/-
	public static void main(String[] args) {
//		Scanner sc= new Scanner(System.in);
		Scanner sc= new Scanner(input4);
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		char[] line = sc.nextLine().toCharArray();
		
		for(int i = 0; i < line.length ; i++) {
			char ch = line[i];
			if(ch >= 'A' && ch <='Z') {
				sb.append(ch);
				continue;
			}
			if(stack.isEmpty()) {
				stack.push(ch);
				continue;
			}
			if("+-".contains(ch+"")) {
				while(true) {
					if(!stack.isEmpty()) {
						char peek = stack.peek();
						if(peek != '(') {
							sb.append(stack.pop());
							continue;
						}
					}
					stack.push(ch);
					break;
				}
			}else if(ch == '('){
				stack.push(ch);
			}else if("*/".contains(ch+"")) {
				while(true) {
					if(!stack.isEmpty()) {
						char peek = stack.peek();
						if(!("+-(".contains(peek+""))) {
							sb.append(stack.pop());
							continue;
						}
					}
					stack.push(ch);
					break;
				}
			}else if(ch == ')') {
				while(true) {
					if(!stack.isEmpty()) {
						char peek = stack.peek();
						if(peek == '(') {
							stack.pop();
							break;
						}
					}
					sb.append(stack.pop());
				}
			}
		}
		if(!stack.isEmpty()) {
			while(true) {
				if(stack.isEmpty()) break;
				sb.append(stack.pop());
			}
		}
		System.out.println(sb.toString());
	}
}
