package jungol;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C1021 {
	static List<int[]>[] arr;	//부품 관계
	static int[] cnt;	//몇개 만들었나
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	//최종 부품 번호
		int M = sc.nextInt();	//부품 관계
		
		arr = new ArrayList[N+1];	//몇번째 부품을 완성하기 위해 몇번째 부품이 몇개 필요한가.. 관계
		for(int i = 1 ; i <= N ; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i = 0 ; i < M ; i++) {
			// X, Y, Z 라 할 때
			// X를 만들기 위한 부품으로 Y개 Z개 필요하다
			arr[sc.nextInt()].add(new int[] {sc.nextInt(), sc.nextInt()});
		}
		
		cnt = new int[N+1];	//갯수 세기 위한 배열 초기화
		
		//arr[부품].size() == 0인 것이 기본 부품
		make(N, 1);
		for(int i = 1 ; i < N+1 ; i++) {
			if(cnt[i] != 0) {
				System.out.println(i + " "+ cnt[i]);
			}
		}
	}
	//Y를 Z개 만든다
	public static void make(int Y, int Z) {
		if(arr[Y].size() == 0) {
			//기본부품일 경우
			cnt[Y] += Z;
			return;
		}
		
		//아닐 경우
		for(int i = 0 ; i < arr[Y].size() ; i++) {
			make(arr[Y].get(i)[0], arr[Y].get(i)[1] * Z);
		}
	}
}
