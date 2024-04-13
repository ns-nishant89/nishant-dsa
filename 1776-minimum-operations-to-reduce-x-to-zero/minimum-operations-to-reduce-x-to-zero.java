class Solution {
    public int minOperations(int[] nums, int x) {
      int sum=0;
      int n = nums.length;
      for(int i:nums) sum+=i;
      int target = sum-x;
      int currsum=0;
      int maxlen=0;
      int i=0;
      boolean found=false;
      for(int j=0;j<n;j++){
        currsum+=nums[j];
        while(i<=j && currsum>target){
            currsum-=nums[i];
            i+=1;
        }
        if(currsum==target){
            found=true;
            maxlen=Math.max(maxlen,j-i+1);
        }
      }
      return found? n-maxlen:-1;  
    }
}