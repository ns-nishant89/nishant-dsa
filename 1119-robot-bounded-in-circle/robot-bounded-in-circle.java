class Solution {
    public boolean isRobotBounded(String instructions) {
        char currdir='N';
        int x=0;
        int y=0;
        for(int i=0;i<instructions.length();i++){
            if(instructions.charAt(i)=='G'){
                if(currdir=='N'){
                    y+=1;
                }else if(currdir=='S'){
                    y-=1;
                }else if(currdir=='W'){
                    x-=1;
                }else if(currdir=='E'){
                    x+=1;
                }
            }else{
                char incoming = instructions.charAt(i);
                if(currdir =='N'){
                  currdir = incoming =='L'? 'W':'E';
                }else if(currdir=='W'){
                    currdir = incoming =='L'? 'S':'N';
                }else if(currdir=='S'){
                    currdir = incoming =='L'? 'E':'W';
                }else{
                    currdir = incoming =='L'? 'N':'S';
                }
            }
        }
        if(x==0&& y==0 ||currdir!='N'){
            return true;
        }
        return false;
    }
}