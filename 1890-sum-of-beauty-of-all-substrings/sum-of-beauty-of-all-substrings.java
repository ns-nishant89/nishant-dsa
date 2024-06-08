class Solution {
    public int beautySum(String s) {
     int ans=0;
     for(int i=0;i<s.length();i++){
        int [] freq = new int[26];
        for(int j=i;j<s.length();j++){
            char ch = s.charAt(j);
            freq[ch-'a']++;
            int mini = Integer.MAX_VALUE;
            int  maxi = Integer.MIN_VALUE;
            for(int k=0;k<26;k++){
                if(freq[k]>0){
                    mini = Math.min(mini,freq[k]);
                    maxi = Math.max(maxi,freq[k]);
                }
            }
            ans+=maxi-mini;
        }

     }   
     return ans;
    }
}