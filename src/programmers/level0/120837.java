class Solution {
    public int solution(int hp) {
        int answer = 0;
        int[] arr = {5,3,1};
        for(int i = 0 ; i < 3 ; i++){
            answer += (hp / arr[i]);
            hp %= arr[i];
        }
        return answer;
    }
}
