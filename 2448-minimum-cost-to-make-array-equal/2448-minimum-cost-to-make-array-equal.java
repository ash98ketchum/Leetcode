import java.util.*;

class Pair {
    int val;
    int cost;
    Pair(int val, int cost) {
        this.val = val;
        this.cost = cost;
    }
}

class Solution {
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        Pair[] arr = new Pair[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], cost[i]);
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a.val, b.val));
        long tot = 0;
        for (int i = 0; i < n; i++) {
            tot += arr[i].cost;
        }

        long med = (tot + 1) / 2; 
        long curr = 0;
        int pot = -1;

        for (int i = 0; i < n; i++) {
            curr += arr[i].cost;
            if (curr >= med) {
                pot = arr[i].val;
                break;
            }
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (long) Math.abs(pot - arr[i].val) * arr[i].cost;
        }

        return ans;
    }
}
