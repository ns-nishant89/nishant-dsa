class Solution {
    public int compareVersion(String version1, String version2) {
      int i=0;
      int j=0;
      int n1=0;
      int n2=0;
       int v1len = version1.length();
      int v2len = version2.length();
      while(i<v1len ||j<v2len){
        //n1 and n2 are for compare
        n1=0;
        n2=0;
        while(i<v1len && version1.charAt(i)!='.'){
            n1 = n1*10+(version1.charAt(i++)-'0');
        }
        while(j<v2len && version2.charAt(j)!='.'){
            n2 = n2*10+(version2.charAt(j++)-'0');
        }
        if(n1>n2) return 1;
         else if(n1<n2) return -1;
         else{
            i++;
            j++;
         }
      } 
      return 0; 
    }
}