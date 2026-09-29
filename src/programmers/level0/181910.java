class Solution {
    public String solution(String my_string, int n) {
        int l = my_string.length();
        String answer = my_string.substring(l - n);
        return answer;
    }
}
