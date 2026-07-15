class Solution {
    public int[] plusOne(int[] digits) {
    for (int i = digits.length - 1; i >= 0; i--) {
        if (digits[i] < 9) {
            digits[i]++;
            return digits; // We are done, no carry needed!
        }
        digits[i] = 0; // If it's a 9, it becomes 0 and the loop continues (carry)
    }

    // If we reach here, it means all digits were 9 (e.g., 999 -> 1000)
    int[] result = new int[digits.length + 1];
    result[0] = 1;
    return result;
}
}
