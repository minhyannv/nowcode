import java.util.List;

/**
 * @author wmy
 * @date 2021/6/11 16:46
 */

/*
描述
输入一个链表，输出一个链表，该输出链表包含原链表中从倒数第k个结点至尾节点的全部节点。
如果该链表长度小于k，请返回一个长度为 0 的链表。
示例1
输入：
{1,2,3,4,5},1
复制
返回值：
{5}

复制
 */
public class Q_FindKthToTail {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param pHead ListNode类
     * @param k     int整型
     * @return ListNode类
     */
    public ListNode FindKthToTail(ListNode pHead, int k) {
        // write code here
        ListNode tail = pHead;
        ListNode pre = pHead;
        int m = 0;
        while (tail != null) {
            if (m < k) {
                m++;
            } else {
                pre = pre.next;
            }
            tail = tail.next;
        }
        if (m < k) {
            return null;
        } else {
            return pre;
        }
    }

    public static void main(String[] args) {
        Q_FindKthToTail app = new Q_FindKthToTail();
        int k = 2;
        ListNode ln1 = new ListNode(3);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(1);
        ln1.next = ln2;
        ln2.next = ln3;
        ListNode res = app.FindKthToTail(ln1, k);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
