class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;
        boolean[][] knowLanguages = new boolean[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int l : languages[i]) {
                knowLanguages[i + 1][l] = true;
            }
        }
        Set<Integer> peopleCouldNotCommunicate = new HashSet<>();
        for (int[] friend : friendships) {
            int u = friend[0];
            int v = friend[1];
            if (!canCoummunicate(knowLanguages, u, v, n)) {
                peopleCouldNotCommunicate.add(u);
                peopleCouldNotCommunicate.add(v);
            }
        }
        if (peopleCouldNotCommunicate.isEmpty()) {
            return 0;
        }
        int maxKnown = 0;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j : peopleCouldNotCommunicate) {
                if (knowLanguages[j][i]) {
                    count++;
                }
            }
            maxKnown = Math.max(maxKnown, count);
        }
        return peopleCouldNotCommunicate.size() - maxKnown;
    }

    private boolean canCoummunicate(boolean[][] knowLanguages, int u, int v, int n) {
        for (int i = 1; i <= n; i++) {
            if (knowLanguages[u][i] && knowLanguages[v][i]) {
                return true;
            }
        }
        return false;
    }
}