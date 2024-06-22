class Solution {
    public int heightChecker(int[] heights) {
        int min = Arrays.stream(heights).min().getAsInt();
        int max = Arrays.stream(heights).max().getAsInt();
        int [] cnt = new int[max+1];
        for(int i=0;i<heights.length;i++){
            cnt[heights[i]]++;
        }
        int [] expected = heights.clone();
        int i=0;
        for( int val=min;val<max+1;val++){
            while(cnt[val]>0){
                expected[i]=val;
                cnt[val]--;
                i++;
            }
        }
        int ans=0;
        for(int x=0;x<heights.length;x++){
            if(expected[x]!=heights[x]){
                ans++;
            }
        }
        return ans;
    }
}