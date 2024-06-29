class Solution {
    public String[] findRelativeRanks(int[] score) {
      int n = score.length;
      int maxscore=0;
      for(int i=0;i<n;i++){
        maxscore = Math.max(maxscore,score[i]);
      }  
      int [] score2index = new int[maxscore+1];
      for(int i=0;i<n;i++){
        score2index[score[i]] = i+1;
      }
      String [] ans = new String[n];
      int place=1;
      for(int i= maxscore;i>=0;i--){
        if(score2index[i]==0) continue;
        int actualindex = score2index[i]-1;
        if(place==1){
            ans[actualindex] ="Gold Medal";
        } else if(place==2){
            ans[actualindex]="Silver Medal";
        }else if(place==3){
            ans[actualindex] ="Bronze Medal";
        } else {
            ans[actualindex] = String.valueOf(place);
        }
        place++;
      }
      return ans;
    }
}