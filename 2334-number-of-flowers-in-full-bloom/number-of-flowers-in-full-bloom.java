class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n = flowers.length;
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i=0; i<n; i++){
            starts[i] = flowers[i][0];
            ends[i] = flowers[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int m = people.length;
        int[] res = new int[m];
        for (int i=0; i<m; i++){
            res[i] = binarySearch(starts, people[i]+1)-binarySearch(ends, people[i]);
        }
        return res;
    }
    
    public int binarySearch(int[] arr, int target) {
        int res = arr.length;
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = (l+r)/2;
            if (arr[mid] >= target) {
                res = mid;
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return res;
    }
}