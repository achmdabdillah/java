package com.abdil;

public class Main {
    public static void main(String[] args) {
        char[] arr = {'c','f', 'j'};
        char target = 'c';

        char ans = nextGreatestLetter(arr, target);
        System.out.println(ans);
    }

    static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;

        if(target > letters[letters.length -1]){
            return letters[start % letters.length];
        }

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(target < letters[mid]){
                    end = mid - 1;
            }
            else if(target > letters[mid]){
                    start = mid + 1;
            }
        }

        return letters[start];
    }
}