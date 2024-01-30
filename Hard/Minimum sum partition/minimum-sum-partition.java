//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    int totalsum=0;
	    for(int i=0;i<n;i++) totalsum+=arr[i];
	     int k = totalsum;
	     boolean [][] dp =new boolean [n][totalsum+1];
	     for(int i=0;i<n;i++) dp[i][0]=true;
	     if(arr[0]<=k) dp[0][totalsum]=true;
	     for(int ind =1;ind<n;ind++){
	         for(int target=1;target<=totalsum;target++){
	           boolean nottaken = dp[ind-1][target];
	           boolean taken =false;
	   if(arr[ind]<=target) taken = dp[ind-1][target-arr[ind]];
	   dp[ind][target] = nottaken||taken;
	             
	         }
	     }
	     int mini = Integer.MAX_VALUE;
	     for(int i=0;i<=totalsum;i++){
	         if(dp[n-1][i]==true)
	         mini = Math.min(mini,Math.abs((totalsum-i)-i));
	     }
	    return mini;
	} 
}
