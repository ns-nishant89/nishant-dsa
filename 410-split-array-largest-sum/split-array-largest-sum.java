class Solution {
    public int findpartion(int []nums,int maxsum){
        int n=nums.length;
        int partion=1;
        int subarraysum=0;
        for(int i=0;i<n;i++){
            if(subarraysum+nums[i]<=maxsum){
                
                subarraysum+=nums[i];
            }else{
                partion++;
                subarraysum=nums[i];
            }
        }
        return partion;
    }
    public int splitArray(int[] nums, int k) {
        int n=nums.length;
        int low=nums[0];
        int high=0;
        for(int i=0;i<n;i++){
            low=Math.max(low,nums[i]);
            high+=nums[i];
        }
        while(low<=high){
            int mid=(low+high)/2;
            int partion=findpartion(nums,mid);
            if(partion>k){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;
        
    }
}