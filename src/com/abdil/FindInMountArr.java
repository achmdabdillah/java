package com.abdil;
// https://leetcode.com/problems/find-in-mountain-array/


public class FindInMountArr {
    public static void main(String[] args) {
        
    }

    static int findInMountainArray(int target, MountainArray mountainArr) {
        
        int peakIndex = peakIndexInMountainArray(mountainArr);
        
        int ans = binarySearch(mountainArr, target, 0, peakIndex);
        
        if(ans != -1) {
            return ans;
        }

        return binarySearch(mountainArr, target, peakIndex + 1, mountainArr.length() - 1);
    }

    static int binarySearch(MountainArray mountainArr, int target, int start, int end){
        
        boolean isAscending = mountainArr.get(start) < mountainArr.get(end);

        while(start <= end){

            int mid = start + (end - start) / 2;

            if(target == mountainArr.get(mid))
            {
                return mid;
            }
            if(isAscending){
                if(target < mountainArr.get(mid))
                {
                    end = mid -1;
                }
               else
               {
                   start = mid +1;
               }
            }else{
               if(target > mountainArr.get(mid)){
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

    static int peakIndexInMountainArray(MountainArray mountainArr) 
    {
        int start = 0;
        int end = mountainArr.length() - 1;

        while(start < end){
            int mid = start + (end - start) / 2;
            
            if(mountainArr.get(mid) > mountainArr.get(mid+1))
            {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
