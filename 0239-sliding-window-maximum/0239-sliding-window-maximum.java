class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>(); // stores indices
        ArrayList<Integer> res = new ArrayList<>();
        
        // for(0 -> k): build first window
        for (int i = 0; i < k; i++) {
            // perform operation: maintain decreasing order
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }
        // ans update: add max of first window
        res.add(nums[dq.peekFirst()]);
        
        // for(k -> n): slide the window
        for (int i = k; i < n; i++) {
            // grow window: insert new element index
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.removeLast();
            }
            dq.addLast(i);

            // shrink window: remove index out of range
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.removeFirst();
            }

            // ans update: add current max
            res.add(nums[dq.peekFirst()]);
        }
        
        // convert ArrayList to int[]
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
