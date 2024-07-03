class Solution {
    public int minSetSize(int[] arr) {
      int n =arr.length;
      int maxi = Integer.MIN_VALUE;
      for(int e:arr) maxi = Math.max(maxi,e);
       
        int [] freq = new int [maxi+1];
      for(int e:arr){
        freq[e]++;
      }
      Arrays.sort(freq);
      int i =maxi;
      int count=0;
    while(n>arr.length/2){
        n-=freq[i];
        i--;
        count++;
    }
    return count;
    }
}