import java.util.List;

/**
 * @author wmy
 * @date 2021/6/11 16:46
 */

/*
描述
给定一个链表，请判断该链表是否为回文结构。
示例1
输入：
[1]
复制
返回值：
true
复制
示例2
输入：
[2,1]
复制
返回值：
false
复制
说明：
2->1
示例3
输入：
[1,2,2,1]
复制
返回值：
true
复制
说明：
1->2->2->1
 */
public class Q_JudgeLinkedListIsPalindrome {
    /**
     * @param head ListNode类 the head
     * @return bool布尔型
     */
    public boolean isPail(ListNode head) {
        // write code here
        if (head == null || head.next == null) {
            return true;
        }
        //step1:寻找中心节点
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //step2:中心节点之后的链表进行翻转
        fast = slow.next;
        slow.next = null;
        ListNode t1 = fast.next;
        fast.next = null;
        while (t1 != null) {
            ListNode t2 = t1.next;
            t1.next = fast;
            fast = t1;
            t1 = t2;
        }
        //step3:判断是否是回文链表
        while (head != null && fast != null) {
            if (head.val != fast.val) {
                return false;
            } else {
                head = head.next;
                fast = fast.next;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Q_JudgeLinkedListIsPalindrome app = new Q_JudgeLinkedListIsPalindrome();
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(2);
        ListNode ln5 = new ListNode(1);

        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;

        boolean res = app.isPail(ln1);
        System.out.println(res);
    }
}
