class Solution {
    public int minimumAverageDifference(int[] nums) {
      int n=nums.length;
      int minAverageDiffrence = Integer.MAX_VALUE;
      int index=0;
      long sumFromFront=0;
      long sumFromEnd=0;
      for( int num:nums) sumFromEnd+=num;
      for(int i=0;i<n;i++){
        sumFromFront+=nums[i];
        sumFromEnd-=nums[i];
        int a =(int)(sumFromFront/(i+1));
        int b=(i==n-1)?0:(int)(sumFromEnd/(n-i-1));
        if(Math.abs(a-b)<minAverageDiffrence){
            minAverageDiffrence=Math.abs(a-b);
            index=i;
        }
      }
      return index;
    }
}