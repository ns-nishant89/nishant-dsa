class Solution {
    public int numRescueBoats(int[] people, int limit) {
     Arrays.sort(people);
     int count =0;
     int n = people.length;
     int left=0;
     int right=n-1;
     while(left<=right){
        if(people[left]+people[right]<=limit){
            left++;
            right--;
        }else{
            right--;
        }
        count++;
     } 
     return count;  
    }
}