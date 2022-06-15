package jungol;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class C1761 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] rec = new int[N][3];
		
		for(int i = 0 ; i < N ; i++) {
			rec[i][0] = sc.nextInt();
			rec[i][1] = sc.nextInt();	//스트라이크
			rec[i][2] = sc.nextInt();	//볼
		}
		
		int cnt = 0;
		outer : for(int i = 111 ; i < 999; i++) {
			String str = Integer.toString(i);	//영수 예상 숫자
			if(str.charAt(0) == str.charAt(1) || str.charAt(1) == str.charAt(2) || str.charAt(0) == str.charAt(2)) continue;	//숫자 겹치면 제외
			if(str.contains("0")) continue;
			for(int j = 0 ; j < N ; j++) {	//N개 한것 모두 비교
				String ori = Integer.toString(rec[j][0]);	//민혁이가 물어본 수
				int s = 0; //스트라이크
				int b = 0; //볼
				for(int k = 0 ; k < 3 ; k++) {	//각 자리수
					if(ori.contains(str.charAt(k)+"")) {	//해당 자리수 예상숫자가 있나
						b++;	//볼 추가
					}
					if(str.charAt(k) == ori.charAt(k)) {	//같은 위치에 같은 수가 있나
						s++;	//스트라이크 추가
						b--;	//볼 제거
					}
				}
				if(rec[j][1] == s && rec[j][2] == b) continue;
				continue outer;
			}
			cnt++;
		}
		
		System.out.println(cnt);
	}
}
