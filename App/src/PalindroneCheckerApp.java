public class PalindroneCheckerApp {
    // Node for Singly Linked List
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }
    public static void main(String[] args){
        String input = "level";

        // 1. Convert string to linked list
        Node head = null;
        Node tail = null;

        for (char c : input.toCharArray()) {
            Node newNode = new Node(c);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        boolean isPalindrome = isPalindrome(head);

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
    }

    private static boolean isPalindrome(Node head) {

        if (head == null || head.next == null)
            return true;

        // 2. Find middle using fast & slow pointers
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        Node secondHalf = reverse(slow.next);

        // 3. Compare both halves
        Node firstHalf = head;
        Node temp = secondHalf;

        while (temp != null) {
            if (firstHalf.data != temp.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            temp = temp.next;
        }

        return true;
    }

    // In-place reversal of linked list
    private static Node reverse(Node head) {

        Node prev = null;
        Node current = head;

        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }
}
