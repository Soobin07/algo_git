package beakjoon.bronze;

import java.util.Scanner;

public class Q15649_2 {
	//StringBuffer은 이상하게 다른 함수에서도 같은 값을 가지고 그냥 쓸 수 있었다.
	//아마 주소값을 넘겨서, append 하면 그 주소값에 직접 넣는 것 같았다.
	
	static Scanner sc = new Scanner(System.in);
	static StringBuffer sb = new StringBuffer(); 
	static boolean[] visit;
	static int[] arr;
	
	public static void main(String[] args) {

		//n과 m을 받고, 숫자가 들어갔는지 확인할 visit과, 출력해야 할 m개의 int를 담을 arr을 만든다.
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		visit = new boolean[n];
		arr = new int[m];
		
		//n과 m, 시작 숫자 0 (m이 1이면 한번은 돌아야 하니 시작숫자는 0이다)를 담는다
		function(n,m,0);
		
		//나오면 프린트
		System.out.println(sb.toString());
	}
	
	static void function(int n, int m, int count) {
		if(count == m) { //m과 몇번 돌았는지가 일치하면 출력해야 한다.
			for(int val : arr) {
				sb.append(val).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		//숫자를 m만큼 얻지 못했을 때 
		for(int i = 0 ; i < n; i++) { //n번 반복 돌린다

			//숫자 (i+1)에 이미 접근했으면 배열에 넣지 않고 빠진다
			if(visit[i] == false) { //아직 들어간 적 없는 숫자일 경우 
				visit[i] = true; //들어갔다는 표시를 한다
				arr[count] = i+1; //몇번째 숫자인지 표시하는 count에 숫자(i+1) 를 넣는다
				function(n,m,count+1); //아직 다음 숫자가 있어야 하니, 카운트를 하나 더 올려서 다시 돌린다.
				
				visit[i] = false; //다음 숫자들이 다 나온 후에는 들어간 표시 해제 (다음 숫자에서 다시 그 배열 사용하니까)
			}
		}
		return;
	}
	
}
