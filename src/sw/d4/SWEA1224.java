package sw.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

//long값 가능
public class SWEA1224 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("data/sw/input1224.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int T = 10;
		for(int t = 1 ; t <= T ; t++) {
			int length = Integer.parseInt(br.readLine());	//line의 길이
			String line = br.readLine();					//식
			
			char[] str = line.toCharArray();				//식을 문자 배열로
			
			Stack<Character> stack = new Stack<>();			//연산자를 담을 stack
			int index = -1;									//현재 식을 담은 문자 배열의 최대 index (식의 length)
			for(int i = 0 ; i < length ; i++) {
				char c = str[i];
				if(c >= '0' && c <= '9') {	// c 가 숫자일 때
					str[++index] = c;
					continue;
				}
				//숫자가 아니면 ( = 연산자 일 경우)
				if(stack.isEmpty()) {	//스택이 비어 있으면 넣어준다
					stack.push(c);
					continue;
				}
				char peek;	//스택이 비어있지 않으면
				switch(c) {
				case '-' : case '+' :
					while(true) {
						peek = stack.peek();
						if(peek != '(') {
							str[++index] = stack.pop();	//우선순위 높은 연산자를 식에 추가
							continue;	//while문 continue
						}
						stack.push(c);	//스택에 연산자 추가
						break;	//while문 나가기
					}
					break;
				case '*' : case '/' :
					while(true) {
						peek = stack.peek();
						if(peek == '*' || peek == '/') {
							str[++index] = stack.pop();
							continue;
						}
						stack.push(c);
						break;	//while문 나가기
					}
					break;
				case '(' : stack.push(c); break;
				case ')' : 
					while(true) {
						peek = stack.peek();
						if(peek != '(') {
							str[++index] = stack.pop();
							continue;
						}
						stack.pop();
						break;
					}
					break;
				}
			}
			while(!stack.isEmpty()) {	//남은 연산자가 있다면
				str[++index] = stack.pop();	//모두 출력하여 붙여준다
			}
			
			//후위표기식 
//			for(int i = 0; i < index+1 ; i++) System.out.print(str[i]);
			
			//만든 후위표기식을 이용하여 계산
			Stack<Integer> stack2 = new Stack<>();
			for(int i = 0 ; i < index+1 ; i++){
				char c = str[i];
				if(c >= '0' && c <= '9') {	//숫자면 스택에 넣어준다
					stack2.push((c-'0'));
					continue;
				}
				//연산자인 경우
				int before = stack2.pop();
				int after = stack2.pop();
				switch(c) {
				case '+' : 
					stack2.push(after+before);
					break;
				case '-' : 
					stack2.push(after-before);
					break;
				case '*' : 
					stack2.push(after*before);
					break;
				case '/' : 
					stack2.push(after/before);
					break;
				}
			}
			sb.append("#").append(t).append(" ").append(stack2.pop()).append("\n");
		}
		System.out.print(sb.toString());
	}
}
