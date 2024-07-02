class Solution {
    public int countNicePairs(int[] nums) {
    int n = nums.length;
    for(int i=0;i<n;i++){
        nums[i] = nums[i]-reverse(nums[i]);
    }    
    Arrays.sort(nums);
    int currentcount=0;
    int lastnumber = nums[0];
    long res = 0;
    for(int num:nums){
        if(num==lastnumber){
            res+=currentcount;
            currentcount++;
        }else{
            currentcount=1;
        }
        lastnumber=num;
    }
    return (int)(res%1000000007);

    }
    public int reverse(int num){
        int reverse=0;
        while(num!=0){
            int remainder = num%10;
            reverse = reverse*10+remainder;
            num=num/10;
        }
        return reverse;
    }
}