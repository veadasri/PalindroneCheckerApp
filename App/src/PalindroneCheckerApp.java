public class PalindroneCheckerApp {
    public static void main(String[] args){
        String input = "refer";

        java.util.Deque<Character> deque = new java.util.ArrayDeque<>();

        // 1. Insert characters into deque
        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        boolean isPalindrome = true;

        // 2 & 3. Remove first & last, compare until empty (or one left)
        while (deque.size() > 1) {

            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
    }
}
