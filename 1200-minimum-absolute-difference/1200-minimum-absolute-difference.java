class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> l = new ArrayList<>();
        int minn = (int)1e9;
        for(int i = 1; i < arr.length; i++){
            minn = Math.min(minn, arr[i] - arr[i - 1]);
        }
        for(int i = 1; i < arr.length; i++){
            int diff = arr[i] - arr[i - 1];
            if(minn == diff){
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i - 1]);
                temp.add(arr[i]);
                l.add(temp);
            }
        }
        return l;
    }
}