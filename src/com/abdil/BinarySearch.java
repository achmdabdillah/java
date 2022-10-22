package com.abdil;

public class BinarySearch {
    public static void main(String[] args) {
        
        int[] ascArr = {1,2,3,4,5,6};
        int[] descArr = {6,5,4,3,2,1};
        int target = 5;

        int ans = binarySearch(ascArr, target);
        System.out.println(ans);

    }

    static int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        boolean isAscending = false;
        if(arr[start] < arr[end]){
            isAscending = true;
        } else {
            isAscending = false;
        }

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(target == arr[mid]){
                return mid;
            }
            else if(target < arr[mid]){
                if(isAscending){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            else if(target > arr[mid]){
                if(isAscending){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}
