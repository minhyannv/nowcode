import com.sun.javafx.scene.layout.region.SliceSequenceConverter;

import java.util.List;

/**
 * @author wmy
 * @date 2021/6/11 16:46
 */

/*
描述
输入两个无环的单链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）

示例1
输入：
{1,2,3},{4,5},{6,7}
复制
返回值：
{6,7}
复制
说明：
第一个参数{1,2,3}代表是第一个链表非公共部分，第二个参数{4,5}代表是第二个链表非公共部分，最后的{6,7}表示的是2个链表的公共部分
这3个参数最后在后台会组装成为2个两个无环的单链表，且是有公共节点的
示例2
输入：
{1},{2,3},{}
复制
返回值：
{}
复制
说明：
2个链表没有公共节点 ,返回null，后台打印{}
 */
public class Q_FindFirstCommonNode {
//    /**
//     * 第一种方法：O(n^2)
//     * @param pHead1
//     * @param pHead2
//     * @return
//     */
//    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
//        while (pHead1 != null) {
//            ListNode temp = pHead2;
//            while (temp != null) {
//                if (pHead1 == temp) {
//                    return pHead1;
//                }
//                temp = temp.next;
//            }
//            pHead1 = pHead1.next;
//        }
//        return null;
//    }

    /**
     * 第二种方法：O(n+m)
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode t1 = pHead1;
        ListNode t2 = pHead2;
        while (t1 != t2) {
            t1 = t1.next;
            t2 = t2.next;
            if (t1 != t2) { //为了解决不相交链表的问题
                if (t1 == null) {
                    t1 = pHead2;
                }
                if (t2 == null) {
                    t2 = pHead1;
                }
            }
        }
        return t1;
    }

    public static void main(String[] args) {
        Q_FindFirstCommonNode app = new Q_FindFirstCommonNode();
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ListNode ln5 = new ListNode(5);

        ln1.next = ln2;
        ln2.next = ln3;

        ln4.next = ln5;

        ListNode res = app.FindFirstCommonNode(ln1, ln4);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
