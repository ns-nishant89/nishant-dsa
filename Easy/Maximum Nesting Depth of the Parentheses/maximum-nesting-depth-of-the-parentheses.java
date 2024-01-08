//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            sc.nextLine();
            String s;
            s = sc.next();
            
            Solution obj = new Solution();
            int res = obj.maxDepth(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int maxDepth(String s) {
        int depth = 0;
        int cnt = 0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                cnt++;
            }
            if(ch==')'){
                cnt--;
            }
            depth = Math.max(depth,cnt);
        }
        return depth;
    }
}
        
