class Solution {
    public String removeOuterParentheses(String s) {
        int cnt=0;
         String ans="";
         boolean flag = true;
         for(int i=0;i<s.length();i++){
             if(s.charAt(i)=='('){
                 cnt++;
             }else cnt--;
         if(cnt==1 && flag==true){
             flag = false;
             continue;
         }
         if(cnt==0 && flag==false){
             flag=true;
             continue;
           }
             ans +=s.charAt(i);
         }
         return ans;
    }
}