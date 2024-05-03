class Solution {
    public int characterReplacement(String s, int k) {
       int [] freq=new int [26];
       char[] arr=s.toCharArray();
       int left =0;
       int right=0;
       int maxlen=0;
       int maxfreq=0;
       while(right<s.length()){
        maxfreq = Math.max(maxfreq,++freq[arr[right]-'A']);
        int canBeReplaced = (right-left+1)-maxfreq;
        if(canBeReplaced>k){
            freq[arr[left++]-'A']--;
        }
        maxlen = Math.max(maxlen,right-left+1);
        right++;
       }
       return maxlen;
    }

}