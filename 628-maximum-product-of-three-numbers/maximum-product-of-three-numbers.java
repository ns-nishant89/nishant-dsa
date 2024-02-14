class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length-1;
        //to find maximum there are two cases
        // 1 is multiply maximum last three number after sorted three number
        int a= nums[n]*nums[n-1]*nums[n-2];
        // 2 is to multiply two smallest and one largest
        int b = nums[0]*nums[1]*nums[n];
        return Math.max(a,b); 
    }
}