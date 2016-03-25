package Leetcode;


 
import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class ReorderList {
    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while(temp!=null){
            stack.push(temp);
            temp=temp.next;
        }
        int size=stack.size();
        int n=0;
        temp =head;
        ListNode nxtTemp = null;
        while(n<size/2){
            nxtTemp = temp.next;
            temp.next=stack.peek();
            temp.next.next=nxtTemp;
            temp=nxtTemp;
            stack.pop();
            n++;
        }
        if(temp!=null)
       temp.next=null;
       
    }
}