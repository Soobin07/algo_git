package beakjoon.silver;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q2108 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] cnt = new int[8002];
		int sum = 0;
		for(int i = 0 ; i < N ; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
			cnt[arr[i]+4000]++;
		}
		int[] sort = Arrays.copyOf(arr, N);
		Arrays.sort(sort);
		System.out.println(Math.round((double)sum/N));	//������
		System.out.println(sort[N/2]);	//�߾Ӱ�
		if(N > 1) {	//�ֺ�
			PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[1] > o2[1]) return -1;
					else if(o1[1] == o2[1]) {
						if(o1[0] > o2[0]) {
							return 1;
						}else {
							return -1;
						}
					}else return 1;
				}
			});
			
			for(int i = 0 ; i < 8002 ; i++) {
				if(cnt[i] != 0) {
					pq.add(new int[] {i-4000, cnt[i]});
				}
			}
			
			int[] first = pq.poll();
			int[] second = pq.poll();
			if(first[1] == second[1]) {
				System.out.println(second[0]);
			}else {
				System.out.println(first[0]);
			}
		}else {
			System.out.println(sort[0]);
		}
		System.out.println(sort[N-1]-sort[0]);	//����
		
	}
}
