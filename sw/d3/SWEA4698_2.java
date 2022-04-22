package sw.d3;

import java.io.FileInputStream;
import java.util.Scanner;

public class SWEA4698_2 {
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
		int[] prime = new int[1000000];	//소수 최대 갯수 몰라서
		int index = 0; //몇번째 소수인지
		for(int i = 0 ; i < isNotPrime.length ; i++) {
			if(!isNotPrime[i])prime[index++]=i;
		}
		
		int T = sc.nextInt();
		for(int t = 1 ; t <= T ; t++) {
			int D = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			int cnt = 0;
			for(int i = 0 ; i < index ; i++) {
				String tmp = Integer.toString(prime[i]);
				if(prime[i] >= A && prime[i] <= B && tmp.contains(""+D)) cnt++;
			}
			
			System.out.printf("#%d %d%n", t, cnt);
		}
	}
}