class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int i = 0;
        int j = 0;
        int cnt = 0;
        while(i < buses.length){
            cnt = 0;
            while (j < passengers.length && cnt < capacity && passengers[j] <= buses[i]) {
                j++;
                cnt++;
            }
            i++;
        }
        int ans;
        if (cnt < capacity) {
            ans = buses[buses.length - 1];
        } 
        else{
            ans = passengers[j - 1];
        }
        j--; 
        while (j >= 0 && passengers[j] == ans) {
            ans--;
            j--;
        }

        return ans;
    }
}