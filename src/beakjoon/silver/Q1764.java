package beakjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Q1764 { //(�躸��)
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	//�赵 ���� ��� ��
		int M = Integer.parseInt(st.nextToken());	//���� ���� ��� ��
		
		Set<String> set = new HashSet<>();
		for(int i = 0 ; i < N ; i++) {
			set.add(br.readLine());
		}//�赵 ���� ��� �ֱ�
		
		List<String> ans = new ArrayList<>();
		for(int i = 0 ; i < M ; i++) {
			String name = br.readLine();
			if(set.contains(name)) {
				ans.add(name);
			}
		}//���� ���� ��� �ֱ�
		
		StringBuffer sb = new StringBuffer();
		Collections.sort(ans);
		sb.append(ans.size()).append("\n");
		for(int i = 0 ; i < ans.size() ; i++) {
			sb.append(ans.get(i)).append("\n");
		}
		System.out.println(sb.toString());
	}

}
