class Solution {
    int lo=0;
        int maxlen = 0;
    public String longestPalindrome(String s) {
        char [] input = s.toCharArray();
        if(s.length()<2){
            return s;
        }
        for(int i=0;i<s.length();i++){
            //work for odd length palindrome
            ExpandPalindrome(input,i,i);
            //work for even length palindrome
            ExpandPalindrome(input,i,i+1);
         }
            return s.substring(lo,lo+maxlen);
        }
    
        public void ExpandPalindrome(char[] s,int j,int k){
        while(j>=0 && k <s.length && s[j]==s[k]){
            j--;
            k++;
            }
            if(maxlen<k-j-1){
                maxlen=k-j-1;
                lo=j+1;
            }
        
          }
        
    }
