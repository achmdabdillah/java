package com.abdil;

public class Ceiling {
    public static void main(String[] args) {
        
        int[] ascArr = {1,2,3,5,6};
        int target = 7;

        int ans = ceiling(ascArr, target);
        System.out.println(ascArr[ans]);

    }

    static int ceiling(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

        if(target > arr[arr.length -1]){
            return -1;
        }

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(target == arr[mid]){
                return mid;
            }
            else if(target < arr[mid]){
                    end = mid - 1;
            }
            else if(target > arr[mid]){
                    start = mid + 1;
            }
        }

        return start;
    }
}
