class Solution {
    public int numberOfBeams(String[] bank) {
        List<Integer> counts = new ArrayList<>();
        int rows = bank.length;
        int cols = bank[0].length();
        int lastcount=0;
        int total=0;
        for(String str : bank){
            int count=0;
            for(int i=0;i<cols;i++){
                if(str.charAt(i)=='1'){
                    count++;
                }
            }
            total+=lastcount*count;
            if(count!=0) lastcount = count;
        }
        return total;
    }
}