import java.util.*;

class Solution {
    public int minCost(int[][] grid) {
        int[][] directions = {
            {0, 1},  // Direction 1: Right
            {0, -1}, // Direction 2: Left
            {1, 0},  // Direction 3: Down
            {-1, 0}  // Direction 4: Up
        };

        int rows = grid.length;
        int cols = grid[0].length;

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        Map<String, Integer> minCost = new HashMap<>();

        queue.offer(new int[]{0, 0, 0}); // {row, col, cost}
        minCost.put("0,0", 0);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0], c = current[1], cost = current[2];

            // If the destination is reached, return the cost
            if (r == rows - 1 && c == cols - 1) {
                return cost;
            }

            // Explore all four directions
            for (int i = 0; i < directions.length; i++) {
                int dr = directions[i][0], dc = directions[i][1];
                int nr = r + dr, nc = c + dc;
                
                if (nr < 0 || nc < 0 || nr >= rows || nc >= cols) {
                    continue; // Out of bounds
                }

                int newCost = cost + (i + 1 == grid[r][c] ? 0 : 1);
                String key = nr + "," + nc;

                if (!minCost.containsKey(key) || newCost < minCost.get(key)) {
                    minCost.put(key, newCost);
                    if (i + 1 == grid[r][c]) {
                        queue.offer(new int[]{nr, nc, newCost});
                    } else {
                        queue.offer(new int[]{nr, nc, newCost});
                    }
                }
            }
        }

        return -1; // If no path is found (should not happen with valid input)
    }
}
