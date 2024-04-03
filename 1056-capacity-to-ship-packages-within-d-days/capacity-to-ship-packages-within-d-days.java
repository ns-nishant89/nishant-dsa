class Solution {
    public int finddays(int[]weights,int capacity){
        int n=weights.length;
        int load=0;
        int day=1;
        for(int i=0;i<n;i++){
            if(load+weights[i]>capacity){
                day+=1;
                load=weights[i];
            }else{
                load+=weights[i];
            }
           
        }
         return day;
    }
    public int shipWithinDays(int[] weights, int days) {
       int low=Integer.MIN_VALUE;
       int high=0;
       int n=weights.length;
       for(int i=0;i<n;i++){
            high+=weights[i];
          low=Math.max(low,weights[i]);
         }
         while(low<=high){
           int mid=(low+high)/2;
           int numberofdays=finddays(weights,mid);
           if(numberofdays<=days){
               high=mid-1;
           }else{
               low=mid+1;
           }
       }
       return low;
    }
}