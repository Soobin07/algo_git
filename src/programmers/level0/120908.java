class Solution {
    public int solution(String str1, String str2) {
        int answer = 1;
        if(!str1.contains(str2)){
            answer+=1;
        }
        return answer;
    }
}
