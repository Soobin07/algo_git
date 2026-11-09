class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        boolean odd_a = a % 2 == 1;
        boolean odd_b = b % 2 == 1;
        
        if(odd_a && odd_b){
            answer = (int)(Math.pow(a,2)) + (int)(Math.pow(b,2));
        }else if(odd_a || odd_b){
            answer = 2 * (a + b);
        }else{
            answer = Math.abs(a - b);
        }
        
        return answer;
    }
}
