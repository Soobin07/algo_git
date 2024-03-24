package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//import java.util.Collections;
//import java.util.ArrayList;
//import java.util.PriorityQueue;

//센서
/*
 * 동일 원소 제거는 필요 없었을 것 같다. 앞, 뒤 원소의 차를 가져올 때, 어차피 0이니까 답에 아무 영향을 주지 않는다.
 * 연산 최소화를 항상 생각해보자. 
 */
public class Q2212 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// 센서의 개수
		int N = Integer.parseInt(br.readLine());
		// 집중국의 개수
		int K = Integer.parseInt(br.readLine());

//		ArrayList<Integer> arr = new ArrayList<>();
//		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//		st = new StringTokenizer(br.readLine());
//
//		// 동일원소 제거하면서 array 담기
//		for (int i = 0; i < N; i++) {
//			int tmp = Integer.parseInt(st.nextToken());
//			if (arr.contains(tmp)) {
//				continue;
//			} else {
//				arr.add(tmp);
//			}
//		}
//
//		// sort
//		Collections.sort(arr);
//
//		// arr 각 원소 사이 차이 찾기
//		for (int i = 0; i < arr.size() - 1; i++) {
//			pq.add(arr.get(i + 1) - arr.get(i));
//		}
//
//		// 큰거 빼고 나머지 더하기
//		long sum = 0;
//		for (int i = 0; i < K - 1; i++) {
//			pq.poll();
//		}
//		while (!pq.isEmpty()) {
//			sum += pq.poll();
//		}
//
//		System.out.println(sum);

		// 더 간단하게
		int[] arr = new int[N]; // 센서
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr); // 센서 위치 정리

		int[] gap = new int[N - 1]; // 사이 거리
		for (int i = 1; i < N; i++) {
			gap[i - 1] = arr[i] - arr[i - 1];
		}
		Arrays.sort(gap); // 사이 거리 정리

		int ans = 0; // 범위 합
		for (int i = 0; i < N - K; i++) { // 큰 순서대로 K-1개 제외
			ans += gap[i];
		}
		System.out.println(ans);
	}
}
