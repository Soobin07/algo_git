class Solution {
    public String solution(String my_string) {
        StringBuffer answer = new StringBuffer();
        for(char c : my_string.toCharArray()){
            if(c >= 'A' && c <= 'Z'){
                answer.append((char)(c - 'A' + 'a'));
            }else{
                answer.append((char)(c - 'a' + 'A'));
            }
        }
        return answer.toString();
    }
}
