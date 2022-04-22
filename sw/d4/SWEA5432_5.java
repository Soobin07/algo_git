package sw.d4;

import java.util.Scanner;
import java.util.Stack;

public class SWEA5432_5 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("data/sw/input5432.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.parseInt(sc.nextLine());
		
		for(int t = 1 ; t <= T ; t++) {
			int cnt = 0;
			Stack<Integer> stack = new Stack<>();
			String line = sc.nextLine();
			for(int i = 0 ; i < line.length() ; i++) {
				if(line.charAt(i) == '(') stack.push(i);
				else {
					if(stack.peek() + 1 == i) {
						stack.pop();
						cnt+=stack.size();
					}else {
						stack.pop();
						cnt++;
					}
				}
			}
			if(!stack.isEmpty()) cnt+=stack.size();
			System.out.printf("#%d %d%n", t, cnt);
		}
	}
}
