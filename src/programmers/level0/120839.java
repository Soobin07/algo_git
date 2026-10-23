class Solution {
    public String solution(String rsp) {
        StringBuffer answer = new StringBuffer();
        int[] win = new int[6];
        win[0] = 5;
        win[5] = 2;
        
        for(char c : rsp.toCharArray()){
            answer.append(win[c-'0']);
        }
        
        return answer.toString();
    }
}
