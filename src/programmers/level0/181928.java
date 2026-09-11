class Solution {
    public int solution(int[] num_list) {
        StringBuffer odd = new StringBuffer();
        StringBuffer even = new StringBuffer();
        
        for(int i : num_list){
            if(i % 2 == 0){
                even.append(i);
            }else{
                odd.append(i);
            }
        }
        
        return Integer.parseInt(even.toString()) + Integer.parseInt(odd.toString());
    }
}
