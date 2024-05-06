class Solution {
      public int subarraysWithKDistinct(int[] nums, int k) {
        return slidingWindow(nums,k)-slidingWindow(nums,k-1);
}
    private int slidingWindow(int[] nums,int k){
  
        int left=0;
        int right=0;
        int cnt=0;
        HashMap<Integer,Integer> map= new HashMap<>();
        while(right<nums.length){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while(map.size()>k){
                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left])==0){
                    map.remove(nums[left]);
            }
            left++;
            }
            cnt=cnt +(right-left+1);
            right++;
        }
        return cnt;
    }
}