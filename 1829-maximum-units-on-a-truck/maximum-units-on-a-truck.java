class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b)->b[1]-a[1]);
        int i=0;
        int ans=0;
        while(truckSize>0 && i<boxTypes.length){
            int maxi = Math.min(boxTypes[i][0],truckSize);
            ans+=maxi*boxTypes[i][1];
            i++;
            truckSize-=maxi;
        }
        return ans;
    }
}