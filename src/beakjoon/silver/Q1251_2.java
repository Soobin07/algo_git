package beakjoon.silver;

import java.util.PriorityQueue;
import java.util.Scanner;

//단어 나누기
public class Q1251_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		// 나눌 idx 조합 nC3 하여 가장 작은 애를 찾아라
		int length = str.length();

		PriorityQueue<String> pq = new PriorityQueue<>();
		StringBuffer tmp = new StringBuffer();
		StringBuffer ans = new StringBuffer();

		// 3 덩어리로 나누는 것이니 가장 간단하게 for문 2개로 하자.
		for (int idx1 = 0; idx1 < length - 2; idx1++) {
			// idx1까지가 첫 단어
			tmp.append(str.substring(0, idx1 + 1));
			tmp.reverse();
			// 첫 단어
			String str1 = tmp.toString();
			for (int idx2 = idx1 + 1; idx2 < length - 1; idx2++) {
				tmp.setLength(0);
				// idx2까지가 두번째 단어
				tmp.append(str.substring(idx1 + 1, idx2 + 1));
				tmp.reverse();

				ans.append(str1);
				ans.append(tmp.toString());
				tmp.setLength(0);

				// idx2부터 끝까지가 마지막 단어
				tmp.append(str.substring(idx2 + 1, length));
				tmp.reverse();
				ans.append(tmp.toString());
				tmp.setLength(0);

				pq.add(ans.toString());
				ans.setLength(0);
			}
		}

		System.out.println(pq.peek());
	}
}
