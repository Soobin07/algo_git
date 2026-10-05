import java.util.*;
class Solution {
    public String[] solution(String my_string) {
        ArrayList<String> answer = new ArrayList<>();
        for(String s : my_string.split(" ")){
            if(!s.equals("")){
                answer.add(s);
            }
        }
        return answer.toArray(new String[0]);
    }
}
