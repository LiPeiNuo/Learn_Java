import sun.plugin.javascript.navig.Link;

class LinkedNode{
    public int data = 0;
    public LinkedNode next = null;

    public LinkedNode( ){

    }

    public LinkedNode(int data){
        this.data = data;
    }
}

    public class Linkedlist{
    private LinkedNode head = null;
    public void addFirst(int elem){
        LinkedNode node= new LinkedNode(elem);
        if(this.head==null){
            this.head = node;
            return;
        }
        node.next = head;//想象为地址
        this.head = node;
        return;
    }

    public void addLast(int elem){
        LinkedNode node = new LinkedNode(elem);
        if(this.head == null){
            this.head = node;
            return;
        }
        LinkedNode cur = this.head;
        while(cur.next!=null){
            cur = cur.next;
        }
        cur.next = node;
    }

    
    public int size(){
        int size = 0;
        for(LinkedNode cur = this.head;cur!=null;cur = cur.next){
            size++;
        }
        return size;
    }
    private LinkedNode getlndexPos(int index){
        LinkedNode cur = this.head;
        for(int i = 0;i<index;i++){
            cur = cur.next;
        }
        return cur;
    }


    public void addIndex(int index,int elem){
        LinkedNode node =new LinkedNode(elem);
        int len = size();
        if(index < 0 || index >len){
            return;
        }
        if(index == 0){
            addFirst(elem);
            return;
        }
        if(index == len){
            addLast(elem);
            return;
        }
        LinkedNode prev = getlndexPos(index - 1);
        node.next = prev.next;
        prev.next = node;
    }


    public boolean contains(int toFind){
        for(LinkedNode cur = this.head;cur!=null;cur=cur.next){
            if(cur.data==toFind){
                return true;
            }
        }
        return false;
    }


    public void remove(int toRemove){
        if(head == null){
            return;
        }
        if(head.data == toRemove){
            this.head = this.head.next;
            return;
        }
        LinkedNode prev = searchPrev(toRemove);
        if (prev == null){
           return;
          }
        LinkedNode nodeToMove = prev.next;
        prev.next = nodeToMove.next;
    }


    private LinkedNode searchPrev(int toRemove){
        if(this.head == null){
            return null;
        }
        LinkedNode prev = this.head;
        while(prev.next!=null){
            if(prev.next.data == toRemove){
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }


    public void display(){
        System.out.print("[");
        for(LinkedNode node = this.head;node!=null;node=node.next){//结点遍历
            System.out.print(node.data);
            if(node.next!=null){
                System.out.print(",");
            }
        }
        System.out.println("]");
    }


    public void removeAllKey(int toRemove){  //先处理后续节点，最后处理头节点
        if (head == null){
            return;
        }
        LinkedNode prev = head;
        LinkedNode cur = head.next;
        while(cur!=null){
            if(cur.data == toRemove){
                prev.next = cur.next;
                cur = prev.next;
            }else{
                prev = cur;
                cur = cur.next;
            }
        }
        if(this.head.data == toRemove){     //头结点情况
            this.head = this.head.next;
        }
        return;
    }


    public void clear(){
        this.head = null;
    }

    public LinkedNode reverseLinked(LinkedNode head){
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        LinkedNode newHead = null;
        LinkedNode cur = head;
        LinkedNode prev = null;
        while(cur != null){
            LinkedNode next = cur.next;
            if(next == null){
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return newHead;
    }











}