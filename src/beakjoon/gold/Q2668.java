package beakjoon.gold;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q2668 {
	static int[] arr;
	static List<boolean[]> ansArrs;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		ansArrs = new ArrayList<>();
		int N = sc.nextInt();
		arr = new int[N + 1];
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		} // 값 입력

		for (int i = 1; i <= N; i++) {
			// 사이클 시작점 잡기
			Arrays.fill(visited, false);
			goNext(arr[i], i);
		}

		// 정답 구하는 방법을 생각해보자
		int cnt = 0;
		boolean[] mArr = new boolean[N+1];
		for(int i = 0 ; i < ansArrs.size() ; i++) {
			for(int j = 1 ; j <= N ; j++) {
				if(ansArrs.get(i)[j] && !mArr[j]) {
					mArr[j] = true;
					cnt++;
				}
			}
		}
		sb.append(cnt).append("\n");
		for(int i = 1 ; i < N+1 ; i++) {
			if(mArr[i]) sb.append(i).append("\n");
		}
		System.out.print(sb.toString());
	}

	static void goNext(int idx, int start) {
		if (visited[idx])
			return;
		visited[idx] = true;
		
		if (start == idx) {
			for (int i = 0; i < ansArrs.size(); i++) {
				if (Arrays.equals(ansArrs.get(i), visited)) {
					// 같으면 바로 패스
					return;
				}
			}
			ansArrs.add(Arrays.copyOf(visited, visited.length));
		}
		goNext(arr[idx], start);
	}

	// 시간초과
//	static int N, maxN;
//	static boolean[] visited, exist, tmpArr;
//	static int[] arr, ans;
//	static List<Integer> sel;
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		N = sc.nextInt();
//		visited = new boolean[N + 1];
//		exist = new boolean[N + 1];
//		arr = new int[N + 1];
//		tmpArr = new boolean[N + 1];
//		sel = new ArrayList<Integer>();
//
//		for (int i = 1; i < N + 1; i++) {
//			int num = sc.nextInt();
//			arr[i] = num;
//			exist[num] = true;
//		} // arr 가져오기 & 가지고 있는 숫자 확인
//
//		comb(1, 0);
//		System.out.println(maxN);
//		Arrays.sort(ans);
//		for (int i = 0; i < maxN; i++) {
//			System.out.println(ans[i]);
//		}
//	}
//
//	static void comb(int idx, int sidx) {
//		if (idx == N + 1) { // 찾기
//			Arrays.fill(tmpArr, false);
//			for (int i = 0; i < sidx; i++) {
//				tmpArr[sel.get(i)] = true;
//			}
//
//			for (int i = 0; i <= N; i++) {
//				if (tmpArr[i] != visited[i])
//					return;
//			}
//
//			if (sel.size() > maxN) {
//				maxN = sel.size();
//				ans = new int[sel.size()];
//				for (int i = 0; i < sel.size(); i++) {
//					ans[i] = sel.get(i);
//				}
//			}
//			return;
//		}
//
//		visited[idx] = false;
//		comb(idx + 1, sidx);
//
//		if (exist[idx]) {
//			visited[idx] = true;
//			sel.add(arr[idx]);
//			comb(idx + 1, sidx + 1);
//			sel.remove(sidx);
//			visited[idx] = false;
//		}
//	}
}
