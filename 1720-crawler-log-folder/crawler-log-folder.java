class Solution {
    public int minOperations(String[] logs) {
      int level=0;
      for(String log:logs){
        if(log.equals("../")){
            if(level!=0){
                level--;
            }
        }else if(log.equals("./")){
             continue;
        }else{
            level++;
        }
      } 
      return level;
    }
}