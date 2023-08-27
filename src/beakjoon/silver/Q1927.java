package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q1927 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			//작으면 앞으로 와라
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if(tmp == 0) {
				if(pq.size() == 0) {
					bw.append("0\n");
				}else {
					bw.append(pq.poll()+"\n");
				}
			}else {
				pq.add(tmp);
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
