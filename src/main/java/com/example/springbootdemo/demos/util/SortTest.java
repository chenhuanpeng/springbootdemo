package com.example.springbootdemo.demos.util;

public class SortTest {

    public static int[] sortArray(int[] nums){

        for(int i=0;i<nums.length-1;i++){

            boolean swap = false;

            for(int j=0;j<nums.length-1-i;j++){
                if(nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    swap = true;
                }
            }

            if(!swap){
                break;
            }

        }

        return nums;

    }

    public static void main(String[] args){
        int[] nums = {9,4,8,6,5,3};
        int[] sortedNums = SortTest.sortArray(nums);
        for(int num : sortedNums){
            System.out.print(num + " ");
        }
    }

}
