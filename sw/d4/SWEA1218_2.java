package sw.d4;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

//선생님이 알려주신 것
public class SWEA1218_2 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("data/sw/input1218.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int T = 10;
		for(int t = 1 ; t <= T ; t++) {
			int ans = 1; //정상 1 , 실패 0 
			sc.nextInt();
			Stack<Character> stack = new Stack<>();
			char[] data = sc.next().toCharArray();
			for(char c : data) {
				if("[{(<".contains(c+"")) {	//여는 괄호일 경우 스택에 푸쉬
					stack.push(c);
					continue;
				}
				//닫는 괄호일 경우
				if(stack.empty() || "[{(<".indexOf(stack.pop()) != "]})>".indexOf(c)) {	//유효하지 않은 상황이면 ans = 0을 세팅하고 반복을 종료
					ans = 0;
					break;
				}
			}
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.print(sb.toString());
	}
}
