package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2110 {
	static int ans = 0;
	static int[] gaps;
	static int[] gaps_sum;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		//위치 입력
		int[] arr = new int[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		//위치 정렬
		Arrays.sort(arr);
		
		//gap array
		gaps = new int[N];
		gaps_sum = new int[N];
		for(int i = 1 ; i < N ; i++) {
			gaps[i] = arr[i]-arr[i-1];
			gaps_sum[i] = gaps_sum[i-1]+gaps[i];
		}
		
		find_max_min(1,gaps_sum[N-1], C);
		System.out.println(ans);
	}
	static void find_max_min(int min, int max, int C) {
		if(min > max)
			return;
		
		int mid = (min+max)/2;
		int c = 1;
		int idx = 0;
		// arr 끝까지 돌 때 까지 
		for(int i = 1 ; i < gaps.length ; i++) {
			//다음 집이 최대 "최소 떨어진" 거리 확보하고 있다면 
			if(gaps_sum[i] - gaps_sum[idx] >= mid) {
				//설치한 집 갯수에 추가하기
				c++;
				//마지막으로 설치한 집의 번호 업데이트
				idx = i;
			}
		}
		
		//c와 C를 비교하여 다음 mid값 생각하기
		if(c >= C) {
			//현재 설치 가능한 집 갯수가 더 많다 or 같다 => 더 큰 max_min값 있을 수 있다.
			ans = Math.max(ans, mid);
			find_max_min(mid+1, max, C);
		}else {
			//C만큼 설치하지 못했다 => 더 작은 max_min값이 필요하다
			find_max_min(min, mid-1, C);
		}
	}
}
