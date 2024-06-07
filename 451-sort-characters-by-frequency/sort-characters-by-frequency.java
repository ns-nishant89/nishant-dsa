class Solution {
    public String frequencySort(String s) {
        StringBuilder ans = new StringBuilder();
        HashMap<Character,Integer>map = new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        List<Character> list = new ArrayList(map.keySet());
        list.sort((obj1,obj2)->map.get(obj2)-map.get(obj1));
        for(char ch:list){
            for(int i=0;i<map.get(ch);i++){
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}