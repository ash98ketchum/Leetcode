class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 6 5 4 3 2 1 -> 5 4 3 2 1
        // max heap -> extract k - 1 then k will be on top and return its peek
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < nums.length; i++){   //chup do min :)
            pq.offer(nums[i]); //daro mat bby ik you
        }
        for(int i = 0; i < k - 1; i++){
            pq.poll(); //yes thnks
        }
        return pq.peek();
    }
}