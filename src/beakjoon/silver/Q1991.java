package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1991 {
	static char[][] nodes;
	static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		nodes = new char[N][3];	// 나, 왼, 오
		
		// 트리 입력
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			char self = st.nextToken().charAt(0);
			nodes[self-'A'][0] = self; 
			nodes[self-'A'][1] = st.nextToken().charAt(0);
			nodes[self-'A'][2] = st.nextToken().charAt(0);
		}
		
		pre(0);
		System.out.println(sb.toString());
		sb.setLength(0);
		
		mid(0);
		System.out.println(sb.toString());
		sb.setLength(0);
		
		post(0);
		System.out.println(sb.toString());
	}
	
	//전위순회
	static void pre(int index) {
		sb.append(nodes[index][0]);
		if(nodes[index][1] != '.') {
			pre(nodes[index][1]-'A');
		}
		if(nodes[index][2] != '.') {
			pre(nodes[index][2]-'A');
		}
	}
	//중위순회
	static void mid(int index) {
		if(nodes[index][1] != '.') {
			mid(nodes[index][1]-'A');
		}
		sb.append(nodes[index][0]);
		if(nodes[index][2] != '.') {
			mid(nodes[index][2]-'A');
		}
	}
	//후위순회
	static void post(int index) {
		if(nodes[index][1] != '.') {
			post(nodes[index][1]-'A');
		}
		if(nodes[index][2] != '.') {
			post(nodes[index][2]-'A');
		}
		sb.append(nodes[index][0]);
	}
}
