import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//외않되
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int G = sc.nextInt();
		
		int N = 1;
		int B = 1;
		
		List<Integer> list = new ArrayList<>();
		while(true) {
			int gap = (int)(Math.pow(N, 2)-Math.pow(B, 2)); 
			if(gap > G && N - B == 1) break;
			if(gap > G) B++;
			else if(gap < G) N++;
			else if(gap == G) {
				list.add(N);
				N++;
			}
		}
		
		if(list.size() == 0) System.out.println(-1);
		else {
			
			for(int i = 0 ;i < list.size() ; i++) {
				System.out.println(list.get(i));
			}
		}
	}
}
