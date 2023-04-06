package hard;

public class ReverseNodesinKGroup {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode currentNode = head;
        for (int i = 2; i < 6; i++) {
            currentNode.next = new ListNode(i);
            currentNode = currentNode.next;
        }
        ReverseNodesinKGroup reverseNodesinKGroup = new ReverseNodesinKGroup();
        ListNode end = reverseNodesinKGroup.reverseKGroup(head, 2);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 0) return head;


        ListNode[] nodesTemp = new ListNode[k + 1];
        int nodesCount = 0;
        ListNode firstNode = head;

        while (head != null) {
            if (k == nodesCount) {
                if (nodesTemp[k] == null) {
                    firstNode = nodesTemp[k - 1];
                }
                changeDirection(nodesTemp, head);
                nodesTemp[k] = nodesTemp[0];
                nodesCount = 0;
            }
            nodesTemp[nodesCount] = head;
            nodesCount++;
            head = head.next;
        }
        if(nodesCount == k){
            if (nodesTemp[k] == null) {
                firstNode = nodesTemp[k - 1];
            }
            changeDirection(nodesTemp, head);
        }


        return firstNode;
    }

    private void changeDirection(ListNode[] nodesTemp, ListNode head) {
        for (int i = nodesTemp.length - 2; i > 0; i--) {
            nodesTemp[i].next = nodesTemp[i - 1];
        }

        int lastNodeNumber = nodesTemp.length - 1;
        if (nodesTemp[lastNodeNumber] != null) nodesTemp[lastNodeNumber].next = nodesTemp[lastNodeNumber - 1];
        nodesTemp[0].next = head;
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
