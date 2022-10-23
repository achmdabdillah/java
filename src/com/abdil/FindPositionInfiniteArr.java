package com.abdil;

// https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
public class FindPositionInfiniteArr {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int target = 4;
        int ans = findPos(arr, target);
        System.out.println(ans);
    }

    static int findPos(int[] nums, int target){
        int start = 0;
        int end = 1;
        boolean isInRange = false;

        while(target > nums[end]){
            start = end + 1;
            end = (start * 2) + 1;
        }
        isInRange = true;

        while(start <= end && isInRange){
            int mid = start + (end - start) / 2;

            if(target < nums[mid]){
                end = mid - 1;
            }
            else if(target > nums[mid]){
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}