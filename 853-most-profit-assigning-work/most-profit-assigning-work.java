class Solution {
       
    private int binarySearch(int x,int [][]arr){
        int low=0;
        int high = arr.length-1;
        int mid = 0;
        while(low<=high){
            mid = low+ (high-low)/2;
            if(arr[mid][0]==x) return mid;
            if(arr[mid][0]<x) low=mid+1;
            else high=mid-1;
            
        }
        return arr[mid][0]>x?mid-1:mid;
    } 
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
      int [][] profits = new int[difficulty.length][2];
      for(int i=0;i<profit.length;i++){
        profits[i][0] = difficulty[i];
        profits[i][1] = profit[i];
      } 
      Arrays.sort(profits,(a,b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]); 
      
      int maxprofit=0;
      for(int i=0;i<profit.length;i++){
        if(maxprofit<=profits[i][1]){
            maxprofit = profits[i][1];
        }
         profits[i][1]=maxprofit;
      }

      int ans=0;
      for(int i:worker){
        int index = binarySearch(i,profits);
            if(index==-1) continue; 
           ans+=profits[index][1];
        }
        return ans;
      }
      
    }
