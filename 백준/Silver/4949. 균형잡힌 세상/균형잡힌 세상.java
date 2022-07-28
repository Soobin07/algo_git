import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = null;
		StringBuffer sb = new StringBuffer();
		
		while(!(str = sc.nextLine()).equals(".")) {
			Stack<Character> s = new Stack<>();
			boolean isEnd = true;
			
			for(int i = 0 ; i < str.length() ; i++) {
				char ch = str.charAt(i);
				if(ch == '('|| ch == '[') {
					s.add(ch);
				}else if(ch == ')') {
					if(s.isEmpty()) {
						sb.append("no").append("\n");
						isEnd = false;
						break;
					}
					char tmp = s.pop();
					if(tmp != '(') {
						sb.append("no").append("\n");
						isEnd = false;
						break;
					}
				}else if(ch == ']') {
					if(s.isEmpty()) {
						sb.append("no").append("\n");
						isEnd = false;
						break;
					}
					char tmp = s.pop();
					if(tmp != '[') {
						sb.append("no").append("\n");
						isEnd = false;
						break;
					}
				}
			}
			if(isEnd) {
				if(!s.isEmpty()) {
					sb.append("no").append("\n");
				}else {
					sb.append("yes").append("\n");
				}
			}
		}
		System.out.print(sb.toString());
	}
}
