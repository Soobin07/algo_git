package beakjoon.gold;

import java.util.Scanner;

public class Q9663 {	//NQueen
	
	static int ans, N;
	static int[] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N];
		setQueen(0);
		System.out.println(ans);
	}
	static void setQueen(int row) {
		if(row >= N) {
			ans++;
			return;
		}
		outer : for(int i = 0 ; i < N ; i++) {	//Queen 놓을 column 정하기
			for(int j = 0 ; j < row ; j++) {	//이전 row중 같은 column에 있는 퀸 있는지 찾기
				if(map[j] == i) continue outer;
				if(Math.abs(row-j) == Math.abs(i-map[j])) continue outer;
			}
			map[row] = i;
			setQueen(row+1);
		}
	}
}
