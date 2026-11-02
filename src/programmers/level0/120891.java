class Solution {
    public int solution(int order) {
        int answer = 0;
        while(order > 0){
            int x = order % 10;
            if(x == 3 || x == 6 || x == 9){
                answer++;
            }
            order /= 10;
        }
        return answer;
    }
}
