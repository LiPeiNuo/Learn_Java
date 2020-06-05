package QueueTest;

public class MyQueueByLinkedList {
    //Node这个类叫做内部类 ，定义宅某个类或者方法中的类
    //static 效果就是：创建Node的实例不依赖MyQueueByLinkedList
    static class Node{
        public  int val;
        Node next = null;

        public Node(int val) {
            this.val = val;
        }
    }

    //创建一个链表得有一个头节点此处头节点不是傀儡节点
    //基于链表来实现队列，可以入队列从尾部插入，出队列从头部删除
    //也可以入队列入队列从头部插入，出队列从尾部删除
    //无论是哪种实现方式， 最好把头和尾记录下来
    private Node head = null;
    private Node tail = null;

    //入队列(标准库中得入队列操作就叫offer)
    public void offer(int val){
        Node newNode = new Node(val);
        if(head == null){
            head = newNode;
            tail = newNode;
            return;
        }
        //当前如果不是空链表
        tail.next = newNode;
        tail = tail.next;
    }

    //出队列
    public Integer poll(){
        if(head == null){
            return null;
        }
        int ret = head.val;
        head = head.next;
        if(head == null){
            tail = null;
        }
        return ret;
    }
    //取队首元素
    public Integer peek(){
        if(head == null){
            return null;
        }
        return head.val;
    }
}
