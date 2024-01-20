class Solution {
    
    static int uniquepath(int i,int j,int[][]dp,int[][] obstacleGrid){
      if(i<0 || j<0 || obstacleGrid [i][j]==1 ) return 0;

      if(i==0 && j==0) return 1;
      if(dp[i][j]!=-1) return dp[i][j];
      int up = uniquepath(i-1,j,dp,obstacleGrid);
      int left = uniquepath(i,j-1,dp,obstacleGrid);
      return dp[i][j]=up+left;  
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m =obstacleGrid.length;
        int n =obstacleGrid[0].length;
        int g [][] = new int [m][n];
        int dp[][] = new int[m][n];
        for(int []row:dp){
            Arrays.fill(row,-1);
        }
        return uniquepath(m-1,n-1,dp,obstacleGrid);
    }
}