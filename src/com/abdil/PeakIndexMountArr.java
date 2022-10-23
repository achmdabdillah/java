package com.abdil;

// https://leetcode.com/problems/peak-index-in-a-mountain-array/
public class PeakIndexMountArr {
    public static void main(String[] args) {
        int[] mountArr = {3,5,3,2,0};
        int ans = peakIndexInMountainArray(mountArr);
        System.out.println(ans);
        
    }
    static int peakIndexInMountainArray(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while(start < end){
            int mid = start + (end - start) / 2;
            
            if(nums[mid] > nums[mid+1]){
                // you are in the descending part of the array
                // this may be the ans, but we still want to check the left side
                // this is why end != mid - 1
                end = mid;
            } else {
                // you are in the ascending part of the array
                start = mid + 1; // because we know that mid + 1 is greater than mid
            }
        }
        return start;
    }
}
