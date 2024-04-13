class Solution {
    public int maximumUniqueSubarray(int[] nums) {
       int ans=0;
       int currentsum=0;
       HashSet<Integer> set=new HashSet<>();
       for(int i=0,j=0;j<nums.length;j++){
        while(set.contains(nums[j])){
            set.remove(nums[i]);
            currentsum-=nums[i];
            i++;
        }
         set.add(nums[j]);
         currentsum+=nums[j];
         ans=Math.max(ans,currentsum);
       } 
       return ans;
    }
}