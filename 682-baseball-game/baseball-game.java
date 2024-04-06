class Solution {
    public int calPoints(String[] operations) {
      List<Integer> scores = new ArrayList<>();
      int size=0;
      for(String i:operations){
        if(i.equals("+")){
           scores.add(scores.get(size-1)+scores.get(size-2));
            size++;
        }else if(i.equals("D")){
            scores.add(2*scores.get(size-1));
            size++;
        }else if(i.equals("C")){
        size--;
        scores.remove(size);    
        }else{
            size++;
            scores.add(Integer.parseInt(i));
        }
      }
      int sum=0;
      for(int i=0;i<size;i++){
        sum+=scores.get(i);
      }
      return sum;
    }
}