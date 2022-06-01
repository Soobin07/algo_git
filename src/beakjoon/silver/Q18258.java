package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//명령어에서 첫글자만 따오고 (p일 경우에는 2번째를 대신 가져오기)
//그걸로 명령어 실행
public class Q18258 {
	static int[] arr;
	static int front = -1;
	static int rear = -1;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];

		for(int n = 0 ; n < N ; n++) {
			String line = br.readLine();
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