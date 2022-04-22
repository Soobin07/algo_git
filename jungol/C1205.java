package jungol;

import java.util.Arrays;
import java.util.Scanner;

public class C1205 {
	static String input1 = "7 \r\n" + 
			"0 6 5 10 3 0 11";	//5
	static String input2 = "6\r\n" + 
			"100 100 100 99 97 103";	//2
	static String input3 = "8\r\n" + 
			"0 0 0 1 2 6 8 1000";	//6
	static String input4 = "5\r\n" + 
			"0 1 0 2 0";	//5
	static String input5 = "21\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0";	//21
	static String input6 = "50\r\n" + 
			"850675 850700 850696 850716 850674 850681 850676 850715 850689 850720 850688 850721 850677 850683 850707 850686 850693 850697 850692 850680 0 850695 850699 850703 850682 0 850719 0 850687 850717 0 850698 850714 850709 850710 850672 850711 850702 850678 850673 850705 850708 850685 850690 850712 850691 850718 850704 850713 850679";
			//50
	static String input7 = "48\r\n" + 
			"0 1 1000 2000 3000 4000 5000 6000 7000 8000 9000 10000 11000 12000 13000 14000 15000 16000 17000 18000 19000 20000 21000 22000 23000 24000 25000 26000 27000 28000 29000 30000 21000 22000 23000 24000 25000 26000 27000 28000 29000 30000 20000 300000 999997 999998 999999 1000000";
			//5
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(input1);
		
		int N = sc.nextInt();
		int max = 0; //최대로 이어지는 스트레이트 수
		
		int jo = 0;	//조커 갯수
		int[] arr = new int[N];	//카드 담는 배열
		for(int i = 0 ; i < N ; i++) {	//카드 담는다
			arr[i] = sc.nextInt();
			if(arr[i] == 0) jo++;	//조커 카드 숫자 센다
		}
		Arrays.sort(arr);	//오름차순으로 정렬
		
		if(jo == N) max = N;
		for(int i = jo ; i < N ; i++) {	//현재 숫자부터 스트레이트 되는 수까지
			int used = 0;	//현재까지 사용된 조커 갯수
			int tmp = 0;	//현재 인덱스까지 이어진 스트레이트 수
			for(int j = i ; j < N-1 ; j++) {
				int gap = arr[j+1]-arr[j];	//다음수와의 차이
				
				//tmp 끊어지는 조건
				if(gap-1 > jo-used) {
					//현재까지 스트레이트+남은 조커가 최대
					tmp += jo-used;
					used = jo;
					break;
				}
				//다음 수와 이번 수가 같으면, 이번엔 pass
				if(gap == 0) {
					continue;
				}
				//2개가 이어지면 2스트레이트
				if(tmp == 0) tmp++;
				used += gap-1;
				tmp += gap;
			}
			//남은 조커 사용
			if(jo-used != 0) {
				tmp += jo-used;
			}
			max = Math.max(max, tmp);
		}
		
		System.out.println(max);
	}
}