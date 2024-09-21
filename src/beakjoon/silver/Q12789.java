package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//도키도키 간식드리미
public class Q12789 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 몇명의 사람이 있는가
		StringTokenizer st = new StringTokenizer(br.readLine()); // 번호표 순서
		Stack<Integer> stack = new Stack<>(); // 한 사람만 들어갈 수 있는 통로

		/*
		 * 전 사람 번호 + 1 과 이번 사람 번호를 비교하여 1. 같으면, 전 사람 번호 update (순서대로 들어가는 경우) 2. 다르면, 전
		 * 사람 번호 + 1과 stack 가장 앞 번호를 비교 2-1. 같으면, 전 사람 번호 update 후 stack에 이번 사람 번호 넣기
		 * 2-2. 다르면, stack 가장 앞 번호와 이번 사람 번호 비교하여, 이번 사람 번호가 2-2-1. 크면, SAD로 종료. 2-2-2.
		 * 작으면, stack에 넣는다.
		 */

		int before = 0; // 이전 사람 번호
		boolean can = true; // SAD인 경우 확인 위해
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken()); // 이번 사람 번호
			// 1. 순서대로 들어가는 경우
			if (num == before + 1) {
				before = num;
				continue;
			}
			// 2. stack 확인 해야 하는 경우
			// 2-1. stack 제일 앞 사람이 가야 하는 경우
			while (!stack.isEmpty()) {
				if (stack.peek() == before + 1) {
					before = stack.pop();
					continue;
				}
				break;
			}
			// 2-1. stack이 비어서 비교 대상이 없으므로 그냥 넣어준다.
			if (stack.isEmpty()) {
				stack.add(num);
				continue;
			} else if (stack.peek() < num) {
				// 2-2. stack이 안 비었을 때stack 제일 앞 사람이 이번 사람보다 앞 번호인 경우 막힘.
				can = false;
				break;
			}
			stack.add(num);
		}
		// 남은 stack에 순서대로 들어있나 확인
		while (!stack.isEmpty()) {
			if (stack.peek() == before + 1) {
				before = stack.pop();
				continue;
			}
			can = false;
			break;
		}
		System.out.println(can ? "Nice" : "Sad");
	}
}
