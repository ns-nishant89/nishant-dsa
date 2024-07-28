class Solution {
    public boolean isPalindrome(int x){       
       int revnum = 0;
       int dup = x;
       while(x>0){
          int ld = x%10;
          revnum=(revnum*10)+ld;
          x=x/10; 
          } 
          if(dup==revnum) return true; 
          return false;     
    }
}