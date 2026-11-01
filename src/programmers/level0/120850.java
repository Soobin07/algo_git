import java.util.*;
class Solution {
    public int[] solution(String my_string) {
        my_string = my_string.replaceAll("[a-z]","");
        int[] answer = new int[my_string.length()];
        char[] array = my_string.toCharArray();
        for(int i = 0 ; i < answer.length ; i++){
            answer[i] = array[i] - '0';
        }
        Arrays.sort(answer);
        return answer;
    }
}
