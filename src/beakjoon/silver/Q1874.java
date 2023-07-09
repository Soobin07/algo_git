package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q1874 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		Stack<Integer> stack = new Stack<>();
		int now = 1;
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		boolean flag = true;
		for(int i = 0 ; i < N ; i++) {
			while(arr[i] >= now) {
				 stack.add(now);
				 now++;
				 sb.append("+\n");
			}
			if(stack.peek() == arr[i]) {
				stack.pop();
				sb.append("-\n");
			}else {
				sb.setLength(0);
				sb.append("NO");
				flag = false;
				break;
			}
		}
		if(flag)
			sb.deleteCharAt(sb.length()-1);
		System.out.print(sb.toString());
	}
}
