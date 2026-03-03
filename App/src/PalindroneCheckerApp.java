public class PalindroneCheckerApp {

    public static void main(String[] args) {

        String input = "level";

        PalindromeStrategy twoPointer = new TwoPointerStrategy();
        PalindromeStrategy stackStrategy = new StackStrategy();

        // Measure Two Pointer Strategy
        long start1 = System.nanoTime();
        boolean result1 = twoPointer.check(input);
        long end1 = System.nanoTime();
        long duration1 = end1 - start1;

        // Measure Stack Strategy
        long start2 = System.nanoTime();
        boolean result2 = stackStrategy.check(input);
        long end2 = System.nanoTime();
        long duration2 = end2 - start2;

        System.out.println("Input : " + input);
        System.out.println();

        System.out.println("Two Pointer Result : " + result1);
        System.out.println("Two Pointer Time   : " + duration1 + " ns");
        System.out.println();

        System.out.println("Stack Result       : " + result2);
        System.out.println("Stack Time         : " + duration2 + " ns");
    }
}

interface PalindromeStrategy {
    boolean check(String input);
}

// Strategy 1: Two Pointer Approach
class TwoPointerStrategy implements PalindromeStrategy {

    public boolean check(String input) {

        int start = 0;
        int end = input.length() - 1;

        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}

// Strategy 2: Stack Approach
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