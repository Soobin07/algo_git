package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Q10866 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		StringBuffer sb = new StringBuffer();
		
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			String commend = st.nextToken();
			if("push_front".equals(commend)) {
				deque.push(Integer.parseInt(st.nextToken()));
			}else if("push_back".equals(commend)) {
				deque.add(Integer.parseInt(st.nextToken()));
			}else if("pop_front".equals(commend)) {
				if(deque.isEmpty())
					sb.append("-1"+"\n");
				else
					sb.append(deque.pop()+"\n");
			}else if("pop_back".equals(commend)) {
				if(deque.isEmpty())
					sb.append("-1"+"\n");
				else
					sb.append(deque.pollLast()+"\n");
			}else if("size".equals(commend)) {
				sb.append(deque.size()+"\n");
			}else if("empty".equals(commend)) {
				if(deque.isEmpty())
					sb.append("1\n");
				else
					sb.append("0\n");
			}else if("front".equals(commend)) {
				if(deque.isEmpty())
					sb.append("-1"+"\n");
				else
					sb.append(deque.peekFirst()+"\n");
			}else if("back".equals(commend)) {
				if(deque.isEmpty())
					sb.append("-1"+"\n");
				else
					sb.append(deque.peekLast()+"\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}
