class Solution {
    public boolean partionsubsetsum(int ind,int target,int[]nums,int [][]dp){
        if(target==0) return true;
        if(ind==0) return nums[ind]==target;
        if(dp[ind][target]!=-1) return dp[ind][target]==0?false:true;
        boolean nottaken = partionsubsetsum(ind-1,target,nums,dp);
        boolean taken = false;
        if(nums[ind]<target){
            taken = partionsubsetsum(ind-1,target-nums[ind],nums,dp);
        }
         dp[ind][target]=nottaken||taken?1:0;
         return nottaken||taken;
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalsum = 0;
        for(int i = 0;i<n;i++){
        totalsum += nums[i];
        }
        if(totalsum%2==1)
            return false;
         else {
            int k = totalsum/2;
            int [][] dp = new int[n][k+1];
            for(int [] row:dp){
                Arrays.fill(row,-1);
            }
          return partionsubsetsum(n-1,k,nums,dp);
        }
      
    }
}