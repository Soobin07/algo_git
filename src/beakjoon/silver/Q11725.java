package algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Q11725 {
	static int[] parent;
	static List<Integer>[] list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		list = new ArrayList[N+1];
		for(int i = 0 ; i <= N ; i++) {
			list[i] = new ArrayList<>();
		}//null에러 안나게 처리
		
		for(int i = 0 ; i < N-1 ; i++) {
			int first = sc.nextInt();
			int second = sc.nextInt();
			
			list[first].add(second);
			list[second].add(first);
		}//노드 연결하기
		
		parent = new int[N+1];	//부모 소환
		
		//Queue를 이용하여 다음 숫자를 구함
		Queue<Integer> q = new LinkedList<>();
		q.add(1);	//루트
		parent[1] = 1;
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i = 0 ; i < list[now].size() ; i++) {
				int tmp = list[now].get(i);
				if(parent[tmp] == 0) {
					parent[tmp] = now;
					q.add(tmp);
				}
			}
		}
		
		for(int i = 2 ; i <= N ; i++) {
			System.out.println(parent[i]);
		}
	}
}
