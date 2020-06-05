package QueueTest;

import java.util.Stack;
/*
使用栈实现队列的下列操作：
        push(x) -- 将一个元素放入队列的尾部。
        pop() -- 从队列首部移除元素。
        peek() -- 返回队列首部的元素。
        empty() -- 返回队列是否为空。
        示例:

        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        queue.peek();  // 返回 1
        queue.pop();   // 返回 1
        queue.empty(); // 返回 false
        说明:

        你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
        你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
        假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
        通过次数46,842提交次数73,097

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
 */


public class MyQueueBy2Stack {
    Stack<Integer> A = new Stack<>();
    Stack<Integer> B = new Stack<>();
    public void push(int x){
        //先把 B 中的元素都倒腾到 A里
        while (!B.isEmpty()){
            int tmp = B.pop();
            A.push(tmp);
        }
        //把新元素入A即可
        A.push(x);
    }

    public Integer pop(){
        //如果为空，就直接返回
        if(empty()){
            return null;
        }
        //把A中的元素都倒腾给B
        while (!A.isEmpty()){
            int tmp = A.pop();
            B.push(tmp);
        }
        return B.pop();

    }

    public Integer peek(){
        //如果为空，就直接返回
        if(empty()){
            return null;
        }
        //把A中的元素都倒腾给B
        while (!A.isEmpty()){
            int tmp = A.pop();
            B.push(tmp);
        }
        return B.peek();

    }

    public boolean empty(){
        return A.isEmpty() && B.isEmpty();
    }
}
