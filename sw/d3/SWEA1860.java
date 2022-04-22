package sw.d3;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

//448개 맞음
public class SWEA1860 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("data/sw/input1860.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		test : for(int t = 1 ; t <= T ; t++) {
			int N = sc.nextInt(); //사람수
			int M = sc.nextInt(); //붕어빵을 k개 만드는데 걸리는 시간
			int K = sc.nextInt(); //한 단위시간 당 만드는 붕어빵의 갯수
			int[] person = new int[N];
			
			//예약 받기
			for(int i = 0 ; i < N ; i++) {
				person[i] = sc.nextInt();
			}
			//시간순서대로
			Arrays.sort(person);

			//시간이 흐른다
			int count = 0;	//남은 붕어빵 갯수
			int idx = 0;	//(몇-1)번째 손님
			for(int i = 0 ; i <= 11111 ; i++) {
				if(i%M == 0 && i != 0) count+= K;
				if(idx == N) {
					System.out.println("#"+t+" "+"Possible");
					continue test;
				}
				if(person[idx] == i) {
					if(count > 0) {
						while(idx < N && person[idx] == i) {
							count--;
							idx++;
						}
						if(count < 0) {
							System.out.println("#"+t+" "+"Impossible");
							continue test;
						}
					}else {
						System.out.println("#"+t+" "+"Impossible");
						continue test;
					}
				}
			}
		}
	}
}
