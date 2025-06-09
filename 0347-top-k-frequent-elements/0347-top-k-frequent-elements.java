class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int it : nums){
            map.put(it, map.getOrDefault(it,0) + 1);
        }
        PriorityQueue<Integer> iloveyou = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            iloveyou.offer(entry.getKey());
            if(iloveyou.size() > k){
                iloveyou.poll();
            }
        }
            int []res = new int[k];
            int i = 0;
            while(!iloveyou.isEmpty()){
                res[i] = iloveyou.poll();
                i++;
            }
            
    
        return res;
        
    }
}