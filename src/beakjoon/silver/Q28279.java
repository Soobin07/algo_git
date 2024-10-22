package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

//덱 2
public class Q28279 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new ArrayDeque<Integer>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int commend = Integer.parseInt(st.nextToken());
			if (commend == 1) {
				deque.addFirst(Integer.parseInt(st.nextToken()));
			} else if (commend == 2) {
				deque.addLast(Integer.parseInt(st.nextToken()));
			} else if (commend == 3) {
				bw.append(deque.isEmpty() ? "-1\n" : deque.pollFirst() + "\n");
			} else if (commend == 4) {
				bw.append(deque.isEmpty() ? "-1\n" : deque.pollLast() + "\n");
			} else if (commend == 5) {
				bw.append(deque.size() + "\n");
			} else if (commend == 6) {
				bw.append(deque.isEmpty() ? "1\n" : "0\n");
			} else if (commend == 7) {
				bw.append(deque.isEmpty() ? "-1\n" : deque.peekFirst() + "\n");
			} else if (commend == 8) {
				bw.append(deque.isEmpty() ? "-1\n" : deque.peekLast() + "\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
