package com.abdil;

// https://leetcode.com/problems/search-in-rotated-sorted-array/description/
public class rotatedBinarySearch {
    public static void main(String[] args){
        int[] nums = {5, 1 ,3}; 
        int target = 3;

        int tst = search(nums, target);
        System.out.println("result =>> " + tst);
        
    }

    static int search(int[] nums, int target){
        int pivot = findPivot(nums);
        int ans;

        if(pivot != -1){
            ans = binarySearch(nums, target, 0, pivot);
            if(ans != -1){
                return ans;
            }
            return binarySearch(nums, target, pivot + 1, nums.length -1);
        } else {
            return binarySearch(nums, target, 0, nums.length-1);
        }
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
            // is between the mid + 1 and last element  
            if(nums[mid] > nums[end]){
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start - 1;
    }

    static int binarySearch(int[] nums, int target, int start, int end){
        
        boolean isAscending = nums[start] < nums[end];

        while(start <= end){

            int mid = start + (end - start) / 2;

            if(target == nums[mid])
            {
                return mid;
            }
            if(isAscending){
                if(target < nums[mid])
                {
                    end = mid -1;
                }
               else
               {
                   start = mid +1;
               }
            }else{
               if(target > nums[mid]){
                   end = mid - 1;
               }
               else
               {
                   start = mid + 1;
               }
            }
        }

        return -1;
    }
}
