class Solution {
    public int partitionDisjoint(int[] nums) {
       int n = nums.length;
       int leftmax= nums[0];
       int greater =nums[0];
       int ans=0;
       for(int i=1;i<n;i++){
           if(nums[i]>greater){
                 greater =nums[i];
           }else if(nums[i]<leftmax){
               leftmax=greater;
               ans=i;
           }
       } 
       return ans+1;
    }
}