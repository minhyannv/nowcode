/**
 * @author wmy
 * @date 2021/6/11 16:46
 */

/*
描述
给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，返回null。

输入描述：
输入分为2段，第一段是入环前的链表部分，第二段是链表环的部分，后台将这2个会组装成一个有环或者无环单链表
返回值描述：
返回链表的环的入口结点即可。而我们后台程序会打印这个节点
示例1
输入：
{1,2},{3,4,5}
返回值：
3
说明：
返回环形链表入口节点，我们后台会打印该环形链表入口节点，即3    
示例2
输入：
{1},{}
返回值：
"null"
说明：
没有环，返回null，后台打印"null" 
示例3
输入：
{},{2}
返回值：
2
说明：
只有环形链表节点2，返回节点2，后台打印2   
 */
public class Q_EntryNodeOfLoop {

    /**
     * 参考：https://www.huaweicloud.com/articles/8e503547ab756b3f0731cf32030f2f08.html
     *
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (fast.next != null && fast.next.next != null) { //寻找第一次相遇点
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }
        slow = pHead; //slow置为初始点
        while (slow != fast) { //fast和slow每次只走一步，第一次相遇点即为入口点
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Q_EntryNodeOfLoop app = new Q_EntryNodeOfLoop();
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ListNode ln5 = new ListNode(5);
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;
        ln5.next = ln3;
        ListNode res = app.EntryNodeOfLoop(ln1);
        System.out.print(res.val + " ");
    }
}
