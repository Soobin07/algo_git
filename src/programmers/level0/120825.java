class Solution {
    public String solution(String my_string, int n) {
        StringBuffer sb = new StringBuffer();
        for(int k = 0 ; k < my_string.length() ; k++){
            char c = my_string.charAt(k);
            for(int i = 0 ; i < n ; i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
