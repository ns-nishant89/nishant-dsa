class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
       int row=matrix.length;
       int col = matrix[0].length;
       int maxofrowmin = Integer.MIN_VALUE;
       for(int i=0;i<row;i++){
        int minval = matrix[i][0];
        for(int j=0;j<col;j++){
            minval = Math.min(minval,matrix[i][j]);
        }
        maxofrowmin = Math.max(maxofrowmin,minval);
       }
       
       List<Integer> res = new ArrayList<>();
         for(int i=0;i<col;i++){
            int maxval = matrix[0][i];
            for(int j=0;j<row;j++){
                maxval = Math.max(maxval,matrix[j][i]);
            }
            if(maxval==maxofrowmin){
                res.add(maxval);
            }
         }
         return res;
    }
}