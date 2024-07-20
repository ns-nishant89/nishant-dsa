class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
    int rows = rowSum.length;
    int cols = colSum.length;
    int r=0;
    int c=0;
    int [][] res = new int[rows][cols];
       while(r<rows && c<cols){
        int minval = Math.min(rowSum[r],colSum[c]);
        res[r][c] =minval;
        rowSum[r]-=minval;
        colSum[c]-=minval;
        if(rowSum[r]==0){
             r++;
        }else{
            c++;
        }
       }
       return res;
    }
}