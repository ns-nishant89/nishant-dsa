class Solution {
    public int wiggleMaxLength(int[] nums) {
       if(nums.length<2) return nums.length;
      int prev=nums[1]-nums[0];
      int count=prev!=0?2:1;
       int diff=0;
       for(int i=1;i<nums.length-1;i++){
        diff=nums[i+1]-nums[i];
        if((diff>0 && prev<=0)|| (diff<0 && prev>=0)){
            prev=diff;
            count++;
         }
       }
       return count;
    }
}