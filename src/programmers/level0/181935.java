class Solution {
    public int solution(int n) {
        int answer = 0;
        int point = (n + 1) % 2 + 1;
        for(int i = point ; i <= n ; i+= 2){
            answer += (int) Math.pow(i, point);
        }
        return answer;
    }
}
