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
            //System.out.print(nums[i]+" ");
        }

        Integer[] c = new Integer[]{121,343,242,4211,2342452,345,35465,2321};
        radixSort(c,c.length,7);
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i]+" ");
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

    public static int getDigit(int x, int d){
        int a[] = {1,10,100,1000,10000,100000,1000000,10000000};
        return (x/a[d-1])%10;
    }

    /**
     * 基数排序
     */
    public static void radixSort(Integer[] data, int n, int maxDigit){
        int radix = 10;
        int[] count = new int[radix];
        int[] bucket = new int[n];
        for(int i=1; i<=maxDigit; i++){
            for (int j = 0; j < radix; j++) {
                count[j] = 0;
            }
            for (int j = 0; j < n; j++) {
                int x = getDigit(data[j], i);
                count[x]++;
            }
            for (int j = 1; j < radix; j++) {
                count[j] = count[j] + count[j-1];
            }
            for (int j = n-1; j >=0 ; j--) {
                int x = getDigit(data[j],i);
                bucket[count[x]-1] = data[j];
                count[x]--;
            }
            for (int j = 0,m = 0; j < n; j++,m++) {
                data[j] = bucket[m];
            }
        }
    }

}
