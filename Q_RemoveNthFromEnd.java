/**
 * @author wmy
 * @date 2021/6/11 16:46
 */

/*
描述
给定一个链表，删除链表的倒数第 n个节点并返回链表的头指针
例如，
给出的链表为: 1\to 2\to 3\to 4\to 51→2→3→4→5, n= 2n=2.
删除了链表的倒数第 nn 个节点之后,链表变为1\to 2\to 3\to 51→2→3→5.

备注：
题目保证 nn 一定是有效的
请给出请给出时间复杂度为\ O(n) O(n) 的算法
示例1
输入：
{1,2},2
复制
返回值：
{2}
复制
 */
public class Q_RemoveNthFromEnd {
    /**
     * @param head ListNode类
     * @param n    int整型
     * @return ListNode类
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write code here
        if (head == null) {
            return null;
        }
        ListNode left = head;
        ListNode right = head;
        while (n > 0) { //右指针向右移动n个位置
            if (right != null) {
                right = right.next;
            } else { //如果右指针为空，说明链表长度小于n，返回null
                return null;
            }
            n--;
        }
        if (right == null) { //如果恰好移动n个位置后，右指针为空，则移除的是首节点
            return left.next;
        }
        while (right.next != null) { //走到倒数的第n+1个结点
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next; // 跳过倒数的第n个结点
        return head;
    }

    public static void main(String[] args) {
        Q_RemoveNthFromEnd app = new Q_RemoveNthFromEnd();
        int n = 5;
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ListNode ln5 = new ListNode(5);
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;
//        int n = 2;
//        ListNode ln1 = new ListNode(1);
//        ListNode ln2 = new ListNode(2);
//        ln1.next = ln2;
        ListNode res = app.removeNthFromEnd(ln1, n);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
