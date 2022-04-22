package beakjoon.gold;

import java.util.Scanner;

//https://hellodoor.tistory.com/112
//거리를 1~17까지로 하여 횟수, 최대거리를 적어본 후 규칙 발견 (max = 루트(거리) && max*2-1= count)
public class Q1011_2 {
	static String input1 = "3\n0 3\n1 5\n45 50";
	
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(input1);
		
		int tc = sc.nextInt();
		int x, y, dis, cnt, max;
		
		for(int t = 1 ; t <= tc ; t++) {
			
			x = sc.nextInt();
			y = sc.nextInt();
			dis = y-x;
			cnt = 0;
			max = (int)Math.sqrt(dis); //소수점 제거, 제곱근 구하기
			
			if(max==Math.sqrt(dis)) {
				cnt = max*2-1;
			}else if(dis <= max*max+max) {
				cnt = max*2;
			}else {
				cnt = max*2 +1;
			}
			System.out.println(cnt);
		}
	}
}
