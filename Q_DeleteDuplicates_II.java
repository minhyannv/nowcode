/**
 * @author wmy
 * @date 2021/6/11 16:46
 */

/*
描述
给出一个升序排序的链表，删除链表中的所有重复出现的元素，只保留原链表中只出现一次的元素。
例如：
给出的链表为1 \to 2\to 3\to 3\to 4\to 4\to51→2→3→3→4→4→5, 返回1\to 2\to51→2→5.
给出的链表为1\to1 \to 1\to 2 \to 31→1→1→2→3, 返回2\to 32→3.

示例1
输入：
{1,2,2}
返回值：
{1}
 */
public class Q_DeleteDuplicates_II {
    /**
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteDuplicates(ListNode head) {
        // write code here
        ListNode newHead = null;
        ListNode newTail = null;
        while (head != null) {
            if (head.next == null || head.val != head.next.val) {
                if (newHead == null) {
                    newHead = head;
                } else {
                    newTail.next = head;
                }
                newTail = head;
                head = head.next;
            } else {
                int val = head.val;
                while (head != null && head.val == val) {
                    head = head.next;
                }
            }
        }
        if (newTail != null) {
            newTail.next = null;
        }
        return newHead;
    }

    public static void main(String[] args) {
        Q_DeleteDuplicates_II app = new Q_DeleteDuplicates_II();
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
