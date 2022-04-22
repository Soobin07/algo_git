package beakjoon.bronze;

import java.util.Scanner;

public class Q2292_2 {
	// 방 번호
	// 1 : 1번줄 (1번 움직임)
	// 2 - 7 : 2번 줄(2번 움직임) (1+6)
	// 8 - 19 : 3번 줄 (7 + 12)
	// ... 각줄의 마지막 수는 이전 줄의 마지막 수 + 6*(줄 수 -1)
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	//도착해야 할 방 번호
		int n = 1;				//현재 방 번호
		int cnt = 0; 			//몇번 움직였나
		while(true) {
			cnt++;
			n += (cnt-1)*6;
			if(N <= n) break;	//해당 번호를 포함하게 되면 멈춘다
		}
		System.out.println(cnt);
	}
}
