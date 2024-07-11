class Solution {
    public String reverseParentheses(String s) {
   Stack<Integer> st = new Stack<>();
   StringBuilder res = new StringBuilder();
   int [] arr = new int[s.length()];
   for(int i=0;i<s.length();i++){
    char ch = s.charAt(i);
    if (ch =='(') {
        st.push(i);
    }else if(ch ==')'){
          int openindex = st.pop();
          arr[openindex]=i;
          arr[i] = openindex; 
         }
      }
      int dir=1;
      int i=0;
      while(i<s.length()){
        char ch = s.charAt(i);
        if(ch=='(' || ch==')'){
            i=arr[i];
            dir = -1*dir;
        }else{
            res.append(ch);
        }
        i+=dir;
      }      
      return res.toString();
    }
}