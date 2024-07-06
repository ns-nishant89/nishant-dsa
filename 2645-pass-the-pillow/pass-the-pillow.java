class Solution {
    public int passThePillow(int n, int time) {
     int caltime=0;
     int pillowpos=1;
     boolean revdir=false;
     while(caltime<time){
        if(!revdir){
            pillowpos+=1;
        }else{
            pillowpos-=1;
        }
        if(pillowpos==1 || pillowpos==n){
            revdir=!revdir;
        }
        caltime++;
     } 
     return pillowpos;  
    }
}