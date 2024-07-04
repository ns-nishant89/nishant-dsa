class Solution {
    public int minDifference(int[] nums) {
      if(nums.length<=4) return 0;
      int n=nums.length;
      Arrays.sort(nums);
      int res = Integer.MAX_VALUE;
      //case1
        res = Math.min(res,nums[n-4]-nums[0]);  
      //case2
       res = Math.min(res,nums[n-3]-nums[1]);  
      //case3
       res = Math.min(res,nums[n-2]-nums[2]);  
      //case4
      res = Math.min(res,nums[n-1]-nums[3]); 
      return res; 
    }
}