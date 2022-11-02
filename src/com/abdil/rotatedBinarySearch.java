package com.abdil;

// https://leetcode.com/problems/search-in-rotated-sorted-array/description/
public class rotatedBinarySearch {
    public static void main(String[] args){
        int[] nums = {7,8,1,2,3,4,5,6}; 
        int target = 2;
        int pivot = findPivot(nums);
        System.out.println("PIVOT =====>> " + pivot );
        int ans = search(nums, target);
        System.out.println("ANSWER =====>> " + ans);

        // int ans = binarySearch(nums, 0, 0, nums.length-1);
        // System.out.println(ans);
    } 

    /* Kunal Kushwaha Search */
    
    static int search(int[] nums, int target) {
        int pivot = findPivot(nums);

        // if you did not find a pivot, it means the array is not rotated
        if (pivot == -1) {
            // just do normal binary search
            return binarySearch(nums, target, 0 , nums.length - 1);
        }

        // if pivot is found, you have found 2 asc sorted arrays
        if (nums[pivot] == target) {
            return pivot;
        }

        if (target >= nums[0]) {
            return binarySearch(nums, target, 0, pivot - 1);
        }

        // nums 5, 1 ,3

        return binarySearch(nums, target, pivot + 1, nums.length - 1);
    }

    /* my search function */

    // static int search(int[] nums, int target) {
    //     if(nums.length < 2){
    //         if(nums[0] == target){
    //             return 0;
    //         } else {
    //             return - 1;
    //         }
    //     }
    //     int pivotIndex = findPivot(nums);
    //     int ans;
    //     if(pivotIndex != -1){
    //         ans = binarySearch(nums, target, 0, pivotIndex);
    //     } else {
    //         ans = binarySearch(nums, target, 0, nums.length - 1);
    //     }

    //     if(ans != -1) {
    //         return ans;
    //     }
    //     ans = binarySearch(nums, target, pivotIndex, nums.length - 1);
    //     if(ans != -1) {
    //         return ans;
    //     }
    //     return -1;
    // }


// 7,8,1,2,3,4,5,6
    
    static int findPivot(int[] nums){
        for(int i = nums.length - 1; i > 0; i--){
            if(nums[i] < nums[i - 1]) {
                int ans = (i-1);
                if(ans == nums.length - 1){
                    return 0;
                } else {
                    return ans;
                }
            }
        }
        return -1;
    }

    // static int findPivot(int[] arr) {
    //     int start = 0;
    //     int end = arr.length - 1;
    //     while (start <= end) {
    //         int mid = start + (end - start) / 2;
    //         // 4 cases over here
    //         if (mid < end && arr[mid] > arr[mid + 1]) {
    //             return mid;
    //         }
    //         if (mid > start && arr[mid] < arr[mid - 1]) {
    //             return mid-1;
    //         }
    //         if (arr[mid] <= arr[start]) {
    //             end = mid - 1;
    //         } else {
    //             start = mid + 1;
    //         }
    //     }
    //     return -1;
    // }

    static int binarySearch(int[] nums, int target, int start, int end){
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] > target){
                end = mid - 1;
            } else if(nums[mid] < target){
                start = mid + 1;
            } else if(nums[mid] == target){
                return mid;
            }
        }
        
        return -1;
    }
}
