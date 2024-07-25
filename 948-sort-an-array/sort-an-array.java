class Solution {
    public void merge(int []nums,int low,int mid,int high){
        int n1= mid-low+1;
        int n2=high-mid;
        int arr1[] = new int [n1];
        int arr2[] = new int [n2];
        for(int i=0;i<n1;i++){
            arr1[i]=nums[low+i];
        }
        for(int i=0;i<n2;i++){
            arr2[i]= nums[(mid+1)+i];
        }
        //two pointer
        int i=0;
        int j=0;
        int k=low;
        while(i<n1 && j<n2){
            if(arr1[i]<=arr2[j]){
                nums[k]=arr1[i];
                i++;
            }else{
                nums[k] =arr2[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            nums[k]= arr1[i];
            i++;
            k++;
        }
         while(j<n2){
            nums[k]= arr2[j];
            j++;
            k++;
        }


    }
    public void mergeSort(int [] nums, int low,int high){
      if(low<high){
        int mid = (low+high)/2;
        mergeSort(nums,low,mid);
        mergeSort(nums,mid+1,high);
        merge(nums,low,mid,high);
      }

    }
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
}