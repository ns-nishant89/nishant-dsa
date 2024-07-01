class Solution {
    public int appendCharacters(String s, String t) {
        int i=0;
        int j=0;
        int m=s.length();
        int n = t.length();
            while(i<m && j<n){
                if(s.charAt(i)==t.charAt(j)){
                    j++;
                }
                i++;
            }
        return n-j;
        
    }
}