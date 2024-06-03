class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int start =-1;
        int min =Integer.MAX_VALUE;
        int l=0;
       int r =0;
       int cnt=0;
       HashMap<Character,Integer> map = new HashMap<>(); 
       for(int i=0;i<m;i++){
        //add every character of t inside the map.
        map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
       }
        //run a while loop and s string ka character>0  increase count me karke uske baad hasmap me decrease kar denege 
        while(r<n){
            if(map.getOrDefault(s.charAt(r),0)>0) cnt++;
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)-1);
            while(cnt==m){
                if(r-l+1<min){
                    min = r-l+1;
                    start=l;
                }
                map.put(s.charAt(l),map.get(s.charAt(l))+1);
                if(map.get(s.charAt(l))>0) cnt--;
                l++;
            }
            r++;
        }
       
       if(start==-1) return "";
       return s.substring(start,start+min);
    }
}