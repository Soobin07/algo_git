package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

//스택2 => int array로 했으면 더 빨랐겠지.
public class Q28278 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		LinkedList<Integer> stack = new LinkedList<>();
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int comm = Integer.parseInt(st.nextToken());
			switch (comm) {
			case 1:
				stack.addLast(Integer.parseInt(st.nextToken()));
				break;
			case 2:
				if (stack.size() > 0)
					bw.append(stack.pollLast() + "\n");
				else
					bw.append("-1\n");
				break;
			case 3:
				bw.append(stack.size() + "\n");
				break;
			case 4:
				bw.append((stack.isEmpty() ? "1" : "0") + "\n");
				break;
			case 5:
				if (stack.size() > 0)
					bw.append(stack.peekLast() + "\n");
				else
					bw.append("-1\n");
				break;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
