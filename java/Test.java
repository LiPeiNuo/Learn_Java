// 数组转字符串
int[] arr = {1,2,3,4};
String newArr = Arrays.toString(arr);
System.out.println(newArr);
//执行结果[1, 2, 3, 4]


//实现自己版本的拷贝数组
public static int[] copyof(int[] arr){
    int ret = new int[arr.length];
    for(int i = 0; i < arr.length; i++ ){
        ret[i] = arr[i];
    }
    return ret;
}


//数组遍历 
class Test{
    public static void main(String[] args){
        int[]arr = {1,2,3};
        printArray(arr);
    }
    public static void printArray(int[]a){
        for (int x:a){
            System.out.println(x);
        }   
    }
}



//参数传内置类型
class Test{
    public static void main(String[] args){
        int num = 0;
        func(num);
        System.out.println("num = " + num);
    }
    public static void func(int x){
        x = 10;
        System.out.println("x = " + x);
    } 
}
//执行结果 x=10   num=0
//修改形参x的值，不影响实参num的值



//参数传数组类型
class Test{
    public static void main(String[] args){
    int[] arr = {1,2,3};
    func(arr);
    System.out.println("arr[0]=" + arr[0]);
    }

    public static void func(int[] a){
    a[0] = 10;
    System.out.println("a[0]=" + a[0]);
    }
}
//执行结果 a[0]=10    arr[0]=10
//函数内部修改数组内容, 函数外部也发生改变. 
//引用本质上只是存了一个地址. Java 将数组设定成引用类型
//这样的话后续进行数组参数传参, 其实只是将数组的地址传入到函数形参中



//写一个方法，将数组中的每一个元素都*2
class Test{
    public static void main(String[] args){
        int[]arr = {1,2,3};
        int[] output = transform(arr);
        printArray(output);
    }

    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    public static int[] transform(int[] arr){
        int[] ret = new int[arr.length];
        for(int i = 0; i<arr.length;i++){
            ret[i] = arr[i]*2;
        }
        return ret;
    }
}



//找数组中的最大元素
class Test{
    public static void main(String[] args){
    int[] arr = {1,2,3,4,5};
    System.out.println(max(arr));
    }

    public static int max(int[] arr){
    int max = arr[0];
    for(int i = 1; i < arr.length; i++){
        if (arr[i] > max){
            max = arr[i];
        }
    }
    return max;
    }
}


//给定一个整形数组，求平均值
class Test{
    public static void main(String[] args){
    int[] arr = {1,2,3,4,5};
    System.out.println(avg(arr));
    }

    public static double avg(int[] arr){
    int sum = 0;
    for(int x:arr){
        sum += x;
    }
    return (double)sum / (double)arr.length;
    }
}



//查找数组中的指定元素
class Test{
    public static void main(String[] args){
    int[] arr = {1,2,3,4};
    System.out.println(find(arr,3));
    }
    
    public static int find(int[] arr, int tofind){
    for(int i = 0; i < arr.length; i++){
        if (arr[i] == tofind){
            return i;
        }
    }
    return -1;
    }
}



//查找数组中指定元素（二分查找  有序数组）
class Test{
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7};
        System.out.println(binarySearch(arr,6));
    }   

    public static int binarySearch(int[]arr, int toFind){
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(toFind < arr[mid]){
                right = mid - 1;
            }
            else if(toFind > arr[mid]){
                left = mid + 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}



//检查数组的有序性 升序
class Test{
    public static void main (String[] args){
        int[] arr = {1,2,3,4,5,6,7};
        System.out.println(isSorted(arr));
    }

    public static boolean isSorted(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] > arr[i+1]){
                return false;
            }
        }
        return true;
    }
}



//数组排序（冒泡排序）
class Test{
    public static void main(String[] args){
        int[] arr = {9,5,2,7};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr){
        for (int bound = 0; bound < arr.length; bound++){
            for(int cur = arr.length - 1; cur > bound; cur--){
                if(arr[cur - 1] > arr[cur]){
                    int tmp = arr[cur - 1];
                    arr[cur - 1] = arr[cur];
                    arr[cur] = tmp;
                }
            }
        }
    }
}

