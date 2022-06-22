package jungol;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class C1311 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] arr = new char[5][2];	//색, 숫자
		
		int result = 0;
		HashMap<Character,Integer> colors = new HashMap<>();	//색 갯수
		HashMap<Integer,Integer> numbs = new HashMap<>();	//숫자 갯수
		
		for(int i = 0 ; i < 5 ; i++) {
			arr[i][0] = sc.next().charAt(0);
			arr[i][1] = sc.next().charAt(0);
			
			if(colors.containsKey(arr[i][0])) {	//색 갯수 세기
				colors.put(arr[i][0], colors.get(arr[i][0])+1);
			}else {
				colors.put(arr[i][0], 1);
			}
			
			if(numbs.containsKey(arr[i][1]-'0')) {	// 숫자 갯수 세기
				numbs.put(arr[i][1]-'0', numbs.get(arr[i][1]-'0')+1);
			}else {
				numbs.put(arr[i][1]-'0', 1);
			}
		}
		
		//숫자 순서대로 정렬
		Arrays.sort(arr, new Comparator<char[]>() {
			@Override
			public int compare(char[] o1, char[] o2) {
				return o1[1]-o2[1];
			}
		});

		//모두 같은 색
		if(colors.containsValue(5)) {
			//1. 카드 5장 같은 색, 숫자 연속
			boolean continues = isContinueNum(arr);
			if(continues) {	//연속임
				result = Math.max(result, 900 + arr[4][1]-'0');
			}else {
				//4. 5장 같은 색
				result = Math.max(result, 600 + arr[4][1]-'0');
			}
		}
		
		int cnt = 0;
		int idx = -1;
		for(int i = 1 ; i <= 9 ; i++) {
			if(numbs.containsKey(i)) {
				int tmp = numbs.get(i);
				if(tmp == 4) {
					//2. 4장 숫자 같은 경우
					result = Math.max(result, 800 + i);
				}else if(tmp == 3) {
					if(cnt == 2) {	//2,3찾음
						//3. 3, 2장 숫자 같은 경우
						result = Math.max(result, 10 * i + idx + 700);
						cnt = 0;
					}else {	//아직 1개째
						cnt = tmp;
						idx = i;
					}
				}else if(tmp == 2) {
					if(cnt == 3) {	//2,3찾음
						//3. 3, 2장 숫자 같은 경우
						result = Math.max(result, 10 * idx + i + 700);
						cnt = 0;
					}else if(cnt == 2){
						// 7. 2장이 같고 2장이 같을 때
						result = Math.max(result, i * 10 + idx + 300);
						cnt = 0;
					}else{	//아직 1개째
						cnt = tmp;
						idx = i;
					}
				}
			}
		}
		
		// 5. 5장의 숫자가 연속적일때
		boolean continues2 = isContinueNum(arr);
		if(continues2) {
			result = Math.max(result, arr[4][1]-'0' + 500);
		}
		
		// 6. 3장의 숫자가 같을 때
		if(cnt == 3) {
			result = Math.max(result, idx + 400);
		}
		
		// 8. 2장의 숫자가 같을 때
		if(cnt == 2) {
			result = Math.max(result, idx + 200);
		}
		
		//9. 아무것도 아닐 때
		if(result == 0) {
			result = arr[4][1] - '0' + 100;
		}
		
		System.out.println(result);
	}
	
	//연속 숫자 확인
	public static boolean isContinueNum(char[][] arr) {
		boolean continues = true;
		for(int i = 1 ; i < 5 ; i++) {
			if(arr[i][1] == arr[i-1][1]+1) {
				continue;
			}else {
				continues = false;
				break;
			}
		}
		return continues;
	}
}
