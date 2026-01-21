import java.util.*;

class Solution {

    static final int N = 5 * 10000 + 1;
    static boolean[] sieve = new boolean[N];

    static {
        Arrays.fill(sieve, true);
        sieve[0] = sieve[1] = false;

        for (int i = 2; i * i < N; i++) {
            if (!sieve[i]) continue;
            for (int j = i * i; j < N; j += i) {
                sieve[j] = false;
            }
        }
    }

    public int primeSubarray(int[] nums, int k) {

        int n = nums.length;

        Deque<Integer> maxval = new ArrayDeque<>();
        Deque<Integer> minval = new ArrayDeque<>();
        List<Integer> plist = new ArrayList<>();

        int l = 0;
        int ans = 0;

        for (int r = 0; r < n; r++) {
            int x = nums[r];

            if (sieve[x]) {
                // add prime index
                plist.add(r);

                // max monotonic queue
                while (!maxval.isEmpty() && nums[maxval.peekLast()] < x) {
                    maxval.pollLast();
                }
                maxval.addLast(r);

                // min monotonic queue
                while (!minval.isEmpty() && nums[minval.peekLast()] > x) {
                    minval.pollLast();
                }
                minval.addLast(r);

                // shrink window
                while (plist.size() >= 2 &&
                       nums[maxval.peekFirst()] - nums[minval.peekFirst()] > k) {

                    if (sieve[nums[l]]) {
                        plist.remove(0);

                        if (maxval.peekFirst() == l) {
                            maxval.pollFirst();
                        }
                        if (minval.peekFirst() == l) {
                            minval.pollFirst();
                        }
                    }
                    l++;
                }
            }

            // update answer
            if (plist.size() >= 2 &&
                nums[maxval.peekFirst()] - nums[minval.peekFirst()] <= k) {

                int secondLastPrimeIndex = plist.get(plist.size() - 2);
                ans += (secondLastPrimeIndex - l + 1);
            }
        }

        return ans;
    }
}
