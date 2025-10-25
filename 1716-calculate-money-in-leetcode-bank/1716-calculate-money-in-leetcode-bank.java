class Solution {
    public int totalMoney(int n) {
        int div = n / 7;
        int rem = n % 7;

        int sum = (div * (2 * 28 + (div - 1) * 7))/2;

        for(int i = 0; i < rem; i++){
            div++;
            sum += div;
        }
        return sum;
    }
}