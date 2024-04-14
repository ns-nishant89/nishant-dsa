class Solution {
    int dp[][];
    public int minDistance(String word1, String word2) {
         dp = new int [word1.length()+1][word2.length()+1];
        for(int rows[]:dp){
            Arrays.fill(rows,1000);
        }
        return helper(word1,word2,0,0);
    }
     public int helper(String w1,String w2,int i,int j){
        if(i==w1.length() && j==w2.length()) return 0;
        if(i==w1.length() || j==w2.length()) return Math.max(w1.length()-i,w2.length()-j);
        if(dp[i][j]!=1000) return dp[i][j];
        if(w1.charAt(i)==w2.charAt(j)) return helper(w1,w2,i+1,j+1);
        return dp[i][j] = 1+ Math.min(helper(w1,w2,i+1,j),helper(w1,w2,i,j+1));
     }
}