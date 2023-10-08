class Tuple {
    int distance;
    int row;
    int col;

    Tuple(int distance, int row, int col) {
        this.distance = distance;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // Check if the start or end cell is blocked
        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) {
            return -1;
        }

        // Initialize distances array with maximum values
        int distances[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distances[i], Integer.MAX_VALUE);
        }
        
        distances[0][0] = 1; // Start distance is 1

        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(1, 0, 0)); // Add start tuple to the queue with distance 1

        int dr[] = {-1, -1, 0, 1, 1, 1, 0, -1};
        int dc[] = {0, 1, 1, 1, 0, -1, -1, -1};

        while (!queue.isEmpty()) {
            Tuple current = queue.poll();
            int distance = current.distance;
            int row = current.row;
            int col = current.col;

            // Iterate through 8 possible directions
            for (int i = 0; i < 8; i++) {
                int newRow = row + dr[i];
                int newCol = col + dc[i];

                // Check bounds and if cell is open and if new distance is smaller
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m
                        && grid[newRow][newCol] == 0 && distance + 1 < distances[newRow][newCol]) {

                    distances[newRow][newCol] = distance + 1; // Update distance
                    queue.add(new Tuple(distance + 1, newRow, newCol)); // Add to queue
                }
            }
        }

        // Check if end cell is reachable
        if (distances[n - 1][m - 1] == Integer.MAX_VALUE) {
            return -1;
        }
        return distances[n - 1][m - 1]; // Return shortest path to end cell
    }
}