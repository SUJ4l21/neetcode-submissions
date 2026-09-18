class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        //bubble sort

        // for(int i=0;i<n-1;i++){
        //     for(int j =0;j<n-i-1;j++){
        //         if(nums[j]>nums[j+1]){
        //             int temp = nums[j];
        //             nums[j]=nums[j+1];
        //             nums[j+1]=temp;
        //         }
        //     }
        // }
        // return nums;


        // selection sort

        for(int i =0;i<n-1;i++){
            int min = i;
            for(int j=i+1;j<n;j++){
                if(nums[j]<nums[min]){
                    min = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;

        }
        return nums;
    }
}