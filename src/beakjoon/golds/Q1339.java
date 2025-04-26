package beakjoon.golds;

import java.util.*;

class Q1339 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		HashMap<Character, Integer> cnt = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < str.length(); j++) {
				char ch = str.charAt(str.length() - 1 - j);
				cnt.put(ch, cnt.getOrDefault(ch, 0) + (int) Math.pow(10, j));
			}
		}

		int[] arr = new int[cnt.size()];
		int i = 0;
		for (Character c : cnt.keySet()) {
			arr[i++] = cnt.get(c);
		}

		Arrays.sort(arr);

		int sum = 0;
		for (int j = 0; j < arr.length; j++) {
			sum += (arr[arr.length - j - 1] * (9 - j));
		}

		System.out.print(sum);
	}
}