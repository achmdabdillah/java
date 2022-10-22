package com.abdil;

import java.util.Arrays;

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class FirstAndLastPos {
    public static void main(String[] args) {
        int[] nums = {5,7,7,7,11};
        int target = 7;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    static int[] searchRange(int[] nums, int target) {
        int[] answer = {-1,-1};
        int first = search(nums, target, true);        
        int last = search(nums, target, false);
        answer[0] = first;        
        answer[1] = last;        
        return answer;
    }

    static int search(int[] nums, int target, boolean findFirstIndex){
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(target < nums[mid]){
                    end = mid - 1;
            }
            else if(target > nums[mid]){
                    start = mid + 1;
            } else {
                ans = mid;
                if(findFirstIndex){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return ans;
    }
}
