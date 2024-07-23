class Solution {
    public int[] frequencySort(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int num:nums){
            freq.put(num,freq.getOrDefault(num,0)+1);
        }
        Integer temp[] = new Integer[freq.size()];
        int i=0;
        for(Integer key:freq.keySet()){
            temp[i]=key;
            i++;
        }
           Arrays.sort(temp,new Comparator <Integer>(){
            public int compare(Integer a,Integer b){
                if(freq.get(a)==freq.get(b)){
                  return b-a;
                }
                return freq.get(a)-freq.get(b);
            }
           });
            i=0;
           for(int key:temp){
            int f = freq.get(key);
            for( int j=0;j<f;j++){
                  nums[i]=key;
                  i++;
            }
           }
           return nums;
    }
}