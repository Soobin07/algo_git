package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q2493 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		Stack<Integer> idx = new Stack<>();
		Stack<Integer> hei = new Stack<>();
		
		//N개 돌리기
		for(int i = 1 ; i <= N ; i++) {
			//이번 높이
			int now = Integer.parseInt(st.nextToken());
			//이전것들과 비교
			while(true) {
				if(hei.empty()) {
					//다 봤는데 얘보다 큰게 없다
					hei.add(now);
					idx.add(i);
					sb.append("0 ");
					break;
				}
				if(hei.peek() > now) {
					//peek이 받는다
					sb.append(idx.peek()+" ");
					//얘도 뭔가 받을 수도 있다
					hei.add(now);
					idx.add(i);
					break;
				}else {
					//현재 값 보다 작다 => 버려
					hei.pop();
					idx.pop();
				}
			}
		}
		sb.setLength(sb.length()-1);
		System.out.print(sb.toString());
		
	}
}
