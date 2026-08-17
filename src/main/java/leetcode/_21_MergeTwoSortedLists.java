package leetcode;

public class _21_MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode merged = new ListNode();
        ListNode pointer = merged;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                pointer.next = list1;
                list1 = list1.next;
            } else if (list2.val < list1.val) {
                pointer.next = list2;
                list2 = list2.next;
            }
            pointer = pointer.next;
        }

        if (list1 == null) {
            pointer.next = list2;
        } else {
            pointer.next = list1;
        }

        return merged.next;
    }
}
