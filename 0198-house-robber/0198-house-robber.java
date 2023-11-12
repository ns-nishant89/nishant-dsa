class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int prev=nums[0];
        int prev2= 0;
        for(int i=1;i<n;i++){
            int pick  = prev2+nums[i];
            int nonpick = prev;
            int curr = Math.max(pick,nonpick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}