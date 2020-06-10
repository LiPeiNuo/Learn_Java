package ListNodePratice;

public class LinkedListTest {
    //内部类
    static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }

    //删除链表中给定值val的所有节点
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode per = head;
        ListNode cur = head.next;
        while (cur != null) {
            if(cur.val == val){
                per.next = cur.next;
                cur = per.next;
            }
            else{
                per = cur;
                cur = cur.next;
            }

        }
        if(head.val == val){
            head = head.next;
        }
        return head;

    }


    //反转链表
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur = head;
        ListNode reverseHead = null;
        ListNode next;
        while (cur != null){
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }

        head = reverseHead.next;
        return head;
    }

    public ListNode reverseList_2(ListNode head){
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode newHead = null;
        while (cur != null){
            ListNode next = cur.next;
            //cur为当前链表的末尾
            if(next == null){
                newHead = cur;
            }
            //核心操作
            cur.next = pre;
            pre = cur; //更新
            cur = next;
        }
        return newHead;
    }


    //链表的中间结点
    public ListNode middleNode(ListNode head) {
        int size = 0;
        ListNode temp = head;
        ListNode cur = head;
        int step = 0;
        while ( temp != null){
            ++size;
            temp = temp.next;
        }
        step = size/2;
        while (step > 0){
            cur = cur.next;
            --step;
        }
        return cur;
    }


    //返回链表的倒数第K个结点
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode temp = head;
        int size = 0;
        while (temp != null){
            size++;
            temp = temp.next;
        }
        if(k < 0 || k > size){
            return null;
        }
        int step = size - k;
        ListNode cur = head;
        while (step > 0){
            cur = cur.next;
            step--;
        }
        return cur;
    }

    //合并两个有序链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode newHead = new ListNode(0);
        ListNode tail = newHead;
        while ( cur1 != null && cur2 != null){
            if(cur1.val < cur2.val){
                tail.next = cur1;
                tail = tail.next;
                cur1 = cur1.next;
            }else{
                tail.next = cur2;
                tail = tail.next;
                cur2 = cur2.next;
            }
        }
        if(cur1 == null){
            tail.next = cur2;
        }else{
            tail.next = cur1;
        }
        return newHead.next;
    }


    //给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
    public ListNode partition(ListNode pHead, int x) {
        if(pHead == null){
            return null;
        }
        if(pHead.next == null){
            return pHead;
        }
        ListNode samllHead = new ListNode(0);
        ListNode samll = samllHead;
        ListNode bigHead = new ListNode(0);
        ListNode big = bigHead;
        ListNode cur = pHead;
        while (cur != null){
            if(cur.val < x){
                samll.next = new ListNode(cur.val);
                samll = samll.next;
            }else{
                big.next = new ListNode(cur.val);
                big = big.next;
            }
            cur = cur.next;
        }
        samll.next = bigHead.next;
        return samllHead.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(9);
        ListNode b = new ListNode(5);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(7);
        ListNode e = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = null;

        int x = 4;
        LinkedListTest test = new LinkedListTest();
        ListNode result = test.partition(a,x);
        for(ListNode cur = result; cur != null; cur = cur.next){
            System.out.println(cur.val);
        }
    }

    //在一个排序的链表中，存在重复的结点，删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
    // 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode newHead = new ListNode(0);
        ListNode Tail = newHead;
        ListNode cur = pHead;
        while (cur!= null){
            if(cur.next != null && cur.val == cur.next.val){
                while (cur.next != null && cur.val == cur.next.val){
                    cur = cur.next;
                }
                cur = cur.next;
            }else{
                Tail.next = new ListNode(cur.val);
                Tail = Tail.next;
                cur = cur.next;
            }
        }
        return newHead.next;
    }



    //链表的回文结构
    public boolean chkPalindrome(ListNode A) {
        //求链表的长度
        int size = 0;
        ListNode temp = A;
        while (temp != null){
            size++;
            temp = temp.next;
        }
        //找链表的中间结点
        int steps = size/2;
        ListNode B = A;
        while (steps > 0){
            B = B.next;
            steps--;
        }
        //从中间位置逆置链表
        ListNode cur = B;
        ListNode pre = null;
        while (cur != null){
            ListNode next = cur.next;
            if(next == null){
                B = cur;
            }
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        //两个链表重头开始遍历对比
        while (B != null){
            if(A.val != B.val){
                return false;
            }
            A = A.next;
            B = B.next;
        }
        return true;
    }

     public int size(ListNode head){
        int size = 0;
        ListNode cur = head;
        while (cur != null){
            size++;
            cur = cur.next;
        }
        return size;
     }

    //找到两个单链表相交的起始节点。
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = size(headA);
        int sizeB = size(headB);
        int offset = 0;
        if(sizeA > sizeB){
            offset = sizeA - sizeB;
            for (int i = 0; i < offset; i++){
                headA = headA.next;
            }
        }else{
            offset = sizeB - sizeA;
            for(int i = 0; i < offset; i++){
                headB = headB.next;
            }
        }

        while (headA != null && headB != null){
            if(headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    //判断链表是否有环
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next!= null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    //给定一个链表，返回链表开始入环的第一个节点。
    // 如果链表无环，则返回 null。
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode solw = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            solw = solw.next;
            if(fast == solw){
                break;
            }
        }
        if(fast == null || fast.next == null){
            return null;
        }
        ListNode cur1 = head;
        ListNode cur2 = solw;
        while (cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

}
