package StackTest;

import java.util.LinkedList;
import java.util.Queue;


/*使用队列实现栈的下列操作：

push(x) -- 元素 x 入栈
pop() -- 移除栈顶元素
top() -- 获取栈顶元素
empty() -- 返回栈是否为空
注意:

你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
通过次数54,924提交次数84,880
在真实的面试中遇到过这道题？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/implement-stack-using-queues
*/
public class MyStackBy2Queue {
    private Queue<Integer> A = new LinkedList<>();
    private Queue<Integer> B = new LinkedList<>();
    public void push(int x){
        //x往A中入即可
        A.offer(x);
    }

    public Integer pop(){
        if(empty()){
            return null;
        }
        //把A中得元素往B中倒腾
        while (A.size() > 1){
            //需要判定什么时候A中中剩一个元素
            Integer front = A.poll();
            B.offer(front);
        }
        //当循环结束后 A中只有一个元素
        //这个元素就是要出栈得元素
        int ret = A.poll();
        //交换A 和B 得身份
        swapAB();
        return ret;

    }
    private void swapAB(){
        Queue<Integer> tmp = A;
        A = B;
        B = tmp;
    }

    public Integer top(){
        if(empty()){
            return null;
        }
        while (A.size() > 1){
            Integer front = A.poll();
            B.offer(front);
        }
        int ret = A.poll();
        B.offer(ret);
        swapAB();
        return ret;
    }

    public boolean empty(){
        return A.isEmpty() && B.isEmpty();
    }
}
