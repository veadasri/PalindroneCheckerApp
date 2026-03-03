public class PalindroneCheckerApp {

    public static void main(String[] args) {

        String input = "level";

        // Inject strategy at runtime
        PalindromeStrategy strategy;

        // You can change strategy dynamically
        strategy = new StackStrategy();
        // strategy = new DequeStrategy();

        boolean isPalindrome = strategy.check(input);

        System.out.println("Input : " + input);
        System.out.println("Strategy Used : " + strategy.getClass().getSimpleName());
        System.out.println("Is Palindrome? : " + isPalindrome);
    }
}

// Strategy Interface
interface PalindromeStrategy {
    boolean check(String input);
}

// Concrete Strategy 1: Stack Based
class StackStrategy implements PalindromeStrategy {

    public boolean check(String input) {

        java.util.Stack<Character> stack = new java.util.Stack<>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

// Concrete Strategy 2: Deque Based
class DequeStrategy implements PalindromeStrategy {

    public boolean check(String input) {

        java.util.Deque<Character> deque = new java.util.ArrayDeque<>();

        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }
}