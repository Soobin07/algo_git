import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	//접시수
		int d = sc.nextInt();	//가짓수
		int k = sc.nextInt();	//연속으로 먹는 접시 수
		int c = sc.nextInt();	//쿠폰번호
		
		int[] dishes = new int[N];
		for(int i = 0 ; i < N ; i++) {
			dishes[i] = sc.nextInt();
		}//접시 확인
		
		int[] eatCnts = new int[d+1];
		eatCnts[c] = 1;	//쿠폰 가지고 시작하자
		int eats = 1;	//먹은 가짓수
		
		int first = 0;
		int last = k;
		for(int i = first ; i < last ; i++) {
			if(eatCnts[dishes[i]] == 0) {
				eats++;
			}
			eatCnts[dishes[i]]++;
		}//처음 k개
		
		int max = eats;
		
		while(eats <= d && eats <= k+1 && first < N) {
			//다음것 먹기
			if(eatCnts[dishes[last]] == 0) {
				eats++;	//안먹었던거면 먹은 가짓수 늘리기
			}
			eatCnts[dishes[last]]++;
			last = (last+1)%N;	//다음것으로 가기
			
			//가장 처음것 빼기
			eatCnts[dishes[first]]--;
			if(eatCnts[dishes[first]] == 0) {
				eats--;	//얘 안먹은게 되니 빼기
			}
			first++;
			max = Math.max(max, eats);
		}
		
		System.out.println(max);
	}
}
