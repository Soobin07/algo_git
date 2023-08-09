package beakjoon.silver;

import java.util.Scanner;
import java.util.Stack;

public class Q1935 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		//피연산자의 갯수
		int N = Integer.parseInt(sc.nextLine());
		
		//후위표기식 받는다
		String str = sc.nextLine();
		//숫자 받기
		double[] arr = new double[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Double.parseDouble(sc.nextLine());
		}
		
		double ans = 0;
		Stack<Double> num = new Stack<>();
		for(int i = 0 ; i < str.length() ; i++) {
			char c = str.charAt(i);
			if(c >= 'A' && c <= 'Z') {
				//숫자면 스택에
				num.add(arr[c-'A']);
			}else {
				//연산자다
				double num2 = num.pop();
				double num1= num.pop();
				if(c == '+') {
					num.add(num1+num2);
				}else if(c == '-') {
					num.add(num1-num2);
				}else if(c == '*') {
					num.add(num1*num2);
				}else {
					num.add(num1/num2);
				}
			}
		}
		
		System.out.printf("%.2f", num.pop());
	}
}
