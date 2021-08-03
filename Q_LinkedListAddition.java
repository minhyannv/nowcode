import java.util.List;

/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
假设链表中每一个节点的值都在 0 - 9 之间，那么链表整体就可以代表一个整数。
给定两个这种链表，请生成代表两个整数相加值的结果链表。
例如：链表 1 为 9->3->7，链表 2 为 6->3，最后生成新的结果链表为 1->0->0->0。
示例1
输入：
[9,3,7],[6,3]
返回值：
{1,0,0,0}
 */
public class Q_LinkedListAddition {
    /**
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public ListNode addInList(ListNode head1, ListNode head2) {
        // write code here
        head1 = reverse(head1);
        head2 = reverse(head2);
        ListNode res = null;
        ListNode head = null;
        int flag = 0;
        while (head1 != null || head2 != null) {
            int h1Value = head1 == null ? 0 : head1.val;
            int h2Value = head2 == null ? 0 : head2.val;
            if (head1 != null) {
                head1 = head1.next;
            }
            if (head2 != null) {
                head2 = head2.next;
            }
            int sum = h1Value + h2Value + flag;
            flag = sum / 10;
            sum = sum % 10;
            if (res == null) {
                res = new ListNode(sum);
                head = res;
            } else {
                res.next = new ListNode(sum);
                res = res.next;
            }
        }
        if (flag == 1) {
            res.next = new ListNode(flag);
        }
        return reverse(head);
    }

    public ListNode reverse(ListNode head) {
        ListNode temp = head.next;
        head.next = null;
        while (temp != null) {
            ListNode temp2 = temp.next;
            temp.next = head;
            head = temp;
            temp = temp2;
        }
        return head;
    }

    public static void main(String[] args) {
        Q_LinkedListAddition app = new Q_LinkedListAddition();
        ListNode head1 = new ListNode(9);
        ListNode h1_2 = new ListNode(3);
        ListNode h1_2_3 = new ListNode(7);

        head1.next = h1_2;
        h1_2.next = h1_2_3;

        ListNode head2 = new ListNode(6);
        ListNode h2_2 = new ListNode(3);

        head2.next = h2_2;


        int[] prices = {4, 1, 2};
        ListNode res = app.addInList(head1, head2);
        while (res != null) {
            System.out.print(res.val);
            res = res.next;
        }

    }
}
