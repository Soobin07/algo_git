package beakjoon.bronze;

//시간초과
public class Q4673 {

	public static void main(String[] args) {
		//1. for돌려서 1~10000까지 selfNum 검증 num 제시
		//2. for돌려서 selfNum을 깰 가능성 있는(검증num보다 작은) 수 제시
		//3. 2의 num중 검증num이 selfNum이 아님을 증명하면 다음 검증, selfNum이면 print
		
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
		int result = num;
		int temp = num;
		int logNo = (int)Math.log10(num) +1;
		for(int i = 1 ; i <= logNo ; i++) {
			result += (temp % (int)(Math.pow(10, i)))/(int)(Math.pow(10, i-1));
		}
		return result;
	}
}
