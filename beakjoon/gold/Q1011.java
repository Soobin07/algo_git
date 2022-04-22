package beakjoon.gold;

import java.util.Scanner;

//stack over flow! 왜인지는 모르겠음 
//(힌트를 보고 int값을 벗어나는 것 때문이라 생각해 long값으로 바꿔주었지만 효과X)
//(메모리때문일 수 있겠다. 다른 방법을 찾자)
public class Q1011 {
	static String input1 = "3\n0 3\n1 5\n45 50";
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(input1);
		
		int tc = sc.nextInt();
		int x, y, dst, max, cnt;
		for(int t = 0 ; t < tc ; t++) {
			x = sc.nextInt();
			y = sc.nextInt();
			
			dst = y-x;
			max = (int)Math.sqrt(dst);
			
			if(max*max == dst) {
				cnt = max*2-1;
			}else if(dst <= max*max+max) {
				cnt = max*2;
			}else{
//				 if(max*max-max > dst && max*max < dst) 
				cnt = max*2+1;
			}
			
			System.out.println(cnt);
		}
	}
	
	
	//처음 해서 실패한 재귀
//	static int[] delta = {-1, 0, 1};
//	static int min_count;
//	
//	public static void main(String[] args) {
////		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(input1);
//		
//		int tc = sc.nextInt();
//		int x, y;
//		
//		for(int t = 1 ; t <= tc ; t++) {
//			min_count = Integer.MAX_VALUE;
//			
//			x = sc.nextInt();
//			y = sc.nextInt();
//			
//			goToY(y-x-1, 1, 1);
//			
//			System.out.println(min_count);
//		}
//	}
//	
//	static void goToY(long rest_way, long trvl, int count) {
//		if(rest_way == 0 && trvl == 1 && count < min_count) {
//			min_count = count;
//		}else if(rest_way > 0) {
//			for(int i = 0 ; i < 3 ; i++) {
//				long dstnc = trvl + delta[i];
//				if(dstnc < 0) return;
//				if(rest_way-dstnc < 0) return;
//				goToY(rest_way-dstnc, dstnc, count+1);
//			}
//		}
//		return;
//	}
}
