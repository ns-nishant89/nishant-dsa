class Solution {
    public int findmax(int [] nums){
        int maxi=Integer.MIN_VALUE;;
        for(int i=0;i<nums.length;i++){
            maxi = Math.max(maxi,nums[i]);
        } 
      return maxi;
    }
    public int minIncrementForUnique(int[] nums) {
       int maxelem = findmax(nums);
       int n=nums.length;
       int countArr[] = new int[maxelem+n];
       for(int num:nums){
        countArr[num]++;
       } 
       int moves=0;
       for(int i=0;i<countArr.length;i++){
        if(countArr[i]<=1) continue;
         int extra =countArr[i]-1;
        moves+=extra;
        countArr[i+1]+=extra;

       }
       return moves;
    }
}