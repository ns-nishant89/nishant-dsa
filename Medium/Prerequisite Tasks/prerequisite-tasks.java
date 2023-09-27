//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,P,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public boolean isPossible(int N,int P, int[][] prerequisites)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<N;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<P;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int indegree []= new int[N];
        for(int i=0;i<N;i++){
            for(int it: adj.get(i)){
                indegree[it]++;
            }
        }
            Queue<Integer> q =new LinkedList<Integer>();
            for( int i=0;i<N;i++){
               if( indegree[i]==0){
                 q.add(i);  
               }  
            }
        List<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int node  = q.peek();
            q.remove();
            topo.add(node);
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0) q.add(it);
            }
        }
        if(topo.size()==N)return true ;
        return false;
    }
    
}