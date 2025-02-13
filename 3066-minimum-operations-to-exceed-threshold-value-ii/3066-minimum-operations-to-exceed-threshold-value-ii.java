class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for (long num : nums) {
            minHeap.add(num);
        }

        int cnt = 0;
        while (minHeap.size() > 1) {
            long x=minHeap.poll();
            if(x>=k){
                return cnt;
            }
            else{
                long y=minHeap.poll();
                minHeap.add(Math.min(x,y)*2+Math.max(x,y));
                cnt++;
            }
        }

        return cnt;
    
    }
}