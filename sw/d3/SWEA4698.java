package sw.d3;

import java.io.FileInputStream;
import java.util.Scanner;

public class SWEA4698 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("data/sw/input4698.txt"));
		Scanner sc = new Scanner(System.in);
		
		boolean[] isNotPrime = new boolean[1000001];
		isNotPrime[0] = isNotPrime[1] = true;	
		for(int i = 2 ; i*i < 1000001 ; i++) {	//1000000 안의 소수가 될 수 있는 수 찾기
			if(!isNotPrime[i]) {	//이전까지 나온 소수의 곱이 아닌 경우
				for(int j = i*i ; j < 1000001 ; j+=i) {	//소수의 배수 찾아 지우기 (i*2가 아닌 이유 = i*2는 2의 배수 할 때 다 없어졌음. i 이전의 소수*i는 이미 사라져있음)
					isNotPrime[j] = true;
				}
			}
		}
		
		int T = sc.nextInt();
		for(int t = 1 ; t <= T ; t++) {
			int D = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			int cnt = 0;
			for(int i = A ; i <= B ; i++) {
				String tmp = Integer.toString(i);
				if(!isNotPrime[i] && tmp.contains(D+"")) {	//prime 수 < D를 포함하고 있는 수. 그러니 적은 수로 먼저 걸러낸 후 D를 보는게 더 편하다.
					cnt++;
				}
			}
			
			System.out.printf("#%d %d%n", t, cnt);
		}
	}
}