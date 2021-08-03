import com.sun.javafx.scene.layout.region.SliceSequenceConverter;

import java.util.List;

/**
 * @author wmy
 * @date 2021/6/11 16:46
 */

/*
描述
给出一个链表和一个值 ，以 为参照将链表划分成两部分，使所有小于 的节点都位于大于或等于 的节点之前。
两个部分之内的节点之间要保持的原始相对顺序。
例如：
给出 1\to 4 \to 3 \to 2 \to 5 \to 21→4→3→2→5→2 和 \ x = 3 x=3,
返回 1\to 2 \to 2 \to 4 \to 3 \to 51→2→2→4→3→5.
示例1
输入：
{1,4,3,2,5,2},3
复制
返回值：
{1,2,2,4,3,5}
复制
 */
public class Q_PartitionLinkedList {

    /**
     * @param head ListNode类
     * @param x    int整型
     * @return ListNode类
     */
    public ListNode partition(ListNode head, int x) {
        // write code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode min = new ListNode(Integer.MIN_VALUE);
        ListNode minHead = min;
        ListNode max = new ListNode(Integer.MIN_VALUE);
        ListNode maxHead = max;
        while (head != null) {
            ListNode temp = head.next;
            head.next = null;
            if (head.val < x) {
                min.next = head;
                min = head;
            } else {
                max.next = head;
                max = head;
            }
            head = temp;
        }
        min.next = maxHead.next;
        return minHead.next;
    }

    public static void main(String[] args) {
        Q_PartitionLinkedList app = new Q_PartitionLinkedList();
        int x = 3;
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(4);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(2);
        ListNode ln5 = new ListNode(5);
        ListNode ln6 = new ListNode(2);

        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;
        ln5.next = ln6;

        ListNode res = app.partition(ln1, x);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
