package sw.d3;

import java.io.FileInputStream;
import java.util.Scanner;

public class SWEA6190 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("data/sw/input6190.txt"));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int T = sc.nextInt();
		for(int t = 1 ; t <= T ; t++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			int max = -1;	//단조 증가하는 수가 나오지 않으면 -1이 나와야 하니까 
			
			for(int i = 0 ; i < N ; i++) {//숫자 배열 입력 받음
				arr[i] = sc.nextInt();
			}
			
			for(int i = 0 ; i < N ; i++) {	//시작하는 수
				for(int j = i+1 ; j < N ; j++) {	//다음 수 ( i< j여야 하니까 i+1부터 시작)
					int val = arr[i]*arr[j];	//곱해준다
					int bef = 9;	//나올 수 있는 가장 큰 수(임시)
					
					while(val != 0) {	//0이면 다 나눈것
						int curr = val%10;	//제일 오른쪽 자리의 숫자
						if(curr > 0 && curr <= bef) {	//0이면 단조증가하는 수가 아니니까
							bef = curr;
							val /= 10;
							continue;
						}
						break;	//위에 안걸리면 단조증가하는수 아니다
					}
					
					if(val == 0) max = Math.max(max, arr[i]*arr[j]);	//단조증가하는 수는 다 나눠졌을거다
				}
			}
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		System.out.print(sb.toString());
	}
}
