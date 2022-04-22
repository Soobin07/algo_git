package programmers.kakao;

//1, 11 런타임에러, 12,14,15,16 실패
public class KakaoBlindRecruitment2022_2 {
	public static void main(String[] args) {
		int n = 437674;
		int k = 3;
//		int n = 110011;
//		int k = 10;
		System.out.println(solution(n,k));
		
		//양의 정수 n을 k진수로 바꿨을 때
		//1. 조건에 맞는 값 확인 (0P0, P0, 0P, P)
		//2. 소수인지 확인
	}
	static public int solution(int n, int k) {
        int answer = 0;
        StringBuffer sb = new StringBuffer();

        //k진수로 변환
    	while(n/k > 0) {
    		sb.insert(0, n%k);
    		n /= k;
    	}
    	sb.insert(0, n%k);
    	
    	//조건에 맞는 값 확인
    	String[] strs = sb.toString().split("0");
    	for(int i = 0 ; i < strs.length ; i++) {
    		if(!strs[i].equals("1") && !strs[i].equals("")) {
    			long tmp = Long.parseLong(strs[i]);
    			//소수 확인 ==> 아래 방법은 11111111111 등.. 매우 큰 수가 나올 경우 오래걸림
    			/*
					for(int j = 2 ; j < tmp ; j++) {
						if(tmp % j == 0) break;
					}
    			*/
    			if(isprime(tmp)) answer++;
    		}
    	}
        return answer;
    }
	static boolean isprime(long n){
        if(n <= 1) return false;
        for(long i = 2; i*i <= n; i++)
            if(n % i == 0) return false;
        return true;
    }
}
