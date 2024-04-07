class Solution {
    public boolean backspaceCompare(String s, String t) {
      StringBuilder str1=compare(s);
        StringBuilder str2=compare(t);

        return str1.toString().equals(str2.toString());
    }
    
    public StringBuilder compare(String s){
        StringBuilder str = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='#'){
                if(str.length()>0)
                    str.deleteCharAt(str.length()-1);
            } 
            else
                str.append(s.charAt(i));
        }
        
        return str;
       
    }
}