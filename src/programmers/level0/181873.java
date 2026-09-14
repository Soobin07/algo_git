class Solution {
    public String solution(String my_string, String alp) {
        StringBuffer answer = new StringBuffer();
        for(char c : my_string.toCharArray()){
            if(c == alp.charAt(0)){
                c = (char)(c - 'a' + 'A');
            }
            answer.append(c);
        }
        return answer.toString();
    }
}
