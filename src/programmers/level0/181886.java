class Solution {
    public String[] solution(String[] names) {
        int len = names.length / 5 + (names.length % 5 == 0 ? 0 : 1);
        String[] answer = new String[len];
        for(int i = 0 ; i * 5 < names.length ; i++){
            answer[i] = names[i * 5];
        }
        return answer;
    }
}
