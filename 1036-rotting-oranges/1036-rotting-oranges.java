class Pair{
    int row;
    int col;
    int time;
    Pair(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int freshCount = 0;
        int cnt = 0;

        Queue<Pair> q = new LinkedList<>();

        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                if(grid[i][j] == 2){
                    vis[i][j] = 2;
                    q.add(new Pair(i, j, 0));
                }
                else if(grid[i][j] == 1){
                    ++freshCount;
                }
            }
        }
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        int time = 0;

        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().time;
            q.poll();
            time = Math.max(time, t);

            for(int i = 0; i < 4; ++i){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0){
                    q.add(new Pair(nrow, ncol, t + 1));
                    vis[nrow][ncol] = 2;
                    ++cnt;
                }
            }
        }
        if(cnt != freshCount){
            return -1;
        }
        return time;
    }
}