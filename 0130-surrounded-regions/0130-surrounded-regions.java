class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        
        int[] delRows = {-1, 0, 1, 0}; // Array to represent changes in row index to traverse in all four directions
        int[] delCols = {0, 1, 0, -1}; // Array to represent changes in column index to traverse in all four directions

        int[][] visited = new int[rows][cols]; // Matrix to keep track of visited cells

        // Process first row and last row
        for (int i = 0; i < cols; i++) {
            // Process first row
            if (board[0][i] == 'O' && visited[0][i] == 0) {
                dfs(0, i, board, visited, delRows, delCols); // Call the dfs method to explore the connected region of 'O's
            }
            // Process last row
            if (board[rows - 1][i] == 'O' && visited[rows - 1][i] == 0) {
                dfs(rows - 1, i, board, visited, delRows, delCols); // Call the dfs method to explore the connected region of 'O's
            }
        }

        // Process first and last column
        for (int i = 0; i < rows; i++) {
            // Process first column
            if (board[i][0] == 'O' && visited[i][0] == 0) {
                dfs(i, 0, board, visited, delRows, delCols); // Call the dfs method to explore the connected region of 'O's
            }
            // Process last column
            if (board[i][cols - 1] == 'O' && visited[i][cols - 1] == 0) {
                dfs(i, cols - 1, board, visited, delRows, delCols); // Call the dfs method to explore the connected region of 'O's
            }
        }

        // Convert surrounded 'O's to 'X's
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O' && visited[i][j] == 0) {
                    board[i][j] = 'X'; // Mark the surrounded 'O's as 'X'
                }
            }
        }
    }

    // Depth First Search (DFS) method to explore the connected region of 'O's
    private static void dfs(int row, int col, char[][] board, int[][] visited, int[] delRows, int[] delCols) {
        visited[row][col] = 1; // Mark the current cell as visited

        int rows = board.length;
        int cols = board[0].length;

        // Explore all four directions
        for (int i = 0; i < 4; i++) {
            int newRow = row + delRows[i];
            int newCol = col + delCols[i];

            // Check if the new cell is within bounds and is an unvisited 'O'
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                && board[newRow][newCol] == 'O' && visited[newRow][newCol] == 0) {
                dfs(newRow, newCol, board, visited, delRows, delCols); // Recursively call dfs for the new cell
            }
        }
    }
}