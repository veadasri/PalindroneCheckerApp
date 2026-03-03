public class PalindroneCheckerApp {
    public static void main(String[] args){
        String input = "racecar";

        PalindromeChecker checker = new PalindromeChecker();

        boolean isPalindrome = checker.checkPalindrome(input);

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
    }
}

// Encapsulated Service Class
class PalindromeChecker {

    // Public method exposed to users
    public boolean checkPalindrome(String input) {

        if (input == null)
            return false;

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
