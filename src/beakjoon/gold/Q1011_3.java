package beakjoon.gold;

import java.util.Scanner;

//https://heo-dev-0229.tistory.com/8?category=931659
//양 끝에서 동시 출발, 서로 만나거나 겹칠때까지 동작
//그때까지 양쪽에서 각각 이동한 횟수를 더한다
public class Q1011_3 {
	static String input1 = "3\n0 3\n1 5\n45 50";
	
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(input1);
		
		int tc = sc.nextInt();
		int x, y, start, end, start_cnt, end_cnt, dist;
		
		for(int t = 1 ; t <= tc ; t++) {
			
			x = sc.nextInt();
			y = sc.nextInt();
			start = 0;	//end가 x와 y사이의 거리니까 start는 0
			end = y-x;
			start_cnt = 0;
			end_cnt = 0;
			
			dist=1; //첫 이동거리
			while(start<end) {
				//시작점과 끝점에서부터 이동하는 동작
				start += dist;
				start_cnt +=1;
				//시작점에서 이동한 것이 끝점을 이동한 것과 만나거나 넘어갈 때 까지 동작 시행
				
				if(start >= end) break; //거리차 1인 경우 바로 끝내기 위해
				
				end -= dist;
				end_cnt += 1;
				
				if(start >= end) break;
				
				dist++;
			}
			System.out.println(start_cnt+end_cnt);
		}
	}
}
