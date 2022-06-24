package jungol;

import java.util.Scanner;
import java.util.Stack;


public class C1221 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		
		Stack<Integer> tmp = new Stack<>();
		for(int i = 0 ; i < M ; i++) {
			char c = sc.next().charAt(0);
			if(c >= '0' && c <= '9') {	//c가 숫자면
				tmp.add(c-'0');
			}else if(c == '+'){
				tmp.add(tmp.pop()+tmp.pop());
			}else if(c == '-') {
				int num1 = tmp.pop();
				int num2 = tmp.pop();
				tmp.add(num2 - num1);
			}else if(c == '*') {
				tmp.add(tmp.pop()*tmp.pop());
			}else if(c == '/') {
				int num1 = tmp.pop();
				int num2 = tmp.pop();
				tmp.add(num2 / num1);
			}
		}
		System.out.println(tmp.pop());
	}
}
