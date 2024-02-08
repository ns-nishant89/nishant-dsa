class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> freqmap = new HashMap<>();
        for(int val:arr){
            freqmap.put(val,freqmap.getOrDefault(val,0)+1);
        }
        HashSet<Integer> unique = new HashSet<>();
        for(int freq:freqmap.values()){
            if(unique.contains(freq)){
                return false;
            }else{
                unique.add(freq);
            }
        }
        return true;
    }
}