class Solution {
    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        int n = costs.length;
        List<int[]> l = new ArrayList<>();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            l.add(new int[]{costs[i], capacity[i]});
            if (costs[i] < budget)
                ans = Math.max(ans, capacity[i]);
        }
        Collections.sort(l, (a, b) -> Integer.compare(a[0], b[0]));

        int i = 0, j = n - 1;
        while (i < j) {
            int sum = l.get(i)[0] + l.get(j)[0];
            if (sum < budget) {
                ans = Math.max(ans, l.get(i)[1] + l.get(j)[1]);
                i++;
            } else {
                j--;
            }
        }

        return ans;
    }
}
