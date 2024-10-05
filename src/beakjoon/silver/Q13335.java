package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//트럭
public class Q13335 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// 조건 받기
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 다리를 건너는 트럭의 수
		int w = Integer.parseInt(st.nextToken()); // 다리의 길이
		int L = Integer.parseInt(st.nextToken()); // 다리의 최대하중

		// 트럭의 무게
		st = new StringTokenizer(br.readLine());
		Queue<Integer> truck = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			truck.add(Integer.parseInt(st.nextToken()));
		}

		// w길이에 뭐 있음?
		Queue<Integer> bridge = new LinkedList<>();
		for (int i = 0; i < w; i++) {
			bridge.add(0);
		}

		int time = 0;
		int weight = 0;
		while (!bridge.isEmpty()) {
			time++;
			weight -= bridge.poll();

			if (truck.isEmpty())
				continue;

			if (truck.peek() + weight <= L) {
				int cur = truck.poll();
				weight += cur;
				bridge.add(cur);
			} else {
				bridge.add(0);
			}
		}

		System.out.println(time);
	}
}
