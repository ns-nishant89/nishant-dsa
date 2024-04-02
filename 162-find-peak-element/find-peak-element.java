class Solution {
    public int findPeakElement(int[] nums) {
     int n=nums.length;
     int start=0;
     int end=n-1;
     while(start<end){
        int mid=start+(end-start)/2;
        if(nums[mid+1]>nums[mid]){
        start=mid+1;
         }else{
             end=mid;
             }
         } 
         return start;    
    
    }
}