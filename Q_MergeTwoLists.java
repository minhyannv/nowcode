/**
 * @author wmy
 * @date 2021/6/13 21:45
 */
/*
描述
将两个有序的链表合并为一个新链表，要求新的链表是通过拼接两个链表的节点来生成的，且合并后新链表依然有序。

示例1
输入：
{1},{2}
返回值：
{1,2}
示例2
输入：
{2},{1}
返回值：
{1,2}
 */
public class Q_MergeTwoLists {
    /**
     * @param l1 ListNode类
     * @param l2 ListNode类
     * @return ListNode类
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write code here
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode temp = new ListNode(-1);
        ListNode res = temp;
        while (true) {
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    temp.next = l1;
                    l1 = l1.next;
                } else {
                    temp.next = l2;
                    l2 = l2.next;
                }
                temp = temp.next;
            } else if (l1 != null) {
                temp.next = l1;
                break;
            } else {
                temp.next = l2;
                break;
            }
        }
        return res.next;
    }

    public static void main(String[] args) {
        Q_MergeTwoLists app = new Q_MergeTwoLists();
        ListNode head1 = new ListNode(2);
        ListNode h1_2 = new ListNode(5);
        ListNode h1_2_3 = new ListNode(6);
        head1.next = h1_2;
        h1_2.next = h1_2_3;
        ListNode head2 = new ListNode(3);
        ListNode h2_2 = new ListNode(7);
        head2.next = h2_2;
//        ListNode head1 = new ListNode(1);
//        ListNode head2 = new ListNode(2);
        ListNode res = app.mergeTwoLists(head1, head2);
        while (res != null) {
            System.out.print(res.val);
            res = res.next;
        }

    }
}
