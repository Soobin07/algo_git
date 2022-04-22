package beakjoon.bronze;


public class Q4673_2 {

	public static void main(String[] args) {
		
		boolean isNotSelfNum = false;
		label: for(int j = 1 ; j < 10000; j++) {
			isNotSelfNum = false;
			for(int i = 1 ; i < j ; i++) {
				if(selfNum(i) == j) {
					isNotSelfNum = true;
					continue label;
				}
			}
			if(!isNotSelfNum) System.out.println(j);
		}
	}
	
	
	//전체 + 10으로 나눈 나머지값 + 100으로 나눈 나머지값..
	static int selfNum(int num) {
		int sum = num;
		while(num != 0) {
			sum += (num % 10);
			num /=10;
		}
		return sum;
	}
}
