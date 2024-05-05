class Solution {
     public int numberOfSubarrays(int[] nums, int k) {
        return countNicesubArrays(nums,k)-countNicesubArrays(nums,k-1);
    }
    private int countNicesubArrays(int [] nums,int k){
        if(k<0) return 0;
       int left=0;
       int right=0;
       int sum=0;
       int count=0;
       while(right<nums.length){
        if(nums[right]%2==1) sum++;
        while(sum>k){
            if(nums[left]%2==1) sum--;
            left++;
        }
        count+=(right-left+1);
        right++;
       }
       return count;
    } 
}