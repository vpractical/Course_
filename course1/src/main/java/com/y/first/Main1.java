package com.y.first;

import java.util.Arrays;

public class Main1 {

    public static void main(String[] args) {
        int[] arr = {1, 8, 2, 3, 7, 6, 4, 9, 5, 0};
        System.out.println(Arrays.toString(arr));
//        bubbleSort(arr);
//        quickSort(arr, 0, arr.length - 1);
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        binarySearch(arr, 0, arr.length, 6);
        System.out.println("二分查找：循环：" + binarySearch2(arr, 0, arr.length, 6));
    }

    /**
     * 冒泡
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        for (int j = arr.length - 1; j > 0; j--) {
            boolean flag = true;
            for (int i = 0; i < j; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    /**
     * 选择排序
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        int len = arr.length;
        for (int j = 0; j <= len - 2; j++) {
            int index = j;
            for (int i = index + 1; i <= len - 1; i++) {
                if (arr[index] > arr[i]) {
                    index = i;
                }
            }
            if (index != j) {
                arr[index] = arr[index] ^ arr[j];
                arr[j] = arr[index] ^ arr[j];
                arr[index] = arr[j] ^ arr[index];
            }
        }
    }

    public static void quickSort(int[] arr, int begin, int end) {
        if (begin > end || end >= arr.length) return;
        int left = begin;
        int right = end;
        int temp = arr[left];
        boolean direction = true;
        L:
        while (left < right) {
            if (direction) {
                for (int i = right; i > left; i--) {
                    if (arr[i] < temp) {
                        arr[left] = arr[i];
                        arr[i] = temp;
                        right = i;
                        left++;
                        direction = false;
                        continue L;
                    }
                }
                right = left;
            } else {
                for (int i = left; i < right; i++) {
                    if (arr[i] > temp) {
                        arr[right] = arr[i];
                        arr[i] = temp;
                        left = i;
                        right--;
                        direction = true;
                        continue L;
                    }
                }
                left = right;
            }
        }
        quickSort(arr, begin, left - 1);
        quickSort(arr, left + 1, end);
    }

    public static void mergeSort(int array[], int left, int right) {
        if (left == right) {
            return;
        } else {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid + 1, right);
        }
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int leftSize = mid - left;
        int rightSize = right - mid + 1;
        //生成数组
        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];
        //填充数据
        for (int i = left; i < mid; i++) {
            leftArray[i - left] = array[i];
        }
        for (int i = mid; i <= right; i++) {
            rightArray[i - mid] = array[i];
        }
        //合并
        int i = 0;
        int j = 0;
        int k = left;
        while (i < leftSize && j < rightSize) {
            if (leftArray[i] < rightArray[j]) {
                array[k] = leftArray[i];
                k++;
                i++;
            } else {
                array[k] = rightArray[j];
                k++;
                j++;
            }
        }
        while (i < leftSize) {
            array[k] = leftArray[i];
            k++;
            i++;
        }
        while (j < rightSize) {
            array[k] = rightArray[j];
            k++;
            j++;
        }
    }

    /**
     * 二分查找
     */
    public static void binarySearch(int[] arr, int fromIndex, int toIndex, int key) {

        if (fromIndex > toIndex) return;

        int low = fromIndex;
        int high = toIndex;

        int mid = (low + high) / 2;

        if (key > arr[mid]) {
            low = mid + 1;
        } else if (key < arr[mid]) {
            high = mid - 1;
        } else {
            System.out.println("二分查找：递归：" + mid);
            return;
        }

        binarySearch(arr, low, high, key);

    }

    /**
     * 二分查找
     */
    public static int binarySearch2(int[] arr, int fromIndex, int toIndex, int key) {

        if (fromIndex > toIndex) return -1;

        int from = fromIndex;
        int to = toIndex;
        while (from < to) {
            int mid = (from + to) / 2;
            int val = arr[mid];
            if (key < val) {
                to = mid - 1;
            } else if (key > val) {
                from = mid + 1;
            } else {
                return val;
            }
        }

        return -1;
    }
}
