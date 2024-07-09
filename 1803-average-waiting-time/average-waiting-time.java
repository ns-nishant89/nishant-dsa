class Solution {
    public double averageWaitingTime(int[][] customers) {
      int idletime=1;
      long totalwaititme=0;
      for(int customer[] : customers){
        if(idletime<=customer[0]){
            idletime=customer[0]+customer[1];
        }else{
            idletime=idletime+customer[1];
        }
        totalwaititme +=idletime-customer[0];
      }  
      double avg = (totalwaititme/(double) customers.length);
      return avg;
    }
}