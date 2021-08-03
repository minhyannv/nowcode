import java.util.List;

/**
 * @author wmy
 * @date 2021/6/11 16:46
 */

/*
描述
将一个链表\ m m 位置到\ n n 位置之间的区间反转，要求时间复杂度 O(n)O(n)，空间复杂度 O(1)O(1)。
例如：
给出的链表为 1\to 2 \to 3 \to 4 \to 5 \to NULL1→2→3→4→5→NULL, m=2,n=4m=2,n=4,
返回 1\to 4\to 3\to 2\to 5\to NULL1→4→3→2→5→NULL.
注意：
给出的 mm,nn 满足以下条件：
1 \leq m \leq n \leq 链表长度1≤m≤n≤链表长度
示例1
输入：
{1,2,3,4,5},2,4
复制
返回值：
{1,4,3,2,5}
复制
 */
public class Q_ReverseBetweenLinkedList {
    /**
     * @param head ListNode类
     * @param m    int整型
     * @param n    int整型
     * @return ListNode类
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write code here
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        ListNode start = pre.next;
        ListNode tail = start.next;
        for (int i = m - 1; i < n - 1; i++) {
            start.next = tail.next;
            tail.next = pre.next;
            pre.next = tail;
            tail = start.next;
        }
        return dummy.next;

    }

    public static void main(String[] args) {
        Q_ReverseBetweenLinkedList app = new Q_ReverseBetweenLinkedList();
        int m = 2;
        int n = 4;
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ListNode ln5 = new ListNode(5);

        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;

        ListNode res = app.reverseBetween(ln1, m, n);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
