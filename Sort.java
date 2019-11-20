package SortDemo;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[]arr = {9, 5, 2, 7, 8, 10, 15, 19, 3, 1, 90, 59, 80};
//        insertSort(arr);
//        shellSort(arr);
//        selectSort(arr);
//        heapSort(arr);
//        bubbleSort(arr);
//        quickSort(arr,0,arr.length-1);
//        mergeSort(arr);
        mergeSortByLoop(arr);
        System.out.println(Arrays.toString(arr));
    }

    //直接插入排序
    public static void insertSort(int[] array) {
        int bound = 1;
        for(;bound < array.length; bound++){
            int tmp = array[bound];
            int cur = bound - 1;
            for(; cur >= 0; cur--){
                if(array[cur] > tmp){
                    array[cur + 1] = array[cur];
                }else {
                    break;
                }
            }
            array[cur + 1] = tmp;
        }
    }


    //希尔排序
    public static void  shellSort(int[]array){
        int gap = array.length;
        while(gap > 1){
            gap /= 2;
            insertSortGap(array,gap);
        }
        insertSortGap(array,1);
    }
    public static void insertSortGap(int[] array,int gap){
        for(int bound = 1; bound < array.length; bound ++ ){
            int tmp = array[bound];
            int cur = bound - gap;
            for(; cur >= 0; cur -= gap){
                if(array[cur] > tmp){
                    array[cur + gap] = array[cur];
                }else{
                    break;
                }
            }
            array[cur + gap] = tmp;
        }
    }



    //直接选择排序
    public static void selectSort(int[]array){
        //[0,bound]已排序区间 [bound，array.length]待排序期间
        for(int bound = 0; bound < array.length; bound++){
            for(int cur = bound + 1; cur < array.length; cur++){
                int tmp = array[bound];
                if(array[cur] < tmp){
                    array[bound] = array[cur];
                    array[cur] = tmp;
                }
            }
        }
    }


    //堆排序
    public static void heapSort(int[] array){
        createHeap(array);
        for(int i = 0; i < array.length; i++){
            swap(array, 0, array.length - i - 1);
            shiftDown(array, array.length - i - 1,0);
        }
    }
    public static void createHeap(int[] array){
        for(int i = (array.length - 1 - 1) / 2; i >= 0; i--){
            shiftDown(array, array.length, i);
        }
    }
    public static void shiftDown(int[]array, int size, int index){
        int parent = index;
        int child = 2 * parent + 1;
        while(child < size){
            if(child + 1 <size && array[child + 1] > array[child]){
                child = child + 1;
            }
            if(array[child] > array[parent]){
                swap(array, child, parent);
            }else{
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }
    public static void swap(int[] array, int x, int y){
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }

    //冒泡排序
    public static void bubbleSort(int[]array){
        for(int bound = array.length - 1; bound > 0; bound --){
            for(int cur = 0; cur < bound; cur++){
                if(array[cur] > array[cur + 1]){
                    swap(array,cur,cur+1);
                }
            }
        }
    }

    //快速排序
    public static void quickSort(int[] array, int left, int right ){
        if(left < right){
            int i = left;
            int j = right;
            int baseValue = array[i];
            while ( i < j){
                while( i < j && array[j] > baseValue){
                    j--; // 从右向左找第一个小于baseValue的值
                }
              while (i < j && array[i] < baseValue){
                    i++;
                }
                swap(array,i,j);
            }
            array[i] = baseValue;
            quickSort(array,left,i-1);
            quickSort(array,i+1,right);
        }
    }



//归并排序递归版本
    public static void mergeSort(int[]array){
        mergeSortHleper(array,0,array.length);
    }
    private static void mergeSortHleper(int[]array, int left, int right){
        if(left >= right ||right - left == 1){
            return;
        }
        int mid = (left +right) / 2;
        mergeSortHleper(array, left, mid);
        mergeSortHleper(array, mid, right);
        merge(array, left, mid, right);
    }
    private static void merge(int[]array, int left, int mid, int right){
        int length = right - left;
        int[]output = new int[length];
        int outputIndex = 0;
        int i = left;
        int j = mid;
        while ( i < mid && j <right){
            if(array[i] < array[j]){
                output[outputIndex++] = array[i++];
            }else{
                output[outputIndex++] = array[j++];
            }
        }
        while(i < mid){
            output[outputIndex++] = array[i++];
        }
        while(j < right){
            output[outputIndex++] = array[j++];
        }

        for(int k = 0; k < length; k++){
            array[left +k] = output[k];
        }
    }
    //归并排序非递归版本
    public static void mergeSortByLoop(int[]array){
        for(int gap = 1; gap < array.length; gap *= 2){
            for(int i = 0; i < array.length; i+= 2*gap){
                int beg = i;
                int mid = i + gap;
                int end = i + 2*gap;
                if(mid > array.length){
                    mid = array.length;
                }
                if(end > array.length){
                    end = array.length;
                }
                merge(array, beg, mid, end);
            }
        }
    }

}
