class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> l1 = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                l1.add(nums[i]);
            }
        }
        return l1;
    }
}