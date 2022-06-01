package sw.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA1218 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("data/sw/input1218.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int T = 10;
		for(int t = 1 ; t <= T ; t++) {
			int len = Integer.parseInt(br.readLine());
			String line = br.readLine();
			char[] arr = line.toCharArray();
			Stack<Character> stack = new Stack<>();
			
			boolean isOk = true;
			
			for(int i = 0 ; i < len ; i++) {
				char c = arr[i];
				if(c == '(' || c == '['|| c == '{'|| c == '<') {
					stack.push(c);
				}else{
					if(!stack.isEmpty()) {
						char pop = stack.pop();
						if(c == ')' && pop == '(') {
							continue;
						}else if(c == ']' && pop == '[') {
							continue;
						}else if(c == '}' && pop == '{') {
							continue;
						}else if(c == '>' && pop == '<') {
							continue;
						}
					}
					isOk = false;
					break;
				}
			}
			if(!stack.isEmpty()) isOk = false;
			
			sb.append("#").append(t).append(" ").append(isOk? 1 : 0).append("\n");
		}
		System.out.print(sb.toString());
	}
}
