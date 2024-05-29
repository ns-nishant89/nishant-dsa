class Solution {
    public boolean canJump(int[] nums) {
        int maxind=0;
        int n =nums.length;
        for(int i=0;i<=n-1;i++){
            if(i>maxind) return false;
            maxind = Math.max(maxind,i+nums[i]);
        }
        return true;
    }
}