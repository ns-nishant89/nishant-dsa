class Solution {
    public List<String> summaryRanges(int[] nums) {
     int length=nums.length;
     List<String> res = new ArrayList<String>(length);
     for(int i=0;i<length;i++){
        int num = nums[i];
        while(i<length-1 && nums[i]+1==nums[i+1]){
            i++;
        }
        if(num!=nums[i]){
            res.add(num+"->" +nums[i]);
        }else{
            res.add(num+"");
        }
     }   
     return res;
    }
}