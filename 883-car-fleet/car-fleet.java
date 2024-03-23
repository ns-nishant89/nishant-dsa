class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n=position.length;
        double [][] cardata = new double [n][2];
        // 0th pe postion calculate karna hoga
        // 1th pe time calculate kara hoga
        for(int i=0;i<n;i++){
            cardata [i][0] = position[i]*1d;
            cardata [i][1] = (target-position[i]*1d)/speed[i];
        }
        Arrays.sort(cardata,(a,b)->Double.compare(a[0],b[0]));
        int nooffleet=1;
        double tt = cardata[n-1][1];
        for(int i=n-2;i>=0;i--){
            if(cardata[i][1]>tt){
                nooffleet++;
                tt=cardata[i][1];
            }
        }
        return nooffleet;
    }
}