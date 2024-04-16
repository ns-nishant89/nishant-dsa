class Solution {
    public String removeDuplicates(String s, int k) {
       int n =s.length();
       if(n<k)return s;
       Stack<Pair<Character,Integer>>st = new Stack<>();
       for(int i=0;i<n;i++){
        if(st.isEmpty()||st.peek().first!=s.charAt(i)){
            st.push(new Pair<>(s.charAt(i),1));
        }
        else{
           Pair<Character,Integer> prev = st.pop();
           st.push(new Pair<>(s.charAt(i),prev.second+1));
        }
        if(st.peek().second==k) st.pop();
       } 
       StringBuilder ans = new StringBuilder();
       while(!st.isEmpty()){
        Pair<Character,Integer> curr = st.pop();
        while(curr.second-->0){
            ans.append(curr.first);
        }
       }
       return ans.reverse().toString();
    }
     static class Pair<T, U> {
        T first;
        U second;

        Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }
    }
}
