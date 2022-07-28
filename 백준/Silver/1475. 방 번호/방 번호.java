import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String N = sc.nextLine();	//방번호
		int[] cnt = new int[9];	//0-8까지
		
		int set = 1;
		for(int i = 0 ; i < N.length() ; i++) {
			char ch = N.charAt(i);	//숫자 찾기
			if(ch == '6' || ch == '9') {	//6, 9 중 하나 나오면
				cnt[6]++;	// 6 을 올린다
				if(cnt[6] > set*2) {	//set개 넘으면
					set++;	//세트 올린다
				}
			}else {
				cnt[ch-'0']++;
				if(cnt[ch-'0'] > set) {
					set++;
				}
			}
		}
		System.out.println(set);
	}
}
