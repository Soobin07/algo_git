package beakjoon.bronze;

import java.util.Scanner;
import java.util.Stack;

public class Q10828 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		StringBuffer sb = new StringBuffer();
		
		int n = Integer.parseInt(sc.nextLine());
		
		for(int i = 0 ; i < n ; i++) {
			String[] arr = sc.nextLine().split(" ");
			
			switch(arr[0]) {
			case "push" : 
				stack.add(Integer.parseInt(arr[1]));
				break;
			case "pop" : 
				if(!stack.isEmpty()) {
					sb.append(stack.pop()).append("\n");
				}else {
					sb.append(-1).append("\n");
				}
				break;
			case "size" : 
				sb.append(stack.size()).append("\n");
				break;
			case "empty" : 
				if(stack.isEmpty()) sb.append(1).append("\n");
				else sb.append(0).append("\n");
				break;
			case "top" : 
				if(!stack.isEmpty()) {
					sb.append(stack.peek()).append("\n");
				}else {
					sb.append(-1).append("\n");
				}
				break;
			}
		}
		System.out.println(sb.toString());
	}
}
