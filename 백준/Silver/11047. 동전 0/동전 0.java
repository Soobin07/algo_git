import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	//동전 갯수
		int K = sc.nextInt();	//금액
		
		int[] cos = new int[N];	//동전 종류 모아놓음
		for(int i = 0 ; i < N ; i++) {
			cos[i] = sc.nextInt();
		}//입력 완료
		
		int res = K;	//남은 돈
		int cnt = 0;	//동전 갯수
		//뒤에서부터
		for(int i = N-1 ; i >= 0 ; i--) {
			if(res < cos[i]) continue;	//동전 금액이 남은 돈보다 클 때는 pass
			//동전 금액으로 남은 돈의 일부를 바꿀 수 있을 때
			cnt += res/cos[i];
			res %= cos[i];
			if(res == 0) break;
		}
		System.out.println(cnt);
	}
}
