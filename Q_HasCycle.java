/**
 * @author wmy
 * @date 2021/6/12 15:13
 */
/*
判断给定的链表中是否有环。如果有环则返回true，否则返回false。
你能给出空间复杂度的解法么？
 */
public class Q_HasCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            if (fast == slow) {
                return true;
            } else {
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Q_HasCycle app = new Q_HasCycle();
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln2;
        boolean res = app.hasCycle(ln1);
        System.out.println(res);
    }
}
