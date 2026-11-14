import java.util.*;
class Solution {
    public String[] solution(String myString) {
        String[] tmp = myString.split("x");
        ArrayList<String> answer = new ArrayList<>();
        for(String str : tmp){
            if(str.equals("")){
                continue;
            }
            answer.add(str);
        }
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
}
