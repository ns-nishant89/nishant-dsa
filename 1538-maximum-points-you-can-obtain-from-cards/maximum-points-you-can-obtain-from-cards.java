class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int leftsum =0;
        for(int i=0;i<k;i++)leftsum = leftsum+=cardPoints[i];
          int maxsum = leftsum;
          int rightsum=0;
        int rightind=cardPoints.length-1;
        for( int i=k-1;i>=0;i--){
            leftsum = leftsum-cardPoints[i];
            rightsum = rightsum+cardPoints[rightind];
            rightind=rightind-1;
            maxsum = Math.max(maxsum,leftsum+rightsum);
        }
        return maxsum;
    }
}