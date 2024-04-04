class Solution {
    public int maxPower(String s) {
       int ans=1;
       int x=1;
       for(int i=1;i<s.length();i++){
        if(s.charAt(i)==s.charAt(i-1)){
            x++;
        }else{
            ans=Math.max(ans,x);
            x=1;
        }
       }
       ans = Math.max(ans,x);
       return ans; 
    }
}