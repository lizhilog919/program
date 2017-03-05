package com.test.demo.algorithm;

/**
 * Created by lizhi
 * 17-3-2
 */
public class SortUtil {

    public static void main(String[] args){
        Integer[] nums = new Integer[]{2,3,1,4,8,7,15,60,34,43,9};
        selectSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }

    /**
     *冒泡排序
     */
    public static void paoSort(Integer[] data){
        for (int i = 0; i < data.length; i++) {
            for (int j = data.length -1; j > i; j--) {
                if(data[j] < data[j-1]){
                    int temp = data[j];
                    data[j] = data[j-1];
                    data[j-1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     */
    public static void selectSort(Integer[] data){
        for (int i = 0; i < data.length; i++) {
            int k = i;
            for(int j=i+1; j< data.length;j++){
                if(data[j] < data[i]){
                    k = j;
                }
            }
            int temp = data[k];
            data[k] = data[i];
            data[i] = temp;
        }
    }


    /**
     * 快速排序
     */
    public static void quickSort(Integer[] data, int low, int high){
        if(low < high) {
            int start = low;
            int end = high;
            int key = data[low];
            while (start < end) {
                while (start < end && data[end] >= key) {
                    end--;
                }
                if(data[end] <= key){
                    int temp = data[start];
                    data[start] = data[end];
                    data[end] = temp;
                }
                while (start < end && data[start] <= key) {
                    start++;
                }
                if(start < end && data[start] >= key){
                    int temp = data[start];
                    data[start] = data[end];
                    data[end] = temp;
                }
            }
            quickSort(data, low, start - 1);
            quickSort(data, start + 1, high);
        }
    }

}
