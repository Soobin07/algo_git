package sw.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

//switch가 확실히 메모리 /실행 시간을 많이 잡아먹는 것 같다 (switch case 4-5개정되 되면 switch가 더 빠르다)
//charAt이 배열 만드는 것 보다 메모리를 적게 차지한다
//연산을 최소화 하는 것이 좋다
//if문 두개 중첩보다 if-else if 등으로 나누면 더 빠르다.

public class SWEA5432 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("data/sw/input5432.txt"));
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int ans, cnt_l;
		int T = Integer.parseInt(br.readLine());
		for(int t = 1 ; t <= T ; t++) {
			//값 초기화
			cnt_l = 0;
			ans = 0;
			
			//쇠막대기와 레이저의 배치
			char[] arr = br.readLine().toCharArray();
			
			for(int i = 0 ; i < arr.length ; i++) {	//또는 i = 1 부터 arr.length 까지 , arr[a-1]을 본다
				if(arr[i] == '(') {
					cnt_l++;
					if(arr[i+1] == ')') {	//arr[arr.length-1]은 여기 올일 없으니 처리 생략함
						cnt_l--;
						ans += cnt_l;
						i++;
					}
				}else {
					cnt_l--;
					ans++;
				}
			}
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}
}
