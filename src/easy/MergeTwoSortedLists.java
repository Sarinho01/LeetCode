package easy;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        MergeTwoSortedLists m = new MergeTwoSortedLists();
        m.mergeTwoLists(m.creatNodeList(new int[]{1, 2, 4}), m.creatNodeList(new int[]{1, 3, 4}));
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergedList = new ListNode();

        ListNode currentNode = mergedList;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                currentNode.next = list1;
                list1 = list1.next;
            }
            else {
                currentNode.next = list2;
                list2 = list2.next;
            }
            currentNode = currentNode.next;
        }
        currentNode.next = (list1 == null) ? list2 : list1;

        return mergedList.next;
    }

    private ListNode creatNodeList(int[] array) {
        ListNode nodeList = new ListNode();
        ListNode currentNode = nodeList;
        for (int n : array) {
            nodeList.val = n;
            nodeList.next = new ListNode();
            nodeList = nodeList.next;
        }
        return currentNode;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
