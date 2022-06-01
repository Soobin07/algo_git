package beakjoon.silver;

import java.util.Scanner;

public class Q10845 {
	
	static String input1 = "15\r\n" + 
			"push 1\r\n" + 
			"push 2\r\n" + 
			"front\r\n" + 
			"back\r\n" + 
			"size\r\n" + 
			"empty\r\n" + 
			"pop\r\n" + 
			"pop\r\n" + 
			"pop\r\n" + 
			"size\r\n" + 
			"empty\r\n" + 
			"pop\r\n" + 
			"push 3\r\n" + 
			"empty\r\n" + 
			"front";	
	/*
	    1
		2
		2
		0
		1
		2
		-1
		0
		1
		-1
		0
		3
	 */
	
	static int[] arr;
	static int front = -1;
	static int rear = -1;

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(input1);
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(sc.nextLine());
		arr = new int[N];

		for(int n = 0 ; n < N ; n++) {
			String line = sc.nextLine();
			String order = line.split(" ")[0];
			
			switch(order) {
			case "push" : push(Integer.parseInt(line.split(" ")[1])); break;
			case "pop" : sb.append(pop()).append("\n");;break;
			case "size" : sb.append(size()).append("\n");; break;
			case "empty" : sb.append(empty()).append("\n");; break;
			case "front" : sb.append(front()).append("\n");; break;
			case "back" : sb.append(back()).append("\n");; break;
			}
		}
		System.out.print(sb.toString());
	}
	static void push(int X) {
		arr[++rear] = X;
	}
	static int pop() {
		if(empty() == 1) return -1;
		return arr[++front];
	}
	static int size() {
		return Math.max(rear-front, 0);
	}
	static int empty() {
		if(front == rear) return 1;
		return 0;
	}
	static int front() {
		if(empty() == 1) return -1;
		return arr[front+1];
	}
	static int back() {
		if(empty() == 1) return -1;
		return arr[rear];
	}
}
