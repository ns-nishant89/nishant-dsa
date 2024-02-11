class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int [] res = new int[n];
        int i=0;
        int j =n-1; 
         int index = n-1;
         while(i<=j){
        int val1 = nums[i]*nums[i];
        int val2 = nums[j]*nums[j];  
        if(val1>val2){
            res[index] = val1;
            i++;
        }else{
            res[index] = val2;
            j--;
        }
        index--;
        }
        return res;

    }
}