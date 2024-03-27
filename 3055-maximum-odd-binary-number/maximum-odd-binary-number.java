class Solution {
    public String maximumOddBinaryNumber(String s) {
        int cntones=0;
        StringBuilder res = new StringBuilder();
        for(char ch:s.toCharArray()){
            if(ch=='1'){
                cntones++;
            }
        }
        for(int i=0;i<s.length()-1;i++){
            if(cntones>1){
                cntones--;
                res.append('1');
            }else{
                res.append('0');
            }
        }
        res.append('1');
        return res.toString();
    }
}