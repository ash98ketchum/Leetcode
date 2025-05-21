class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        // int sum = 0;
        // for(int i=n-1; i >= 0 && k > 0; i--, k--){
        //     sum += cardPoints[i];
        // }
        // return sum;
        // 1 2 3 4  5 6  1 1 2 3 

        int arr[] = new int[2 * k];
        int j = 0;
        for(int i = n - k; i < n; i++){
            arr[j] = cardPoints[i];
            j++;
        }
        for(int i = 0 ; i < k; i++){
            arr[j] = cardPoints[i];
            j++;
        }
// --------------------------------------------------------------------//
        int ans = 0, sum = 0;
        for(int i = 0; i < k; i++){
            // operation performed
            sum += arr[i];
        }
        // ans update
        ans = Math.max(ans, sum);
        for(int i = k; i < arr.length; i++){
            // grow
            sum += arr[i];

            // shrink
            sum -= arr[i-k];
            // ans update
            ans = Math.max(ans, sum);
        }
        for(int it: arr){
            System.out.println(it + " ");
        }
        return ans;
    }
}