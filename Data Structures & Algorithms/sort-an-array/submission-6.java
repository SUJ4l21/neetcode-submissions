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

        // for(int i =0;i<n-1;i++){
        //     int min = i;
        //     for(int j=i+1;j<n;j++){
        //         if(nums[j]<nums[min]){
        //             min = j;
        //         }
        //     }
        //     int temp = nums[i];
        //     nums[i] = nums[min];
        //     nums[min] = temp;

        // }
        // return nums;


        // insertion sort 

        // for(int i=1;i<n;i++){
        //     int key = nums[i];
        //     int j = i-1;

        //     while(j>=0 && nums[j]>key){
        //         nums[j+1] = nums[j];
        //         j--;
        //     }
        //     nums[j+1]= key;
        // }
        // return nums;




        // merge sort 

        sort(nums,0,nums.length-1);
        return nums;

    }
    public void sort(int[]nums,int left,int right){
        if(left<right){

            int mid = left + (right-left)/2;
            sort(nums,left,mid);
            sort(nums,mid+1,right);

            merge(nums,left,mid,right);
        }
    }
    public void merge(int[]nums,int left,int mid,int right){

        int[] temp = new int[right-left+1];
        int i =left;
        int j = mid+1;
        int k = 0;

        while(i<=mid && j<=right){
            if(nums[i]<=nums[j]){
                temp[k++] = nums[i++];
            }else{
                temp[k++] = nums[j++];
            }
        }

        while(j<=right){
            temp[k++] = nums[j++];
        }
        while(i<=mid){
            temp[k++] = nums[i++];
        }

        for(int a=0;a<temp.length;a++){
            nums[left+a] = temp[a];
        }

    }
}