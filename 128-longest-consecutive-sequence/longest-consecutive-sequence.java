class Solution {
    public int longestConsecutive(int[] nums) {
       Set<Integer> set = new HashSet<>();
       for(int num:nums){
        set.add(num);
       } 
       int ans=0;
       for(int num:nums){
        if(!set.contains(num-1)){
            int currnum = num;
            int currstreak=1;
        while(set.contains(currnum+1)){
            currnum++;
            currstreak++;
        }
          ans = Math.max(ans,currstreak);
       }
       }
       return ans;
    }
}