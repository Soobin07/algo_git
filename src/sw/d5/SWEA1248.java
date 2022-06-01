package sw.d5;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SWEA1248 {
	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream("data/input1248.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1 ; t <= T ; t++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			int idx1 = sc.nextInt();
			int idx2 = sc.nextInt();
			
			int[] parentIndexs = new int[V+1];
			
			//넣기
			for(int i = 0 ; i < E ; i++) {
				int parent = sc.nextInt();
				int child = sc.nextInt();
				
				parentIndexs[child] = parent;
			}
			
			//공통부모 찾기
			ArrayList<Integer> idx1Parents = getParents(idx1, parentIndexs);
			ArrayList<Integer> idx2Parents = getParents(idx2, parentIndexs);
			int minV = 0;
			int maxi = 0;
			int maxj = 0;
			for(int i = idx1Parents.size()-1 ; i >= 0 ; i--) {
				for(int j = idx2Parents.size()-1 ; j >= 0 ; j--) {
					if(idx1Parents.get(i).equals(idx2Parents.get(j))) {
						if(maxi + maxj <= i+j) {
							maxi = i;
							maxj = j;
							minV = idx1Parents.get(i);
						}
					}
				}
			}
			
			System.out.println("#"+t+" "+minV+" "+getCount(minV, parentIndexs));
		}
	}
	
	public static ArrayList<Integer> getParents(int index, int[] parentIndexs){
		ArrayList<Integer> list = new ArrayList<>();
		while(index > 1) {
			list.add(0,parentIndexs[index]);
			index = parentIndexs[index];
		}
		return list;
	}
	
	public static int getCount(int index, int[] parentIndexs) {
		int result = 1;
		for(int i = 1 ; i < parentIndexs.length ; i++) {
			if(parentIndexs[i] == index) {
				result+=getCount(i, parentIndexs);
			}
		}
		return result;
	}
}
