class Solution {
    public int solution(int price) {
        int answer = price;
        double mult = 1;
        if(price >= 50_0000){
            mult = 0.8;
        }else if(price >= 30_0000){
            mult = 0.9;
        }else if(price >= 10_0000){
            mult = 0.95;
        }
        return (int)(answer * mult);
    }
}
