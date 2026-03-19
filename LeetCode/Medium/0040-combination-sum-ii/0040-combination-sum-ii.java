class Solution {

    public static void myrec(List<List<Integer>> res, List<Integer> temp,
                            int idx, int[] arr, int target) {

        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        if (idx >= arr.length || target < 0) return;
        temp.add(arr[idx]);
        myrec(res, temp, idx + 1, arr, target - arr[idx]);
        temp.remove(temp.size() - 1);

        int next = idx + 1;
        while (next < arr.length && arr[next] == arr[idx]) next++;

        myrec(res, temp, next, arr, target);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        myrec(res, new ArrayList<>(), 0, candidates, target);
        return res;
    }
}