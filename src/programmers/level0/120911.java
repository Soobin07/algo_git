import java.util.*;
class Solution {
    public String solution(String my_string) {
        String answer = "";
        char[] chs = my_string.toLowerCase().toCharArray();
        Arrays.sort(chs);
        return answer.valueOf(chs);
    }
}
