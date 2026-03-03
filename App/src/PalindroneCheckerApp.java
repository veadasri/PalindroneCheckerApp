public class PalindroneCheckerApp {
    public static void main(String[] args){
        String input = "A man a plan a canal Panama";

        // 1. Normalize string (remove spaces & convert to lowercase)
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        // 2. Apply previous two-pointer logic
        boolean isPalindrome = true;
        int start = 0;
        int end = normalized.length() - 1;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
    }
}
