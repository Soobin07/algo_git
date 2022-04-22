package sw.d4;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

//쌤이 알려주시는 코드
public class SWEA1224_2 {	//Stack_06_계산기
	static Map<Character, Integer> priority = new HashMap<>();//우선순위 맵 만들어줌

	//static 변수에 대해 초기화 시켜주겠다
	static {	
		priority.put('(',0);
		priority.put('+',1);
		priority.put('-',1);
		priority.put('*',2);
		priority.put('/',2);
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("data/sw/input1224.txt"));
		Scanner sc = new Scanner(System.in);
		
		for(int t = 1 ; t <= 10 ; t++) {
			sc.nextInt(); //버림(길이)
			System.out.println("#"+t+" "+calc(makePost(sc.next())));
		}
	}
	//pre :전위 , in : 중위, post : 후위
	private static String makePost(String inData) {
		StringBuffer post = new StringBuffer();
		Stack<Character> op = new Stack<>();
		
		for(int i = 0 ; i < inData.length() ; i++) {
			char c = inData.charAt(i);
			if(c == '(') {	//연산자가 모여있는 스택에 무조건 집어넣는다.
				op.push(c);
				continue;
			}
			if( c == ')') {	//여는 괄호가 나올 때 까지 모두 꺼낸다. 단, 여는 괄호는 버림
				while(op.peek() != '(') {
					post.append(op.pop());
				}
				//여는괄호인 경우
				op.pop();
				continue;
			}
			if(c >= '0' && c <= '9') {	//숫자인 경우에는 후위표현식에 추가한다.
				post.append(c);
				continue;
			}
			//연산자일 경우
			if(op.empty()) {	//스택이 비어있는 경우는 그냥 입장
				op.push(c);
				continue;
			}
			
			//while에 isEmpty 있는 이유 => while 돌리면서 pop하다보면 stack이 텅텅 빌 수 있다.
			//이때 텅 빈 곳에서 peek 할 수 없으니까, 비었는지 매번 체크해준다.
			while(!op.isEmpty() && priority.get(c) <= priority.get(op.peek())) {
				post.append(op.pop());
			}
			op.push(c);
		}
		//스택에 남아있는 연산자를 꺼내서 후위표현식에 추가한다.
		while(!op.empty()) post.append(op.pop());
		
		return post.toString();
	}
	private static int calc(String post) {
		Stack<Integer> stack = new Stack<>();	//계산식 정교하게 하려면 double이 맞다
		for (int i = 0; i < post.length(); i++) {
			char c = post.charAt(i);
			if( c >= '0' && c <= '9') {
				stack.push(c - '0');	//char 끼리 연산하면 int로 연산이 된다. 따라서 숫자가 된다.
				continue;
			}
			//연산자일 경우
			int num2 = stack.pop();
			int num1 = stack.pop();
			int result = 0;
			switch(c) {
				case '+' : result = num1 + num2; break;
				case '-' : result = num1 - num2; break;
				case '*' : result = num1 * num2; break;
				case '/' : result = num1 / num2; break;
			}
			stack.push(result);
		}
		return stack.pop();
	}
}
