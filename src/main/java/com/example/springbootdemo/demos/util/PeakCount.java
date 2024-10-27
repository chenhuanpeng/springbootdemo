package com.example.springbootdemo.demos.util;

public class PeakCount {

    public static int countPeaks(int[] arr) {
        int count = 0;

        for(int i=0;i<arr.length;i++){
            if(i==0 && arr[i]>arr[i+1]){
                count++;
            }
            if(i==arr.length-1&&arr[i]>arr[i-1]){
                count++;
            }
            if(i>0 && i<arr.length-1 && arr[i]>arr[i-1] && arr[i]>arr[i+1]){
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3, 2, 1, 0, 1, 2};
        System.out.println(countPeaks(arr));
    }
}
