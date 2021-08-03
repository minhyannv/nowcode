/**
 * @author wmy
 * @date 2021/6/11 16:46
 */

/*
描述
删除给出链表中的重复元素（链表中元素从小到大有序），使链表中的所有元素都只出现一次
例如：
给出的链表为1\to1\to21→1→2,返回1 \to 21→2.
给出的链表为1\to1\to 2 \to 3 \to 31→1→2→3→3,返回1\to 2 \to 31→2→3.

示例1
输入：
{1,1,2}
复制
返回值：
{1,2}
复制
 */
public class Q_DeleteDuplicates_I {
    /**
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteDuplicates(ListNode head) {
        // write code here
        ListNode t1 = head;
        while (t1 != null) {
            ListNode t2 = t1.next;
            while (t2 != null && t2.val == t1.val) {
                t2 = t2.next;
            }
            t1.next = t2;
            t1 = t2;
        }
        return head;
    }

    public static void main(String[] args) {
        Q_DeleteDuplicates_I app = new Q_DeleteDuplicates_I();
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(1);
        ListNode ln3 = new ListNode(1);
        ListNode ln4 = new ListNode(2);
        ListNode ln5 = new ListNode(2);

        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;
        ListNode res = app.deleteDuplicates(ln1);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
