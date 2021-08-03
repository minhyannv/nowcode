/**
 * @author wmy
 * @date 2021/6/11 16:46
 */

/*
描述
给定一个单链表，请设定一个函数，将链表的奇数位节点和偶数位节点分别放在一起，重排后输出。
注意是节点的编号而非节点的数值。
示例1
输入：
{1,2,3,4,5,6}
复制
返回值：
{1,3,5,2,4,6}
复制
说明：
1->2->3->4->5->6->NULL
重排后为
1->3->5->2->4->6->NULL
示例2
输入：
{1,4,6,3,7}
复制
返回值：
{1,6,7,4,3}
复制
说明：
1->4->6->3->7->NULL
重排后为
1->6->7->4->3->NULL
奇数节点有1,6,7，偶数节点有4,3。重排后为1,6,7,4,3
 */
public class Q_OddEvenList {
//    /**
//     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
//     *
//     * @param head ListNode类
//     * @return ListNode类
//     */
//    public ListNode oddEvenList(ListNode head) {
//        // write code here
//        ListNode temp = head;
//        ListNode odd = null;
//        ListNode oddHead = null;
//        ListNode even = null;
//        ListNode evenHead = null;
//        int i = 1;
//        while (temp != null) {
//            ListNode listNode = temp.next;
//            if (i % 2 == 1) {
//                if (odd == null) {
//                    odd = temp;
//                    oddHead = odd;
//                    odd.next = null;
//                } else {
//                    odd.next = temp;
//                    odd = temp;
//                    odd.next = null;
//                }
//            } else {
//                if (even == null) {
//                    even = temp;
//                    evenHead = even;
//                    even.next = null;
//                } else {
//                    even.next = temp;
//                    even = temp;
//                    even.next = null;
//                }
//            }
//            temp = listNode;
//            i++;
//        }
//        if (odd != null) {
//            odd.next = evenHead;
//            return oddHead;
//        } else {
//            return evenHead;
//        }
//    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode oddEvenList(ListNode head) {
        // write code here
        if (head == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        Q_OddEvenList app = new Q_OddEvenList();
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ListNode ln5 = new ListNode(5);

        ln1.next = ln2;
        ln2.next = ln3;
//        ln3.next = ln4;
//        ln4.next = ln5;

        ListNode res = app.oddEvenList(ln1);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
