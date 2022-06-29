package jungol;

import java.util.Scanner;

public class C3427 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	//공 몇개
		String ori = sc.next();	//공 배열(원본)

		//1. 제일 오른쪽 덩어리 색을 옮기자 (X) - 45점
		//2. 둘 다 해보자 (X) - 65점
		//3. 선택한 색을 왼쪽으로도 모아보자
		
		//B 움직일 때
		char strdColor = 'B';
		int cnt = Math.min(count(strdColor, ori, false), count(strdColor, ori, true));
		//R 움직일 때
		strdColor = 'R';
		cnt = Math.min(cnt, Math.min(count(strdColor, ori, false), count(strdColor, ori, true)));
		
		System.out.println(cnt);
		
	}
	public static int count(char strdColor, String ori, boolean goFront) {
		int cnt = 0;	//옮겨야 하는 숫자
		if(!goFront) {	//정상적으로 뒤로 갈 때
			//덩어리로 분리한다
			int lastIdx = ori.length()-1;	//마지막으로 봐야 하는 idx
			if(ori.charAt(ori.length()-1) == strdColor) {	//마지막 덩어리가 strdColor일 때
				//뒤에서부터 마지막 strdColor를 찾는다
				for(int i = ori.length() - 1 ; i >= 0 ; i--) {	
					char c = ori.charAt(i);
					if(c != strdColor) {
						lastIdx = i;
						break;
					}
				}
			}
			//제일 오른쪽 덩어리 제외하고 다른곳의 해당 색의 갯수를 세어준다
			if(lastIdx != 0) {	//전체가 같은 덩어리가 아닌 경우만
				for(int i = 0 ; i <= lastIdx ; i++) {
					char c = ori.charAt(i);
					if(c == strdColor) cnt++;
				}
			}
		}else {	//앞으로 모두 옮길 때
			//덩어리로 분리한다
			int lastIdx = 0;	//마지막으로 봐야 하는 idx
			if(ori.charAt(0) == strdColor) {	//마지막 덩어리가 strdColor일 때
				//앞에서부터 마지막 strdColor를 찾는다
				for(int i = 0 ; i < ori.length() ; i++) {	
					char c = ori.charAt(i);
					if(c != strdColor) {
						lastIdx = i;
						break;
					}
				}
			}
			//제일 왼쪽 덩어리 제외하고 다른곳의 해당 색의 갯수를 세어준다
			if(lastIdx != ori.length() - 1) {	//전체가 같은 덩어리가 아닌 경우만
				for(int i = ori.length() -1 ; i >= lastIdx ; i--) {
					char c = ori.charAt(i);
					if(c == strdColor) cnt++;
				}
			}
		}
		
		return cnt;
	}
}
