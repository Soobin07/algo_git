package beakjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//시간 반 이하로 단축하길래  가져왔는데 다음에 다시 봐야겠다 모르겠네
public class Q2751_2 {
	
	static int[] arr = null;
	static int[] sorted = null;
	static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());		//숫자 갯수 받아옴
		arr = new int[n];								//갯수대로 배열 생성
		sorted = new int[n];
		for(int i = 0; i < n ; i++) {
			arr[i] = Integer.parseInt(br.readLine());	//배열에 값 넣기
		}
		
		divide(0, n-1);									//sort 함수
		
		for(int i = 0 ; i < n ; i++) {					//arr 정리됨? 얘를 넣음
			sb.append(arr[i]+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	public static void divide(int start, int end) {
		if(start < end) {	
			int mid = (start+end)/2;	//수열의 중간 찾음
			divide(start, mid);			//수열을 둘로 나눠서 다시 중간 찾음
			divide(mid, end);
			merge(start, mid, end);		//이름만 봐선 두 배열을 합치는데
		}//==> 결국은 0,1,2 셋중 두 수를 크기대로 정리하고 나머지 하나를 그냥 뒤에 넣어주는데, 결국 정리되어있겠네 => (0,1,2 정리하고 2,3,4 정리하고)정리하고...맨 마지막은? 
	}
	public static void merge(int start, int mid, int end) { 
		int left = start;
		int right = mid+1;
		int idx = start;
		
		while(left <= mid && right <= end) {	//시작이 mid보다 작거나 같고, mid+1이  end보다 작거나 같을때까지
			if(arr[left] < arr[right]) {	//왼쪽게 오른쪽보다 작으면
				sorted[idx] = arr[left];	//얘를 먼저 넣어줌
				left++;
			}else {
				sorted[idx] = arr[right];
				right++;
			}//작은 애를 sorted에 넣어준다
			idx++;	//idx 올려줌
		}//==> idx[start]~idx[...둘 중 하나가 먼저 끝날 때 까지] => 정리되는데 아래는?
		while(left <= mid) {	//left가 mid를 넘어갈 때 => 앞쪽만 남았을 때
			sorted[idx] = arr[left];	//하나씩 넣어준다
			left++;
			idx++;
		}//==> 앞쪽만 그냥 남았을 때, 위쪽 정리된 곳에 붙여서 그냥 넣어주는데?
		while(right <= end) {	//right가 end를 넘어갈 때 => 뒤쪽만 남았을 때
			sorted[idx] = arr[right];
			right++;
			idx++;
		}//==> 동일하게 뒤쪽만..
		
		for(int i = start ; i <= end; i++) {
			arr[i] = sorted[i];
		}//=>왜 다 정리된 척 하는거지!!!
	}
}
