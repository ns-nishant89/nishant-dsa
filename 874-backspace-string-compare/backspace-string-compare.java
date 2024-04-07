class Solution {
    public boolean backspaceCompare(String s, String t) {
     Stack<Character> S1 = new Stack<>();
     Stack<Character> T1 = new Stack<>();
     StringBuilder str1 = new StringBuilder();
     StringBuilder str2 = new StringBuilder();
     for(int i=0;i<s.length();i++){
        if(s.charAt(i)=='#' && !S1.isEmpty()){
            S1.pop();
        }else if(s.charAt(i)!='#'){
            S1.push(s.charAt(i));
        }
     }
     for(int i=0;i<t.length();i++){
        if(t.charAt(i)=='#' && !T1.isEmpty()){
            T1.pop();
        }else if(t.charAt(i)!='#'){
            T1.push(t.charAt(i));
        }
     }
     while(!S1.isEmpty()){
        str1.append(S1.peek());
        S1.pop();

     }   
      while(!T1.isEmpty()){
        str2.append(T1.peek());
        T1.pop();
     }   
     return str1.toString().equals(str2.toString());
    }
}