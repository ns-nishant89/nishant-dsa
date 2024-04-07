class Solution {
    public int removePalindromeSub(String s) {
      int i=0;
      int j = s.length()-1;
      boolean isPalindrome = true;
      while(i<=j){
      if(s.charAt(i)!=s.charAt(j)) isPalindrome=false;
      i++;
      j--;  
      }
      if(isPalindrome) return 1;
      return 2;
    }
}