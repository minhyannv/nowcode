import java.util.List;

/**
 * @author wmy
 * @date 2021/6/11 16:46
 */

/*
描述
输入一个链表，反转链表后，输出新链表的表头。
示例1
输入：{1,2,3}
返回值：{3,2,1}
 */
public class Q_ReverseList {

    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode t1 = head.next;
        head.next = null;
        while (t1 != null) {
            ListNode t2 = t1.next;
            t1.next = head;
            head = t1;
            t1 = t2;
        }
        return head;
    }

    public static void main(String[] args) {
        Q_ReverseList app = new Q_ReverseList();
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ln1.next = ln2;
        ln2.next = ln3;
        ListNode res = app.ReverseList(ln1);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
