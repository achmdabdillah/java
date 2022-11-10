package com.abdil;

public class findPivot {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6}; 
        int pivot = findPivot(nums);

        System.out.println("PIVOT ====> " + pivot);
    }

    static int findPivot(int[] nums) {
        int start = 0;
        int end = nums.length - 1 ;
        
        if (nums == null || nums.length == 0) {
            return -1;
        }

        while(start < end){
            int mid = start + (end - start) / 2;

            // if mid element is greater than
            // last element, then the pivot 
            // is between the mid and last element  
            if(nums[mid] > nums[end]){
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        // start is the smallest number, and we want the pivot or the largest number in the array which is 1 index before smallest number
        return start - 1 ;
    }
}
