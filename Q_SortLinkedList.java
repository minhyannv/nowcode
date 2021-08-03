/**
 * @author wmy
 * @date 2021/6/11 16:46
 */

import java.util.*;

/*
描述
给定一个无序单链表，实现单链表的排序(按升序排序)。
示例1
输入：
[1,3,2,4,5]
复制
返回值：
{1,2,3,4,5}
复制
 */
public class Q_SortLinkedList {

//    /**
//     * 第一种方法：快排
//     *
//     * @param head ListNode类 the head node
//     * @return ListNode类
//     */
//    public ListNode sortInList(ListNode head) {
//        // write code here
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ArrayList<Integer> temp = new ArrayList<>();
//        while (head != null) {
//            temp.add(head.val);
//            head = head.next;
//        }
//        temp.sort(Comparator.naturalOrder());
//        head = null;
//        ListNode auxiliary = null;
//        for (Integer integer : temp) {
//            if (auxiliary == null) {
//                head = auxiliary = new ListNode(integer);
//            } else {
//                auxiliary.next = new ListNode(integer);
//                auxiliary = auxiliary.next;
//            }
//        }
//        return head;
//    }

    /**
     * 第二种方法：归并排序
     *
     * @param head ListNode类 the head node
     * @return ListNode类
     */
    public ListNode sortInList(ListNode head) {
        // write code here
        if (head == null || head.next == null)
            return head;
        //使用快慢指针找到中点
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //分割为两个链表
        ListNode newList = slow.next;
        slow.next = null;
        //将两个链表继续分割
        ListNode left = sortInList(head);
        ListNode right = sortInList(newList);

        ListNode lhead = new ListNode(-1);
        ListNode res = lhead;
        //归并排序
        while (left != null && right != null) {
            if (left.val < right.val) {
                lhead.next = left;
                left = left.next;
            } else {
                lhead.next = right;
                right = right.next;
            }
            lhead = lhead.next;
        }
        //判断左右链表是否为空
        lhead.next = left != null ? left : right;
        return res.next;
    }

    public static void main(String[] args) {
        Q_SortLinkedList app = new Q_SortLinkedList();
        ListNode ln1 = new ListNode(3);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(1);
        ln1.next = ln2;
        ln2.next = ln3;
        ListNode res = app.sortInList(ln1);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
