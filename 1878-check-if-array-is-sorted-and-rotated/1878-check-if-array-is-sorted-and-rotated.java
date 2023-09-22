class Solution {
    public boolean check(int[] nums) {
        int c=0;
        for(int i=0;i<nums.length;i++){
            // Check if the current element is greater than the next element in a circular manner.
            // The modulo operator (%) is used to wrap around to the beginning when reaching the end of the array.
            if(nums[i]>nums[(i+1)%nums.length]){
                c++;
            }
            if(c>1){
                return false;
            }
        }
        return true;
    }
}