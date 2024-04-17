class Solution {
    public void helper(int ind,int sum,int n ,List<Integer> ans2,List<List<Integer>> ans,int k){
        //base case
        if(sum==n && k==0){
            ans.add(new ArrayList<>(ans2));
            return;
        }
        if(sum>n) return;
        for(int i=ind;i<=9;i++){
            if(i>n) break;
            ans2.add(i);
            helper(i+1,sum+i,n,ans2,ans,k-1);
            ans2.remove(ans2.size()-1);

        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> ans2 = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        helper(1,0,n,ans2,ans,k);
        return ans;
    }
}