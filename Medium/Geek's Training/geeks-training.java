//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int [][]points=new int[N][3];
            for(int i=0;i<N;i++){
                for(int j=0;j<3;j++){
                    points[i][j]=sc.nextInt();
                }
            }
            Solution obj=new Solution();
            int res=obj.maximumPoints(points,N);
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int func(int day,int last,int [][] dp,int [][] points){
        //if it is already calculated 
        if(dp[day][last] !=-1) return dp[day][last] ;
        //calculation for day 0 
        if(day==0){
            int maxi=0;
            for(int i=0;i<=2;i++){
                if(i!=last){
                   maxi =Math.max(maxi,points[0][i]);
                }
            }
            return dp[day][last] =maxi;
        }
        //calculation for current day+previous day
        int maxi =0;
        for(int i=0;i<=2;i++){
            if(i!=last){
                int activity = points[day][i] +func(day-1,i,dp,points);
                 maxi = Math.max(maxi,activity);
            }
        }
        return dp[day][last] =maxi;
        
    }
    public int maximumPoints(int points[][],int N){
       int[][] dp = new int [N][4];
       for(int []row:dp){
           Arrays.fill(row,-1);
       }
       return func(N-1,3,dp,points);
    }
}