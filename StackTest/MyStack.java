package StackTest;

public class MyStack {
    private int[] array = new int[100];
    private int size = 0;  //栈中存放多少个有效元素
    //入栈
    public void push(int x){
        array[size] = x;
        size++;
    }

    //取栈顶元素
    public int peek(){
        return array[size -1];
    }

    //出栈
    public int  pop(){
        int ret = array[size -1];
        size--;
        return ret;
    }

}
