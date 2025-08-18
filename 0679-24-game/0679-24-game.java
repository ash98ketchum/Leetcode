class Solution {
    final double ep = 1e-6;

    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>(4);
        for (int x : cards) nums.add((double) x);
        return myrec(nums);
    }

    private boolean myrec(List<Double> nums) {
        int n =  nums.size();
        if(n == 1) return Math.abs(nums.get(0) - 24.0) < ep;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                List<Double> next = new ArrayList<>(n-1);
                for (int k = 0; k < n; k++){
                    if (k != i && k != j){
                        next.add(nums.get(k));
                    }
                }
                // c, d, (a op b)
                double a = nums.get(i), b = nums.get(j);
                // 1) a + b
                if (i < j) {
                    next.add(a + b);
                    if (myrec(next)){
                        return true;
                    }
                    next.remove(next.size() - 1);
                    // 2) a * b
                    next.add(a * b);
                    if (myrec(next)){
                        return true;
                    }
                    next.remove(next.size() - 1);
                }

                // 3) a - b
                next.add(a - b);
                if (myrec(next)){
                    return true;
                }
                next.remove(next.size() - 1);

                // 4) b - a
                next.add(b - a);
                if (myrec(next)){
                    return true;
                }
                next.remove(next.size() - 1);

                // 5) a / b
                if (Math.abs(b) > ep) {
                    next.add(a / b);
                    if (myrec(next)){
                        return true;
                    }
                    next.remove(next.size() - 1);
                }

                // 6) b / a
                if (Math.abs(a) > ep) {
                    next.add(b / a);
                    if (myrec(next)){
                        return true;
                    }
                    next.remove(next.size() - 1);
                }
            }
        }
        return false;
    }
}
