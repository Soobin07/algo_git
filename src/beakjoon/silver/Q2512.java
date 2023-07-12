package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2512 {
	
	static long budget;
	static int[] arr;
	static long maxbget;	//가장 크게 사용된 예산
	static int ans;	//가장 큰 수
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());	// 지방 수
		arr = new int[N];	// 각 지방 예산 요청 array
		
		//예산 요청을 array에 넣기
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			ans = Math.max(ans, arr[i]);
			maxbget += arr[i];
		}
		
		budget = Long.parseLong(br.readLine());	//총 예산
		
		//넘치나 확인
		if(maxbget > budget) {
			//넘치면 최댓값인 정수 찾으러 감
			int tmp = ans;
			maxbget = 0;
			ans = 0;
			find(1, tmp);
		}
		System.out.println(ans);
	}
	
	static void find(long min, long max) {
		if(min > max)
			return;
		
		// 예산 배정 최댓값이 mid인 경우
		long mid = (min+max)/2;
		long sum = 0;
		for(int i = 0 ; i < arr.length ; i++) {
			if(arr[i] > mid)
				sum += mid;
			else
				sum += arr[i];
		}
		
		if(sum <= budget) {
			// 위의 값을 최댓값으로 사용할 수 있음
			maxbget = sum;
			ans = (int)mid;
			
			//더 budget에 가까운 수가 있는지 확인
			find(mid + 1, max);
		}else {
			//위의 값이 예산 초과일 경우 더 작은 수에서 찾는게 좋음
			find(min, mid - 1);
		}
		
		
		
	}
}
