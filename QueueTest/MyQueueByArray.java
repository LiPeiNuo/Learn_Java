package QueueTest;

public class MyQueueByArray {
    private int[] array = new int[100];
    //[head,tail)有效元素得范围，注意tail可能在head之前
    private int head = 0;
    private int tail = 0;
    private int size = 0; //元素个数

    //入队列
    public void offer(int val){
        if(size == array.length){
            // 队列已经满了，无法继续插入
            return;
        }
        array[tail] = val;
        tail++;
        //tail++之后如果超出数组得有效范围，就从头开始
        if(tail >= array.length){
            tail = 0;
        }
        size++;
    }

    //出队列
    public Integer poll(){
        if(size == 0){
            return null;
        }
        Integer ret = array[head];
        head++;
        if(head >= array.length){
            head = 0;
        }
        size--;
        return ret;

    }

    //取队首元素
    public Integer peek(){
        if(size ==0){
            return null;
        }
        return array[size];
    }
}
