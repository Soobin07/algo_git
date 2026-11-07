class Solution {
    public String solution(String n_str) {
        StringBuffer answer = new StringBuffer();
        boolean add = false;
        for(int i = 0 ; i < n_str.length() ; i++){
            if(n_str.charAt(i) == '0' && !add){
                continue;
            }
            add = true;
            answer.append(n_str.charAt(i));
        }
        return answer.toString();
    }
}
