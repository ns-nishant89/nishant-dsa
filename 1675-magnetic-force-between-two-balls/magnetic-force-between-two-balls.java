class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low=0;
        int high =position[position.length-1];
        int optimal=0;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(isPlacmentPossible(position,m,mid)){
                optimal = mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return optimal;
    }
    private boolean isPlacmentPossible(int []position,int m,int max){
        int count=1;
        int last = position[0];
        for(int i=0;i<position.length;i++){
            if(position[i]-last>=max){
                last = position[i];
                count++;
            }
        }
        return count>=m;
    }
}