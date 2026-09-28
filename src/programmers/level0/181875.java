class Solution {
    public String[] solution(String[] strArr) {
        String[] answer = new String[strArr.length];
        for(int i = 1 ; i < strArr.length ; i+=2){
            answer[i] = strArr[i].toUpperCase();
        }
        for(int i = 0 ; i < strArr.length ; i+=2){
            answer[i] = strArr[i].toLowerCase();
        }
        return answer;
    }
}
