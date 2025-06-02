class Solution {
    public boolean lemonadeChange(int[] bills) {
        int cnt5 = 0;
        int cnt10 = 0;
        for(int i = 0; i < bills.length; i++){
            if(bills[i] == 5){
                cnt5++;
            }
            if(bills[i] == 10){
                cnt10++;
                if(cnt5 == 0){
                    return false;
                }
                cnt5--;
            }
            if(bills[i] == 20){
                if(cnt10 >= 1 && cnt5 >=1){
                    cnt10--;
                    cnt5--;
                    continue;
                }
                else if(cnt5 >=3){
                    cnt5-=3;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}