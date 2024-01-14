class Solution {
    public int maxDepth(String s) {
      int depth = 0;
    int cnt = 0;
    for(char ch: s.toCharArray()){
        if(ch =='('){
            cnt++;
        } 
        if(ch ==')') {
          cnt--;
        }
        depth = Math.max(depth,cnt);
    }
    return depth;
    }
}