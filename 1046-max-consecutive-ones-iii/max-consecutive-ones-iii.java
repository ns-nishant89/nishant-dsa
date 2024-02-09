class Solution {
    public int longestOnes(int[] nums, int k) {
       int ans=0;
       int i=0;
       int j=-1;
       int countofzero=0;
       while(i<nums.length){
           //acquire
           if(nums[i]==0){
               countofzero++;
               i++;
           }else{
               i++;
           }  
        
       while(countofzero>k){
           j++;
           if(nums[j]==0){
            countofzero--; 
           }else{

           }
       }
       int sizeofwindow = i-1-j;
       ans = Math.max(ans,sizeofwindow);
       }
       return ans;
    }
}