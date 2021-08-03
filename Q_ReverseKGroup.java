/**
 * @author wmy
 * @date 2021/6/11 16:46
 */

/*
描述
将给出的链表中的节点每\ k k 个一组翻转，返回翻转后的链表
如果链表中的节点数不是\ k k 的倍数，将最后剩下的节点保持原样
你不能更改节点中的值，只能更改节点本身。
要求空间复杂度 \ O(1) O(1)
例如：
给定的链表是1\to2\to3\to4\to51→2→3→4→5
对于 \ k = 2 k=2, 你应该返回 2\to 1\to 4\to 3\to 52→1→4→3→5
对于 \ k = 3 k=3, 你应该返回 3\to2 \to1 \to 4\to 53→2→1→4→5

示例1
输入：
{1,2,3,4,5},2
复制
返回值：
{2,1,4,3,5}
复制
 */
public class Q_ReverseKGroup {
    /**
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // write code here
        int num = 0;
        ListNode t1 = head;
        while (t1.next != null) {
            ListNode start = t1; //开始节点
            num += 1;
            if (num == k) { //结束节点
                ListNode t2 = t1.next;
                //start和end之间进行翻转
                t1 = ReverseList(start, t1);
                t1.next = t2;
                t1 = t1.next;
            }
        }
        return head;
    }

    public ListNode ReverseList(ListNode start, ListNode end) {
        if (start == null || start.next == null) {
            return start;
        }
        ListNode t1 = start.next;
        start.next = null;
        while (t1 != null && t1 != end) {
            ListNode t2 = t1.next;
            t1.next = start;
            start = t1;
            t1 = t2;
        }
        return t1;
    }

    public static void main(String[] args) {
        Q_ReverseKGroup app = new Q_ReverseKGroup();
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ListNode ln5 = new ListNode(5);

        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;
        int k = 2;
        ListNode res = app.reverseKGroup(ln1, k);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
