class Solution {
    public int jump(int[] nums) {
        int jump=0;
        int currind=0;
        int maxind=0;
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            maxind = Math.max(maxind,nums[i]+i);
             if(i==currind){
                currind=maxind;
                jump++;
             }
        }
        return jump;
        
    }
}