package sw.d4;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA1232 {// D4
	static class Node {
		boolean isOperator;
		String data;
		int left = 0;
		int right = 0;
	}

	static Node[] arr;
	static String operator = "+-/*";
	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream("data/input1232.txt"));
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;

		int T = 10;
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(sc.nextLine());

			//배열 생성
			arr = new Node[N+1];
			//받아주기
			for(int i = 1 ; i <= N ; i++) {
				st = new StringTokenizer(sc.nextLine());
				
				Node tmp = new Node();
				int index = Integer.parseInt(st.nextToken());
				tmp.data = st.nextToken();
				if(operator.contains(tmp.data)) {
					tmp.isOperator = true;
					if(st.hasMoreTokens()) {
						tmp.left = Integer.parseInt(st.nextToken());
					}
					if(st.hasMoreTokens()) {
						tmp.right = Integer.parseInt(st.nextToken());
					}
				}
				
				arr[index] = tmp;
			}
			
			int ans = (int)func(1);
			System.out.println("#"+t+" "+ans);
		}
	}
	
	static double func(int index) {
		double result = 0d;
		if(arr[index].isOperator) {
			double val1 = func(arr[index].left);
			double val2 = func(arr[index].right);
			
			switch(arr[index].data) {
				case "+" : result = val1 + val2; break;
				case "-" : result = val1 - val2; break;
				case "/" : result = val1 / val2; break;
				case "*" : result = val1 * val2; break;
			}
		}else {
			result = Double.parseDouble(arr[index].data);
		}
		
		return result;
	}
}
